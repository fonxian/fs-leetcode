package com.fonxian.base.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Michael Fang
 * @since 2020-04-01
 */
public class ReflectDemo {

    public static void main(String[] args) {

        Person person1 = new Person();

        Class classz1 = Person.class;
        Class classz2 = person1.getClass();
        try {

            Class classz3 = Class.forName("com.fonxian.base.reflect.Person");
            Object obj = classz3.getConstructor().newInstance();
            Person person2 = (Person) obj;
            person2.learn();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
