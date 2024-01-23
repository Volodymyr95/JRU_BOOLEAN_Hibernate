import com.entity.User;
import com.entity.UserTask;
import config.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    public static void main(String[] args) {
        Session currentSession = factory.openSession();
        User user = currentSession.find(User.class, 8L);

        user.getAddress()
                .getCity();
        currentSession.close();

    }

    private static void saveExample(Session session) {
        User bohdan = new User("Bohdan", 20);
        session.save(bohdan);
        session.close();
        System.out.println("END!");
    }

    private static void saveWithIdExample(Session session) {
        User bohdan = new User("Bohdan", 22);
        bohdan.setId(2L);
        session.save(bohdan);
        session.close();
        System.out.println("END!");
    }

    private static void saveWithUpdateExample(Session session) {
        Transaction transaction = session.beginTransaction();
        User bohdan = session.find(User.class, 2L);
        bohdan.setAge(45);
        session.save(bohdan); // make update only for persisted. for transient only insert
        transaction.commit();
        session.close();
    }

    private static void persistWithUpdateExample(Session session) {
        Transaction transaction = session.beginTransaction();
        User bohdan = session.find(User.class, 12L);
        bohdan.setAge(40);
        session.persist(bohdan); // make update only for persisted. for transient only insert
        transaction.commit();
        session.close();
    }

    private static void mergeWithUpdateExample(Session session) {
        Transaction transaction = session.beginTransaction();
        User bob = new User("Nick", 30);
        bob.setId(22L);
        session.merge(bob);
        transaction.commit();
        session.close();
    }

    private static void saveOrUpdateWithUpdateExample(Session session) {
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, 2L);
        // User bob = new User("Bob", 48);
        user.setName("Den");
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    private static void refreshExample(Session session) {
        Transaction transaction = session.beginTransaction();
        User bob = new User("Taras", 48);
        session.persist(bob);
        session.refresh(bob);
        System.out.println(session.find(User.class, 12L));
        transaction.commit();
        session.close();
    }

    private static void createUserTask(Session session) {
        UserTask userTask = new UserTask();
        userTask.setUser(session.find(User.class, 3L));
        userTask.setName("Task");
        session.save(userTask);
        session.close();
    }

    private static void cascadeTaskDelete(Session session) {
        Transaction transaction = session.beginTransaction();
        session.remove(session.find(User.class, 3L));
        transaction.commit();
        session.close();
    }

    private static void hqlDelete(Session session, Long id) {
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
    }

    private static void nativeDelete(Session session, Long id) {
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE from user where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
    }

}
