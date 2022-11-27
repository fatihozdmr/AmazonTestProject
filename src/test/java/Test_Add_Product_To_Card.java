import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Test_Add_Product_To_Card extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void search_a_product() throws InterruptedException{
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductPage(), "Not on products page!");

//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("window.scroll(0,1200)");
//        Thread.sleep(2000);
    }

    @Test
    @Order(2)

    public void select_a_product() throws InterruptedException{
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on product detail page!");
        Thread.sleep(2000);
    }

    @Test
    @Order(3)

    public void add_product_to_cart() throws InterruptedException{
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(), "Product count did not increase!");
        Thread.sleep(2000);
    }

    @Test
    @Order(4)

    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(), "Product was not added to cart!");
    }
}
