package makeSeleniumEasy;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class Tutorial27 {

    public static void main(String[] args) throws IOException {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/auth");

        String JsonString = "{\n" +
        "  \"[\\n   {\\n      \\\"firstname\\\":\\\"Jim\\\",\\n      \\\"lastname\\\":\\\"Brown\\\",\\n      \\\"totalprice\\\":111,\\n      \\\"depositpaid\\\":true,\\n      \\\"additionalneeds\\\":\\\"Breakfast\\\",\\n      \\\"bookingdates\\\":{\\n         \\\"checkin\\\":\\\"2021-07-01\\\",\\n         \\\"checkout\\\":\\\"2021-07-01\\\"\\n      }\\n   },\\n   {\\n      \\\"firstname\\\" : \\\"Amod\\\",\\n      \\\"lastname\\\" : \\\"Mahajan\\\",\\n      \\\"totalprice\\\" : 222,\\n      \\\"depositpaid\\\" : true,\\n      \\\"additionalneeds\\\" : \\\"Breakfast\\\",\\n      \\\"bookingdates\\\" : {\\n         \\\"checkin\\\" : \\\"2022-07-01\\\",\\n         \\\"checkout\\\" : \\\"2022-07-01\\\"\\n     }\\n  }\\n]\": null\n" +
        "}";

        request.body(JsonString);




    }

}
