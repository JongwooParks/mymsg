package com.msg.dm.repository.user;

import com.msg.dm.domain.entity.user.StUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<StUser,Long> {

    public List<StUser> findByUserId(String userId);
}
