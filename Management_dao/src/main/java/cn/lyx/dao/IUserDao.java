package cn.lyx.dao;

import cn.lyx.daomain.Role;
import cn.lyx.daomain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phonenum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.lyx.dao.IRoleDao.findById"))
    })
    UserInfo findByUserName(String username);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "cn.lyx.dao.IRoleDao.findById"))
    })
    UserInfo findById(String id);

    @Select("select * from role where id not in (SELECT  roleId FROM users_role WHERE  userId=#{id})")
    List<Role> findUserByIdAndAllRole(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param(value = "userId") String userId,@Param(value = "roleId") String roleId);
    @Select("select * from users where id  in (SELECT  userId FROM users_role WHERE  roleId=#{id})")
    List<UserInfo> findUser(String id);
}
