import java.io.*;
/**
Renames all the files in a given directory to 
  prefixnn
where prefix is passed in and nn is an increasing number.

usage : java renameFiles directory prefix

This approach makes it easy to move a subset of key files to a given directory and then rename. This avoids the chance or accidental pattern match. 
**/

public class renameFiles{

public static String initialDirectory;
public static String prefix;
public static int startingIndex;
public static int index;

public static void main(String[] args){
  if (args.length < 3) {
    System.out.println("Usage: java renameFiles initialDirectory  prefix startingIndex");
    return;
  }

  initialDirectory = args[0];
  prefix = args[1];
  index = Integer.parseInt(args[2]);

  File directory = new File(initialDirectory);
  File[] flist = directory.listFiles();
  for(File file: flist){
  	if(file.isFile()){
  		convertIfSvg(file.getName());
  	}
  }
}

public static void convertIfSvg(String filename){
	int dot = filename.lastIndexOf(".");
	String name = filename.substring(0, dot);
	String extension = filename.substring(dot + 1, filename.length());
	String command;
	System.out.println(filename + " -> " + prefix + index + "." + extension);
	command = "cmd /c ren " + initialDirectory + "\\" + filename + " " + prefix + index + "." + extension;
		System.out.println(command);
	try{Runtime rt = Runtime.getRuntime();
	   rt.exec(command);
	   index++;
	} catch(Exception e){
		System.out.println("error "  + e.getMessage());
		System.out.println(command);
	}
}
}	