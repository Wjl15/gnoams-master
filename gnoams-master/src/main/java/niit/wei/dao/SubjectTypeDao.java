package niit.wei.dao;


import niit.wei.entity.SubjectType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SubjectTypeDao {
    List<SubjectType> getSubjectTypeList(Connection conn, String sql, Class<SubjectType> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    SubjectType getSubjectType(Connection conn, String sql, Class<SubjectType> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
}
