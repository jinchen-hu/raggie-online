package com.raggie.base.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaggieException extends RuntimeException {
    private String errorMessage;

    public static void cast(CommonError commonError) {
        throw new RaggieException(commonError.getMessage());
    }

    public static void cast(String errorMessage) {
        throw new RaggieException(errorMessage);
    }
}
