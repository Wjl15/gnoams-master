package niit.wei.dao.impl;

import niit.wei.dao.SubjectTypeDao;
import niit.wei.entity.SubjectType;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 14:51
 * @Version 1.0
 */
public class SubjectTypeDaoImpl extends BaseDao<SubjectType> implements SubjectTypeDao {
    @Override
    public List<SubjectType> getSubjectTypeList(Connection conn, String sql, Class<SubjectType> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz, args);
    }

    @Override
    public SubjectType getSubjectType(Connection conn, String sql, Class<SubjectType> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn, sql, clazz, args);
    }
}
