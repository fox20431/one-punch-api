package com.hihusky.user.repositories;

import com.hihusky.user.po.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    public Optional<User> findOneByUsername(String username);
}
