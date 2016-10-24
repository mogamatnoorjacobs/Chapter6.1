package za.ac.cput.www.assignment6ver2;

import org.junit.Assert;

import za.ac.cput.www.assignment6ver2.domain.Product;
import za.ac.cput.www.assignment6ver2.factories.ProductFactory;
import za.ac.cput.www.assignment6ver2.factories.implement.ProductFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class ProductFactoryImplTest {

    private ProductFactory factory;
    //@BeforeMethod
    public void setUp() throws Exception {
        factory = ProductFactoryImpl.getInstance();
    }

    @org.junit.Test
    public void testCreateProduct() throws Exception
    {
        Product type=factory.createProduct((long) 213213,"Matrix",1,10.00);
        Assert.assertEquals(type.getProductID(),"mv123");
        Assert.assertEquals(type.getProductName(),"Matrix");
        Assert.assertEquals(type.getProductGenre(),"Action");
        Assert.assertEquals(type.getPrice(),10.00);

    }


}