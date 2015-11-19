public class MP3 extends Audio {
    public MP3(String s) {
        super(s);
    }
	@Override
	public int getPrice(){ // override and only call the parent's constructor to get the base price.
        return price;
	}
    public String getListInfo() {
        return super.getListInfo() + "\tMP3";
    }
}
