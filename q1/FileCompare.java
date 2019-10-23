import java.io.File;
import java.util.Comparator;

/**
 * FileCompare allows custom comparator between files
 * 1. Size of file 
 * 2. Name of file (alphabetical order)
 */
public class FileCompare implements Comparator<File> {
  public int compare(File f1, File f2) {
    if (f1.length() < f2.length()) return -1;
    if (f1.length() > f2.length()) return 1;
    return f1.getName().compareTo(f2.getName());
  }
}