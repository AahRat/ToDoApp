package main;

import java.util.*;

class TodoApp{
	String username;
	ArrayList<TodoList> todolist ; 
	
	public TodoApp(String username) {
		this.username = username;
		this.todolist = new ArrayList<TodoList>();
	}
	
	public void displayList() {
		for ( int i = 0 ; i < todolist.size(); i++ ) {
			String listname = todolist.get(i).name ; 
			System.out.println(listname);
		}
	}
	
}

class TodoList{
	String name ;
	ArrayList<Task> allTasks;
	public TodoList(String name) {
		this.name = name;
		this.allTasks = new ArrayList<Task>();
	}
	
	public void displayList() {
		System.out.println(allTasks);
	}
	
	public void addTask(Task taskInput) {
		allTasks.add(taskInput);
	}
}

class Task extends Object{
	String title;
	String description;
	String date;
	
	public Task(String title, String description, String date) {
		this.title = title;
		this.description = description;
		this.date = date;
	}
	
	public void displayInfo() {
		System.out.println("Title: "+title+"\nDescription: "+description+"\nDate: "+date);
		}
	
	public String toString() {
		return "Title: "+title+"\nDescription: "+description+"\nDate: "+date;
	}
}
public class Main {
	public static void main(String[] args) {
				
		String name = "xyz";
		
		TodoApp user = new TodoApp(name);
		
		Scanner userInput = new Scanner(System.in);
		while(true) {
			line2();
			System.out.println("1. Create Todo-List \n2.Create Task \n3.Display Todo-List \n4.Display All Task\n5.Display Selected Tasks");
			line2();
			String userChoice = userInput.nextLine();
			
			if(userChoice.equals("1")) {
				System.out.println("Enter Name of List: ");
				String listName = userInput.nextLine();
				listName = listName.toLowerCase();
				TodoList todolist = new TodoList(listName);
				user.todolist.add(todolist);
				System.out.println("List Created");
			}
			else if(userChoice.equals("2")) {
				System.out.println("Enter Name of Task: ");
				String taskName = userInput.nextLine();
				System.out.println("Enter Description of Task: ");
				String taskDes = userInput.nextLine();
				System.out.println("Enter Date of Task: ");
				String taskDate = userInput.nextLine();
				Task todoTask = new Task(taskName, taskDes, taskDate);
				System.out.println("Name of List You Want to Add Task To: ");

				String listname = userInput.nextLine();
				listname = listname.toLowerCase();
				
				for(int i=0; i<user.todolist.size();i++) {
					if (user.todolist.get(i).name.equals(listname) ) {
						user.todolist.get(i).addTask(todoTask);
						break;
					}
				}
				System.out.println("Task Created & Added");
			}
			else if ( userChoice.equals("3")) {
				user.displayList();
			}
			
			else if(userChoice.equals("4")) {
				for ( int j = 0 ; j < user.todolist.size(); j++ ) {
					System.out.println("***");
					System.out.println("---");
					System.out.println(user.todolist.get(j).name.toUpperCase());
					System.out.println("---");
					for ( int i = 0 ; i < user.todolist.get(j).allTasks.size() ; i++ ) {
						
						System.out.println(user.todolist.get(0).allTasks.get(i).title);
					}
				}
				
			}
			
			else if(userChoice.equals("5")) {
				System.out.println("Enter the Name of List for Selected Tasks:");
				String selectedListName = userInput.nextLine();
				selectedListName = selectedListName.toLowerCase();
				for (int j = 0 ; j < user.todolist.size(); j++ ) {
					
					if ( selectedListName.equals(user.todolist.get(j).name)) {
						System.out.println("Displaying Tasks....");
						for ( int i = 0 ; i < user.todolist.get(j).allTasks.size() ; i++ ) {			
							System.out.println(user.todolist.get(j).allTasks.get(i));
							line1();
						}
						break;
					}
					
				}
			}
		}
		
		
		
	}

	
	public static void line1() {
		System.out.println("----------------------------");
	}
	public static void line2() {
		System.out.println("================================");
	}
}
