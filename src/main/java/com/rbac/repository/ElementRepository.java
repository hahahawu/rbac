package com.rbac.repository;

import com.rbac.entity.ElementsinpageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hahah on 2017/5/8.
 */
public interface ElementRepository extends JpaRepository<ElementsinpageEntity, Long> {

    @Query("select elementEntity from Privilege2ElementEntity privilegeElementEntity,ElementsinpageEntity elementEntity " +
            "where privilegeElementEntity.peelementsinpageEntity.elementid=elementEntity.elementid " +
            "and privilegeElementEntity.peprivilegeEntity.privilegeid=?1")
    List<ElementsinpageEntity> findElementsinpageEntitiesByPrivilegeid(Integer id);
}
