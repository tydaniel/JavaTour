package net.tydaniel.libsysmybaits.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import net.tydaniel.libsysmybaits.model.User;

public interface UserMapper extends BaseMapper<User> {
	//SQL Query in "UserMapper.xml"
	public List<User> selectAllUsers();
	
	//SQL Query in "UserMapper.xml"
	public User selectUser(@Param("id") int id);
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User selectUserByID(@Param("id") int id);
	
	//SQL Query in "UserMapper.xml"
	public int insertUser(User user);
}
