import com.criteria.dao.UserDao;
import com.entity.User;
import com.entity.UserTask;
import config.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateMain {
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    public static void main(String[] args) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
//        UserTask userTask = new UserTask();
//        userTask.setName("fix a bug");
//        userTask.setUser(session.find(User.class, 3L));
//        session.save(userTask);
//        transaction.commit();
        UserDao userDao = new UserDao(session);
        userDao.selectUserDtos();
        transaction.commit();

    }
}
