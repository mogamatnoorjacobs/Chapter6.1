package za.ac.cput.www.assignment6ver2.domain;

import za.ac.cput.www.assignment6ver2.factories.implement.ProductFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Movie extends ProductFactoryImpl
{
    public Movie()
    {}

    private Product movie;


    public void movieDetails(Long productID, String productName, int productGenre, double productPrice) {

        movie = super.createProduct(productID,productName,productGenre,productPrice);

    }

    public double moviePrice()
    {
        return movie.getPrice();
    }

    public String toString()
    {
        return movie.getProductID()+" "+movie.getProductGenre()+" "+movie.getProductName()+" "+movie.getPrice();
    }

}