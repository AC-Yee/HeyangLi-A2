// Employee.java
// Represents an employee who can operate rides

public class Employee extends Person {
    private String employeeID;
    private String role;

    // Default constructor
    public Employee() {
        super();
        this.employeeID = "E000";
        this.role = "Staff";
    }

    // Parameterized constructor
    public Employee(String name, int age, String gender, String employeeID, String role) {
        super(name, age, gender);
        this.employeeID = employeeID;
        this.role = role;
    }

    // Getters and Setters
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", role='" + role + '\'' +
                ", " + super.toString() +
                '}';
    }
}