package com.rbac.repository;

import com.rbac.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by hahah on 2017/5/5.
 */
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("select userEntity from UserEntity userEntity " +
            ", User2RoleEntity user2role " +
            "where userEntity.userid=?1 and user2role.urroleEntity.rolename=?2 and userEntity.userid=user2role.uruserEntity.userid")
    UserEntity findUserEntityByUserid(Integer userid , String role);

    UserEntity findUserEntityByUserid(Integer id);

    UserEntity findUserEntityByUsername(String name);

}
