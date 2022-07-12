package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.Optional;

public class DashBoardFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public JFXButton btnSaveStudent;
    public JFXButton btnUpdateStudent;
    public TableView<StudentTM> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;
    public TableColumn colOption;
    public TextField txtSearchId;

    public  void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("sId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        initUI();
        loadAllStudents();
    }

    public void initUI() {
        txtStudentId.clear();
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtName.clear();
        btnSaveStudent.setDisable(true);
    }

    private void loadAllStudents() {
        try {
            ObservableList<Student> obList = FXCollections.observableArrayList(StudentCrudController.loadAllStudents());

            for (Student student : obList
            ) {
                Button btn= new Button("Delete");

                StudentTM tm= new StudentTM(student.getsId(),student.getName(),student.getEmail(),student.getContact(), student.getAddress(),student.getNic(), btn);
                tmList.add(tm);

                btn.setOnAction(e->{
                    Alert alert= new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(buttonType.get().equals(ButtonType.YES)){

                        try{
                            boolean isCustomerDeleted = new StudentCrudController().deleteStudent(student);
                            if (isCustomerDeleted) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
                            }else{
                                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                            }
                        }catch (SQLException | ClassNotFoundException E){
                            E.printStackTrace();
                        }

                        // Remove Employee From tmList
                        tmList.remove(tm);
                    }
                });
                tblStudent.setItems(tmList);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    ObservableList<StudentTM> tmList = FXCollections.observableArrayList();

    public void saveStudentOnAction(ActionEvent actionEvent) {
        Student  s = new Student(txtStudentId.getText(), txtName.getText(), txtEmail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());

        // Add new Customer to Customer table
        try {
            boolean isStudentSaved = new StudentCrudController().saveStudent(s);
            if (isStudentSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        // Clear the table data
        tmList.clear();

        // Load all Customers to the TableView
        loadAllStudents();

    }

    public void updateStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ObservableList<Student> obList = FXCollections.observableArrayList(StudentCrudController.loadAllStudents());

        for (Student tm :obList
        ) {
            if(tm.getsId().equals(txtStudentId.getText())){
                tm.setName(txtName.getText());
                tm.setEmail(txtEmail.getText());
                tm.setContact(txtContact.getText());
                tm.setAddress((txtAddress.getText()));
                tm.setNic((txtNic.getText()));

                // Update Student
                try{
                    boolean isStudentUpdated = new StudentCrudController().updateStudent(tm);
                    if (isStudentUpdated){
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
                    }else{
                        new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                    }

                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }

                // Clear the table data
                tmList.clear();
                loadAllStudents();

                return;
            }
        }
    }



    public void txtSearchOnAction(ActionEvent actionEvent) {
        String selectedStudentId=txtStudentId.getText();

        try {
            Student s= StudentCrudController.getStudent(selectedStudentId);

            if(s!=null){
                txtStudentId.setText(s.getsId());
                txtName.setText(s.getName());
                txtEmail.setText(s.getEmail());
                txtContact.setText(s.getContact());
                txtAddress.setText(s.getAddress());
                txtNic.setText(s.getNic());
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void addStudentOnAction(ActionEvent actionEvent) {
        txtStudentId.clear();
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtName.clear();
        btnSaveStudent.setDisable(false);
    }
}
