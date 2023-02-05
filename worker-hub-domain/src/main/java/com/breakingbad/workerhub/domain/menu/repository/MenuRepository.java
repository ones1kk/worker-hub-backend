package com.breakingbad.workerhub.domain.menu.repository;

import com.breakingbad.workerhub.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
