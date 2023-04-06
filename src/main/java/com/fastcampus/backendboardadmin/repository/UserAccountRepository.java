package com.fastcampus.backendboardadmin.repository;

import com.fastcampus.backendboardadmin.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
