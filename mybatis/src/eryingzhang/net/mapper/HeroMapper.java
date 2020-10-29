package eryingzhang.net.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import eryingzhang.net.pojo.Hero;
import eryingzhang.net.sqlprovider.HeroSqlProvider;

public interface HeroMapper {

	@Select("select * from hero_")
	public List<Hero> listAll();

	@Select("select * from hero_ where id = #{id}")
	public Hero get(int id);

	@DeleteProvider(type = HeroSqlProvider.class, method = "delete")
	public void delete(int id);

	@InsertProvider(type = HeroSqlProvider.class, method = "add")
	public int add(Map<String, Object> map);

	@Select("select * from hero_  limit #{start},#{count}")
	public List<Hero> listPage(@Param("start") int start, @Param("count") int count);
}
