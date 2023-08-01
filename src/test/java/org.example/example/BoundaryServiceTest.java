package org.example.example;

import org.example.BoundaryService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BoundaryServiceTest {
    BoundaryService boundaryService = new BoundaryService();

    private static int[][] arrayProvider(){
        return new int[][]{ {-5, 1, 5, 9 ,58}, {58, 9, 5, 1, -5} , {-1, 0, -57, 100, -99, 1000}};
    }

    @ParameterizedTest(name = "Корректные значения")
    @MethodSource("arrayProvider")
    @Disabled
    void positiveTest(int[] arr){
        var result = boundaryService.findMin(arr);
        var expected = Arrays.stream(arr).min().getAsInt();
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Пустой массив")
    @EmptySource
    void arrIsEmpty(int[] emptyArr){
        Throwable thrown = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            boundaryService.findMin(emptyArr);
        });
        assertNotNull(thrown.getMessage());
    }
}

