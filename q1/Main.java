public class Main {
  public static void main(String[] args) {
    try {
      String directoryPath = args[0]; 
      Utility.printSortedFilesInPath(directoryPath);  
    } catch(IndexOutOfBoundsException ioe) {
      System.out.println("Path argument was not entered.\nPlease enter the directory path e.g `java Main [path]` .");
    } catch (NullPointerException npe) {
      System.out.println(args[0] + " is not a valid path.\nPlease enter a valid directory path.");
    } catch(SecurityException se) {
      System.out.println("No permission to read files in directory: " + args[0]);
    }
  }
}