/*
* Name: Thomas Sikma Graham Van Deventer Nezar Dimitri
* MacID: sikmat vandevgm dimitn
* Student Number: 1428584 1404877 1422586
* Description: The main class. This file will be used by the user, and has access to all other classes, calling them when needed
*/
//(contains the main method)
public class HWK4_MACID {//class containing main method
    public static void main(String[] args) {//main method
        UserInterface ui = new UserInterface();//create a new user interface for page naviagtion and display
        while (true) {//continue repeating forever
        	ui.changeCurrentPage(ui.getCurrentPage());//change the page, based on inputs and outcomes of user action on currently displayed page
    	}//end while loop
    }//end of main
}//emd of class HWK4
