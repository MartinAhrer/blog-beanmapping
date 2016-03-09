package at.softwarecraftsmen;

import at.softwarecraftsmen.model.Person;
import at.softwarecraftsmen.model.PersonName;
import at.softwarecraftsmen.resource.PersonNameResource;
import at.softwarecraftsmen.resource.PersonResource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper (uses = PersonNameMapper.class)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonResource map(Person person);
}
