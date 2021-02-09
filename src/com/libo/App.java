package com.libo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import com.libo.services.Validate;
import com.libo.services.impl.BookServiceImpl;
import com.libo.services.impl.LoanServiceImpl;
import com.libo.services.impl.ValidateServiceImpl;

public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) throws IOException {

		int studentId;
		int pageNumber;
		long price;
		String username;
		String password;
		String bookName;
		String authorName;
		String subjectName;
		List menu = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Library lib = Library.getObject();
		BookServices bookImpl = new BookServiceImpl(new BookDAOImpl());
		LoanServices loanImpl = new LoanServiceImpl(new LoanDAOImpl());

		menu.add("SHOW BOOK");
		menu.add("ADD BOOK");
		menu.add("REMOVE BOOK");
		menu.add("GET BOOK BY AUTHOR NAME");
		menu.add("GET BOOK BY BOOK NAME");
		menu.add("GET LOANED RECORDS");
		menu.add("ASSING BOOK TO STUDENTS");
		menu.add("CHECK BOOK OUT OF THAT ARE OUT OF STOCK");

		Admin admin = new Admin(1, "admin", "admin");
		Student jay = new Student(11, "jay", "pimpri", "pune", "student");
		Student shimona = new Student(22, "shimona", "dighi", "pune", "student");
		Student bobby = new Student(33, "bobby", "dighi", "pune", "student");

		List<User> users = List.of(admin, jay, shimona, bobby);
		lib.setUsers(users);

		Validate authenicate = new ValidateServiceImpl();

		String[] authX = { "1. LOGIN" };

		for (int i = 0; i < authX.length; i++)

			System.out.println(authX[i]);

		System.out.println("0. Close The Software");

		boolean quit = false;

		int menuItem;

		do {

			System.out.print("You can either Login #1 / Close System 0#: ");

			menuItem = in.nextInt();

			switch (menuItem) {

			case 1:

				System.out.print("Enter your name and password ");
				username = reader.readLine();
				password = reader.readLine();
				if (authenicate.login(username, password)) {

					if ("ADMIN".equals(authenicate.authorizeUser(username, password))) {

						String[] authZ = { "1. Show Book", "2. Add Book", "3. Remove Book",
								"4. GET BOOK BY AUTHOR NAME", "5. GET BOOK BY BOOK NAME", "6. GET LOANED RECORDS",
								"7. ASSING BOOK TO STUDENTS", "8. CHECK BOOK THAT ARE OUT OF STOCK" };

						for (int i = 0; i < authZ.length; i++)

							System.out.println(authZ[i]);

						System.out.println("0. Logout");

						boolean quits = false;

						int menuItems;

						do {

							System.out.print("Choose menu item: ");

							menuItems = in.nextInt();

							switch (menuItems) {

							case 1:
								System.out.println("You've chosen item #1 SHOW BOOK");
								System.out.println(bookImpl.getBooks());

								break;

							case 2:

								System.out.println("You've chosen item #2 ADD BOOK");
								System.out.println("Enter Book Details");
								System.out.println(
										"In Following Order: Book Name, Subject Name, Author Name, Page No, Price");

								bookName = reader.readLine();
								subjectName = reader.readLine();
								authorName = reader.readLine();
								pageNumber = Integer.parseInt(reader.readLine());
								price = Long.parseLong(reader.readLine());

								bookImpl.addBook(bookName, subjectName, authorName, pageNumber, price);

								break;

							case 3:

								System.out.println("You've chosen item #3 Remove BOOK");
								System.out.println("Enter book name to delete book from library");
								String bookNameToDelete = reader.readLine();

								bookImpl.removeBook(bookNameToDelete);
								break;

							case 4:

								System.out.println("You've chosen item #4 Search Book By Author Name");
								System.out.println("Enter author name to his book");
								authorName = reader.readLine();
								Object bookByAuthorName = bookImpl.SearchBookByAuthor(authorName);
								System.out.println(bookByAuthorName);

								break;

							case 5:

								System.out.println("You've chosen item #5 SEARCH BY BookName ");
								System.out.println("Enter book name to search");
								bookName = reader.readLine();
								Object bookByBookName = bookImpl.SearchBookByName(bookName);
								System.out.println(bookByBookName);

								break;

							case 6:

								System.out.println("You've chosen item #6 Check Loanded Book Record");
								System.out.println(loanImpl.getLoanedList());

								break;

							case 7:

								System.out.println("You've chosen item #7 Assign Book To Student");
								System.out.println("Enter you Student Id and Student Name and Book Name");
								studentId = Integer.parseInt(reader.readLine());
								String studentName = reader.readLine();
								String bookNameToLoan = reader.readLine();
								loanImpl.addLoan(studentId, studentName, bookNameToLoan);
								bookImpl.removeBook(bookNameToLoan);

								break;

							case 8:

								System.out.println("You've chosen item #8 Check Book That Are Out Of Stock");
								bookImpl.checkBookOutOfStock();

								break;

							case 0:

								quits = true;

								break;

							default:

								System.out.println("Invalid choice. Inner");

							}

						} while (!quits);
					}

					else if ("STUDENT".equals(authenicate.authorizeUser(username, password))) {
						String[] authZZ = { "1. Show Books", "2. Search Book By Author Name",
								"3. Search Book By Book Name", };

						for (int i = 0; i < authZZ.length; i++)

							System.out.println(authZZ[i]);

						System.out.println("0. Logout");

						boolean quitss = false;

						int menuItemss;

						do {

							System.out.print("Choose menu item: Inner");

							menuItemss = in.nextInt();

							switch (menuItemss) {

							case 1:

								System.out.println("You've chosen item #1 ADD BOOK");
								System.out.println(bookImpl.getBooks());

								break;

							case 2:

								System.out.println("You've chosen item #2 SEARCH BY AuthorName");
								System.out.println("Enter author name to his book");
								authorName = reader.readLine();
								Object bookByAuthorName = bookImpl.SearchBookByAuthor(authorName);
								System.out.println(bookByAuthorName);

								break;

							case 3:

								System.out.println("You've chosen item #3 SEARCH BY BookName ");
								System.out.println("Enter book name to search");
								bookName = reader.readLine();
								Object bookByBookName = bookImpl.SearchBookByName(bookName);
								System.out.println(bookByBookName);

								break;

							case 0:

								quitss = true;

								break;

							default:

								System.out.println("Invalid choice. Inner");

							}

						} while (!quitss);
					}

				} else {
					System.exit(0);
				}
				System.out.println("Bye-bye! You Can Login Again");

				break;

			case 2:

				System.out.println("You've chosen item #2 Outer");

				break;

			case 0:

				quit = true;

				break;

			default:

				System.out.println("Invalid choice. Outer");

			}

		} while (!quit);

		System.out.println("Bye-bye!");

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
