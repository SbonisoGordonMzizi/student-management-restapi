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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@WebMvcTest(TeacherController.class)
class TeacherControllerTest {

    @Autowired
    private MockMvc mockedMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp(){
        student = new Student("Test1","White",'F',30);
    }

    @Test
    void addStudent() throws Exception {
        String url = "/teacher/api/v1/student/enroll";
        when(studentService.addStudent(student)).thenReturn(student);

        mockedMvc.perform( MockMvcRequestBuilders
                .post(url)
                .content(objectMapper.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(studentService).addStudent(student);
    }

    @Test
    void updateStudent() throws Exception {
        String url = "/teacher/api/v1/student/update";
        when(studentService.updateStudent(student)).thenReturn(student);

        mockedMvc.perform( MockMvcRequestBuilders
                .post(url)
                .content(objectMapper.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(studentService).updateStudent(student);
    }

    @Test
    void deleteStudent() throws Exception {
        String url = "/teacher/api/v1/student/deregister/1";
        when(studentService.deleteStudentById(1L)).thenReturn(student);

        mockedMvc.perform( MockMvcRequestBuilders
                .delete(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(studentService).deleteStudentById(1L);
    }
}