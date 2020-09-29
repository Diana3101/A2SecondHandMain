package entities.dto;

import entities.Customer;
import entities.Problems;
import entities.Size;

import java.util.List;

public class CustomerDTO {

    private String firstName;
    private String lastName;
    private Size size;
    private Problems problem;

    public CustomerDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Problems getProblem() {
        return problem;
    }

    public void setProblem(Problems problem) {
        this.problem = problem;
    }
}
