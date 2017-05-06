package com.rbac.repository;

import com.rbac.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hahah on 2017/5/5.
 */
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}
