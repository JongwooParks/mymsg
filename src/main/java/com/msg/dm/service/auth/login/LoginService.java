package com.msg.dm.service.auth.login;

import com.msg.dm.configuration.security.jwt.JwtTokenProvider;
import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.entity.user.StUser;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface LoginService {

    public String doLogin(StUserDTO user, PasswordEncoder encoder, JwtTokenProvider jwtTokenProvider);
}
