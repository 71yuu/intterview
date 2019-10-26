package com.yuu.interview.base;

import java.io.File;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by Yuu
 * @Classname JDK中常用的包有哪些
 * @Date 2019/10/24 8:56
 * @see com.yuu.interview.base
 */
public class JDK中常用的包有哪些 {
    public static void main(String[] args) throws SQLException {
        // java.lang
        String str = new String();
        // java.util
        List<Object> list = new ArrayList<>();
        // java.io
        File file = new File("xxx.txt");
        // java.net
        Socket socket = new Socket();
        // java.sql
        DriverManager.getConnection("xxx", "xxx", "xxx");
    }
}
