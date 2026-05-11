package FinalProject;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class CreatureManager {
	Set<Creature> creaturesList = new HashSet<>();
	
	// Filtering by specified Species
	
	public Set<Creature> filterBySpecies(String Species) {
		HashSet<Creature> result = new HashSet<>();
		
		for (Creature creature : creaturesList) 
		{
			if(creature.Species.equals(Species)) 
			{
				result.add(creature);
			}
		}
		
		if (!result.isEmpty()) {
		    for (Creature creature : result) {
		        System.out.println(creature.toString());
		        System.out.println();
		    }
		}
		
		return result;
	}
	
	// Filtering by specified Ability
	
	public Set<Creature> filterByAbility(String Ability) {
	    HashSet<Creature> result = new HashSet<>();

	    for (Creature creature : creaturesList) {

	        // If FirePower Type Creature (Dragons and Phoenixes)
	        if (String.valueOf(creature.Ability()).equals(Ability)) {
	            result.add(creature);
	            continue;
	        }

	        // If Color Type Creature (Unicorns)
	        if (creature.CreatureAbility().equals(Ability)) {
	            result.add(creature);
	        }
	    }

	    if (!result.isEmpty()) {
	        for (Creature creature : result) {
	            System.out.println(creature.toString());
	            System.out.println();
	        }
	    }

	    return result;
	}

	
	// Filtering by specified Gender or Sex
	
	public Set<Creature> filterByGender(char SexOrGender) {
		HashSet<Creature> result = new HashSet<>();
		
		for (Creature creature : creaturesList) 
		{
			if(creature.SexOrGender == SexOrGender) 
			{
				result.add(creature);
			}
		}
		
		if (!result.isEmpty()) {
		    for (Creature creature : result) {
		        System.out.println(creature.toString());
		        System.out.println();
		    }
		}
		
		return result;
	}
	
	// Filtering by specified Age
	
	public Set<Creature> filterByAge(int Age) {
		HashSet<Creature> result = new HashSet<>();
		
		for (Creature creature : creaturesList) 
		{
			if(creature.Age == Age) 
			{
				result.add(creature);
			}
		}
		
		if (!result.isEmpty()) {
		    for (Creature creature : result) {
		        System.out.println(creature.toString());
		        System.out.println();
		    }
		}
		
		return result;
	}
	
	// Filtering by specified ID
	
	public Set<Creature> filterByID(int ID) {
		HashSet<Creature> result = new HashSet<>();
		
		for (Creature creature : creaturesList) 
		{
			if(creature.CreatureID == ID) 
			{
				result.add(creature);
			}
		}
		
		if (!result.isEmpty()) {
		    for (Creature creature : result) {
		        System.out.println(creature.toString());
		        System.out.println();
		    }
		}
		
		return result;
	}
	
	// Filtering by specified Name
	
	public Set<Creature> filterByName(String Name) {
		HashSet<Creature> result = new HashSet<>();
		
		for (Creature creature : creaturesList) 
		{
			if(creature.Name.equals(Name)) 
			{
				result.add(creature);
			}
		}

		if (!result.isEmpty()) {
		    for (Creature creature : result) {
		        System.out.println(creature.toString());
		        System.out.println();
		    }
		}
		
		return result;
	}
	
	// Creating a new creature
	
	public void addNewCreature(Creature newCreature) 
	{
	    if (newCreature != null) {
	        creaturesList.add(newCreature);
	    }
	}
	
	// Removing a creature by ID
	
	public Boolean removeCreature(int CreatureID) 
	{	
		for(Creature creature : creaturesList) 
		{
			if (creature.CreatureID == CreatureID) 
			{
				System.out.println("Deletion of ID#" + CreatureID + " was successful.");
				creaturesList.remove(creature);
				return true;
			}
		}
		System.out.println("No such ID Exists. Nothing was deleted.");
		return false;
	}
	
	// Displaying how many creatures were created
	
	public void displayCreatureCount() 
	{
		System.out.println("==== Amount of Creatures Added ====\n");
		
		if(creaturesList.size() == 1) 
		{
			System.out.println("There is only " + creaturesList.size() + " creature that has been logged.");
			// only 1 creature
		}
		else if(creaturesList.size() <= 0) 
		{
			System.out.println("There are no creatures found. \nAdd a creature first.");
			// 0 or less creatures found
		}
		else 
		{
			System.out.println("There are " + creaturesList.size() + " creatures that has been logged.");
			// multiple creatures
		}
	}
	
	// Displaying ALL the information from each and every creature created
	
	public void displayAllCreatures() 
	{
		System.out.println("\n== All Creature Info Displayed ==");
		
		for(Creature Creature : creaturesList) 
		{
			System.out.println(Creature.toString());
			System.out.println("");
		}
		
		if(creaturesList.size() <= 0) {
			System.out.println("Empty");
		}
	}
	
	public void displayOptions() 
	{
		System.out.println("======= OPTIONS AVAILABLE =======");
		System.out.println("1. Add a Creature");
		System.out.println("2. Remove a Creature");
		System.out.println("3. Display all Creatures");
		System.out.println("4. Filter by Criteria");
		System.out.println("5. Show Statistics");
		System.out.println("6. Save Data");
		System.out.println("7. Load Data");
		System.out.println("8. Exit");
		System.out.println("=========== YOUR INPUT ==========");
	}
	
	public void chooseWhatToFilter()
	{
		System.out.println("======= OPTIONS AVAILABLE =======");
		System.out.println("1. Creature ID");
		System.out.println("2. Name");
		System.out.println("3. Age");
		System.out.println("4. Species");
		System.out.println("5. Gender or Sex");
		System.out.println("6. Ability");
		System.out.println("7. Return to Main Menu");
		System.out.println("=========== YOUR INPUT ==========");
	}
	
	public void chooseWhatStatistics() 
	{
		System.out.println("======= OPTIONS AVAILABLE =======");
		System.out.println("1. Calculate the Most Common Age");
		System.out.println("2. Calculate the Most Common Abilities");
		System.out.println("3. Calculate Most Common Gender");
		System.out.println("4. Return to Main Menu");
		System.out.println("=========== YOUR INPUT ==========");
	}
	
	public char parseGender(String GenderInput) {
	    if (GenderInput == null) return 0;

	    String g = GenderInput.trim().toLowerCase();

	    if (g.equals("m") || g.equals("male") || g.equals("boy") ||
	        g.equals("man") || g.equals("he")) 
	    {
	        return 'M';
	    }

	    if (g.equals("f") || g.equals("female") || g.equals("girl") ||
	        g.equals("woman") || g.equals("she")) 
	    {
	        return 'F';
	    }

	    return 0; // invalid gender
	}

	public char promptGender(Scanner scanner) {
	    while (true) {
	        System.out.println("Is your creature Male(M) or Female(F)?");
	        System.out.println("[!] Gender or Sex is indicated with a single letter [!]");
	        System.out.println("[!] Multiple forms of writing is accepted [!]");
	        System.out.print("\nYour input: ");

	        String input = scanner.nextLine();
	        char g = parseGender(input);

	        if (g == 'M' || g == 'F') {
	            return g;
	        }

	        System.out.println("Invalid gender. Try again.\n");
	    }
	}
	
	public String promptYesOrNo(Scanner scanner) {
	    while (true) {
	        System.out.print("Yes or No: ");
	        String input = scanner.nextLine().trim().toLowerCase();

	        if (input.equals("yes") || input.equals("y")) {
	            return "Yes";
	        }

	        if (input.equals("no") || input.equals("n")) {
	            return "No";
	        }

	        System.out.println("Invalid input. Try again.\n");
	    }
	}
	
	public void getAverageAge() 
	{
		int totalAge = 0;
		int creatureCount = 0;
		double average = 0.0;
		
		for(Creature creature : creaturesList) 
		{
			totalAge = totalAge + creature.Age;
			creatureCount = creatureCount + 1;
		}
		
		if(creatureCount == 0) 
		{
			System.out.println("No Creatures Found.");
		}
		
		average = totalAge / creatureCount;
		
		System.out.println("======= SEPERATE AGES =======\n");
		
		 for(Creature creature : creaturesList) 
		 {
			 System.out.println(creature.Name + ": " + creature.Age + " years");
		 }  
		 
		System.out.println("\n======= AVERAGE AGE =======");
		System.out.println("\nTotal Creatures: " + creatureCount);
		System.out.println("Combined Age: " + totalAge);
		System.out.println("Average Age: " + average);
		System.out.println("\n===========================");
	}

	public double setDragonFirePowerAverage() 
	{
		double totalFirePower = 0.0;
		int dragonCount = 0;
		double dragonFirePowerAverage = 0.0;
		
		for(Creature creature : creaturesList) 
		{
			if(creature.Species.equals("Dragon"))
			{	
				totalFirePower = totalFirePower +  creature.Ability();
				dragonCount = dragonCount + 1;
			}
		}
		
		return dragonFirePowerAverage = totalFirePower / dragonCount;
	}
	
	public void getDragonFirePowerAverage() 
	{
		int dragonCount = 0;
		
		for(Creature creature : creaturesList) 
		{
			if(creature.Species.equals("Dragon"))
			{	
				dragonCount = dragonCount + 1;
			}
		}
		
		if(dragonCount == 0) 
		{
			System.out.println("No dragons found.");
		}
		
		setDragonFirePowerAverage();
		
		System.out.println("========= SEPERATE FIRE POWER VALUES =========");
		
		 for(Creature creature : creaturesList) 
		 {
			 if(creature.Species.equals("Dragon"))
			 {
				 System.out.println(creature.Name + ": " + creature.Ability() + " Fire Power");
			 }
		 }  
		
	    System.out.println("======= AVERAGE FIRE POWER FOR DRAGONS =======");
	    System.out.println("\nTotal Dragons: " + dragonCount);
	    System.out.println("Average Fire Power: " + setDragonFirePowerAverage());
	    System.out.println("\n==============================================");
	}
	
	public String setUnicornHornColorAverage() {
	    Set<String> hornColors = new HashSet<>();

	    for (Creature creature : creaturesList) {
	        if (creature.Species.equals("Unicorn")) {
	            String hornColor = creature.CreatureAbility();
	            hornColors.add(hornColor);
	        }
	    }

	    if (hornColors.isEmpty()) {
	        return null;
	    }

	    String mostCommonColor = "";
	    int highestCount = 0;

	    for (String hornColor : hornColors) {
	        int count = 0;

	        for (Creature creature : creaturesList) {
	            if (creature.Species.equals("Unicorn") &&
	                creature.CreatureAbility().equals(hornColor)) {
	                count++;
	            }
	        }

	        if (count > highestCount) {
	            highestCount = count;
	            mostCommonColor = hornColor;
	        }
	    }

	    return mostCommonColor;
	}

	public void getUnicornHornColorAverage() {
	    Set<String> hornColors = new HashSet<>();

	    for (Creature creature : creaturesList) {
	        if (creature.Species.equals("Unicorn")) {
	            String hornColor = creature.CreatureAbility();
	            hornColors.add(hornColor);
	        }
	    }

	    if (hornColors.isEmpty()) {
	        System.out.println("No unicorns found.");
	        return;
	    }

	    String mostCommonColor = setUnicornHornColorAverage();
	    int highestCount = 0;

	    for (Creature creature : creaturesList) {
	        if (creature.Species.equals("Unicorn") &&
	            creature.CreatureAbility().equals(mostCommonColor)) {
	            highestCount++;
	        }
	    }

	    System.out.println("============ SEPERATE COLOR VALUES ============");

	    for (Creature creature : creaturesList) {
	        if (creature.Species.equals("Unicorn")) {
	            System.out.println(creature.Name + ": " + creature.CreatureAbility() + " Horn");
	        }
	    }

	    System.out.println("========= MOST COMMON UNICORN HORN COLOR =======");
	    System.out.println("\nColor: " + mostCommonColor);
	    System.out.println("Count: " + highestCount);
	    System.out.println("\n================================================");
	}

	
	public double setPhoenixFirePowerAverage() 
	{
		double totalFirePower = 0.0;
		int phoenixCount = 0;
		double phoenixFirePowerAverage = 0.0;
		
		for(Creature creature : creaturesList) 
		{
			if(creature.Species.equals("Phoenix"))
			{	
				totalFirePower = totalFirePower +  creature.Ability();
				phoenixCount = phoenixCount + 1;
			}
		}
		
		return phoenixFirePowerAverage = totalFirePower / phoenixCount;
	}
	
	public void getPhoenixFirePowerAverage() 
	{
		int phoenixCount = 0;
		
		for(Creature creature : creaturesList) 
		{
			if(creature.Species.equals("Phoenix"))
			{	
				phoenixCount = phoenixCount + 1;
			}
		}
		
		if(phoenixCount == 0) 
		{
			System.out.println("No dragons found.");
		}
		
		setPhoenixFirePowerAverage();
		
		System.out.println("========= SEPERATE FIRE POWER VALUES =========");
		
		 for(Creature creature : creaturesList) 
		 {
			 if(creature.Species.equals("Unicorn"))
			 {
				 System.out.println(creature.Name + ": " + creature.Ability() + " Fire Power");
			 }		 
		 }  
		
	    System.out.println("====== AVERAGE FIRE POWER FOR PHOENIXES =======");
	    System.out.println("\nTotal Phoenixes: " + phoenixCount);
	    System.out.println("Average Fire Power: " + setPhoenixFirePowerAverage());
	    System.out.println("\n===============================================");
	}
	
	public void getGenderAverage() {
		double maleCreatureCount = 0;
		double femaleCreatureCount = 0;
		double totalCount = 0;
		
		for(Creature creature : creaturesList) {
			if(creature.SexOrGender == 'M') 
			{
				maleCreatureCount = maleCreatureCount + 1;
			}
			else if(creature.SexOrGender == 'F') 
			{
				femaleCreatureCount = femaleCreatureCount + 1;
			}
			totalCount = totalCount + 1;
		}
		
		if(totalCount == 0) 
		{
			System.out.println("No creatures found.");
		}
		
		double malePercent = (maleCreatureCount / totalCount) * 100;
		double femalePercent = (femaleCreatureCount / totalCount) * 100;
		
		String maleFormatted = String.format("%.2f", malePercent);
		String femaleFormatted = String.format("%.2f", femalePercent);
		
	    System.out.println("======= AVERAGE GENDER =======");
	    System.out.println("\nTotal Creatures: " + totalCount);
	    System.out.println("How many Males: " + maleCreatureCount + " (" + maleFormatted + "%)");
	    System.out.println("How many Females: " + femaleCreatureCount + " (" + femaleFormatted + "%)");
	    System.out.println("\n==============================");
	}
}
