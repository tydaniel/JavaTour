package net.tydaniel.service.impl;

import net.tydaniel.model.UserRole;
import net.tydaniel.mapper.UserRoleMapper;
import net.tydaniel.service.IUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
	
}
