package net.tydaniel.service.impl;

import net.tydaniel.model.User;
import net.tydaniel.mapper.UserMapper;
import net.tydaniel.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
