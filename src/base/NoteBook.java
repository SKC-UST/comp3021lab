package base;
/** import it for using ArrayList*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** NoteBook class with an ArrayList of Folder objects*/
public class NoteBook {
	private ArrayList<Folder> folders;

	/** construct NoteBook class which initiate an
	 * empty ArrayList for Folder objects*/
	public NoteBook(){
		folders = new ArrayList<Folder>();
	}

	/** call constructor to make new TextNote then insert it to a folder with folderName*/
	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
	}

	/** placeholder to put it in Notebook instead in Textnote*/
	// Overloading method createTextNote
	public boolean createTextNote(String folderName, String title, String content){
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}

	/** call constructor to make new ImageNote then insert it to a folder with folderName*/
	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title);
		return insertNote(folderName, note);
	}

	/** return caller's (NoteBook) ArrayList of Folder*/
	public ArrayList<Folder> getFolders() {
		return folders;
	}

	/** return true if insertion successful and false otherwise*/
	public boolean insertNote(String folderName, Note note) {
		/** find if there is already a Folder with folderName in caller's (NoteBook) ArrayList,
		 *  use that one if already exist*/
		Folder f = null;
		for (Folder f1 : folders) {
			// equals usable there (String.equals())
			if(f1.getName().equals(folderName)){
				f = f1;
			}
		}
		/** if not, add a new Folder with folderName to caller's (NoteBook) ArrayList,
		 *  use this one for following operation*/
		if (f == null) {
			f = new Folder(folderName);
			folders.add(f);
		}
		/** find if there is already a Note in Folder with same name as parameter note's,
		 *  insertion fail if there is (print error message and return false), success otherwise
		 *  (add note to Folder's ArrayList and return true)*/
		for (Note n : f.getNotes()) {
			if(note.equals(n)){
				System.out.println("Creating note " + note.getTitle() + " under folder " + folderName + " failed");
				return false;
			}
		}
		f.addNote(note);
		return true;

	}

	/** sort notes in each folder in date order ->sort folders in string order, smaller first*/
	public void sortFolders(){
		for (Folder f1 : this.folders) {
			f1.sortNotes(); // sort notes for each notes in a folder
		}
		Collections.sort(this.folders); // type casting the array list to list, changes made to array list

	}

	/** search all note in all folder*/
	public List<Note> searchNotes(String keywords){
		List<Note> notes = new ArrayList<Note>();
		for (Folder f1 : folders) { // all folder
			List<Note> e = f1.searchNotes(keywords); // get search result from a folder
			if(e != null && !e.isEmpty()){ // not empty result
				notes.addAll(e); // add item in notes
			}
		}
		return notes;
	}
}
