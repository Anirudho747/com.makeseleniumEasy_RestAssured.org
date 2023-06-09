package dsrlztn_33;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONString2JavaObject {

    public static void main(String[] args) throws JsonProcessingException
    {
        String jsonString = "{\r\n" +
                "  \"firstName\" : \"Amod\",\r\n" +
                "  \"lastName\" : \"Mahajan\",\r\n" +
                "  \"gender\" : \"M\",\r\n" +
                "  \"age\" : 29,\r\n" +
                "  \"salary\" : 10987.77,\r\n" +
                "  \"married\" : false\r\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        // Pass JSON string and the POJO class
        Employee employeeObject = objectMapper.readValue(jsonString, Employee.class);
        // Now use getter method to retrieve values
        String firsName = employeeObject.getFirstName();
        String lastName = employeeObject.getLastName();
        String gender = employeeObject.getGender();
        int age = employeeObject.getAge();
        double salary = employeeObject.getSalary();
        boolean married = employeeObject.getMarried();


        System.out.println("Details of Employee is as below:-");
        System.out.println("First Name : " + firsName);
        System.out.println("Last Name : " + lastName);
        System.out.println("Gender : " + gender);
        System.out.println("Age : " + age);
        System.out.println("Salary : " + salary);
        System.out.println("Married : " + married);
    }
}
