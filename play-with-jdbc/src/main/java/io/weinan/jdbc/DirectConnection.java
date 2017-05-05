package io.weinan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by weli on 30/04/2017.
 */
public class DirectConnection {

    public static void main(String[] args)  throws Exception {


        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost/weli";
        Properties props = new Properties();
        props.setProperty("user", "weli");
        props.setProperty("password", "");
        props.setProperty("ssl", "false");

        Connection conn = DriverManager.getConnection(url, props);

        try {
            conn.setAutoCommit(true);
            Statement st = conn.createStatement();
            st.executeQuery("insert into user_info (id, name, age) values (3, 'weli', 16);");

        } finally {
            conn.commit();
            conn.close();
        }

    }
}
