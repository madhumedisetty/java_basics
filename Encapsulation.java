

class Student{
    private String name;
    private int age;
    private int id;
    private int marks;

    public Student(String name, int age, int id){
        this.name=name;
        this.age=age;
        this.id=id;
    }

    public void setMarks(int marks){
        this.marks=marks;
        if(marks<50){
            System.out.println("You are failed");
        }
        else{
            System.out.println("You are passed");
        }
    }

    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Id: "+id);
        System.out.println("Marks: "+marks);
    }
}

public class Encapsulation {
    public static void main(String args[]){
        Student obj=new Student("John",20,101);
        obj.setMarks(45);
        obj.displayInfo();
    }
}
