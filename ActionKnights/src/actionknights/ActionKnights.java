/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionknights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author k1336511
 */
public class ActionKnights {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws QuestException {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("XML/knightXMLConfig.xml");

        Knight knight = (Knight) context.getBean("knight");
        Knight sKnight = (Knight) context.getBean("slayerKnight");
        Knight rKnight = (Knight) context.getBean("rounderKnight");
        
        

        knight.embarkOnQuest();
        sKnight.embarkOnQuest();
        rKnight.embarkOnQuest();
    }

}
