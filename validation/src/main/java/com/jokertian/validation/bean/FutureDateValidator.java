package com.jokertian.validation.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

/**
 * @author 田朋朋
 * @date 2022/5/15 21:42
 */
public class FutureDateValidator implements ConstraintValidator<FutureDate, Object> {

    @Override
    public void initialize(FutureDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (!(o instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = (LocalDateTime) o;
        return localDateTime.isAfter(now);
    }
}
