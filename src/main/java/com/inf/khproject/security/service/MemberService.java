package com.inf.khproject.security.service;


import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import com.inf.khproject.repository.MemberRepository;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.Random;


@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailsender;

    public Member register(MemberDTO dto) throws Exception {
        dto.setPw(passwordEncoder.encode(dto.getPw()));

        MemberRole role = dto.getRole();
        log.info(dto);
        Member member = repository.findByEmailAndIsSocial(dto.getEmail(), true)
                .map(entity -> entity.dtoToEntity(dto))
                .orElse(dto.dtoToEntity(dto));

        repository.save(member);
        return member;
    }


    public int usernameCheck(String username) throws Exception {
        int existID = repository.usernameCheck(username);
        return existID;
    }


    public int nicknameCheck(String nickname) throws Exception {
        int existNickname = repository.nicknameCheck(nickname);
        return existNickname;
    }


    public String findUsername(String name, String phoneNum)throws Exception{
        String username = repository.findUsernameByNameAndPhoneNum(name, phoneNum);
        return username;
    }



    public void tempPW(String name, String username, String email) throws Exception {
        String tempPw = sendTempPW(email);
        String hashPw = passwordEncoder.encode(tempPw);
        int existAccount = repository.existusernameandname(username,name);
        if(existAccount == 1) {
            repository.updatePW(name, username, hashPw);
        }else{
            throw new Exception("존재하지 않는 계정입니다.");
        }
    }

    @Transactional
    public Member modify(Member member)throws Exception{
        member.setPw(passwordEncoder.encode(member.getPw()));
        Member member1 = repository.findById(member.getId())
                .orElseThrow();
        member1.setPw(member.getPw());
        member1.setNickname(member.getNickname());
        member1.setCompanyNo(member.getCompanyNo());
        member1.setRoadAddress(member.getRoadAddress());
        member1.setDetailAddress(member.getDetailAddress());
        member1.setPhoneNum(member.getPhoneNum());
        return member1;
    }

    private String CODE; // 인증번호

    // 메일 내용 작성
    public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException {
//		System.out.println("보내는 대상 : " + to);
//		System.out.println("인증 번호 : " + ePw);

        MimeMessage message = mailsender.createMimeMessage();

        message.addRecipients(RecipientType.TO, to);// 보내는 대상
        message.setSubject("[당신의 인테리어에 대한 고민을 보다 쉽게! 인테리어 프렌드 인프! 인증 이메일 입니다.]");// 제목

        String msgg = "";
        msgg += "<div style='margin:100px;'>";
        msgg += "<h1> 안녕하세요</h1>";
        msgg += "<h1> 인테리어 프렌드 인프에 회원가입해주셔서 감사합니다.</h1>";
        msgg += "<br>";
        msgg += "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요</p>";
        msgg += "<br>";
        msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE : <strong>";
        msgg += CODE + "</strong><div><br/> "; // 메일에 인증번호 넣기
        msgg += "</div>";
        message.setText(msgg, "utf-8", "html");// 내용, charset 타입, subtype
        // 보내는 사람의 이메일 주소, 보내는 사람 이름
        message.setFrom(new InternetAddress("xogus8206@gmail.com", "INF"));// 보내는 사람

        return message;
    }

    // 랜덤 인증 코드 전송

    public String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤, rnd 값에 따라서 아래 switch 문이 실행됨

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    // a~z (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    // A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }

        return key.toString();
    }

    public String sendSimpleMessage(String to) throws Exception {

        CODE = createKey(); // 랜덤 인증번호 생성

        MimeMessage message = createMessage(to); // 메일 발송
        try {// 예외처리
            mailsender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }


        return CODE; // 메일로 보냈던 인증 코드를 서버로 반환
    }

    public MimeMessage TempPW(String to) throws MessagingException, UnsupportedEncodingException {
//		System.out.println("보내는 대상 : " + to);
//		System.out.println("인증 번호 : " + ePw);

        MimeMessage message = mailsender.createMimeMessage();

        message.addRecipients(RecipientType.TO, to);// 보내는 대상
        message.setSubject("[당신의 인테리어에 대한 고민을 보다 쉽게! 인테리어 프렌드 인프! 임시 비밀번호입니다.]");// 제목

        String msgg = "";
        msgg += "<div style='margin:100px;'>";
        msgg += "<h1> 안녕하세요</h1>";
        msgg += "<h1> 요청하신 임시 비밀번호 입니다</h1>";
        msgg += "<br>";
        msgg += "<p>아래 비밀번호로 로그인 후 비밀번호를 변경 해주세요</p>";
        msgg += "<br>";
        msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE : <strong>";
        msgg += CODE + "</strong><div><br/> "; // 메일에 인증번호 넣기
        msgg += "</div>";
        message.setText(msgg, "utf-8", "html");// 내용, charset 타입, subtype
        // 보내는 사람의 이메일 주소, 보내는 사람 이름
        message.setFrom(new InternetAddress("xogus8206@gmail.com", "INF"));// 보내는 사람

        return message;
    }

    public String sendTempPW(String to) throws Exception {

        CODE = createKey(); // 랜덤 인증번호 생성

        MimeMessage message = TempPW(to); // 메일 발송
        try {// 예외처리
            mailsender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }


        return CODE; // 메일로 보냈던 인증 코드를 서버로 반환
    }



}
