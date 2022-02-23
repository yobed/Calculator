package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates the HTML help page explaining how to use the fragile product.
 * 
 * @author team05
 */
public class Html 
{

  private static File file = null;


  /**
   * Creates an HTML file for Fragile.
   * @param args
   */
  public static void main(final String[] args)
  {
    
    String head = "";
    String faq = "";
    String question1 = "";
    String answer1 = "";
    String question2 = "";
    String answer2 = "";
    String question3 = "";
    String answer3 = "";
    String question4 = "";
    String answer4 = "";
    String question5 = "";
    String answer5 = "";
    String question6 = "";
    String answer6 = "";
    String question7 = "";
    String answer7 = "";
    String question8 = "";
    String answer8 = "";
    int lang = Observer.getCurrLang();
    if (lang == 0) 
    {
      head = "<div><h1>Help Page</h1></div>";
      faq = "<div><h2><b>Frequently Asked Questions</b></h2></div>";

      question1 = "<div><b>How Do I E"
          + "nter The Numerator And Denominator Of The Fraction?</b></div>";
      answer1 = "<div><details>The p"
          + "eriod key, or the focus button beside the zero button, will"
          + " allow the user to cycle through th"
          + "e whole, numerator, and denominator portions of the "
          + "fraction.</details></div>";

      question2 = "<div><b>How Do I Change The Form Of My Fraction?</b></div>";
      answer2 = "<div><details><o"
          + "l><li>There is a menu bar at the top of the program with a section ti"
          + "tled Form.</li><li>From h"
          + "ere you can choose between the fractions being displayed as reduced or"
          + " irreduced fractions.</li></ol></details></div>";

      question3 = "<div><b>How Do I Record A Sequence Of Calculations To A File?</b></div>";
      answer3 = "<div><details><ol><l" + "i>There is a menu " + "bar at the top of the prog"
          + "ram with a section ti" + "tled Record.</li><li>From here the user would sel"
          + "ect Record.</li><li>The user will Begin ente" + "ring their calculat"
          + "ions, and once they are satisfied the user would press Stop.</li><li>From h"
          + "ere they would press save to save the calculations"
          + " to their computer.</li><li>From this point th"
          + "e user can also load the calculations back into the calculator.</li></ol></details>";

      question4 = "<div><b>How Do I Look At The History O"
          + "f Fractions I Have Calculated?</b></div>";
      answer4 = "<div><details><ol><li>There is a menu b"
          + "ar at the top of the program with a section ti"
          + "tled History.</li><li>From here the user will sele"
          + "ct the Show History option.</li><li>A window slides ou"
          + "t from the left side of the calculator showing the "
          + "current history.</li></ol></details></div>";

      question5 = "<div><b>How Do I Print My History Of Calculations?</b></div>";
      answer5 = "<div><details><ol><li>There is a menu "
          + "bar at the top of the program with a section ti"
          + "tled Print.</li><li>The user will press Print and"
          + " then select Print Screen.</li><li>From here the user"
          + "must select the printer, number of copies, and t"
          + "he pages to print.</li></ol></details></div>";

      question6 = "<div><b>Can I Change The Color Of My Background and or Buttons?</b></div>";
      answer6 = "<div><details><ol><li>Yes! There"
          + " is a menu bar at the top of the program with a secti"
          + "on titled Colors.</li><li>The user will need "
          + "to select this then pick either buttons or backgrou"
          + "nd.</li><li>The user must then select which but"
          + "ton group to change.</li><li>Once picked any color sele"
          + "cted will change the button group to that color.</li></ol></details></div>";

      question7 = "<div><b>Can I Use This Calculator In Different Languages?</b></div>";
      answer7 = "<div><details><ol><li>Y"
          + "es! There is a menu bar at the top of the program with a secti"
          + "on titled Languages.</li><li>From here "
          + "the user must select the language they would like to use."
          + "</li></ol></details></div>";

      question8 = "<div><b>What Do All Of The Buttons Do?</b></div>";
      answer8 = "<div><details><ol>" + "<li>Numbers (0-9):  Allow the user to i"
          + "nput numbers into the portion of the fraction being focused.</li>"
          + "<li>Plus Minus: Allows the user t"
          + "o choose if the fraction is positive or negative.</li>"
          + "<li>C: Allows the user to clear the fraction currently being input.</li>"
          + "<li>Left Arrow: Allows the user to dele"
          + "te the most recently used integer in the focused part of the fraction.</li>"
          + "<li>Focus: Allows the user to cycle throu"
          + "gh the whole numerator and denominator portions of the fraction.</li>"
          + "<li>Operands: Allows the user to use any of t"
          + "he Math symbols to perform that type of calcul"
          + "ation between the first and second fraction.</li>"
          + "<li>=: Allows the user to execute the calculation.</li>"
          + "<li>R: Allows the user to clear the entire calculation that is being input.</li>"
          + "<li>Inv: Allows the user to find the multiplicative inverse of a mixed fraction.</li>"
          + "<li>Pow: Allows the user to calculate the integer power of a fraction.</li>"
          + "<li>Med: Allows the user to calculate the mediant of two mixed fractions.</li>"
          + "<li><: Allows the user to see the steps of the calculation.</li>"
          + "</ol></details></div>";
    } else if (lang == 1) 
    {
      head = MultipleLanguages.SPANISHHEAD;
      faq = MultipleLanguages.SPANISHFAQ;
      question1 = MultipleLanguages.SPANISHQ1;
      answer1 = MultipleLanguages.SPANISHA1;
      question2 = MultipleLanguages.SPANISHQ2;
      answer2 = MultipleLanguages.SPANISHA2;
      question3 = MultipleLanguages.SPANISHQ3;
      answer3 = MultipleLanguages.SPANISHA3;
      question4 = MultipleLanguages.SPANISHQ4;
      answer4 = MultipleLanguages.SPANISHA4;
      question5 = MultipleLanguages.SPANISHQ5;
      answer5 = MultipleLanguages.SPANISHA5;
      question6 = MultipleLanguages.SPANISHQ6;
      answer6 = MultipleLanguages.SPANISHA6;
      question7 = MultipleLanguages.SPANISHQ7;
      answer7 = MultipleLanguages.SPANISHA7;
      question8 = MultipleLanguages.SPANISHQ8;
      answer8 = MultipleLanguages.SPANISHA8;
    } else 
    {
      head = MultipleLanguages.FRENCHHEAD;
      faq = MultipleLanguages.FRENCHFAQ;
      question1 = MultipleLanguages.FRENCHQ1;
      answer1 = MultipleLanguages.FRENCHA1;
      question2 = MultipleLanguages.FRENCHQ2;
      answer2 = MultipleLanguages.FRENCHA2;
      question3 = MultipleLanguages.FRENCHQ3;
      answer3 = MultipleLanguages.FRENCHA3;
      question4 = MultipleLanguages.FRENCHQ4;
      answer4 = MultipleLanguages.FRENCHA4;
      question5 = MultipleLanguages.FRENCHQ5;
      answer5 = MultipleLanguages.FRENCHA5;
      question6 = MultipleLanguages.FRENCHQ6;
      answer6 = MultipleLanguages.FRENCHA6;
      question7 = MultipleLanguages.FRENCHQ7;
      answer7 = MultipleLanguages.FRENCHA7;
      question8 = MultipleLanguages.FRENCHQ8;
      answer8 = MultipleLanguages.FRENCHA8;
    }
    

    file = new File("HelpPage.html");
    try
    {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.write(head);
      writer.write(faq);
      writer.write(question1);
      writer.write(answer1);
      writer.write(question2);
      writer.write(answer2);
      writer.write(question3);
      writer.write(answer3);
      writer.write(question4);
      writer.write(answer4);
      writer.write(question5);
      writer.write(answer5);
      writer.write(question6);
      writer.write(answer6);
      writer.write(question7);
      writer.write(answer7);
      writer.write(question8);
      writer.write(answer8);
      writer.close();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    
  }
  
  /**
   * Returns the file.
   * @return File
   */
  public static File getFile() 
  {
    return file; 
  }
}
