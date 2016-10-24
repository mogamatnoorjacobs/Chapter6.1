package za.ac.cput.www.assignment6ver2.factories;

import za.ac.cput.www.assignment6ver2.domain.Persons;

/**
 * Created by fatimam on 2016-05-21.
 */
public interface PersonsFactory
{
    public Persons createPersons(Long id,String name, String surname, String idNumber, String houseNumber, String road, String area, String username, String password);
}
