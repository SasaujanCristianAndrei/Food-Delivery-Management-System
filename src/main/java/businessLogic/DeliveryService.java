package businessLogic;
import dataAcces.*;
import model.BaseProduct;
import model.MenuItem;
import model.Order;
import model.User;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    UserSerializator userSerializator = new UserSerializator();
    ProductSerializator productSerializator = new ProductSerializator();
    OrderSerializator orderSerializator = new OrderSerializator();
    IdSerializator idSerializator=new IdSerializator();

    private int contor = 0;
    private int orderContor = 1;
    HashMap<Order, List<MenuItem>> orders = new HashMap<>();

    public void importProducts() throws FileNotFoundException {
        List<MenuItem> menuList = new ArrayList<>();
        menuList = productSerializator.getBaseProduct();
        contor = menuList.size();
        BufferedReader br = new BufferedReader(new FileReader("products.csv"));
        String row;
        try {
            br.readLine();
            row = br.readLine();
            while (row != null) {
                String[] data = row.split(",");
                String v0 = data[0];
                double v1 = Double.parseDouble(data[1]);
                double v2 = Double.parseDouble(data[2]);
                double v3 = Double.parseDouble(data[3]);
                double v4 = Double.parseDouble(data[4]);
                double v5 = Double.parseDouble(data[5]);
                double v6 = Double.parseDouble(data[6]);
                BaseProduct baseProduct = new BaseProduct(v0, v1, v2, v3, v4, v5, v6);
                if (!findProduct(baseProduct, menuList)) {
                    menuList.add(baseProduct);
                    baseProduct.setId(contor++);
                }
                row = br.readLine();
            }
            br.close();
            productSerializator.addProduct(menuList);//adaug in product.ser

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean findProduct(MenuItem product, List<MenuItem> menuItems) {
        for (MenuItem x : menuItems) {
            if (x.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public List<MenuItem> findProductClient(BaseProduct baseProduct) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems = productSerializator.getBaseProduct();
        List<MenuItem> resultFinal = menuItems.stream()
                .filter(baseProductSimple -> {
                    if (
                            ((!baseProduct.getTitle().equals("")) ? baseProductSimple.getTitle().contains(baseProduct.getTitle()) : true) &&
                                    ((!(baseProduct.getRating() == null)) ? Double.compare(baseProductSimple.getRating(), baseProduct.getRating()) == 0 : true) &&
                                    ((!(baseProduct.getCalories() == null)) ? Double.compare(baseProductSimple.getCalories(), baseProduct.getCalories()) == 0 : true) &&
                                    ((!(baseProduct.getProteins() == null)) ? Double.compare(baseProductSimple.getProteins(), baseProduct.getProteins()) == 0 : true) &&
                                    ((!(baseProduct.getFats() == null)) ? Double.compare(baseProductSimple.getFats(), baseProduct.getFats()) == 0 : true) &&
                                    ((!(baseProduct.getSodium() == null)) ? Double.compare(baseProductSimple.getSodium(), baseProduct.getSodium()) == 0 : true) &&
                                    ((!(baseProduct.getPrice() == null)) ? Double.compare(baseProductSimple.getPrice(), baseProduct.getPrice()) == 0 : true)
                    ) return true;
                    else return false;
                })
                .collect(Collectors.toList());
        return resultFinal;
    }
    /**
     * find a product given
     * @pre product!=null
     * @post @nochange
     */
    public boolean findProduct(MenuItem product) {
        assert product!=null;
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems = productSerializator.getBaseProduct();
        for (MenuItem x : menuItems) {
            if (x.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(String title) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems = productSerializator.getBaseProduct();
        for (MenuItem x : menuItems) {
            if (x.getTitle().equals(title)) {
                productSerializator.deleteProduct(title);
                contor--;
                return true;
            }
        }
        return false;
    }

    /**
     * serialize the new product;
     * @pre product!=null
     * @post menuItems.size() == menuItems.size()@pre +1
     */
    public boolean addProduct(MenuItem product) {
        assert product!=null;
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems = productSerializator.getBaseProduct();
        contor = menuItems.size();
        if (!findProduct(product)) {
            product.setId(contor);
            productSerializator.addProduct(product);
            int sizeFinal=productSerializator.getBaseProduct().size();
            assert sizeFinal==contor+1;
            return true;
        }
        return false;
    }

    /**
     * @pre true
     * @post @nochange
     */
    public MenuItem findProduct(String title) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems = productSerializator.getBaseProduct();
        for (MenuItem x : menuItems) {
            if (x.getTitle().equals(title)) {
                return x;
            }
        }
        return null;
    }

    /**
     * @pre id>=0
     * @post @nochange
     */
    public MenuItem findProduct(Integer id) {
        assert id >=0;
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems = productSerializator.getBaseProduct();
        for (MenuItem x : menuItems) {
            if (Objects.equals(x.getId(), id)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public boolean editProducts(String title, Double rating, Double calories, Double proteins, Double fats, Double sodium, Double price) {

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems = productSerializator.getBaseProduct();
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getTitle().equals(title)) {
                menuItems.get(i).setTitle(title);
                menuItems.get(i).setCalories(calories);
                menuItems.get(i).setFats(fats);
                menuItems.get(i).setPrice(price);
                menuItems.get(i).setProteins(proteins);
                menuItems.get(i).setSodium(sodium);
                menuItems.get(i).setRating(rating);
                productSerializator.addProduct(menuItems);
                return true;
            }
        }
        return false;
    }

    /**
     * get the orders
     * @pre true
     * @post baseProductList.size()>=0
     */
    public List<MenuItem> getProducts() {
        List<MenuItem> baseProductList = new ArrayList<>();
        baseProductList = productSerializator.getBaseProduct();
        assert baseProductList.size()>=0;
        return baseProductList;
    }

    /**
     * find a product given
     * @pre foodOrder.size()>0 && client!=null;
     * @post @nochange
     */
    public void placeOrder(List<MenuItem> foodOrder, User client) {
        assert foodOrder.size()>0 && client!=null;
        LocalDateTime date = LocalDateTime.now();
        int id=0;
        int nr=idSerializator.getContorId();
        if(nr==0) {
            orderContor=1;
        }else orderContor=nr+1;
        List<User> findUserId=userSerializator.getUser();
        for(User x : findUserId) {
            if(x.equals(client)) id=x.getId();
        }
        Order order = new Order(orderContor, id, date);
        assert foodOrder.size()==0 :"You need to have at least 1 product";
        String nameProducts = "";
        double sumPrice = 0, iterator = 0;
        for (MenuItem x : foodOrder) {
            sumPrice = sumPrice + x.getPrice();
            iterator++;
            if (iterator == foodOrder.size()) {
                nameProducts = nameProducts + x.getTitle();
            } else nameProducts = nameProducts + x.getTitle() + ",";
        }
            File file = new File("order" + orderContor + ".txt");
            try {
                FileWriter bill = new FileWriter(file);
                bill.write("Order with ID = " + orderContor + " Made by the client with ID = "+id+"\n");
                bill.write("Food ordered = " + nameProducts + "\n");
                bill.write("Price = " + sumPrice);
                bill.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        for(User x : findUserId) {
            if(x.getRole().toString().equals("REGULAR_EMPLOYEE"))
            {
                x.update(this,order.getOrderId());
            }
        }
            order.setOrderPrice(sumPrice);
            order.setProductsOrdered(foodOrder);
            idSerializator.addContorId(orderContor);
            orderContor++;
            orderSerializator.addOrder(order,foodOrder);

    }

    /**
     * get the orders
     * @pre true
     * @post orderListHashMap.size()>=0
     */
    public HashMap<Order, List<MenuItem>> getOrders() {
        HashMap<Order, List<MenuItem>> orderListHashMap = new HashMap<>();
        orderListHashMap = orderSerializator.getOrders();
        assert orderListHashMap.size()>=0;
        return orderListHashMap;
    }


}

