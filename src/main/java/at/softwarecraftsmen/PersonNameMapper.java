package at.softwarecraftsmen;

import at.softwarecraftsmen.model.PersonName;
import at.softwarecraftsmen.resource.PersonNameResource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonNameMapper {
    PersonNameMapper INSTANCE = Mappers.getMapper(PersonNameMapper.class);

    PersonNameResource map(PersonName person);
}
