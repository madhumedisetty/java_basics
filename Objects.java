
class Class{
    private String name;
    private int age;
    private String gender;
    
    public Class(String name, int age, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
    }
}

public class Objects {
    public static void main(String args[]){
        Class obj=new Class("John",20,"Male");
        obj.displayInfo();
    }
}
