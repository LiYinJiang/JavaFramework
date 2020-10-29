package eryingzhang.net.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import eryingzhang.net.pojo.User;

public interface UserMapper {

	@Select("select * from user_ limit #{start}, #{count}")
	public List<User> listPage(@Param("start") int start, @Param("count") int count);
}
