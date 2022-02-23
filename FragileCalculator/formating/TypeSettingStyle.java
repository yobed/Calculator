package formating;

import gui.DisplayPanel;
import math.MixedFraction;

/**
 * Takes an input of a MixedFraction and returns a string in specified style.
 * 
 * @author Max
 *
 */
public class TypeSettingStyle
{
  private static final char ZEROSUB = '\u2080';
  private static final char ONESUB = '\u2081';
  private static final char TWOSUB = '\u2082';
  private static final char THREESUB = '\u2083';
  private static final char FOURSUB = '\u2084';
  private static final char FIVESUB = '\u2085';
  private static final char SIXSUB = '\u2086';
  private static final char SEVENSUB = '\u2087';
  private static final char EIGHTSUB = '\u2088';
  private static final char NINESUB = '\u2089';

  private static final char SLASH = '\u2044';
  private static final String OTHERSLASH = "/"; // hi

  private static final char ZEROSUPER = '\u2070';
  private static final char ONESUPER = '\u00B9';
  private static final char TWOSUPER = '\u00B2';
  private static final char THREESUPER = '\u00B3';
  private static final char FOURSUPER = '\u2074';
  private static final char FIVESUPER = '\u2075';
  private static final char SIXSUPER = '\u2076';
  private static final char SEVENSUPER = '\u2077';
  private static final char EIGHTSUPER = '\u2078';
  private static final char NINESUPER = '\u2079';
  private static final String STARTSTRING = "<html>";
  private static final String ENDSTRING = "</html>";
  private static final String MARK = "<mark>";
  private static final String END_MARK = "</mark>";
  private static final String ZERO = "0";
  private static String THREETR = "<tr><td></td><td>";
  private static String TABLESTART = "<table>";
  private static String TABLEEND = "</table>";
  private static String ONEROW = "<tr><td>";
  private static String ENDROW = "</td><td><td/></tr>";
  private static String DASHROW = "</td><td>-</td><td>";
  private static String ENDTDTR = "</td></tr>";
  private static String ENDBOTH = "</td><td></td></tr>";
  private static String ENDSTART = "</td><td>";
  private static String DASH = "-";
  /**
   * Takes MixedFraction and returns solidus typeset String.
   * 
   * @param f MixedFraction
   * @return solidus String
   */
  public static String setSolidus(final MixedFraction f)
  {
    return setSolidusHelper(f.getWhole(), f.getNumerator(), f.getDenominator());
  }

  /**
   * Takes mixedFraction f, and uses toReduce to determine whether or not to leave irreduced.
   * 
   * @param f MixedFraction input
   * @param toReduce reduce flag
   * @return solidus typeset Strings
   */
  public static String setSolidus(final MixedFraction f, final boolean toReduce)
  {
    if (toReduce)
      return setSolidusHelper(f.getWhole(), f.getNumerator(), f.getDenominator());
    else
      return setSolidusHelper(f.getIrreducedWhole(), f.getIrreducedNum(), f.getDenominator());

  }

  /**
   * Handels logic of converter the int inputs to solidus output.
   * @param whole
   * @param numerator
   * @param denominator
   * @return String
   */
  private static String setSolidusHelper(final int whole, final int numerator,
      final int denominator)
  {
    String resultString = "" + whole;
    int rollingNumerator = numerator;
    int rollingDenom = denominator;

    
    String numerString = "";
    while (rollingNumerator > 0)
    {
      switch (rollingNumerator % 10) 
      {
        case 1:
          numerString += ONESUPER;
          break;
        case 2:
          numerString += TWOSUPER;
          break;
        case 3:
          numerString += THREESUPER;
          break;
        case 4:
          numerString += FOURSUPER;
          break;
        case 5:
          numerString += FIVESUPER;
          break;
        case 6:
          numerString += SIXSUPER;
          break;
        case 7:
          numerString += SEVENSUPER;
          break;
        case 8:
          numerString += EIGHTSUPER;
          break;
        case 9:
          numerString += NINESUPER;
          break;
        default:
        // as it is literally impossible to reach this if I
        // include the 0 case, for coverage reasons
        // I will have 0 be default
          numerString += ZEROSUPER;
          break;
      }
      rollingNumerator = rollingNumerator / 10;
    }
    resultString += new StringBuilder(numerString).reverse().toString();
    resultString += SLASH;

    String denomString = "";
    while (rollingDenom > 0)
    {
      switch (rollingDenom % 10) 
      {
        case 1:
          denomString += ONESUB;
          break;
        case 2:
          denomString += TWOSUB;
          break;
        case 3:
          denomString += THREESUB;
          break;
        case 4:
          denomString += FOURSUB;
          break;
        case 5:
          denomString += FIVESUB;
          break;
        case 6:
          denomString += SIXSUB;
          break;
        case 7:
          denomString += SEVENSUB;
          break;
        case 8:
          denomString += EIGHTSUB;
          break;
        case 9:
          denomString += NINESUB;
          break;
        default:
        // as it is literally impossible to reach this if I
        // include the 0 case, for coverage reasons
        // I will have 0 be default
          denomString += ZEROSUB;
          break;
      }
      rollingDenom = rollingDenom / 10;
    }
    resultString += new StringBuilder(denomString).reverse().toString();
    return resultString;
  }

  /**
   * Returns the int for the corresponding unicode char. returns -1 if error
   * 
   * @param c
   * @return # char represents.
   */
  private static int returnUniInput(final char c)
  {
    int retInt = -1;
    switch (c) 
    {
      case ZEROSUPER:
      case ZEROSUB:
        retInt = 0;
        break;
      case ONESUPER:
      case ONESUB:
        retInt = 1;
        break;
      case TWOSUPER:
      case TWOSUB:
        retInt = 2;
        break;
      case THREESUPER:
      case THREESUB:
        retInt = 3;
        break;
      case FOURSUPER:
      case FOURSUB:
        retInt = 4;
        break;
      case FIVESUPER:
      case FIVESUB:
        retInt = 5;
        break;
      case SIXSUPER:
      case SIXSUB:
        retInt = 6;
        break;
      case SEVENSUPER:
      case SEVENSUB:
        retInt = 7;
        break;
      case EIGHTSUPER:
      case EIGHTSUB:
        retInt = 8;
        break;
      case NINESUPER:
      case NINESUB:
        retInt = 9;
        break;
      default:
      // as it is literally impossible to reach this if I
      // include the 0 case, for coverage reasons
      // I will have 0 be default
        retInt = -1;
    }
    return retInt;
  }

  /**
   * returns a mixedFraction from a solidus format input string.
   * 
   * @param s
   * @return a MixedFraction from input
   */
  public static MixedFraction fromSolidusToMixedFraction(final String s)
      throws NumberFormatException
  {
    boolean onlyWholeNum = false;
    char[] solArr = s.toCharArray();
    String currentChar = "" + solArr[0];
    int index = 0;
    String wholeNum = "";
    // first loop through to get whole #
    while (true)
    {

      if (index >= solArr.length)
      {
        onlyWholeNum = true;
        break;
      }
      currentChar = "" + solArr[index];
      try
      {
        wholeNum += Integer.parseInt(currentChar);
      } catch (NumberFormatException e)
      {
        break;
      }
      index++;
    }

    if (!s.contains("" + SLASH) && !s.contains(OTHERSLASH) && !onlyWholeNum)
      throw new NumberFormatException("Input string has other digits besides whole num but no /");

    String numerNum = "";
    // next loop through from past whole#, to superscript
    while (true)
    {
      if (index == solArr.length && !onlyWholeNum)
        throw new NumberFormatException("Input string in denom in solidus has super but no /");
      else if (index >= solArr.length)
        break;
      int current = returnUniInput(solArr[index]);
      if (current == -1 && solArr[index] != SLASH && solArr[index] != '/')
      {
        System.out.println(solArr[index]);
        throw new NumberFormatException("Unexpected value in denom in Solidus String.");
      } else if (current == -1)
      {
        break;
      }

      numerNum += current;
      index++;
    }

    index++;
    String denomNum = "";
    // now past / and doing denom
    while (true)
    {
      if (index == solArr.length && !onlyWholeNum && !s.contains("" + SLASH)
          && !s.contains(OTHERSLASH))
        throw new NumberFormatException("Input string in solidus has super but no /");
      else if (index >= solArr.length)
        break;
      int current = returnUniInput(solArr[index]);
      if (current == -1 && solArr[index] != SLASH && solArr[index] != '/')
      {
        System.out.println(solArr[index]);
        throw new NumberFormatException("Unexpected value in Solidus String.");
      } else if (current == -1)
      {
        break;
      }

      denomNum += current;
      index++;
    }
    // should never throw exception here
    if (onlyWholeNum)
      return new MixedFraction(Integer.parseInt(wholeNum), 1, 1);
    return new MixedFraction(Integer.parseInt(wholeNum), Integer.parseInt(numerNum),
        Integer.parseInt(denomNum));
  }

  /**
   * Takes MixedFraction and returns bar typeset String. TODO. allow bar to properly format edge
   * cases IE 0 in whole, 0 in num
   * 
   * @param f MixedFraction
   * @return bar String
   */
  public static String setBar(final MixedFraction f)
  {
    String operator = "";
    String whole = String.valueOf(f.getWhole());
    String numer = String.valueOf(f.getNumerator());
    String denom = String.valueOf(f.getDenominator());
    return TABLESTART + THREETR + numer + ENDROW + ONEROW + whole
        + DASHROW + operator + ENDTDTR + THREETR + denom
        + ENDBOTH + TABLEEND; // bar

  }

  /**
   * Used in Display for focus, to allow for it be displayed as bar.
   * 
   * @param whole
   * @param denom
   * @param numer
   * @return bar style String
   */
  public static String setBar(final Integer whole, final Integer numer, final Integer denom)
  {
    String operator = "";
    String bar = DASH;
    String retNum;
    String retWhole;
    String retDenom;
    if (whole != null)
      retWhole = whole.toString();
    else
      retWhole = "";
    if (denom != null)
      retDenom = denom.toString();
    else
      retDenom = "";
    if (numer != null)
      retNum = numer.toString();
    else
      retNum = "";
    /*
     * String whole = String.valueOf(f.getWhole()); String numer = String.valueOf(f.getNumerator());
     * String denom = String.valueOf(f.getDenominator());
     */
    return TABLESTART + THREETR + retNum + ENDROW + ONEROW + retWhole
        + ENDSTART + bar + ENDSTART + operator + ENDTDTR + THREETR + retDenom
        + ENDBOTH + TABLEEND; // bar

  }

  /**
   * Used in Display for focus, to allow for it be displayed as bar Focus is a size 3 array which
   * sets a flag for whether or not a current element has focus focus[0] = whole, focus[1] = numer,
   * focus[2] = denom.
   * 
   * @param whole
   * @param denom
   * @param numer
   * @param focus
   * @return String
   */
  public static String setBar(final Integer whole, final Integer numer, final Integer denom,
      final boolean[] focus)
  {
    String space = " ";
    String operator = "";
    String bar = DASH;
    String retNum = "";
    String retWhole = "";
    String retDenom = "";
    if (focus[0])
      retWhole += MARK;
    else if (focus[1])
      retNum += MARK;
    else if (focus[2])
      retDenom += MARK;

    if (whole != null)
      retWhole = whole.toString();
    else
      retWhole = space;
    if (denom != null)
      retDenom = denom.toString();
    else
      retDenom = space;
    if (numer != null)
      retNum = numer.toString();
    else
      retNum = space;

    if (focus[0])
      retWhole += END_MARK;
    else if (focus[1])
      retNum += END_MARK;
    else if (focus[2])
      retDenom += END_MARK;

    /*
     * String whole = String.valueOf(f.getWhole()); String numer = String.valueOf(f.getNumerator());
     * String denom = String.valueOf(f.getDenominator());
     */
    return TABLESTART + THREETR + retNum + ENDROW + ONEROW + retWhole
        + ENDSTART + bar + ENDSTART + operator + ENDTDTR + THREETR + retDenom
        + ENDBOTH + TABLEEND; // bar

  }

  /**
   * gives bar style string with given input operator and mixed fraction TODO. allow bar to properly
   * format edge cases IE 0 in whole, 0 in num
   * 
   * @param f
   * @param operator
   * @return string formated with html to bar style
   */
  public static String setBar(final MixedFraction f, final String operator)
  {
    String whole = "";
    if (f.getWhole() != 0)
    {
      whole = String.valueOf(f.getWhole());
    }
    if (f.getNumerator() == 0 || f.getDenominator() == 0)
    {
      return whole;
    }
    String numer = String.valueOf(f.getNumerator());
    String denom = String.valueOf(f.getDenominator());
    return STARTSTRING + TABLESTART + THREETR + numer + ENDROW
        + ONEROW + whole + DASHROW + operator + ENDTDTR + THREETR
        + denom + ENDBOTH + TABLEEND + ENDSTRING; // bar
  }

  /**
   * Returns the whole fraction for display.
   * 
   * @param first
   * @param operand
   * @param second
   * @param answer
   * @return String display
   */
  public static String setBar(final MixedFraction first, final String operand,
      final MixedFraction second, final MixedFraction answer)
  {
    String firstRow = "";
    String secondRow = "";
    String thirdRow = "";
    String trtdtrtd = "</td><td></td><td>";

    String num1 = String.valueOf(first.getNumerator());
    String num2 = String.valueOf(second.getNumerator());
    String numa = String.valueOf(answer.getNumerator());
    String den1 = String.valueOf(first.getDenominator());
    String den2 = String.valueOf(second.getDenominator());
    String dena = String.valueOf(answer.getDenominator());
    String whole1 = "";
    String operandx = operand;
    if (first.getWhole() != 0)
      whole1 = String.valueOf(first.getWhole());
    if (first.getNumerator() == 0)
    {
      if (first.getWhole() == 0)
        whole1 = ZERO;
      firstRow = TABLESTART + "<tr><td></td><td></td><td><td/><td>";
      secondRow = ONEROW + whole1 + trtdtrtd + operandx;
      thirdRow = "<tr><td></td><td></td><td></td><td></td><td>";
    } else
    {
      firstRow = TABLESTART + THREETR + num1 + "</td><td><td/><td>";
      secondRow = ONEROW + whole1 + DASHROW + operandx;
      thirdRow = THREETR + den1 + "</td><td><" + "/td><td></td><td>";
    }

    String whole2 = "";

    if (second.getWhole() != 0)
      whole2 = String.valueOf(second.getWhole());
    if (second.getNumerator() == 0)
    {
      if (second.getWhole() == 0)
        whole2 = ZERO;
      firstRow += "</td><td" + "></td><td></td><td>";
      secondRow += ENDSTART + whole2 + trtdtrtd;
      thirdRow += "</td><td></td" + "><td></td><td>";
    } else
    {
      firstRow += num2 + "</td><td></td><" + "td></td><td>";
      secondRow += ENDSTART + whole2 + DASHROW;
      thirdRow += den2 + "</td><td></td><td></td><td>";
    }

    String wholea = "";
    if (answer.getWhole() != 0)
      wholea = String.valueOf(answer.getWhole());
    if (answer.getNumerator() == 0)
    {
      if (answer.getWhole() == 0)
        wholea = ZERO;
      firstRow += ENDTDTR;
      secondRow += DisplayPanel.EQUALS + ENDSTART + wholea + ENDBOTH;
      thirdRow += "</td></tr" + ">" + TABLEEND;
    } else
    {
      firstRow += numa + ENDTDTR;
      secondRow += DisplayPanel.EQUALS + ENDSTART + wholea + "</td><td>-</td></tr>";
      thirdRow += dena + ENDTDTR + TABLEEND;
    }

    return STARTSTRING + firstRow + secondRow + thirdRow + ENDSTRING;

  }

  /**
   * Takes MixedFraction and returns slash typeset String.
   * 
   * @param f MixedFraction
   * @return slash String
   */
  public static String setSlash(final MixedFraction f)
  {
    return f.toString();
  }

}
