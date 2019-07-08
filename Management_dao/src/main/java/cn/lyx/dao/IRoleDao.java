package cn.lyx.dao;

import cn.lyx.daomain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.lyx.dao.IPermissionDao.findById"))
    })
    List<Role> findById(String userId);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "users", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.lyx.dao.IUserDao.findUser")),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.lyx.dao.IPermissionDao.findById"))
    })
    Role findByIds(String id);

    @Select("select * from role where id in(select roleId from role_permission where permissionId=#{permissionId})")
    List<Role> s( String permissionId);
}
