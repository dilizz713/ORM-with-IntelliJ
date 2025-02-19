import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.List;

public class Main {
    private static FactoryConfiguration factoryConfiguration;

    public static void main(String[] args) {
        factoryConfiguration = FactoryConfiguration.getInstance();

        Customer customer1 = new Customer(1, "Dilini", "dilini@gmail.com", "07012412031");
        Customer customer2 = new Customer(2, "Kamal", "kamal@gmail.com", "0754120123");
        Customer customer3 = new Customer(3, "Sunil", "sunil@gmail.com", "0765412301");
        Customer customer4 = new Customer(4, "Pawani", "pawani@gmail.com", "0712563245");
        Customer customer5 = new Customer(5, "Umair", "umair@gmail.com", "070552412362");

        /*saveCustomer(customer1);
        saveCustomer(customer2);
        saveCustomer(customer3);
        saveCustomer(customer4);
        saveCustomer(customer5);*/

        System.out.println("Customer : " + getCustomerById(customer4.getId()));

        //deleteCustomer(customer5.getId());

        Customer customer = new Customer(4, "Malith", "malith@gmail.com", "070552412362");
        updateCustomer(customer);

        List<Customer> allCustomers = getAllCustomers();
        for (Customer customers : allCustomers) {
            System.out.println(customers);
        }


    }

    public static boolean saveCustomer(Customer customer) {
        Session session = factoryConfiguration.getSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static Customer getCustomerById(int id) {
        Session session = factoryConfiguration.getSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public static boolean deleteCustomer(int id) {
        Session session = factoryConfiguration.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     /*public static boolean updateCustomer(int id, Customer newCustomerData) {
        Session session = factory.getSession();
        try {
            Customer customerById = session.get(Customer.class, id);
            Transaction transaction = session.beginTransaction();

            customerById.setName(newCustomerData.getName());
            customerById.setEmail(newCustomerData.getEmail());
            customerById.setPhone(newCustomerData.getPhone());
//            session.update(newCustomerData); don't use
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fail to update customer");
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }*/

    public static boolean updateCustomer(Customer customer) {
        Session session = factoryConfiguration.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<Customer> getAllCustomers() {
        Session session = factoryConfiguration.getSession();

        //HQL - hibernate query language
        List<Customer> customers = session.createCriteria(Customer.class).list();
        session.close();
        return customers;
    }
}