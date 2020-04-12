package cn.tedu.mybatis;

import cn.tedu.mybatis.entity.User;
import cn.tedu.mybatis.mapper.UserMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.nio.DoubleBuffer;
import java.sql.Connection;
import java.sql.SQLException;

public class UserMapperTests {

    UserMapper mapper;

    private ClassPathXmlApplicationContext ca ;
    private DataSource dataSource;
    @Before
    public void doBefore(){
        ca = new ClassPathXmlApplicationContext("spring-dao.xml");
        mapper = ca.getBean("userMapper", UserMapper.class);

    }

    @After
    public void doAfter(){
        ca.close();
    }

    @Test
    public void getConn() throws SQLException {
        dataSource = ca.getBean("dataSource", BasicDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println("\t 从连接池中获取连接对象: "+connection);
    }

    @Test
    public void insert(){

        User user = new User();
        user.setId(1);
        user.setName("范闲");
        user.setAge(12);
        user.setGender("男");
        Integer rows = mapper.insert(user);
        System.out.println("\t rows = "+ rows);
    }

    @Test
    public void findById(){
        Integer id = 1;
        User user = mapper.findById(id);
        System.out.println("\t user = "+ user);
    }
}

