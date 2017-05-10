package net.tydaniel.service.impl;

import net.tydaniel.model.Organization;
import net.tydaniel.mapper.OrganizationMapper;
import net.tydaniel.service.IOrganizationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {
	
}
