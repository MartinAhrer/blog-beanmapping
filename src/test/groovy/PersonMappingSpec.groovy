import at.softwarecraftsmen.PersonMapper
import at.softwarecraftsmen.PersonNameMapper
import at.softwarecraftsmen.model.Person
import at.softwarecraftsmen.test.shared.PersonFactory
import spock.lang.Specification

class PersonMappingSpec extends Specification {

    def "person should be mapped" () {
        given:
        def mapper= PersonMapper.INSTANCE
        def source = new PersonFactory().newEntity()
        when:
        def target= mapper.map(source)
        then:
        target.name.firstName == source.name.firstName
        target.dateOfBirth == source.dateOfBirth
    }

}
