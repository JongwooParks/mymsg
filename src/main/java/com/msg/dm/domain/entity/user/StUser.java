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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="ST_USER")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StUser extends AuditingDate implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(roleType.name()));
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
