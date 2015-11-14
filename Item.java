public abstract class Item {
	public Item(String s) {
        String data[] = s.split(", ");
        sNo = Integer.parseInt(data[0]);
        name = data[1];
        creator = data[2];
        price = Integer.parseInt(data[3]);
        quantity = Integer.parseInt(data[4]);
    }
	public abstract String getInfo();
	public abstract int getPrice();

	protected int price;
	protected int sNo;
	protected String name;
    protected String creator;
    protected int quantity;
	
}