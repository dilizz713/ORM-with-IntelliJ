import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

public class Main {
   private static FactoryConfiguration factoryConfiguration;

    public static void main(String[] args) {
        factoryConfiguration = FactoryConfiguration.getInstance();

        Customer customer1 = new Customer(1,"Dilini","dilini@gmail.com","07012412031");
        saveCustomer(customer1);

    }
    public static boolean saveCustomer(Customer customer){
        Session session = factoryConfiguration.getSession();

        try{
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }finally{
            if(session != null){
                session.close();
            }
        }
    }
}