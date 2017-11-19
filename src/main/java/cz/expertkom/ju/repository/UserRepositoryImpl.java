package cz.expertkom.ju.repository;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cz.expertkom.ju.interfaces.UserRepository;
import cz.expertkom.ju.interfaces.entity.User;


@Repository
public class UserRepositoryImpl implements UserRepository {
	
	/* proměnná ve které je uložen uživatel nalezený v seznamu*/
	private User foundUser = new User();
	
	/* seznam uživatelů - představuje databázi uživatelů */
	private List<User> listOfUsers= new ArrayList<User>();
	
	@PostConstruct
	public void setRepositoryImpl() {
		
		
		System.out.println("\n\nStart inicializace seznamu uživatelů....");
		
		/* jetliže seznam uživatelů není prázdný, tak ho vyprázdni */
		if (!listOfUsers.isEmpty()) {listOfUsers.clear();}
		
		/*vytvoření seznamu uživatelů */
		User u1 = new User(); u1.initUser ("karel", "Karel", "Novak");this.listOfUsers.add(u1);
		User u2 = new User(); u2.initUser ("larry", "Larry", "Allison");this.listOfUsers.add(u2);
		User u3 = new User(); u3.initUser ("rudolf", "Rudolf", "Druhy");this.listOfUsers.add(u3);
		
/*		
  		u1.setUsername("karel"); u1.setFirstname("Karel"); u1.setLastname("Novak");
		this.listOfUsers.add(u1);
		u2.setUsername("larry"); u2.setFirstname("Larry"); u2.setLastname("Allison");
		this.listOfUsers.add(u2);
		u3.setUsername("rudolf"); u3.setFirstname("Rudolf"); u3.setLastname("Druhy");
		this.listOfUsers.add(u3);
*/
		
		
		System.out.println("....Konec inicializace\n\n");
	}



	/* metoda ke zjištění uživatele:*/
	@Override
	public User getUser(String username) {
		
		this.setRepositoryImpl();
		
		/*inicialize nalezeného uživatele */
		System.out.println("Uživatel: "+username);
		this.foundUser.setFirstname("Unknown");
		this.foundUser.setLastname("Unknown");
		this.foundUser.setUsername(username);
		
		/* vytisknout seznam uživatelů */
		System.out.println("Seznam Uživatelů:");
		for (User u: this.listOfUsers) {
			System.out.println("    "+u);
		}
		
		
		System.out.println("Požadovaný uživatel:"+ username);
		/* procházení listu uživatelů */
		for (User u: this.listOfUsers) {
			if (username.equals(u.getUsername())) {
				this.foundUser = u;
				break;
			}
		}
		return this.foundUser;
		
		
/* původní implementace */
		
/*		
		User user = new User();
		user.setFirstname("Karel");
		user.setLastname("Gates");
		user.setUsername(username);
		
		return user;
		
 */
	}

/*
public User getFoundUser() {
		return foundUser;
	}

	public void setFoundUser(User foundUser) {
		this.foundUser = foundUser;
	}
	
*/

	
}
