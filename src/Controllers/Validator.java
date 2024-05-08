package Controllers;

@FunctionalInterface
public interface Validator {
    boolean validate(Object o);
}
