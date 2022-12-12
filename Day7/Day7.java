package Day7;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day7 {
    public static void main(String[] args) {
        
        try {
            Scanner sc = new Scanner(new File("Day7/input.txt"));
            sc.nextLine();
            Day7 obj = new Day7();
            Folder root = obj.new Folder("/");
            Folder currentFolder = root;

            while (sc.hasNext()) {
                String nextLine = sc.nextLine();

                if (nextLine.charAt(0) == '$') {
                    if (nextLine.charAt(2) == 'c') {
                        if (nextLine.charAt(5) == '.') {
                            currentFolder = currentFolder.getParent();
                        }
                        else {
                            currentFolder = currentFolder.getFolder(nextLine.substring(5));
                        }
                    }
                }
                else if (nextLine.charAt(0) == 'd') {
                    Folder newFolder = obj.new Folder(nextLine.substring(4), currentFolder);
                    currentFolder.addFolder(newFolder);
                }
                else {
                    String[] strings = nextLine.split(" ");
                    PFile newFile = obj.new PFile(Integer.parseInt(strings[0]), strings[1]);
                    currentFolder.addFile(newFile);
                }
            }
            root.setSizes();
            root.print(0);
            System.out.println(root.sumSizesUnder(100000));
            int spaceNeeded = 30000000 - (70000000 - root.getSize());
            System.out.println(spaceNeeded);
            System.out.println(root.findMinAbove(spaceNeeded, root.getSize()));
        }        
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
        }
    }


    public class Folder {

        private ArrayList<PFile> files;
        private ArrayList<Folder> folders;
        private Folder parentFolder;
        int size;
        String name;
    
        public Folder(String name) {
            files = new ArrayList<PFile>();
            folders = new ArrayList<Folder>();
            this.name = name;
            this.parentFolder = null;
            this.size = 0;
        }
    
        public Folder(String name, Folder parentFolder) {
            files = new ArrayList<PFile>();
            folders = new ArrayList<Folder>();
            this.parentFolder = parentFolder;
            this.name = name;
        }
    
        public Folder getFolder(String name) {
            for (Folder folder: folders) {
                if (folder.getName().equals(name)) {
                    return folder;
                }
            }
            return null;
        }

        public void setSizes() {
            for (PFile file: files) {
                this.size += file.getSize();
            }
            for (Folder folder: folders) {
                folder.setSizes();
                this.size += folder.getSize();
            }
        }

        public int sumSizesUnder(int sizeLimit) {
            int sizeSum = 0;
            for (Folder folder: folders) {
                sizeSum += folder.sumSizesUnder(sizeLimit);
            }
            if (this.getSize() < sizeLimit) {
                sizeSum += this.getSize();
            }
            return sizeSum;
        }
        
        public int findMinAbove(int minSize, int currentMin) {
            if (this.size < minSize) {
                return currentMin;
            }
            currentMin = Math.min(this.size, currentMin);
            
            for (Folder folder: folders) {
                currentMin = Math.min(currentMin, folder.findMinAbove(minSize, currentMin));
            }

            return currentMin;
        }
    
        public String getName() {
            return name;
        }
    
        public void addFile(PFile file) {
            files.add(file);
        }
        public void addFolder(Folder folder) {
            folders.add(folder);
        }

        public Folder getParent() {
            return this.parentFolder;
        }
    
        public int getSize() {
            return this.size;
        }

        public void print(int depth) {
            for (int i = 0; i < depth; i++) {
                System.out.print("-");
            }
            System.out.println(this.name + ", " + this.getSize());
            
            for(PFile file: files) {
                file.print(depth + 1);
            }

            for(Folder folder: folders) {
                folder.print(depth + 1);
            }
        }
    }

    public class PFile {
        public int size;
        public String name;
    
        public PFile(int size, String name) {
            this.size = size;
            this.name = name;
        }
    
        public int getSize() {
            return size;
        }

        public void print(int depth) {
            for (int i = 0; i < depth; i++) {
                System.out.print("-");
            }
            System.out.println("FILE:" + this.name + ", " + this.getSize());
        }
    }
}

