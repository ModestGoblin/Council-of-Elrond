/*
* Name: Thomas Sikma Graham Van Deventer Nezar Dimitri
* MacID: sikmat vandevgm dimitn
* Student Number: 1428584 1404877 1422586
* Description: The User class contains relevant information on Users, specifically the username. This username will be accessed when Shopping Cart fucnctions are used. Each instance of User will most likely have a Shopping Cart assoiciated with it
*/
public class User{//class that contains all information on a user
	private String username;//the username of the user
    public User(String username) {//constructor
        this.username = username;//assign User username to User object
    }//end constructor
	public String getUsername(){ // stores the username.
        return username;//grab and return to username
	}//end getUsername
}//end User class
