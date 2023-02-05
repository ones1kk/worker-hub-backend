package com.breakingbad.workerhub.domain.component;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Embeddable
public class MenuRelationshipId implements Serializable {

    @JoinColumn(name = "menu_id")
    private Long baseMenuId;

    @JoinColumn(name = "menu_id")
    private Long opponentMenuId;

}
