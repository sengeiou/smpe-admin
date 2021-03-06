package marchsoft.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import marchsoft.config.MybatisRedisCache;
import marchsoft.modules.system.entity.Dept;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 部门 Mapper 接口
 * </p>
 *
 * @author Wangmingcan
 * @since 2020-08-17
 */
@CacheNamespace(implementation = MybatisRedisCache.class, eviction = MybatisRedisCache.class)
public interface DeptMapper extends BaseMapper<Dept> {


    /**
     * description 通过角色id和关联表roles_depts查询角色对应的所有部门
     *
     * @param roleId 角色id
     * @return Set<Dept> 角色对应的所有部门
     * @author Wangmingcan
     * @date 2020-08-23 15:42
     */
    @Select("SELECT d.* FROM sys_dept d, sys_roles_depts r WHERE d.dept_id = r.dept_id and r.role_id = #{roleId}")
    @Result(column = "dept_id", property = "id")
    Set<Dept> findByRoleId(Long roleId);
}
