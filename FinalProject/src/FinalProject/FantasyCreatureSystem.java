package FinalProject;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FantasyCreatureSystem 
{
	
	private static int oldCreatureID = 1;

	public static void main(String[] args) 
	{
		System.out.println("====== Fantasy Creature Manager ======\n");
		CreatureManager creatureManager = new CreatureManager();
		FileHandler fileHandler = new FileHandler();
		Scanner scanner = new Scanner(System.in);
		String filename = "creatures.txt";
		
		File file = new File(filename);

		try {
		    if (!file.exists()) {
		        file.createNewFile();
		        System.out.println("Creating to: " + file.getAbsolutePath());
		        System.out.println("Created new creature save file.");
		    }
		} catch (IOException e) {
		    System.out.println("Could not create save file.");
		    e.printStackTrace();
		}
		
	    HashSet<Creature> loadedCreatures = fileHandler.loadCreatures(filename);
	    creatureManager.creaturesList.addAll(loadedCreatures);
		
		System.out.println("Welcome! What would you like to do?");
		int selection = 0;
		boolean userWantsAccess = true;
		boolean waitingForValidOption = true;
		
		while(userWantsAccess) 
		{
			System.out.print("\n");
			creatureManager.displayOptions();
			System.out.print("\nYour Input: ");
			try 
			{
				selection = scanner.nextInt();
			}	
			catch(InputMismatchException e) 
			{
				System.out.println("Please input one of the 8 options.");
				scanner = new Scanner(System.in);
			}
			
			switch(selection) 
			{
				case 1:
					System.out.println("\n===== ADDING A NEW CREATURE =====");
					
					Creature newCreature = makeNewCreature();
					creatureManager.addNewCreature(newCreature);
					break;
				case 2:
					creatureManager.displayAllCreatures();
					
					System.out.println("====== DELETING A CREATURE ======");
					
					while(waitingForValidOption) {
						try 
						{
							System.out.print("\nPick a creature to delete by ID: ");
							int creatureID = scanner.nextInt();
							creatureManager.removeCreature(creatureID);
							waitingForValidOption = false;
						}	
						catch(InputMismatchException e) 
						{
							System.out.println("Please input a valid Creature ID.");
							scanner = new Scanner(System.in);
						}
					}
					break;
				case 3:
					System.out.println("");
					creatureManager.displayCreatureCount();
					creatureManager.displayAllCreatures();
					System.out.println("=================================");
					
					System.out.println("\nReply with [OK] when finished.");
					scanner.next();
					
					break;
				case 4:
					System.out.print("\n");
					creatureManager.displayCreatureCount();
					
					System.out.println("\n======= FILTER BY CRITERIA =======");
					
					System.out.println("\nChoose a criteria to filter by.\n");
					creatureManager.chooseWhatToFilter();
					
					System.out.print("\nYour Input: ");
					
					try 
					{
						selection = scanner.nextInt();
						
							switch(selection) 
							{
								case 1:
									waitingForValidOption = true;
									
									while(waitingForValidOption) 
									{
										try 
										{
											System.out.println("\nEnter in a value for ID: ");
											
											scanner = new Scanner(System.in);
											int ID = scanner.nextInt();
											
											System.out.println("\n== FILTERED BY ID: " + ID + " ==");
											creatureManager.filterByID(ID);
											System.out.println("\n======================================");
											
											waitingForValidOption = false;
										}
										catch (InputMismatchException e)
										{
											System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
											e.printStackTrace();
											System.out.println("\nYour input was invalid. Please provide a valid ID.");
											System.out.println("\n=======================================");
											scanner = new Scanner(System.in);
										}
									}
									
									waitingForValidOption = true;
									break;
								case 2:
									scanner = new Scanner(System.in);
									System.out.print("\nEnter in a name: ");
									String Name = scanner.next();
									
									System.out.println("\n== FILTERED BY NAME: " + Name + " ==");
									creatureManager.filterByName(Name);
									System.out.println("\n======================================");
									break;
								case 3:
									waitingForValidOption = true;
									
									while(waitingForValidOption) 
									{
										try 
										{
											System.out.println("\nEnter an age value: ");
											
											scanner = new Scanner(System.in);
											int Age = scanner.nextInt();
											
											System.out.println("\n== FILTERED BY AGE: " + Age + " ==");
											creatureManager.filterByAge(Age);
											System.out.println("\n======================================");
											
											waitingForValidOption = false;
										}
										catch (InputMismatchException e)
										{
											System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
											e.printStackTrace();
											System.out.println("\nYour input was invalid. Please provide a valid Age.");
											System.out.println("\n=======================================");
											scanner = new Scanner(System.in);
										}
									}
									
									waitingForValidOption = true;
									break;
								case 4:
									System.out.println("\nEnter in a species: ");
									
									scanner = new Scanner(System.in);
									String Species = scanner.next();
									
									System.out.println("\n== FILTERED BY SPECIES: " + Species + " ==");
									creatureManager.filterBySpecies(Species);
									System.out.println("\n======================================");
									break;
								case 5:
									scanner = new Scanner(System.in);
								    char sexOrGender = creatureManager.promptGender(scanner);

								    System.out.println("\n== FILTERED BY Gender/Sex: " + sexOrGender + " ==");
								    creatureManager.filterByGender(sexOrGender);
								    System.out.println("\n======================================");
								    break;
								case 6:
									System.out.println("\nEnter in a value for ability (Numerical / Color): ");
									
									scanner = new Scanner(System.in);
									String Ability = scanner.nextLine();
									
									creatureManager.filterByAbility(Ability);
									break;
								case 7:
									break;
							}
					}	
					catch(InputMismatchException e) 
					{
						System.out.println("Please input one of the 6 options.");
						scanner = new Scanner(System.in);
					}
					
					System.out.println("\nReply with [OK] when finished.");
					scanner.next();
					break;
				case 5:
					System.out.println("");
					creatureManager.chooseWhatStatistics();
					
					waitingForValidOption = true;
					
					while(waitingForValidOption) 
					{
						scanner = new Scanner(System.in);
						try 
						{
							System.out.print("\nYour Input: ");
							int calculateOption = scanner.nextInt();
							System.out.println("");
							switch(calculateOption) 
							{
								case 1:
									creatureManager.getAverageAge();
									System.out.println("\nReply with [OK] when finished.");
									scanner = new Scanner(System.in);
									scanner.next();
									waitingForValidOption = false;
									break;
								case 2:
									creatureManager.getDragonFirePowerAverage();
									creatureManager.getPhoenixFirePowerAverage();
									creatureManager.getUnicornHornColorAverage();
									
									System.out.println("\nReply with [OK] when finished.");
									scanner = new Scanner(System.in);
									scanner.next();
									waitingForValidOption = false;
									break;
								case 3:
									creatureManager.getGenderAverage();
									System.out.println("\nReply with [OK] when finished.");
									scanner = new Scanner(System.in);
									scanner.next();
									waitingForValidOption = false;
									break;
								case 4:
									waitingForValidOption = false;
									break;
							}
						}
						catch(InputMismatchException e)
						{
							System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
							e.printStackTrace();
							System.out.println("\nYour input was invalid. Please provide a valid option.");
							System.out.println("\n=======================================");
							scanner = new Scanner(System.in);
						}
					}
					break;
				case 6:
	                fileHandler.saveCreatures(creatureManager.creaturesList, filename);
			        System.out.println("Saving to: " + file.getAbsolutePath());
	                System.out.println("Creatures saved.");
					break;
				case 7:
					fileHandler.loadCreatures(filename);
			        System.out.println("Loading from: " + file.getAbsolutePath());
					break;
				
				case 8:
					System.out.println("\n====== TERMINATED PROGRAM. ======\n");
	                fileHandler.saveCreatures(creatureManager.creaturesList, filename);
			        System.out.println("Saved to: " + file.getAbsolutePath());
					
					System.out.println("Goodbye!");
					userWantsAccess = false;
					break;
				
				default:
					continue;
			}
		}
	}
	
	private static Creature makeNewCreature() 
	{
		int CreatureID = oldCreatureID++;
		boolean waitingForValidInput = true;
		int Age = 0;
		int SpeciesInput = 0;
		int Ability = 0;
		String Species = "";
		String creatureInnateAbility = "";
		Scanner scanner = new Scanner(System.in);
		char SexOrGender = 0;
		
		System.out.print("\nName your new creature: ");
		String Name = scanner.next();
		
		while (waitingForValidInput) 
		{
			try 
			{
				System.out.print("\nHow old is " + Name + " in Earth years? ");
				Age = scanner.nextInt();
				waitingForValidInput = false;
			}
			catch (InputMismatchException e) 
			{
				System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
				e.printStackTrace();
				System.out.println("\nYour input was invalid. Please provide a valid Age.");
				System.out.println("\n=======================================");
				scanner = new Scanner(System.in);
			}
		}
		
		waitingForValidInput = true;
		
		while (waitingForValidInput) 
		{	
			scanner = new Scanner(System.in);
			CreatureManager creatureManager = new CreatureManager();
			System.out.println("");
			SexOrGender = creatureManager.promptGender(scanner);
			
			switch(SexOrGender) 
			{
			case 'F':
				System.out.println("Your new creature, " + Name + " is a woman.");
				waitingForValidInput = false;
				break;
				
			case 'M':
				System.out.println("Your new creature, " + Name + " is a man.");
				waitingForValidInput = false;
				break;
				
			default:
		        System.out.println("Invalid gender. Try again.\n");
		        waitingForValidInput = true;
			}
		}
		waitingForValidInput = true;
		
		while(waitingForValidInput) 
		{
			System.out.println("\nWhat species would " + Name + " be listed under?");
			
			System.out.println("======= OPTIONS AVAILABLE =======");
			System.out.println("1. Dragon");
			System.out.println("2. Phoenix");
			System.out.println("3. Unicorn");
			System.out.println("4. Homebrew / Custom / Other (NOT ADDED YET)");
			System.out.println("==================================");
			
			try 
			{
				System.out.print("Your option: ");
				SpeciesInput = scanner.nextInt();
				System.out.println("");	
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please pick a numerical option, 1 through 4.");
			}
			
			switch(SpeciesInput) 
			{
				case 1:
					Species = "Dragon";
					switch(SexOrGender) 
					{
						case 'M':
							System.out.println("Since " + Name + " is a " + Species + ", his ability will be: Fire.");
							break;
						case 'F':
							System.out.println("Since " + Name + " is a " + Species + ", her ability will be: Fire.");
							break;
					}
					waitingForValidInput = false;
					scanner = new Scanner(System.in);
					break;
					
				case 2:
					Species = "Phoenix";
					switch(SexOrGender) 
					{
						case 'M':
							System.out.println("Since " + Name + " is a " + Species + ", his ability will be: Fire.");
							break;
						case 'F':
							System.out.println("Since " + Name + " is a " + Species + ", her ability will be: Fire.");
							break;
					}
					waitingForValidInput = false;
					scanner = new Scanner(System.in);
					break;
					
				case 3:
					Species = "Unicorn";
					switch(SexOrGender) 
					{
						case 'M':
							System.out.println("Since " + Name + " is a " + Species + ", his ability is his Horn.");
							break;
						case 'F':
							System.out.println("Since " + Name + " is a " + Species + ", her ability is her Horn.");
							break;
					}
					waitingForValidInput = false;
					scanner = new Scanner(System.in);
					break;
					
				case 4:
					System.out.println("\n\nThis hasn't been implemented just yet. Check back later!");
					scanner = new Scanner(System.in);
					break;
				
				default:
					System.out.println("Your input was invalid.");
					scanner = new Scanner(System.in);
					break;
			}
		}	
		
		switch(Species) 
		{
			case "Dragon":
				waitingForValidInput = true;
				
				while (waitingForValidInput) 
				{
					System.out.print("Enter a powerscaling numerical value for " + Name + "'s Fire Power: ");
					creatureInnateAbility = scanner.next();
					
					try
					{
						Ability = Integer.parseInt(creatureInnateAbility);
						
						System.out.print("\n====! SAYING NO WILL SEND YOU BACK TO THE MAIN MENU WITH DATA LOSS !====\n");
						System.out.println("\nAre these details correct?\n");
						System.out.print("====! SAYING NO WILL SEND YOU BACK TO THE MAIN MENU WITH DATA LOSS !====\n");
						
						Creature newCreature = new Dragon(CreatureID, Name, Age, SexOrGender, Species, Ability);
						System.out.println(newCreature.toString());
						
						scanner = new Scanner(System.in);
						System.out.println("\n============================= YOUR INPUT =============================\n");
						
						CreatureManager creatureManager = new CreatureManager();
						String YesOrNo = creatureManager.promptYesOrNo(scanner);

						switch (YesOrNo) {
						    case "Yes":
						        System.out.println("\nSuccessfully created: " + Name);
						        return newCreature;

						    case "No":
						        creatureManager.removeCreature(CreatureID);
						        System.out.println("\nSuccessfully stopped the creation of: " + Name);
						        return null;
						}
					}
					catch (InputMismatchException e) 
					{
						System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
						e.printStackTrace();
						System.out.println("\nYour input was invalid. Please provide a valid numerical power value.");
						System.out.println("\n=======================================");
						scanner = new Scanner(System.in);
						continue;
					}
					break;
				}
				
			case "Phoenix":
				waitingForValidInput = true;
				
				while (waitingForValidInput) 
				{
					System.out.print("Enter a powerscaling numerical value for " + Name + "'s Fire Power: ");
					creatureInnateAbility = scanner.next();
					
					try
					{
						Ability = Integer.parseInt(creatureInnateAbility);
						
						System.out.print("\n====! SAYING NO WILL SEND YOU BACK TO THE MAIN MENU WITH DATA LOSS !====\n");
						System.out.println("\nAre these details correct?\n");
						System.out.print("====! SAYING NO WILL SEND YOU BACK TO THE MAIN MENU WITH DATA LOSS !====\n");
						
						Creature newCreature = new Phoenix(CreatureID, Name, Age, SexOrGender, Species, Ability);
						System.out.print(newCreature.toString());
						
						scanner = new Scanner(System.in);
						System.out.println("\n============================= YOUR INPUT =============================\n");
						
						CreatureManager creatureManager = new CreatureManager();
						String YesOrNo = creatureManager.promptYesOrNo(scanner);

						switch (YesOrNo) {
						    case "Yes":
						        System.out.println("\nSuccessfully created: " + Name);
						        return newCreature;

						    case "No":
						        creatureManager.removeCreature(CreatureID);
						        System.out.println("\nSuccessfully stopped the creation of: " + Name);
						        return null;
						}
					}
					catch (InputMismatchException e) 
					{
						System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
						e.printStackTrace();
						System.out.println("\nYour input was invalid. Please provide a valid numerical power value.");
						System.out.println("\n=======================================");
						scanner = new Scanner(System.in);
						continue;
					}
					break;
				}
			case "Unicorn":
				waitingForValidInput = true;
				
				while (waitingForValidInput) 
				{
					System.out.print("Enter a color for " + Name + "'s Horn: ");
					
					try
					{	
						creatureInnateAbility = scanner.next();
					}
					catch (InputMismatchException e) 
					{
						System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
						e.printStackTrace();
						System.out.println("\nYour input was invalid. Please provide a valid color.");
						System.out.println("\n=======================================");
						scanner = new Scanner(System.in);
						continue;
					}
					
					System.out.print("\n====! SAYING NO WILL SEND YOU BACK TO THE MAIN MENU WITH DATA LOSS !====\n");
					System.out.println("\nAre these details correct?\n");
					System.out.print("====! SAYING NO WILL SEND YOU BACK TO THE MAIN MENU WITH DATA LOSS !====\n");
					
					Creature newCreature = new Unicorn(CreatureID, Name, Age, SexOrGender, Species, creatureInnateAbility);
					System.out.println(newCreature.toString());
					
					System.out.println("\n============================= YOUR INPUT =============================");

					scanner = new Scanner(System.in);
					CreatureManager creatureManager = new CreatureManager();
					String YesOrNo = creatureManager.promptYesOrNo(scanner);

					switch (YesOrNo) {
					    case "Yes":
					        System.out.println("\nSuccessfully created: " + Name);
					        return newCreature;

					    case "No":
					        creatureManager.removeCreature(CreatureID);
					        System.out.println("\nSuccessfully stopped the creation of: " + Name);
					        return null;
					}
				}
		}
		
		return null;
		
	}
}
