package math;

/**
 * Other mixed fraction operations. Includes operations Mediant, 
 * Multiplicative Inverse, Integer Power and Simplification (reduce).
 * 
 * @author Team05
 *
 */

public class OtherMixedFractionOperations 
{

  /**
   * Calculates the multiplicative inverse of two mixed fractions.
   * Example: Let A b/c be the mixed fraction. First turn it into an improper
   * fraction by (Ac + b)/c. Then switch the numerator and the denominator. 
   * 5 2/7 = 37/7, and the multiplicative inverse is 7/37.
   * 
   * @param value1 the first mixed fraction.
   * @return the multiplicative inverse of two mixed fraction. 
   */
  public static MixedFraction multiplicativeInverse(final MixedFraction value1)
  {
    return new MixedFraction(0, value1.getDenominator(), value1.getIrreducedNum());
  }
  
  /**
   * Calculates the power of a mixed fraction. 
   * Multiply the numerator and denominator by themselves as many times as is
   * the integer power value.
   * Example: (3/8)^2 = 3/8 * 3/8 = 9/64.
   * 
   * @param value1 the first mixed fraction.
   * @param value2 the integer power.
   * @return the integer power of the fraction.
   */
  public static MixedFraction integerPower(final MixedFraction value1,
      final Integer value2) 
  {
    int powerNumerator = (int) Math.pow(value1.getIrreducedNum(), value2);
    int powerDenominator = (int) Math.pow(value1.getDenominator(), value2);
    
    return new MixedFraction(0, powerNumerator, powerDenominator);
  }
  
  /**
   * Calculates the mediant of two mixed fractions.
   * Example: The mediant of 1 2/3 and 2 4/5 would be 19/8 or 2 3/8.
   * 
   * @param value1 the first mixed fraction value.
   * @param value2 the second mixed fraction value.
   * @return the mediant of two mixed fractions.
   */
  public static MixedFraction mediant(final MixedFraction value1,
      final MixedFraction value2)
  {
    int mediantNum = value1.getIrreducedNum() + value2.getIrreducedNum();
    int mediantDen = value1.getDenominator() + value2.getDenominator();
    return new MixedFraction(0, mediantNum, mediantDen);
  }
  
  /**
   * Simplifies an improper fraction to a mixed fraction.
   * Example: 19/8 would be 2 3/8.
   * 
   * @param frac the fraction to be simplified. 
   * @return the fully simplified fraction.
   */
  public static MixedFraction reduce(final MixedFraction frac) 
  {
    int propNumerator = (frac.getNumerator() % frac.getDenominator());
    return new MixedFraction(frac.getWhole(), propNumerator, frac.getDenominator());
  }


}
