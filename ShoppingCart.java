/*
* Name: Thomas Sikma Graham Van Deventer Nezar Dimitri
* MacID: sikmat vandevgm dimitn
* Student Number: 1428584 1404877 1422586
* Description: The shopping Cart Class keeps track of all items all users are currently going to purchase, this class reads and writes to individual text files for each user, and overwrites Methods from the User class
*/
import java.util.*;//import all general utility functions
import java.io.*;//import functions needed for file reading, writing and user input

public class ShoppingCart extends User {//class that will be used for everything required for a shopping cart
	private ArrayList<Item> content; //array of items
    private ArrayList<Integer> quantities;//array of item quantities
    public ShoppingCart(String name) {//constructor
        super(name);//call parent constructor
        content = new ArrayList<Item>();//create new array for contents
        quantities = new ArrayList<Integer>();//create new array for quantities of content
        File f = new File("Cart_" + getUsername() + ".txt");//create text file that will contain all Shopping Cart content
        if (f.exists()) {//file exists
            try {//if possible
                Scanner sc = new Scanner(f);//create a new scanner
                while (sc.hasNextLine()) {//not at end of file
                    String line = sc.nextLine();//grab next line and save it
                    String data[] = line.split(",");//split line at commas and save in data array
                    quantities.add(Integer.parseInt(data[data.length - 1]));
                    int backremove = data[data.length - 1].length();
                    if (line.charAt(0) == 'R') {//item is readable
                        content.add(new Readable(line.substring(1, line.length() - backremove)));
                    } else {
                        content.add(new Audio(line.substring(1, line.length() - backremove)));
                    }//end else
                }//end while loop
            }//end try 
            catch (Exception e) {//unable to complete above
		//do nothing
            }//end catch
        }//end if
    }//end constructor
	public String getContent(){ // return the content of the shopping cart
        String ret = "";//string that will have all content
        for (Item i : content) {//for all items in cart
            ret += i.getInfo() + "\n";//add item info to returning string and add a new line
        }//end for loop
        return ret;//return cart contents
	}//end get content
	public void addItem(Item i, int quantity){//add an item to the cart
        content.add(i);	//to content array, add item
        quantities.add(quantity);//to array of item contents, add quantity of item
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File("Cart_" + getUsername() + ".txt"));
        } catch (Exception e) {}
        for (int j = 0; j < content.size(); j++) {
            out.println(content.get(j).toFile() + "," + quantities.get(j));      
        }//end for loop
        out.close();//close PrintWriter
	}//end add Item
    public boolean empty() {//will return whether or not the cart has contents
        return content.isEmpty();//check cart contents for anythign existing
    }//end empty
    public void displayCart() {//method to show user contents of Cart
        for (Item i : content) {//for all items in cart
            System.out.println(i.getShoppingInfo());//display item info
        }//end for loop
    }//end display cart
    public int size() {
        return content.size();
    }
    public void checkout() {//function to control checkout options
        int total = 0;//total to be paid
        int enviro = 0;//environment tax
        int hst = 0;//HST tax
        int shipping = 0;//shipping fee
        for (int i = 0; i < content.size(); i++) {//for each item in the cart
            total += content.get(i).getPrice() * quantities.get(i);//total = total + price of item * number of items
            hst += (int)content.get(i).getPrice() * .13;//hst = hst + 13% of item price
            enviro = (int) (content.get(i).getPrice() * .13 * quantities.get(i));//calculates environment tax
            if (content.get(i) instanceof CD || content.get(i) instanceof Book) {//if its a CD or a Book
                shipping += content.get(i).getPrice() * .1;//add a shipping fee
            }//end if statement
            System.out.println(content.get(i).getName() + "             " + quantities.get(i) +
                    "       " + content.get(i).getPrice());//print item name, amount ordered, and price
        }//end for loop
        System.out.println("Environment Tax     2%              " + enviro);//display Environment Tax
        System.out.println("HST                13%              " + hst);//display HST
        System.out.println("Shipping           10%              " + shipping);//display Shipping fee
        System.out.println("Total                               " + (total + enviro + hst + shipping));//dispkay total
    }//end checkout

    public void clear() {//reset Cart
        content.clear();//empty content
        quantities.clear();//empty quantities array
        PrintWriter out = null;//reset Writer
        try {//While file exists
            out = new PrintWriter(new File("Cart_" + getUsername() + ".txt"));//write to newly created file
        } catch (Exception e) {}//SOme sort of error, do nothing
        out.close();//close writer
    }//end clear
}//end class
