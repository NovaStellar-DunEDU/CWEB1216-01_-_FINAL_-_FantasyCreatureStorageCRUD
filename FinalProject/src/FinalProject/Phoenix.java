package FinalProject;

public class Phoenix extends Creature implements Ability{
	private int Ability;
	
	protected Phoenix(int CreatureID, String Name, int Age, char SexOrGender, String Species, int Ability)
	{
		super(CreatureID, Name, Age, SexOrGender, Species);
		this.Ability = Ability;
	}
	
	@Override
	public String CreatureAbility() 
	{
		return Integer.toString(Ability);
	} 
	
	@Override
	public int Ability() 
	{
		return Ability;
	} 
	
	@Override
	public String toString() 
	{
		String PhoenixAsString = "";
		PhoenixAsString += "\nCreatureID: " + CreatureID + "\nName: " + Name + "\n" + "Age: " + Age + "\n" + "Sex/Gender: " + SexOrGender + "\n" + "Species: " + Species + "\n" + "Fire Power: " + CreatureAbility();
		return PhoenixAsString;
	}
}
