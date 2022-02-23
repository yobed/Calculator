package formating;

import java.util.ArrayList;

import math.MixedFraction;

/**
 * Stores info from save files to give to displayPanel.
 * 
 * @author Max
 *
 */
public class FragileSaveFile
{
  private ArrayList<MixedFraction> fractions;
  private ArrayList<String> operands;

  /**
   * takes in fractions and operands arr created from txt file, and stores it for later use.
   * 
   * @param fractions
   * @param operands
   */
  public FragileSaveFile(final ArrayList<MixedFraction> fractions, final ArrayList<String> operands)
  {
    this.fractions = fractions;
    this.operands = operands;
  }

  /**
   * getter of ops.
   * 
   * @return ops to return.
   */
  public ArrayList<String> getOperands()
  {
    return operands;
  }

  /**
   * getter of fracs.
   * 
   * @return fracs return.
   */
  public ArrayList<MixedFraction> getFractions()
  {
    return fractions;
  }

}
