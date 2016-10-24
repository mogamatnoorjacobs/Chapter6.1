package za.ac.cput.www.assignment6ver2;

import junit.framework.Assert;

import za.ac.cput.www.assignment6ver2.domain.Persons;
import za.ac.cput.www.assignment6ver2.factories.PersonsFactory;
import za.ac.cput.www.assignment6ver2.factories.implement.PersonsFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class PersonsFactoryImplTest {

    private PersonsFactory factory;

    //@BeforeMethod
    public void setUp() throws Exception {
        factory = PersonsFactoryImpl.getInstance();
    }

    @org.junit.Test
    public void testCreatePersons() throws Exception
    {
        Persons role = factory.createPersons((long) 1236589522d,"Noor", "Jacobs", "9209152354532", "26", "Hazendal rd", "Athlone", "noor", "jac2365");
        Assert.assertEquals(role.getName(), "Noor");
        Assert.assertEquals(role.getSurname(), "Jacobs");
        Assert.assertNotNull(role.getIDNumber(), "9209152354532");
        Assert.assertEquals(role.getHouseNumber(), "26");
        Assert.assertEquals(role.getRoad(), "Hazendal rd");
        Assert.assertEquals(role.getArea(), "Athlone");
        Assert.assertEquals(role.getUsername(), "noor");
        Assert.assertEquals(role.getPassword(), "jac2365");

    }

    public void testPersonsUpdate() throws Exception {
        Persons role = factory.createPersons((long) 123,"Noor", "Jacobs", "9209152354532", "26", "Hazendal rd", "Athlone", "noor", "jac2365");
        Assert.assertEquals(role.getName(), "Noor");
        Assert.assertEquals(role.getSurname(), "Jacobs");
        Assert.assertNotNull(role.getIDNumber(), "9209152354532");
        Assert.assertEquals(role.getHouseNumber(), "26");
        Assert.assertEquals(role.getRoad(), "Hazendal rd");
        Assert.assertEquals(role.getArea(), "Athlone");
        Assert.assertEquals(role.getUsername(), "noor");
        Assert.assertEquals(role.getPassword(), "jac2365");

        Persons updateRole = new Persons.Builder()
                .copy(role)
                .roadName("Athlone rd")
                .build();

        Assert.assertEquals(updateRole.getRoad(), "Athlone rd");
        Assert.assertEquals(role.getName(), updateRole.getName());
        Assert.assertEquals(role.getSurname(), updateRole.getSurname());
        Assert.assertNotNull(role.getIDNumber(), updateRole.getIDNumber());
        Assert.assertEquals(role.getHouseNumber(), updateRole.getHouseNumber());
        Assert.assertEquals(role.getArea(), updateRole.getArea());
        Assert.assertEquals(role.getUsername(), updateRole.getUsername());
        Assert.assertEquals(role.getPassword(), updateRole.getPassword());
    }

}