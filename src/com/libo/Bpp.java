package com.libo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.libo.beans.Admin;
import com.libo.beans.Library;
import com.libo.beans.Student;
import com.libo.beans.User;
import com.libo.dao.BookDAOImpl;
import com.libo.dao.LoanDAOImpl;
import com.libo.services.BookServices;
import com.libo.services.LoanServices;
import com.libo.services.impl.BookServiceImpl;
import com.libo.services.impl.LoanServiceImpl;

public class Bpp {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String username;
		String password;

		Library lib = new Library();

//		BookServices bookImpl = new BookServiceImpl(lib);
		BookServices bookImpl = new BookServiceImpl(lib, new BookDAOImpl(lib));
		LoanServices loanImpl = new LoanServiceImpl(lib, new LoanDAOImpl(lib));

		List menu = new ArrayList<String>();
		menu.add("SHOW BOOK");
		menu.add("ADD BOOK");
		menu.add("REMOVE BOOK");
		menu.add("GET BOOK BY AUTHOR NAME");
		menu.add("GET BOOK BY BOOK NAME");
		menu.add("GET LOANED RECORDS");
		menu.add("ASSING BOOK TO STUDENTS");
		menu.add("CHECK BOOK OUT OF THAT ARE OUT OF STOCK");

		Admin admin = new Admin(1, "admin", "abcd");
		Student jay = new Student(11, "jay", "pimpri", "pune", "1234");
		Student shimona = new Student(22, "shimona", "dighi", "pune", "password");
		Student bobby = new Student(33, "bobby", "dighi", "pune", "password");

		List<User> users = List.of(admin, jay);

		System.out.println("Enter your username and password");

		username = in.nextLine();
		password = in.nextLine();

		if (username != null && password != null) {
			for (User user : users) {
				if (username.equals(user.getName()) && password.equals(user.getPassword())) {

					String role = user.getRole().toString();

					if ("ADMIN".equals(role)) {
						LOGGER.info("Hello this is an info message");
						// ADMIN LOGIC
						System.out.println("Admin logic");
						for (int i = 0; i < menu.size(); i++)

							System.out.println(i + 1 + " " + menu.get(i) + " #" + (i + 1));

						System.out.println("0. Quit");

						boolean quit = false;

						int menuItem;

						do {

							System.out.print("Choose menu item: ");

							menuItem = in.nextInt();

							switch (menuItem) {

							case 1:

								System.out.println("You've chosen item #1 to show all the book in self");
								System.out.println(bookImpl.getBooks());

								break;

							case 2:

								System.out.println("You've chosen item #2 to add book");
								bookImpl.addBook();

								break;

							case 3:

								System.out.println("You've chosen item #3 to remove book");
								bookImpl.removeBook();

								break;

							case 4:

								System.out.println("You've chosen item #4 SEARCH BY AuthorName");
								Object bookByAuthorName = bookImpl.SearchBookByAuthor();
								System.out.println(bookByAuthorName);

								break;

							case 5:

								System.out.println("You've chosen item #5 SEARCH BY BookName ");
								Object bookByBookName = bookImpl.SearchBookByName();
								System.out.println(bookByBookName);

								break;

							case 6:

								System.out.println("You've chosen item #6 Check Loanded Book Record");
								System.out.println(loanImpl.getLoanedList());

								break;

							case 7:

								System.out.println("You've chosen item #7 Assign Book To Student");
								loanImpl.addLoan();
								bookImpl.removeBook();

								break;

							case 8:

								System.out.println("You've chosen item #8 Check Book That Are Out Of Stock");
								bookImpl.checkBookOutOfStock();

								break;

							case 0:

								quit = true;

								break;

							default:

								System.out.println("Invalid choice.");

							}

						} while (!quit);

						System.out.println("Bye-bye!");
					} else if ("STUDENT".equals(role)) {
						// STUDENT LOGIC

						menu.remove("ADD BOOK");
						menu.remove("REMOVE BOOK");

						System.out.println("Student logic");

						for (int i = 0; i < menu.size(); i++)

							System.out.println(i + 1 + " " + menu.get(i) + " #" + (i + 1));

						System.out.println("0. Quit");

						boolean quit = false;

						int menuItem;

						do {

							System.out.print("Choose menu item: ");

							menuItem = in.nextInt();

							switch (menuItem) {

							case 1:

								System.out.println("You've chosen item #1 to show all the book in self");
								System.out.println(bookImpl.getBooks());

								break;

							case 2:

								System.out.println("You've chosen item #2 SEARCH BY AuthorName");
								Object bookByAuthorName = bookImpl.SearchBookByAuthor();
								System.out.println(bookByAuthorName);

								break;

							case 3:

								System.out.println("You've chosen item #3 SEARCH BY BookName ");
								Object bookByBookName = bookImpl.SearchBookByName();
								System.out.println(bookByBookName);

								break;

							case 0:

								quit = true;

								break;

							default:

								System.out.println("Invalid choice.");

							}

						} while (!quit);

						System.out.println("Bye-bye!");

					} else {

						System.out.println("Wrong Email or Password");

					}

				}
			}
		}

	}
}

//****************  LIBRARY REQUIREDMENT   *****************//

//		Create a library management system with following use cases 
//
//		1) As a librarian, you should be able to add a new book, with following details Book Name, Book Subject (like Database, QA, Computer Network),  Author Name, Page Number and Price 
//		2) As a librarian you should be able to see all the books in the library 
//		3) As a student, you should be able to search a book by Title or Author 
//		4) As a student you should be able to loan a book and return it 
//		3) As a librarian you should be able to see all the books loaned out to students
//
//
//		Guideline
//
//		1. The online system should have login for Student and librarian  
//		2. The online system doesn't need to have a UI, but it should be a continuum.
//		3. This application shouldn't use any database or frameworks.