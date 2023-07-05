package niit.wei.service.impl;

import niit.wei.entity.Subject;
import niit.wei.service.SubjectService;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class SubjectServiceImplTest {
    private SubjectService subjectService = new SubjectServiceImpl();

    @Test
    public void add() throws ParseException {
        Subject subject = new Subject();
        subject.setSubjectName("Html5");
        subject.setSubjectLife(20);
        Date date = new Date();
        System.out.println(date);
//        Timestamp timestamp = new Timestamp(date.getTime());
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
        subject.setCreateTime(date1);
        subject.setSubjectTypeId(10001);
        subjectService.add(subject);
    }

    @Test
    public void update() {
        Subject subject = new Subject();
        subject.setSubjectName("Html5");
        subject.setSubjectLife(20);
        Date date = new Date();
        System.out.println(date);
//        Timestamp timestamp = new Timestamp(date.getTime());
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
        subject.setCreateTime(date1);
        subject.setSubjectTypeId(10002);
        subject.setSubjectId(1002);
        subjectService.update(subject);
    }

    @Test
    public void delete() {
        subjectService.delete(10003);
    }

    @Test
    public void getSubjectById() {

        Subject subject = subjectService.getSubjectById(10002);
        System.out.println(subject);
    }

    @Test
    public void getSubjectList() {
        List<Subject> subjects = subjectService.getSubjectList();
        System.out.println(subjects);
    }

    @Test
    public void getSubjectPage() {
    }
}