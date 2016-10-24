package za.ac.cput.www.assignment6ver2.domain;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Discount
{
    private static double platinumClient=0.20;
    private static double goldClient=0.15;
    private static double silverClient=0.10;
    private static double newClient=0.00;

    public Discount(){};



    public double getPlatinumClient()
    {
        return platinumClient;
    }
    public double getGoldClient()
    {
        return goldClient;
    }
    public double getSilverClient()
    {
        return silverClient;
    }

    public double getNewClient()
    {
        return newClient;
    }
}
