public class MP3 extends Audio {
	@Override
	public int getPrice(){ // override and only call the parent's constructor to get the base price.
		return price;

	}
	public String getListInfo(){
		return getInfo() + "\tMP3";
	}
}