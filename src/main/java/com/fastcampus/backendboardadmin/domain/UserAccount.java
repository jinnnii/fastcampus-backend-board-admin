package com.fastcampus.backendboardadmin.domain;

import com.fastcampus.backendboardadmin.domain.constant.RoleType;
import com.fastcampus.backendboardadmin.domain.converter.RoleTypesConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdId"),
        @Index(columnList = "createdAt")
})
@Entity
public class UserAccount extends AuditingField {
    @Id
    @Column(length = 50)
    private String userId;
    @Setter @Column(nullable = false)   private String userPw;

    @Convert(converter = RoleTypesConverter.class)
    @Column(nullable = false)  private
    Set<RoleType> roleTypes = new LinkedHashSet<>();

    @Setter @Column(length = 100)       private String email;
    @Setter @Column(length = 100)       private String nickname;
    @Setter                             private String memo;


    protected UserAccount(){}

    private UserAccount(String userId, String userPw, Set<RoleType> roleTypes, String email, String nickname, String memo, String createdId) {
        this.userId = userId;
        this.userPw = userPw;
        this.roleTypes = roleTypes;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdId = createdId;
    }


    public static UserAccount of(String userId, String userPw, Set<RoleType> roleTypes, String email, String nickname, String memo){
        return UserAccount.of(userId, userPw, roleTypes, email, nickname, memo, null);
    }

    private static UserAccount of(String userId, String userPw, Set<RoleType> roleTypes, String email, String nickname, String memo, String createdId) {
        return new UserAccount(userId,userPw,roleTypes,email,nickname,memo,createdId);
    }

    public void addRoleType(RoleType roleType){
        this.getRoleTypes().add(roleType);
    }

    public void addRoleTypes(Collection<RoleType> roleTypes){
        this.getRoleTypes().addAll(roleTypes);
    }

    public void removeRoleType(RoleType roleType){
        this.getRoleTypes().remove(roleType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return this.getUserId()!=null && this.getUserId().equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }
}
