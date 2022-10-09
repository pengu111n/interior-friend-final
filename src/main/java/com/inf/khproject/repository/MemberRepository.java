package com.inf.khproject.repository;

import com.inf.khproject.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("select count(m) from Member m where m.username = :username")
    int usernameCheck(@Param("username") String username) throws Exception;

    @Query("select count(m) from Member m where m.nickname = :nickname")
    int nicknameCheck(@Param("nickname") String nickname) throws Exception;


    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.isSocial = :isSocial and m.username = :username")
    Optional<Member> findByUsername(@Param("username") String username, @Param("isSocial") boolean isSocial);

    Optional<Member> findByUsername(@Param("username") String username);
}
