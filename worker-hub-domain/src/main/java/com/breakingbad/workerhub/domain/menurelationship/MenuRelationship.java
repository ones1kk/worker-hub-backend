package com.breakingbad.workerhub.domain.menurelationship;

import com.breakingbad.workerhub.domain.component.MenuRelationshipId;
import com.breakingbad.workerhub.domain.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "menu_relationship")
@Entity
public class MenuRelationship {

    @EmbeddedId
    private MenuRelationshipId menuRelationshipId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column(name = "base_menu_level")
    private Integer baseLevel;

    @Column(name = "opp_menu_level")
    private Integer opponentLevel;

    @Column(name = "base_sort_no")
    private Integer baseSortNumber;

    @Column(name = "opp_sort_no")
    private Integer opponentSortNumber;

}
