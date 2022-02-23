package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.*;

import java.awt.Desktop;

import formating.FragilePrinterController;
import formating.FragileSaveFile;
import formating.FragileSaveFileRecorder;

/**
 * Observer for buttons.
 * 
 * @author team5
 */
public class Observer implements ActionListener
{
  private static int lang = 0; // 0 english 1 spanish 2 french
  private DisplayPanel panel;
  private Focus focus;
  private FragileInterWindow intermediateDisplay;
  private FragileHistoryWindow historyDisplay;
  private FragileFileChooser fileChooser;
  private AboutWindow about;
  private int count = 0;
  private final String slash = "Slash";
  private RightButtons right;
  private LeftButtons left;

  /**
   * Observer constructor, takes in panel and intermediate for internal. use
   * 
   * @param panel
   * @param intermediateDisplay
   * @param about
   * @param historyDisplay
   */
  public Observer(final DisplayPanel panel, final FragileInterWindow intermediateDisplay,
      final FragileHistoryWindow historyDisplay, final AboutWindow about)
  {
    this.panel = panel;
    this.intermediateDisplay = intermediateDisplay;
    this.historyDisplay = historyDisplay;
    historyDisplay.createLabels(8);
    this.focus = panel.getFocus();
    this.about = about;
    fileChooser = new FragileFileChooser();
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    String ac;

    ac = e.getActionCommand();
    if (isOperator(ac))
    {
      if (panel.getFractions().size() == 3)
      {
        panel.runningCalculation(ac);
        focus.clear();
      } else if (panel.getCurrentText().length() != 0 && count < 1)
      {
        panel.updateOperand(ac);
        focus.clear();
        count++;
      }
      {
        count = 0;
      }

    } else if (isNumber(ac))
    {
      if (panel.getFractions().size() == 3)
      {
        panel.updateReset();
      }
      panel.addToCurrentText(ac);
      panel.updateDisplay();
    } else if (ac.equals(DisplayPanel.FOCUS))
    {
      focus.changeFocusForward();
    } else if (ac.equals("Bar") || ac.equals("Solidus") || ac.equals(slash)
        || ac.equals(MultipleLanguages.SPANISHSLASH) || ac.equals(MultipleLanguages.FRENCHSLASH))
    {
      panel.setStyle(ac);
      if (ac.equals(MultipleLanguages.SPANISHSLASH) || ac.equals(MultipleLanguages.FRENCHSLASH))
        panel.setStyle(ac);
      panel.switchToStyle();

    } else if (ac.equals(DisplayPanel.WEBSITE) || ac.equals(MultipleLanguages.SPANISHWEBSITE)
        || ac.equals(MultipleLanguages.FRENCHWEBSITE))
    {
      try
      {
        Desktop desktop = Desktop.getDesktop();
        Html.main(null);
        File file = new File(Html.getFile().getAbsolutePath());
        desktop.browse(file.toURI());
      } catch (MalformedURLException e1)
      {
        e1.printStackTrace();
      } catch (IOException e1)
      {
        e1.printStackTrace();
      }
    } else if (ac.equals(DisplayPanel.ABOUT) || ac.equals(MultipleLanguages.SPANISHABOUT)
        || ac.equals(MultipleLanguages.FRENCHABOUT))
    {
      about.setVisible(true);

    } else if (ac.equals(DisplayPanel.START) || ac.equals(MultipleLanguages.SPANISHSTART)
        || ac.equals(MultipleLanguages.FRENCHSTART))
    {
      panel.setRecord(true);
    } else if (ac.equals(DisplayPanel.STOP) || ac.equals(MultipleLanguages.SPANISHSTOP)
        || ac.equals(MultipleLanguages.FRENCHSTOP))
    {
      panel.setRecord(false);
    } else if (ac.equals(DisplayPanel.LOAD) || ac.equals(MultipleLanguages.SPANISHLOAD)
        || ac.equals(MultipleLanguages.FRENCHLOAD))
    {
      // FragileSaveFile.readSave("save");
      fileChooser.showOpenDialog(fileChooser);
      // gets filename / path
      String filename = "";
      try
      {
        filename = fileChooser.getSelectedFile().getName();
        FragileSaveFile recordedInfo = FragileSaveFileRecorder.readSave(filename);
        panel.loadSave(recordedInfo);
      } catch (NullPointerException ex)
      {
        // do nothing
      }
    }
    if (ac.equals(DisplayPanel.SAVE) || ac.equals(MultipleLanguages.SPANISHSAVE)
        || ac.equals(MultipleLanguages.FRENCHSAVE))
    {

      fileChooser.showSaveDialog(fileChooser);
      // get savedList
      String filename = "";
      try
      {
        filename = fileChooser.getSelectedFile().getName();
        if (panel.getRecordedFracs().size() > 0)
          FragileSaveFileRecorder.createSave(panel.getRecordedFracs(), panel.getAllOperands(),
              filename);
      } catch (NullPointerException ex)
      {

      }

      if (panel.getRecordedFracs().size() > 0)
        FragileSaveFileRecorder.createSave(panel.getRecordedFracs(), panel.getAllOperands(),
            "save");

    } else if (ac.equals(DisplayPanel.EQUALS))
    {
      panel.updateOperand(ac);
      panel.clearFocus();
      focus.clear();
      if (panel.getFractions().size() == 2)
      {
        panel.updateEquals();
        historyDisplay.createLabel(panel.getCurrentText());
      }
    } else if (ac.equals(DisplayPanel.CLEAR))
    {
      panel.clear();
    } else if (ac.equals(DisplayPanel.LEFTARROW))
    {
      panel.backpace();

    } else if (ac.equals(DisplayPanel.PRINT))
    {
      FragilePrinterController.print(panel.printScreenHelper(), panel.getParentFrame());
    } else if (ac.equals(DisplayPanel.RESET))
    {
      panel.updateReset();
    } else if (ac.equals(DisplayPanel.IRREDUCE) || ac.equals(MultipleLanguages.SPANISHIRREDUCED)
        || ac.equals(MultipleLanguages.FRENCHIRREDUCED))
    {
      panel.irreducedFractionDisplay();
    } else if (ac.equals(DisplayPanel.REDUCE) || ac.equals(MultipleLanguages.SPANISHREDUCED)
        || ac.equals(MultipleLanguages.FRENCHREDUCED))
    {
      panel.reduceFractionDisplay();
    } else if (ac.equals(DisplayPanel.L_CARROT) && !intermediateDisplay.isVisible())
    {
      // makes interdisplay visible
      intermediateDisplay.startUp();
      // enter list of fractions into intermediateDisplay
      intermediateDisplay.enterMixedFractions(panel.getAllFractions());
      intermediateDisplay.enterOps(panel.getAllOperands());
      intermediateDisplay.interSteps();
      intermediateDisplay.getCloseButton().addActionListener(this);

    } else if ((ac.equals("Show History") || ac.equals(MultipleLanguages.FRENCHSHOWHISTORY)
        || ac.equals(MultipleLanguages.SPANISHSHOWHISTORY)) && !historyDisplay.isVisible())
    {
      // makes history visible
      historyDisplay.startUp();
      historyDisplay.getCloseButton().addActionListener(this);
    } else if (ac.equals(DisplayPanel.R_CARROT) && historyDisplay.isVisible())
    {
      historyDisplay.shutDown();
    } else if (ac.equals(DisplayPanel.L_CARROT)
        || ac.equals(DisplayPanel.R_CARROT) && intermediateDisplay.isVisible())
    {
      intermediateDisplay.shutDown();
    } else if (ac.equals(DisplayPanel.PLUSMINUS))
    {
      panel.setPlusMinus();
    } else if (ac.equals(DisplayPanel.BCOLORS) || ac.equals(MultipleLanguages.SPANISHBUTTONCOLORS)
        || ac.equals(MultipleLanguages.FRENCHBUTTONCOLORS))
    {
      ColorScheme buttonColorScheme = new ColorScheme(left.listOfNumButtons(),
          left.listOfFuncButtons(), right.listOfButtons(), true, lang);
      buttonColorScheme.openColorWindow(ac);
    } else if (ac.equals(DisplayPanel.BGCOLORS)
        || ac.equals(MultipleLanguages.SPANISHBACKGROUNDCOLORS)
        || ac.equals(MultipleLanguages.FRENCHBACKGROUNDCOLORS))
    {
      ColorScheme buttonColorScheme = new ColorScheme(left.listOfNumButtons(),
          left.listOfFuncButtons(), right.listOfButtons(), false, lang);
      buttonColorScheme.openColorWindow(ac);
    } else if (ac.equals("English") || ac.equals(MultipleLanguages.SPANISHENGLISH)
        || ac.equals(MultipleLanguages.FRENCHENGLISH))
    {
      about.updateLanguage(0);
      FragileMenuBar.updateMenu(0);
      this.lang = 0;
      intermediateDisplay.setLanguage(intermediateDisplay.ENGLISH);
    } else if (ac.equals("Spanish") || ac.equals(MultipleLanguages.SPANISHSPANISH)
        || ac.equals(MultipleLanguages.FRENCHSPANISH))
    {
      about.updateLanguage(1);
      FragileMenuBar.updateMenu(1);
      intermediateDisplay.setLanguage(intermediateDisplay.SPANISH);
      this.lang = 1;
    } else if (ac.equals("French") || ac.equals(MultipleLanguages.SPANISHFRENCH)
        || ac.equals(MultipleLanguages.FRENCHFRENCH))
    {
      about.updateLanguage(2);
      FragileMenuBar.updateMenu(2);
      intermediateDisplay.setLanguage(intermediateDisplay.FRENCH);
      this.lang = 2;
    }
  }

  /**
   * Checks if the action command is an operator.
   * 
   * @param ac
   * @return boolean
   */
  private boolean isOperator(final String ac)
  {
    if (ac.equals(DisplayPanel.ADD) || ac.equals(DisplayPanel.SUBTRACT)
        || ac.equals(DisplayPanel.MULTIPLY) || ac.equals(DisplayPanel.DIVIDE)
        || ac.equals(DisplayPanel.INV) || ac.equals(DisplayPanel.MED)
        || ac.equals(DisplayPanel.POW))
    {
      return true;
    }
    return false;
  }

  /**
   * Adds buttons to the Observer.
   * 
   * @param rightb
   * @param leftb
   */
  public void addButtons(final RightButtons rightb, final LeftButtons leftb)
  {
    this.right = rightb;
    this.left = leftb;
  }

  /**
   * Returns the language.
   * 
   * @return int
   */
  public static int getCurrLang()
  {
    return lang;
  }

  /**
   * Checks if the action command is an number.
   * 
   * @param ac
   * @return boolean
   */
  private boolean isNumber(final String ac)
  {
    if (ac.equals(DisplayPanel.ONE) || ac.equals(DisplayPanel.TWO) || ac.equals(DisplayPanel.THREE)
        || ac.equals(DisplayPanel.FOUR) || ac.equals(DisplayPanel.FIVE)
        || ac.equals(DisplayPanel.SIX) || ac.equals(DisplayPanel.SEVEN)
        || ac.equals(DisplayPanel.EIGHT) || ac.equals(DisplayPanel.NINE)
        || ac.equals(DisplayPanel.ZERO))
    {
      return true;
    }
    return false;
  }

}
