package com.gin.dao;

import com.gin.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/school";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";
    private static Student student = null;
    private static final String INSERT_STUDENT = "INSERT INTO student" + " (idschool, name, email,pass, phone, birthday, sex) VALUES" + "(?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_STUDENT_1 = "select * from student where id <> ?;";
    private static final String LOGIN_STUDENT = "select * from student where email = ? and pass = ?;";
    private static final String SEARCH_STUDENT = "select name,sex from student where name like ?;";
    private static final String UPDATE_STUDENT = "update student set name=?,pass=?,phone=?,birthday=?,sex=? where id = ?;";
    private static final String SELECT_STUDENT_BY_NAME = "select id,name,pass, phone, birthday, sex from student where id =?";
    public StudentDao(){
    }
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("kết nối không thành công");
        }
        return connection;
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        try (
                Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)){
            preparedStatement.setInt(1,student.getIdschool());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getPass());
            preparedStatement.setInt(5,student.getPhone());
            preparedStatement.setString(6,student.getBirthday());
            preparedStatement.setString(7,student.getSex());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT_1);) {
            preparedStatement.setInt(1, student.getId());
            System.out.println(preparedStatement.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                students.add(new Student(name,sex));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public Student longinStudent(String Email, String Pass) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_STUDENT);){
            preparedStatement.setString(1,Email);
            preparedStatement.setString(2,Pass);
            System.out.println(preparedStatement);

            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pass = rs.getString("pass");
                int phone = rs.getInt("phone");
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");
                student = new Student(id, name,pass,phone,birthday,sex);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
            boolean rowUpdate;
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);){
                statement.setString(1,student.getName());
                statement.setString(2,student.getPass());
                statement.setInt(3,student.getPhone());
                statement.setString(4,student.getBirthday());
                statement.setString(5,student.getSex());
                statement.setInt(6,student.getId());
                rowUpdate = statement.executeUpdate() > 0;
            }
            return rowUpdate;
    }

    @Override
    public Student selectStudent(String Name) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_NAME);){
            preparedStatement.setString(1,student.getName());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String pass = rs.getString("pass");
                int phone = Integer.parseInt(rs.getString("phone"));
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public List<Student>selectByStudent(String Name){
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection() ;
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENT);){
                preparedStatement.setString(1,"%" + Name + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                students.add(new Student(name,sex));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
}
