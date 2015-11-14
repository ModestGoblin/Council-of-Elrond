public class Readable extends Item {

	protected String authorName;
	public String getInfo(){
		return sNo + "\t" + name + "\t" + creator + "\t" + price + "\t" + quantity;
	} //Returns sNo, Name, Author name, etc in a string
	@Override
	public int getPrice(){ //override
		return price;
	}
}