package niit.wei.service;

import niit.wei.dto.Page;
import niit.wei.entity.Class1;

import java.util.List;

public interface ClassService {
    void addClass(Class1 class1);
    void deleteClassById(Integer classId);
    void updateClass(Class1 class1);
    Class1 getClassById(Integer classId);
    List<Class1> getAllClass();
    Page getClassPage(Integer pageNo, Integer pageSize);

}
