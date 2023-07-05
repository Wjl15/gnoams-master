package niit.wei.service.impl;

import niit.wei.dao.EducationDao;
import niit.wei.dao.impl.EducationDaoImpl;
import niit.wei.entity.Education;
import niit.wei.entity.SubjectType;
import niit.wei.service.EducationService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-04 10:16
 * @Version 1.0
 */
public class EducationServiceImpl implements EducationService {
    private EducationDao educationDao = new EducationDaoImpl();
    @Override
    public List<Education> getEducationList() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select education_id educationId, education_name educationName from education;";
            return educationDao.getEducationList(conn,sql, Education.class);
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
