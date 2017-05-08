package com.rbac.repository;

import com.rbac.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hahah on 2017/5/5.
 */
public interface OperationRepository extends JpaRepository<OperationEntity,Long> {

    @Query("select operationEntity from Privilege2OpEntity privilege2opEntity,OperationEntity operationEntity " +
            "where privilege2opEntity.pooperationEntity.operationid=operationEntity.operationid " +
            "and privilege2opEntity.poprivilegeEntity.privilegeid=?1")
    List<OperationEntity> findOperationEntitiesByPrivilegeid(Integer id);
}
