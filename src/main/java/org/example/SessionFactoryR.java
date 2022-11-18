package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
@Component
public class SessionFactoryR {

    public SessionFactory connection() {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        return sessionFactory;
    }


}
