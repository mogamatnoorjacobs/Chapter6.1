package za.ac.cput.www.assignment6ver2.factories.implement;

import za.ac.cput.www.assignment6ver2.domain.Product;
import za.ac.cput.www.assignment6ver2.factories.ProductFactory;

/**
 * Created by fatimam on 2016-05-22.
 */
public class ProductFactoryImpl implements ProductFactory
{

    private static ProductFactoryImpl factory = null;

    public  ProductFactoryImpl() {
    }

    public static ProductFactoryImpl getInstance()
    {
        if(factory ==null)
            factory = new ProductFactoryImpl();
        return factory;
    }

    public Product createProduct(Long productID, String productName, int productGenre, double productPrice)
    {
        Product  product = new Product
                .Builder()
                .prodID(productID)
                .prodName(productName)
                .prodGenre(productGenre)
                .prodPrice(productPrice)
                .build();
        return product;
    }
}