/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P3webApp;

/**
 *
 * @author laptop
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.Calendar;
import java.text.SimpleDateFormat;

@Controller

public class P3webAppController{
    
    
    
//a simple method to get today's date
public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";
public static String now() {
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
return sdf.format(cal.getTime());
}
    
//mapping starts from here
    @RequestMapping("/index")
    public String printIndex(ModelMap model) {
       return "index";
}

   @RequestMapping("/about")
    public String printHello(ModelMap model) {
      model.addAttribute("message", "<hr />" + now());
      return "about";
   }
   
   @RequestMapping("/route1")
    public ModelAndView helloWorld() {
        String message = "<br><ul><li>Java Spring</li><li>Microsoft .NET</li><li>Facebook-PHP</li><li>Google Map</li><li>Strawberry Pie!</li></ul>";
        return new ModelAndView("routeOptions", "message1", message);
    }

   @RequestMapping("/route2")
    public ModelAndView helloWorld2() {
        String message = "<br><li>Facebook-PHP</li><li>Google Map</li><li>Strawberry Pie!</li></ul>";
        return new ModelAndView("routeOptions", "message1", message);
    }

   
   

}
