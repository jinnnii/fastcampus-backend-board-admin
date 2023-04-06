package com.fastcampus.backendboardadmin.dto;

import com.fastcampus.backendboardadmin.domain.UserAccount;
import com.fastcampus.backendboardadmin.domain.constant.RoleType;

import java.time.LocalDateTime;
import java.util.Set;

public record UserAccountDto(
        String userId,
        String userPw,
        Set<RoleType> roleTypes,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdId,
        LocalDateTime modifiedAt,
        String modifiedId
){
    public static UserAccountDto of (
                          String userId,
                          String userPw,
                          Set<RoleType> roleTypes,
                          String email,
                          String nickname,
                          String memo,
                          LocalDateTime createdAt,
                          String createdId,
                          LocalDateTime modifiedAt,
                          String modifiedId) {
        return new UserAccountDto(userId, userPw, roleTypes, email, nickname, memo, createdAt, createdId, modifiedAt, modifiedId);
    }

    public static UserAccountDto of (
            String userId,
            String userPw,
            Set<RoleType> roleTypes,
            String email,
            String nickname,
            String memo) {
        return new UserAccountDto(userId, userPw, roleTypes, email, nickname, memo, null, null, null, null);
    }

    public static UserAccountDto from(UserAccount entity){
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPw(),
                entity.getRoleTypes(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedId(),
                entity.getModifiedAt(),
                entity.getModifiedId()
        );
    }

    public UserAccount toEntity(){
        return UserAccount.of(userId, userPw, roleTypes, email, nickname, memo);
    }
}
