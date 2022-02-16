package base;
/** import java.io.File for file datatype */
import java.io.File;

/** ImageNote is subclass of Note with own File datatype*/
public class ImageNote extends Note{
	File image;

	/** construct ImageNote with title and call superclass' constructor*/
	public ImageNote(String title){
		super(title);
	}
}

