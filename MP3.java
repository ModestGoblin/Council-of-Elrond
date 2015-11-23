/*
* Name: Thomas Sikma Graham Van Deventer Nezar Dimitri
* MacID: sikmat vandevgm dimitn
* Student Number: 1428584 1404877 1422586
* Description: All MP3 items for the store will share these characteristics and functions, that can be and will be called from other classes that demand use of them.
*/
public class MP3 extends Audio {//class that contains all info and functions on MP3 items
    public MP3(String s) {//constructor
        super(s);//call parent constructor
    }//end constructor
	@Override
	public int getPrice(){ // override and only call the parent's constructor to get the base price.
        return price;//fetch item price and return it
	}//end get price
    public String getListInfo() {//function to fetch and return all relevant information
        return super.getListInfo() + "\tMP3";//add MP3 to the string of info and return it
    }//end getListInfo
}//end class
