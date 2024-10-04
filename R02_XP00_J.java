public void deleteFile() {
    File somefile = new File("someFileName.txt");
    // Do something with someFile
    if (!someFile.delete()) {
        // Handle failure to delete the file   
    }
}
