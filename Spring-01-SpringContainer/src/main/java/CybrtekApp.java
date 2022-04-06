import interfaces.Mentor;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybrtekApp {
    public static void main(String[] args) {

//        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

//        Class as argument
        Mentor mentor = container.getBean("fullTimeMentor", Mentor.class);
//        Casting the Class
        Mentor mentor1 = (Mentor) container.getBean("partTimeMentor");

        mentor.createAccount();
        mentor1.createAccount();
    }
}
