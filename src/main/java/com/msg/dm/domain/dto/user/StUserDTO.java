package com.msg.dm.domain.dto.user;

import com.msg.dm.domain.entity.user.StUser;
import com.msg.dm.domain.enumulation.user.RoleType;
import com.msg.dm.domain.enumulation.user.UserStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StUserDTO {
    private Long id;

    private String userId;
    private String password;

    private String roleType;

    private String userStatus;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public StUserDTO(Long id, String userId, String password, RoleType roleType, UserStatus userStatus, LocalDateTime createDate, LocalDateTime updateDate){
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.roleType = roleType.name();
        this.userStatus = userStatus.name();
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public StUser build(){
        return new StUser(userId,password,roleType,userStatus);
    }
}
