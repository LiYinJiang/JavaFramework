package eryingzhang.net.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import eryingzhang.net.pojo.Hero;

public interface NameOfHeroMapper {
	
	
	@Select("select * from name_of_hero_ where tmid = #{tmid}")
	@Results({
		@Result(property="tmid", column="tmid"),
		
	})
	public List<Hero> getHeroByTmId(int tmId);
}
