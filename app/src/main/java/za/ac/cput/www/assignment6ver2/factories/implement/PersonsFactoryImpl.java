package za.ac.cput.www.assignment6ver2.factories.implement;

import za.ac.cput.www.assignment6ver2.domain.Persons;
import za.ac.cput.www.assignment6ver2.factories.PersonsFactory;

/**
 * Created by fatimam on 2016-05-22.
 */
public class PersonsFactoryImpl implements PersonsFactory
{

    private static PersonsFactoryImpl factory = null;

    public  PersonsFactoryImpl() {
    }
    public static PersonsFactoryImpl getInstance()
    {
        if(factory ==null)
            factory = new PersonsFactoryImpl();
        return factory;
    }

    public Persons createPersons(Long id,String name, String surname, String idNumber, String houseNumber, String road, String area, String username, String password)
    {
        Persons  persons = new Persons
                .Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .idNumber(idNumber)
                .houseNum(houseNumber)
                .roadName(road)
                .areaName(area)
                .userName(username)
                .passWord(password)
                .build();
        return persons;
    }


}