package za.ac.cput.www.assignment6ver2.domain;

import android.database.sqlite.SQLiteOpenHelper;

import za.ac.cput.www.assignment6ver2.repository.PersonsRespository;
import za.ac.cput.www.assignment6ver2.repository.ProductRepository;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Product
{
    private Long productID;
    private String productName;
    private String productGenre;
    private double price=0.00;


    public Product(){}

    public Long getProductID()
    {
        return productID;
    }

    public String getProductName()
    {
        return productName;
    }

    public String getProductGenre()
    {
        return productGenre;
    }

    public double getPrice()
    {
        return price;
    }

    private Product (Builder builder)
    {
        this.productID=builder.productID;
        this.productName=builder.productName;
        this.productGenre=builder.productGenre;
        this.price=builder.price;
    }


    public static class Builder
    {
        private Long productID;
        private String productName;
        private String productGenre;
        private double price=0.00;




        public Builder prodID(Long value) {
            this.productID = value;
            return this;
        }

        public Builder prodName(String value)
        {
            this.productName=value;
            return this;
        }

        public Builder prodGenre(int value)
        {
            Genre genre=new Genre.Builder()
                    .genreType(value)
                    .build();
            this.productGenre=genre.getGenre();
            return this;
        }

        public Builder prodPrice(double value)
        {
            this.price=value;
            return this;
        }

        public Builder copy(Product value)
        {
            this.productID=value.productID;
            this.productName=value.productName;
            this.productGenre=value.productGenre;
            this.price=value.price;
            return this;
        }

        public Product build()
        {
            return new Product(this);
        }

    }
}
