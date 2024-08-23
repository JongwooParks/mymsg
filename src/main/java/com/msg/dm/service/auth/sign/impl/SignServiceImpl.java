package com.msg.dm.service.auth.sign.impl;

import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.enumulation.user.RoleType;
import com.msg.dm.domain.enumulation.user.UserStatus;
import com.msg.dm.repository.user.UserRepository;
import com.msg.dm.service.auth.sign.SignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SignServiceImpl implements SignService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;


    @Override
    public boolean existUser(String userId) {
        return !userRepo.findAllByUserId(userId).isEmpty();
    }

    @Override
    public void signUp(StUserDTO user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserStatus(UserStatus.N.name());
        user.setRoleType(RoleType.USER.name());
        userRepo.save(user.build());
    }
}
