package com.fastcampus.backendboardadmin.repository;

import com.fastcampus.backendboardadmin.domain.UserAccount;
import com.fastcampus.backendboardadmin.domain.constant.RoleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@Import(JpaRepositoryTest.TestJpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final UserAccountRepository userAccountRepository;

    public JpaRepositoryTest(@Autowired UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @DisplayName("회원정보 조회 테스트")
    @Test
    void givenUserAccounts_whenSelecting_thenWorksFine() {
        //given

        //when
        List<UserAccount> userAccounts = userAccountRepository.findAll();

        //then
        assertThat(userAccounts)
                .isNotNull()
                .hasSize(4);
    }

    @DisplayName("회원정보 생성 테스트")
    @Test
    void givenUserAccount_whenInserting_thenWorksFine() {
        //given
        long previousCount = userAccountRepository.count();
        UserAccount userAccount = UserAccount.of("test", "{noop}1234", Set.of(RoleType.DEVELOPER), "test@email.com", "test", "this is memo", "user1");
        //when
        userAccountRepository.save(userAccount);

        //then
        assertThat(userAccountRepository.count())
                .isEqualTo(previousCount+1);
    }

    @DisplayName("회원정보 수정 테스트")
    @Test
    void givenUserAccount_whenUpdating_thenWorksFine() {
        //given
        UserAccount userAccount = userAccountRepository.getReferenceById("user1");
        userAccount.addRoleType(RoleType.DEVELOPER);
        userAccount.addRoleTypes(List.of(RoleType.USER, RoleType.USER));
        userAccount.removeRoleType(RoleType.ADMIN);

        //when
        UserAccount updatedUserAccount = userAccountRepository.saveAndFlush(userAccount);

        //then
        assertThat(updatedUserAccount)
                .hasFieldOrPropertyWithValue("userId", "user1")
                .hasFieldOrPropertyWithValue("roleTypes", Set.of(RoleType.DEVELOPER, RoleType.USER));
    }

    @DisplayName("회원정보 삭제 테스트")
    @Test
    void givenUserAccount_whenDeleting_thenWorksFine() {
        //given
        long previousCount = userAccountRepository.count();
        UserAccount userAccount = userAccountRepository.getReferenceById("user1");

        //when
        userAccountRepository.delete(userAccount);

        //then
        assertThat(userAccountRepository.count())
                .isEqualTo(previousCount-1);
    }

    @EnableJpaAuditing
    @TestConfiguration
    public static class TestJpaConfig{
        @Bean
        public AuditorAware<String> auditorAware(){
            return ()-> Optional.of("kej");
        }
    }
}