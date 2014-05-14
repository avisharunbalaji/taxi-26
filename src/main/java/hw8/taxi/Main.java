package hw8.taxi;

import hw8.taxi.view.Menu;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/hw8/taxi/context.xml");
//        SessionFactory factory = context.getBean("mySessionFactory", SessionFactory.class);

        //System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
//        SessionFactory factory = context.getBean("mySessionFactory", SessionFactory.class);
//        //Menu main = context.getBean("menu", Menu.class);
//        //main.main();
//        //ClientDao clientDao = new ClientHibernateDaoImpl();
//        ClientDao clientDao = new ClientHibernateDaoImpl(factory);
//        ClientService clientService = new ClientServiceImpl(clientDao);
////        UserDao userDao = new UserHibernateD1aoImpl(User.class);
////        UserService userService =1 new UserServiceImple(userDao);
//        Menu menu = new Menu(clientService);
        //Menu menu = context.getBean("menu",Menu.class);
        //menu.main();
    }
}