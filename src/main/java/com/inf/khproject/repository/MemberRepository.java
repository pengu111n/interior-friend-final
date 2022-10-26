package com.inf.khproject.repository;

import com.inf.khproject.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    @Query("select m.username from Member m where m.name = :name and m.phoneNum = :phoneNum")
    String findUsernameByNameAndPhoneNum(@Param("name")String name, @Param("phoneNum")String phoneNum);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.pw = :pw where m.name = :name and m.username = :username")
    int updatePW(@Param("name")String name, @Param("username")String username, @Param("pw")String pw);

    @Query("select count(m) from Member m where m.username = :username and m.name = :name")
    int existusernameandname(@Param("username") String username, @Param("name") String name) throws Exception;

    Optional<Member> findByEmail(@Param("email") String email);

    Optional<Member> findByEmailAndIsSocial(@Param("email")String email, @Param("isSocial")boolean isSocial);

    Optional<Member> findById(@Param("id")Long id);

}
