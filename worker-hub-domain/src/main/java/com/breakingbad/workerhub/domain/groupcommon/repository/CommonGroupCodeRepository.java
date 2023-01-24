package com.breakingbad.workerhub.domain.groupcommon.repository;

import com.breakingbad.workerhub.domain.groupcommon.CommonGroupCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonGroupCodeRepository extends JpaRepository<CommonGroupCode, String> {
}
