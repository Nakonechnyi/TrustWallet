package org.community.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by a.nakonechnyi on 25.02.2017.
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {


    private PhoneNumberUtil phoneUtil;

    @Override
    public void initialize(Phone paramA){
                phoneUtil=PhoneNumberUtil.getInstance();
    }

    @Override
    public boolean isValid(String phoneNo,ConstraintValidatorContext ctx){
            try{
                phoneUtil.parse(phoneNo,"UA");
                return true;
            }catch(NumberParseException e){
                return false;
            }
    }
}
