package LibraryManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LibraryManagement 
{
	static ArrayList<Library> al= new ArrayList();
    
	public static void LibraryManagement() throws IOException
	{
		loadDataFromFileToArrayList();
		
		Scanner scanner=new Scanner(System.in);
		
		boolean canIKeepRunningTheProgram=true;
		
		while(canIKeepRunningTheProgram==true)
		{
			System.out.println("____WELCOME TO LIBRARY MANAGEMENT___");
			System.out.println("\n");
			System.out.println("1.Add Book");
			System.out.println("2.Search Book");
			System.out.println("3.Delete Book");
			System.out.println("4.Edit Book");
			System.out.println("5.Exit");
			
			int optionSelectedByUser=scanner.nextInt();
			
			if(optionSelectedByUser==LibraryOptions.EXIT)
			{
				File file=new File("C:\\Users\\Pratiksha\\eclipse-workspace\\LibraryManagement\\src\\LibraryManagement\\Library.txt");
				FileWriter fileWriter=new FileWriter(file,false);
				BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
				
				for(Library library:al)
				{
					bufferedWriter.write(library.Bookname+" , "+library.BookID+" , "+library.BookCategory+","+library.AuthorName+","+library.Price+",");
					
				}
				bufferedWriter.close();
				fileWriter.close();
				file=null;
				
				System.out.println("Program is closed..");
				canIKeepRunningTheProgram=false;
			}
			else if(optionSelectedByUser==LibraryOptions.ADD_BOOK)
			{
				addBook();
				System.out.println("\n");
			}
			else if(optionSelectedByUser==LibraryOptions.DELETE_BOOK)
			{
				System.out.println("Enter The book name you want to delete:");
			    scanner.nextLine();
			    String sn=scanner.nextLine();
			    deleteBook(sn);
			    System.out.println("\n");
			 }
			else if(optionSelectedByUser==LibraryOptions.SEARCH_BOOK)
			{
				System.out.println("Enter the book name you want to search:");
				scanner.nextLine();
				String sn=scanner.nextLine();
				searchBook(sn);
			}
			else if(optionSelectedByUser==LibraryOptions.EDIT_BOOK)
			{
				System.out.println("Enter the book name you want to edit:");
				scanner.nextLine();
				String sn=scanner.nextLine();
				editBook(sn);
		    }
			
		}
		System.out.println("\n");
		System.out.println("After While Loop");
		
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).BookID);
			System.out.println(al.get(i).Bookname);
			System.out.println(al.get(i).BookCategory);
			System.out.println(al.get(i).AuthorName);
			System.out.println(al.get(i).Price);
		}
	}
	
	public static void addBook()
	{
		Scanner scanner=new Scanner(System.in);
		Library libraryObject=new Library();
		
		System.out.println("Book Name:");
		libraryObject.Bookname=scanner.nextLine();
		
		System.out.println("Book Category :");
		libraryObject.BookCategory=scanner.nextLine();
		
		System.out.println("Book Id:");
		libraryObject.BookID=scanner.nextLine();
		
		System.out.println("Price:");
		libraryObject.Price=scanner.nextLine();
		
		System.out.println("Book Author:");
		libraryObject.AuthorName=scanner.nextLine();
		
		System.out.println("Book Name:"+libraryObject.Bookname);
		System.out.println("Book id:"+libraryObject.BookID);
		System.out.println("Book Author:"+libraryObject.AuthorName);
		System.out.println("Price :"+libraryObject.Price);
		System.out.println("Catory :"+libraryObject.BookCategory);
		
		al.add(libraryObject);
		
	}
	public static void searchBook(String BookName)
	{
		for(Library u : al)
		 {
			if(u.Bookname.equalsIgnoreCase(BookName))
			{
				System.out.println("Book Name:"+u.Bookname);
				System.out.println("Book id:"+u.BookID);
				System.out.println("Book Author:"+u.AuthorName);
				System.out.println("Price :"+u.Price);
				System.out.println("Catory :"+u.BookCategory);
				
				return;
			}
		}
		
		System.out.println("Book Not Found");
	}
	public static void editBook(String BookName)
	{
		for( Library u : al)
		{
			if(u.Bookname.equalsIgnoreCase(BookName))
			{
		        Scanner scanner=new Scanner(System.in);
				System.out.println("Editing Book :"+u.Bookname);

				System.out.println("New Book Name:");
				u.Bookname=scanner.nextLine();
				
				System.out.println("New BookId:");
				u.BookID=scanner.nextLine();
				
				System.out.println("New price:");
				u.Price=scanner.nextLine();
				
				System.out.println("New Category");
				u.BookCategory=scanner.nextLine();
				
				System.out.println("New AuthorName:");
				u.AuthorName=scanner.nextLine();
				
				
				System.out.println("Book Information Updated");
				
				return;

			}
		}
		
		System.out.println("User not found");
	}
	public static void deleteBook(String BookName)
	{
         Iterator<Library>Iterator=al.iterator();
		
		while(Iterator.hasNext())
		{
			Library library=Iterator.next();
			if(library.Bookname.equalsIgnoreCase(BookName))
			{
				Iterator.remove();
				System.out.println("Book" + library.Bookname+"has been deleted.");
				break;
			}
		}
		
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file=new File("C:\\Users\\Pratiksha\\eclipse-workspace\\LibraryManagement\\src\\LibraryManagement\\Library.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String Line="";
		while((Line= br.readLine())!=null)
		{
			Library library=new Library();
			String[] libraryDataArray=Line.split(",");
			
			if(libraryDataArray.length>4)
			{
				library.Bookname=libraryDataArray[0];
				library.BookID=libraryDataArray[1];
				library.Price=libraryDataArray[2];
				library.AuthorName=libraryDataArray[3];
				library.BookCategory=libraryDataArray[4];
				
                al.add(library);
             }
		}
		 br.close();
		 fr.close();
		 file=null;

		}
}


