package niit.wei.service.impl;

import niit.wei.dao.SubjectTypeDao;
import niit.wei.dao.impl.SubjectTypeDaoImpl;
import niit.wei.entity.SubjectType;
import niit.wei.service.SubjectTypeService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 14:55
 * @Version 1.0
 */
public class SubjectTypeServiceImpl implements SubjectTypeService {
    private SubjectTypeDao subjectTypeDao = new SubjectTypeDaoImpl();
    @Override
    public List<SubjectType> getSubjectTypes() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select subject_type_id subjectTypeId, subject_type_name subjectTypeName  from subject_type;";
            return subjectTypeDao.getSubjectTypeList(conn,sql,SubjectType.class);
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
