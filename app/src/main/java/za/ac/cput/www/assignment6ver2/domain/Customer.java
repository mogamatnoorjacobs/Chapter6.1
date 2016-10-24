package za.ac.cput.www.assignment6ver2.domain;

import za.ac.cput.www.assignment6ver2.factories.implement.PersonsFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Customer extends PersonsFactoryImpl
{
    private Persons customers;
    public Customer()
    {

    }

    public void customerDetails(Long id,String name, String surname, String idNumber, String houseNumber, String road, String area, String username, String password) {

        customers = super.createPersons(id,name, surname, idNumber, houseNumber, road, area, username, password);

    }

    public String toString()
    {
        return customers.getName()+" "+customers.getSurname()+" "+customers.getUsername();
    }


}