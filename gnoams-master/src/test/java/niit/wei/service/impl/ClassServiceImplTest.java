package niit.wei.service.impl;

import niit.wei.service.ClassService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassServiceImplTest {
private ClassService classService = new ClassServiceImpl();
    @Test
    public void addClass() {
    }

    @Test
    public void deleteClassById() {
    }

    @Test
    public void updateClass() {
    }

    @Test
    public void getClassById() {
        System.out.println(classService.getClassById(10000));
    }

    @Test
    public void getAllClass() {
        System.out.println(classService.getAllClass());
    }

    @Test
    public void getClassPage() {
    }
}