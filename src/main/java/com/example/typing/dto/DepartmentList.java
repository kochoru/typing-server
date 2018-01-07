package com.example.typing.dto;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DepartmentList {

    private List<Department> departmentList;

    public DepartmentList(String[] strArr) {
        departmentList = new CopyOnWriteArrayList<>();
        for(String str : strArr) {
            departmentList.add(new Department(str, str));
        }
    }

    public List<Department> getDepartmentList() {
        return this.departmentList;
    }

    public class Department {

        private String label;

        private String value;

        public Department(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
