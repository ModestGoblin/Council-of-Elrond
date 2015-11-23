/*
* Name: Thomas Sikma Graham Van Deventer Nezar Dimitri
* MacID: sikmat vandevgm dimitn
* Student Number: 1428584 1404877 1422586
* Description: The class for all Audio items. All details regarding them will be handled and manipulated here
*/

import java.util.*;//import general utility methods required for program
import java.text.*;//import text formatting methods/functions
public class Audio extends Item {//class that contains all information regarding 
    public Audio(String s) {//Constructor
        super(s);//call parent class
    }//end constructor
    public String getShoppingInfo() {//function that returns all shopping info
        Date date = Calendar.getInstance().getTime();//grab current time and date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//create a new date object
        return name+","+sdf.format(date)+","+quantity;//return name of item, date, and quantity in store
    }//end shopping info function
	public String getInfo(){ //Returns sNo, Name, Artist name, etc in a string
        return name + "\t" + creator + "\t" + price + "\t" + quantity;//returns sNo, Name, Artist Name and quantity in a string
	}//end get info 
    public String getListInfo() {//function that will call getInfo
        return getInfo();//return what was returned from getInfo
    }//end getListInfo
    public String toFile() {//will return a string that will be written to a file, Audio.txt or a shopping cart
        return "A"+sNo+","+name+","+creator+","+price+","+quantity;//create the string and return it
    }// end toFile
	@Override
	public int getPrice(){ //override parent getPrice
        return price;//return price of item
	}//end getPrice
}//end Audio class
