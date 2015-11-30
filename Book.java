/*
* Description: Class for all Book items. All book items have their details dealt with and manipulated using the code below
*/
public class Book extends Readable {//class that contains information on Book items
    public Book(String s) {//constructor
        super(s);//call parent
    }//end constructor
	@Override
	public int getPrice(){ // override to get the item price and add 2% (Environment Tax)
        return (int)(price + price * 0.02);//return price with tax
	}//end getPrice
	public String getListInfo(){ //Based on the value of Type(Book or eBook) print the list of Items
        return super.getListInfo() + "\tBook";//return info on Book
	}//end getListInfo
}//end Book Class
