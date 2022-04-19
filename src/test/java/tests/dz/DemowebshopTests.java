package tests.dz;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemowebshopTests {

    @Test
    public void addToWishListAsNewUserTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .body("addtocart_43.EnteredQuantity=1")
                .post("http://demowebshop.tricentis.com/addproducttocart/details/43/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                .body("updatetopwishlistsectionhtml", is("(1)"));
    }

    @Test
    public void addToWishListWithCookieTest() {
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("Nop.customer=d5876974-632b-4c1f-9cf5-9af97672204d;")
                        .when()
                        .body("addtocart_43.EnteredQuantity=1")
                        .post("http://demowebshop.tricentis.com/addproducttocart/details/43/2")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                        .body("updatetopwishlistsectionhtml", not(empty()));
    }
}
