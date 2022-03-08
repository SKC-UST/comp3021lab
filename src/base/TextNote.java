package base;
/** TextNote is subclass of Note with own String data type*/
public class TextNote extends Note {
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


}
