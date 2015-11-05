public class UserInterface{
	private int currentPage; 
	//^ the page number (P1..P10)
	public int getCurrentPage(int toPage){
		Scanner option = new Scanner(System.in);
		if(toPage == 1){
			int choice = 0;
			while(choice != 1 && choice != 2){
				choice = 0;
				System.out.println("1.Sign in");
				System.out.println("2.Sign up");
				choice = Integer.parseInt(option.next());
			}
			if(choice == 1){
				System.out.println("Please enter your username");
				changeCurrentPage(3);
			}
			else if(choice == 2){
				changeCurrentPage(2);
			}
		}
		else if (toPage == 2){
			System.out.println("Now on P2");
			changeCurrentPage(5);
		}
		else if(toPage == 3){
			System.out.println("Now on P3");
			changeCurrentPage(5);
		}
		else if(toPage == 4){
			System.out.println("Now on P4");
			changeCurrentPage(1);
		}
		else if(toPage == 5){
			System.out.println("Main Menu");
			int choice = 0;
			while(choice != 1 && choice != 2 && choice != 3){
				choice = 0;
				System.out.println("1.Browse Store By Category");
				System.out.println("2.View Cart");
				System.out.println("3.Return to Sign In");
				choice = Integer.parseInt(option.next());
			}
			if(choice == 1){
				changeCurrentPage(6);
			}
			else if(choice == 2){
				changeCurrentPage(7);
			}
			else if(choice == 3){
				changeCurrentPage(1);
			}
		}
		else if(toPage == 6){
			int choice = 0;
			while(choice != -1 && choice != 1 && choice != 2){
				System.out.println("1.Readables");
				System.out.println("2.Audio");
				System.out.println("Please enter your selection or enter -1 to return to the last menu");
				choice = Integer.parseInt(option.next());
			}
			if(choice == 1){
				changeCurrentPage(8);
			}
			else if(choice == 2){
				changeCurrentPage(9);
			}
			else if(choice == -1){
				changeCurrentPage(5);
			}
		}
		else if(toPage == 7){
			System.out.println("Shopping Cart");
		}
		else if(toPage == 8){
			System.out.println("Readable Materials");
			System.out.println("S.No  Name of the Book  Author  Price($)  Quantity in Store  Type");
			//
		}
		else if(toPage == 9){
			System.out.println("Audio Materials");
			System.out.println("S.No  Name           Artist  Price($)  Quantity in Store  Type");
			//
		}
		else if(toPage == 10){
			System.out.println("Checkout");
		}
		return 0;
	}
	public int changeCurrentPage(int selection){
		this.currentPage = selection;
		this.getCurrentPage(selection);
		return 0;
	}

}
