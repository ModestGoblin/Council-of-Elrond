import java.util.*;
import java.io.*;

public class UserInterface{
	private int currentPage; 
    private ShoppingCart current;
    private ArrayList<ShoppingCart> users;
    private ArrayList<Readable> readables;
    private ArrayList<Audio> audioProducts;

    public UserInterface() {
        currentPage = 1;
        readables = new ArrayList<Readable>();
        audioProducts = new ArrayList<Audio>();
        getReadables();
        getAudioProducts();
        users = new ArrayList<ShoppingCart>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File("Users.txt"));
        } catch (Exception e) {

        }
        while (sc.hasNext()) {
            users.add(new ShoppingCart(sc.next()));
        }
        current = null;
    }
    public int getCurrentPage() {
        return currentPage;
    }
	//^ the page number (P1..P10)
	public int changeCurrentPage(int toPage){
        System.out.println();
		Scanner option = new Scanner(System.in);
		if(toPage == 1){
			int choice = 0;
			while(choice != 1 && choice != 2){
				choice = 0;
				System.out.println("1.Sign in");
				System.out.println("2.Sign up");
                System.out.print("Choose your option:");
				choice = Integer.parseInt(option.next());
			}
			if(choice == 1){
                System.out.println("Enter your username:");
                boolean valid = false;
                String name = option.next();
                for (ShoppingCart c : users) {
                    if (c.getUsername().equals(name)) {
                        valid = true;
                        current = c;
                        break;
                    }
                }
                if (valid) {
                    currentPage = 3;
                } else {
                    currentPage = 4;
                }
			}
			else if(choice == 2){
                currentPage = 2; 
			}
		}
		else if (toPage == 2){
            System.out.println("Choose your username:");
            String name = option.next();
            System.out.println("Username successfully added");
            users.add(new ShoppingCart(name));
            PrintWriter out = null;
            try {
                out = new PrintWriter(new File("Users.txt"));
            } catch (Exception e) {

            }
            for (User u : users) {
                out.println(u.getUsername());
            }
            out.close();
            currentPage = 1;
		}
		else if(toPage == 3){
            System.out.println("Hello Mr." + users.get(users.size() - 1).getUsername());
            currentPage = 5;
		}
		else if(toPage == 4){
            System.out.println("No Access");
            currentPage = 1;
		}
		else if(toPage == 5){
			int choice = 0;
			while(choice != 1 && choice != 2 && choice != 3){
				choice = 0;
				System.out.println("1.Browse Store By Category");
				System.out.println("2.View Cart");
				System.out.println("3.Return to Sign In");
                System.out.print("Choose your option: ");
				choice = Integer.parseInt(option.next());
			}
			if(choice == 1){
				currentPage = 6;
			}
			else if(choice == 2){
                currentPage = 7;
			}
			else if(choice == 3){
                currentPage = 1;
			}
		}
		else if(toPage == 6){
			int choice = 0;
			while(choice != -1 && choice != 1 && choice != 2){
				System.out.println("1.Readables");
				System.out.println("2.Audio");
				System.out.print("Please enter your selection or enter -1 to return to the last menu:");
				choice = Integer.parseInt(option.next());
			}
			if(choice == 1){
                currentPage = 8;
			}
			else if(choice == 2){
                currentPage = 9;
			}
			else if(choice == -1){
                currentPage = 5;
			}
		}
		else if(toPage == 7){
            if (current.empty()) {
                System.out.println("Shopping cart is empty!");
                currentPage = 5;
            } else {
                current.displayCart();
                int choice = 5;
                while (choice != 0 && choice != -1) {
                    System.out.print("Press 0 to checkout or -1 to return to the last menu:");
                    choice = Integer.parseInt(option.next());
                }
                if (choice == 0) {
                    currentPage = 10;
                } else {
                    currentPage = 5;

                }
            }
		}
		else if(toPage == 8){
			System.out.println("Readable Materials");
			System.out.println("S.No  Name of the Book  Author  Price($)  Quantity in Store  Type");
            showReadables();
            int choice = readables.size();
            while (choice < 0 || choice >= readables.size()) {
                System.out.println("Choose your option:");
                System.out.println("Press -1 to return to previous menu");
                choice = Integer.parseInt(option.next());
                if (choice == -1) break;
            }
            int quantity = -1;
            while (quantity <= 0) {
                System.out.print("Enter quantity:");
                quantity = Integer.parseInt(option.next());
            }
            current.addItem(readables.get(choice), quantity);
            System.out.println(readables.get(choice).getName() + " successfully added to your cart");
            choice = 1;
            while (choice != -2 && choice != 0) {
                System.out.print("Press -2 to continue shopping or press 0 to checkout:");
                choice = Integer.parseInt(option.next());
            }
            if (choice == -2) {
                currentPage = 6;
            } else {
                currentPage = 10;
            }
		}
		else if(toPage == 9){
			System.out.println("Audio Materials");
			System.out.println("S.No  Name           Artist  Price($)  Quantity in Store  Type");
            showAudioProducts();
            int choice = audioProducts.size();
            while (choice < 0 || choice >= audioProducts.size()) {
                System.out.println("Choose your option:");
                System.out.println("Press -1 to return to previous menu");
                choice = Integer.parseInt(option.next());
                if (choice == -1) break;
            }
            int quantity = -1;
            while (quantity <= 0) {
                System.out.print("Enter quantity:");
                quantity = Integer.parseInt(option.next());
            }
            current.addItem(audioProducts.get(choice), quantity);
            System.out.println(readables.get(choice).getName() + " successfully added to your cart");
            choice = 1;
            while (choice != -2 && choice != 0) {
                System.out.print("Press -2 to continue shopping or press 0 to checkout:");
                choice = Integer.parseInt(option.next());
            }
            if (choice == -2) {
                currentPage = 6;
            } else {
                currentPage = 10;
            }
		}
		else if(toPage == 10){
			System.out.println("Checkout");
            System.out.println("Billing Information:");
            System.out.println("Name              Quantity       Price");
            current.checkout();
            System.out.println("Are you sure you want to pay? yes or no.");
            String response = option.next();
            if (response.toLowerCase().equals("yes")) {
                System.out.println("Confirmation ID: U1000");
                System.out.println("Items shipped to: Mr." + current.getUsername());
            }
            currentPage = 5;
            current.clear();
		}
		return 0;
	}
    public void getReadables() {
        Scanner s = null;
        try {
            s = new Scanner(new File("Books.txt"));
        } catch (Exception e) {

        }
        while (s.hasNextLine()) {
            readables.add(new Book(s.nextLine()));
        }
        try {
            s = new Scanner(new File("Ebooks.txt"));
        } catch (Exception e) {

        }
        while (s.hasNextLine()) {
            readables.add(new eBook(s.nextLine()));
        }
    }

    public void getAudioProducts() {
        Scanner s = null;
        try {
            s = new Scanner(new File("CDs.txt"));    
        } catch (Exception e) {

        }
        while (s.hasNextLine()) {
            audioProducts.add(new CD(s.nextLine()));
        }

        try {
            s = new Scanner(new File("MP3.txt"));
        } catch (Exception e) {

        }
        while (s.hasNextLine()) {
            audioProducts.add(new MP3(s.nextLine()));
        }
    }

    public void showReadables() {
        for (int i = 0; i < readables.size(); i++) {
            System.out.println(i + "\t" + readables.get(i).getListInfo());
        }
    }

    public void showAudioProducts() {
        for (int i = 0; i < audioProducts.size(); i++) {
            System.out.println(i + "\t" + audioProducts.get(i).getListInfo());
        }
    }
}
