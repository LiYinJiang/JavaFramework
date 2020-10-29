package eryingzhang.net.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import eryingzhang.net.pojo.Hero;
import eryingzhang.net.pojo.TeamMember;

public interface TeamMemberMapper {

	@Insert("insert into team_member_ (name, tid) values(#{name}, #{tid})")
	public void insert(TeamMember teamMember);

	@Update("update team_member_ set name = #{name} , tid = #{tid} where id = #{id}")
	public int update(TeamMember teamMember);

	@Delete("delete from team_member_ where id = #{id}")
	public void delete(int id);

	@Select("select * from team_member_ ")
	@Results({
			@Result(property = "tid", column = "tid", one = @One(select = "eryingzhang.net.mapper.TeamMapper.getId")) })
	public List<TeamMember> listAll();

	@Select("select * from team_member_  where id = #{id}")
	public TeamMember select(int id);

	@Select("select h.* from hero_  h left join name_of_hero_ noh on noh.hid = h.id left join team_member_ tm on tm.id = noh.tmid where tm.id =#{0}")
	public List<Hero> listHeroByTeamId(int id);
	
	@Select("select * from team_member_ where tid = #{tid}")
	public List<TeamMember> listByTeamId(int tid);

}
