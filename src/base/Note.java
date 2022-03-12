package base;

import java.io.Serializable;
/** import java.util.Date for Date datatype*/
import java.util.Date;
import java.util.Objects;

/** a class with 2 subclass of ImageNote and TextNote*/
public class Note implements Comparable<Note>,Serializable{
	/** parameter in superclass*/
	private Date date;
	private String title;

	/** construct a Note object using title and current time*/
	public Note(String title){
		this.title = title;
		this.date = new Date(System.currentTimeMillis());
	}

	/** return caller's (Note object) title*/
	public String getTitle(){
		return title;
	}

	/** hashCode note placeholder*/
	@Override
	public int hashCode(){
		return Objects.hash(title);
	}

	/** equals method generated from 'Source' (need to be modified otherwise would not work)*/
	// equals compare subclass instead (bug)
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if(!(obj instanceof Note)){
			return false;
		}
		Note other = (Note) obj;
		return Objects.equals(title, other.title);
	}

	/** return date comparison of notes (Trying Date.compareTo, 0=equals, 1 = after o, -1 = before o)
	 * in other words, may need flip result*/
	@Override// may need other method than compareTo since larger date is smaller here
	public int compareTo(Note o){
		return -(this.date.compareTo(o.date)); // flip result since more recent need smaller value instead of larger
	}

	/** print date and title of each note*/
	public String toString(){
		return date.toString() + "\t" + title;
	}
	/*public boolean equals(Note note) {
		if (title.equals(note.getTitle())){
			return true;
		}
		return false;
	}*/
	//System.out.println("current " + this.title);
	//System.out.println("comparing " + other.title);

}




