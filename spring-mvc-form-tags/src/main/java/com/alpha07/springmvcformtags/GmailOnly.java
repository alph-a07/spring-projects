package com.alpha07.springmvcformtags;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GmailValidator.class) // validation logic class
@Target({ElementType.FIELD,ElementType.METHOD}) // validation element target type
@Retention(RetentionPolicy.RUNTIME) // duration of annotation retention
public @interface GmailOnly {

    // jakarta.validation.ConstraintDefinitionException: HV000074: com.alpha07.springmvcformtags.GmailOnly contains Constraint annotation, but does not contain a groups parameter.
    // define default groups
    public Class<?>[] groups() default {};

    // jakarta.servlet.ServletException: Request processing failed: jakarta.validation.ConstraintDefinitionException: HV000074: com.alpha07.springmvcformtags.GmailOnly contains Constraint annotation, but does not contain a payload parameter.
    // define default payloads
    public Class<? extends Payload>[] payload() default {};

    // >> Below properties can be overridden while using the annotation or can be used as default too

    // Define default email tag
    public String tag() default "@gmail.com";

    // Define default error message
    public String message() default "Only gmail addresses are allowed";
}
