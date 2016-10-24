package za.ac.cput.www.assignment6ver2.domain;

import za.ac.cput.www.assignment6ver2.factories.implement.ProductFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Game extends ProductFactoryImpl
{
    private Product game;

    public Game(){}

    public void gameDetails(Long productID, String productName, int productGenre, double productPrice) {

        game = super.createProduct(productID,productName,productGenre,productPrice);

    }

    public double gamePrice()
    {
        return game.getPrice();
    }

    public String toString()
    {
        return game.getProductID()+" "+game.getProductName()+" "+gamePrice();
    }

}