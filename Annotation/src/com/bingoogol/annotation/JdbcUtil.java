package com.bingoogol.annotation;

import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * Created by bingoogol@sina.com on 14-3-13.
 */
public class JdbcUtil {


    @DbInfo(driver="com.mysql.jdbc.Driver",url="jdbc:mysql://localhost:3306/test",user="root",password="123456")
    public Connection getConnection() throws NoSuchMethodException {
        Class clazz = JdbcUtil.class;
        Method method = clazz.getMethod("getConnection",null);
        DbInfo dbInfo = method.getAnnotation(DbInfo.class);
        System.out.println(dbInfo.driver());
        System.out.println(dbInfo.url());
        System.out.println(dbInfo.user());
        System.out.println(dbInfo.password());
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        new JdbcUtil().getConnection();
    }
}
