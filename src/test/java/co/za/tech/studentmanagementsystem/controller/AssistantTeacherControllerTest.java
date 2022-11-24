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

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AssistantTeacherController.class)
class AssistantTeacherControllerTest {

    @Autowired
    private MockMvc mockedMvc;

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
    void getStudentByFirstName() throws Exception {
        String url = "/assistant/api/v1/student/firstName/Vice";
        when(studentService.getStudentByFirstName("Vice")).thenReturn(Set.of(student));
        MvcResult mvcResult = mockedMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String actual = mvcResult.getResponse().getContentAsString();
        String expected = objectMapper.writeValueAsString(student);

        verify(studentService).getStudentByFirstName("Vice");
        assertEquals("["+expected+"]",actual);
    }

    @Test
    void getStudentByLastName() throws Exception {
        String url = "/assistant/api/v1/student/lastName/Mzizi";
        when(studentService.getStudentByLastName("Mzizi")).thenReturn(Set.of(student));
        MvcResult mvcResult = mockedMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String actual = mvcResult.getResponse().getContentAsString();
        String expected = objectMapper.writeValueAsString(student);

        verify(studentService).getStudentByLastName("Mzizi");
        assertEquals("["+expected+"]",actual);
    }

    @Test
    void getAllStudent() throws Exception {
        String url = "/assistant/api/v1/student/all";
        when(studentService.getAllStudent()).thenReturn(Set.of(student));
        MvcResult mvcResult = mockedMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String actual = mvcResult.getResponse().getContentAsString();
        String expected = objectMapper.writeValueAsString(student);

        verify(studentService).getAllStudent();
        assertEquals("["+expected+"]",actual);
    }
}