package qa.automation.java.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excelling {

    // Task 1
    // Open an excel read data in a row

    public static void main(String args[]) {
        String filePath = "F:\\Shruti\\workspace\\the-java-way\\src\\main\\resources\\EmployeeData.xlsx";

        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet employeeData = workbook.getSheetAt(0);
            System.out.println("Employee Name"+"\t"+"salary");
            double salarySum = 0;

            // Add an employee
            employeeData.shiftRows(employeeData.getLastRowNum(),employeeData.getLastRowNum(),1);
            Row newEmployee = employeeData.createRow(employeeData.getLastRowNum()-1);
            newEmployee.createCell(1,CellType.STRING).setCellValue("Chinnu");
            newEmployee.createCell(2,CellType.NUMERIC).setCellValue(2000);

            for (int i = 2; i < employeeData.getLastRowNum(); i++) {
                Row row = employeeData.getRow(i);
                String empName = row.getCell(1).getStringCellValue();
                Double salary = row.getCell(2).getNumericCellValue();
                salarySum += salary;
                System.out.println(empName+"\t"+salary);
            }

            // Print Average
            System.out.println(employeeData.getLastRowNum());
            double average = salarySum/(employeeData.getLastRowNum()-2);
            System.out.println("Average = "+average);
//            Row addedRow = employeeData.createRow(employeeData.getLastRowNum()+1);
//            addedRow.createCell(1, CellType.STRING).setCellValue("Average");
//            addedRow.createCell(2,CellType.NUMERIC).setCellValue(average);
            employeeData.getRow(employeeData.getLastRowNum()).getCell(2).setCellValue(average);

            FileOutputStream fos = new FileOutputStream(new File(filePath));
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    // Open an excel read data in col 1, col2 and write the addition in col 3

    // Task 3
    // Open an excel read data from it, and pass that to a data provider and pass it to testng test case using that data provider

}
