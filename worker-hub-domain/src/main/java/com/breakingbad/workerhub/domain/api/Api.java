package com.breakingbad.workerhub.domain.api;

import com.breakingbad.workerhub.constant.HttpMethod;
import com.breakingbad.workerhub.domain.audting.IdAuditingEntity;
import com.breakingbad.workerhub.domain.constant.APiClassifyCode;
import com.breakingbad.workerhub.domain.constant.SiteCode;
import com.breakingbad.workerhub.domain.constant.YesOrNo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "api")
@Entity
public class Api extends IdAuditingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "api_id")
    private Long id;

    @Column(name = "api_name")
    private String name;

    @Column(name = "api_description", columnDefinition = "text")
    private String description;

    @Column(name = "site_code", nullable = false)
    @Enumerated(value = STRING)
    private SiteCode siteCode;

    @Column(name = "api_classify_cde")
    @Enumerated(value = STRING)
    private APiClassifyCode aPiClassifyCode;

    @Column(name = "http_method")
    @Enumerated(value = STRING)
    private HttpMethod httpMethod;

    @Column(name = "api_url")
    private String url;

    @Column(name = "api_free_yn")
    @Enumerated(value = STRING)
    private YesOrNo apiFreeYn;

    @Column(name = "api_use_yn")
    @Enumerated(value = STRING)
    private YesOrNo useYn;

    @Column(name = "api_delete_yn")
    @Enumerated(value = STRING)
    private YesOrNo deleteYn;

    @Column(name = "multipart_yn")
    @Enumerated(value = STRING)
    private YesOrNo multipartYn;

}
