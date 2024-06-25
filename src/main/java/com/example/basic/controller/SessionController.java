package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.entity.Board;
import com.example.basic.entity.User;
import com.example.basic.model.BoardModel;
import com.example.basic.model.UserModel;
import com.example.basic.repository.BoradRepository;
import com.example.basic.repository.UserRepository;
import com.example.basic.utill.EncryptUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoradRepository boradRepository;
    @Autowired
    EncryptUtil encryptUtil;

    @GetMapping("/borad")
    public String board() {
        return "board";
    }

    @PostMapping("/board")
    public String boardPost(BoardModel boardModel) {
        Board board = new Board();
        board.setTitle((boardModel.getTitle()));
        boradRepository.save(board);
        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String joinPost(UserModel user) {
        User u = new User();
        u.setUserId(user.getUserId());
        String encodedPw = encryptUtil.encode(user.getUserPw());
        u.setUserPw(encodedPw);
        userRepository.save(u);
        return "redirect:/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> loginPost(
        @RequestBody UserModel user, HttpSession session) {
        
        Map<String, Object> map = new HashMap<>();
        String encodedPw = encryptUtil.encode(user.getUserPw());
        com.example.basic.entity.User dbUser = userRepository.findByUserIdAndUserPw(
                user.getUserId(), encodedPw);
        
        if (dbUser == null) {
            map.put("msg", "ID 또는 PW를 확인해주세요.");
            return map;
        }
        session.setAttribute("user", user);
        map.put("msg", "로그인되었습니다.");
        return map;
        // 작업 처리후 해당 위치로 이동
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        session.removeAttribute("user");
        return "redirect:/login";
    }

    @GetMapping("/main")
    public String main(HttpSession session) {
        UserModel u = (UserModel) session.getAttribute("user");
        if (u == null) {
            return "redirect:/login";
        }
        String id = u.getUserId();
        String pw = u.getUserPw();
        System.out.println(id + ", " + pw);
        return "main";
    }

}
