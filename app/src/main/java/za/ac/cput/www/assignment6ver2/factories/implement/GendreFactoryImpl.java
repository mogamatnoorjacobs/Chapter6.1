package za.ac.cput.www.assignment6ver2.factories.implement;

import za.ac.cput.www.assignment6ver2.domain.Genre;
import za.ac.cput.www.assignment6ver2.factories.GenreFactory;

/**
 * Created by fatimam on 2016-05-22.
 */
public class GendreFactoryImpl implements GenreFactory
{

    private static GendreFactoryImpl factory = null;

    private  GendreFactoryImpl()
    {
    }

    public static GendreFactoryImpl getInstance()
    {
        if(factory ==null)
            factory = new GendreFactoryImpl();
        return factory;
    }
    public Genre createGendre(int gendreNum)

    {
        Genre  gendreT;
        gendreT = new Genre
                .Builder()
                .genreType(gendreNum)
                .build();
        return gendreT;
    }
}

