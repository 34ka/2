package tests;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DemowebshopTests {

    /*
    HttpResponse<String> response = Unirest.post("http://demowebshop.tricentis.com/addproducttocart/details/75/1")
  .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
  .header("Cookie", "Nop.customer=d5876974-632b-4c1f-9cf5-9af97672204d; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; __utma=78382081.1410244865.1650384536.1650384536.1650384536.1; __utmc=78382081; __utmz=78382081.1650384536.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=75&RecentlyViewedProductIds=2; __atuvc=4%7C16; __atuvs=625edecdebaf9b22003; __utmb=78382081.5.10.1650384536; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; Nop.customer=d5876974-632b-4c1f-9cf5-9af97672204d")
  .body("product_attribute_75_5_31=96&product_attribute_75_6_32=100&product_attribute_75_3_33=102&addtocart_75.EnteredQuantity=1")
  .asString();
    */
    @Test
    public void addToCartAsNewUserTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .body("product_attribute_75_5_31=96&product_attribute_75_6_32=100&product_attribute_75_3_33=102&addtocart_75.EnteredQuantity=1")
                .post("http://demowebshop.tricentis.com/addproducttocart/details/75/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is("(1)"));
    }

    @Test
    public void addToCartWithCookieTest() {
        Integer cartSize = 0;

        ValidatableResponse response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("Nop.customer=d5876974-632b-4c1f-9cf5-9af97672204d;")
                        .when()
                        .body("product_attribute_75_5_31=96&product_attribute_75_6_32=100&product_attribute_75_3_33=102&addtocart_75.EnteredQuantity=1")
                        .post("http://demowebshop.tricentis.com/addproducttocart/details/75/1")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));

//        assertThat(response.extract().path("updatetopcartsectionhtml").toString())
//                .body("updatetopcartsectionhtml", is("(31)"));
    }
}
