package com.breakingbad.workerhub.domain.menurelationship.repository;

import com.breakingbad.workerhub.domain.component.MenuRelationshipId;
import com.breakingbad.workerhub.domain.menurelationship.MenuRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRelationshipRepository extends JpaRepository<MenuRelationship, MenuRelationshipId> {

}
