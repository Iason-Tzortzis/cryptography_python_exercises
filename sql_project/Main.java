import java.sql.*;

import java.util.*;


		public class Main{
		public static void main(String[] args) throws SQLException {
			
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "project_mk3";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root"; 
			String password = "";
			Boolean repeat = true;
			Scanner sc = new Scanner(System.in);
			try{
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,password);
				System.out.println("Connected to database");
			}catch(Exception e) {
				e.printStackTrace();
			
			} 

			try{
				Random rand = new Random();
				int i = rand.nextInt(1000000);
				
				Statement st = conn.createStatement();
				st.execute("SET FOREIGN_KEY_CHECKS=0");
				while(repeat) {
					String SI = Integer.toString(i);
					System.out.println("Input a number to select a function: \n"
							+ "1: Insert or Update Flights/Customers/Reservations\n"
							+ "2: Print List of Flights by Airline\n"
							+ "3: Display Full Flights\n" 
							+ "4: Display Flights between Toronto and New York\n" 
							+ "5: Ticket Reservation\n" 
							+ "6: Update Seat Status to Reserved/Paid\n" 
							+ "7: Delete Cancelled Reservations\n" 
							+ "0: Exit the Application\n");
					
					int input = sc.nextInt();
					switch(input) { // Main Functions
					case 1:
						System.out.println("Input a number to Insert/Update an Entity: \n"
								+ "1: Insert/Update Flight\n"
								+ "2: Insert/Update Customer\n"
								+ "3: Insert/Update Reservation\n");
						
						int input2 = sc.nextInt();
						System.out.println("Would you like to Update or Insert an entity?:\n"
								+ "1: Insert\n"
								+ "2: Update");
						int input3 = sc.nextInt();
						switch(input2) {
						
						
						case 1:                                                                                                      //Flight
							switch(input3) {
							case 1:
								//Insert
								
								Boolean B1 = true;
								Boolean B2 = true;
								
								
								System.out.println("Input Flight ID:");
								String I1 = sc.next();
								
								System.out.println("Input Airline ID:");
								String I2 = sc.next();
								
								System.out.println("Will there be Business Class seats?: (0:False/1:True)");
								int I5 = sc.nextInt();
									
								if(I5==0)
									B1 = false;
								
								System.out.println("Will there be Smoking seats?: (0:False/1:True)");
								int I6 = sc.nextInt();
								
								if(I6==0)
									B2 = false;
								System.out.println();
								String query = "INSERT INTO flight VALUES(?,?,?,?,?,?,?)";
							    
							    PreparedStatement PS = conn.prepareStatement(query);
							    PS.setString (1, I1);
							    PS.setString(2, I2);
							    PS.setBoolean(3, B1);
							    PS.setBoolean(4, B2);
							    PS.setString(5, SI); 
							    PS.setString(6, SI);
							    PS.setString(7, SI);
						        PS.executeUpdate();
						        
						        System.out.println("Flight Availability: ");
						       
							    
						        System.out.println("Input Flight Time:");
						        String I11 = sc.next();
						        
						        System.out.println("Input Flight Date:");
						        String I12 = sc.next();
						        
						        System.out.println("Input Arrival Airport:");
						        String I13 = sc.next();
						        
						        System.out.println("Input Departure Airport:");
						        String I14 = sc.next();
						        
						        System.out.println("Input Flight Duration:");
						        String I15 = sc.next();
						        
						        System.out.println("Input Total Business Class Seats:");
						        int I16 = sc.nextInt();
						        
						        System.out.println("Input Total Economy Class Seats:");
						        int I17 = sc.nextInt();
						        
						        String queryA = "INSERT INTO availability VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
							    PreparedStatement PSA = conn.prepareStatement(queryA);
							    PSA.setString (1, I1);
							    PSA.setString(2, I11);
							    PSA.setString(3, I12);
							    PSA.setString(4, I13);
							    PSA.setString(5, I14); 
							    PSA.setString(6, I15);
							    PSA.setInt(7, I16);
							    PSA.setInt(8,0);
							    PSA.setInt(9, I17); 
							    PSA.setInt(10,0);
							    PSA.setString(11,SI);
							    PSA.setString(12,SI);
							    PSA.setString(13,SI);
							    PSA.setString(14,SI);
							    PSA.setString(15,SI);
						        PSA.executeUpdate(); 
							break;
							case 2:
								//Update
								Boolean B11 = true;
								Boolean B21 = true;
								System.out.println("Insert the Flight ID of the flight you wish to UPDATE:\n");
								String FID = sc.next();
								
								String deleteQ = "DELETE FROM flight WHERE flight_id=?";
								PreparedStatement PSD = conn.prepareStatement(deleteQ);
								PSD.setString(1, FID);
								PSD.executeUpdate();
								
								String deleteQA = "DELETE FROM availability WHERE flight_id=?";
								PreparedStatement PSDA = conn.prepareStatement(deleteQA);
								PSDA.setString(1, FID);
								PSDA.executeUpdate();
								
								System.out.println("Input Airline ID:");
								String I21 = sc.next();
								
								System.out.println("Will there be Business Class seats?: (0:False/1:True)");
								int I51 = sc.nextInt();
									
								if(I51==0)
									B11 = false;
								
								System.out.println("Will there be Smoking seats?: (0:False/1:True)");
								int I61 = sc.nextInt();
								
								if(I61==0)
									B21 = false;
								System.out.println();
								String queryU = "INSERT INTO flight VALUES(?,?,?,?,?,?,?)";
							    
							    PreparedStatement PSU = conn.prepareStatement(queryU);
							    PSU.setString (1, FID);
							    PSU.setString(2, I21);
							    PSU.setBoolean(3, B11);
							    PSU.setBoolean(4, B21);
							    PSU.setString(5, SI); 
							    PSU.setString(6, SI);
							    PSU.setString(7, SI);
						        PSU.executeUpdate();
								System.out.println("Flight Information has been successfully UPDATED.\n");
								
								 System.out.println("Flight Availability: ");
							        String queryAU = "INSERT INTO availability VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								    
							        System.out.println("Input Flight Time:");
							        String I111 = sc.next();
							        
							        System.out.println("Input Flight Date:");
							        String I121 = sc.next();
							        
							        System.out.println("Input Arrival Airport:");
							        String I131 = sc.next();
							        
							        System.out.println("Input Departure Airport:");
							        String I141 = sc.next();
							        
							        System.out.println("Input Flight Duration:");
							        String I151 = sc.next();
							        
							        System.out.println("Input Total Business Class Seats:");
							        int I161 = sc.nextInt();
							        
							        System.out.println("Input Total Economy Class Seats:");
							        int I171 = sc.nextInt();
							        
							        System.out.println("Input Total Reserved Business Class Seats:");
							        int BR = sc.nextInt();
							        
							        System.out.println("Input Total Reserved Economy Class Seats:");
							        int ER = sc.nextInt();
							        
								    PreparedStatement PSA1 = conn.prepareStatement(queryAU);
								    PSA1.setString (1, FID);
								    PSA1.setString(2, I111);
								    PSA1.setString(3, I121);
								    PSA1.setString(4, I131);
								    PSA1.setString(5, I141); 
								    PSA1.setString(6, I151);
								    PSA1.setInt(7, I161);
								    PSA1.setInt(8, BR);
								    PSA1.setInt(9, I171);
								    PSA1.setInt(10, ER);
								    PSA1.setString(11, SI);
								    PSA1.setString(12, SI);
								    PSA1.setString(13, SI);
								    PSA1.setString(14, SI);
								    PSA1.setString(15, SI);
							        PSA1.executeUpdate();
							        System.out.println("Flight Availability Information has been successfully UPDATED.\n");
							break;
							}                                                                                                    //End Flight
						break;
						case 2:                                                                                                   //Customer
							switch(input3) {
							case 1:
								//Insert
		
								System.out.println("Insert Customer Name:");
								String I1 = sc.next();
								
								System.out.println("Insert Customer Surname:");
								String I2 = sc.next();
								System.out.println("Insert Customer Home Address:");
								String I3 = sc.next();
								System.out.println("Insert Customer Email Address:");
								String I4 = sc.next();
								System.out.println("Insert Customer Phone Number:");
								String I5 = sc.next();
								System.out.println("Insert Customer Fax Number:");
								String I6 = sc.next();
								System.out.println();
								String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?)";
							    
							    PreparedStatement PS = conn.prepareStatement(query);
							    PS.setString (1, I1);
							    PS.setString(2, I2);
							    PS.setString(3, I3);
							    PS.setString(4, I4);
							    PS.setString(5, I5); 
							    PS.setString(6, I6);
						        PS.executeUpdate();
							break;
							case 2:
								//Update
								System.out.println("Insert the Email Address of the Customer you wish to UPDATE:\n");
								String EMAIL = sc.next();
								
								String deleteQ = "DELETE FROM customer WHERE email=?";
								PreparedStatement PSD = conn.prepareStatement(deleteQ);
								PSD.setString(1, EMAIL);
								PSD.executeUpdate();
								
								System.out.println("Insert Customer Name:");
								String I11 = sc.next();
								
								System.out.println("Insert Customer Surname:");
								String I21 = sc.next();
								System.out.println("Insert Customer Home Address:");
								String I31 = sc.next();
			
								System.out.println("Insert Customer Phone Number:");
								String I51 = sc.next();
								System.out.println("Insert Customer Fax Number:");
								String I61 = sc.next();
								System.out.println();
								String queryU = "INSERT INTO Customer VALUES(?,?,?,?,?,?)";
							    
							    PreparedStatement PSU = conn.prepareStatement(queryU);
							    PSU.setString (1, I11);
							    PSU.setString(2, I21);
							    PSU.setString(3, I31);
							    PSU.setString(4, EMAIL);
							    PSU.setString(5, I51); 
							    PSU.setString(6, I61);
						        PSU.executeUpdate();
						        System.out.println("Customer Information has been successfully UPDATED.\n");
						        
							break;
							}                                                                                                  //End Customer
						break;
						case 3:                                                                                                //Reservation
							switch(input3) {
							case 1:
								//Insert
	
								
								System.out.println("Input Reservation ID:");
								String I1 = sc.next();
								System.out.println("Input City of Reservation:");
								String I2 = sc.next();
								
								java.util.Date dt = new java.util.Date();
								java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("dd-MM-yyyy");
								String I3 = sdf.format(dt);
								
								System.out.println("Input Flight ID:");
								String I4 = sc.next();
								System.out.println("Input Departure Time: (HH-MM-SS)");
								String I5 = sc.next();
								System.out.println("Input Departure Date: (dd-MM-yyyy)");
								String I6 = sc.next();
								System.out.println("Input Arrival Time: (HH-MM-SS)");
								String I7 = sc.next();
								System.out.println("Input Arrival Date: (dd-MM-yyyy)");
								String I8 = sc.next();
								System.out.println("Input Seat Type: (Business/Economy)");
								String I9 = sc.next();
								System.out.println("Input Flight Price:");
								double I10 = sc.nextDouble();
								System.out.println("Input the sum that was paid in advance by the customer:");
								double I11 = sc.nextDouble();
								System.out.println("Input the Seat Status: (A/B/C)");
								String I12 = sc.next();
								
								
								String queryR = "INSERT INTO reservation VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
								PreparedStatement PSL = conn.prepareStatement(queryR);
							    PSL.setString(1, I1);
							    PSL.setString(2, I2);
							    PSL.setString(3, I3);
							    PSL.setString(4, I4);
							    PSL.setString(5, I5); 
							    PSL.setString(6, I6);
							    PSL.setString(7, I7);
							    PSL.setString(8, I8);
							    PSL.setString(9, I9);
							    PSL.setDouble(10, 1.0);
							    PSL.setDouble(11, I10);
							    PSL.setDouble(12, I11);
							    PSL.setDouble(13, 1.0);
							    PSL.setString(14, I12);
							    PSL.setString(15, SI);
							    PSL.setString(16, SI);
							    PSL.setString(17, SI);
							    PSL.setString(18, SI);
							    PSL.setString(19, SI);
							    PSL.setDouble(20, 0.0);
							    PSL.executeUpdate();
							    
						        
						        
							break;                                                                                        
							case 2:
								//Update
								System.out.println("Insert the Reservation ID of the Reservation you wish to UPDATE:\n");
								String RES = sc.next();
								
								String deleteQ = "DELETE FROM reservation WHERE reservation_id=?";
								PreparedStatement PSD = conn.prepareStatement(deleteQ);
								PSD.setString(1, RES);
								PSD.executeUpdate();
								
								System.out.println("Input City of Reservation:");
								String I21 = sc.next();
								
								java.util.Date dt1 = new java.util.Date();
								java.text.SimpleDateFormat sdf1 =  new java.text.SimpleDateFormat("dd-MM-yyyy");
								String I31 = sdf1.format(dt1);
								
								System.out.println("Input Flight ID:");
								String I41 = sc.next();
								System.out.println("Input Departure Time: (HH-MM-SS)");
								String I51 = sc.next();
								System.out.println("Input Departure Date: (dd-MM-yyyy)");
								String I61 = sc.next();
								System.out.println("Input Arrival Time: (HH-MM-SS)");
								String I71 = sc.next();
								System.out.println("Input Arrival Date: (dd-MM-yyyy)");
								String I81 = sc.next();
								System.out.println("Input Seat Type: (Business/Economy)");
								String I91 = sc.next();
								System.out.println("Input Flight Price:");
								double I101 = sc.nextDouble();
								System.out.println("Input the sum that was paid in advance by the customer:");
								double I111 = sc.nextDouble();
								System.out.println("Input the Seat Status: (A/B/C)");
								String I121 = sc.next();
							
								
								String queryU = "INSERT INTO reservation VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
							    
							    PreparedStatement PSU = conn.prepareStatement(queryU);
							    PSU.setString(1, RES);
							    PSU.setString(2, I21);
							    PSU.setString(3, I31);
							    PSU.setString(4, I41);
							    PSU.setString(5, I51); 
							    PSU.setString(6, I61);
							    PSU.setString(7, I71);
							    PSU.setString(8, I81);
							    PSU.setString(9, I91);
							    PSU.setDouble(10, 1);
							    PSU.setDouble(11, I101);
							    PSU.setDouble(12, I111);
							    PSU.setDouble(13, 1);
							    PSU.setString(14, I121);
							    PSU.setString(15, SI);
							    PSU.setString(16, SI);
							    PSU.setString(17, SI);
							    PSU.setString(18, SI);
							    PSU.setString(19, SI);
							    PSU.setDouble(20, 0.0);
						        PSU.executeUpdate();
						        System.out.println("Reservation Information has been successfully UPDATED.\n");
							break;
							}                                                                                                   //End Reservation
						break;
						case 0: //Exit
						break;
						}
						
					break;
					case 2:
						//Print all flights by Airline
						  String query1 = "SELECT * FROM flight"; //AIRCAN
	                      ResultSet rs1 = st.executeQuery(query1);
	                      System.out.println("AirCan Flights: ");
	                      while (rs1.next())
	                      {
	                    	  String flight_id = rs1.getString("flight_id");
	                          String airline_id = rs1.getString("airline_id");
	                          Double businessclass = rs1.getDouble("businessclass");
	                          Double smokingseats = rs1.getDouble("smokingseats");

	                        if(airline_id.equals("AirCan")) {
	                        	 // print the results
		                        System.out.format("Flight ID: %s, Airline: %s, ", flight_id, airline_id);
		                        if(businessclass==1) {
		                        	System.out.print("Business Class seats Available, ");
		                        }
		                        else {
		                        	System.out.print("Business Class seats not Available, ");
		                        }
		                        if(smokingseats==1) {
		                        	System.out.print("Smoking seats Available.");
		                        }
		                        else {
		                        	System.out.print("Smoking seats not Available.");
		                        }
		                        System.out.println();
	                        }
	                      }
	                      System.out.println(); 
	                      
	                      
	                      
	                      String query2 = "SELECT * FROM flight"; //USAIR
	                      ResultSet rs2 = st.executeQuery(query2);
	                      System.out.println("USAir Flights: ");
	                      while (rs2.next())
	                      {
	                    	  String flight_id = rs2.getString("flight_id");
	                          String airline_id = rs2.getString("airline_id");
	                          Double businessclass = rs2.getDouble("businessclass");
	                          Double smokingseats = rs2.getDouble("smokingseats");

	                        if(airline_id.equals("USAir")) {
	                        	 // print the results
		                        System.out.format("Flight ID: %s, Airline: %s, ", flight_id, airline_id);
		                        if(businessclass==1) {
		                        	System.out.print("Business Class seats Available, ");
		                        }
		                        else {
		                        	System.out.print("Business Class seats not Available, ");
		                        }
		                        if(smokingseats==1) {
		                        	System.out.print("Smoking seats Available.");
		                        }
		                        else {
		                        	System.out.print("Smoking seats not Available.");
		                        }
		                        System.out.println();
	                        }
	                      }
	                      System.out.println(); 
	                      
	                      
	                      
	                      String query3 = "SELECT * FROM flight"; //BRITAIR
	                      ResultSet rs3 = st.executeQuery(query3);
	                      System.out.println("BritAir Flights: ");
	                      while (rs3.next())
	                      {
	                    	  String flight_id = rs3.getString("flight_id");
	                          String airline_id = rs3.getString("airline_id");
	                          Double businessclass = rs3.getDouble("businessclass");
	                          Double smokingseats = rs3.getDouble("smokingseats");

	                        if(airline_id.equals("BritAir")) {
	                        	 // print the results
		                        System.out.format("Flight ID: %s, Airline: %s, ", flight_id, airline_id);
		                        if(businessclass==1) {
		                        	System.out.print("Business Class seats Available, ");
		                        }
		                        else {
		                        	System.out.print("Business Class seats not Available, ");
		                        }
		                        if(smokingseats==1) {
		                        	System.out.print("Smoking seats Available.");
		                        }
		                        else {
		                        	System.out.print("Smoking seats not Available.");
		                        }
		                        System.out.println();
	                        }
	                      }
	                      System.out.println(); 
	                      
	                      
	                      
	                      
	                      String query4 = "SELECT * FROM flight"; //AIRFRANCE
	                      ResultSet rs4 = st.executeQuery(query4);
	                      System.out.println("AirFrance Flights: ");
	                      while (rs4.next())
	                      {
	                    	  String flight_id = rs4.getString("flight_id");
	                          String airline_id = rs4.getString("airline_id");
	                          Double businessclass = rs4.getDouble("businessclass");
	                          Double smokingseats = rs4.getDouble("smokingseats");

	                        if(airline_id.equals("AirFrance")) {
	                        	 // print the results
		                        System.out.format("Flight ID: %s, Airline: %s, ", flight_id, airline_id);
		                        if(businessclass==1) {
		                        	System.out.print("Business Class seats Available, ");
		                        }
		                        else {
		                        	System.out.print("Business Class seats not Available, ");
		                        }
		                        if(smokingseats==1) {
		                        	System.out.print("Smoking seats Available.");
		                        }
		                        else {
		                        	System.out.print("Smoking seats not Available.");
		                        }
		                        System.out.println();
	                        }
	                      }
	                      System.out.println(); 
	                      
	                      
	                      
	                      
	                      String query5 = "SELECT * FROM flight"; //LUFTAIR
	                      ResultSet rs5 = st.executeQuery(query5);
	                      System.out.println("LuftAir Flights: ");
	                      while (rs5.next())
	                      {
	                    	  String flight_id = rs5.getString("flight_id");
	                          String airline_id = rs5.getString("airline_id");
	                          Double businessclass = rs5.getDouble("businessclass");
	                          Double smokingseats = rs5.getDouble("smokingseats");

	                        if(airline_id.equals("LuftAir")) {
	                        	 // print the results
		                        System.out.format("Flight ID: %s, Airline: %s, ", flight_id, airline_id);
		                        if(businessclass==1) {
		                        	System.out.print("Business Class seats Available, ");
		                        }
		                        else {
		                        	System.out.print("Business Class seats not Available, ");
		                        }
		                        if(smokingseats==1) {
		                        	System.out.print("Smoking seats Available.");
		                        }
		                        else {
		                        	System.out.print("Smoking seats not Available.");
		                        }
		                        System.out.println();
	                        }
	                      }
	                      System.out.println(); 
	                      
	                      
	                      
	                      String query6 = "SELECT * FROM flight"; //ITALAIR
	                      ResultSet rs6 = st.executeQuery(query6);
	                      System.out.println("ItalAir Flights: ");
	                      while (rs6.next())
	                      {
	                    	  String flight_id = rs6.getString("flight_id");
	                          String airline_id = rs6.getString("airline_id");
	                          Double businessclass = rs6.getDouble("businessclass");
	                          Double smokingseats = rs6.getDouble("smokingseats");

	                        if(airline_id.equals("ItalAir")) {
	                        	 // print the results
		                        System.out.format("Flight ID: %s, Airline: %s, ", flight_id, airline_id);
		                        if(businessclass==1) {
		                        	System.out.print("Business Class seats Available, ");
		                        }
		                        else {
		                        	System.out.print("Business Class seats not Available, ");
		                        }
		                        if(smokingseats==1) {
		                        	System.out.print("Smoking seats Available.");
		                        }
		                        else {
		                        	System.out.print("Smoking seats not Available.");
		                        }
		                        System.out.println();
	                        }
	                      }
	                      System.out.println(); 
	                      
	                      
					break;
					case 3:
						String query = "SELECT * FROM availability";
						int C=0;
	                      ResultSet rs = st.executeQuery(query);
	                      while (rs.next())
	                      {
	                    	String FID = rs.getString("flight_id");  
	                        int TBCS = rs.getInt("total_bclass_seats");
	                        int RBCS = rs.getInt("reserved_bclass_seats");
	                        int TECS = rs.getInt("total_eclass_seats");
	                        int RECS = rs.getInt("reserved_eclass_seats");
	                        
	                        // print the results
	                       
	                        if(TBCS==RBCS && TECS==RECS) {
	                        	 System.out.format("Flight with Flight ID %s is full\n",FID);
	                        	 C++;
	                        }
	                      }
	                      if(C==0)
	                    	  System.out.println("No FLights are Full.");
	                      
	                      System.out.println();
					break;
					case 4:
						String flights = "SELECT * FROM availability WHERE arr_airport ='YYZ' AND dep_airport='JFK' ORDER BY flight_id";
						ResultSet RSF = st.executeQuery(flights);
						while(RSF.next()) {
							String FID = RSF.getString("flight_id");
							System.out.format("Flight from NY to Toronto: %s", FID);
							System.out.println();
						}
						
						
						String flights1 = "SELECT * FROM availability WHERE arr_airport ='JFK' AND dep_airport='YYZ' ORDER BY flight_id";
						RSF = st.executeQuery(flights1);
						while(RSF.next()) {
							String FID1 = RSF.getString("flight_id");
							System.out.format("Flight from Toronto to NY: %s", FID1);
							System.out.println();
						}
						System.out.println();
					break;
					case 5:
						System.out.println("Input Flight ID:");
						String I11 = sc.next();
						System.out.println("Input Airline ID:");
						String I21 = sc.next();
						
						String str = "SELECT * FROM availability";
						
						ResultSet RSF2 = st.executeQuery(str);
						
						while(RSF2.next()) {
						String ID = RSF2.getString("flight_id");
						if(I11.equals(ID)) {
						String TBC = RSF2.getString("total_bclass_seats");
						String RBC = RSF2.getString("reserved_bclass_seats");
						String TEC = RSF2.getString("total_eclass_seats");
						String REC = RSF2.getString("reserved_eclass_seats");
						if(TBC==RBC && TEC==REC) {
							System.out.println("There is no availability for the selected Flight ID");
							break;
						}
						}
						
						}
					
						System.out.println("Input Reservation ID:");
						String I13 = sc.next();
						System.out.println("Input City of Reservation:");
						String I221 = sc.next();
						
						java.util.Date dt1 = new java.util.Date();
						java.text.SimpleDateFormat sdf2 =  new java.text.SimpleDateFormat("dd-MM-yyyy");
						String I311 = sdf2.format(dt1);
						
						
						System.out.println("Input Departure Time: (HH-MM-SS)");
						String I51 = sc.next();
						System.out.println("Input Departure Date: (dd-MM-yyyy)");
						String I61 = sc.next();
						System.out.println("Input Arrival Time: (HH-MM-SS)");
						String I71 = sc.next();
						System.out.println("Input Arrival Date: (dd-MM-yyyy)");
						String I81 = sc.next();
						System.out.println("Input Seat Type: (Business/Economy)");
						String I91 = sc.next();
						System.out.println("Input Base Flight Price:");
						double I101 = sc.nextDouble();
						System.out.println("Input the sum that was paid in advance by the customer:");
						double I111 = sc.nextDouble();
						System.out.println("Input the Seat Status: (A/B/C)");
						String I121 = sc.next();
						
						
						String queryR1 = "INSERT INTO reservation VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
						PreparedStatement PSL = conn.prepareStatement(queryR1);
					    PSL.setString(1, I13);
					    PSL.setString(2, I221);
					    PSL.setString(3, I11);
					    PSL.setString(4, I311);
					    PSL.setString(5, I51); 
					    PSL.setString(6, I61);
					    PSL.setString(7, I71);
					    PSL.setString(8, I81);
					    PSL.setString(9, I91);
					    PSL.setDouble(10, 1.0);
					    PSL.setDouble(11, I101);
					    PSL.setDouble(12, I111);
					    PSL.setDouble(13, 1.0);
					    PSL.setString(14, I121);
					    PSL.setString(15, SI);
					    PSL.setString(16, SI);
					    PSL.setString(17, SI);
					    PSL.setString(18, SI);
					    PSL.setString(19, SI);
					    PSL.setDouble(20, 0.0);
					    PSL.executeUpdate(); 
						
					    if(I91.equals("Economy")) {
					    String str1 = "UPDATE availability SET reserved_eclass_seats=?";
					    String str31 = "SELECT * FROM reservation";
					     RSF2 = st.executeQuery(str);
					    while(RSF2.next()){
					    	String ID = RSF2.getString("flight_id");
					    	if(ID.equals(I11)) {
					    		String City1 = RSF2.getString("city_of_reservation");
				    			 String CityQ1 = "SELECT * FROM city";
				    			 
				    			 ResultSet city = st.executeQuery(CityQ1);
				    			 while(city.next()) {
				    				 String CityT = city.getString("name");
				    				 if(City1.equals(CityT)) {
				    					 double tax = city.getDouble("airport_tax");
				    					 ResultSet R = st.executeQuery(str31);
										    while(R.next()) {
										    	ID = R.getString("flight_id");
										    	if(ID.equals(I11)) {
										    	double O = R.getDouble("flight_price");
										    	String str4 = "UPDATE reservation SET price_total=?,remaining=?,airport_tax=?";
										    	double PA1 = R.getDouble("paid_in_advance");
										    	
												double AT = O+O * tax;
												double T = AT+O;
												double R1 = T-PA1;
										    	PreparedStatement UU = conn.prepareStatement(str4);
										    	
										    	UU.setDouble(10,T);
										    	UU.setDouble(12,R1);
										    	UU.setDouble(20, AT);
										    	UU.executeUpdate();
										    	}
										    }
				    				 }
				    			 }
					    			Double M = RSF2.getDouble("reserved_eclass_seats"); 
								    M++;
								    PreparedStatement PP = conn.prepareStatement(str1);
								    PP.setDouble(10,M);
								    PP.executeUpdate();
					    	
					    	
					    	}
					    	else { //Business
						    	String str2 = "UPDATE availability SET reserved_bclass_seats=?";
						    	String str3 = "SELECT * FROM reservation";
						    	 RSF2 = st.executeQuery(str);
						    	while(RSF2.next()) {
						    		 ID = RSF2.getString("flight_id");
						    		 if(ID.equals(I11)) {
						    			 String City = RSF2.getString("city_of_reservation");
						    			 String CityQ = "SELECT * FROM city";
						    			 
						    			 ResultSet city = st.executeQuery(CityQ);
						    			 while(city.next()) {
						    				 String CityT = city.getString("name");
						    				 if(City.equals(CityT)) {
						    					 double tax = city.getDouble("airport_tax");
						    					 ResultSet R = st.executeQuery(str3);
												    while(R.next()) {
												    	ID = R.getString("flight_id");
												    	if(ID.equals(I11)) {
												    	double O = R.getDouble("flight_price");
												    	String str4 = "UPDATE reservation SET price_total=?,remaining=?,airport_tax=?";
												    	O = O*1.5;
												    	double PA = R.getDouble("paid_in_advance");
														double AT =O+ O * tax;
														double T = AT+O;
														double R1 = T-PA;
												    	PreparedStatement UU = conn.prepareStatement(str4);
												    	
												    	UU.setDouble(10,T);
												    	UU.setDouble(12,R1);
												    	UU.setDouble(20, AT);
												    	UU.executeUpdate();
												    	}
												    }
						    				 }
						    			 }
						    			 Double M1 = RSF2.getDouble("reserved_bclass_seats");
						    			 
									    	M1++;
									    	PreparedStatement PP1 = conn.prepareStatement(str2);
									    	PP1.setDouble(8,M1);
										    PP1.executeUpdate();
						    		 }
						    	}
						    	
							    
							    
					    }
					    
					   
					    }
					    
						    
					    }
					    
					break;
					case 6:
						System.out.println("Input Reservation ID to change Seat Status: ");
						String I = sc.next();
						String MOD = "UPDATE reservation SET seat_status = 'A',remaining = 0.0 WHERE reservation_id=?";
						PreparedStatement PS11 = conn.prepareStatement(MOD);
						PS11.setString(1, I);
						PS11.executeUpdate();
						System.out.println("Seat Status Successfully Updated.");
					break;
					case 7:
						System.out.println("Input Airline name:");
						 String I1 = sc.next();
						 String delete = "SELECT * FROM reservation";
						 ResultSet rsd = st.executeQuery(delete);
						
						 while(rsd.next()) {
							
							 String RID = rsd.getString("reservation_id");
							
							 if(I1.contentEquals("USAir")) {
		                            String SQL = "DELETE FROM reservation WHERE seat_status = 'B'";
		                            PreparedStatement PS1 = conn.prepareStatement(SQL);
		                            PS1.executeUpdate();
		                            System.out.format("Reservation with ID: %s has been Deleted.",RID);
		                            System.out.println();
		                        }
		                        else if(I1.contentEquals("AIRCan")){
		                        	String SQL = "DELETE FROM reservation WHERE seat_status = 'B'";
		                            PreparedStatement PS1 = conn.prepareStatement(SQL);
		                            PS1.executeUpdate();
		                            System.out.format("Reservation with ID: %s has been Deleted.",RID);
		                            System.out.println();
		                       
		                        }
		                        else if(I1.contentEquals("BritAir")){
		                        	String SQL = "DELETE FROM reservation WHERE seat_status = 'B'";
		                            PreparedStatement PS1 = conn.prepareStatement(SQL);
		                            PS1.executeUpdate();
		                            System.out.format("Reservation with ID: %s has been Deleted.",RID);
		                            System.out.println();
		                        }
		                        else if(I1.contentEquals("AirFrance")){
		                        	String SQL = "DELETE FROM reservation WHERE seat_status = 'B'";
		                            PreparedStatement PS1 = conn.prepareStatement(SQL);
		                            PS1.executeUpdate();
		                            System.out.format("Reservation with ID: %s has been Deleted.",RID);
		                            System.out.println();
		                        }
		                        else if(I1.contentEquals("LuftAir")){
		                        	String SQL = "DELETE FROM reservation WHERE seat_status = 'B'";
		                            PreparedStatement PS1 = conn.prepareStatement(SQL);
		                            PS1.executeUpdate();
		                            System.out.format("Reservation with ID: %s has been Deleted.",RID);
		                            System.out.println();
		                        }
		                        else if(I1.contentEquals("ItalAir")){
		                        	String SQL = "DELETE FROM reservation WHERE seat_status = 'B'";
		                            PreparedStatement PS1 = conn.prepareStatement(SQL);
		                            PS1.executeUpdate();
		                            System.out.format("Reservation with ID: %s has been Deleted.",RID);
		                            System.out.println();
		                        }
		                        else {
		                        	break;
		                        }
						 }
						break;
					case 0:
						repeat=false;
					break;
					}
					i++;
				}
			}catch(SQLException s){
				System.out.println("SQL statement is not executed!" +s);
			}

			
			

		  
			
			
		

				conn.close();
				sc.close();
				System.out.println("Disconnected from database");
		} 
		}


	


