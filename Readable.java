
import java.util.*;//import utility functions
import java.text.*;//import text manipulating functions
public class Readable extends Item {//class containing all information on readable items (Books)
    public Readable(String s) {//constructor
        super(s);//call parent constructor
    }//end constructor
    public String getShoppingInfo() {//function to display releveant informationon the item
        Date date = Calendar.getInstance().getTime();//get current date and time
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//create a new date variable
        return name+","+sdf.format(date) + ","+quantity;//return all relevant information including date, item name and stock in sotre
    }//end getShoppingInfo
    public String getListInfo() {//fetch all info on the item
        return getInfo();//call function to grab all info
    }//end getListInfo
	public String getInfo(){//function to return all information
        return name + "\t" + creator + "\t" + price + "\t" + quantity;//return item name, author, price and quantity in store, in proper format
    } //Returns sNo, Name, Author name, etc in a string
    public String toFile() {//string that will be included in file
        return "R"+sNo+","+name+","+creator+","+price+","+quantity;//returns all information, properly formatted for the file to be written
    }//end toFile
	@Override
	public int getPrice(){ //override
        return price;//self explanatory, return vprice of item
	}//end get price
}//end class
