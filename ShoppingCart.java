import java.util.*;
import java.io.*;

public class ShoppingCart extends User {
	private ArrayList<Item> content; //array of items
    private ArrayList<Integer> quantities;
    public ShoppingCart(String name) {
        super(name);
        content = new ArrayList<Item>();
        quantities = new ArrayList<Integer>();
        File f = new File("Cart_" + getUsername() + ".txt");
        if (f.exists()) {
            try {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String data[] = line.split(",");
                    quantities.add(Integer.parseInt(data[data.length - 1]));
                    int backremove = data[data.length - 1].length();
                    if (line.charAt(0) == 'R') {
                        content.add(new Readable(line.substring(1, line.length() - backremove)));
                    } else {
                        content.add(new Audio(line.substring(1, line.length() - backremove)));
                    }
                }
            } catch (Exception e) {

            }
        }
    }
	public String getContent(){ // return the content of the shopping cart
        String ret = "";
        for (Item i : content) {
            ret += i.getInfo() + "\n";
        }
        return ret;
	}
	public void addItem(Item i, int quantity){
        content.add(i);	
        quantities.add(quantity);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File("Cart_" + getUsername() + ".txt"));
        } catch (Exception e) {}
        for (int j = 0; j < content.size(); j++) {
            out.println(content.get(j).toFile() + "," + quantities.get(j));      
        }
        out.close();
	}
    public boolean empty() {
        return content.isEmpty();
    }
    public void displayCart() {
        for (Item i : content) {
            System.out.println(i.getShoppingInfo());
        }
    }
    public int size() {
        return content.size();
    }
    public void checkout() {
        int total = 0;
        int enviro = 0;
        int hst = 0;
        int shipping = 0;
        for (int i = 0; i < content.size(); i++) {
            total += content.get(i).getPrice() * quantities.get(i);
            hst += (int)content.get(i).getPrice() * .13;
            enviro = (int) (content.get(i).getPrice() * .13 * quantities.get(i));
            if (content.get(i) instanceof CD || content.get(i) instanceof Book) {
                shipping += content.get(i).getPrice() * .1;
            }
            System.out.println(content.get(i).getName() + "             " + quantities.get(i) +
                    "       " + content.get(i).getPrice());
        }
        System.out.println("Environment Tax     2%              " + enviro);
        System.out.println("HST                13%              " + hst);
        System.out.println("Shipping           10%              " + shipping);
        System.out.println("Total                               " + (total + enviro + hst + shipping));
    }

    public void clear() {
        content.clear();
        quantities.clear();
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File("Cart_" + getUsername() + ".txt"));
        } catch (Exception e) {}
        out.close();
    }
}
