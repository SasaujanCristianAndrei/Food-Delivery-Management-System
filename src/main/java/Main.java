import presentation.*;

public class Main {
    public static void main(String[] args) {
        LoginRegisterView loginRegisterView=new LoginRegisterView();
        AdministratorView administratorView=new AdministratorView();
        ClientView clientView=new ClientView();
        RaportView raportView=new RaportView();
        Controller controller=new Controller(loginRegisterView,administratorView,clientView,raportView);
    }
}
