/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldspring;

//Imports for the Hello interface and Spring Framework libraries
import com.hello.Hello;
import  org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author K1336511
 */
public class HelloWorldSpring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instantiates a new ApplicationContext type variable, which gives the application a context of spring-confix.xml
        ApplicationContext ctx =                                                                                
            new ClassPathXmlApplicationContext("spring-config.xml");
        //Instantiates a new Hello type variable and calls the sayHello method, using the previous ApplicationContext variable, and 
Hello helloBean =  (Hello) ctx.getBean("helloBean");

helloBean.sayHello("we are Springing!");

    }
    
}
