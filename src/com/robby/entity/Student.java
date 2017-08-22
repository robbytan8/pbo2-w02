package com.robby.entity;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Robby
 */
public final class Student {

    private final ObjectProperty<Department> department = new SimpleObjectProperty<>();
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();

    public Student() {
    }

    public Student(String id, String name, Department department) {
        this.setId(id);
        this.setName(name);
        this.setDepartment(department);
    }

    public ObjectProperty departmentProperty() {
        return department;
    }

    public Department getDepartment() {
        return department.get();
    }

    public void setDepartment(Department value) {
        department.set(value);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

}
