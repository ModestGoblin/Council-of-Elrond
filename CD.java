public class CD extends Audio {
    public CD(String s) {
        super(s);
    }
	@Override
	public int getPrice(){ // override to get the item price and add 2% (Environment Tax)
        return (int)((double)price + ((double)price * 0.02));
	}
    public String getListInfo() {
        return super.getListInfo() + "\tCD";
    }
}
