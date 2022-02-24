package base;

/** allow the use of ArrayList*/
import java.util.ArrayList;
import java.util.Objects;

/** a class with its own name and an ArrayList of Note object*/
public class Folder {
	private ArrayList<Note> notes;
	private String name;

	/** construct a Folder object with name and
	 *  in process create a new empty ArrayList of Note*/
	public Folder(String name){
		notes = new ArrayList<Note>();
		this.name = name;
	}

	/** add a Note object to Folder's ArrayList*/
	public void addNote(Note note){
		notes.add(note);
	}

	/** return caller's (Folder) name*/
	public String getName(){
		return name;
	}

	/** return caller's (Folder) ArrayList of Note*/
	public ArrayList <Note> getNotes(){
		return notes;
	}

	/** hashCode note placeholder*/
	@Override
	public int hashCode(){
		return Objects.hash(name);
	}

	/** toString overriding method modified from Source based on lab notes,
	 *   count number of TextNote and ImageNote in Folder,
	 *   then print those number along with folder name*/
	@Override
	public String toString() {
		int nText = 0;
		int nImage = 0;
		// TODO

		for (Note note : this.getNotes()){
			/** instanceof is for finding out if note is TextNote subclass or not*/
			if (note instanceof TextNote){
				nText++;
			}

			else{
				nImage++;
			}
		}

		return name + ":" + nText + ":" + nImage;
	}

	/** equals overriding method from Source*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
