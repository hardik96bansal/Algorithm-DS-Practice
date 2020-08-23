package DpPractice;

import java.util.ArrayList;
import java.util.HashSet;

class User{
    String name;
    ArrayList<Todo> todos;

    public User(String name) {
        this.name = name;
        this.todos = new ArrayList<>();
    }
}

class Todo{
    String task;
    User user;
    boolean isComplete;
    public Todo(String task, User user, boolean isComplete) {
        this.task = task;
        this.user = user;
        this.isComplete = isComplete;
        this.user.todos.add(this);
    }
}

class TodoManager{    

    HashSet<User> users;
    ArrayList<Todo> todos;

    TodoManager(){
        this.users = new HashSet<>();
        this.todos = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void newTask(String taskName, User user){
        Todo newTodo = new Todo(taskName, user, false);
        this.todos.add(newTodo);
    }

    public ArrayList<Todo> getTodos(){
        return this.todos;
    }

    public void completeTask(String taskName){
        for(int i=0;i<this.todos.size();i++){
            if(this.todos.get(i).task.equals(taskName)){
                Todo temp = this.todos.get(i);
                temp.isComplete = true;
                this.todos.set(i, temp);
            }
        }
    }    
}


public class Temp {
    public static void main(String[] args) {
        TodoManager tm = new TodoManager();
        User u1 = new User("Shorya");
        tm.addUser(u1);
        tm.newTask("Study", u1);
        tm.newTask("Eat", u1);
        tm.newTask("Work", u1);

        ArrayList<Todo> todos = tm.getTodos();
        for(Todo todo:todos){
            System.out.println(todo.task + " " + todo.isComplete + " " + todo.user.name);
        }

        tm.completeTask("Eat");

        System.out.println("\n");
        for(Todo todo:todos){
            System.out.println(todo.task + " " + todo.isComplete + " " + todo.user.name);
        }


    }
}