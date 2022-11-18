package org.example;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GreetingController {

    private ProductDao productDao;
    private SessionFactoryR sessionFactory;

    @Autowired
    public GreetingController(ProductDao productDao, SessionFactoryR sessionFactory) {
        this.productDao = productDao;
        this.sessionFactory = sessionFactory;
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        Session session = null;
        session = sessionFactory.connection().getCurrentSession();
        session.beginTransaction();
        List<Product> list = productDao.findAll(session);
        model.addAttribute("productList", list);
        session.getTransaction().commit();
        return "showAll";
    }
}
