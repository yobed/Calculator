package math;

/**
 * 
 * @author team05
 * @version nov17
 */
public class SignedMixedFractionOperations
{

  /**
   * Adds mixed fractions and whole numbers together signed.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction
   */
  public static MixedFraction add(final MixedFraction valOne, final MixedFraction valTwo)
  {
    boolean valOneSign = MixedFraction.isNegativeHelper(valOne.getWhole(), valOne.getNumerator(),
        valOne.getDenominator());
    boolean valTwoSign = MixedFraction.isNegativeHelper(valTwo.getWhole(), valTwo.getNumerator(),
        valTwo.getDenominator());
    MixedFraction resultFrac = null;
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

    // if only valOne is negative
    if (valOneSign)
    {
      // if the denominator is zero
      if (valOne.getDenominator() == 0)
      {
        valOneNum = 0;
        valOneDenom = 1;
      }
    }

    // if only valTwo is negative
    if (valTwoSign)
    {
      if (valTwo.getDenominator() == 0)
      {
        valTwoNum = 0;
        valTwoDenom = 1;
      }
    }
    // if valOne and valTwo are both negative or both positive
    if ((!(valOneSign) && !(valTwoSign))
        || (valOneSign && valTwoSign))
    {
      resultFrac = MixedFractionOperations.add(valOne, valTwo);
      return resultFrac;
    }

    // if the whole number is not present for either
    if (valOne.getWhole() == 0 && valTwo.getWhole() == 0)
    {
      newDenom = valOneDenom * valTwoDenom;
      valOneNum = valOneNum * valTwoDenom;
      valTwoNum = valTwoNum * valOneDenom;
      newNum = valTwoNum - valOneNum;
      newWhole = newNum / newDenom;
      newNum = newNum % newDenom;
      int gcd = MixedFractionOperations.gcd(newNum, newDenom);
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
      int gcd = MixedFractionOperations.gcd(newNum, newDenom);
      MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
      return answer;
    }

  }

  /**
   * Subtracts mixed fractions and whole numbers together signed.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction
   */
  public static MixedFraction sub(final MixedFraction valOne, final MixedFraction valTwo)
  {
    boolean valOneSign = MixedFraction.isNegativeHelper(valOne.getWhole(), valOne.getNumerator(),
        valOne.getDenominator());
    boolean valTwoSign = MixedFraction.isNegativeHelper(valTwo.getWhole(), valTwo.getNumerator(),
        valTwo.getDenominator());
    MixedFraction resultFrac = null;
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

    // if only valOne is negative
    if (valOneSign)
    {
      MixedFraction answer = null;
      // if the whole number is not present for either
      if (valOne.getWhole() == 0 && valTwo.getWhole() == 0)
      {
        newDenom = valOneDenom * valTwoDenom;
        valOneNum = valOneNum * valTwoDenom;
        valTwoNum = valTwoNum * valOneDenom;
        newNum = valOneNum - valTwoNum;
        newWhole = newNum / newDenom;
        newNum = newNum % newDenom;
        int gcd = MixedFractionOperations.gcd(newNum, newDenom);
        answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
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
        int gcd = MixedFractionOperations.gcd(newNum, newDenom);
        answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
        
      }
      return answer;
    }

    // if onlt valTwo is negative
    if (valTwoSign)
    {
      MixedFraction answer = null;
      // if the whole number is not present for either
      if (valOne.getWhole() == 0 && valTwo.getWhole() == 0)
      {
        newDenom = valOneDenom * valTwoDenom;
        valOneNum = valOneNum * valTwoDenom;
        valTwoNum = valTwoNum * valOneDenom;
        newNum = valOneNum - valTwoNum;
        newWhole = newNum / newDenom;
        newNum = newNum % newDenom;
        int gcd = MixedFractionOperations.gcd(newNum, newDenom);
        answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
        
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
        int gcd = MixedFractionOperations.gcd(newNum, newDenom);
        answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
        
      }
      return answer;

    }

    // if valOne and valTwo are both negative or both positive
    if ((!(valOneSign) && !(valTwoSign))
        || (valOneSign && valTwoSign))
    {
      resultFrac = MixedFractionOperations.subtract(valOne, valTwo);
    }

    return resultFrac;

  }

  /**
   * Multiplies mixed fractions and whole numbers together signed.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction
   */
  public static MixedFraction multi(final MixedFraction valOne, final MixedFraction valTwo)
  {
    boolean valOneSign = MixedFraction.isNegativeHelper(valOne.getWhole(), valOne.getNumerator(),
        valOne.getDenominator());
    boolean valTwoSign = MixedFraction.isNegativeHelper(valTwo.getWhole(), valTwo.getNumerator(),
        valTwo.getDenominator());

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

    // initalize variable
    MixedFraction fracresult = new MixedFraction(0, 0, 0);


    // if only valOne is negative
    if ((valOneSign) || (valTwoSign))
    {
      newDenom = valOneDenom * valTwoDenom;
      valOneNum = valOneNum * valTwoDenom;
      valTwoNum = valTwoNum * valOneDenom;
      newNum = valOneNum * valTwoNum;
      newDenom = newDenom * newDenom;
      newWhole = valOneWhole * valTwoWhole;
      MixedFraction answer = new MixedFraction(newWhole, newNum, newDenom);
      fracresult = answer;

    }

    // if valOne and valTwo are both negative or both positive
    if ((!(valOneSign) && !(valTwoSign))
        || (valOneSign && valTwoSign))

    {
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
        int gcd = MixedFractionOperations.gcd(newNum, newDenom);
        MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
        fracresult = answer;
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
        int gcd = MixedFractionOperations.gcd(newNum, newDenom);
        MixedFraction answer = new MixedFraction(newWhole, newNum / gcd, newDenom / gcd);
        fracresult = answer;
      }
    }
    return fracresult;
  }

  /**
   * Divide mixed fractions and whole numbers together signed.
   * 
   * @param valOne
   * @param valTwo
   * @return MixedFraction
   */
  public static MixedFraction divide(final MixedFraction valOne, final MixedFraction valTwo)
  {
    boolean valOneSign = MixedFraction.isNegativeHelper(valOne.getWhole(), valOne.getNumerator(),
        valOne.getDenominator());
    boolean valTwoSign = MixedFraction.isNegativeHelper(valTwo.getWhole(), valTwo.getNumerator(),
        valTwo.getDenominator());
    MixedFraction resultFrac = null;

    if ((valOneSign) || (valTwoSign))
    {
      resultFrac = MixedFractionOperations.divide(valOne, valTwo);
    }

    // if valOne and valTwo are both negative or both positive
    if ((!(valOneSign) && !(valTwoSign))
        || (valOneSign && valTwoSign))
    {
      resultFrac = MixedFractionOperations.divide(valOne, valTwo);
    }

    return resultFrac;
  }

}
