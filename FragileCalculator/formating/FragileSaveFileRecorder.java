package formating;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import math.MixedFraction;

/**
 * Takes in inputs of operands and mixedFractions, and converts them into a file. File format as
 * follows slash style format fraction (toString) (newline) operator ... Ex: 2 1/3 + 3 1/3 = 5 2/3
 * 
 * @author Max
 *
 */
public class FragileSaveFileRecorder
{
  public static final String TXT = ".txt";
  public static final String SAVE = "saves\\";

  private static final String NEW_LINE = "\n";

  // white list of acceptable characters for file
  char[] acceptableInputs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '/', '*',
      ' '};

  /**
   * Takes in arraylist of the recorded mixedFractions and Ops, then outputs a plaintext .frac text
   * file in the saves folder.
   * 
   * @param recordedFrac
   * @param recordedOps
   * @param name of file
   */
  public static void createSave(final ArrayList<MixedFraction> recordedFrac,
      final ArrayList<String> recordedOps, final String name)
  {
    File saveFile;
    try
    {
      saveFile = new File(SAVE + name + TXT);
      saveFile.getParentFile().mkdir();
      saveFile.createNewFile();
    } catch (IOException e)
    {
      System.out.println("Failure in save file creation!");
      return;
    }

    // File Format

    try
    {
      FileWriter fWrite = new FileWriter(saveFile);
      String writeString = new String();
      for (int i = 0; i < recordedFrac.size(); i++)
      {
        writeString += recordedFrac.get(i).toString() + NEW_LINE;
        if (i < recordedOps.size())
          writeString += recordedOps.get(i) + NEW_LINE;
      }

      fWrite.write(writeString);
      fWrite.close();
    } catch (IOException e)
    {
      System.out.println("Failure in writing to file!");
    }
  }

  /**
   * Reads save, and populates a fraction an operator array based off of save file.
   * 
   * @param fileName name of file
   * @return returns a FragileSaveFile object which contains contents of saveFile
   */
  public static FragileSaveFile readSave(final String fileName)
  {
    File saveFile;
    ArrayList<MixedFraction> savedFractions = new ArrayList<MixedFraction>();
    ArrayList<String> savedOps = new ArrayList<String>();

    try
    {
      saveFile = new File(SAVE +fileName);

      Scanner scan = new Scanner(saveFile);
      while (scan.hasNextLine())
      {
        String fractionString = scan.nextLine();
        MixedFraction currentFraction = new MixedFraction(fractionString);
        savedFractions.add(currentFraction);
        // breaks if no operator
        if (!scan.hasNextLine())
          break;
        String operatorString = scan.nextLine();
        savedOps.add(operatorString);
      }
    } catch (IOException e)
    {
      System.out.println("Error reading save file!");
    }
    if (savedFractions.size() == 0)
      return null;
    return new FragileSaveFile(savedFractions, savedOps);
  }
}
