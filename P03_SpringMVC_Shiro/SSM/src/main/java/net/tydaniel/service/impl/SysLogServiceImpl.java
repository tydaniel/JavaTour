package net.tydaniel.service.impl;

import net.tydaniel.model.SysLog;
import net.tydaniel.mapper.SysLogMapper;
import net.tydaniel.service.ISysLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author Xiaojun Pan
 * @since 2017-05-10
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
	
}
