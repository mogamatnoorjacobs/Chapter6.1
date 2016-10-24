package za.ac.cput.www.assignment6ver2.domain;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Catalog
{
    private static String type1="Movies";
    private static String type2="Movies and Games";

    private String catalogSelection;

    public Catalog()
    {

    }
    public Catalog(int cat)
    {
        if(cat==1) {
            catalogSelection = type1;
        }
        else {
            catalogSelection = type2;
        }
    }

    public void setCatalog(int cat)
    {
        if(cat==1)
            catalogSelection=type1;
        else
            catalogSelection=type2;

    }

    public String getCatalogSelection()
    {
        return catalogSelection;
    }



}
