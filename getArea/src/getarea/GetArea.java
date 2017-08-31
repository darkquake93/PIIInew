/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getarea;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author k1336511
 */
public class GetArea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * you need to set the application context here*
         */
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("XML/spring_config.xml");
        circle circle = (circle) ctx.getBean("shape2");
        printInfo(circle);
        
        System.out.println(Math.PI);
    }

    private static void printInfo(shape shape) {
        System.out.println(shape.getClass().getSimpleName());
        System.out.println(shape.getArea());
    }

}
