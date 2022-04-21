package tests.dz;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static listeners.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.Matchers.*;

@Tag("properties")
@Tag("dz")
public class DemowebshopTests {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
    }

    @Test
    public void addToWishListAsNewUserTest() {
        given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .body("addtocart_43.EnteredQuantity=1")
                .post("/addproducttocart/details/43/2")
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
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=d5876974-632b-4c1f-9cf5-9af97672204d;")
                .when()
                .body("addtocart_43.EnteredQuantity=1")
                .post("/addproducttocart/details/43/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                .body("updatetopwishlistsectionhtml", not(empty()));
    }
}
