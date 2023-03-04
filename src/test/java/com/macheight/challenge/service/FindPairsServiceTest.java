package com.macheight.challenge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FindPairsServiceTest {

    private FindPairsService fpService;

    @BeforeEach
    void setUp(){
        fpService = new FindPairsService();
    }
    @Test
    void given_many_invalid_inputString_then_it_should_raise_a_runtime_exception() {

        String errorMsgExpected = "Invalid input data... Finished program :)";

        //Given
        String blankSpace_at_the_beginning = " 3,5,4,7 11";
        String blankSpace_at_the_end_instead_given_value = "3,5,4,7 ";
        String blankSpace_at_the_end = "3,5,4,7 11 ";
        String blankSpace_in_the_middle_of_list_number = "3,5,4 ,7 11 ";
        String starts_with_comma = ",3,5,4 ,7 11 ";
        String starts_with_sign_but_without_number = "-,5,4,7 11 ";
        String inputString_with_letter = "A,5,4,7 11 ";

        //Act
        Exception blankSpace_at_the_beginning_exception = assertThrows(RuntimeException.class, () -> fpService.run(blankSpace_at_the_beginning));
        Exception blankSpace_at_the_end_instead_given_value_exception = assertThrows(RuntimeException.class, () -> fpService.run(blankSpace_at_the_end_instead_given_value));
        Exception blankSpace_at_the_end_exception = assertThrows(RuntimeException.class, () -> fpService.run(blankSpace_at_the_end));
        Exception blankSpace_in_the_middle_of_list_number_exception = assertThrows(RuntimeException.class, () -> fpService.run(blankSpace_in_the_middle_of_list_number));
        Exception starts_with_comma_exception = assertThrows(RuntimeException.class, () -> fpService.run(starts_with_comma));
        Exception starts_with_sign_but_without_number_exception = assertThrows(RuntimeException.class, () -> fpService.run(starts_with_sign_but_without_number));
        Exception inputString_with_letter_exception = assertThrows(RuntimeException.class, () -> fpService.run(inputString_with_letter));

        //Asserts
        assertEquals(blankSpace_at_the_beginning_exception.getMessage(), errorMsgExpected);
        assertEquals(blankSpace_at_the_end_instead_given_value_exception.getMessage(), errorMsgExpected);
        assertEquals(blankSpace_at_the_end_exception.getMessage(), errorMsgExpected);
        assertEquals(blankSpace_in_the_middle_of_list_number_exception.getMessage(), errorMsgExpected);
        assertEquals(starts_with_comma_exception.getMessage(), errorMsgExpected);
        assertEquals(starts_with_sign_but_without_number_exception.getMessage(), errorMsgExpected);
        assertEquals(inputString_with_letter_exception.getMessage(), errorMsgExpected);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,7,8 19",
            "-1,2,-3,4,5,-6,7,8 3",
            "1,9,5,0,20,-4,12,16,7,3 12"
    })
    void given_a_valid_inputString_then_it_must_process_the_request_successfully(String inputString){
        //Act
        assertDoesNotThrow(() -> fpService.run(inputString));
    }
}
