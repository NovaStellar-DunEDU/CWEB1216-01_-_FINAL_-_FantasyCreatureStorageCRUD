package FinalProject;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreatureManagerTest {

	private CreatureManager creatureManager;
	private Dragon dragon;
	private Phoenix phoenix;
	private Unicorn unicorn;
	
	// variables usable across every test
	
	@BeforeEach
	void setup() 
	{
		creatureManager = new CreatureManager();
		dragon = new Dragon(1, "Some", 50, 'M', "Dragon", 85);
		phoenix = new Phoenix(2, "Temporary", 72, 'F', "Phoenix", 85);
		unicorn = new Unicorn(3, "Information", 32, 'M', "Unicorn", "Red");
	}
	
	// testing to adding a new creature
	
    @Test
    void testAddNewCreature() {
        creatureManager.addNewCreature(dragon);
        Assertions.assertTrue(creatureManager.creaturesList.contains(dragon));
        Assertions.assertEquals(1, creatureManager.creaturesList.size());
    }
    
    // tests for duplicates in the adding process
    
    @Test
    void testAddNewCreature_NoDuplicates() {
        creatureManager.addNewCreature(dragon);
        creatureManager.addNewCreature(dragon);
        Assertions.assertEquals(1, creatureManager.creaturesList.size());
    }
	
    // tests for removal
    
    @Test
    void testRemoveCreature_DeleteOne() {
        CreatureManager manager = new CreatureManager();

        Dragon dragon1 = new Dragon(1, "Draco", 50, 'M', "Dragon", 80);
        Dragon dragon2 = new Dragon(2, "Inferno", 60, 'M', "Dragon", 100);

        manager.addNewCreature(dragon1);
        manager.addNewCreature(dragon2);

        boolean removed = manager.removeCreature(2);

        Assertions.assertTrue(removed);
        Assertions.assertFalse(manager.creaturesList.contains(dragon2));
        Assertions.assertTrue(manager.creaturesList.contains(dragon1));
    }
    
    
    // testing to look up a creature by ID, returns a dragon
    
    @Test
    void testID_Found() {
        creatureManager = new CreatureManager();
        creatureManager.addNewCreature(dragon);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Set<Creature> result = creatureManager.filterByID(1);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(dragon));

        String output = out.toString().trim();
        String expected = dragon.toString().trim();

        Assertions.assertTrue(output.contains(expected));
    }
    
    // testing to look up a creature by ID, but returns nothing
    
    @Test
    void testID_NotFound() 
    {
    	Set<Creature> result = creatureManager.filterByID(1);
    	Assertions.assertTrue(result.isEmpty());
    }
    
    
    // testing to look up a creature by name, returns a dragon
    
    @Test
    void testName_Found() {
        creatureManager = new CreatureManager();
        creatureManager.addNewCreature(dragon);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Set<Creature> result = creatureManager.filterByName("Some");

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(dragon));

        String output = out.toString().trim();
        String expected = dragon.toString().trim();

        Assertions.assertTrue(output.contains(expected));
    }
    
    // testing to look up a creature, but returns nothing
    
    @Test
    void testName_NotFound() 
    {
    	Set<Creature> result = creatureManager.filterByName("Some");
    	Assertions.assertTrue(result.isEmpty());
    }
    
    // testing to look up a creature by AGE, returns a dragon
    
    @Test
    void testAge_Found() {
        creatureManager = new CreatureManager();
        creatureManager.addNewCreature(dragon);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Set<Creature> result = creatureManager.filterByAge(50);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(dragon));

        String output = out.toString().trim();
        String expected = dragon.toString().trim();

        Assertions.assertTrue(output.contains(expected));
    }
    
    // testing to look up a creature by AGE, but returns nothing
    
    @Test
    void testAge_NotFound() 
    {
    	Set<Creature> result = creatureManager.filterByAge(50);
    	Assertions.assertTrue(result.isEmpty());
    }
    
    // testing to look up a creature by GENDER, returns a dragon
    
    @Test
    void testGender_Found() {
        creatureManager = new CreatureManager();
        creatureManager.addNewCreature(dragon);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Set<Creature> result = creatureManager.filterByGender('M');

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(dragon));

        String output = out.toString().trim();
        String expected = dragon.toString().trim();

        Assertions.assertTrue(output.contains(expected));
    }
    
    // testing to look up a creature by GENDER, but returns nothing
    
    @Test
    void testGender_NotFound() 
    {
    	Set<Creature> result = creatureManager.filterByGender('M');
    	Assertions.assertTrue(result.isEmpty());
    }
    
    // testing to look up a creature by ABILITY
    // returns 2 creatures, a dragon and a phoenix
    
    @Test
    void testFilterByAbility_Found() {
        creatureManager.addNewCreature(dragon);
        creatureManager.addNewCreature(phoenix);
        creatureManager.addNewCreature(unicorn);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Set<Creature> result = creatureManager.filterByAbility("85");

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(dragon));
        Assertions.assertTrue(result.contains(phoenix));

        String output = out.toString().trim();
        Assertions.assertTrue(output.contains(dragon.toString().trim()));
        Assertions.assertTrue(output.contains(phoenix.toString().trim()));
        Assertions.assertFalse(output.contains(unicorn.toString().trim()));
    }

    // testing to look up a creature by Ability
    // returns empty
    
    @Test
    void testFilterByAbility_NotFound() {
        creatureManager.addNewCreature(dragon);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Set<Creature> result = creatureManager.filterByAbility("999");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());

        String output = out.toString().trim();
        Assertions.assertTrue(output.isEmpty());
    }
    
    // testing to display all creatures correctly 
    
    @Test
    void testDisplay_PrintsCorrectly() {
        creatureManager.addNewCreature(dragon);
        creatureManager.addNewCreature(phoenix);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        creatureManager.displayAllCreatures();

        String output = out.toString();
        Assertions.assertTrue(output.contains("Some"));
        Assertions.assertTrue(output.contains("Temporary"));
    }
    
    // checking if the average fire power for dragons is the exact amount
    // 85 + 95 = 180/2 = 90.0
    
    @Test
    void testDragon_FirePowerAverage() 
    {
    	Dragon dragon2 = new Dragon(4, "Thing", 60, 'M', "Dragon", 95);

        creatureManager.addNewCreature(dragon);
        creatureManager.addNewCreature(dragon2);

        double avg = creatureManager.setDragonFirePowerAverage();
        Assertions.assertEquals(90.0, avg);
    }
    
    // same here
    // 93 + 85 = 188/2 = 89.0
    
    @Test
    void testPhoenix_FirePowerAverage() 
    {
    	Phoenix phoenix2 = new Phoenix(4, "Thing", 65, 'M', "Phoenix", 93);

        creatureManager.addNewCreature(phoenix);
        creatureManager.addNewCreature(phoenix2);

        double avg = creatureManager.setPhoenixFirePowerAverage();
        Assertions.assertEquals(89.0, avg);
    }
    
    //checks for the most frequent horn colors
    // 2 red, 1 purple, 1 blue
    // red is the most frequent
    
    @Test
    void testUnicornHornColorAverage() {
        Unicorn unicorn1 = new Unicorn(2, "Thing", 20, 'F', "Unicorn", "Purple");
        Unicorn unicorn2 = new Unicorn(3, "Else", 22, 'F', "Unicorn", "Red");
        Unicorn unicorn3 = new Unicorn(4, "Here", 18, 'M', "Unicorn", "Blue");

        creatureManager.addNewCreature(unicorn);
        creatureManager.addNewCreature(unicorn1);
        creatureManager.addNewCreature(unicorn2);
        creatureManager.addNewCreature(unicorn3);

        String result = creatureManager.setUnicornHornColorAverage();

        Assertions.assertEquals("Red", result);
    }
}

