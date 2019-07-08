package cn.lyx.dao;

import cn.lyx.daomain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findById(String id);

    @Select("select * from permission")
//    @Results({
//            @Result(id = true,property = "id",column = "id"),
//            @Result(property = "permissionName",column = "permissionName"),
//            @Result(property = "url",column = "url"),
//            @Result(property = "roles",column = "id",javaType = java.util.List.class,
//                    many = @Many(select = "cn.lyx.dao.IRoleDao.s"))
//    })
    List<Permission> findAll();

    @Select("select * from permission where id=#{id}")
    @Results({
            @Result(property = "permissionName", column = "permissonName"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "cn.lyx.dao.IRoleDao.s"))
    })
    Permission findByIdd(String id);

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission permission);
}
