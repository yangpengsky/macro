package com.macro.ocp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ocp.pojo.Role;

/**
* @author Admin
* @description 针对表【role(角色表)】的数据库操作Mapper
* @createDate 2022-09-01 11:09:28
* @Entity com.macro.ocp.pojo.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据role的id查询一个role
     * @param roleId
     * @return Role
     * @author zhangkein
     */
    Role getRuleByNo(Integer roleId);
}
