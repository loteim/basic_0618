package com.example.basic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.basic.entity.Hospital;
import com.example.basic.repository.HospitalRepository;

@SpringBootTest
public class HospitalRepositoryTests {
  // @Autowired PasswordEncoder passwordEncoder;
  // @Test void 스프링암호화(){
  //   String pw = passwordEncoder.encode("1");
  //   System.out.println(pw);
  //   pw = passwordEncoder.encode("1");
  //   System.out.println(pw);
  // }
  @Test
  void 암호화() throws NoSuchAlgorithmException {
    String raw = "password1234";
    String rawAndSalt = "abcd1234";
    MessageDigest md = MessageDigest.getInstance("SHA-256");

    md.update(raw.getBytes());
    String hex = String.format("%064x", new BigInteger(1, md.digest()));
    System.out.println("raw의 해시값 : " + hex);
    md.update(rawAndSalt.getBytes());
    hex = String.format("%064x", new BigInteger(1, md.digest()));
    System.out.println("raw+salt의 해시값 : " + hex);

  }

  @Autowired
  HospitalRepository hospitalRepository;

  @Test
  void 조회() {
    List<Hospital> list = hospitalRepository.findBySidoContainingOrNameContaining("서울", "서울");
    System.out.println(list);
  }
}
