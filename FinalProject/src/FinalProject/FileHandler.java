package FinalProject;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileHandler 
{
	public void saveCreatures(Set<Creature> creatureList, String filename) 
	{		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
		{
			for (Creature creature : creatureList) 
			{
				writer.write(
					    creature.CreatureID + "," +
					    creature.Name + "," +
					    creature.Age + "," +
					    creature.SexOrGender + "," +
					    creature.Species + "," +
					    creature.CreatureAbility()
					);
				
				writer.newLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public HashSet<Creature> loadCreatures(String filename)
	{
		HashSet<Creature> creatures = new HashSet<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
		{
			String line;
			
			while((line = reader.readLine()) != null) 
			{
				String[] parts = line.split(",");
				
				int CreatureID = 0;
				CreatureID += 1;
				CreatureID = Integer.parseInt(parts[0]);
				String name =  parts[1];
				int age = Integer.parseInt(parts[2]);
				char gender = parts[3].charAt(0);
				String species = parts[4];
				String ability = parts[5];
				int newAbility = 0;
				
				if(species.equals("Dragon")) 
				{
					try 
					{
						newAbility = Integer.parseInt(ability);
					}
					catch(NumberFormatException e)
					{
						System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
						e.printStackTrace();
						System.out.println("\nYour" + species + ", " + name + "'s fire power wasn't able to be converted.");
						System.out.println("\n=======================================");
						
						Scanner scanner = new Scanner(System.in);
						
						switch(gender) 
						{
						case 'F':
							System.out.println("\nDo you want to give her a new value for fire power? \nYour options are: \nYes, or No");
						case 'M':
							System.out.println("\nDo you want to give him a new value for fire power? \nYour options are: \nYes, or No");
						}
						
						String YorN = scanner.nextLine();
						
						switch(YorN) 
						{
							case "Yes":
								System.out.println("What is the numeric fire power value of your " + species + ", " + name + "?");
								try 
								{
									ability = scanner.next();
									newAbility = Integer.parseInt(ability);
								}
								catch(NumberFormatException n)
								{
									System.out.println("=======! ANOTHER EXCEPTION WAS CAUGHT !=======");
									
									n.printStackTrace();
									
									System.out.println("\n============================================\n");
									
									System.out.println("Your input was invalid. Reloading. . .");
									continue;
								}
								
							case "No":
								YorN = scanner.nextLine();
								
								System.out.println("Are you sure you don't want to load your saved creatures?");
								String YorN2 = scanner.nextLine();
								switch(YorN2) 
								{
									case "Yes":
										System.out.println("Returning to main page.");
										break;
										
									case "No":
										System.out.println("Reloading your data. . .");
										continue;
								}
								
						}
						scanner.close();
					}
					creatures.add(new Dragon(CreatureID, name, age, gender, species, newAbility));
					//Name, Age, SexOrGender, Species)
				}
				
				if(species.equals("Phoenix")) 
				{
					try 
					{
						newAbility = Integer.parseInt(ability);
					}
					catch(NumberFormatException e)
					{
						System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======");
						e.printStackTrace();
						System.out.println("\nYour" + species + ", " + name + "'s fire power wasn't able to be converted.");
						System.out.println("\n=======================================");
						
						Scanner scanner = new Scanner(System.in);
						
						switch(gender) 
						{
						case 'F':
							System.out.println("\nDo you want to give her a new value for fire power? \nYour options are: \nYes, or No");
						case 'M':
							System.out.println("\nDo you want to give him a new value for fire power? \nYour options are: \nYes, or No");
						}
						
						String YorN = scanner.nextLine();
						
						switch(YorN) 
						{
							case "Yes":		
								System.out.println("What is the numeric fire power value of your " + species + ", " + name + "?");
								try 
								{
									ability = scanner.next();
									newAbility = Integer.parseInt(ability);
								}
								catch(NumberFormatException n)
								{
									System.out.println("=======! ANOTHER EXCEPTION WAS CAUGHT !=======");
									
									n.printStackTrace();
									
									System.out.println("\n============================================\n");
									
									System.out.println("Your input was invalid. Reloading. . .");
									continue;
								}
								
							case "No":
								YorN = scanner.nextLine();
								
								System.out.println("Are you sure you don't want to load your saved creatures?");
								String YorN2 = scanner.nextLine();
								switch(YorN2) 
								{
									case "Yes":
										System.out.println("Returning to main page.");
										break;
										
									case "No":
										System.out.println("Reloading your data. . .");
										continue;
								}
						}
						scanner.close();
					}					
					creatures.add(new Phoenix(CreatureID, name, age, gender, species, newAbility));
					//Name, Age, SexOrGender, Species)
				}
				
				if(species.equals("Unicorn")) 
				{
					creatures.add(new Unicorn(CreatureID, name, age, gender, species, ability));
				}
			}
		} 
		catch (IOException e) 
		{
			System.out.println("=======! AN EXCEPTION WAS CAUGHT !=======\n");
			e.printStackTrace();
			System.out.println("\n=======================================");
		}
		
		return creatures;
	}
}
