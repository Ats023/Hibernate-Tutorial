package com.ats;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.Set;

import org.hibernate.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Department d1 = new Department();
        Department d2 = new Department();
        Project p1 = new Project();

        e1.setFirstName("JJ");
        e1.setLastName("Abrams");
        e1.setSalary(1200000);
        e1.setDept(d2);

        e2.setFirstName("Roe");
        e2.setLastName("Jones");
        e2.setSalary(1500000);
        e1.setDept(d1);

        d1.setDeptName("Accounts");
        d1.setDeptHead(e2);

        d2.setDeptName("Development");
        d2.setDeptHead(e1);

        p1.setProjTitle("PROD12_0CS");

        e1.addProjectToEmployee(p1);
        e2.addProjectToEmployee(p1);
        p1.assignToProject(e1);
        p1.assignToProject(e2);

        SessionFactory sf = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class).addAnnotatedClass(Department.class).buildSessionFactory();
        // .addAnnotatedClass(Employee.class)
        // .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost/example")
        // .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "user")
        // .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "pass")
        // .setProperty(AvailableSettings.SHOW_SQL, true);

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(p1);
        session.persist(e1);
        session.persist(e2);
        session.persist(d1);
        session.persist(d2);
        transaction.commit();
        Project proj = session.get(Project.class,1);
        System.out.println(proj.getProjTitle());
        for(Employee e: proj.getAssignedTo()) {
            System.out.println("Employee ID: "+e.getId());
            System.out.println("Employee Name: "+e.getFirstName()+" "+e.getLastName());
        }
        session.close();
        sf.close();
    }
}
