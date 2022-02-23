package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import math.MixedFraction;
import math.OtherMixedFractionOperations;
import math.SignedMixedFractionOperations;

class OtherMixedFractionOperationsTest
{
  
  MixedFraction test1 = new MixedFraction(5, 2, 7);
  MixedFraction test1ans;
  MixedFraction zeroTest = new MixedFraction(0, 0, 0);
  MixedFraction negative = new MixedFraction(-1, 1, 2);
  MixedFraction negativeans;
  
  
  @Test
  void testMultiplicativeInverse()
  {
    
    // tests a generic case.
    test1ans = new MixedFraction(0, 7, test1.getIrreducedNum());
    assertEquals(test1ans, OtherMixedFractionOperations.multiplicativeInverse(test1));
    
    // tests a zero case.   
    assertEquals(zeroTest, OtherMixedFractionOperations.multiplicativeInverse(zeroTest));
    
    // test with a negative fraction.
    negativeans = new MixedFraction(0, -2, 3);
    assertEquals(negativeans.toString(), OtherMixedFractionOperations.multiplicativeInverse(negative).toString());
  }
  
  /**
   * Tests if able to subtract whole numbers.
   */
  @Test
  void negativeFractionsSubWholeNumbers()
  {
    
    // whole number subtract neg number first
    MixedFraction f1 = new MixedFraction(-1, 0, 0);
    MixedFraction f2 = new MixedFraction(2, 0, 0);
    MixedFraction result1 = new MixedFraction(-3, 0, 0);
    assertEquals(result1.toString(), SignedMixedFractionOperations.sub(f1, f2).toString());
    
    // whole number subtract neg number last
    MixedFraction f3 = new MixedFraction(1, 0, 0);
    MixedFraction f4 = new MixedFraction(-2, 0, 0);
    MixedFraction result2 = new MixedFraction(3, 0, 0);
    assertEquals(result2.toString(), SignedMixedFractionOperations.sub(f3, f4).toString());

  }
  
  /**
   * Tests if able to add negative whole numbers.DOES PASS
   * NULL Exception error. 
   */
  @Test
  void negativeFractionsAddWholeNumbers()
  { 
    // not working
    // tests negative whole numbers add first neg
    MixedFraction f1 = new MixedFraction(-3, 0, 0);
    MixedFraction f2 = new MixedFraction(2, 0, 0);
    MixedFraction result1 = new MixedFraction(1, 0, 0);
    assertEquals(result1.toString(), SignedMixedFractionOperations.add(f1, f2).toString());
    
    // tests negative whole numbers add last neg
    MixedFraction f3 = new MixedFraction(-1, 0, 0);
    MixedFraction f4 = new MixedFraction(2, 0, 0);
    MixedFraction result2 = new MixedFraction(1, 0, 0);
    assertEquals(result2.toString(), SignedMixedFractionOperations.add(f3, f4).toString());
    
    // tests negative whole numbers add both neg
    MixedFraction f5 = new MixedFraction(-1, 0, 0);
    MixedFraction f6 = new MixedFraction(-2, 0, 0);
    MixedFraction result3 = new MixedFraction(-3, 0, 0);
    assertEquals(result3.toString(), SignedMixedFractionOperations.add(f5, f6).toString());
  }
  
  /**
   * Tests if able to multiply negative whole numbers.
   */
  @Test
  void negativeFractionsMultiWholeNumbers()
  { 
    // tests negative whole numbers first neg
    MixedFraction f1 = new MixedFraction(-1, 0, 0);
    MixedFraction f2 = new MixedFraction(2, 0, 0);
    MixedFraction result1 = new MixedFraction(-2, 0, 0);
    assertEquals(result1.toString(), SignedMixedFractionOperations.multi(f1, f2).toString());
    
    // tests negative whole numbers last neg
    MixedFraction f3 = new MixedFraction(1, 0, 0);
    MixedFraction f4 = new MixedFraction(-2, 0, 0);
    MixedFraction result2 = new MixedFraction(-2, 0, 0);
    assertEquals(result2.toString(), SignedMixedFractionOperations.multi(f3, f4).toString());
    
    // tests negative whole numbers both neg
    MixedFraction f5 = new MixedFraction(-1, 0, 0);
    MixedFraction f6 = new MixedFraction(-2, 0, 0);
    MixedFraction result3 = new MixedFraction(2, 0, 0);
    assertEquals(result3.toString(), SignedMixedFractionOperations.multi(f5, f6).toString());
  }
  
  /**
   * Tests if able to divide negative whole numbers.
   */
  @Test
  void negativeFractionsDivideWholeNumbers()
  { 
    // tests negative whole numbers first neg
    MixedFraction f1 = new MixedFraction(-2, 0, 0);
    MixedFraction f2 = new MixedFraction(2, 0, 0);
    MixedFraction result1 = new MixedFraction(-1, 0, 0);
    assertEquals(result1.toString(), SignedMixedFractionOperations.divide(f1, f2).toString());
    
    // tests negative whole numbers first last neg
    MixedFraction f3 = new MixedFraction(-2, 0, 0);
    MixedFraction f4 = new MixedFraction(2, 0, 0);
    MixedFraction result2 = new MixedFraction(-1, 0, 0);
    assertEquals(result2.toString(), SignedMixedFractionOperations.divide(f3, f4).toString());
    
    // tests negative whole numbers both negative
    MixedFraction f5 = new MixedFraction(-2, 0, 0);
    MixedFraction f6 = new MixedFraction(-2, 0, 0);
    MixedFraction result3 = new MixedFraction(1, 0, 0);
    assertEquals(result3.toString(), SignedMixedFractionOperations.divide(f5, f6).toString());
  }
  

  
  /**
   * Tests if able to subtract negative improper fractions.
   */
  @Test
  void negativeFractionsSubtractImpropFrac()
  { 
    // tests negative whole numbers add first neg
    MixedFraction f1 = new MixedFraction(0, -1, 2);
    MixedFraction f2 = new MixedFraction(0, 1, 3);
    MixedFraction result1 = new MixedFraction(0, -5, 6);
    assertEquals(result1.toString(), SignedMixedFractionOperations.sub(f1, f2).toString());
    
    // tests negative whole numbers add second neg
    MixedFraction f3 = new MixedFraction(0, 1, 2);
    MixedFraction f4 = new MixedFraction(0, -1, 3);
    MixedFraction result2 = new MixedFraction(0, 5, 6);
    assertEquals(result2.toString(), SignedMixedFractionOperations.sub(f3, f4).toString());
    
    // tests negative whole numbers add both neg
    MixedFraction f5 = new MixedFraction(0, -1, 2);
    MixedFraction f6 = new MixedFraction(0, -1, 3);
    MixedFraction result3 = new MixedFraction(0, -1, 6);
    assertEquals(result3.toString(), SignedMixedFractionOperations.sub(f5, f6).toString());
  }
  
 
  
  // signed mixed fraction test cases
  
  /**
  
  
  /**
   * 
   */
  @Test
  void testIntegerPower() 
  {
    // tests a generic case.
    test1ans = new MixedFraction(27, 46, 49);
    assertEquals(test1ans.toString(), OtherMixedFractionOperations.integerPower(test1, 2).toString());
    
    // tests bigger power.
    test1ans = new MixedFraction(4125, 15082, 16807);
    assertEquals(test1ans.toString(), OtherMixedFractionOperations.integerPower(test1,  5).toString());
    
    // tests negative.
    negativeans = new MixedFraction(2, 1, 4);
    assertEquals(negativeans.toString(), OtherMixedFractionOperations.integerPower(negative,  2).toString());
    
  }
  
  @Test
  void testReduce()
  {
    // from 27/9 to 3. 
    MixedFraction improper = new MixedFraction(0, 27, 9);
    assertEquals("3", OtherMixedFractionOperations.reduce(improper).toString());
    
    // From 38/3 to 12 2/3.
    MixedFraction improper2 = new MixedFraction(0, 38, 3);
    MixedFraction proper2 = new MixedFraction(12, 2, 3);
    assertEquals(proper2.toString(), OtherMixedFractionOperations.reduce(improper2).toString());
    
  }
  
  @Test
  void testMediant()
  {
    // All of the acceptance criteria example cases.
    MixedFraction medTest = new MixedFraction(1, 2, 3);
    MixedFraction medTest1 = new MixedFraction(2, 4, 5);
    MixedFraction medAns = new MixedFraction(0, 19, 8);
    assertEquals(medAns.toString(), OtherMixedFractionOperations.mediant(medTest, medTest1).toString());
    
    MixedFraction medExample = new MixedFraction(0, 1, 1);
    MixedFraction medExample2 = new MixedFraction(0, 1, 2);
    MixedFraction medExAns = new MixedFraction(0, 2, 3);
    assertEquals(medExAns.toString(), OtherMixedFractionOperations.mediant(medExample, medExample2).toString());
    
    MixedFraction medExample3 = new MixedFraction(0, 3, 5);
    assertEquals(medExample3.toString(), OtherMixedFractionOperations.mediant(medExample2, medExAns).toString());  
  }
 

}
