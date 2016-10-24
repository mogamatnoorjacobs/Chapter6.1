package za.ac.cput.www.assignment6ver2.factories;

import za.ac.cput.www.assignment6ver2.domain.Product;

/**
 * Created by fatimam on 2016-05-21.
 */
public interface ProductFactory
{
    public Product createProduct(Long productID, String productName, int productGenre, double productPrice);
}

