package com.example.zepzep.repository;

import com.example.zepzep.domain.User;
import com.infobip.spring.data.ExtendedQueryDslJpaRepository;

public interface UserRepository extends ExtendedQueryDslJpaRepository<User,Long> {
}
