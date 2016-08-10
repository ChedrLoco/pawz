package com.pawz.models;

import com.pawz.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by localadmin on 8/10/16.
 */
public class ShelterTest {
    @Before
    public void setUp() throws Exception {
        Session session =  Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("TRUNCATE TABLE shelters").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldShelterNewShelterAndSave() throws Exception {
       Session session =  Mysql.getSession();
        session.beginTransaction();
        Shelter s = new Shelter("shelter1", new Date(1111/11/11));
        session.save(s);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, s.getId());
    }

    @Test(expected = org.hibernate.exception.DataException.class)
    public void shouldNotCreateNewClientAndSaveNameTooLong() throws Exception {
        Session session =  Mysql.getSession();
        session.beginTransaction();
        Shelter s = new Shelter("Billisnottherealnamebecauseitistoolongtouseinheresoi'mgoingtoaddmorethingsinheretomakeitover45", new Date(1111/11/11));
        try {
            session.save(s);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }

}