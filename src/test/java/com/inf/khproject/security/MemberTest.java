package com.inf.khproject.security;

import com.inf.khproject.entity.Member;
import com.inf.khproject.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
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
