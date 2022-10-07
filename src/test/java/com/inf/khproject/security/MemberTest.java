package com.inf.khproject.security;

import com.inf.khproject.entity.Member;
import com.inf.khproject.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTest {

   @Autowired
    private MemberRepository repository;

   @Autowired
    private PasswordEncoder passwordEncoder;

   @Test
    public void insertDummies(){
       IntStream.rangeClosed(1,100).forEach(i -> {
           Member member = Member.builder()
                   .email("user" + i + "@zerock.org")
                   .build();
       });
   }

   @Test
    public void testRead() {
       Optional<Member> result = repository.findByUsername("qwe", false);

       Member member = result.get();
       System.out.println(member);
   }
}
