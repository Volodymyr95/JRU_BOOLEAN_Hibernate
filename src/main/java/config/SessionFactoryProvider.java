package config;

import com.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(UserTask.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Role.class)
                    .addAnnotatedClass(Passport.class)
                    //.addPackage("com/entity")
                    .buildSessionFactory();
        }
        return factory;
    }
}
