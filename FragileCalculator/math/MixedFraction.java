package math;

import gui.DisplayPanel;

/**
 * MixedFraction class.
 * 
 * @author Max Stevens
 *
 */
public class MixedFraction
{
  public static final int WHOLE_INDEX = 0;
  public static final int NUMERATOR_INDEX = 1;
  public static final int DENOMINATOR_INDEX = 2;

  private boolean isNegative;

  private String spaceStr = " ";
  private String slashStr = "/";
  // stores numbers in 0->whole, 1->numerator, 2->mixedFraction[DENOMINATOR_INDEX]
  private int[] mixedFraction;
  // format whole * numerator/denominator

  /**
   * MixedFraction int constructor. If new fraction is undefined it is set to be 0, and if fraction
   * can be reduced it will be.
   * 
   * @param whole
   * @param numerator
   * @param denominator
   */
  public MixedFraction(final int whole, final int numerator, final int denominator)
  {
    this.mixedFraction = new int[3];
    // properly sets it in the whole only case
    setMixedFraction(whole, numerator, denominator);
  }

  /**
   * Constructor from array. If new fraction is undefined it is set to be 0, and if fraction can be
   * reduced it will be.
   * 
   * @param mixedFraction
   */
  public MixedFraction(final int[] mixedFraction)
  {
    this.mixedFraction = new int[3];
    setMixedFraction(mixedFraction[WHOLE_INDEX], mixedFraction[NUMERATOR_INDEX],
        mixedFraction[DENOMINATOR_INDEX]);
  }

  /**
   * Constructs MixedFraction from String input TODO: Allow for more representations format -> W
   * N/D. AKA slash style If new fraction is undefined it is set to be 0, and if fraction can be
   * reduced it will be.
   * 
   * @param s
   * @throws exception parseInt failing, catch and resolve where mixed is created
   */
  public MixedFraction(final String s) throws NumberFormatException
  {
    if (s == null || s.equals(""))
      throw new IllegalArgumentException("String to create MixedFraction is empty");
    this.mixedFraction = new int[3];
    // for specific whole # case
    if (s.length() == 1)
    {
      setMixedFraction(0, Integer.parseInt(s), 1);
      return;
    }
    // case in which there is no whole #
    if (!s.contains(spaceStr))
    {
      int divideIndex = s.indexOf(slashStr);
      String numerToken = s.substring(0, divideIndex);
      int numer = Integer.parseInt(numerToken);

      String denomToken = s.substring(divideIndex + 1);
      int denom = Integer.parseInt(denomToken);
      setMixedFraction(0, numer, denom);
      return;
    }

    // case in which there IS a whole #, and fraction
    int spaceIndex = s.indexOf(spaceStr);
    String wholeToken = s.substring(0, spaceIndex);
    int whole = Integer.parseInt(wholeToken);

    int divideIndex = s.indexOf(slashStr);
    String numerToken = s.substring(spaceIndex + 1, divideIndex);
    int numer = Integer.parseInt(numerToken);

    String denomToken = s.substring(divideIndex + 1);
    int denom = Integer.parseInt(denomToken);

    setMixedFraction(whole, numer, denom);
  }

  /**
   * Sets fraction using in values. If new fraction is undefined it is set to be 0,
   * 
   * @param fWhole
   * @param fNumerator
   * @param fDenominator
   */
  public void setMixedFraction(final int fWhole, final int fNumerator, final int fDenominator)
  {

    // case neg number
    if (isNegativeHelper(fWhole, fNumerator, fDenominator))
    {
      isNegative = true;
    }

    int runningWhole = Math.abs(fWhole);
    int runningNum = Math.abs(fNumerator);
    int runningDenom = Math.abs(fDenominator);

    // case all 1's
    if (runningNum == 1 && fWhole == 1 && runningDenom == 1)
    {
      setMixedFraction(0, 2, 1);
    }
    // whole # case
    else if (runningNum == 1 && runningDenom == 1)
    {
      // adds one
      mixedFraction[NUMERATOR_INDEX] = runningWhole + 1;
      mixedFraction[DENOMINATOR_INDEX] = runningDenom;
      mixedFraction[WHOLE_INDEX] = runningWhole;
    } else
    {
      mixedFraction[NUMERATOR_INDEX] = runningDenom * runningWhole + runningNum;
      mixedFraction[DENOMINATOR_INDEX] = runningDenom;

      if (runningDenom == 0)
        mixedFraction[WHOLE_INDEX] = 0;
      else
        mixedFraction[WHOLE_INDEX] = runningWhole;
    }
    undefinedCheck();
  }

  /**
   * Sets fraction to all 0s in case of undefined.
   */
  private void setUndefined()
  {
    mixedFraction[WHOLE_INDEX] = 0;
    mixedFraction[NUMERATOR_INDEX] = 0;
    mixedFraction[DENOMINATOR_INDEX] = 0;
  }

  /**
   * returns true iff. input #'s are a negative mixed fraction.
   * @param whole
   * @param num
   * @param dom
   * @return true iff. is negative
   */
  public static boolean isNegativeHelper(final int whole, final int num, final int dom)
  {
    boolean isNeg = false;
    if (whole == 0 && num * dom < 0)
      isNeg = true;
    else if (num == 0 && whole * dom < 0)
      isNeg = true;
    else if (whole * dom * num < 0)
      isNeg = true;
    return isNeg;

  }

  /**
   * getter for a reduced numerator.
   * 
   * @return numerator
   */
  public int getNumerator()
  {
    if (getDenominator() == 0)
      return 0;
    if (getWhole() == 0 && isNegative)
      return (mixedFraction[NUMERATOR_INDEX] % mixedFraction[DENOMINATOR_INDEX]) * -1;
    return mixedFraction[NUMERATOR_INDEX] % mixedFraction[DENOMINATOR_INDEX];
  }

  /**
   * getter for reduced whole, returns whole # based on numerator 
   * and denominator and is reduced.
   * 
   * @return whole
   */
  public int getWhole()
  {
    int signVal = 1;
    if (mixedFraction[DENOMINATOR_INDEX] == 0)
      return 0;
    if (isNegative)
      signVal = -1;
    return mixedFraction[NUMERATOR_INDEX] / mixedFraction[DENOMINATOR_INDEX] * signVal;
  }

  /**
   * returns irreduced numerator.
   * 
   * @return irreduced numerator
   */
  public int getIrreducedNum()
  {
    if (mixedFraction[DENOMINATOR_INDEX] == 0)
      return 0;
    int signVal = 1;
    if (isNegative)
      signVal = -1;
    return signVal * mixedFraction[NUMERATOR_INDEX];
  }

  /**
   * returns irreduced whole #.
   * 
   * @return irreduced whole
   */
  public int getIrreducedWhole()
  {
    int signVal = 1;
    if (isNegative)
      signVal = -1;
    return signVal * mixedFraction[WHOLE_INDEX];
  }

  /**
   * getter.
   * 
   * @return denom
   */
  public int getDenominator()
  {
    return mixedFraction[DENOMINATOR_INDEX];
  }

  /**
   * Checks if denominator is = 0, if it is set everything to 0.
   */
  protected void undefinedCheck()
  {
    if (mixedFraction[DENOMINATOR_INDEX] == 0)
      setUndefined();

  }

  /**
   * Comparative equals method.
   * 
   * @param f fraction to be compared
   * @return true iff. f is a mixed fraction that has the same whole, numerator, and denominator
   */
  public boolean equals(final Object f)
  {
    if (!(f instanceof MixedFraction))
      return false;
    MixedFraction fraction = (MixedFraction) f;
    return fraction.getWhole() == mixedFraction[WHOLE_INDEX]
        && fraction.getNumerator() == mixedFraction[NUMERATOR_INDEX]
        && fraction.getDenominator() == mixedFraction[DENOMINATOR_INDEX];
  }

  /**
   * required by style, no clue why.
   * 
   * @return the hashcode
   */
  public int hashCode()
  {
    return (mixedFraction[WHOLE_INDEX] * mixedFraction[WHOLE_INDEX])
        * (mixedFraction[NUMERATOR_INDEX] * mixedFraction[NUMERATOR_INDEX])
        * (mixedFraction[DENOMINATOR_INDEX] * mixedFraction[DENOMINATOR_INDEX]);
  }

  /**
   * Formated toString based on current mixedFrac values.
   * 
   * @return formated string of whole, num, and denom
   */
  public String toString()
  {
    String returnString = "";
    if (mixedFraction[DENOMINATOR_INDEX] == 0)
      returnString += 0;
    else if (Math.abs(mixedFraction[NUMERATOR_INDEX])
        % Math.abs(mixedFraction[DENOMINATOR_INDEX]) == 0)
      returnString += "" + getWhole();
    else if (Math.abs(mixedFraction[NUMERATOR_INDEX]) < Math.abs(mixedFraction[DENOMINATOR_INDEX]))
      returnString += getNumerator() + slashStr + getDenominator();
    else if (Math.abs(DENOMINATOR_INDEX) == 0 && Math.abs(NUMERATOR_INDEX) == 0)
      returnString += "" + getWhole();
    else 
      // if the user has selected reduce, the fraction will appear reduced. 
      // If not, it will show in irreduced form. 
      if (DisplayPanel.toReduce())
      {
        returnString += "" + getWhole() + spaceStr + getNumerator() + slashStr + getDenominator();
      } else if (DisplayPanel.toIrreduce())
      {
        returnString += "" + getIrreducedNum() + slashStr + getDenominator();
      } else 
      {
        returnString += "" + getWhole() + spaceStr + getNumerator() + slashStr + getDenominator();
      }

    return returnString;
  }

}
