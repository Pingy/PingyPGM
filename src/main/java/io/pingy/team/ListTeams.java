package io.pingy.team;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by thlappy on 10/15/2016.
 */
public class ListTeams {
    public static void listTeams() {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("c:\\file.xml");

        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            //String authorContribution = rootNode.getChild("teams").getChild("team").getChildText();
            List list = rootNode.getChildren("staff");

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);
                System.out.println("First Name : " + node.getChildText("firstname"));
                System.out.println("Last Name : " + node.getChildText("lastname"));
                System.out.println("Nick Name : " + node.getChildText("nickname"));
                System.out.println("Salary : " + node.getChildText("salary"));

            }

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }
}
