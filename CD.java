public class CD extends Audio { /*the objects of CD class will now receive all fields & methods of Audio(it's parent class) */
	@Override /*Child class's getPrice & getListInfo replace the behavior of thier parent's methods by redefining them */
	public int getPrice(){ // override to get the item price and add 2% (Environment Tax)
		return price + price * 0.02;

	}
	public String getListInfo(){
		return getInfo() + "\tCD";
	}
}