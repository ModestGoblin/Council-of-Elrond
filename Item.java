public abstract class Item {//class for all individual items in store inventory
    public Item(String s) {//constructor
        String data[] = s.split(",");//create string array based on splits at commas
        sNo = Integer.parseInt(data[0]);//sNo is first element
        name = data[1];//name if item is second
        creator = data[2];//author/artist = 3rd element
        price = Integer.parseInt(data[3]);//price held in fourth
        quantity = Integer.parseInt(data[4]);//quantity in fifth spot
    }//end constructor
    public abstract String getShoppingInfo();//abstract getInfo method will be overwritten
	public abstract String getInfo();//each item will overwrite this
	public abstract int getPrice();//each item will overwrite this
    public abstract String toFile();//each item wil overwrite this file writing item
    public String getName() {//function will return name of item
        return name;//give the name back
    }//end getName

	protected int price;//price won't be changed directly
	protected int sNo;//sNo can't be changed directly
    protected String name;//name can't be changed directly
    protected String creator;//creator can't be changed directly
    protected int quantity;//quantity is stored here
}
