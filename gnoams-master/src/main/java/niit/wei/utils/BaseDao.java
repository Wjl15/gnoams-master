package niit.wei.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {

    public T getOne(Connection conn, String sql, Class<T> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        T t = null;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
        }
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //获取数据库表的元数据对象
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取数据库的列的总数
        int columnCount = rsmd.getColumnCount();
        if (rs.next()) {
            t = clazz.newInstance();
            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = rsmd.getColumnLabel(i);
                Object columnValue = rs.getObject(columnLabel);

                Field field = clazz.getDeclaredField(columnLabel);

                //开启权限
                field.setAccessible(true);

                field.set(t, columnValue);
            }

            return t;
        }
        return null;
    }

    /**
     * @param conn
     * @param sql
     * @param clazz 映射表的实体类
     * @param args  站位符的参数
     * @return 集合
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    public List<T> getList(Connection conn, String sql, Class<T> clazz, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {

        List<T> list = new ArrayList();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
        }
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //获取数据库表的元数据对象
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取数据库的列的总数
        int columnCount = rsmd.getColumnCount();
        while (rs.next()) {
            T t = clazz.newInstance();
            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = rsmd.getColumnLabel(i);
                Object columnValue = rs.getObject(columnLabel);

                Field field = clazz.getDeclaredField(columnLabel);

                //开启权限
                field.setAccessible(true);

                field.set(t, columnValue);
            }
            list.add(t);

        }
        return list;
    }


    /**
     * @param conn
     * @param sql
     * @param args 占位符
     * @throws SQLException
     */
    public void update(Connection conn, String sql, Object... args) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }

        }
        pstmt.executeUpdate();

    }


    /**
     * 聚合函数查询
     */
    public Long getCount(Connection conn, String sql, Object... args) throws SQLException {
        Long count = 0L;
        PreparedStatement pstm = conn.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i+1, args[i]);
            }
        }
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
             count = rs.getLong("count");
        }
        return count;
    }
}
