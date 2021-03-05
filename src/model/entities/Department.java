package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {

    /*
    O serializale indica que nossos objetos podem ser transformados em sequências de bytes
    para que eles possam ser gravados em arquivos, trafegar em rede, etc.
     */

    private static final long serialVersionUID = 1L;

    private Integer departmentID;
    private String departmentName;

    public Department() {

    }

    public Department(Integer departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentID.equals(that.departmentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentID);
    }

    @Override
    public String toString() {
        return "Department [" +
                "departmentID: " + departmentID +
                ", departmentName: '" + departmentName + '\'' +
                ']';
    }
}
