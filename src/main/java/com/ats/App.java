package com.ats;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        // .addAnnotatedClass(Employee.class)
        // .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost/example")
        // .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "user")
        // .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "pass")
        // .setProperty(AvailableSettings.SHOW_SQL, true);

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Employee emp = (Employee)session.find(Employee.class, 1);
        System.out.println(emp.getFirstName());
        transaction.commit();
        session.close();
        sf.close();
    }
}
