package testing;
import static org.junit.Assert.*;

import org.junit.Test;

import math.MixedFraction;
import math.MixedFractionOperations;

public class MixedFractionOperationsTest
{
  
  MixedFraction fBasic = new MixedFraction (2, 3,4);
  MixedFraction fBasicTwo = new MixedFraction (3, 1, 2);
  
  MixedFraction valOnedenomZero = new MixedFraction(2, 5, 0);
  MixedFraction valTwodenomZero = new MixedFraction(2, 3, 0);
  
  MixedFraction noWholeNumber = new MixedFraction(0, 3, 1);
  
  
  /**
   * Testing.
   */
  @Test
  public void additiontest () 
  {
    // basic addition (normal mixed fractions)
    MixedFraction result1 = MixedFractionOperations.add(fBasic, fBasic);
    assertEquals (result1.toString(), "5 1/2"); 
    
    // if value one has a zero in the denominator
    MixedFraction result2 = MixedFractionOperations.add(valOnedenomZero, fBasic);
    assertEquals (result2.toString(), "2 3/4"); 
    
    // if value two has a zero in the denominator
    MixedFraction result3 = MixedFractionOperations.add(fBasic, valTwodenomZero);
    assertEquals (result3.toString(), "2 3/4"); 
    
    // if both mixedFractions have a zero in the denominator
    MixedFraction result4 = MixedFractionOperations.add(valOnedenomZero, valTwodenomZero);
    assertEquals (result4.toString(), "0"); 
    
    // whole number is not present for either
    MixedFraction result5 = MixedFractionOperations.add(noWholeNumber, noWholeNumber);
    assertEquals (result5.toString(), "6");
  }
  
  /**
   * Testing.
   */
  @Test
  public void subtractiontest () 
  {
    // basic subtraction (normal mixed fractions)
    MixedFraction result = MixedFractionOperations.subtract(fBasic, fBasic);
    assertEquals (result.toString(), "0");  
    
    // if value one has a zero in the denominator
    MixedFraction result2 = MixedFractionOperations.subtract(valOnedenomZero, fBasic);
    assertEquals (result2.toString(), "2 3/4"); 
    
    // if value two has a zero in the denominator
    MixedFraction result3 = MixedFractionOperations.subtract(fBasic, valTwodenomZero);
    assertEquals (result3.toString(), "2 3/4"); 
    
    // if both mixedFractions have a zero in the denominator
    MixedFraction result4 = MixedFractionOperations.subtract(valOnedenomZero, valTwodenomZero);
    assertEquals (result4.toString(), "0");
    
    // whole number is not present for either
    MixedFraction result5 = MixedFractionOperations.subtract(noWholeNumber, noWholeNumber);
    assertEquals (result5.toString(), "0");
  }
  
  /**
   * Testing.
   */
  @Test
  public void multiplicationtest () 
  {

    // basic multiplication (normal mixed fractions)
    MixedFraction result = MixedFractionOperations.multiply(fBasic, fBasic);
    assertEquals (result.toString(), "7 9/16");   
    
    // if value one has a zero in the denominator
    MixedFraction result2 = MixedFractionOperations.multiply(valOnedenomZero, fBasic);
    assertEquals (result2.toString(), "0"); 
    
    // if value two has a zero in the denominator
    MixedFraction result3 = MixedFractionOperations.multiply(fBasic, valTwodenomZero);
    assertEquals (result3.toString(), "0"); 
    
    // if both mixedFractions have a zero in the denominator
    MixedFraction result4 = MixedFractionOperations.multiply(valOnedenomZero, valTwodenomZero);
    assertEquals (result4.toString(), "0");
    
    // whole number is not present for either
    MixedFraction result5 = MixedFractionOperations.multiply(noWholeNumber, noWholeNumber);
    assertEquals (result5.toString(), "9");
  }
  
  /**
   * Testing.
   */
  @Test
  public void divisiontest () 
  {
    // basic division (normal mixed fractions)
    MixedFraction result = MixedFractionOperations.divide(fBasic, fBasic);
    assertEquals (result.toString(), "1");
    
    // if value one has a zero in the denominator
    MixedFraction result2 = MixedFractionOperations.divide(valOnedenomZero, fBasic);
    assertEquals (result2.toString(), "0"); 
    
    // if value two has a zero in the denominator
    MixedFraction result3 = MixedFractionOperations.divide(fBasic, valTwodenomZero);
    assertEquals (result3.toString(), "0"); 
    
    // if both mixedFractions have a zero in the denominator
    MixedFraction result4 = MixedFractionOperations.divide(valOnedenomZero, valTwodenomZero);
    assertEquals (result4.toString(), "0");
    
    // whole number is not present for either
    MixedFraction result5 = MixedFractionOperations.divide(noWholeNumber, noWholeNumber);
    assertEquals (result5.toString(), "1");
  }
  
  /**
   * Testing.
   */
  @Test
  public void gcdtest () 
  {
      int numerator = 2;
      int denominator = 4;
      
      assertEquals(MixedFractionOperations.gcd(numerator, denominator), 2);
  }
  
  /**
   * Testing.
   */
  @Test
  public void reducedImpropFractest () 
  {
      int numerator = 2;
      int denominator = 4;
      
      assertEquals(MixedFractionOperations.gcd(numerator, denominator), 2);
      
      
  }

}
