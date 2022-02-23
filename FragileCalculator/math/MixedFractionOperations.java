package math;

/**
 * Mixed Fractions Operation.
 * 
 * @author team05
 *
 */
public class MixedFractionOperations
{

  /**
   * Adds mixed fractions and whole numbers together.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction
   */
  public static MixedFraction add(final MixedFraction valOne, final MixedFraction valTwo)
  {
    // initalizes a MixedFraction object to be returned
    MixedFraction result = new MixedFraction(0, 0, 0);
    int newWholeNum;
    int valOneWhole = valOne.getWhole();
    int valOneNum = valOne.getNumerator();
    int valOneDenom = valOne.getDenominator();
    int valTwoWhole = valTwo.getWhole();
    int valTwoNum = valTwo.getNumerator();
    int valTwoDenom = valTwo.getDenominator();
    int newNum;
    int newDenom;
    int newWhole;

    // if the denominator is zero
    if (valOneDenom == 0)
    {
      valOneNum = 0;
      valOneDenom = 1;
    }
    if (valTwoDenom == 0)
    {
      valTwoNum = 0;
      valTwoDenom = 1;
    }
    // if the whole number is not present for either
    if (valOne.getWhole() == 0 && valTwo.getWhole() == 0)
    {
      newDenom = valOneDenom * valTwoDenom;
      valOneNum = valOneNum * valTwoDenom;
      valTwoNum = valTwoNum * valOneDenom;
      newNum = valOneNum + valTwoNum;
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    } else
    // Two normal fractions
    {
      if (valOneDenom != valTwoDenom)
      {
        newDenom = valOneDenom * valTwoDenom;
        valOneNum = valOneNum * valTwoDenom;
        valTwoNum = valTwoNum * valOneDenom;
      } else
      {
        newDenom = valOneDenom;
      }
      int n1 = (valOneWhole * newDenom) + valOneNum;
      int n2 = (valTwoWhole * newDenom) + valTwoNum;
      newNum = n1 + n2;
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    }
  }

  /**
   * Subtracts mixed fractions and whole numbers together.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction.
   */
  public static MixedFraction subtract(final MixedFraction valOne, final MixedFraction valTwo)
  {
    // initalizes a MixedFraction object to be returned
    MixedFraction result = new MixedFraction(0, 0, 0);
    int newWholeNum;
    int valOneWhole = valOne.getWhole();
    int valOneNum = valOne.getNumerator();
    int valOneDenom = valOne.getDenominator();
    int valTwoWhole = valTwo.getWhole();
    int valTwoNum = valTwo.getNumerator();
    int valTwoDenom = valTwo.getDenominator();
    int newNum;
    int newDenom;
    int newWhole;
    // if the denominator is zero
    if (valOneDenom == 0)
    {
      valOneNum = 0;
      valOneDenom = 1;
    }
    if (valTwoDenom == 0)
    {
      valTwoNum = 0;
      valTwoDenom = 1;
    }
    // if the whole number is not present for either
    if (valOne.getWhole() == 0 && valTwo.getWhole() == 0)
    {
      newDenom = valOneDenom * valTwoDenom;
      valOneNum = valOneNum * valTwoDenom;
      valTwoNum = valTwoNum * valOneDenom;
      newNum = valOneNum - valTwoNum;
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    } else
    // Two normal fractions
    {
      if (valOneDenom != valTwoDenom)
      {
        newDenom = valOneDenom * valTwoDenom;
        valOneNum = valOneNum * valTwoDenom;
        valTwoNum = valTwoNum * valOneDenom;
      } else
      {
        newDenom = valOneDenom;
      }
      int n1 = (valOneWhole * newDenom) + valOneNum;
      int n2 = (valTwoWhole * newDenom) + valTwoNum;
      newNum = n1 - n2;
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    }
  }

  /**
   * Divides mixed fractions and whole numbers together.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction
   */
  public static MixedFraction divide(final MixedFraction valOne, final MixedFraction valTwo)
  {
    MixedFraction result = new MixedFraction(0, 0, 0);
    int newWholeNum;
    int valOneWhole = valOne.getWhole();
    int valOneNum = valOne.getNumerator();
    int valOneDenom = valOne.getDenominator();
    int valTwoWhole = valTwo.getWhole();
    int valTwoNum = valTwo.getNumerator();
    int valTwoDenom = valTwo.getDenominator();
    int newNum;
    int newDenom;
    int newWhole;
    int hold;
    // if the denominator is zero
    if (valOneDenom == 0)
    {
      valOneNum = 0;
      valOneDenom = 1;
    }
    if (valTwoDenom == 0)
    {
      valTwoNum = 0;
      valTwoDenom = 1;
    }
    // if the whole number is not present for either
    if (valOne.getWhole() == 0 && valTwo.getWhole() == 0)
    {
      newDenom = valOneDenom * valTwoDenom;
      valOneNum = valOneNum * valTwoDenom;
      valTwoNum = valTwoNum * valOneDenom;

      newNum = valOneNum * newDenom;
      newDenom = valTwoNum * newDenom;
      if (newDenom == 0)
      {
        newNum = 0;
        newDenom = 1;
      }
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    } else
    // Two normal fractions
    {
      if (valOneDenom != valTwoDenom)
      {
        newDenom = valOneDenom * valTwoDenom;
        valOneNum = valOneNum * valTwoDenom;
        valTwoNum = valTwoNum * valOneDenom; // test
      } else
      {
        newDenom = valOneDenom;
      }
      int n1 = (valOneWhole * newDenom) + valOneNum;
      int n2 = (valTwoWhole * newDenom) + valTwoNum;

      newNum = n1 * newDenom;
      newDenom = n2 * newDenom;
      if (newDenom == 0)
      {
        newNum = 0;
        newDenom = 1;
      }
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    }
  }

  /**
   * Multiplies mixed fractions and whole numbers together.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction.
   */
  public static MixedFraction multiply(final MixedFraction valOne, final MixedFraction valTwo)
  {
    // initalizes a MixedFraction object to be returned
    MixedFraction result = new MixedFraction(0, 0, 0);
    int newWholeNum;
    int valOneWhole = valOne.getWhole();
    int valOneNum = valOne.getNumerator();
    int valOneDenom = valOne.getDenominator();
    int valTwoWhole = valTwo.getWhole();
    int valTwoNum = valTwo.getNumerator();
    int valTwoDenom = valTwo.getDenominator();
    int newNum;
    int newDenom;
    int newWhole;

    // if the denominator is zero
    if (valOneDenom == 0)
    {
      valOneNum = 0;
      valOneDenom = 1;
    }
    if (valTwoDenom == 0)
    {
      valTwoNum = 0;
      valTwoDenom = 1;
    }
    // if the whole number is not present for either
    if (valOne.getWhole() == 0 && valTwo.getWhole() == 0)
    {
      newDenom = valOneDenom * valTwoDenom;
      valOneNum = valOneNum * valTwoDenom;
      valTwoNum = valTwoNum * valOneDenom;
      newNum = valOneNum * valTwoNum;
      newDenom = newDenom * newDenom;
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom; // m
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    } else
    // Two normal fractions
    {
      if (valOneDenom != valTwoDenom)
      {
        newDenom = valOneDenom * valTwoDenom;
        valOneNum = valOneNum * valTwoDenom;
        valTwoNum = valTwoNum * valOneDenom;
      } else
      {
        newDenom = valOneDenom;
      }
      int n1 = (valOneWhole * newDenom) + valOneNum;
      int n2 = (valTwoWhole * newDenom) + valTwoNum;
      newNum = n1 * n2;
      newDenom = newDenom * newDenom;
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    }
  }

  // improper fraction converter method

  /**
   * Reduces fractions.
   * 
   * @param numerator
   * @param denom
   * @return MixedFraction
   */
  public static MixedFraction reduceImpropFrac(final int numerator, final int denom)

  {
    int gCD = gcd(numerator, denom);
    int num = numerator;
    int den = denom;
    num /= gCD;

    den /= gCD;

    MixedFraction result = new MixedFraction(0, num, den);
    return result;

  }

  /**
   * Finds the greatest common denom for the reduceFrac method.
   * 
   * @param numerator
   * @param denom
   * @return int
   */
  public static int gcd(final int numerator, final int denom)

  {
    int result = 1;
    if (numerator < denom)
    {
      for (int i = 1; i <= numerator && i <= denom; i++)

      {
        if (numerator % i == 0 && denom % i == 0)
        {
          result = i;
        }

      }
    }

    return result;
  }
  
}
