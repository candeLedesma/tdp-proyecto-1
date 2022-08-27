package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		Student estudiante = new Student(135330,"Ledesma","Candela","candelaledesmapm@gmail.com", "https://github.com/candeLedesma", "chickenIcon.png");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
					SimplePresentationScreen window = new SimplePresentationScreen(estudiante);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
}