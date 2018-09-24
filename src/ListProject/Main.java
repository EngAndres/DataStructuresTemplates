package ListProject;
import LinearDataStructures.*;
import java.io.*;

public class Main {

	public static List students = new List();
	public static Queue requests = new Queue();
	public static Stack reports = new Stack();
	
	static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
	static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	
	
	public static String menu()
	{
		String menu = "\nBienvenido al software para estudiantes.\nSeleccione alguna"
				+ " de las siguientes opciones:\n1) Agregar estudiante"
				+ "\n2) Eliminar estudiante\n3) Asignar nota\n4) Solicitud de estudiante"
				+ "\n5) Entregar boletines \n6) Salir\n";
		return menu;
	}
	
	public static void insert_student()
	{
		//String name, String surname, String id, int age, String program
		try
		{
			bw.write("A continuacion diligencie la informacion del estudiante.\nNombres: ");
			bw.flush();
			String name = br.readLine();
			
			bw.write("Apellidos: ");
			bw.flush();
			String surname = br.readLine();
			
			bw.write("ID: ");
			bw.flush();
			String id = br.readLine();
			
			bw.write("Edad: ");
			bw.flush();
			int age = Integer.parseInt(br.readLine());
			
			bw.write("Programa: ");
			bw.flush();
			String program = br.readLine();
			
			students.insertAtEnd(new Student(name, surname, id, age, program) );
		}
		catch(Exception ex) {}
	}
	
	public static void delete_student()
	{
		try 
		{
			bw.write("A continuacion digite el ID del estudiante a eliminar.");
			bw.flush();
			String id = br.readLine();
			
			int index = students.indexOf(new Student(id));
			
			if(index != -1)
			{
				students.deleteAtIndex(index);
				bw.write("El estudiante con el ID " + id + " ha sido exitosamente eliminado.\n");
			}
			else
			{
				bw.write("El ID ingresado no existe.\n");
			}
			
			bw.flush();
		}
		catch(Exception ex) {}
	}
	
	public static void update_grade()
	{
		
	}
	
	public static void student_request()
	{
		try 
		{
			bw.write("Seleccione una de las siguientes opciones respecto a solicitudes."
					+ "\n1) Agregar solicitud\n2) Responder solicitud\n");
			bw.flush();
			int submenu_option = Integer.parseInt( br.readLine() );
			
			switch(submenu_option)
			{
				case 1:
				{
					add_request();
				}
				break;
				case 2:
				{
					resolve_request();
				}
				break;
			}
		}
		catch(Exception ex) {}	
	}
	
	public static void add_request()
	{
		try
		{
			bw.write("A continuacion diligencie la informacion de la solicitud.\nID: ");
			bw.flush();
			String id = br.readLine();
			
			bw.write("Fecha (DD/MM/AAAA): ");
			bw.flush();
			String date = br.readLine();
			
			bw.write("Descripcion: ");
			bw.flush();
			String text = br.readLine();
			
			requests.enqueue(new Request(id, date, text));
		}
		catch(Exception ex) {}
	}
	
	public static void resolve_request()
	{
		try
		{
			
		}
		catch(Exception ex) {}
	}
	
	public static void delivery_report()
	{
		
	}
	
	
	public static void save_studentsList()
	{
		try
		{
			FileWriter fw_students = new FileWriter("Students.umd");
			BufferedWriter bw_students = new BufferedWriter( fw_students );
			
			Student temp = (Student)students.head;
			
			while(temp != null)
			{
				bw_students.write(temp.toString());
				temp = (Student)temp.getNext();
			}
			
			bw_students.flush();
			
		}
		catch(Exception ex) {}
		
	}
	
	public static void load_students()
	{
		try
		{
			FileReader fr_students = new FileReader("Students.umd");
			BufferedReader br_students = new BufferedReader( fr_students );
			
			String input = br_students.readLine();
			String[] data;
			
			while(input != "")
			{
				data = input.split("\t");
				students.insertAtEnd(new Student(data[0].split(" ")[1], data[1].split(" ")[1], data[2].split(" ")[1], Integer.parseInt(data[3].split(" ")[1]), data[4].split(" ")[1]));
				
				input = br_students.readLine();
			}
		}
		catch(Exception ex) {}
	}
	
	public static void main(String[] args) {
		int menu_option;
		load_students();
		students.printList();
		
		try
		{
			do
			{
				bw.write( menu() );
				bw.flush();
				
				menu_option = Integer.parseInt( br.readLine() );
				
				while(menu_option > 6)
				{
					bw.write("Por favor, seleccione una opcion valida.\n");
					bw.flush();
					menu_option = Integer.parseInt( br.readLine() );
				}
				
				switch(menu_option)
				{
					case 1:
						insert_student();
					break;
					case 2:
						delete_student();
					break;
				}
			}
			while(menu_option != 6);
			
			save_studentsList();
		}
		catch(Exception ex) {}
		
	}
}