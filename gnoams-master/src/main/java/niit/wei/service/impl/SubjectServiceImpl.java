package niit.wei.service.impl;

import niit.wei.dao.SubjectDao;
import niit.wei.dao.SubjectTypeDao;
import niit.wei.dao.impl.SubjectDaoImpl;
import niit.wei.dao.impl.SubjectTypeDaoImpl;
import niit.wei.dto.Page;
import niit.wei.entity.Subject;
import niit.wei.entity.SubjectType;
import niit.wei.service.SubjectService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 15:02
 * @Version 1.0
 */
public class SubjectServiceImpl implements SubjectService {
    private SubjectDao  subjectDao = new SubjectDaoImpl();
    private SubjectTypeDao subjectTypeDao = new SubjectTypeDaoImpl();

    @Override
    public void add(Subject subject) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into `subject`(subject_name, subject_life , create_time , subject_type_id ) \n" +
                    "values (?,?,?,?);";
            subjectDao.addSubject(conn, sql,subject.getSubjectName(),subject.getSubjectLife(),subject.getCreateTime(),subject.getSubjectTypeId());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void update(Subject subject) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update subject set  subject_name = ?, subject_life =?, create_time = ?, subject_type_id =? where subject_type_id =?";
            subjectDao.updateSubject(conn, sql,subject.getSubjectName(),subject.getSubjectLife(),subject.getCreateTime(),subject.getSubjectTypeId(),subject.getSubjectTypeId());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(Integer subjectId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete  from subject where subject_id =?";
            subjectDao.deleteSubject(conn, sql,subjectId);
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Subject getSubjectById(Integer subjectId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select subject_id subjectId, subject_name subjectName, subject_life subjectLife, create_time createTime, subject_type_id subjectTypeId from subject where subject_id=?;";
            Subject subject = subjectDao.getSubject(conn, sql, Subject.class, subjectId);
            return subject;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Subject> getSubjectList() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select subject_id subjectId, subject_name subjectName, subject_life subjectLife, create_time createTime, subject_type_id subjectTypeId from subject;";
            List<Subject> subjects = subjectDao.getSubjectList(conn, sql, Subject.class);
            for (Subject subject : subjects) {
                SubjectType subjectType = subjectTypeDao.getSubjectType(conn, "select subject_type_id subjectTypeId, subject_type_name subjectTypeName  from subject_type where subject_type_id=?", SubjectType.class, subject.getSubjectTypeId());
                subject.setSubjectType(subjectType);
            }
            return subjects;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Page getSubjectPage(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select subject_id subjectId, subject_name subjectName, subject_life subjectLife, create_time createTime, subject_type_id subjectTypeId from subject limit ?,?";
            List<Subject> subjectList = subjectDao.getSubjectList(conn, sql, Subject.class, (pageNo - 1) * pageSize, pageSize);
            for (Subject subject : subjectList) {
                SubjectType subjectType = subjectTypeDao.getSubjectType(conn, "select subject_type_id subjectTypeId, subject_type_name subjectTypeName  from subject_type where subject_type_id=?", SubjectType.class, subject.getSubjectTypeId());
                subject.setSubjectType(subjectType);
            }
            page.setPage(subjectList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            Long subjectCount = subjectDao.getSubjectCount(conn,"select count(*) count from subject");
            page.setCount(subjectCount);
            long count = (subjectCount % pageSize == 0) ? (subjectCount / pageSize) : (subjectCount / pageSize + 1);
            int PageCount = (int) count;
            page.setPageCount(PageCount);

            page.setHasPrePage(pageNo <= 1 ? false : true);
            page.setHasNextPage(pageNo >= PageCount ? false : true);
            return page;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
