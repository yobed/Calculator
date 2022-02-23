package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Creates the about window for the fragile window.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author team05
 * @version V1
 */
public class AboutWindow extends JFrame 
{
  private static final long serialVersionUID = 1L;
  private int displaySizeX = 150;
  private int displaySizeY = 150;
  private JLabel text;
  private Container contentPane;
  private final String htmlStart = "<html>";
  private final String htmlEnd = "</html>";
  private final String breakLine = "<br/>";
  private final String english = 
      htmlStart
      + "Fragile is a calculator that allows you to "
      + "manipulate mixed fractions.\n"
      + breakLine
      + "- Enter mixed fractions using the interface and an actual keyboard.\n"
      + breakLine
      + "- Perform basic operations (e.g., addition, subtraction,\n"
      + " multiplication and division) on mixed fractions.\n"
      + breakLine
      + "- Perform advanced/sophisticated operations on mixed fractions.\n"
      + breakLine
      + "The help is located on the website (Help>Website)."
      + htmlEnd;
  private final String spanish = 
      htmlStart
      + "Fragile es una calculadora que te permite"
      + " manipular fracciones mixtas.\n"
      + breakLine
      + "- Ingrese fracciones mixtas usando la interfaz y un teclado real.\n"
      + breakLine
      + "- Realizar operaciones básicas (por ejemplo, suma, resta,\n"
      + " multiplicación y división) en fracciones mixtas.\n"
      + breakLine
      + "- Realizar operaciones avanzadas / sofisticadas en fracciones mixtas.\n"
      + breakLine
      + "La ayuda se encuentra en el sitio web (Ayuda> Sitio web)."
      + htmlEnd;
  private final String french = 
      htmlStart
      + "Fragile est une calculatrice "
      + "qui vous permet de manipuler des fractions mixtes.\n"
      + breakLine
      + "- Entrez des fractions mixtes à l'aide de l'interface et d'un clavier réel.\n"
      + breakLine
      + "- Effectuer des opérations de base (par exemple, addition, soustraction,\n"
      + " multiplication et division) sur les fractions mixtes.\n"
      + breakLine
      + "- Effectuer des opérations avancées/sophistiquées sur des fractions mixtes.\n"
      + breakLine
      + "L'aide se trouve sur le site Web (Aide>Site Web)."
      + htmlEnd;
  private String curr = english;
  
  /**
   * AboutWindow Constructor.
   */
  public AboutWindow() 
  {
    super();
    setupLayout();
  }
  
  private void setupLayout()
  {
    // sets up content pane
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    setSize(displaySizeX, displaySizeY);
    setTitle("About");
    setAlwaysOnTop(true);
    // sets up the image
    ImageIcon logo = new ImageIcon(getClass().getResource("Fragile_Icon_32x32.png"));
    JLabel imgLabel = new JLabel(logo);
    imgLabel.setPreferredSize(new Dimension(32, 32));
    contentPane.add(imgLabel, BorderLayout.NORTH);
    this.setIconImage(logo.getImage());
    this.text = new JLabel();
    this.text.setText(curr);
    contentPane.add(text, BorderLayout.CENTER);
    contentPane.setPreferredSize(new Dimension(250,250));
    
    
    pack();
  }
  
  /**
   * Updates text to language.
   * @param lang (0 - english, 1 - spanish, 2 - french)
   */
  public void updateLanguage(final int lang) 
  {
    if (lang == 0)
    {
      this.text.setText(english);
      setTitle("About Window");
    }
    if (lang == 1)
    {
      this.text.setText(spanish);
      setTitle(MultipleLanguages.SPANISHABOUT);
    }
    if (lang == 2)
    {
      this.text.setText(french);
      setTitle(MultipleLanguages.FRENCHABOUT);
    }
  }

}
