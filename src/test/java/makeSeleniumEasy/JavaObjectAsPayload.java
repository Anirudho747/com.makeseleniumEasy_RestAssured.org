package makeSeleniumEasy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class JavaObjectAsPayload {

    public static void main(String[] args) throws IOException {

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/auth");

        request.header("Content-Type", "application/json");

       ObjectMapper om = new ObjectMapper();

       ObjectNode node1 = om.createObjectNode();

       // It is similar to map put method. put method is overloaded to accept different types of data
        // String as field value
        node1.put("firstname", "Jim");
        node1.put("lastname", "Brown");
        // integer as field value
        node1.put("totalprice", 111);
        // boolean as field value
        node1.put("depositpaid", true);
        node1.put("additionalneeds", "Breakfast");
        // Duplicate field name. Will override value
        node1.put("additionalneeds", "Lunch");

        // Since requirement is to create a nested JSON Object
        ObjectNode node1_1 = om.createObjectNode();
        node1_1.put("checkin", "2023-07-01");
        node1_1.put("checkout", "2023-07-01");

        // Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
        node1.set("bookingdates", node1_1);


        request.body(node1);

        Response response = request.request(Method.POST);

        System.out.println(response.asPrettyString());
        System.out.println("_______________________--------------------------__________________________--------------------");
        System.out.println(response.toString());
        System.out.println("_______________________--------------------------__________________________--------------------");
        System.out.println(response.asString());

    }

}
