package eryingzhang.net.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import eryingzhang.net.pojo.Team;

public interface TeamMapper {

	@Select("Select * from team_")

	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "teamMembers", javaType = List.class, column = "id", many = @Many(select = "eryingzhang.net.mapper.TeamMemberMapper.listByTeamId")) })
	public List<Team> list();

	@Select("Select * from team_ where id = #{id}")
	public Team get(int id);
	
	@Select("Select team_.id from team_ where id = #{id}")
	public int getId(int id);
	
	
}
