public class Book extends Readable {
	@Override
	public int getPrice(){ // override to get the item price and add 2% (Environment Tax)
		return price + price * 0.02;
	}
	public int getListInfo(){ //Based on the value of Type(Book or eBook) print the list of Items
		return getInfo() + "\tBook";
	}
}