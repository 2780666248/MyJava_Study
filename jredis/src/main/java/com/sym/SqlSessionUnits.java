package com.sym;

import com.hemalh.config.MapperConfiguration;
import com.hemalh.config.SqlConfigReader;
import com.hemalh.factory.SqlSessionFactory;
import com.hemalh.session.SqlSession;

public class SqlSessionUnits {
    private static SqlSessionFactory factory;
    static{
        MapperConfiguration config = new SqlConfigReader(SqlSessionUnits.class.getClassLoader()).read("mybatis-config.xml");
        factory = new SqlSessionFactory(config);
    }
    public static SqlSession openSession(){
        return factory.openSession();
    }
}
