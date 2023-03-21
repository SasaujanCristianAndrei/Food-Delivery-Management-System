package presentation;
import businessLogic.DeliveryService;
import businessLogic.UserServiceBLL;
import model.*;
import model.MenuItem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Controller {
    private int i = 0;
    private LoginRegisterView loginRegisterView;
    private AdministratorView administratorView;
    private TableForView tableForView;
    private RaportView raportView;
    private ClientView clientView;
    private List<User> clients;
    private User client;
    UserServiceBLL userServiceBLL;
    DeliveryService deliveryService;
    private JScrollPane scrollPaneMenuItem;

    public Controller(LoginRegisterView loginRegisterView, AdministratorView administratorView, ClientView clientView,RaportView raportView) {
        this.loginRegisterView = loginRegisterView;
        this.administratorView = administratorView;
        this.raportView = raportView;
        this.clientView = clientView;
        deliveryService = new DeliveryService();
        userServiceBLL = new UserServiceBLL();
        clients = new ArrayList<User>();

        this.loginRegisterView.loginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // User administrator=new User(1,"admin","admin", Role.ADMINISTRATOR);
                //userServiceBLL.addUser(administrator);
                User user = new User(loginRegisterView.getNameText(), loginRegisterView.getPasswordText());
                user.setRole(userServiceBLL.verifyPassword(user));
                client=user;
                if (user.getRole() == null) {
                    loginRegisterView.showMessage("Bad username/password");
                } else {
                    if (user.getRole().toString().equals("ADMINISTRATOR")) {
                        administratorView.setVisible(true);
                    }
                    if (user.getRole().toString().equals("CLIENT")) {
                        clientView.setVisible(true);
                    }
                }
                loginRegisterView.refresh();
            }
        });

        this.loginRegisterView.registerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!userServiceBLL.addUser(new User(loginRegisterView.getNameText(), loginRegisterView.getPasswordText(), loginRegisterView.getUserComboBox(),clientView))) {
                    loginRegisterView.showMessage("That's user already exists");
                }
                loginRegisterView.refresh();
            }
        });

        this.administratorView.importProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deliveryService.importProducts();
                    administratorView.showMessage("Succes import");
                } catch (Exception FileNotFoundException) {
                    administratorView.showMessage("Nu s-a putut serializa");
                }
            }
        });

        this.administratorView.viewProductsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (scrollPaneMenuItem != null) {
                    administratorView.remove(scrollPaneMenuItem);
                }
                List<MenuItem> baseProductList = deliveryService.getProducts();
                TableForView table = new TableForView(baseProductList);
                scrollPaneMenuItem = new JScrollPane(table.getTable());
                scrollPaneMenuItem.setBounds(415, 42, 781, 502);
                administratorView.add(scrollPaneMenuItem);
                administratorView.repaint();
            }
        });

        this.administratorView.addProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (administratorView.getTitleTextField().equals("") || administratorView.getFatTextField() == null || administratorView.getPriceTextField() == null || administratorView.getProteinTextField() == null || administratorView.getCaloriesTextField() == null || administratorView.getPriceTextField() == null || administratorView.getSodiumTextField() == null) {
                    administratorView.showMessage("Please fill all the fields");
                    return;
                }
                BaseProduct baseProduct = new BaseProduct(administratorView.getTitleTextField(), administratorView.getRatingTextField(), administratorView.getCaloriesTextField(), administratorView.getProteinTextField(), administratorView.getFatTextField(), administratorView.getSodiumTextField(), administratorView.getPriceTextField());
                if (!deliveryService.addProduct(baseProduct)) {
                    administratorView.showMessage("The item already exists");
                    return;
                } else administratorView.showMessage("Product added with succes");

            }
        });

        this.administratorView.deleteProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!deliveryService.deleteProduct(administratorView.getTitleTextField())) {
                    administratorView.showMessage("This product is not in the menu!");
                } else administratorView.showMessage("Product deleted with succes!");
            }
        });

        this.administratorView.modifyProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (administratorView.getTitleTextField().equals("") || administratorView.getFatTextField() == null || administratorView.getPriceTextField() == null || administratorView.getProteinTextField() == null || administratorView.getCaloriesTextField() == null || administratorView.getPriceTextField() == null || administratorView.getSodiumTextField() == null) {
                    administratorView.showMessage("Please fill all the fields");
                    return;
                }
                if (!deliveryService.editProducts(administratorView.getTitleTextField(), administratorView.getRatingTextField(), administratorView.getCaloriesTextField(), administratorView.getProteinTextField(), administratorView.getFatTextField(), administratorView.getSodiumTextField(), administratorView.getPriceTextField())) {
                    administratorView.showMessage("Item menu not found!");
                } else administratorView.showMessage("Product edited!");
            }
        });

        this.administratorView.createProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = administratorView.getTextAreaCompute();
                String nameProducts = "";
                List<String> parseCommand = Arrays.asList(command.split(","));
                double sumRating = 0, sumCalories = 0, sumProtein = 0, sumFats = 0, sumSodium = 0, sumPrice = 0, contor = 0;
                for (String x : parseCommand) {
                    MenuItem baseProduct = deliveryService.findProduct(Integer.parseInt(x));
                    if (baseProduct == null) {
                        administratorView.showMessage("Product with ID = " + x + " is not in our menu!");
                    } else {
                        contor++;
                        sumRating = sumRating + baseProduct.getRating();
                        sumCalories = sumCalories + baseProduct.getCalories();
                        sumProtein = sumProtein + baseProduct.getProteins();
                        sumFats = sumFats + baseProduct.getFats();
                        sumSodium = sumSodium + baseProduct.getSodium();
                        sumPrice = sumPrice + baseProduct.getSodium();
                        if (contor == parseCommand.size()) {
                            nameProducts = nameProducts + baseProduct.getTitle();
                        } else nameProducts = nameProducts + baseProduct.getTitle() + ",";
                    }
                }
                administratorView.showMessage(administratorView.getNewProductName() + " composed of " + nameProducts+" was created!");
                CompositeProduct compositeProduct = new CompositeProduct(administratorView.getNewProductName(), sumRating / contor, sumCalories / contor, sumProtein / contor, sumFats / contor, sumSodium / contor, sumPrice / contor);
                deliveryService.addProduct(compositeProduct);
            }
        });

        this.clientView.viewProductsClientListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (scrollPaneMenuItem != null) {
                    clientView.remove(scrollPaneMenuItem);
                }
                List<MenuItem> baseProductList = deliveryService.getProducts();
                TableForView table = new TableForView(baseProductList);
                scrollPaneMenuItem = new JScrollPane(table.getTable());
                scrollPaneMenuItem.setBounds(415, 42, 781, 502);
                clientView.add(scrollPaneMenuItem);
                clientView.revalidate();
                clientView.repaint();
            }
        });

        this.clientView.searchProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseProduct baseProduct = new BaseProduct(clientView.getTitleTextField(), clientView.getRatingTextField(), clientView.getCaloriesTextField(), clientView.getProteinTextField(), clientView.getFatTextField(), clientView.getSodiumTextField(), clientView.getPriceTextField());
                if (scrollPaneMenuItem != null) {
                    clientView.remove(scrollPaneMenuItem);
                }
                List<MenuItem> baseProductList = deliveryService.findProductClient(baseProduct);
                TableForView table = new TableForView(baseProductList);
                scrollPaneMenuItem = new JScrollPane(table.getTable());
                scrollPaneMenuItem.setBounds(415, 42, 781, 502);
                clientView.add(scrollPaneMenuItem);
                clientView.repaint();
            }
        });

        this.clientView.placeOrderProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<MenuItem> menuItems=new ArrayList<>();
                String command = clientView.getCommandTextField();
                if(command.equals("")) {
                    clientView.showMessage("The order can not be empty!");
                    return;
                }
                List<String> parseCommand = Arrays.asList(command.split(","));
                for (String x : parseCommand) {
                    if(deliveryService.findProduct(x)==null) {
                        clientView.showMessage("We don't have this type of food or you typed wrong the name of it!");
                        return;
                    }else menuItems.add(deliveryService.findProduct(x));
                }
                deliveryService.placeOrder(menuItems,client);
                clientView.showMessage(client.getAfiseaza());
            }
        });

        this.raportView.raport1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<Order, List<MenuItem>> orderListHashMap=deliveryService.getOrders();
                int startHour=raportView.getStartHourField();
                int endHour=raportView.getEndHourField();
                orderListHashMap=orderListHashMap.entrySet().stream().filter(hash ->hash.getKey().getOrderDate().getHour()>startHour).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                orderListHashMap=orderListHashMap.entrySet().stream().filter(hash ->hash.getKey().getOrderDate().getHour()<endHour).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                List<MenuItem> menuItemsList=new ArrayList<>();
                for (Map.Entry<Order,List<MenuItem>> entry : orderListHashMap.entrySet()) {
                    for(MenuItem x :entry.getValue()) {
                        menuItemsList.add(x);
                    }
                }
                List<MenuItem> baseProductList =menuItemsList;
                if (scrollPaneMenuItem != null) {
                    raportView.remove(scrollPaneMenuItem);
                }
                TableForView table = new TableForView(baseProductList);
                scrollPaneMenuItem = new JScrollPane(table.getTable());
                scrollPaneMenuItem.setBounds(415, 42, 781, 502);
                raportView.add(scrollPaneMenuItem);
                raportView.revalidate();
                raportView.repaint();
            }
        });

        this.raportView.raport2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<Order, List<MenuItem>> orderListHashMap=deliveryService.getOrders();
                List<MenuItem> menuItemsList=new ArrayList<>();
                for (Map.Entry<Order,List<MenuItem>> entry : orderListHashMap.entrySet()) {
                    for(MenuItem x :entry.getValue()) {
                        menuItemsList.add(x);
                    }
                }
                Set<MenuItem>rap2=menuItemsList.stream().filter(m->Collections.frequency(menuItemsList,m)>raportView.getNumberTimesField()).collect(Collectors.toSet());
                List<MenuItem> menuItems=new ArrayList<>(rap2);
                TableForView table = new TableForView(menuItems);
                if (scrollPaneMenuItem != null) {
                    raportView.remove(scrollPaneMenuItem);
                }
                scrollPaneMenuItem = new JScrollPane(table.getTable());
                scrollPaneMenuItem.setBounds(415, 42, 781, 502);
                raportView.add(scrollPaneMenuItem);
                raportView.revalidate();
                raportView.repaint();
            }
        });

        this.raportView.raport3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<Order, List<MenuItem>> orderListHashMap=deliveryService.getOrders();
                List<Order>orderList=new ArrayList<>();
                for (Map.Entry<Order,List<MenuItem>> entry : orderListHashMap.entrySet()) {
                    orderList.add(entry.getKey());
                }
                Set<Order>rap2=orderList.stream().filter(rezultat->rezultat.getOrderPrice()>raportView.getValueTextField()).collect(Collectors.toSet());
                ArrayList<User> userList= (ArrayList<User>) userServiceBLL.getUser();
                userList= (ArrayList<User>) userList.stream().filter(user -> rap2.stream().filter(rezultat->rezultat.getClientId()==user.getId()).count()>raportView.getMoreThanField()).collect(Collectors.toList());
                if (scrollPaneMenuItem != null) {
                    raportView.remove(scrollPaneMenuItem);
                }
                TableForView table = new TableForView(userList);
                scrollPaneMenuItem = new JScrollPane(table.getTable());
                scrollPaneMenuItem.setBounds(415, 42, 781, 502);
                raportView.add(scrollPaneMenuItem);
                raportView.revalidate();
                raportView.repaint();
            }
        });

        this.raportView.raport4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<Order, List<MenuItem>> orderListHashMap=deliveryService.getOrders();
                List<Order>orderList=new ArrayList<>();
                for (Map.Entry<Order,List<MenuItem>> entry : orderListHashMap.entrySet()) {
                    orderList.add(entry.getKey());
                }
               Set<Order>rap2=orderList.stream().filter(rezultat->rezultat.getOrderDate().getDayOfMonth()==raportView.getDayTextField()).collect(Collectors.toSet());
                List<String> list=new ArrayList<>();
                for(Order x: rap2) {
                   for(MenuItem y : x.getProductsOrdered()) {
                       list.add(y.getTitle());
                   }
               }
                Map<String, Long> frequencyMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                raportView.setRaport4TextArea(frequencyMap.toString());
            }
        });
        
        this.administratorView.generateReportsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raportView.setVisible(true);
            }
        });
    }
}
