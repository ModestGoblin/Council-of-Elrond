public class ShoppingCart extends User {
	private ArrayList<Item> content; //array of items
	public String getContent(){ // return the content of the shopping cart
		String ret = "";
        for (Item i : content) {
            ret += i.getListInfo() + "\n";
        }
        return ret;

	}
	public AddItem(Item i){
		content.add(i);	
	}
}