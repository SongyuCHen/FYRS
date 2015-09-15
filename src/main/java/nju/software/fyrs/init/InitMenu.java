package nju.software.fyrs.init;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import nju.software.fyrs.data.dataobject.Menu;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class InitMenu {
	public List<Menu> init() throws Exception
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler2 myHandler2 = new MyHandler2();
        parser.parse(new File(InitMenu.class.getResource("/menu.xml").getPath()),myHandler2);
        return myHandler2.getMenus();
    }
}
class MyHandler2 extends DefaultHandler
{
    private List<Menu> menus = new ArrayList<Menu>();
    private Menu currentMenu;
    @Override
    public void startDocument() throws SAXException
    {
        // System.out.println("startDocument---");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
       // System.out.println("-->"+qName);
       if(qName.equals("menus"))
       {
           currentMenu = new Menu();
           currentMenu.setMenuName("root");
           return;
       }
        Menu menu = new Menu();
        menu.setMenuName(attributes.getValue(0));
        menu.setMenuType(Integer.valueOf(attributes.getValue(1)));
        menu.setOrderNumber(Integer.valueOf(attributes.getValue(2)));
        menu.setHref(attributes.getValue(3));
        menu.setUniqueName(attributes.getValue(4));
        menu.setMenu(currentMenu);
        menus.add(menu);
        currentMenu = menu;
       // currentParent = menu;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        currentMenu = currentMenu.getMenu();
    }

    @Override
    public void endDocument() throws SAXException
    {

    }

    public List<Menu> getMenus()
    {
        for(Menu menu : menus)
        {
            if(menu.getMenuType() == 1 || menu.getMenuType() == 3)
            {
                menu.setMenu(null);
            }
        }
        return menus;
    }

    public static void main(String[] args) throws Exception
    {
        InitMenu initMenu = new InitMenu();
        List<Menu> menus = initMenu.init();
       System.out.println("..........................");
       for (Menu menu : menus) {
           if(null != menu.getMenu())
           {
               System.out.println(menu.getMenuName()+"--------------¸¸"+menu.getMenu().getMenuName());
           }
           else
           {
               System.out.println(menu.getMenuName());
           }

       }
    }

}
