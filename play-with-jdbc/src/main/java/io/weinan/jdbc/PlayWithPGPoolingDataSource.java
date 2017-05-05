package io.weinan.jdbc;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by weli on 01/05/2017.
 */
public class PlayWithPGPoolingDataSource {

    public static void main(String[] args) {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setDataSourceName("jdbc:postgresql://localhost/weli");
        dataSource.setUser("weli");
        dataSource.setPassword("");

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            Statement st = conn.createStatement();

            st.executeQuery("insert into user_info (id, name, age) values (2, 'weli', 16);");

        } catch (SQLException e) {
            // ok
            System.out.println(e);
        }

    }
}
