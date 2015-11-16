public class MP3 extends Audio { /*the objects of MP3 class will now receive all fields & methods of Audio(it's parent class) */
	@Override
	public int getPrice(){ // override and only call the parent's constructor to get the base price.
		return price;

	}
	public String getListInfo(){
		return getInfo() + "\tMP3";
	}
}