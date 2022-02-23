package formating;

import java.util.ArrayList;

import math.MixedFraction;

/**
 * Stores data for staging.
 * @author Max
 *
 */
public class FragileRecordStaging
{

  private ArrayList<MixedFraction> fractions;
  private ArrayList<String> ops;

  /**
   * Blank constructor for init.
   */
  public FragileRecordStaging()
  {
    fractions = new ArrayList<MixedFraction>();
    ops = new ArrayList<String>();
  }

  /**
   * Recording constructor which feeds in data.
   * 
   * @param fractions
   * @param ops
   */
  public FragileRecordStaging(final ArrayList<MixedFraction> fractions, final ArrayList<String> ops)
  {
    this();
    this.fractions.addAll(fractions);
    this.ops.addAll(ops);
  }

  /**
   * add single operand to be saved.
   * @param o single operator
   */
  public void addOp(final String o)
  {
    ops.add(o);
  }

  /**
   * add array of operands to be saved.
   * @param o array of operators
   */
  public void addOps(final ArrayList<String> o)
  {
    ops.addAll(o);
  }

  /**
   * Add fraction to be saved.
   * @param f a fraction
   */
  public void addFraction(final MixedFraction f)
  {
    fractions.add(f);
  }

  /**
   * add array of fractions to be saved.
   * @param f an array of fractions
   */
  public void addFractions(final ArrayList<MixedFraction> f)
  {
    this.fractions.addAll(f);
  }

  /**
   * Creates save with current info in staging.
   */
  public void createSave ()
  {
    FragileSaveFileRecorder.createSave(fractions, ops, "FragileMath");
  }
  
  /**
   * creates a save with file name of file name with
   * info current in staging.
   * @param fileName of save file
   */
  public void createSave (final String fileName)
  {
    FragileSaveFileRecorder.createSave(fractions, ops, fileName);
  }
  
}
