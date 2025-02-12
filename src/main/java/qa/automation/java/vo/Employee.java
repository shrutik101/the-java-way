package qa.automation.java.vo;

public class Employee {
    private String empName;
    private Double salary;
    private Integer employeeID;
    private String department;

    public static String company;

    public Employee(String empName1,Double salary,Integer employeeID,String department){
        empName = empName1;
        this.salary = salary;
        this.employeeID = employeeID;
        this.department = department;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
