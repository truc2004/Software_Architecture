package org.example.composite;

public class Test_Composite {
    public static void main(String[] args) {

        Folder root = new Folder("Root");

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder subFolder = new Folder("Documents");

        subFolder.add(new File("doc1.pdf"));
        subFolder.add(new File("doc2.pdf"));

        root.add(file1);
        root.add(file2);
        root.add(subFolder);

        root.display();
    }
}
