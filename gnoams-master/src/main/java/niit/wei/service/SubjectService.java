package niit.wei.service;

import niit.wei.dto.Page;
import niit.wei.entity.Subject;

import java.util.List;

public interface SubjectService {
    void add(Subject subject);
    void update(Subject subject);
    void delete(Integer subjectId);
    Subject getSubjectById(Integer subjectId);
    List<Subject> getSubjectList();
    Page getSubjectPage(Integer pageNo, Integer pageSize);
}
