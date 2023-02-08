package com.breakingbad.workerhub.domain.rolemenu.repository;

import com.breakingbad.workerhub.domain.component.RoleMenuId;
import com.breakingbad.workerhub.domain.rolemenu.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuRepository extends JpaRepository<RoleMenu, RoleMenuId> {

}
