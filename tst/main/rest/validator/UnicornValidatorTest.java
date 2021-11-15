package main.rest.validator;

import main.rest.model.UniCorn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UnicornValidatorTest {
    UnicornValidator validator;
    UniCorn uniCorn;

    @Before
    public void before() {
        validator = new UnicornValidator();
        uniCorn = new UniCorn();
        uniCorn.setName("TestName");
        uniCorn.setHornLength(210);
        uniCorn.setWeight(20);
        uniCorn.setHeight(200);
    }

    @Test
    public void testValidateHappyPath() {
        validator.validate(uniCorn);
    }

    @Test
    public void testValidateFailurePath() {
        try {
            uniCorn = new UniCorn();
            validator.validate(uniCorn);
            fail("Exception with Parameters to be thrown");
        }
        catch (RuntimeException e) {
            assertEquals("Valid input data need to be passed for parameters: name,hornLength,height,weight", e.getMessage());
        }
    }
}