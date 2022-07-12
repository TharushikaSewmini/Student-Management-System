package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCrudController {
    public boolean saveStudent(Student s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Student VALUES(?,?,?,?,?,?)", s.getsId(),s.getName(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic());
    }

    public boolean updateStudent(Student s1) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Student SET name=?, email=?, contact=?, address=?, nic=? WHERE sId=?", s1.getName(),s1.getEmail(),s1.getContact(),s1.getAddress(),s1.getNic(),s1.getsId());
    }

    public boolean deleteStudent(Student s2) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Student WHERE sId=?", s2.getsId());
    }

    public static ObservableList<Student> loadAllStudents() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Student");
        ObservableList<Student> obList = FXCollections.observableArrayList();
        while (result.next()) {
            obList.add(
                    new Student(
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5),
                            result.getString(6)
                    )
            );
        }
        return obList;
    }

    public static Student getStudent(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Student WHERE sId=?", id);
        if (result.next()) {
            return new Student(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }

    public static String getStudentId() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT sId FROM Student ORDER BY sId DESC LIMIT 1");
        if (set.next()) {
            String id = set.getString("sId");
            int newCustomerId = Integer.parseInt(id.replace("S", "")) + 1;
            return String.format("S%03d", newCustomerId);
        } else {
            return "S001";
        }
    }


}
