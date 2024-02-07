package project.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()

                    .buildSessionFactory();
        }
        return factory;
    }
}
// DAO - Data Access Object
//Repository