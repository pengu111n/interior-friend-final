package com.inf.khproject.repository;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select count(m) from Member m where m.id = :id")
    int idCheck(@Param("id") String id) throws Exception;

    @Query("select count(m) from Member m where m.nickname = :nickname")
    int nicknameCheck(@Param("nickname") String nickname) throws Exception;
}
