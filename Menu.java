//  File:  Menu.java

//  This program llustrates the use of a menu, which would be the basis
//  for constructing a larger program by adding more options, where each
//  option is handled by a separate function.

//  This file is in the directory ~kdjackso/cs665

import java.sql.*;
import org.apache.derby.jdbc.ClientDriver;
import java.util.Scanner;

public class Menu
{
   public static void main(String[] args)
   {
      int response;
      Connection conn = null;
      try
      {
         Driver d;
         String url;
         // Make a menu selection
         response = 2;
         while(response != 2035553){
            response = PrintMenuAndGetResponse();

            switch (response)
            {
               case 21:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=true";
                     conn = d.connect(url, null);
                     AddNewGamesExpansions(conn); 
                     conn.close();
                     break;
               case 22:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=true";
                     conn = d.connect(url, null);
                     AddNewAwardsWinners(conn); 
                     conn.close();
                     break;
               case 23:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=true";
                     conn = d.connect(url, null);
                     AddNewContribs(conn);
                     conn.close();
                     break;
               case 24:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=true";
                     conn = d.connect(url, null);
                     NewRelease(conn);
                     conn.close();
                     break;
               case 31:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     SearchWinnerbyYear(conn);
                     conn.close();
                     break;
               case 32:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     SearchGamebyMech(conn);
                     conn.close();
                     break;
               case 33:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     SearchExpbyBaseGame(conn);
                     conn.close();
                     break;
               case 34:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     SearchGamebyCont(conn);
                     conn.close();
                     break;
               case 35:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     SearchGamesWithContribSet(conn);
                     conn.close();
                     break;
               case 36:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     CustomSearch(conn);
                     conn.close();
                     break;
               case 37:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     top20(conn);
                     conn.close();
                     break;
               case 38:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     mostpopbymech(conn);
                     conn.close();
                     break;
               case 39:
                     d = new ClientDriver();
                     url = "jdbc:derby://localhost:2434/BoardGameDBase"
                                   + ";create=false";
                     conn = d.connect(url, null);
                     mostcomplex(conn);
                     conn.close();
                     break;
               case 11: 
                     System.out.println("Goodbye!");
                     return;
               default: System.out.println("Illegal choice");
                        break;
            }
         }
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      finally
      {
         // Removed disconnect for above custom connection stuffs
      }
   }


   

    //Case 21
    //This adds a new boardgame or boardgame expansion
    public static void AddNewGamesExpansions(Connection conn) throws SQLException
    {
		Statement stmt = conn.createStatement();

	Scanner keyboard;
	keyboard = new Scanner(System.in);
	int choice = 0;
	String Name = "";
	int Year = 0;
	int Time = 0;
	int Age = 0;
	int Max = 0;
	int Min = 0;
	int Sugg = 0;
	int Base =0;
	while(choice != 2035553) {
	    System.out.println("Would you like to:");
	    System.out.println("1. Add a new Game");
	    System.out.println("2. Add a new Expansion");
	    System.out.print("===>");
	    choice = keyboard.nextInt();
	    
	    switch(choice)
		{
		case 1:
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the name of the new Game?:");
		    System.out.print("===> ");
		    Name = keyboard.nextLine();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What Year was it Published?:");
		    System.out.print("===> ");
		    Year = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("How long does it take to play?:");
		    System.out.print("===> ");
		    Time = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the minimum age limit:");
		    System.out.print("===> ");
		    Age = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the maximum number of players?:");
		    System.out.print("===> ");
		    Max = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the minimum number of players?:");
		    System.out.print("===> ");
		    Min = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the suggested number of players?:");
		    System.out.print("===> ");
		    Sugg = keyboard.nextInt();
		    System.out.println();
		    
		    String qry ="INSERT INTO BOARDGAMES (BGId, BGName, BGYearPublished, BGPlaytime, BGMinAge, BGMaxNumber, BGMinNumber, BGSuggestedNum)"
			+ "VALUES ((select MAX(BGId)+1 FROM BOARDGAMES), '" + Name + "', " + Year + ", " + Time + ", " + Age + ", "
			+ Max + ", " + Min + ", " + Sugg + ")";

		    int updated = stmt.executeUpdate(qry);
		    if (updated == 1)
			{
			    System.out.println(Name + " added to table");
			    choice = 2035553;
			}
		    else 
			{
			    System.out.println("Sorry, there was an error please try again");
			}
		    break;

		case 2:
		    //ask what letter the Base Game starts with
		    String letter = "";
		    System.out.print("What letter does the base game start with? ===>");
		    keyboard = new Scanner(System.in);
		    letter = keyboard.nextLine();
		     //print Games that start with that letter
		    String qry2 = "select BGId, BGName from BOARDGAMES where BGName like '" + letter + "%'";
		    ResultSet rs = stmt.executeQuery(qry2);
		    String last = "";
         while (rs.next())
         {
            int BoardGameId = rs.getInt("BGId");
            String BGName = rs.getString("BGName");
            if(last == "")
            {
              last = BGName;
              System.out.println(BoardGameId + ": " + BGName);
            }

            if(!BGName.equals(last))
            {
              System.out.println(BoardGameId + ": " + BGName);
              last = BGName;
            }
         }
         System.out.println();
         rs.close();
		    //enter All other information just like above
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("Enter the IDNumber of the Base Game for this Expansion?:");
		    System.out.print("===> ");
		    Base = keyboard.nextInt();
		    System.out.println();
			keyboard = new Scanner(System.in);
		    System.out.println("What is the name of the new Expansion?:");
		    System.out.print("===> ");
		    Name = keyboard.nextLine();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What Year was it Published?:");
		    System.out.print("===> ");
		    Year = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("How long does it take to play?:");
		    System.out.print("===> ");
		    Time = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the minimum age limit:");
		    System.out.print("===> ");
		    Age = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the maximum number of players?:");
		    System.out.print("===> ");
		    Max = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the minimum number of players?:");
		    System.out.print("===> ");
		    Min = keyboard.nextInt();
		    System.out.println();
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the suggested number of players?:");
		    System.out.print("===> ");
		    Sugg = keyboard.nextInt();
		    System.out.println();
		    
		    //    INSERT INTO EXPANSIONS 
		    qry ="INSERT INTO EXPANSIONS (EId, EName, EYearPublished, EPlaytime, EMinAge, EMaxNumber, EMinNumber, ESuggestedNum, BaseBGId)"
			+ "VALUES ((select MAX(EId)+1 FROM EXPANSIONS), '" + Name + "', " + Year + ", " + Time + ", " + Age + ", "
			+ Max + ", " + Min + ", " + Sugg + ", " + Base + ")";

		    updated = stmt.executeUpdate(qry);
		    if (updated == 1)
			{
			    System.out.println(Name + " added to table");
			    choice = 2035553;
			}
		    else 
			{
			    System.out.println("Sorry, there was an error please try again");
			}
		    break;
		    

		    
		default:
		    System.out.println("Sorry that was not a valid response, return to main menu");
		    choice = 2035553;
		    break;
		}
		

	}
    }

// Case 22
    // This adds an award to the list, automatically assigns it the next AId in the award table OR awards an award to a new winner/Year
    public static void AddNewAwardsWinners(Connection conn) throws SQLException
    {
	Statement stmt = conn.createStatement();

	Scanner keyboard;
	keyboard = new Scanner(System.in);
	int choice = 0;
	String award = "";
	while(choice != 2035553) {
	    System.out.println("Would you like to:");
	    System.out.println("1. Add an Award to the database");
	    System.out.println("2. Add an Award Winner to the database");
	    System.out.print("===>");
	    
	    choice = keyboard.nextInt();
	    
	    switch(choice)
		{
		case 1:
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the name of the new Award?:");
		    System.out.print("===> ");
		    award = keyboard.nextLine();
		    System.out.println();

		    String qry ="INSERT INTO AWARDS (AId, AName) VALUES ((select MAX(AId)+1 FROM AWARDS), '" + award + "')";

		    int updated = stmt.executeUpdate(qry);
		    if (updated == 1)
			{
			    System.out.println(award + " added to table");
			    choice = 2035553;
			}
		    else 
			{
			    System.out.println("Sorry, there was an error please try again");
			}
		    break;

		case 2:
		    //ask what letter the award name starts with
		    String letter = "";
		    System.out.print("What letter does the Award start with? ===>");
		    keyboard = new Scanner(System.in);
		    letter = keyboard.nextLine();
		    //print awards/AIds that start with that letter
		    String qry2 = "select AId, AName from AWARDS where AName like '" + letter + "%'";
		    ResultSet rs = stmt.executeQuery(qry2);
		    String last = "";
         while (rs.next())
         {
            int AwardId = rs.getInt("AId");
            String AwardName = rs.getString("AName");
            if(last == "")
            {
              last = AwardName;
              System.out.println(AwardId + ": " + AwardName);
            }

            if(!AwardName.equals(last))
            {
              System.out.println(AwardId + ": " + AwardName);
              last = AwardName;
            }
         }
         System.out.println();
         System.out.print("Enter ID number of Award===>");
         keyboard = new Scanner(System.in);
		 int Award = keyboard.nextInt();
		 System.out.println();
		 qry2 = "select * FROM AWARDS where AId = " + Award;
		 rs = stmt.executeQuery(qry2);
		 String AWName = "";
		 while(rs.next())
		 {
		 AWName = rs.getString("AName");
		 } 
		 //ask what year of award/enter year
         keyboard = new Scanner(System.in);
		 System.out.println("Enter the Year this was Awarded ===>:");
		 System.out.print("===> ");
		 int Year = keyboard.nextInt();
		 System.out.println();
		 //ask what letter game starts with
		 //print BG names and BGIds of games starting with that letter 
		    System.out.print("What letter does the winning Game start with? ===>");
		    keyboard = new Scanner(System.in);
		    letter = keyboard.nextLine();
		     //print Games that start with that letter
		    qry2 = "select BGId, BGName from BOARDGAMES where BGName like '" + letter + "%'";
		    rs = stmt.executeQuery(qry2);
		    last = "";
         while (rs.next())
         {
            int BoardGameId = rs.getInt("BGId");
            String BGName = rs.getString("BGName");
            if(last == "")
            {
              last = BGName;
              System.out.println(BoardGameId + ": " + BGName);
            }

            if(!BGName.equals(last))
            {
              System.out.println(BoardGameId + ": " + BGName);
              last = BGName; 
            }
         }
		    
		 System.out.println();
		 keyboard = new Scanner(System.in);
		 System.out.println("Enter the IDNumber of the Game for this that won the award:");
		 System.out.print("===> ");
		 int Game = keyboard.nextInt();
		 System.out.println(); 
		 qry2 = "select * FROM BOARDGAMES where BGId = " + Game;
		 rs = stmt.executeQuery(qry2);
		 String BName = "";
		 while(rs.next())
		 {
		 BName = rs.getString("BGName");
		 } 
		 
		 
		 
		 qry ="INSERT INTO AWARDED (BoardGameId, AwardId, YearAwarded) VALUES (" + Game + ", " + Award + ", " + Year + ")";

		    updated = stmt.executeUpdate(qry);
		    if (updated == 1)
			{
			    System.out.println(AWName + " for " + Year +" awarded to " + BName);
			    choice = 2035553;
			}
		    else 
			{
			    System.out.println("Sorry, there was an error please try again");
			}
		    
		    break;
		    
		default:
		    System.out.println("Sorry that was not a valid response, return to main menu");
		    choice = 2035553;
		    break;
		}
		

	}
    }

	//Case 23
	//this method is for Adding records to Creators and Contributors tables.
	public static void AddNewContribs(Connection conn) throws SQLException
	{
		Statement stmt = conn.createStatement();

	Scanner keyboard;
	keyboard = new Scanner(System.in);
	int choice = 0;
	String award = "";
	while(choice != 2035553) {
	    System.out.println("Would you like to:");
	    System.out.println("1. Add a Creator to the database");
	    System.out.println("2. Assign a Creator a new Contribution");
	    System.out.print("===>");
	    
	    choice = keyboard.nextInt();
	    
	    switch(choice)
		{
		case 1:
		    keyboard = new Scanner(System.in);
		    System.out.println("What is the name of the Creator:");
		    System.out.print("===> ");
		    String Name = keyboard.nextLine();
		    System.out.println();

		    String qry ="INSERT INTO CREATOR (CId, CName) VALUES ((select MAX(CId)+1 FROM CREATOR), '" + Name + "')";

		    int updated = stmt.executeUpdate(qry);
		    if (updated == 1)
			{
			    System.out.println(Name + " added to Creators table");
			    choice = 2035553;
			}
		    else 
			{
			    System.out.println("Sorry, there was an error please try again");
			}
		    break;

		case 2:
		    //ask what letter the creator's name starts with
		    String letter = "";
		    System.out.print("What letter does the Creators name start with? ===>");
		    keyboard = new Scanner(System.in);
		    letter = keyboard.nextLine();
		    //print awards/AIds that start with that letter
		    String qry2 = "select CId, CName from CREATOR where CName like '" + letter + "%'";
		    ResultSet rs = stmt.executeQuery(qry2);
		    String last = "";
         while (rs.next())
         {
            int CreatorId = rs.getInt("CId");
            String CreatorName = rs.getString("CName");
            if(last == "")
            {
              last = CreatorName;
              System.out.println(CreatorId + ": " + CreatorName);
            }

            if(!CreatorName.equals(last))
            {
              System.out.println(CreatorId + ": " + CreatorName);
              last = CreatorName;
            }
         }
         System.out.println();
         System.out.print("Enter ID number of Creator===>");
         keyboard = new Scanner(System.in);
		 int Creator = keyboard.nextInt();
		 System.out.println();
		 qry2 = "select * FROM CREATOR where CId = " + Creator;
		 rs = stmt.executeQuery(qry2);
		 String CName = "";
		 while(rs.next())
		 {
		 CName = rs.getString("CName");
		 } 
		 //ask what role that creator filled 
         keyboard = new Scanner(System.in);
		 System.out.println("What Role did this creator fill?");
		 System.out.println("1. Artist");
		 System.out.println("2. Designer");
		 System.out.print("===> ");
		 int Role = keyboard.nextInt();
		 System.out.println();
		 qry2 = "select Role from ROLES where RId = " + Role;
		 rs = stmt.executeQuery(qry2);
		 String RName = "";
		 while(rs.next())
		 {
		 RName = rs.getString("Role");
	     }
		 //ask what letter game starts with
		 //print BG names and BGIds of games starting with that letter 
		    System.out.print("What letter does the Game start with? ===>");
		    keyboard = new Scanner(System.in);
		    letter = keyboard.nextLine();
		     //print Games that start with that letter
		    qry2 = "select BGId, BGName from BOARDGAMES where BGName like '" + letter + "%'";
		    rs = stmt.executeQuery(qry2);
		    last = "";
		    String BGName = "";
         while (rs.next())
         {
            int BoardGameId = rs.getInt("BGId");
            BGName = rs.getString("BGName");
            if(last == "")
            {
              last = BGName;
              System.out.println(BoardGameId + ": " + BGName);
            }

            if(!BGName.equals(last))
            {
              System.out.println(BoardGameId + ": " + BGName);
              last = BGName; 
            }
         }
		    
		 System.out.println();
		 keyboard = new Scanner(System.in);
		 System.out.println("Enter the IDNumber of the Game for this that won the award:");
		 System.out.print("===> ");
		 int Game = keyboard.nextInt();
		 System.out.println();
		 
		 qry2 = "select BGName from BOARDGAMES where BGId = " + Game;
		 rs = stmt.executeQuery(qry2);
		 while(rs.next())
		 {
		 BGName = rs.getString("BGName"); 
	     }
		 
		 qry ="INSERT INTO CONTRIBUTORS (RoleId, CreatorId, BoardgameId) VALUES (" + Role + ", " + Creator + ", " + Game + ")";

		    updated = stmt.executeUpdate(qry);
		    if (updated == 1)
			{
			    System.out.println(CName + " added as " + RName + " for " + BGName);
			    choice = 2035553;
			}
		    else 
			{
			    System.out.println("Sorry, there was an error please try again");
			}
		    
		    break;
		    
		default:
		    System.out.println("Sorry that was not a valid response, return to main menu");
		    choice = 2035553;
		    break;
		}
		

	}
}

   // Case 24
   // This method is for adding new Releases of existing boardgames
   
   public static void NewRelease(Connection conn) throws SQLException
   {
   
	//ask what letter game starts with
		 //print BG names and BGIds of games starting with that letter
			Statement stmt = conn.createStatement();
			Scanner keyboard;
			ResultSet rs;
			String qry = "";
			String qry2 = "";
			String letter = "";
		    System.out.print("What letter does the Game start with? ===>");
		    keyboard = new Scanner(System.in);
		    letter = keyboard.nextLine();
		     //print Games that start with that letter
		    qry2 = "select BGId, BGName from BOARDGAMES where BGName like '" + letter + "%'";
		    rs = stmt.executeQuery(qry2);
		    String last = "";
		    String BGName = "";
         while (rs.next())
         {
            int BoardGameId = rs.getInt("BGId");
            BGName = rs.getString("BGName");
            if(last == "")
            {
              last = BGName;
              System.out.println(BoardGameId + ": " + BGName);
            }

            if(!BGName.equals(last))
            {
              System.out.println(BoardGameId + ": " + BGName);
              last = BGName; 
            }
         }
		    
		 System.out.println();
		 keyboard = new Scanner(System.in);
		 System.out.println("Enter the IDNumber of the Game you are adding a release for:");
		 System.out.print("===> ");
		 int Game = keyboard.nextInt();
		 System.out.println();
		 
		 qry2 = "select BGName from BOARDGAMES where BGId = " + Game;
		 rs = stmt.executeQuery(qry2);
		 while(rs.next())
		 {
		 BGName = rs.getString("BGName"); 
	     }
	     
	     // Get the language of the release
	     qry2 = "select LId, Language from Languages";
		    rs = stmt.executeQuery(qry2);
		    last = "";
		    String Lang = "";
         while (rs.next())
         {
            int LangId = rs.getInt("LId");
            Lang = rs.getString("Language");
            if(last == "")
            {
              last = Lang;
              System.out.println(LangId + ": " + Lang);
            }

            if(!Lang.equals(last))
            {
              System.out.println(LangId + ": " + Lang);
              last = Lang; 
            }
         }
		    
		 System.out.println();
		 keyboard = new Scanner(System.in);
		 System.out.println("Enter the IDNumber of the Language for this release");
		 System.out.print("===> ");
		 int LangNum = keyboard.nextInt();
		 System.out.println();
		 
		 qry2 = "select Language from LANGUAGES where LId = " + LangNum;
		 rs = stmt.executeQuery(qry2);
		 while(rs.next())
		 {
		 Lang = rs.getString("Language"); 
	     }
	     
	     
	     
	     qry ="INSERT INTO RELEASES (BoardgameId, LanguageId) VALUES (" + Game + ", " + LangNum + ")";

		    int updated = stmt.executeUpdate(qry);
		    if (updated == 1)
			{
			    System.out.println("A release of " + BGName + " in " + Lang + " has been added ");
			}
		    else 
			{
			    System.out.println("Sorry, there was an error please try again");
			}
	}
	
   
   
   
   // Case 31
   // This method is for the query of board game by award+year
   public static void SearchWinnerbyYear(Connection conn) throws SQLException
   {
      Statement stmt = conn.createStatement();


      Scanner keyboard;
      int response = 2;
	  String award = "";
      while(response != 2035553){
         keyboard = new Scanner(System.in);
         System.out.println("Type an award name for a wildcard search:");
         System.out.print("Your choice ==> ");
         award = keyboard.nextLine();
         System.out.println( );

         keyboard = new Scanner(System.in);
         System.out.println("Type a winning year:");
         System.out.print("Your choice ==> ");
         response = keyboard.nextInt();
         System.out.println( );

         String qry = "select bgname, aname, yearawarded "
                      + "from boardgames, awards, awarded ";
         
		qry += "where aname like '" + award + "%'";

         qry += " and aid = AwardId and yearawarded = " + response;
		 qry += " and bgid = BoardgameId";
         qry += " order by aname";
            
         ResultSet rs = stmt.executeQuery(qry);

         // Step 3: loop through the result set
         String last = "";
         while (rs.next())
         {
            String yearawarded = rs.getString("yearawarded");
            String bgname = rs.getString("BGName");
            String aname = rs.getString("aname");
            if(last == "")
            {
              last = aname;
              System.out.println(yearawarded + ": " + aname);
            }

            if(!aname.equals(last))
            {
              System.out.println(yearawarded + ": " + aname);
              last = aname;
            }
            System.out.println("\tWinner: " + bgname);
         }
         System.out.println( );
         rs.close();

         break;
      }
   }



   // Case 32
   // This method is for querying board game mechanisms
   public static void SearchGamebyMech(Connection conn) throws SQLException
   {
      Statement stmt = conn.createStatement();


      Scanner keyboard;
      int response = 2;
	  String mech = "";
      while(response != 2035553){
         keyboard = new Scanner(System.in);
         System.out.println("Type a mechanism for a wildcard search:");
         System.out.print("Your choice ==> ");
         mech = keyboard.nextLine();
         System.out.println( );

         String qry = "select distinct bgname "
                      + "from boardgames, mechanics, mechanisms ";
         
		qry += "where mechanism like '" + mech + "%'";

         qry += " and mid = mechanismid and bgid = BoardgameId";
         qry += " order by bgname";

         ResultSet rs = stmt.executeQuery(qry);

         // Step 3: loop through the result set
         while (rs.next())
         {
            String bgname = rs.getString("BGName");
            System.out.println("\t" + bgname);
         }
         System.out.println( );
         rs.close();

         break;
      }
   }


   // Case 33
   // This method is for the query for expansions from a base game
   public static void SearchExpbyBaseGame(Connection conn) throws SQLException
   {
      Statement stmt = conn.createStatement();


      Scanner keyboard;
      int response = 2;
      while(response != 2035553){
         keyboard = new Scanner(System.in);
         System.out.println("Choose from one of the following options:");
         System.out.println("   1. Type full board game name.\n");
         System.out.println("   2. Type beginning of name (wildcard Beginn*).\n");
         System.out.print("Your choice ==> ");
         response = keyboard.nextInt();
         System.out.println( );
         if(response != 1 && response != 2)
            continue;

         keyboard = new Scanner(System.in);
         String bgname;
         System.out.println("Enter the board game name: ");
         System.out.print("Your choice ==> ");
         bgname = keyboard.nextLine();
         System.out.println( );


         String qry = "select distinct ename "
                      + "from boardgames, expansions ";
         
         if(response == 1) // Full name
         {
            qry += "where bgname = '" + bgname + "'";
         }
         else // Beginning of name
         {
            qry += "where bgname like '" + bgname + "%'";
         }

         qry += " and bgid = basebgid";
         qry += " order by ename";

         ResultSet rs = stmt.executeQuery(qry);

         // Step 3: loop through the result set
         while (rs.next())
         {
            String expname = rs.getString("EName");
            System.out.println("\t" + expname);
         }
         System.out.println( );
         rs.close();

         break;
      }
   }



   // Case 34
   // This method is for the query of games by creator
   public static void SearchGamebyCont(Connection conn) throws SQLException
   {
	Statement stmt = conn.createStatement();

	Scanner keyboard;
	int response = 2;
	String award = "";
    int role = 0;
	String contributor = "";
	while(response != 2035553){
		 keyboard = new Scanner(System.in);
		 System.out.println("What creator are you interested in?");
		 System.out.println("(Just type the beginning of a wildcard search)");
		 System.out.print("Your choice ==> ");
		 contributor = keyboard.nextLine();
		 System.out.println( );
		 while(response != 2035553){
			keyboard = new Scanner(System.in);
			System.out.println(contributor + " as?");
			System.out.println("   1. Artist\n");
			System.out.println("   2. Designer\n");
			System.out.println("   3. Neither\n");
			System.out.print("Your choice ==> ");
			response = keyboard.nextInt();
			System.out.println( );
			if(response == 3)
			   break;
			if(response < 0 || response > 2)
			   continue;
			role = response;
			break;
		 }
		 break;
	}

	String qry = "select distinct bgname, cname "
			  + "from boardgames";


	qry += ", contributors as c, creator, roles";
	
	qry += " where cname like '" + contributor + "%'";
	if(response != 3)
		qry += " and rid = " + role;
	
	qry += " and CId = CreatorId and c.BoardgameId = BGId";
    qry += " order by cname";

	ResultSet rs = stmt.executeQuery(qry);

	// Step 3: loop through the result set
	String last = "";
	while (rs.next())
	{
       String cname = rs.getString("cname");
       if(last == "")
       {
           last = cname;
           System.out.println(cname + ":");
       }

       if(!cname.equals(last))
       {
           System.out.println(cname + ":");
           last = cname;
       }
       String bgname = rs.getString("bgname");
       System.out.println("\t" + bgname);
	}
	System.out.println( );
	rs.close();
   }



   // Case 35
   // This method is for the query of games with the same contributors
   public static void SearchGamesWithContribSet(Connection conn) throws SQLException
   {
	Statement stmt = conn.createStatement();

	Scanner keyboard;
	int response = 2;
    int role = 0;
	String award = "";
	String contrib1 = "";
	String contrib2 = "";
	while(response != 2035553){
		 keyboard = new Scanner(System.in);
		 System.out.println("What creators are you interested in?");
		 System.out.println("(Just type the beginning of a wildcard search)");
		 System.out.print("Your first choice ==> ");
		 contrib1 = keyboard.nextLine();
		 System.out.print("Your second choice ==> ");
		 contrib2 = keyboard.nextLine();
		 System.out.println( );
         break;
	}


	String qry = "select distinct bgname from boardgames, contributors, creator " +
        "where bgid = boardgameid and creatorid = cid and " +
        "cname like '" + contrib1 + "%' in (" + 
	    "select bgname from boardgames, contributors, creator " +
        "where bgid = boardgameid and creatorid = cid and " +
        "cname like '" + contrib2 + "%')";



	// Step 3: loop through the result set
      ResultSet rs = stmt.executeQuery(qry);

      while (rs.next())
      {
        String bgname = rs.getString("bgname");
         System.out.print("\t" + bgname + "\n");
      }


	System.out.println( );
	rs.close();
   }




   // This method for a custom search.  Very exciting.
   public static void CustomSearch(Connection conn) throws SQLException
   {
      Statement stmt = conn.createStatement();

      Scanner keyboard;
      int response = 2;
      while(response != 2035553){
         keyboard = new Scanner(System.in);
         System.out.println("Choose from one of the following options:");
         System.out.println("   1. Guided search for (a) board game(s).\n");
         System.out.println("   2. Type own search.\n");
         System.out.print("Your choice ==> ");
         response = keyboard.nextInt();
         System.out.println( );
         if(response != 1 && response != 2)
            continue;

         // If 2, type away, hit database...
         if(response == 2)
         {
            keyboard = new Scanner(System.in);
            System.out.print("Your command ==> ");
            String qry = keyboard.nextLine();
            if(qry.indexOf(';') < 0)
            {
               System.out.print("Query must end with a semicolon (;) character.");
               System.out.println( );
               System.out.println( );
               continue;
            }
            qry = qry.split(";")[0];
            ResultSet rs = stmt.executeQuery(qry);
            ResultSetMetaData md = rs.getMetaData();
            int colCount = md.getColumnCount();

            while (rs.next())
            {
               // This SHOULD print all columns...
               for (int i = 1; i <= colCount; i++){  
                  String col_name = md.getColumnName(i);  
                  String idx_out = rs.getString(col_name);
                  System.out.print("\t" + idx_out);
               }
               System.out.print("\n");
            }
            System.out.println( );
            rs.close();
            return;
         }
         // Else, guide...
         else
         {
            int bgyearpub = 0;
            int bgplay = 0;
            int bgplaygt = 0;
            int bgage = 0;
            int bgmax = 0;
            int bgmin = 0;
            int bgsugg = 0;
            String mechanism = "";
            String contributor = "";
            int role = 0;
            String lang = "";
            int yearawarded = 0;
            String award = "";
            String answr = "";
            while(response != 2035553){
               keyboard = new Scanner(System.in);
               System.out.println("What board game traits do you want to search on?");
               System.out.println("   1. Year Published\n");
               System.out.println("   2. Play Time\n");
               System.out.println("   3. Minimum Age\n");
               System.out.println("   4. Maximum Number of Players\n");
               System.out.println("   5. Minimum Number of Players\n");
               System.out.println("   6. Suggested Number of Players\n");
               System.out.println("   11. None of those\n");
               System.out.print("Your choice ==> ");
               response = keyboard.nextInt();
               System.out.println( );
               if(response == 11)
                  break;
               if(response > 6 || response < 1)
                  continue;
               switch (response)
               {
                  case 1:
                     keyboard = new Scanner(System.in);
                     System.out.println("What publishing year are you interested in?");
                     System.out.print("Your choice ==> ");
                     answr = keyboard.nextLine();
                     System.out.println( );
                    break;
                  case 2:
                     keyboard = new Scanner(System.in);
                     System.out.println("What play time are you interested in?");
                     System.out.print("Your choice ==> ");
                     bgplay = keyboard.nextInt();
                     System.out.println( );
                     while(response != 2035553){
                        keyboard = new Scanner(System.in);
                        System.out.println("More or less than " + bgplay + "?");
                        System.out.println("   1. More\n");
                        System.out.println("   2. Less\n");
                        System.out.print("Your choice ==> ");
                        response = keyboard.nextInt();
                        System.out.println( );
                        if(response < 0 || response > 2)
                           continue;
                        bgplaygt = response;

                        break;
                     }
                    break;
                  case 3:
                     keyboard = new Scanner(System.in);
                     System.out.println("What is the youngest player's age?");
                     System.out.print("Your choice ==> ");
                     bgage = keyboard.nextInt();
                     System.out.println( );
                    break;
                  case 4:
                     keyboard = new Scanner(System.in);
                     System.out.println("What maximum number of players do you want?");
                     System.out.print("Your choice ==> ");
                     bgmax = keyboard.nextInt();
                     System.out.println( );
                    break;
                  case 5:
                     keyboard = new Scanner(System.in);
                     System.out.println("What minimum number of players do you want?");
                     System.out.print("Your choice ==> ");
                     bgmin = keyboard.nextInt();
                     System.out.println( );
                    break;
                  case 6:
                     keyboard = new Scanner(System.in);
                     System.out.println("What suggested number of player do you want?");
                     System.out.print("Your choice ==> ");
                     bgsugg = keyboard.nextInt();
                     System.out.println( );
                    break;
               }
            }

            while(response != 2035553){
               keyboard = new Scanner(System.in);
               System.out.println("What board game traits do you want to search on?");
               System.out.println("   1. Game Play Mechanism\n");
               System.out.println("   2. Creator\n");
               System.out.println("   11. Neither of those\n");
               System.out.print("Your choice ==> ");
               response = keyboard.nextInt();
               System.out.println( );
               if(response == 11)
                  break;
               if(response > 2 || response < 1)
                  continue;
               switch (response)
               {
                  case 1:
                     keyboard = new Scanner(System.in);
                     System.out.println("What game play mechanism are you interested in?");
                     System.out.println("(Just type the beginning of a wildcard search)");
                     System.out.print("Your choice ==> ");
                     mechanism = keyboard.nextLine();
                     System.out.println( );
                    break;
                  case 2:
                     keyboard = new Scanner(System.in);
                     System.out.println("What creator are you interested in?");
                     System.out.println("(Just type the beginning of a wildcard search)");
                     System.out.print("Your choice ==> ");
                     contributor = keyboard.nextLine();
                     System.out.println( );
                     while(response != 2035553){
                        keyboard = new Scanner(System.in);
                        System.out.println(contributor + " as?");
                        System.out.println("   1. Artist\n");
                        System.out.println("   2. Designer\n");
                        System.out.println("   3. Neither\n");
                        System.out.print("Your choice ==> ");
                        response = keyboard.nextInt();
                        System.out.println( );
                        if(response == 3)
                           break;
                        if(response < 0 || response > 2)
                           continue;
                        role = response;
                        break;
                     }
                    break;
               }
            }


            while(response != 2035553){
               keyboard = new Scanner(System.in);
               System.out.println("What board game traits do you want to search on?");
               System.out.println("   1. Language\n");
               System.out.println("   2. Award Received\n");
               System.out.println("   3. Year Awarded\n");
               System.out.println("   11. None of those\n");
               System.out.print("Your choice ==> ");
               response = keyboard.nextInt();
               System.out.println( );
               if(response == 11)
                  break;
               if(response > 3 || response < 1)
                  continue;
               switch (response)
               {
                  case 1:
                     keyboard = new Scanner(System.in);
                     System.out.println("What language are you interested in?");
                     System.out.println("(Just type the beginning of a wildcard search)");
                     System.out.print("Your choice ==> ");
                     lang = keyboard.nextLine();
                     System.out.println( );
                    break;
                  case 2:
                     keyboard = new Scanner(System.in);
                     System.out.println("What award are you interested in?");
                     System.out.println("(Just type the beginning of a wildcard search)");
                     System.out.print("Your choice ==> ");
                     award = keyboard.nextLine();
                     System.out.println( );
                    break;
                  case 3:
                     keyboard = new Scanner(System.in);
                     System.out.println("What awarded year are you interested in?");
                     System.out.print("Your choice ==> ");
                     yearawarded = keyboard.nextInt();
                     System.out.println( );
                    break;
               }
            }

            // Search criteria gathered...now build query.
            int whereused = 0;

            int querymade = 0;
            String qry = "select distinct bgid, bgname from boardgames";
            if(mechanism != "")
            {
               qry += ", mechanics as m, mechanisms";
               querymade = 1;
            }
            if(contributor != "")
            {
               qry += ", contributors as c, creator, roles";
               querymade = 1;
            }
            if(lang != "")
            {
               qry += ", releases as r, languages";
               querymade = 1;
            }
            if(award != "" || yearawarded != 0)
            {
               qry += ", awarded as a, awards";
               querymade = 1;
            }

            if(bgyearpub != 0)
            {
               whereused = 1;
               qry += " where bgyearpublished = '" + bgyearpub + "'";
               querymade = 1;
            }

            if(bgplay != 0)
            {
               querymade = 1;
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where bgplaytime ";
                  if(bgplaygt == 1)
                     qry += ">=" + bgplay;
                  else
                     qry += "<=" + bgplay;
               }
               else
               {
                  qry += " and bgplaytime ";
                  if(bgplaygt == 1)
                     qry += ">=" + bgplay;
                  else
                     qry += "<=" + bgplay;
               }
            }

            if(bgage != 0)
            {
               querymade = 1;
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where bgminage >= '" + bgage + "'";
               }
               else
               {
                  qry += " and bgminage >= '" + bgage + "'";
               }
            }


            if(bgmax != 0)
            {
               querymade = 1;
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where BGMaxNumber <= " + bgmax;
               }
               else
               {
                  qry += " and BGMaxNumber <= " + bgmax;
               }
            }

            if(bgmin != 0)
            {
               querymade = 1;
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where BGMinNumber >= " + bgmin;
               }
               else
               {
                  qry += " and BGMinNumber >= " + bgmin;
               }
            }

            if(bgsugg != 0)
            {
               querymade = 1;
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where BGSuggestedNum = " + bgsugg;
               }
               else
               {
                  qry += " and BGSuggestedNum = " + bgsugg;
               }
            }


            if(mechanism != "")
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where Mechanism like '" + mechanism + "%'" +
                  " and MId = MechanismId and m.BoardgameId = BGId";
               }
               else
               {
                  qry += " and Mechanism like '" + mechanism + "%'" +
                  " and MId = MechanismId and m.BoardgameId = BGId";
               }
            if(contributor != "")
            {
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where cname like '" + contributor + "%'" +
                  " and CId = CreatorId and c.BoardgameId = BGId";
               }
               else
               {
                  qry += " and cname like '" + contributor + "%'" +
                  " and CId = CreatorId and c.BoardgameId = BGId";
               }
               if(role != 0)
               {
                  qry += " and RId = " + role;
               }
            }
            if(lang != "")
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where Language like '%" + lang + "%'" +
                  " and LId = LanguageId and r.BoardgameId = BGId";
               }
               else
               {
                  qry += " and Language like '%" + lang + "%'" +
                  " and LId = LanguageId and r.BoardgameId = BGId";
               }
            int alreadyawarded = 0;
            if(award != "")
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where AName like '" + award + "%'" +
                  " and AId = AwardId and a.BoardgameId = BGId";
                  alreadyawarded = 1;
               }
               else
               {
                  qry += " where AName like '" + award + "%'" +
                  " and AId = AwardId and a.BoardgameId = BGId";
                  alreadyawarded = 1;
               }
            if(yearawarded != 0)
            {
               if(whereused == 0)
               {
                  whereused = 1;
                  qry += " where YearAwarded = " + yearawarded;
               }
               else
               {
                  qry += " where YearAwarded = " + yearawarded;
               }
               if(alreadyawarded == 0)
                  qry += " and a.BoardgameId = BGId";
            }

            if(querymade == 0)
            {
               System.out.print("Must select something to search on...\n\n");
               continue;
            }

            qry += "\n";

            // Need to get and print statement
               ResultSet rs = stmt.executeQuery(qry);
               ResultSetMetaData md = rs.getMetaData();
               int colCount = md.getColumnCount();

               while (rs.next())
               {
                  String id = rs.getString("BGId");
                  String bgname = rs.getString("BGName");
                  System.out.print("\t" + id + "\t" + bgname + "\n");
               }
               System.out.println( );
               rs.close();


            break;
         }
      }
   }



   // Case 37
   // This method is for the query of games by creator
   public static void top20(Connection conn) throws SQLException
   {
	Statement stmt = conn.createStatement();

    System.out.print("Printing top 20 board games (by awards received)\n");
    System.out.println( );

	String qry = "select bgname, count(awardid) from boardgames, awarded " +
                "where BoardgameId = bgid " +
                "group by bgname order by count(awardid) desc";



	// Step 3: loop through the result set
      ResultSet rs = stmt.executeQuery(qry);

      int count = 0;
      while (rs.next() && count < 20)
      {
        String bgname = rs.getString("bgname");
        count = count + 1;
         System.out.print("\t" + count + ". " + bgname + "\n");
      }
      System.out.println( );
	rs.close();
   }




   // Case 38
   // This method is for the query of games by creator
   public static void mostpopbymech(Connection conn) throws SQLException
   {
	Statement stmt = conn.createStatement();

	Scanner keyboard;
	String mech = "";
      keyboard = new Scanner(System.in);
      System.out.println("What mechanism are you interested in?");
      System.out.println("(Just type the beginning of a wildcard search)");
      System.out.print("Your choice ==> ");
      mech = keyboard.nextLine();
      System.out.println( );


	String qry = "select bgname, count(awardid) " + 
        "from boardgames, awarded a, mechanics m, mechanisms " +
        "where a.BoardgameId = bgid and m.boardgameid = bgid " +
        "and mid = m.MechanismId and Mechanism like '%" + mech + "%' " +
        "group by bgname order by count(a.awardid) desc";


	// Step 3: loop through the result set
      ResultSet rs = stmt.executeQuery(qry);

      int count = 0;
      while (rs.next())
      {
        String bgname = rs.getString("bgname");
        count = count + 1;
         System.out.print("\t" + count + ". " + bgname + "\n");
      }
      System.out.println( );
	rs.close();

   }



   // Case 39
   // This method is for the query of games by creator
   public static void mostcomplex(Connection conn) throws SQLException
   {
	Statement stmt = conn.createStatement();

      System.out.println("Printing the top 15 more complex games by mechanisms and expansions.");
      System.out.println( );


	String qry = "select bgname, count(mechanism), count(eid)  " + 
        "from boardgames, awarded a, mechanics m, mechanisms, expansions " +
        "where a.BoardgameId = bgid and m.boardgameid = bgid " +
        "and mid = m.MechanismId and basebgid = bgid " +
        "group by bgname order by count(mechanism) desc, count(eid) desc";


	// Step 3: loop through the result set
      ResultSet rs = stmt.executeQuery(qry);

      int count = 0;
      while (rs.next() && count < 25)
      {
        String bgname = rs.getString("bgname");
        count = count + 1;
         System.out.print("\t" + count + ". " + bgname + "\n");
      }
      System.out.println( );
	rs.close();

   }




   public static int PrintMenuAndGetResponse()
   {
      Scanner keyboard;
      int response = 2;
      while(response != 2035553){
         keyboard = new Scanner(System.in);
         System.out.println("Choose from one of the following options:");
         System.out.println("   1. Data Entry.\n");
         System.out.println("   2. Search.\n");
         System.out.println("  11. Quit the program\n");
         System.out.print("Your choice ==> ");
         response = keyboard.nextInt();
         System.out.println( );
         if(response == 1) while(response != 2035553){
            keyboard = new Scanner(System.in);
            System.out.println("Choose from one of the following options:");
            System.out.println("   1. Add new games/expansions.\n");
            System.out.println("   2. Add new awards/winners.\n");
            System.out.println("   3. Add new contributions/contributors.\n");
            System.out.println("   4. Add new Release of a Boardgame.\n");
            System.out.print("Your choice ==> ");
            response = keyboard.nextInt();
            System.out.println( );
            if(response < 0 || response > 4)
               continue;
            else
               return response + 20;
         }
         else if(response == 2) while(response != 2035553){
            keyboard = new Scanner(System.in);
            System.out.println("Choose from one of the following searches:");
            System.out.println("   1. Award winners by year.\n");
            System.out.println("   2. Games by mechanics.\n");
            System.out.println("   3. Expansions by base game.\n");
            System.out.println("   4. Games by contributor.\n");
            System.out.println("   5. Games with the same contributors.\n");
            System.out.println("   6. Custom.\n");
            System.out.println("   7. Top 20 games.\n");
            System.out.println("   8. Most popular games by mechanisms.\n");
            System.out.println("   9. Most complex games.\n");
            System.out.print("Your choice ==> ");
            response = keyboard.nextInt();
            System.out.println( );
            if(response < 0 || response > 9)
               continue;
            else
               return response + 30;
         }
         else if(response == 11)
         {
            return 11; // Goodbye!
         }
      }
      return response;
   }
}
