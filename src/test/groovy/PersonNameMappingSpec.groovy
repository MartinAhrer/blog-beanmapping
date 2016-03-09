import at.softwarecraftsmen.PersonNameMapper
import at.softwarecraftsmen.test.shared.PersonNameFactory
import spock.lang.Specification

class PersonNameMappingSpec extends Specification {

    def "person name should be mapped" () {

        given:
        def mapper = PersonNameMapper.INSTANCE
        def source = new PersonNameFactory().newEntity()

        when:
        def target = mapper.map(source)

        then:
        target.firstName == source.firstName
        target.lastName == source.lastName
        target.middleName == source.middleName
        target.namePrefix == source.namePrefix
    }
}
