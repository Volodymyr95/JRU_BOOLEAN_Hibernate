package config;

import com.dto.UserDto;
import com.entity.*;
import com.entity.inheritance.Developer;
import com.entity.inheritance.Manager;
import com.entity.single_table_strategy.CryptoProduct;
import com.entity.single_table_strategy.DigitalProduct;
import com.entity.single_table_strategy.PhysicalProduct;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(UserTask.class)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Comment.class)
                    .addAnnotatedClass(CashedUser.class)
                    .addAnnotatedClass(Developer.class)
                    .addAnnotatedClass(Manager.class)
                    .addAnnotatedClass(PhysicalProduct.class)
                    .addAnnotatedClass(DigitalProduct.class)
                    .addAnnotatedClass(CryptoProduct.class)
                    //.addPackage("com/entity")
                    .buildSessionFactory();
        }
        return factory;
    }
}
