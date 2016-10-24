package za.ac.cput.www.assignment6ver2.factories.implement;

import za.ac.cput.www.assignment6ver2.domain.Shops;

/**
 * Created by fatimam on 2016-05-22.
 */
public class ShopsFactoryImpl
{
    private static ShopsFactoryImpl factory = null;

    public  ShopsFactoryImpl()
    {

    }

    public static ShopsFactoryImpl getInstance()
    {
        if(factory ==null)
            factory = new ShopsFactoryImpl();
        return factory;
    }

    public Shops createShops(Long shopID, String shopName, String shopNumber, String road, String area, int catalog)
    {
        Shops shops=new Shops
                .Builder()
                .shopsID(shopID)
                .name(shopName)
                .numberAddress(shopNumber)
                .roadName(road)
                .areaName(area)
                .catalogOption(catalog)
                .build();
        return shops;
    }



}