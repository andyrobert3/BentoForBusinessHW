import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.Collections;

/**
 * Helper class to print files in directory path in a sorted manner
 */
public class Utility {
  private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  /**
   * Sorts files by size, if size equal then sort by name
   * @param files - Array of files 
   * @return sorted array of files
   */
  private static ArrayList<File> sortFilesBySize(ArrayList<File> files) {
    FileCompare fileCompare = new FileCompare();
    Collections.sort(files, fileCompare);
    return files;
  }

  /**
   * Returns array of File objects for a given directory path & its subdirectories
   * @param directoryPath - directory path to show list of files in directory & subdirectories
   * @throws NullPointerException - invalid file path
   * @throws SecurityException - no permission to read files in directory
   */
  private static ArrayList<File> getFilesFromPath(String directoryPath) throws NullPointerException, SecurityException {
    File dir = new File(directoryPath);
    ArrayList<File> filesList = new ArrayList<>();

    if (dir.exists() && dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File f : files) {
        if (f.isDirectory()) {
          ArrayList<File> subFiles = getFilesFromPath(f.getAbsolutePath());
          filesList.addAll(subFiles);
        } else {
          filesList.add(f);
        }
      }
    }

    return filesList;
  }

  
  /**
   * Prints sorted files in a given directory path
   * @param directoryPath - directory path to print files
   * @throws NullPointerException - invalid file path
   * @throws SecurityException - no permission to read files in directory
   */
  public static void printSortedFilesInPath(String directoryPath) throws NullPointerException, SecurityException {
    ArrayList<File> files = getFilesFromPath(directoryPath);
    LOGGER.info("Files have been read from path directory.");

    files = sortFilesBySize(files);
    LOGGER.info("Files have been sorted by size.");
    
    System.out.println("=================================================================");
    for (File file : files) {
      System.out.println("Path: " + file.getAbsolutePath() + "\nName: " + file.getName() + "\nSize: " + file.length()/1000 + " kilobytes");
      System.out.println("=================================================================");
    }
  }
}