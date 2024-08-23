package com.msg.dm.repository.user;

import com.msg.dm.domain.entity.user.StUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<StUser,Long> {

    public List<StUser> findAllByUserId(String userId);

    public Optional<StUser> findByUserId(String userId);
}
