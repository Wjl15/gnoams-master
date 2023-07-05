package niit.wei.dao.impl;

import niit.wei.dao.EducationDao;
import niit.wei.entity.Education;
import niit.wei.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-04 10:14
 * @Version 1.0
 */
public class EducationDaoImpl extends BaseDao<Education> implements EducationDao {
    @Override
    public List<Education> getEducationList(Connection conn, String sql, Class<Education> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getList(conn, sql, clazz, args);
    }

    @Override
    public Education getEducation(Connection conn, String sql, Class<Education> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        return getOne(conn, sql, clazz, args);
    }
}
