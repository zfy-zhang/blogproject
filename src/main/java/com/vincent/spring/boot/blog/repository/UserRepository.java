package com.vincent.spring.boot.blog.repository;

import com.vincent.spring.boot.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * User Repository 接口
 *
 * Created by vincent
 * on 2018/5/18 上午9:34
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 创建或者修改用户
     * @Param user
     * @return
     *
     */
//    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @Param user
     *
     */
//     void deleteUser(Long id);


    /**
     * 根据用户id查询用户
     * @Param user
     * @return
     *
     */
//     User getUserById(Long id);
    @Query("from User where id =:id ")
    User findOne(@Param("id") Long id);


    /**
     * 获取用户列表
     * @return
     *
     */
//     List<User> listUser();


}
