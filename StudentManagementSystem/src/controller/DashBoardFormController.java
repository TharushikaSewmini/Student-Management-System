package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DashBoardFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public JFXButton btnSaveStudent;
    public JFXButton btnDeleteCustomer;
    public TableView tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void saveStudentOnAction(ActionEvent actionEvent) {
    }

    public void deleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void addStudentOnAction(ActionEvent actionEvent) {
    }
}
