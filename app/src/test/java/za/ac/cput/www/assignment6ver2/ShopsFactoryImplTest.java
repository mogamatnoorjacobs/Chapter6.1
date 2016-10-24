package za.ac.cput.www.assignment6ver2;

import org.junit.Assert;

import za.ac.cput.www.assignment6ver2.domain.Shops;
import za.ac.cput.www.assignment6ver2.factories.implement.ShopsFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class ShopsFactoryImplTest {

    private ShopsFactoryImpl factory;

    //@BeforeMethod
    public void setUp() throws Exception
    {
        factory =ShopsFactoryImpl.getInstance();
    }

    @org.junit.Test
    public void testCreateShops() throws Exception
    {
        Shops shop=factory.createShops((long) 2213213,"noor shop","26","Hazendal rd","Athlone",1);

        Assert.assertEquals(shop.getShopID(), "shop1");
        Assert.assertEquals(shop.getShopName(), "noor shop");
        Assert.assertEquals(shop.getShopNumber(), "26");
        Assert.assertEquals(shop.getRoad(), "Hazendal rd");
        Assert.assertEquals(shop.getArea(), "Athlone");
        Assert.assertEquals(shop.getCatalog(),"Movies");
    }

    public void testShopsUpdate() throws Exception
    {
        Shops shop=factory.createShops((long) 2132132132,"noor shop","26","Hazendal rd","Athlone",1);

        Assert.assertEquals(shop.getShopID(), "shop1");
        Assert.assertEquals(shop.getShopName(), "noor shop");
        Assert.assertEquals(shop.getShopNumber(), "26");
        Assert.assertEquals(shop.getRoad(), "Hazendal rd");
        Assert.assertEquals(shop.getArea(), "Athlone");
        Assert.assertEquals(shop.getCatalog(),"Movies");

        Shops updateShop = new Shops.Builder()
                .catalogOption(2)
                .copy(shop)
                .build();

        Assert.assertEquals(updateShop.getCatalog(), "Movies and Games");
        Assert.assertEquals(shop.getShopID(), updateShop.getShopID());
        Assert.assertEquals(shop.getShopName(), updateShop.getShopName());
        Assert.assertEquals(shop.getRoad(), updateShop.getRoad());
        Assert.assertEquals(shop.getArea(), updateShop.getArea());
        Assert.assertEquals(shop.getCatalog(),"Movies");
    }



}