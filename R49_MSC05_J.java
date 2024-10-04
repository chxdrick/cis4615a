class ReadNames {
  private Vector<String> names = new Vector<String>();
  private final InputStreamReader input;
  private final BufferedReader reader;
 
  public static final int fileSizeLimit = 1000000;
  
  public ReadNames(String filename) throws IOException {
    long size = Files.size( Paths.get( filename));
    if (size > fileSizeLimit) {
      throw new IOException("File too large");
    } 
    else if (size == 0L) {
      throw new IOException("File size cannot be determined, possibly too large");
    }
    this.input = new FileReader(filename);
    this.reader = new BufferedReader(input);
  }
 
  public void addNames() throws IOException {
    try {
      String newName;
      while (((newName = reader.readLine()) != null) &&
             !(newName.equalsIgnoreCase("quit"))) {
        names.addElement(newName);
        System.out.println("adding " + newName);
      }
    } finally {
      input.close();
    }
  }
 
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Arguments: [filename]");
      return;
    }
    ReadNames demo = new ReadNames(args[0]);
    demo.addNames();
  }
}
