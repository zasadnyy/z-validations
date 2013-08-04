package ua.org.zasadnyy.zvalidations.validations;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public interface Validation {

    String getErrorMessage();

    boolean isValid(String text);

}
