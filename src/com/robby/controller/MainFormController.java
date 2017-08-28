package com.robby.controller;

import com.robby.entity.Department;
import com.robby.entity.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Robby
 */
public class MainFormController implements Initializable {

    @FXML
    private TableColumn<Student, String> colDepartment;
    @FXML
    private TableColumn<Student, String> colID;
    @FXML
    private TableColumn<Student, String> colName;
    @FXML
    private ComboBox<Department> comboDepartment;
    @FXML
    private TableView<Student> tableStudent;

    private ObservableList<Department> departments;
    private ObservableList<Student> students;

    public ObservableList<Department> getDepartments() {
        if (departments == null) {
            departments = FXCollections.observableArrayList();
        }
        return departments;
    }

    public ObservableList<Student> getStudents() {
        if (students == null) {
            students = FXCollections.observableArrayList();
        }
        return students;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateDepartmentData();
        populateStudentData();
        comboDepartment.setItems(getDepartments());
        tableStudent.setItems(getStudents());
        colID.setCellValueFactory(data -> data.getValue().idProperty());
        colName.setCellValueFactory(data -> data.getValue().nameProperty());
        colDepartment.setCellValueFactory(data -> data.getValue().getDepartment().nameProperty());
    }

    @FXML
    private void mnAboutAction(ActionEvent event) {
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        alertInfo.setContentText("Created by Robby");
        alertInfo.setTitle("Information");
        alertInfo.showAndWait();
    }

    @FXML
    private void mnCloseAction(ActionEvent event) {
        Platform.exit();
    }

    private void populateDepartmentData() {
        getDepartments().add(new Department(1, "Department 1"));
        getDepartments().add(new Department(2, "Department 2"));
        getDepartments().add(new Department(3, "Department 3"));
        getDepartments().add(new Department(4, "Department 4"));
        getDepartments().add(new Department(5, "Department 5"));
    }

    private void populateStudentData() {
        getStudents().add(new Student("2015010001", "Person 1", getDepartments().get(0)));
        getStudents().add(new Student("2015010002", "Person 2", getDepartments().get(0)));
        getStudents().add(new Student("2015010003", "Person 3", getDepartments().get(0)));
        getStudents().add(new Student("2015010004", "Person 4", getDepartments().get(0)));
        getStudents().add(new Student("2015040001", "Person 5", getDepartments().get(3)));
        getStudents().add(new Student("2015040002", "Person 6", getDepartments().get(3)));
        getStudents().add(new Student("2015040003", "Person 7", getDepartments().get(3)));
    }
}
