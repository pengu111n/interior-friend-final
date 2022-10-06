package com.inf.khproject.repository;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select count(m) from Member m where m.id = :id")
    int idCheck(@Param("id") String id) throws Exception;

    @Query("select count(m) from Member m where m.nickname = :nickname")
    int nicknameCheck(@Param("nickname") String nickname) throws Exception;

    @EntityGraph(attributePaths = {"roleset"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.isSocial = :social and m.id = :id")
    Optional<Member> findById(String id, boolean social);

    Member findById(String id);
}
