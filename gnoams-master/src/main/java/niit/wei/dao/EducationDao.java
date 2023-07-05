package niit.wei.dao;

import niit.wei.entity.Education;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EducationDao {
    List<Education> getEducationList(Connection conn, String sql, Class<Education> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
    Education getEducation(Connection conn, String sql, Class<Education> clazz, Object... args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
}
