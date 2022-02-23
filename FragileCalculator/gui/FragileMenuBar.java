package gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Creates the menu bar for the fragile window.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author team05
 * @version V1
 */
public class FragileMenuBar extends JMenuBar
{

  private static String solidus = "Solidus";
  private static String bar = "Bar";
  private static ArrayList<JMenuItem> items;
  private static ArrayList<JMenu> menus;
  private static ArrayList<String> spanishItems;
  private static ArrayList<String> spanishMenus;
  private static ArrayList<String> englishItems;
  private static ArrayList<String> englishMenus;
  private static ArrayList<String> frenchItems;
  private static ArrayList<String> frenchMenus;
  private static int currLang;
  private static final long serialVersionUID = 1L;
  private ActionListener obs;
  

  /**
   * FragileMenuBar constructor.
   * @param obs
   */
  public FragileMenuBar(final Observer obs) 
  {
    this.obs = obs;
    menus = new ArrayList<>();
    items = new ArrayList<>();
    
    spanishItems = setupSpanishItems();
    spanishMenus = setupSpanishMenus();
    frenchItems = setupFrenchItems();
    frenchMenus = setupFrenchMenus();
    
    setupLayout();
  }
  
  /**
   * Creates an arrayList of strings for translation.
   * @return ArrayList
   */
  private ArrayList<String> setupSpanishItems() 
  {
    ArrayList<String> result = new ArrayList<>();
    result.add(MultipleLanguages.SPANISHSLASH);
    result.add(bar);
    result.add(MultipleLanguages.SPANISHREDUCED);
    result.add(MultipleLanguages.SPANISHIRREDUCED);
    result.add(MultipleLanguages.SPANISHSTART);
    result.add(MultipleLanguages.SPANISHSAVE);
    result.add(MultipleLanguages.SPANISHSTOP);
    result.add(MultipleLanguages.SPANISHLOAD);
    result.add(MultipleLanguages.SPANISHPRINTSCREEN);
    result.add(MultipleLanguages.SPANISHSHOWHISTORY);
    result.add(MultipleLanguages.SPANISHBUTTONCOLORS);
    result.add(MultipleLanguages.SPANISHBACKGROUNDCOLORS);
    result.add(MultipleLanguages.SPANISHABOUT);
    result.add(MultipleLanguages.SPANISHWEBSITE);
    result.add(MultipleLanguages.SPANISHENGLISH);
    result.add(MultipleLanguages.SPANISHFRENCH);
    result.add(MultipleLanguages.SPANISHSPANISH);
    return result;
    
  }
  
  /**
   * Creates an arrayList of strings for translation.
   * @return ArrayList
   */
  private ArrayList<String> setupSpanishMenus() 
  {
    ArrayList<String> result = new ArrayList<>();
    result.add(MultipleLanguages.SPANISHSTYLE);
    result.add(MultipleLanguages.SPANISHFORM);
    result.add(MultipleLanguages.SPANISHRECORD);
    result.add(MultipleLanguages.SPANISHPRINT);
    result.add(MultipleLanguages.SPANISHHISTORY);
    result.add(MultipleLanguages.SPANISHCOLORS);
    result.add(MultipleLanguages.SPANISHHELP);
    result.add(MultipleLanguages.SPANISHLANGUAGES);
    return result;
  }
  
  /**
   * Creates an arrayList for FrenchItems.
   * @return ArrayList
   */
  private ArrayList<String> setupFrenchItems() 
  {
    ArrayList<String> result = new ArrayList<>();
    result.add(MultipleLanguages.FRENCHSLASH);
    result.add(bar);
    result.add(MultipleLanguages.FRENCHREDUCED);
    result.add(MultipleLanguages.FRENCHIRREDUCED);
    result.add(MultipleLanguages.FRENCHSTART);
    result.add(MultipleLanguages.FRENCHSAVE);
    result.add(MultipleLanguages.FRENCHSTOP);
    result.add(MultipleLanguages.FRENCHLOAD);
    result.add(MultipleLanguages.FRENCHPRINTSCREEN);
    result.add(MultipleLanguages.FRENCHSHOWHISTORY);
    result.add(MultipleLanguages.FRENCHBUTTONCOLORS);
    result.add(MultipleLanguages.FRENCHBACKGROUNDCOLORS);
    result.add(MultipleLanguages.FRENCHABOUT);
    result.add(MultipleLanguages.FRENCHWEBSITE);
    result.add(MultipleLanguages.FRENCHENGLISH);
    result.add(MultipleLanguages.FRENCHFRENCH);
    result.add(MultipleLanguages.FRENCHSPANISH);
    return result;
    
  }
  
  /**
   * Creates an arrayList for FrenchMenus.
   * @return ArrayList
   */
  private ArrayList<String> setupFrenchMenus() 
  {
    ArrayList<String> result = new ArrayList<>();
    result.add(MultipleLanguages.FRENCHSTYLE);
    result.add(MultipleLanguages.FRENCHFORM);
    result.add(MultipleLanguages.FRENCHRECORD);
    result.add(MultipleLanguages.FRENCHPRINT);
    result.add(MultipleLanguages.FRENCHHISTORY);
    result.add(MultipleLanguages.FRENCHCOLORS);
    result.add(MultipleLanguages.FRENCHHELP);
    result.add(MultipleLanguages.FRENCHLANGUAGES);
    return result;
  }
  
  /**
   * Sets up layout.
   */
  private void setupLayout()
  {
    englishItems = new ArrayList<>();
    englishMenus = new ArrayList<>();
    JMenu menu;
    JMenuItem item;
    menu = new JMenu("Style");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    
    item = new JMenuItem("Slash");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    item = new JMenuItem(bar);
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    // now do form spec.
    menu = new JMenu("Form");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    
    item = new JMenuItem("Reduced");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    item = new JMenuItem("Irreduced");
    menu.add(item);
    item.addActionListener(obs);
    items.add(item);
    englishItems.add(item.getText());
    
    // now do save
    menu = new JMenu ("Record");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    
    item = new JMenuItem ("Start");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    item = new JMenuItem ("Save");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    item = new JMenuItem ("Stop");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    item = new JMenuItem("Load");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    // now do print
    menu = new JMenu ("Print");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    item = new JMenuItem ("Print Screen");
    menu.add(item);
    items.add(item);
    item.addActionListener(obs);
    englishItems.add(item.getText());
    // now do History
    menu = new JMenu ("History");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    item = new JMenuItem ("Show History");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    // Configure Colors menu
    menu = new JMenu("Colors");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    item = new JMenuItem("Button Colors");
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    item.addActionListener(obs);
    item = new JMenuItem("Background Colors");
    menu.add(item);
    item.addActionListener(obs);
    items.add(item);
    englishItems.add(item.getText());
    
    //Help menu config
    menu = new JMenu("Help");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    
    item = new JMenuItem("About");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    item = new JMenuItem("Website");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    
    //language menu config
    menu = new JMenu("Languages");
    add(menu);
    menus.add(menu);
    englishMenus.add(menu.getText());
    // reverts gui back to english
    item = new JMenuItem("English");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    item = new JMenuItem("French");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
    item = new JMenuItem("Spanish");
    item.addActionListener(obs);
    menu.add(item);
    items.add(item);
    englishItems.add(item.getText());
  }
  
  /**
   * Updates all the menu to specified language.
   * @param n (0 - english, 1 -spanish, 2- french)
   */
  public static void updateMenu(final int n)
  {
    currLang = n;
    updateItems();
    updateMenus();
    
  }
  
  /**
   * Updates menuItems.
   */
  private static void updateItems() 
  {
    int index = 0;
    for (JMenuItem item : items) 
    {

      if (currLang == 1) // spanish
      {
        item.setText(spanishItems.get(index));
      }
      if (currLang == 0) // english
      {
        item.setText(englishItems.get(index));
      }
      if (currLang == 2) // french
      {
        item.setText(frenchItems.get(index));
      }
      index += 1;
    }
    
  }
  
  /**
   * Updates Menus.
   */
  private static void updateMenus() 
  {
    int index = 0;
    for (JMenu item : menus) 
    {
      if (currLang == 1) // spanish
      {
        item.setText(spanishMenus.get(index));
      }
      if (currLang == 0) // english
      {
        item.setText(englishMenus.get(index));
      }
      if (currLang == 2) // french
      {
        item.setText(frenchMenus.get(index));
      }
      index += 1;
    }
  }
}
