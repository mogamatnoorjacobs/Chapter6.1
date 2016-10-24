package za.ac.cput.www.assignment6ver2.domain;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Shops
{
    private Long shopID;
    private String shopName;
    private String shopNumber;
    private String road;
    private String area;
    private String catalog;
    private Long id;


    public Shops(){}

    public Long getShopID()
    {
        return shopID;
    }

    public String getShopName()
    {
        return shopName;
    }

    public String getShopNumber()
    {
        return shopNumber;
    }

    public String getRoad()
    {
        return road;
    }

    public String getArea()
    {
        return area;
    }

    public String getCatalog()
    {
        return catalog;
    }

    private Shops(Builder builder)
    {
        this.shopID=builder.shopID;
        this.shopName=builder.shopName;
        this.shopNumber=builder.shopNumber;
        this.road=builder.road;
        this.area=builder.area;
        this.catalog=builder.catalog;
    }

    //*************Builder***********************

    public static class Builder
    {
        private Long shopID;
        private String shopName;
        private String shopNumber;
        private String road;
        private String area;
        private String catalog;
        private Catalog catalogs;

        public Builder shopsID(Long value)
        {
            this.shopID=value;
            return this;
        }

        public Builder name(String value)
        {
            this.shopName=value;
            return this;
        }

        public Builder numberAddress(String value)
        {
            this.shopNumber=value;
            return this;
        }
        public Builder roadName(String value)
        {
            this.road=value;
            return this;
        }

        public Builder areaName(String value)
        {
            this.area=value;
            return this;
        }

        public Builder catalogOption(int value)
        {
            catalogs=new Catalog(value);
            this.catalog=catalogs.getCatalogSelection();
            return this;
        }

        public Builder copy(Shops value)
        {
            this.shopID= value.shopID;
            this.shopName=value.shopName;
            this.shopNumber=value.shopNumber;
            this.road=value.road;
            this.area=value.area;
            this.catalog=value.catalog;

            return this;
        }

        public Shops build()
        {
            return new Shops(this);
        }




    }
}
