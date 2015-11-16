public class Audio extends Item { /*the objects of Audio class will now receive all fields & methods of Items(it's parent class) */
	protected String artistName;
	public String getInfo(){ //Returns sNo, Name, Artist name, etc in a string
		return sNo + "\t" + name + "\t" + creator + "\t" + price + "\t" + quantity;
	}
	@Override /*Child class's getPrice & getListInfo replace the behavior of thier parent's methods by redefining them */
	public int getPrice(){ //override
		return price;
	}
	public int getListInfo(){ //Based on the value of Type(CD or MP3) print the list of Items

	}
}