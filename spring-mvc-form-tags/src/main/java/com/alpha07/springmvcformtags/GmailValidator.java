package com.alpha07.springmvcformtags;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Implements ConstraintValidator<AnnotationInterface, TargetType>
public class GmailValidator implements ConstraintValidator<GmailOnly, String> {

    String defaultTag; // default value of the annotation tag

    @Override
    public void initialize(GmailOnly constraintAnnotation) {
        defaultTag = constraintAnnotation.tag(); // default value of the annotation tag
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;

        // Mark valid only if string contains defaultTag
        if (s != null) isValid = s.contains(defaultTag);
        else isValid = true;

        return isValid;
    }
}
