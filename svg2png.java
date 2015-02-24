import java.io.*;
/**
Converts all .svg in the current directory files to .png in the same directory
Easier to move the files here than rewrite the program.
Uses inkscape to do the conversion. So inkscape cannot move.
You should make sure there are no duplicate files.
**/

public class svg2png{

public static String pngDirectory;
public static String svgDirectory;

public static void main(String[] args){
  if (args.length < 2) {
    System.out.println("Usage: java svgDirectory pngDirectory");
    return;
  }
  svgDirectory = args[0];
  File directory = new File(svgDirectory);
  File[] flist = directory.listFiles();
  pngDirectory = args[1];
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

	if("svg".equalsIgnoreCase(extension)){
		System.out.println(" " + name + " is svg");
		convertFile(name);
	}
}

public static void convertFile(String name){
	try{Runtime rt = Runtime.getRuntime();
	   rt.exec("inkscape -f " + svgDirectory + "\\" + name + 
        ".svg -e " + pngDirectory + "\\" + name + ".png");
	} catch(Exception e){
	}
}
}	