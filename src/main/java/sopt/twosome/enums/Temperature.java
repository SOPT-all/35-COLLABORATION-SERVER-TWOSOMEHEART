package sopt.twosome.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import sopt.twosome.exception.ErrorCode;
import sopt.twosome.exception.InvalidArgsException;

@AllArgsConstructor
public enum Temperature {
    ICE(0, "ICE"),
    HOT(1, "HOT");

    private final int index;
    private final String value;

    @JsonCreator
    public static Temperature fromIndex(int index) {
        for (Temperature temp : Temperature.values()) {
            if (temp.index == index) {
                return temp;
            }
        }
        throw new InvalidArgsException(ErrorCode.INVALID_OPTIONS);
    }


    public int getIndex() {
        return index;
    }

    @JsonValue
    public String getValue() {
        return value;
    }


}
