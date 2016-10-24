package za.ac.cput.www.assignment6ver2.services;


import android.content.Context;

import za.ac.cput.www.assignment6ver2.domain.Persons;

/**
 * Created by fatimam on 2016-07-16.
 */
public interface PersonService
{
    void addPersonAddress(Context context, Persons address);

    void updatePersonAddress(Context context, Persons address);
}
