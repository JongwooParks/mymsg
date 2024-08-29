package com.msg.dm.util.auth;

import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.entity.user.StUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserUtils {

    public StUserDTO getUser(StUser user){
        return user == null ? new StUserDTO() : user.build();
    }
}
