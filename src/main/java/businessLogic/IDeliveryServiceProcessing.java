package businessLogic;

import model.BaseProduct;
import model.MenuItem;
import model.Order;
import model.User;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public interface IDeliveryServiceProcessing {

    /**
     * @throws FileNotFoundException
     */
    void importProducts() throws FileNotFoundException;

    /**
     * @param title
     * @param rating
     * @param calories
     * @param proteins
     * @param fats
     * @param sodium
     * @param price
     * @return boolean
     * imports the products from the csv file
     */
    boolean editProducts(String title, Double rating, Double calories, Double proteins, Double fats, Double sodium, Double price);

    /**
     * @param product
     * @param menuItems
     * @return boolean
     * returns true if we have a product to edit, else false
     */
    boolean findProduct(MenuItem product, List<MenuItem> menuItems);

    /**
     * @param baseProduct
     * @return boolean
     * returns List of menuItems
     */
    List<MenuItem> findProductClient(BaseProduct baseProduct);

    /**
     * @param product
     * @return boolean
     * returns true if we find the product, else false
     *
     */
    boolean findProduct(MenuItem product);

    /**
     * @param title
     * @return boolean
     * returns true if we delete the product,else false
     */
    boolean deleteProduct(String title);

    /**
     * @param product
     * @return boolean
     * returns true if we add the product,else false
     */
    boolean addProduct(MenuItem product);

    /**
     * @param title
     * @return MenuItem
     * returns true the menuItem find by the tile
     */
    MenuItem findProduct(String title);

    /**
     * @param id
     * @return MenuItem
     * returns true the menuItem find by the id
     */
    MenuItem findProduct(Integer id);

    /**
     * @return List<MenuItem></MenuItem>
     * returns all the products from the serializator
     */
    List<MenuItem> getProducts();

    /**
     * @param foodOrder
     * @param client
     */
    void placeOrder(List<MenuItem> foodOrder, User client);

    /**
     * @return HashMap<Order, List<MenuItem>>
     */
    HashMap<Order, List<MenuItem>> getOrders();
}
