package com.breakingbad.workerhub.domain.rank.repository;

import com.breakingbad.workerhub.domain.rank.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
}
