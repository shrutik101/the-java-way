package qa.automation.java.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import qa.automation.java.vo.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ExcelWithClass {

    public static void main(String args[]){
        try{
//            System.out.println("Argument Len :" + aaa.length);
            File file = new File("F:\\Shruti\\workspace\\the-java-way\\src\\main\\resources\\EmployeeData.xlsx");
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet employeeData = workbook.getSheetAt(0);
            ArrayList<Employee> listOfEmployeeDetails = new ArrayList<>();
            for(int i=2; i <=employeeData.getLastRowNum(); i++){
                Row row = employeeData.getRow(i);
                String empName = row.getCell(1).getStringCellValue();
                double salary = row.getCell(2).getNumericCellValue();
                int employeeID = (int)row.getCell(3).getNumericCellValue();
                String department = row.getCell(4).getStringCellValue();
//                Employee employee = new Employee(empName,salary,employeeID,department);
//                listOfEmployeeDetails.add(employee);
            }

            Employee.company = "Synechron";

            System.out.println(Employee.company);

            Set<String> set = new HashSet<>();

            set.add("hii");

            set.add("Hello");

            set.add("hii");

            System.out.println("Set Size : "+set.size());


            int toChange = 0;
            for (Employee e : listOfEmployeeDetails){
                if(toChange == 0){
                    e.setEmpName("Shru");
                    e.company = "Synechron";
                }
                System.out.println(e.getEmpName() + " " + Employee.company);
                toChange++;

            }

            Employee.company = "Synechron";

            System.out.println(Employee.company);

            Employee e1 = new Employee("Shruti", 2000.0, 1100, "IT");





//            System.out.println(listOfEmployeeDetails.size());
//            Print a list of employees in IT department
//            System.out.println("List of employees in IT department:");
//            for(Employee employeeDetails : listOfEmployeeDetails){
//                if(employeeDetails.getDepartment().equalsIgnoreCase("IT")){
//                    System.out.println(employeeDetails.getEmpName());
//                }
//            }
//
//
////            Print employees in each department
//            for(Employee employeeDetails : listOfEmployeeDetails) {
//                if (employeeDetails.getDepartment().equalsIgnoreCase("IT")){
//
//                }
//            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
