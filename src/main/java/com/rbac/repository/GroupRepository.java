package com.rbac.repository;

import com.rbac.entity.UsergroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hahah on 2017/5/5.
 */
public interface GroupRepository extends JpaRepository<UsergroupEntity,Long> {
    UsergroupEntity findUsergroupEntityByUsergroupname(String name);
}
