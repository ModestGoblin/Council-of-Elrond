
public class CD extends Audio {//class containing info for CD items
    public CD(String s) {//constructor
        super(s);//call parent constructor
    }//end of constructor
	@Override
	public int getPrice(){ // override to get the item price and add 2% (Environment Tax)
        return (int)((double)price + ((double)price * 0.02));//return newly calculated price
	}//end of get price
    public String getListInfo() {//function to return info about the item
        return super.getListInfo() + "\tCD";//return information
    }//end getListInfo
}//end of class
