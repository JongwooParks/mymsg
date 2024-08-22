package com.msg.dm.domain.entity.user;

import com.msg.dm.domain.audit.AuditingDate;
import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.enumulation.user.RoleType;
import com.msg.dm.domain.enumulation.user.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ST_USER")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StUser extends AuditingDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    public StUser(String userId, String password, String roleType, String userStatus){
        this.userId = userId;
        this.password = password;
        this.roleType = RoleType.valueOf(roleType);
        this.userStatus = UserStatus.valueOf(userStatus);
    }

    public StUserDTO build(){
        return new StUserDTO(this.id, this.userId, this.password, this.roleType, this.userStatus, this.getCreateDate(), this.getUpdateDate());
    }

}
