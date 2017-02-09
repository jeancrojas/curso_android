package es.cice.jcreadingjson.model;

/**
 * Created by cice on 9/2/17.
 */

public class Person {

    private String name;
    private Integer age;

    public Person (String name, Integer age) {

        this.name = name;
        this.age = age;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString () {
        return "PERSON(POJO)=> name:"+name+" age:"+age;
    }
}
