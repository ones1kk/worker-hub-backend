package com.breakingbad.workerhub.common.audting;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class IdAuditingEntity extends DateTimeAuditingEntity {

    @CreatedBy
    @Column(name = "createdBy", updatable = false, nullable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "lastModifiedBy", nullable = false)
    private String lastModifiedBy;

}
