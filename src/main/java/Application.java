import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Application {

    /*
    Java Reflection is an feature that allows you to inspect and manipulate classes, interfaces, fields, and methods at runtime
     */
    public static void main(String[] args) throws Exception {

        annotationInjection();
        verifyInstances();
        verifyMethods();

    }

    public static void annotationInjection() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Dog dog = new Dog();
        System.out.println("Dog Name: " + dog.getName());

        InjectionAnnotation injectionAnnotation = new InjectionAnnotation();
        injectionAnnotation.inject(dog);

        Method method = Dog.class.getDeclaredMethod("getBreed");
        method.setAccessible(true);

        System.out.println("Dog Name after annotation: " + dog.getName());
        System.out.println("Dog Breed after annotation: " + method.invoke(dog).toString());
    }

    public static void verifyInstances() throws Exception {
        Class<?> dog = Class.forName("Dog");

        boolean isEqual = dog.isInstance(new Dog());
        boolean isEqualWithParameter = dog.isInstance(new Dog("Solo", "Daschung"));

        System.out.println(isEqual);
        System.out.println(isEqualWithParameter);
    }

    public static void verifyMethods() throws ClassNotFoundException {
        Class<?> dog = Class.forName("Dog");
        Method[] methodArr = dog.getDeclaredMethods();

        for (Method m : methodArr) {
            System.out.println("Method name: " + m.getName());
            System.out.println("Method parameter types" + Arrays.toString(m.getParameterTypes()));
            System.out.println("Method return type" + m.getReturnType());
            System.out.println("Method exceprion types:" + Arrays.toString(m.getExceptionTypes()));
            System.out.println();
        }
    }
}