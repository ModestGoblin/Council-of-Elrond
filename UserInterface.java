import java.util.*;//import general utility functions
import java.io.*;//import functions for input and output

public class UserInterface{//The User Interface Class, for all page naviagtion
	private int currentPage; //what page the user is on
    private ShoppingCart current;//current logged in user's shopping cart
    private ArrayList<ShoppingCart> users;
    private ArrayList<Readable> readables;//all Readables in the store
    private ArrayList<Audio> audioProducts;//all audio products in store
    private int confirmnum = 1000; //confirmation number
    public UserInterface() {//constructor
        currentPage = 1;//default starting page is page 1
        readables = new ArrayList<Readable>();//create new array of Readable items for the store inventory
        audioProducts = new ArrayList<Audio>();//create new array of Audio items for the store inventory
        getReadables();//get all readables, and add to readables
        getAudioProducts();//get all Audio items and add to Auido
        users = new ArrayList<ShoppingCart>();//Array of User Shopping carts
        Scanner sc = null;//new scanner
        try {//if possible
            sc = new Scanner(new File("Users.txt"));//access Users.txt
        } catch (Exception e) {//if not possible
	//do nothing
        }//end catch
        while (sc.hasNext()) {//while not at end of file
            users.add(new ShoppingCart(sc.next()));//add a new shopping cart for each user
        }//end while
        current = null;//no one is logged in yet
    }//end of constructor
    public int getCurrentPage() {//returns current page
        return currentPage;//returns the current page USer is on
    }//end getCurrentPage
	//^ the page number (P1..P10)
	public int changeCurrentPage(int toPage){//function to change the CLASS
        System.out.println();//print empty line for spacing
		Scanner option = new Scanner(System.in);//Scanner that will take in user input
		if(toPage == 1){//page 1, sign in/up page
			int choice = 0;//user choice
			while(choice != 1 && choice != 2){//while user choice isn't a valid option
				choice = 0;//reset user choice
				System.out.println("1.Sign in");//Display option 1
				System.out.println("2.Sign up");//Display option 2
                System.out.print("Choose your option:");//Prompt user for input
				choice = Integer.parseInt(option.next());//Take user input
			}//end while loop
			if(choice == 1){//User selected Sign in
                System.out.println("Enter your username:");//Prompt user
                boolean valid = false;//reset validity checker
                String name = option.next();//Take in USer input of username
                for (ShoppingCart c : users) {//for all possible USers
                    if (c.getUsername().equals(name)) {//compare input to Username
                        valid = true;//USername is a usable anme
                        current = c;//current User that's logged in's cart is activated as the current one
                        break;//brak out
                    }//end if
                }//end for loop
                if (valid) {//valid username
                    currentPage = 3;//next page will be welcome page
                } else {//invalid username
                    currentPage = 4;//Access enied page is next
                }//end else
			}//end option 1
			else if(choice == 2){//Sign up selected
                currentPage = 2; //next page will be sign up page
			}//end else if
		}//end of Page 1
		else if (toPage == 2){//Sign up page
            System.out.println("Choose your username:");//prompts user to select a username
            String name = option.next();//Take in user name selection
            System.out.println("Username successfully added");//Tell user it's been added
            users.add(new ShoppingCart(name));//create new shopping cart based on user input and add it to the array of usernames
            PrintWriter out = null;//new Writer for file writing
            try {//if file exists and can be added to
                out = new PrintWriter(new File("Users.txt"));//write username to list of valid names
            } catch (Exception e) {//something went wrong
//do nothing
            }//end catch
            for (User u : users) {//for each username in the array
                out.println(u.getUsername());//print the username (Rewrites the entire file with updated info)
            }//end for loop
            out.close();//close writer
            currentPage = 1;//set next page to Sign in/up page
		}//end Sign up page
		else if(toPage == 3){//Welcome Page
            System.out.println("Hello Mr." + users.get(users.size() - 1).getUsername());//welcome user
            currentPage = 5;//next page is main menu
		}//end welcome page
		else if(toPage == 4){//no access page
            System.out.println("No Access");//inform USer
            currentPage = 1;//next page is Sign in/up page
		}//end no access page
		else if(toPage == 5){//main menu
			int choice = 0;//user choice reset
			while(choice != 1 && choice != 2 && choice != 3){//while choice invalid/reset
				choice = 0;//reset choice
				System.out.println("1.Browse Store By Category");//display option 1
				System.out.println("2.View Cart");//display option 2
				System.out.println("3.Return to Sign In");//display option 3
                System.out.print("Choose your option: ");//prompt user for input
				choice = Integer.parseInt(option.next());//User input
			}//end while
			if(choice == 1){//Browse store selected
				currentPage = 6;//next page is store
			}//end choice 1
			else if(choice == 2){//shopping cart contents desired
                currentPage = 7;//go to cart display page
			}//end shopping cart selected 
			else if(choice == 3){//go to sign in page
                currentPage = 1;//go to sign in 
			}//end sign in page choice
		}//end main menu
		else if(toPage == 6){//Store inventory selection page
			int choice = 0;//user choice is reset
			while(choice != -1 && choice != 1 && choice != 2){//while invalid choice
				choice = 0;//reset user choice
				System.out.println("1.Readables");//display option 1
				System.out.println("2.Audio");//display option 2
				System.out.print("Please enter your selection or enter -1 to return to the last menu:");//prompt user for input and display option -1
				choice = Integer.parseInt(option.next());////Take user input
			}//end while loop
			if(choice == 1){//User wants to browse readables
                currentPage = 8;//next page is Readables
			}//end choice == 1
			else if(choice == 2){//User wants to browse Audio
                currentPage = 9;//next page is Audio items
			}//end choice == 2
			else if(choice == -1){//user wants to return to main menu
                currentPage = 5;//next page is main menu
			}//end choice == -1
		}//end Store inventory selection page
		else if(toPage == 7){//Display Shopping Cart contents
            if (current.empty()) {//Cart is empty
                System.out.println("Shopping cart is empty!");//Notify user of Empty Cart
                currentPage = 5;//next page is main menu
            } else {//Cart not empty
                current.displayCart();//Show cart contents
                int choice = 5;//reset choice to intitally be invalid
                while (choice != 0 && choice != -1) {//while invalid choice
                    System.out.print("Press 0 to checkout or -1 to return to the last menu:");//prompt user for input and what valid options are
                    choice = Integer.parseInt(option.next());//take user input
                }//end while loop
                if (choice == 0) {//Checkout wanted
                    currentPage = 10;//next page is checkout
                } else {//Last menu wanted
                    currentPage = 5;//next page is main menu
                }//end else
            }//end non empty cart
		}//end Display Cart Page
		else if(toPage == 8){//Display Readable items
			System.out.println("Readable Materials");//Display Title
			System.out.println("S.No  Name of the Book  Author  Price($)  Quantity in Store  Type");//Subtites displayed
            showReadables();//grab all relevant Readble info and display it
            int choice = readables.size();//initally set to a valid option
            while (choice < 0 || choice >= readables.size()) {//while valid choice selected
                System.out.println("Choose your option:");//Prompt user for input
                System.out.println("Press -1 to return to previous menu");//Notify user that -1 takes them back a menu
                choice = Integer.parseInt(option.next());//take user input
                if (choice == -1) break;//want to return to last menu
            }//end while
            int quantity = -1;//initally set quantity to an invalid input
            while (quantity <= 0) {//while quantity is less than 0
                System.out.print("Enter quantity:");//prompt user to select how many of the item they wish to purchase
                quantity = Integer.parseInt(option.next());//take user input
            }//end while loop
            current.addItem(readables.get(choice), quantity);//add to cart, the item and quantity in the matching arrays
            System.out.println(readables.get(choice).getName() + " successfully added to your cart");//notify user the item has been added to cart
            choice = 1;//initally invalidate the choice
            while (choice != -2 && choice != 0) {//while choice not valid
                System.out.print("Press -2 to continue shopping or press 0 to checkout:");//prompt user for input
                choice = Integer.parseInt(option.next());//take user input
            }//end while
            if (choice == -2) {//user wants to continue shopping
                currentPage = 6;//return to store invantory display page
            } else {//user wants to go to check out
                currentPage = 10;//next page is check out
            }//end else
		}//end page 8
		else if(toPage == 9){//Audio Display page
			System.out.println("Audio Materials");//display title
			System.out.println("S.No  Name           Artist  Price($)  Quantity in Store  Type");//Display Sub titles
            showAudioProducts();//Display all Audio products
            int choice = audioProducts.size();//reset user choice
            while (choice < 0 || choice >= audioProducts.size()) {//while choice is invalid
                System.out.println("Choose your option:");//Prompt user for input
                System.out.println("Press -1 to return to previous menu");//notify of menu back out option
                choice = Integer.parseInt(option.next());//Take user input
                if (choice == -1) break;//user wants to return to last menu
            }//end while
            int quantity = -1;//initially make quantity invalid
            while (quantity <= 0) {//while quantity is invalid
                System.out.print("Enter quantity:");//prompt user for input
                quantity = Integer.parseInt(option.next());//take user input
            }//end while
            current.addItem(audioProducts.get(choice), quantity);//add item to cart, along with quantity using the proper arrays
            System.out.println(readables.get(choice).getName() + " successfully added to your cart");//notify user that item was added
            choice = 1;//reset choice to an invalid option initially
            while (choice != -2 && choice != 0) {//while invalid choice
                System.out.print("Press -2 to continue shopping or press 0 to checkout:");//prompt user for input
                choice = Integer.parseInt(option.next());//Take user Input
            }//end while loop
            if (choice == -2) {//user wants to continue shopping
                currentPage = 6;//return to shopping main page
            } else {//user wants to check out 
                currentPage = 10;//next page is check out
            }//end else
		}//end page 9
		else if(toPage == 10){//check out
			System.out.println("Checkout");//title
            System.out.println("Billing Information:");//sub title
            System.out.println("Name              Quantity       Price");//sub title
            current.checkout();//call checkout on the cart
            System.out.println("Are you sure you want to pay? yes or no.");//prompt user for confirmation
            String response = option.next();//take user input
            if (response.toLowerCase().equals("yes")) {//user confirmed
                System.out.println("Confirmation ID: U" + confirmnum);//display confirmation number
                confirmnum += 1//add 1 to make sure confirmation
                System.out.println("Items shipped to: Mr." + current.getUsername());//notifies user that Item order ahs been confirmed
            }//end user confirmation
            currentPage = 5;//return to main menu
            current.clear();//empty cart
		}//end chack out page
		return 0;//return 0
	}//end change current page
    public void getReadables() {//returns all readable items
        Scanner s = null;//scanner for file reading
        try {//attempt to read from file
            s = new Scanner(new File("Books.txt"));//scanner will read from Books.txt
        } catch (Exception e) {//something went wrong
//do nothing
        }//end catch
        while (s.hasNextLine()) {//not at end of file
            readables.add(new Book(s.nextLine()));//array of readable items adds each book
        }//end while
        try {//attempt to read from file
            s = new Scanner(new File("Ebooks.txt"));//scanner will read from ebooks.txt
        } catch (Exception e) {//something went wrong
	//do nothing
        }//end catch
        while (s.hasNextLine()) {//while not at end of file
            readables.add(new eBook(s.nextLine()));//add eBook to readables array
        }//end while
    }//end getReadable

    public void getAudioProducts() {//fetch all Audio Products
        Scanner s = null;//Scanner that will read from a file
        try {//atempt to read from file
            s = new Scanner(new File("CDs.txt")); //scanner file accesses CDs.txt    
        } catch (Exception e) {//something went wrong
	//do nothing
        }//end catch
        while (s.hasNextLine()) {//while not at end of files
            audioProducts.add(new CD(s.nextLine()));//add next CD to array of Audio products
        }//end while
        try {//attempt to read from MP3.txt
            s = new Scanner(new File("MP3.txt"));//Scanner has access to file
        } catch (Exception e) {//something went wrong
//do nothing
        }//end catch
        while (s.hasNextLine()) {//while not at end of file
            audioProducts.add(new MP3(s.nextLine()));//add MP3 from file to array of audio pproducts
        }//end while
    }//end get Audio Products

    public void showReadables() {//display all readable items
        for (int i = 0; i < readables.size(); i++) {//for each readable item
            System.out.println(i + "\t" + readables.get(i).getListInfo());//display all info on the item
        }//end for loop
    }//end showReadables

    public void showAudioProducts() {//display all Audio items
        for (int i = 0; i < audioProducts.size(); i++) {//for each audio item
            System.out.println(i + "\t" + audioProducts.get(i).getListInfo());//display all relevant info on the item
        }//end for loop
    }//end showAudioProducts
}//end class
