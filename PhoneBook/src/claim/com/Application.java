package claim.com;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

	//private Entry[] entries;
	private Entry[] entries;
	
	//getters and setters
	public Entry[] getEntries() {
		return entries;
	}
	public void setEntries(Entry[] entries) {
		this.entries = entries;
	}
	
	
	//Main Method
	public static void main(String[] args) {
		Application app = new Application();
		//initialize each array to avoid null error
		app.entries = new Entry[0];
		boolean cont = true;
		while (cont = true) {
			//Scanners
			Scanner scanner = new Scanner(System.in);
			Scanner sc = new Scanner(System.in);
			int num = 0;
			
			//Ask user to pick a function
			try {
				System.out.println("Welcome to the Phonebook! What would you like to do?: ");
				System.out.println("1. Add new entries" + '\n'
						+ "2. Search by first name" + '\n'
						+ "3. Search by last name" + '\n'
						+ "4. Search by full name" + '\n'
						+ "5. Search by telephone number" + '\n'
						+ "6. Search by city or state" + '\n'
						+ "7. Delete a record for a given telephone number" + '\n'
						+ "8. Update a record for a given telephone number" + '\n'
						+ "9. Show all records in asc order" + '\n'
						+ "10. exit the program");
				num = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Error: Must enter an Integer!");
			}
			//Functions of the program
			switch(num){
			// enter a new entry
				case 1:{
					Entry entry = new Entry();
					// user input entry
					System.out.println("Please enter the entry: John Doe,114 Market St,St. Louis,MO,63403,6366435698 ");
					String newEntry = sc.nextLine();
					
					//Split the entry
					String[] splitEntry = newEntry.split(",");
					
					try {
						entry = constructEntry(splitEntry);
					} catch (Exception e) {
						System.out.println("Error: incorrect format for Entry!");
					}
					//add to array of entries
					Entry [] entries = addEntry(app.getEntries(), entry);
					app.setEntries(entries);
					
					System.out.println(entries.length);
					break;
				}
				
				// find entry by first name
				case 2:{
					System.out.println("Please enter first name: John");
					String searchFName = scanner.next();
					System.out.println("The matching entries are: ");
					
					//find matching entry
					try {
						for (int i = 0; i < app.getEntries().length; i++) {
							findFMatch(app.getEntries(), searchFName, i);
						}	
					}catch (Exception e) {
						System.out.println("Cant search in a empty database! Please enter a new Entry");
					}
					
					break;
				}
				
				//Search entry by Last Name
				case 3:{
					System.out.println("Please enter last name: Doe");
					String searchLName = scanner.next();
					System.out.println("The matching entries are: ");
					
					//find matching entry
					try {
						for (int i = 0; i < app.getEntries().length; i++) {
							findLMatch(app.getEntries(), searchLName, i);
						}
					}catch (Exception e) {
						System.out.println("Cant search in a empty database! Please enter a new Entry");
					}
					
					break;
				}
				//Search entry by Full Name
				case 4:{
					System.out.println("Please enter Full name: John Doe");
					String searchFullName = sc.nextLine();
					
					System.out.println("The matching entries are: ");
					
					//find matching entry
					try {
						for (int i = 0; i < app.getEntries().length; i++) {
							findFullMatch(app.getEntries(), searchFullName, i);
						}
					}catch (Exception e) {
						System.out.println("Cant search in a empty database! Please enter a new Entry");
					}
					
					break;
				}
				//Search by phone number
				case 5:{
					
					System.out.println("Please enter phone number: 6366435698");
					String searchPhone = scanner.next();
					System.out.println("The matching entries are: ");
					
					//find matching entry
					try {
						for (int i = 0; i < app.getEntries().length; i++) {
							findPhone(app.getEntries(), searchPhone, i);
						}
					}catch (Exception e) {
						System.out.println("Cant search in a empty database! Please enter a new Entry");
					}
					
					break;
				}
				//Search by city or state
				case 6:{
					System.out.println("Please enter city or state: St. Louis or MO");
					String searchCityOState = sc.nextLine();
					System.out.println("The matching entries are: ");
					//find matching entry
					try {
						for (int i = 0; i < app.getEntries().length; i++) {
							findCityOState(app.getEntries(), searchCityOState, i);
						}
					}catch (Exception e) {
						System.out.println("Cant search in a empty database! Please enter a new Entry");
					}
					
					break;
				}
				
				//Delete records
				//delete by phone
				case 7:{
					System.out.println("Please enter phone number: 6366435698");
					String searchPhone = scanner.next();
					
					
					try {
						Entry e = new Entry();
						//Search by Phone
						for (int i = 0; i < app.getEntries().length; i++) {
							e = findByPhone(app.getEntries(), searchPhone, i);
						}
						//Delete the record
						app.entries = DeleteByPhone(app.entries, e, searchPhone);
					}catch (Exception e) {
						System.out.println("Cant search in a empty database! Please enter a new Entry");
					}
					
					break;
				}
				
				//Update by phone
				case 8:{
					System.out.println("Please enter phone number: 6366435698");
					String searchPhone = scanner.next();
					Entry [] compare = app.getEntries();
					try {
						//Search by Phone & update record
						for (int i = 0; i < app.getEntries().length; i++) {
							if (compare[i].getPhone().trim().equalsIgnoreCase(searchPhone.trim())) {
								app.setEntries(app.updateRecord(app.getEntries(), searchPhone, i));
							}
						}
					} catch (Exception e) {
						System.out.println("Cant search in a empty database! Please enter a new Entry");
					}
					break;
				}
				
				//Ascending order
				case 9:{
					//User select the order it is sorted by
					System.out.println("How do you want to sort it by: " + '\n' +
							"1: First Name, 2: Last Name, 3: Phone Number");
					int sort = scanner.nextInt();
					
					if (sort > 0 && sort <= 3) {
						app.SortEntry(app.getEntries(), sort);
					} else {
						System.out.println("Must make a choice between 1-3! ");
					}
					
					
					break;
				}
				case 10: {
					System.out.println("Thanks for using the Phonebook ");
					System.exit(0);
					break;
				}
			}
		}
		

	}
	//Construct entry
	public static Entry constructEntry(String[] splitEntry) {
		Entry e = new Entry();
		Address a = new Address();
		
		e.setName(splitEntry[0]);
		e.setPhone(splitEntry[5]);
		
		//add address
		a.Address(splitEntry[1], splitEntry[2], splitEntry[3], splitEntry[4]);
		e.setAddress(a);
		
		//Split name
		String[] name = splitEntry[0].split(" ");
		e.setFName(name[0]);
		e.setLName(name[name.length - 1]);
		
		return e;
	}
	
	//Add new entry
	public static Entry[] addEntry(Entry[] entries, Entry e) {
		Entry[] tempArray = new Entry[entries.length + 1];
		
		for (int i = 0; i < entries.length; i++) {
			Entry entry = entries[i];
			tempArray[i] = entry;
		}
		tempArray[tempArray.length - 1] = e;
		return tempArray;
	}
	
	//Find matching values
	//firstName
	public static void findFMatch( Entry[] entries ,String search, int i) {
		String firstName = entries[i].getFName();
		if(search.equalsIgnoreCase(firstName)) {
			System.out.println(entries[i].toString());
		} 
	}
	//LastName
	public static void findLMatch( Entry[] entries, String search, int i) {
		String lastName = entries[i].getlName();
		if(search.equalsIgnoreCase(lastName)) {
			System.out.println(entries[i].toString());
		} 
	}
	//full
	public static void findFullMatch(Entry[] entries, String search, int i) {
		String name = entries[i].getName();
		search = search.trim();
		name = name.trim();
		if(search.equalsIgnoreCase(name)) {
			System.out.println(entries[i].toString());
		}
	}
	//Phone
	public static void findPhone(Entry[] entries, String search, int i) {
		String phone = entries[i].getPhone();
		search = search.trim();
		phone = phone.trim();
		if(search.equalsIgnoreCase(phone)) {
			System.out.println(entries[i].toString());
		}
	}
	//City or State
	public static void findCityOState(Entry[] entries, String search, int i) {
		Address a = entries[i].getAddress();
		String city = a.getCity();
		String state = a.getState();
		search = search.trim();
		city = city.trim();
		state = state.trim();
		if(search.equalsIgnoreCase(city) || search.equalsIgnoreCase(state)) {
			System.out.println(entries[i].toString());
		}
	}
	
	//Delete records methods
	public static Entry findByPhone(Entry[] entries, String search, int i) {
		Entry entry = new Entry();
		String phone = entries[i].getPhone();
		search = search.trim();
		phone = phone.trim();
		if(search.equalsIgnoreCase(phone)) {
			entry = entries[i];
		}
		return entry;
	}
	public static Entry[] DeleteByPhone(Entry[] entries, Entry e, String search ) {
		Entry[] tempArray = new Entry[entries.length - 1]; 
		
		for (int i = 0; i < entries.length; i++) {
			String phone = entries[i].getPhone();
			search = search.trim();
			phone = phone.trim();
			if(!search.equalsIgnoreCase(phone)) {
				Entry entry = entries[i];
				tempArray[i] = entry;
			}
		}
		return tempArray;
	}
	
	//Update record
	public static Entry[] updateRecord( Entry[] entries ,String search, int i) {
		Scanner scanner = new Scanner(System.in);
		// user input a new entry
		System.out.println("Please enter a new entry: John Doe,114 Market St,St. Louis,MO,63403,6366435698 ");
		String newEntry = scanner.nextLine();
		
		String[] splitEntry = newEntry.split(",");
		
		Entry e = constructEntry(splitEntry);
		
		entries[i] =  e;
		
		return entries;
	}
	
	//Sort Entries
	public static void SortEntry(Entry[] entries, int sort) {
		Entry temp;
		switch(sort) {
			
			// by FirstName
			case 1: {
				//Sorting the entries
				for (int i = 0; i < (entries.length) ; i++) {
					for (int j = i + 1; j < (entries.length); j++) {
						String f1 = entries[i].getFName();
						String f2 = entries[j].getFName();
						if(f1.compareTo(f2)>0) {
							temp = entries[i];
		                    entries[i] = entries[j];
		                    entries[j] = temp;
						}
					}
				}
				//displaying the strings
				System.out.println("Entries in Sorted Order:");
		        for (int i = 0; i < entries.length ; i++) {
		            System.out.println(entries[i].toString());
		        }
				break;
			}
			
			//by LastName
			case 2: {
				//Sorting the entries
				for (int i = 0; i < (entries.length); i++) {
					for (int j = 0; j < (entries.length); j++) {
						String l1 = entries[i].getlName();
						String l2 = entries[j].getlName();
						if(l1.compareTo(l2)>0) {
							temp = entries[i];
		                    entries[i] = entries[j];
		                    entries[j] = temp;
						}
					}
				}
				//displaying the strings
				System.out.print("Entries in Sorted Order:");
		        for (int i = 0; i < entries.length ; i++) {
		            System.out.println(entries[i].toString());
		        }
				break;
			}
			
			//by Phone
			case 3: {
				//Sorting the entries
				for (int i = 0; i < (entries.length); i++) {
					for (int j = 0; j < (entries.length); j++) {
						String p1 = entries[i].getPhone();
						String p2 = entries[j].getPhone();
						if(p2.compareTo(p1)>0) {
							temp = entries[i];
		                    entries[i] = entries[j];
		                    entries[j] = temp;
						}
					}
				}
				//displaying the strings
				System.out.println("Entries in Sorted Order:");
		        for (int i = 0; i < entries.length ; i++) {
		            System.out.println(entries[i].toString());
		        }
				break;
			}
		}
		
		
	}
}
