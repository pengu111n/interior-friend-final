package com.inf.khproject.repository;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import com.inf.khproject.entity.Memo;
import com.inf.khproject.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@RequiredArgsConstructor
@Log4j2
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Autowired
    MemberRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender mailsender;

    @Autowired
    MemberService service;



    @Test
    public void testRegister() throws Exception {
        MemberDTO dto = new MemberDTO();
        dto.setPw(passwordEncoder.encode(dto.getPw()));
        MemberRole role = dto.getRole();
        log.info(dto);
        String auth = service.sendSimpleMessage(dto.getEmail());
        dto.setEmail(auth);
        log.info(dto);
        Member member = dto.dtoToEntity(dto);
        repository.save(member);
    }

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });

    }

    @Test
    public void testSelect() {

        //데이터베이스에 존재하는 mno
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("======================================");

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }

    }

    @Test
    public void testUpdate() {

        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();

        System.out.println(memoRepository.save(memo));

    }

    @Test
    public void testDelete() {

        long mno = 100L;

        memoRepository.deleteById(mno);

    }

    @Test
    public void testPageDefault() {

        //1페이지 10개
        Pageable pageable = PageRequest.of(0, 10);

        Page<Memo> result = memoRepository.findAll(pageable);

        System.out.println(result);

        System.out.println("----------------------------------------");

        System.out.println("Total Pages: " + result.getTotalPages()); //총 몇 페이지

        System.out.println("Total Count: " + result.getTotalElements()); //전체 개수

        System.out.println("Page Number: " + result.getNumber()); //현재 페이지 번호 0부터 시작

        System.out.println("Page Size: " + result.getSize()); //페이지당 데이터 개수

        System.out.println("has next page?: " + result.hasNext()); //다음 페이지 존재 여부

        System.out.println("first page?: " + result.isFirst()); //시작 페이지(0) 여부

        System.out.println("----------------------------------------");

        for (Memo memo : result.getContent()) {
            System.out.println(memo);
        }

    }

    @Test
    public void testSort() {

        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").ascending();
        Sort sortAll = sort1.and(sort2); //and를 이용한 연결

        PageRequest pageable = PageRequest.of(0, 10, sortAll); //결합된 정렬 조건 사용

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });

    }

    @Test
    public void testQueryMethods() {

        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);

        for (Memo memo : list) {
            System.out.println(memo);
        }

    }

    @Test
    public void testQueryMethodWithPageable() {

        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });

    }

    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethods() {
        memoRepository.deleteMemoByMnoLessThan(10L);
    }

}
