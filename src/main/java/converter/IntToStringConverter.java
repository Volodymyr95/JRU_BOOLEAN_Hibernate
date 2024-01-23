package converter;

import javax.persistence.AttributeConverter;

public class IntToStringConverter implements AttributeConverter<Integer, String> {
    @Override
    public String convertToDatabaseColumn(Integer integer) {
        return String.valueOf(integer);
    }

    @Override
    public Integer convertToEntityAttribute(String s) {
        return Integer.parseInt(s);
    }
}
