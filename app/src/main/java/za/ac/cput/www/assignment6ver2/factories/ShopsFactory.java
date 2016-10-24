package za.ac.cput.www.assignment6ver2.factories;

import za.ac.cput.www.assignment6ver2.domain.Shops;

/**
 * Created by fatimam on 2016-05-21.
 */
public interface ShopsFactory
{
    public Shops createShops(Long shopID, String shopName, String shopNumber, String road, String area, int catalog);
}