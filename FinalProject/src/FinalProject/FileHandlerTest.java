package FinalProject;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileHandlerTest {
	private Dragon dragon;
	private Phoenix phoenix;
	private Unicorn unicorn;
	
	@BeforeEach
	void setup() 
	{
		dragon = new Dragon(1, "Some", 50, 'M', "Dragon", 85);
		phoenix = new Phoenix(2, "Temporary", 72, 'F', "Phoenix", 85);
		unicorn = new Unicorn(3, "Information", 32, 'M', "Unicorn", "Red");
	}
	
	@Test
	void testFileHandler_SaveCreatures() throws Exception {
	    FileHandler handler = new FileHandler();
	    String filename = "test_save_creatures.txt";

	    Set<Creature> creatures = new HashSet<>();
	    creatures.add(dragon);
	    creatures.add(phoenix);
	    creatures.add(unicorn);

	    handler.saveCreatures(creatures, filename);

	    File file = new File(filename);
	    Assertions.assertTrue(file.exists());
	    Assertions.assertTrue(file.length() > 0);

	    List<String> lines = Files.readAllLines(file.toPath());
	    Assertions.assertEquals(3, lines.size());
	}

	@Test
	void testFileHandler_LoadCreatures() throws Exception {
	    FileHandler handler = new FileHandler();
	    String filename = "test_load_creatures.txt";

	    PrintWriter writer = new PrintWriter(filename);
	    writer.println("1,Some,50,M,Dragon,85");
	    writer.println("2,Temporary,72,F,Phoenix,85");
	    writer.println("3,Information,32,M,Unicorn,Red");
	    writer.close();

	    HashSet<Creature> loaded = handler.loadCreatures(filename);

	    Assertions.assertEquals(3, loaded.size());

	    boolean foundDragon = false;
	    boolean foundPhoenix = false;
	    boolean foundUnicorn = false;

	    for (Creature creature : loaded) {
	        if (creature instanceof Dragon) {
	            foundDragon = true;
	        }
	        if (creature instanceof Phoenix) {
	            foundPhoenix = true;
	        }
	        if (creature instanceof Unicorn) {
	            foundUnicorn = true;
	        }
	    }

	    Assertions.assertTrue(foundDragon);
	    Assertions.assertTrue(foundPhoenix);
	    Assertions.assertTrue(foundUnicorn);
	}
}
