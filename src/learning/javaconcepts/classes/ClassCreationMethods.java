package learning.javaconcepts.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassCreationMethods implements Cloneable {
    String name = "ClassCreationMethods";

    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        /**
         * 1st Method is a typical creation
         */
        ClassCreationMethods obj1 = new ClassCreationMethods();
        System.out.println("obj1: " + obj1.name);

        try {
            /**
             * 2nd Method is using Class's forName method
             */
            Class aClass = Class.forName("learning.javaconcepts.classes.ClassCreationMethods"); // throws ClassNotFoundException
            ClassCreationMethods obj2 = (ClassCreationMethods) aClass.newInstance(); //  throws IllegalAccessException and InstantiationException
            System.out.println("obj2: " + obj2.name);

            /**
             * 3rd Method is using cloning
             */
            ClassCreationMethods obj3 = (ClassCreationMethods) obj2.clone(); // 3rd method - throws CloneNotSupportedException - need to implement Cloneable interface
            System.out.println("obj3: " + obj3.name);

            /**
             * 4th Method is using Serialization and Deserialization Method.
             * First you have to Serialize an object using FileOutputStream and ObjectOutputStream.
             * Then you have to Deserialize the contents of file into an object.
             * Now you'll deserialize into a Java object by casting the data.
             */

            /**
             * 5th Method is using java reflection
             */
            Constructor<ClassCreationMethods> constructor = ClassCreationMethods.class.getDeclaredConstructor();
            ClassCreationMethods obj5 = constructor.newInstance();
            obj5.setName("Obj5: ClassCreationMethods");
            System.out.println(obj5.name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
