package de.ayr.laserdb.common.services.login.control;

import javax.ejb.Stateful;

import com.google.inject.ImplementedBy;

//    @Local
    @Stateful
    @ImplementedBy(DataStore.class)
    public interface DataStoreLocal {

            public String getData();
}
    

