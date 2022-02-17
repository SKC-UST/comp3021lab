package base;

/** import java.util.Date for Date datatype*/
import java.util.Date;

/** a class with 2 subclass of ImageNote and TextNote*/
public class Note {
	/** parameter in superclass*/
	private Date date;
	private String title;

	/** construct a Note object using title and current time*/
	public Note(String title){
		this.title = title;
		date = new Date(System.currentTimeMillis());
	}

	/** return caller's (Note object) title*/
	public String getTitle(){
		return this.title;
	}

	/** equals method generated from 'Source' overridden by method below*/
	// equals compare subclass instead (bug)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/** just compare the title of the caller and parameter's title,
	 *  return true if same and false otherwise. Further note that if use the
	 *  original override function from Source directly, it would lead to bug that
	 *  the program also create note for second Photography which has different
	 *  subclass than the first one despite having same title and folder. As a result,
	 *  the program would totally create 12 notes instead of 11 as in sample.*/
	public boolean equals(Note note) {
		if (title.equals(note.getTitle())){
			return true;
		}
		return false;
	}
	//System.out.println("current " + this.title);
	//System.out.println("comparing " + other.title);

}




