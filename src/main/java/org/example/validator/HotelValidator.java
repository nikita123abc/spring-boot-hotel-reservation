package org.example.validator;

import org.example.constants.ErrorMessages;
import org.example.entity.Hotel;
import org.example.entity.ValidTypesOfHotelsEnum;
import org.example.exception.InvalidRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Slf4j
public class HotelValidator extends BaseValidator {

    /**
     * Validator for the Hotel POST call
     *
     * @param hotel
     */
    public static void validateHotelPOST(Hotel hotel) {
        validateName(hotel.getName());
        validateType(hotel.getType());
        validateDates(hotel.getAvailableFrom(), hotel.getAvailableTo());
    }

    /**
     * Validator for the Hotel PATCH call
     *
     * @param hotel
     */
    public static void validateHotelPATCH(Hotel hotel) {
        validateId(hotel.getId());
        validateName(hotel.getName());
        validateType(hotel.getType());
        validateDates(hotel.getAvailableFrom(), hotel.getAvailableTo());
    }

    /**
     * Validator for the Hotel name
     *
     * @param name
     */
    public static void validateName(String name) {
        if (!StringUtils.hasText(name)) {
            log.error("Hotel name cannot be null...");
            throw new InvalidRequestException(ErrorMessages.INVALID_NAME);
        }
    }

    /**
     * Validator for the Hotel type
     *
     * @param type
     */
    public static void validateType(ValidTypesOfHotelsEnum type) {
        if (type == null || !Arrays.asList("DELUXE", "LUXURY", "SUITE").contains(type.toString())) {
            log.error("The type parameter: '{}' is invalid, must be one of the following [DELUXE, LUXURY, SUITE]", type);
            throw new InvalidRequestException(ErrorMessages.INVALID_TYPE);
        }
    }

}
