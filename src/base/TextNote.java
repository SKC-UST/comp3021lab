package base;
// For import textnote from file
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
// Export textnote to file
import java.io.BufferedWriter;
import java.io.FileWriter;

/** TextNote is subclass of Note with own String data type*/
public class TextNote extends Note implements Serializable{
	String content;

	/** construct TextNote with title and call superclass' constructor*/
	public TextNote(String title){
		super(title);
	}

	/** overloading constructor if have content*/
	public TextNote(String title, String content){
		super(title);
		this.content = content;
	}

	/**
	* load a TextNote from File f
	* the tile of the TextNote is the name of the file
	* the content of the TextNote is the content of the file
	*
	* @param File f
	*/
	public TextNote (File f){
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
		//System.out.println(this.content);
	}
	/**
	* get the content of a file
	* @param absolutePath of the file
	* @return the content of the file
	*/
	private String getTextFromFile(String absolutePath){
		FileInputStream fis = null;
		ObjectInputStream in = null; // both stream to null first
		String result = "";
		try{
			fis = new FileInputStream(absolutePath); // using the inputted file
			in = new ObjectInputStream(fis); // object output to file
			TextNote n = (TextNote)in.readObject(); // create a new object from file content
			in.close(); // close stream
			//fis.close();
			result = n.content; // constructing object's folders is the one in file
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;

	}

	/**
	* export text note to file
	* @param pathFolder path of the folder where to export the note
	* the file has to be named as the title of the note with extension ".txt"
	* if the tile contains white spaces " " they has to be replaced with underscores "_"
	*/
	public void exportTextToFile (String pathFolder){
		if (pathFolder == ""){
			pathFolder = "."; // save file to current directory
		}
		File file = new File(pathFolder + File.separator + this.getTitle().replaceAll(" ", "_") +".txt");
		FileOutputStream fos = null;
		ObjectOutputStream out = null; // set both stream to null frst, above is make new file object with formatted filename
		try{
			//System.out.println(this);
			fos = new FileOutputStream(file); // new file is output
			out = new ObjectOutputStream(fos); // object output to that file
			out.writeObject(this.content); // write current object's content to file
			out.close(); // close stream
			//fos.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
