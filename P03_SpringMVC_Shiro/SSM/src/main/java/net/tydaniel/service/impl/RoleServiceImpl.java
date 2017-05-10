package net.tydaniel.service.impl;

import net.tydaniel.model.Role;
import net.tydaniel.mapper.RoleMapper;
import net.tydaniel.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
