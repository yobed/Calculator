package testing;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import gui.DisplayPanel;
import math.MixedFraction;

public class MixedFractionTest
{
  /**
   * Tests Constructor. 
   */
  @Test
  public void constructorTest() 
  {
   int[] fractionArr = {1,1,1}; 
   int[] fractionArrDiff = {2,1,1};
   int[] fractionArrDiff2 = {1,1,2};
   int[] fractionArrDiff3 = {1, 2, 3};
   String fractionWholeGT1 = "3 2/5";
   String fractionNoWhole = "2/5";
   String fractionMultiNum = "12 25/37";
   String wholeFrac = "1";
   String wholeFracSix = "6";
   String fraction = "1 1/1";
   String emptyFraction = "";
   int[] undefinedFraction = {1,0,0};
   
   MixedFraction fBasic = new MixedFraction (1, 1, 1); 
   MixedFraction fArr = new MixedFraction (fractionArr);
   MixedFraction fString = new MixedFraction (fraction);
   MixedFraction fUndefinedNum = new MixedFraction (1,0,0);
   MixedFraction fUndefinedArr = new MixedFraction (undefinedFraction);
   MixedFraction fReduce = new MixedFraction (0,7,2);
   MixedFraction fReduceInvalid = new MixedFraction (0,7,0);
   
   MixedFraction fDiff = new MixedFraction (fractionArrDiff);
   MixedFraction fDiff2 = new MixedFraction (fractionArrDiff2);
   
   assertEquals (fBasic.toString(), "2");
   assertEquals (fArr.toString(), fString.toString());
   assertEquals (fUndefinedNum.getWhole(), 0);
   
   
   assertEquals (fBasic.toString(), fArr.toString());
   assertEquals (fBasic.toString(), "2");
   assertEquals (fBasic.hashCode(), 0);
   
   Object o = new Object();
   assertFalse (fBasic.equals(o));
   assertFalse (fBasic.equals(fUndefinedArr));
   assertFalse (fBasic.equals(fDiff));
   assertFalse (fBasic.equals(fDiff2));
   assertFalse (fBasic.equals(new MixedFraction(fractionArrDiff3)));
   
   Assertions.assertThrows(IllegalArgumentException.class, () -> 
   {
     MixedFraction fNullString = new MixedFraction ((String)null);
   });
   Assertions.assertThrows(IllegalArgumentException.class, () -> 
   {
     MixedFraction fNullString = new MixedFraction (emptyFraction);
   });
   
   assertEquals (fReduce.getWhole(), 3);
   assertEquals (fReduce.getNumerator(), 1);
   assertEquals (fReduce.getDenominator(), 2);
   assertEquals (fReduceInvalid.getDenominator(), 0);
   
   assertEquals (new MixedFraction (fractionWholeGT1).toString(), fractionWholeGT1);
   assertEquals (new MixedFraction (fractionNoWhole).toString(), fractionNoWhole);
   MixedFraction fSingleWhole = new MixedFraction ("1");
   assertEquals (fSingleWhole.getWhole(), 1);
   assertEquals (new MixedFraction (fractionMultiNum).toString(), fractionMultiNum);
   assertEquals (new MixedFraction (wholeFracSix).toString(), "6");
   assertEquals (new MixedFraction (0,0,0).toString(), "0");
   
   MixedFraction negOneHalf = new MixedFraction (-1, 1, 2);
   assertEquals (negOneHalf.getWhole(), -1);
   assertEquals (negOneHalf.getNumerator(), 1);
   assertEquals (negOneHalf.toString(), "-1 1/2");
   MixedFraction negTwo = new MixedFraction (-2, 0, 1);
   assertEquals (negTwo.getWhole(), -2);
   assertEquals (negTwo.toString(), "-2");
   MixedFraction negHalf = new MixedFraction (0, -1, 2);
   assertEquals (negHalf.toString(), "-1/2");
   
   
   assertEquals (fReduce.getIrreducedNum(), 7);
   assertEquals (fReduce.getIrreducedWhole(), 0);
  
  }
  
  @Test
  public void testToString()
  {
    MixedFraction noWhole = new MixedFraction(0, 34, 5);
    assertEquals("6 4/5", noWhole.toString());
    
    DisplayPanel.settoIrreduce(true);
    assertEquals("34/5", noWhole.toString());
    
    DisplayPanel.settoReduce(true);
    DisplayPanel.settoIrreduce(false);
    assertEquals("6 4/5", noWhole.toString());
  }

}
