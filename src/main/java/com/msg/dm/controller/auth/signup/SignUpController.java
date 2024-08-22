package com.msg.dm.controller.auth.signup;

import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.service.auth.sign.SignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
@Slf4j
public class SignUpController {
    private final SignService signService;


    @PostMapping("/validUserId")
    public ResponseEntity<?> existUser(@RequestBody StUserDTO user){
        log.info(user.getUserId());
        return ResponseEntity.ok(signService.existUser(user.getUserId()));
    }

    @RequestMapping("/up")
    public ResponseEntity<?> signup(@RequestBody StUserDTO user){
      try{
          signService.signUp(user);
          return ResponseEntity.ok(true);
      }catch (Exception e){
          e.printStackTrace();
          return ResponseEntity.badRequest().body(false);
      }
    }
}
