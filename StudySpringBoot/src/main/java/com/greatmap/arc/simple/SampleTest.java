package com.greatmap.arc.simple;

import com.greatmap.arc.entity.Student;
import com.greatmap.arc.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelect() {
        System.out.println("--查询--");
        List<Student> students = studentMapper.selectList(null);
        students.forEach(student -> System.out.println(student.toString()));
    }

}
