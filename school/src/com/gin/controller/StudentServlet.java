package com.gin.controller;

import com.gin.dao.StudentDao;
import com.gin.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet" ,urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao = new StudentDao();

    public void init() {
        studentDao = new StudentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "login":
                    loginStudent(request,response);
                    break;
                case "create":
                    insertStudents(request, response);
                    break;
                case "edit":
                    updateStudent(request,response);
                    break;
                case "search":
                    searchStudent(request,response);
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        String pass = request.getParameter("pass");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        Student student =new Student(id,name,pass,phone,birthday,sex);
        studentDao.updateStudent(student);
        RequestDispatcher dispatcher =request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Student> students = studentDao.selectByStudent(search);
        request.setAttribute("students",students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(request,response);
    }

    private void loginStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Student student = null;
        RequestDispatcher dispatcher = null;
        student = this.studentDao.longinStudent(email,pass);
        if (student == null){
            request.setAttribute("message","Không có tài khoản này");
            dispatcher = request.getRequestDispatcher("student/login.jsp");

        }else {
            List<Student> students = studentDao.selectAllStudent();
            request.setAttribute("students", students);
            request.setAttribute("id",student.getId());
            request.setAttribute("name",student.getName());
            dispatcher = request.getRequestDispatcher("student/list.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void insertStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int idschool = Integer.parseInt(request.getParameter("idschool"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        Student newStudent = new Student(idschool, name, email, pass, phone, birthday, sex);
        studentDao.insertStudent(newStudent);
        request.setAttribute("messages","Đăng ký thành công hãy ấn quay lại để đăng nhập");
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "login":
                    showLogin(request,response);
                    break;
                case "create":
                    showNewForm(request, response);
                    break;
                case "home":
                    listStudent(request, response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        Student existingStuden = studentDao.selectStudent(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        request.setAttribute("student",existingStuden);
        dispatcher.forward(request,response);
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/login.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentDao.selectAllStudent();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
