package co.za.tech.studentmanagementsystem.controller;

import co.za.tech.studentmanagementsystem.entity.Student;
import co.za.tech.studentmanagementsystem.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp(){
        student = new Student("Vice","Mzizi",'m',20);
        student.setId(1L);
    }

    @Test
    void getStudentById() throws Exception {
        String url = "/student/api/v1/student/1";
        when(studentService.getStudentById(1l)).thenReturn(student);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String studentActual = mvcResult.getResponse().getContentAsString();
        String studentExpected = objectMapper.writeValueAsString(student);
        verify(studentService).getStudentById(1l);
        assertEquals("["+studentExpected+"]",studentActual);
    }
}