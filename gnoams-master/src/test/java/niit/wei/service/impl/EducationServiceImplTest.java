package niit.wei.service.impl;

import niit.wei.entity.Education;
import niit.wei.service.EducationService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EducationServiceImplTest {

    @Test
    public void getEducationList() {
        EducationService educationService = new EducationServiceImpl();
        List<Education> educationList = educationService.getEducationList();
        System.out.println(educationList);
    }
}