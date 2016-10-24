package za.ac.cput.www.assignment6ver2.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.www.assignment6ver2.services.PersonService;

/**
 * Created by fatimam on 2016-07-16.
 */

public class PersonServiceImpl
{
    private final PersonAddressAPI api;
    private final PersonAddressRepository repo;

    private static final String ACTION_ADD = "zm.hashcode.hashdroidpvt.services.person.Impl.action.ADD";
    private static final String ACTION_UPDATE = "zm.hashcode.hashdroidpvt.services.person.Impl.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "zm.hashcode.hashdroidpvt.services.person.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "zm.hashcode.hashdroidpvt.services.person.Impl.extra.UPDATE";

    private static PersonAddressServiceImpl service = null;

    public static PersonAddressServiceImpl getInstance() {
        if (service == null)
            service = new PersonAddressServiceImpl();
        return service;
    }

    private PersonAddressServiceImpl() {
        super("PersonAddressServiceImpl");
        api = new PersonAddressAPIImpl();
        repo = new PersonAddressRepositoryImpl(App.getAppContext());
    }


    @Override
    public void addPersonAddress(Context context, PersonAddress address) {
        Intent intent = new Intent(context, PersonAddressServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, address);
        context.startService(intent);

    }

    @Override
    public void updatePersonAddress(Context context, PersonAddress address) {
        Intent intent = new Intent(context, PersonAddressServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, address);
        context.startService(intent);

    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final PersonAddress personAddress = (PersonAddress) intent.getSerializableExtra(EXTRA_ADD);
                postAddress(personAddress);
            } else if (ACTION_UPDATE.equals(action)) {
                final PersonAddress personAddress = (PersonAddress) intent.getSerializableExtra(EXTRA_UPDATE);
                updateAddress(personAddress);
            }
        }
    }

    private void updateAddress(PersonAddress personAddress) {
        //POST and Save Local
        try {
            PersonAddress updatedAddress = api.updatePersonAddress(personAddress);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(PersonAddress personAddress) {
        //POST and Save Local
        try {
            PersonAddress createdAddress = api.createPersonAddress(personAddress);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
