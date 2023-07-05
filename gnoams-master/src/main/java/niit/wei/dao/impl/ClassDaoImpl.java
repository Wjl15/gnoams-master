package niit.wei.dao.impl;

import niit.wei.dao.ClassDao;
import niit.wei.entity.Class1;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 19:08
 * @Version 1.0
 */
public class ClassDaoImpl extends BaseDao<Class1> implements ClassDao {
    @Override
    public List<Class1> getClassList(Connection conn, String sql, Class<Class1> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz, args);
    }

    @Override
    public Class1 getClass1(Connection conn, String sql, Class<Class1> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn, sql, clazz, args);
    }

    @Override
    public Long getClass1Count(Connection conn, String sql, Object... args) throws SQLException {
        return getCount(conn, sql, args);
    }

    @Override
    public void addClass1(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void deleteClass1(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void updateClass1(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }
}
