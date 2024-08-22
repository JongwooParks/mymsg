package com.msg.dm;

import com.msg.dm.domain.enumulation.user.RoleType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DmApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(RoleType.USER.name());
    }

}
