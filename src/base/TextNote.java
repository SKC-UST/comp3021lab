package base;
/** TextNote is subclass of Note with own String datatype*/
public class TextNote extends Note {
	String content;

	/** construct TextNote with title and call superclass' constructor*/
	public TextNote(String title){
		super(title);
	}
}
