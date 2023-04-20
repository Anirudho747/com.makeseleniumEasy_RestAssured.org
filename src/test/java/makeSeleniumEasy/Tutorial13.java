package makeSeleniumEasy;

import com.google.common.io.Files;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;

public class Tutorial13 {

    public static void main(String [] args) throws IOException {
        RequestSpecification request = RestAssured
                                       .given()
                                       .baseUri("https://restful-booker.herokuapp.com/auth");


        // There is no need to add escape character manually. Just paste string within
        // double quotes. It will automatically add escape sequence as required.
        String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

        request.header("Content-Type", "application/json");
        request.body(jsonString);

        Response response = request.request(Method.POST);

        System.out.println(response.asPrettyString());
        System.out.println("_______________________--------------------------__________________________--------------------");
        System.out.println(response.toString());
        System.out.println("_______________________--------------------------__________________________--------------------");
        System.out.println(response.asString());

        // Getting response as a byteArray and writing in to a file
        byte[] responseAsByteArray = response.asByteArray();
        File targetFileForByteArray = new File("src/main/resources/targetFileForByteArray.json");
        // Writing into files
        Files.write(responseAsByteArray, targetFileForByteArray);
    }
}
