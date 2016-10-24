package za.ac.cput.www.assignment6ver2;

import org.junit.Assert;

import za.ac.cput.www.assignment6ver2.domain.Genre;
import za.ac.cput.www.assignment6ver2.factories.implement.GendreFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class GendreFactoryImplTest {

    private GendreFactoryImpl factory=null;

    //@BeforeMethod
    public void setUp() throws Exception {
        factory = GendreFactoryImpl.getInstance();
    }

    @org.junit.Test
    public void testCreateGendre() throws Exception
    {
        Genre type = factory.createGendre(1);
        Assert.assertEquals(type.getGenre(), "Action");

    }

    public void testGendreUpdate() throws Exception
    {

        Genre type = factory.createGendre(1);
        Assert.assertEquals(type.getGenre(), "Action");

        Genre updateType = new Genre
                .Builder()
                .copy(type)
                .genreType(2)
                .build();
        Assert.assertEquals(updateType.getGenre(),"Horror");
    }
}