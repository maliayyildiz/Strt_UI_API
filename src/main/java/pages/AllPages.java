package pages;

public class AllPages {
    public AllPages(){}

    private LoginPage loginPage;
    private UserPage userPage;
    private DeliveryDetailsPage deliveryDetailsPage;
    private CancellationPage cancellationPage;
    private HistoryPage historyPage;



    public LoginPage loginPage(){
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    public UserPage userPage(){
        if (userPage == null){
            userPage = new UserPage();
        }
        return userPage;
    }
    public DeliveryDetailsPage deliveryDetailsPage(){
        if (deliveryDetailsPage == null){
            deliveryDetailsPage = new DeliveryDetailsPage();
        }
        return deliveryDetailsPage;
    }
    public CancellationPage cancellationPage(){
        if (cancellationPage == null){
            cancellationPage = new CancellationPage();
        }
        return cancellationPage;
    }
    public HistoryPage historyPage(){
        if (historyPage == null){
            historyPage = new HistoryPage();
        }
        return historyPage;
    }


}
