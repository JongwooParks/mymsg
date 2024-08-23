package com.msg.dm.service.auth.login.impl;

import com.msg.dm.configuration.security.jwt.JwtTokenProvider;
import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.entity.user.StUser;
import com.msg.dm.repository.user.UserRepository;
import com.msg.dm.service.auth.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    @Override
    public String doLogin(StUserDTO user, PasswordEncoder encoder, JwtTokenProvider jwtTokenProvider) {

        StUser loginUser = userRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));

        if(!encoder.matches(user.getPassword(),loginUser.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return jwtTokenProvider.createToken(loginUser.getUserId(),loginUser.getRoleType().name());
    }
}
