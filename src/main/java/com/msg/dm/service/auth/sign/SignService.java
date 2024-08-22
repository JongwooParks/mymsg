package com.msg.dm.service.auth.sign;

import com.msg.dm.domain.dto.user.StUserDTO;

public interface SignService {

    public boolean existUser(String userId);

    public void signUp(StUserDTO user);
}
