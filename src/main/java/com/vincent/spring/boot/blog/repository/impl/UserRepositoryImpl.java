package com.vincent.spring.boot.blog.repository.impl;

import com.vincent.spring.boot.blog.domain.User;
import com.vincent.spring.boot.blog.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vincent
 * on 2018/5/18 上午9:42
 */
@Repository
public class UserRepositoryImpl {

    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, User> userConcurrentHashMap = new ConcurrentHashMap<>();

    /*@Override
    public User saveOrUpdateUser(User user) {

        Long id = user.getId();
        // 新建
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userConcurrentHashMap.put(id, user);

        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userConcurrentHashMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userConcurrentHashMap.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<User>(this.userConcurrentHashMap.values());
    }*/
}
