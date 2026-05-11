package FinalProject;

public class Unicorn extends Creature implements Ability{
	private String Ability;
	
	protected Unicorn(int CreatureID, String Name, int Age, char SexOrGender, String Species, String Ability)
	{
		super(CreatureID, Name, Age, SexOrGender, Species);
		this.Ability = Ability;
	}
	
	@Override
	public String CreatureAbility() 
	{
		return Ability;
	} 
	
	@Override
	public int Ability() 
	{
		return 0;
	} 
	
	@Override
	public String toString() 
	{
		String UnicornAsString = "";
		UnicornAsString += "\nCreatureID: " + CreatureID + "\nName: " + Name + "\n" + "Age: " + Age + "\n" + "Sex/Gender: " + SexOrGender + "\n" + "Species: " + Species + "\n" + "Horn Color: " + CreatureAbility();
		return UnicornAsString;
	}
}

