package com.rbac.repository;

import com.rbac.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hahah on 2017/5/5.
 */
public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity,Long> {

    @Query("select privilegeEntity from PrivilegeEntity privilegeEntity," +
            "Role2PrivilegeEntity role2PrivilegeEntity " +
            "where role2PrivilegeEntity.rproleEntity.rolename=?1 " +
            "and role2PrivilegeEntity.rpprivilegeEntity.privilegeid=privilegeEntity.privilegeid")
    List<PrivilegeEntity> findPrivilegeEntitiesByRolename(String name);
}
