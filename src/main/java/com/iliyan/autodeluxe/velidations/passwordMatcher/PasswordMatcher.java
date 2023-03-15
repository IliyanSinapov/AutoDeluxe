package com.iliyan.autodeluxe.velidations.passwordMatcher;


import com.iliyan.autodeluxe.models.DTOs.view.UserRegisterModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterModel> {

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterModel userRegisterModel, ConstraintValidatorContext constraintValidatorContext) {

        if (userRegisterModel.getPassword() != null && userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
                .addPropertyNode(userRegisterModel.getConfirmPassword())
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}