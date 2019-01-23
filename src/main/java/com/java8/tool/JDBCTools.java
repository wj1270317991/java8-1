package com.java8.tool;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * com.java8.tool
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/10/23.
 */
public class JDBCTools {
    /**
     * Ö´ÐÐ SQL Óï¾ä, Ê¹ÓÃ PreparedStatement
     * @param sql
     * @param args: ÌîÐ´ SQL Õ¼Î»·ûµÄ¿É±ä²ÎÊý
     */
    public static void update(String sql, Object ... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for(int i = 0; i < args.length; i++){
                preparedStatement.setObject(i + 1, args[i]);
            }

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCTools.releaseDB(null, preparedStatement, connection);
        }
    }

    /**
     * Ö´ÐÐ SQL µÄ·½·¨
     *
     * @param sql: insert, update »ò delete¡£ ¶ø²»°üº¬ select
     */
    public static void update(String sql) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 1. »ñÈ¡Êý¾Ý¿âÁ¬½Ó
            connection = getConnection();

            // 2. µ÷ÓÃ Connection ¶ÔÏóµÄ createStatement() ·½·¨»ñÈ¡ Statement ¶ÔÏó
            statement = connection.createStatement();

            // 4. ·¢ËÍ SQL Óï¾ä: µ÷ÓÃ Statement ¶ÔÏóµÄ executeUpdate(sql) ·½·¨
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. ¹Ø±ÕÊý¾Ý¿â×ÊÔ´: ÓÉÀïÏòÍâ¹Ø±Õ.
            releaseDB(null, statement, connection);
        }
    }

    /**
     * ÊÍ·ÅÊý¾Ý¿â×ÊÔ´µÄ·½·¨
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void releaseDB(ResultSet resultSet, Statement statement,
                                 Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * »ñÈ¡Êý¾Ý¿âÁ¬½ÓµÄ·½·¨
     */
    public static Connection getConnection() throws IOException,
            ClassNotFoundException, SQLException {
        // 0. ¶ÁÈ¡ jdbc.properties

        Properties properties = new Properties();
        InputStream inStream = JDBCTools.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        properties.load(inStream);

        // 1. ×¼±¸»ñÈ¡Á¬½ÓµÄ 4 ¸ö×Ö·û´®: user, password, jdbcUrl, driverClass
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String jdbcUrl = properties.getProperty("jdbcUrl");
        String driverClass = properties.getProperty("driverClass");

        // 2. ¼ÓÔØÇý¶¯: Class.forName(driverClass)
        Class.forName(driverClass);

        // 3. µ÷ÓÃ
        // DriverManager.getConnection(jdbcUrl, user, password)
        // »ñÈ¡Êý¾Ý¿âÁ¬½Ó
        Connection connection = DriverManager.getConnection(jdbcUrl, user,
                password);
        return connection;
    }
}
