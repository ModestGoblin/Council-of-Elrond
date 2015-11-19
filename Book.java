public class Book extends Readable {
    public Book(String s) {
        super(s);
    }
	@Override
	public int getPrice(){ // override to get the item price and add 2% (Environment Tax)
        return (int)(price + price * 0.02);
	}
	public String getListInfo(){ //Based on the value of Type(Book or eBook) print the list of Items
        return super.getListInfo() + "\tBook";
	}
}
