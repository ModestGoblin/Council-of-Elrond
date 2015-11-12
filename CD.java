public class CD extends Audio {
	@Override
	public int getPrice(){ // override to get the item price and add 2% (Environment Tax)
		return price + price * 0.02;

	}
	public String getListInfo(){
		return getInfo() + "\tCD";
	}
}