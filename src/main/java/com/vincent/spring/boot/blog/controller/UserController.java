package com.vincent.spring.boot.blog.controller;

import com.vincent.spring.boot.blog.domain.User;
import com.vincent.spring.boot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by vincent
 * on 2018/5/18 上午9:58
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 从 用户存储库 获取用户列表
     * @return
     */
    private List<User> getUserlist() {
        return (List<User>) userRepository.findAll();
    }

    /**
     *
     * 查询所有用户
     * @param model
     * @return
     *
     */
    @GetMapping
    public ModelAndView list(Model model) {

        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");

       return new ModelAndView("users/list", "userModel",model);
    }

    /**
     *
     * 根据id查询用户
     * @param model
     * @return
     *
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {

        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");

        return new ModelAndView("users/view", "userModel",model);
    }

    /**
     *
     * 获取创建表单页面
     * @param model
     * @return
     *
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");

        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 新建用户
     * @param user
     * @param result
     * @param redirect
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteById(id);

        model.addAttribute("userList", getUserlist());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {

        User user = userRepository.findOne(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
    
}
