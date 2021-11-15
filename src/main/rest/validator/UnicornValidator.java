package main.rest.validator;

import main.rest.exception.ValidationException;
import main.rest.model.UniCorn;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
@Repository
public class UnicornValidator {
    private static final String EMPTY_STRING = "";

    public void validate(UniCorn uniCorn) {
        StringBuilder sb = new StringBuilder();
        sb.append(checkIfNameIsValid(uniCorn));
        sb.append(checkIfHornLengthIsValid(uniCorn));
        sb.append(checkIfHeightIsValid(uniCorn));
        sb.append(checkIfWeightIsValid(uniCorn));
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            throw new ValidationException("Valid input data need to be passed for parameters: " + sb.toString());
        }
    }

    private String checkIfNameIsValid(final UniCorn uniCorn) {
        if (StringUtils.isEmpty(uniCorn.getName())) {
            return "name,";
        }
        return EMPTY_STRING;
    }

    private String checkIfHornLengthIsValid(final UniCorn uniCorn) {
        if (uniCorn.getHornLength() == 0) {
            return "hornLength,";
        }
        return EMPTY_STRING;
    }

    private String checkIfHeightIsValid(final UniCorn uniCorn) {
        if (uniCorn.getHeight() == 0) {
            return "height,";
        }
        return EMPTY_STRING;
    }

    private String checkIfWeightIsValid(final UniCorn uniCorn) {
        if (uniCorn.getWeight() == 0) {
            return "weight,";
        }
        return EMPTY_STRING;
    }
}
