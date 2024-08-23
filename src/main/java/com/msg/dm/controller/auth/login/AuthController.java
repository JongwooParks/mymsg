package com.msg.dm.controller.auth.login;

import com.msg.dm.configuration.security.jwt.JwtTokenProvider;
import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.entity.user.StUser;
import com.msg.dm.service.auth.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody StUserDTO user){
        try{
            String token = loginService.doLogin(user,passwordEncoder,jwtTokenProvider);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/loginCheck")
    public ResponseEntity<?> loginCheck(@AuthenticationPrincipal StUser userDetails){


        if(userDetails != null){
            log.info(userDetails.build().toString());
            return ResponseEntity.ok(userDetails);
        }else{
            log.info("user is null");
        }



        return ResponseEntity.badRequest().body(false);
    }
}
