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
    public TableColumn colsId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;
    public TableColumn colOption;
    public TextField txtSearchId;

    public  void initialize() {
        colsId.setCellValueFactory(new PropertyValueFactory<>("sId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));


        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {
                txtStudentId.setText(newValue.getsId());
                txtName.setText(newValue.getName());
                txtEmail.setText(newValue.getEmail());
                txtContact.setText(newValue.getContact());
                txtAddress.setText(newValue.getAddress());
                txtNic.setText(newValue.getNic());

            }
        });
        initUI();
        loadAllStudents();
    }

    public void initUI() {
        txtStudentId.clear();
        txtStudentId.setText(setStudentId());
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtName.clear();
        txtName.requestFocus();
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

        try {
            boolean isStudentSaved = new StudentCrudController().saveStudent(s);
            if (isStudentSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        tmList.clear();

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

                tmList.clear();
                loadAllStudents();

                return;
            }
        }
    }



    public void txtSearchOnAction(ActionEvent actionEvent) {
        String selectedStudentId=txtSearchId.getText();

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
        txtStudentId.setText(setStudentId());
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtName.clear();
        txtName.requestFocus();
    }

    public String setStudentId(){
        try {
            String sId = StudentCrudController.getStudentId();
            txtStudentId.setText(sId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "S001";
    }
}
