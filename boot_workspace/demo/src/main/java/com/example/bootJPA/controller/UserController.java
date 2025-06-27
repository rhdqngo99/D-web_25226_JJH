package com.example.bootJPA.controller;

import com.example.bootJPA.dto.UserDTO;
import com.example.bootJPA.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
@Controller
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/join")
    public void join(){}

    @PostMapping("/join")
    public String join(UserDTO userDTO){
        log.info(">>>>> userDTO >> {}", userDTO);
        // password 암호화
        userDTO.setPwd(passwordEncoder.encode(userDTO.getPwd()));
        String email = userService.register(userDTO);
        return (email != null) ? "/index" : "/user/join";
    }

//    @GetMapping("/login")
//    public void login(){ }

    @GetMapping("/login")
    public String login( HttpServletRequest request,
//            @RequestParam(value = "email", required = false) String email,
//            @RequestParam(value = "errmsg", required = false) String errmsg,
                         Model model){

        String email =(String)request.getSession().getAttribute("email");
        String errmsg =(String)request.getSession().getAttribute("errmsg");
        if(errmsg != null){
            log.info(">>>> controller errmsg >> {}", errmsg);
            model.addAttribute("email", email);
            model.addAttribute("errmsg", errmsg);
        }

        request.getSession().removeAttribute("email");
        request.getSession().removeAttribute("errmsg");

        return "/user/login";
    }

//    @PostMapping("/login")
//    public String login(HttpServletRequest request, RedirectAttributes re) {
//        // 실제 로그인시에는 Security의 filter에서 가져감.
//        // 로그인 실패시 다시 로그인 페이지로 돌아와 오류 메시지를 전송
//        log.info(">>>> email >> {}", request.getAttribute("email").toString());
//        log.info(">>>> errorMessage >> {}", request.getAttribute("errmsg"));
//        re.addFlashAttribute("email", request.getAttribute("email"));
//        re.addFlashAttribute("errmsg", request.getAttribute("errmsg"));
//
//        return "redirect:/user/login";
//    }

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("userList",
                userService.getList());
    }

    @GetMapping("/modify")
    public void modify(Model model, Principal principal){
        model.addAttribute("userDTO",
                userService.selectEmail(principal.getName()));
    }

    @PostMapping("/modify")
    public String modify(UserDTO userDTO,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         RedirectAttributes redirectAttributes){
        if(!userDTO.getPwd().isEmpty()){
            userDTO.setPwd(passwordEncoder.encode(userDTO.getPwd()));
        }
        String email = userService.modify(userDTO);
        if(email != null){
            redirectAttributes.addFlashAttribute("modMsg", "ok");
        }else{
            redirectAttributes.addFlashAttribute("modMsg", "fail");
        }
        logout(request, response);

        return "redirect:/";

    }

    @GetMapping("/remove")
    public String remove(Principal principal,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         RedirectAttributes redirectAttributes){
        String email = userService.remove(principal.getName());
        if(email != null){
            redirectAttributes.addFlashAttribute("delMsg", "ok");
        }else{
            redirectAttributes.addFlashAttribute("delMsg", "fail");
        }
        logout(request, response);
        return "redirect:/";
    }

    private void logout(HttpServletRequest request,
                        HttpServletResponse response){
        Authentication auth = SecurityContextHolder
                .getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

}