package ListProject;
import LinearDataStructures.Node;

public class Student implements Node {
	
	//Data Structure
	String name = null;
	String surname = null;
	String id = null;
	int age = 0;
	String program = null;
	double average_grades = 0.0;
	Student next = null;
	
	public Student(String id)
	{
		this.id = id;
	}
	
	public Student(String name, String surname, String id, int age, String program)
	{
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.age = age;
		this.program = program;
	}
	
	public Student(String name, String surname, String id, int age, String program, double average_grades)
	{
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.age = age;
		this.program = program;
		this.average_grades = average_grades;
	}
	
	@Override
	public void setNext(Node node) 
	{
		next = (Student)node; 
	}
	
	@Override
	public Node getNext() 
	{
		return next;
	}
	
	@Override
	public Node clone() 
	{
		Student clone = new Student(name, surname, id, age, program, average_grades);
		return clone;
	}
	
	@Override
	public boolean isEqual(Node node) 
	{
		Student temp = (Student)node;
		if(this.id.equals( temp.id ))
			return true;
			
		return false;
	}
	
	@Override
	public boolean isLessThan(Node node) 
	{
		Student temp = (Student)node;
		if(this.age < temp.age)
			return true;
		
		return false;
	}
	
	@Override
	public String toString()
	{
		return "Nombre: " + this.name + "\tApellidos: " + this.surname 
				+ "\tID: " + this.id + "\tPrograma: " + this.program + "\n";
	}
}