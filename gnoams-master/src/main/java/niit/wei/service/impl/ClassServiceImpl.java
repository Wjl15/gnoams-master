package niit.wei.service.impl;

import niit.wei.dao.ClassDao;
import niit.wei.dao.SubjectDao;
import niit.wei.dao.impl.ClassDaoImpl;
import niit.wei.dao.impl.SubjectDaoImpl;
import niit.wei.dto.Page;
import niit.wei.entity.Class1;
import niit.wei.entity.Subject;
import niit.wei.entity.SubjectType;
import niit.wei.service.ClassService;
import niit.wei.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author WeiJinLong
 * @Date 2023-07-03 19:12
 * @Version 1.0
 */
public class ClassServiceImpl implements ClassService {
    private ClassDao classDao = new ClassDaoImpl();
    private SubjectDao subjectDao = new SubjectDaoImpl();
    @Override
    public void addClass(Class1 class1)  {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into class(class_name, subject_id,create_time,class_life ,class_count,class_address) values(?,?,?,?,?,?)";
            classDao.addClass1(conn, sql, class1.getClassName(), class1.getSubjectId(),  class1.getCreateTime(),class1.getClassLife() ,class1.getClassCount(), class1.getClassAddress());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn!=null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
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
    public void deleteClassById(Integer classId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from class where class_id=?";
            classDao.deleteClass1(conn, sql, classId);
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn!=null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
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
    public void updateClass(Class1 class1) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "update class set class_name=?,subject_id=?,create_time=?,class_life=?,class_count=?,class_address=? where class_id =?;";
            classDao.updateClass1(conn, sql, class1.getClassName(),class1.getSubjectId(),class1.getCreateTime(),class1.getClassLife(),class1.getClassCount(),class1.getClassAddress(),class1.getClassId());
            conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (conn!=null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
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
    public Class1 getClassById(Integer classId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select class_id classId, class_name className, subject_id subjectId, class_count classCount, class_life classLife, class_address classAddress, create_time createTime from class where class_id=?";
            Class1 class1 = classDao.getClass1(conn, sql, Class1.class, classId);

            return class1;
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
    public List<Class1> getAllClass() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select class_id classId, class_name className, subject_id subjectId, class_count classCount, class_life classLife, class_address classAddress, create_time createTime from class";
            List<Class1> classList = classDao.getClassList(conn, sql, Class1.class);
            for (Class1 class1 : classList) {
                Subject subject = subjectDao.getSubject(conn, "select subject_id subjectId, subject_name subjectName,subject_life subjectLife,create_time createTime  from subject where subject_id=?", Subject.class, class1.getSubjectId());
                class1.setSubject(subject);
            }
            return classList;
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
    public Page getClassPage(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select class_id classId, class_name className, subject_id subjectId, class_count classCount, class_life classLife, class_address classAddress, create_time createTime from class limit ?,?";
            List<Class1> classList = classDao.getClassList(conn, sql, Class1.class,(pageNo - 1) * pageSize, pageSize);
            for (Class1 class1 : classList) {
                Subject subject = subjectDao.getSubject(conn, "select subject_id subjectId, subject_name subjectName,subject_life subjectLife,create_time createTime  from subject where subject_id=?", Subject.class, class1.getSubjectId());
                class1.setSubject(subject);
            }
            page.setPage(classList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);

            Long class1Count = classDao.getClass1Count(conn, "select count(*) count from class");
            page.setCount(class1Count);
            long count = (class1Count % pageSize == 0) ? (class1Count / pageSize) : (class1Count / pageSize + 1);
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
