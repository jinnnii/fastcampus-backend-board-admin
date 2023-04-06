package com.fastcampus.backendboardadmin.domain.converter;

import com.fastcampus.backendboardadmin.domain.constant.RoleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class RoleTypesConverter implements AttributeConverter<Set<RoleType>,String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(Set<RoleType> attribute) {
<<<<<<< Updated upstream
        return attribute.stream().map(RoleType::name).sorted().collect(Collectors.joining());
=======
        return attribute.stream().map(RoleType::name).sorted().collect(Collectors.joining(DELIMITER));
>>>>>>> Stashed changes
    }

    @Override
    public Set<RoleType> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(DELIMITER)).map(RoleType::valueOf).collect(Collectors.toSet());
    }
}
