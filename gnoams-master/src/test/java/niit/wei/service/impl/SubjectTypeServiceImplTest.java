package niit.wei.service.impl;

import niit.wei.entity.SubjectType;
import niit.wei.service.SubjectService;
import niit.wei.service.SubjectTypeService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubjectTypeServiceImplTest {
   private SubjectTypeService subjectTypeService = new SubjectTypeServiceImpl();
    @Test
    public void getSubjectTypes() {
        List<SubjectType> subjectTypes = subjectTypeService.getSubjectTypes();
        System.out.println(subjectTypes);
    }
}