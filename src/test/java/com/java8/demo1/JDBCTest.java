package com.java8.demo1;

import com.java8.tool.JDBCTools;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

/**
 * com.java8.demo1
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/10/23.
 */
public class JDBCTest {

    @Test
    public void testResultSetMetaData() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT flow_id flowId, type, id_card idCard, "
                    + "exam_card examCard, student_name studentName, "
                    + "location, grade " + "FROM examstudent WHERE flow_id = ?";

            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 5);

            resultSet = preparedStatement.executeQuery();

            Map<String, Object> values =
                    new HashMap<String, Object>();

            //1. µÃµ½ ResultSetMetaData ¶ÔÏó
            ResultSetMetaData rsmd = resultSet.getMetaData();

            while(resultSet.next()){
                //2. ´òÓ¡Ã¿Ò»ÁÐµÄÁÐÃû
                for(int i = 0; i < rsmd.getColumnCount(); i++){
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(columnLabel);

                    values.put(columnLabel, columnValue);
                }
            }

////			System.out.println(values);
//
//            Class clazz = Student.class;
//
//            Object object = clazz.newInstance();
//            for(Map.Entry<String, Object> entry: values.entrySet()){
//                String fieldName = entry.getKey();
//                Object fieldValue = entry.getValue();
//
////				System.out.println(fieldName + ": " + fieldValue);
//
//                ReflectionUtils.setFieldValue(object, fieldName, fieldValue);
//            }
//
//            System.out.println(object);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(resultSet, preparedStatement, connection);
        }
    }

}
