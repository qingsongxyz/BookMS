package com.hubu.controller;

import com.hubu.encode.EncodeHelper;
import com.hubu.pojo.User;
import com.hubu.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private HttpSession session;

    @PostMapping("/login")
    public User login(String username, String password) {
        String encodePassword = EncodeHelper.encode(password);
        return userService.login(username, encodePassword);
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String realName = file.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("/images");
        File dest = new File(realPath + "\\" + realName);
        file.transferTo(dest);
        return "上传图片" + realName + "成功!";
    }

    @PostMapping("/register")
    public String register(User user) {
        User userByUsername = userService.findUserByUsername(user.getUsername());
        if (userByUsername != null) {
            return "用户名已存在!";
        } else {
            //加密
            String str = user.getPassword();
            user.setPassword(EncodeHelper.encode(str));
            int newUser = userService.register(user);
            return "";
        }
    }


    @PostMapping("/updatePassword")
    public String updatePassword(String username, String oldPassword, String newPassword) {
        String encodeOldPassword = EncodeHelper.encode(oldPassword);
        User user = userService.login(username, encodeOldPassword);
        if (user == null) {
            return "用户名或密码错误!!!";
        } else {
            String encodeNewPassword = EncodeHelper.encode(newPassword);
            int newUser = userService.updatePassword(username, encodeNewPassword);
            return "";
        }
    }

    @PostMapping("/getUserInfo")
    public User getUserInfo(String username){
        return userService.getUserInfo(username);
    }

    @PostMapping("/updatePersonalInfo")
    public String updatePersonalInfo(@RequestBody User user){
        int i = userService.updatePersonalInfo(user);
        return "个人信息修改成功!";
    }

    @PostMapping("/getUserByUsernameAndPhone")
    public User getUserByUsernameAndPhone(String username, String phone){
        return userService.getUserByUsernameAndPhone(username, phone);
    }

    @PostMapping("/resetPassword")
    public int resetPassword(User user){
        String encodePassword = EncodeHelper.encode("123456");
        user.setPassword(encodePassword);
        return userService.resetPassword(user);
    }
}
