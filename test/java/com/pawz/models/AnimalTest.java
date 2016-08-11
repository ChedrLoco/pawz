package com.pawz.models;

import com.pawz.enums.Sex;
import com.pawz.enums.Species;
import com.pawz.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 8/11/16.
 */
public class AnimalTest {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeClass
    public static void setUp() throws Exception {
        Session session =  Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("TRUNCATE TABLE animals").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateAnimal() throws Exception {
        Session session =  Mysql.getSession();
        session.beginTransaction();
        Animal a = new Animal("Sprinkles", Sex.F, Species.Cat, format.parse("2013-02-11"));
        session.save(a);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, a.getId());
    }

    @Test
    public void shouldGetAnimal() throws Exception {
        Session session =  Mysql.getSession();
        Animal a = session.get(Animal.class, 1);
        session.close();
        assertEquals(1, a.getId());
    }

    @Test
    public void shouldDeleteAnimal() throws Exception {
        Session session =  Mysql.getSession();
        Animal a = session.get(Animal.class, 1);
        assertEquals(1, a.getId());
        session.beginTransaction();
        session.delete(a);
        Animal a_del = session.get(Animal.class, 1);
        session.getTransaction().commit();
        session.close();
        assertNull(a_del);
    }

}