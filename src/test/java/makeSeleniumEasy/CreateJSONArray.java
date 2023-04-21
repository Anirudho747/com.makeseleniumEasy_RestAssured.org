package makeSeleniumEasy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Iterator;

/*
 * [
   {
      "firstname":"Jim",
      "lastname":"Brown",
      "totalprice":111,
      "depositpaid":true,
      "additionalneeds":"Breakfast",
      "bookingdates":{
         "checkin":"2021-07-01",
         "checkout":"2021-07-01"
      }
   },
   {
      "firstname":"Amod",
      "lastname":"Mahajan",
      "totalprice":222,
      "depositpaid":true,
      "additionalneeds":"Lunch",
      "bookingdates":{
         "checkin":"2022-07-01",
         "checkout":"2022-07-01"
      }
   }
]
 *
 */

public class CreateJSONArray {

    public static void main(String[] args) throws IOException {

        ObjectMapper om = new ObjectMapper();

        ArrayNode parentArray = om.createArrayNode();

        ObjectNode on1 = om.createObjectNode();

        // It is similar to map put method. put method is overloaded to accept different types of data
        // String as field value
        on1.put("firstname", "Jim");
        on1.put("lastname", "Brown");
        // integer as field value
        on1.put("totalprice", 111);
        // boolean as field value
        on1.put("depositpaid", true);
        on1.put("additionalneeds", "Breakfast");

        // Since requirement is to create a nested JSON Object
        ObjectNode on1_1 = om.createObjectNode();
        on1_1.put("checkin", "2021-07-01");
        on1_1.put("checkout", "2021-07-01");

        // Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
        on1.set("bookingdates", on1_1);



        ObjectNode on2 = om.createObjectNode();

        // It is similar to map put method. put method is overloaded to accept different types of data
        // String as field value
        on2.put("firstname", "Amod");
        on2.put("lastname", "Mahajan");
        // integer as field value
        on2.put("totalprice", 222);
        // boolean as field value
        on2.put("depositpaid", false);
        on2.put("additionalneeds", "Lunch");

        // Since requirement is to create a nested JSON Object
        ObjectNode on2_1 = om.createObjectNode();
        on2_1.put("checkin", "2021-07-01");
        on2_1.put("checkout", "2021-07-01");

        // Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
        on2.set("bookingdates", on2_1);

        parentArray.add(on1);
        parentArray.add(on2);


        String jsonArrayAsString = om.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray);
        System.out.println("Created Json Array is : ");
        System.out.println(jsonArrayAsString);
        System.out.println("=======================================================================================");
        // To get json array element using index
        JsonNode firstElement = parentArray.get(0);
        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(firstElement));
        System.out.println("=======================================================================================");
        // To get size of JSON array
        int sizeOfArray = parentArray.size();
        System.out.println("Size of array is "+sizeOfArray);
        System.out.println("=======================================================================================");
        // To iterate JSON Array
        Iterator<JsonNode> itrtr = parentArray.iterator();
        System.out.println("Prining Json Node using iterator : ");
        while(itrtr.hasNext())
        {
            JsonNode currentJsonNode = itrtr.next();
            System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(currentJsonNode));
        }
        System.out.println("=======================================================================================");
        // To remove an element from array
        parentArray.remove(0);
        System.out.println("After removing first element from array : "+ om.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));
        System.out.println("=======================================================================================");
        // To empty JSON Array
        parentArray.removeAll();
        System.out.println("After removing all elements from array : "+ om.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));


    }
}
