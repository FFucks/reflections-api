import java.lang.reflect.Field;

public class InjectionAnnotation {

    public void inject(Object obj) throws IllegalAccessException {
        Class<?> c = obj.getClass();

        for (Field field : c.getDeclaredFields()) {
            if (field.isAnnotationPresent(Dog.DefaultName.class)) {
                Dog.DefaultName annotation = field.getAnnotation(Dog.DefaultName.class);

                String value = annotation.value();
                field.setAccessible(true);

                if (field.getType() == String.class) {
                    field.set(obj, value);
                }
            } else if (field.isAnnotationPresent(Dog.DefaultBreed.class)) {
                Dog.DefaultBreed annotation = field.getAnnotation(Dog.DefaultBreed.class);

                String value = annotation.value();
                field.setAccessible(true);

                if (field.getType() == String.class) {
                    field.set(obj, value);
                }
            }
        }
    }
}
