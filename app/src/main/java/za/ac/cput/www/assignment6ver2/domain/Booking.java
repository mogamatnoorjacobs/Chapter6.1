package za.ac.cput.www.assignment6ver2.domain;

import za.ac.cput.www.assignment6ver2.factories.implement.ShopsFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Booking extends ShopsFactoryImpl
{
    //Name of Customer(username),MovieShop,Discount from Account type movie or game, Staff(username) who booked out

    public Booking(){}

    private Customer custDetails=new Customer();
    private Staff staffDetails=new Staff();
    private Movie movieDetails=new Movie();
    private Game gameDetails=new Game();
    private Shops shopDetails=new Shops();
    private AccountType accountType=new AccountType();
    private double account;
    private Shops shop;

    private double moviePrice=0.00;
    private double gamePrice=0.00;
    private double total=0.00;



    public void booking(String custName, String custSurname, String custIdNumber, String custHouseNumber, String custRoad, String custArea, String custUsername, String custPassword,String staffName, String staffSurname, String staffIdNumber, String staffHouseNumber, String staffRoad, String staffArea, String staffUsername, String staffPassword, String movieID, String movieName, int movieGenre, double moviePrice,String gameID, String gameName, int gameGenre, double gamePrice,int accType,String shopID,String shopName,String shopNumber,String road,String area,int catalog)

    //String shopID, String shopName, String shopNumber, String road, String area,int catalog,int accType)
    {
    /*    custDetails.customerDetails(custName,custSurname,custIdNumber,custHouseNumber,custRoad,custArea,custUsername,custPassword);
        staffDetails.staffDetails(staffName,staffSurname,staffIdNumber,staffHouseNumber,staffRoad,staffArea,staffUsername,staffPassword);
        movieDetails.movieDetails(movieID,movieName,movieGenre,moviePrice);
        gameDetails.gameDetails(gameID,gameName,gameGenre,gamePrice);
        shop=super.createShops(shopID,shopName,shopNumber,road,area,catalog);

        accountType.memberType(accType);
        this.moviePrice=moviePrice;
        this.gamePrice=gamePrice;*/
    }

    public double calculateTotal()
    {
        double discountPrice=((moviePrice+ gamePrice)*accountType.getMemberDiscount());
        total=moviePrice+ gamePrice-discountPrice;

        return total;
    }


    public String toString()
    {
        String rental;
        rental="Customer: "+custDetails.toString()+"\n"+"Movie: "+movieDetails.toString()+"\n"+"Game: "+ gameDetails.toString()+"\n"+"Staff: "+staffDetails.toString()+"\n"+"Total: R"+calculateTotal()+"\n"+"Discount: R"+accountType.getMemberDiscount()+"\n"+"Shop ID: "+shop.getShopID()+" "+shop.getShopName();

        return rental;
    }



}