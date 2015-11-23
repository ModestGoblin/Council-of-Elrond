/*
* Name: Thomas Sikma Graham Van Deventer Nezar Dimitri
* MacID: sikmat vandevgm dimitn
* Student Number: 1428584 1404877 1422586
* Description: The eBook class is responsible for keeping track of all detail relevant to eBook Items, as well as overrwriting various functions from parent classes in order to make them more usable and relevant. 
*/
public class eBook extends Readable {//class that has all info on 
    public eBook(String s) {//constructor
        super(s);//call parent constructor
    }//end constructor
	@Override
	public int getPrice(){ // override and only call the parent's constructor to get base price.
        return price;//grab price of item and return it
	}//and getPrice
	public String getListInfo(){ //Based on the value of Type(Book or eBook) print the list of Items
        return super.getListInfo() + "\teBook";//return parent call of getList info + the word eBook
	}//end getListInfo
}..end class
