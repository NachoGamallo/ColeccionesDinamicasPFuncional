package org.example.Colecciones.EqualsHashCode.TEx2_RecaudacionDelCine;

public class Person {

    private int age;

    public Person(int age){

        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
