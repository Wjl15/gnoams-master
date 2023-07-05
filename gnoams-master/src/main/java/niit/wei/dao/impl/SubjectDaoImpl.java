package niit.wei.dao.impl;

import niit.wei.dao.SubjectDao;
import niit.wei.entity.Subject;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 14:47
 * @Version 1.0
 */
public class SubjectDaoImpl extends BaseDao<Subject> implements SubjectDao {
    @Override
    public List<Subject> getSubjectList(Connection conn, String sql, Class<Subject> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz,args);
    }

    @Override
    public Subject getSubject(Connection conn, String sql, Class<Subject> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn, sql, clazz, args);
    }

    @Override
    public Long getSubjectCount(Connection conn, String sql, Object... args) throws SQLException {
        return getCount(conn, sql, args);
    }

    @Override
    public void addSubject(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void deleteSubject(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }

    @Override
    public void updateSubject(Connection conn, String sql, Object... args) throws SQLException {
        update(conn, sql, args);
    }
}
