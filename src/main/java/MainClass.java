import java.util.ArrayList;
import java.util.List;


interface Animal {

    void jump();
}

 class Dog implements  Animal{

    @Override
    public String toString() {
        return "I'm a Dog . . .";
    }

    @Override
    public void jump() {
        System.out.println("Dog is jumping");
    }
}

class Cat implements Animal{


    @Override
    public String toString() {
        return "I'm a Cat . . .";
    }

    @Override
    public void jump() {
        System.out.println("Cat is jumping");
    }
}



 class NewAnimal<T extends Animal> {
    T  value;
    public NewAnimal(T value){
        this.value=value;
    }
    public void print() {
        System.out.println(value);

    }
}

class Test {

}
public class MainClass {

    public static void main(String[] args) {

        //accept only generic extend animal
        //NewAnimal<Test> newAnimal = new NewAnimal<>(new Test());

        NewAnimal<Dog> newAnimal1 = new NewAnimal<>(new Dog());
        NewAnimal<Cat> newAnimal2 = new NewAnimal<>(new Cat());


        /** Generic Lists example **/
        List<Double> list1= new ArrayList<>();
        list1.add(1.1);

        List<Dog> list2 = new ArrayList<>();
        list2.add(new Dog());

        List<Animal> list3= new ArrayList<>();
        list3.add(new Cat());


        printGenericExtend(list2);
        printGenericSuper(list3);
    }

    private static void printGenericExtend(List<? extends Animal> list) {
        //  list.add(new Cat()) //<-- wrong
        list.stream().forEach(animal -> System.out.println(animal));
    }

    private static void printGenericSuper(List<? super  Cat> list) {
        list.add(new Cat()); //<-- good
        list.stream().forEach(obj-> System.out.println(obj));
    }

}
