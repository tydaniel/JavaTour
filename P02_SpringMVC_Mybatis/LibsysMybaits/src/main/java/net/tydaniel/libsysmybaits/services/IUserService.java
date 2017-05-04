package net.tydaniel.libsysmybaits.services;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import net.tydaniel.libsysmybaits.model.User;

public interface IUserService extends IService<User> {
    List<User> selectAllUsers();

    void insertByObj(User user);

    User selectUserById(Long id);

    void updateByObj(User user);

    void updatePwdByUserId(Long userId, String md5Hex);  

    void deleteUserById(Long id);
}
