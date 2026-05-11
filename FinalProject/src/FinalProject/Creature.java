package FinalProject;

public abstract class Creature implements Ability{
	protected int CreatureID;
	protected String Name;
	protected String Species;
	protected int Age;
	protected char SexOrGender;
	
	protected Creature(int CreatureID, String Name, int Age, char SexOrGender, String Species) 
	{
		this.CreatureID = CreatureID;
		this.Name = Name;
		this.Age = Age;
		this.SexOrGender = SexOrGender;
		this.Species = Species;
	}
}
