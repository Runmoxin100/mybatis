package cn.tedu.mybatis.mapper;

import cn.tedu.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    /**
     * 向表中插入新的用户数据
     * @param user 参数就是新的用户数据
     * @return 执行数据库操作后,执行成功则将受影响的行数返回
     */
    Integer insert(User user);

    /**
     * 根据用户的id来查询用户数据
     * @param id 要查询用户信息的id
     * @return 返回的是查询的结果
     */
    User findById(Integer id);

}
