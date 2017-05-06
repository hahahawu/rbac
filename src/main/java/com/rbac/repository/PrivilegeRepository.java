package com.rbac.repository;

import com.rbac.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hahah on 2017/5/5.
 */
public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity,Long> {
}
