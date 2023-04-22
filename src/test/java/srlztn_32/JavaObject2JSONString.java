package srlztn_32;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JavaObject2JSONString {

    public static void main(String[] args) throws IOException {

        MSE_EmployeePojo mse_EmployeePojo = new MSE_EmployeePojo();
        mse_EmployeePojo.setFirstName("Amod");
        mse_EmployeePojo.setLastName("Mahajan");
        mse_EmployeePojo.setAge(29);
        mse_EmployeePojo.setSalary(10987.77);
        mse_EmployeePojo.setMarried(false);
        mse_EmployeePojo.setGender("M");

        //Converting POJO to JSONString
        ObjectMapper objectMapper = new ObjectMapper();
        //For API we mostly used as a string or into a file. For proper formating use “writerWithDefaultPrettyPrinter()” before writing
        String convertedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mse_EmployeePojo);
        System.out.println(convertedJson);

        //Converting POJO to JSONFile
        //We just need to pass the target JSON file path and use the overloaded writeValue(File file, Object obj) method.
        String userDir = System.getProperty("user.dir");
        File outputJsonFile = new File(userDir+ "\\src\\test\\resources\\EmployeePayload.json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, mse_EmployeePojo);
    }
}
