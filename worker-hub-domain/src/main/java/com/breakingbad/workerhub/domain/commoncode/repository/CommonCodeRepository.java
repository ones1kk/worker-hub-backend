package com.breakingbad.workerhub.domain.commoncode.repository;

import com.breakingbad.workerhub.common.component.GroupCodeId;
import com.breakingbad.workerhub.domain.commoncode.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCode, GroupCodeId> {
}
