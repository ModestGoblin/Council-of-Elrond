import java.util.*;
import java.text.*;
public class Readable extends Item {
    public Readable(String s) {
        super(s);
    }
    public String getShoppingInfo() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return name+","+sdf.format(date) + ","+quantity;
    }
    public String getListInfo() {
        return getInfo();
    }
	public String getInfo(){
        return name + "\t" + creator + "\t" + price + "\t" + quantity;
    } //Returns sNo, Name, Author name, etc in a string
    public String toFile() {
        return "R"+sNo+","+name+","+creator+","+price+","+quantity;
    }
	@Override
	public int getPrice(){ //override
        return price;
	}
}
