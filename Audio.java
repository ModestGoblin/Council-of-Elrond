import java.util.*;
import java.text.*;
public class Audio extends Item {
    public Audio(String s) {
        super(s);
    }
    public String getShoppingInfo() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return name+","+sdf.format(date)+","+quantity;
    }
	public String getInfo(){ //Returns sNo, Name, Artist name, etc in a string
        return name + "\t" + creator + "\t" + price + "\t" + quantity;
	}
    public String getListInfo() {
        return getInfo();
    }
    public String toFile() {
        return "A"+sNo+","+name+","+creator+","+price+","+quantity;
    }
	@Override
	public int getPrice(){ //override
        return price;
	}
}
