package com.pawz.models;

import com.pawz.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 8/10/16.
 */
public class ClientTest {
    @Before
    public void setUp() throws Exception {
        Session session =  Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("TRUNCATE TABLE clients").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewClientAndSave() throws Exception {
       Session session =  Mysql.getSession();
        session.beginTransaction();
        Client c = new Client("Bill");
        session.save(c);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, c.getId());
    }

    @Test(expected = org.hibernate.exception.DataException.class)
    public void shouldNotCreateNewClientAndSaveNameTooLong() throws Exception {
        Session session =  Mysql.getSession();
        session.beginTransaction();
        Client c = new Client("Billisnottherealnamebecauseitistoolongtouseinheresoi'mgoingtoaddmorethingsinheretomakeitover45324234234242343");
        try {
            session.save(c);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }

}