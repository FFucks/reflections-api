import java.lang.reflect.Method;
import java.util.Arrays;

public class Application {

    /*
    Java Reflection is an feature that allows you to inspect and manipulate classes, interfaces, fields, and methods at runtime
     */
    public static void main(String[] args) throws Exception {

        Class dog = Class.forName("Dog");
        Method methodArr[] = dog.getDeclaredMethods();

        boolean isEqual = dog.isInstance(new Dog());
        boolean isEqualWithParameter = dog.isInstance(new Dog("Solo", "Daschung"));

        System.out.println(isEqual);
        System.out.println(isEqualWithParameter);

        Method method = methodArr[0];
        Class paramTypes[] = method.getParameterTypes();
        Class returnType = method.getReturnType();
        Class exceptionTypes[] = method.getExceptionTypes();

        Arrays.stream(paramTypes).forEach(System.out::println);
        System.out.println("Return Type: " + returnType);
        //System.out.println("Param Types: " + paramTypes[0]);


        for (int count = 0; count < methodArr.length; count ++) {
            System.out.println(methodArr[count].toString());
        }

        //System.out.println(method[4].toString());



    }
}