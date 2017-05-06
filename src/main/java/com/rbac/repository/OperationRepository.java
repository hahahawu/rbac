package com.rbac.repository;

import com.rbac.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hahah on 2017/5/5.
 */
public interface OperationRepository extends JpaRepository<OperationEntity,Long> {
}
