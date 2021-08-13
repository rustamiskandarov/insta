package ru.rustisk.insta.validations;

import ru.rustisk.insta.annotations.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    public void initialize(ValidEmail constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return false;
    }
}
