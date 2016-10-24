package za.ac.cput.www.assignment6ver2.domain;

import za.ac.cput.www.assignment6ver2.factories.implement.PersonsFactoryImpl;

/**
 * Created by fatimam on 2016-05-22.
 */
public class Staff  extends PersonsFactoryImpl
{

    private Persons staff;


    public Staff()
    {

    }
    public void staffDetails(Long id,String name, String surname, String idNumber, String houseNumber, String road, String area, String username, String password) {

        staff = super.createPersons(id,name, surname, idNumber, houseNumber, road, area, username, password);

    }

    public String toString()
    {
        return staff.getUsername();
    }

}
