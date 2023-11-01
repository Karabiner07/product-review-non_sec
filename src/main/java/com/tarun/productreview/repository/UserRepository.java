package com.tarun.productreview.repository;

import com.tarun.productreview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUserId(Long userId);

    public User findUserByUserName(String userName);
    public boolean existsUserByUserName(String userName);

    public boolean existsUserByUserId(Long userId);
    public boolean existsUserByUserPass(String userPass);
}