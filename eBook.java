public class eBook extends Readable {
    public eBook(String s) {
        super(s);
    }
	@Override
	public int getPrice(){ // override and only call the parent's constructor to get base price.
        return price;
	}
	public String getListInfo(){ //Based on the value of Type(Book or eBook) print the list of Items
        return super.getListInfo() + "\teBook";
	}
}
