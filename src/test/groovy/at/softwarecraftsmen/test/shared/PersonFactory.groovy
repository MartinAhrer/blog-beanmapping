package at.softwarecraftsmen.test.shared

import at.softwarecraftsmen.model.Person
import org.apache.commons.lang3.RandomUtils
import org.joda.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired

class PersonFactory extends AbstractEntityFactory {

    @Autowired(required = false)
    PersonNameFactory personNameFactory = new PersonNameFactory()


    Person newEntity(Map args = [:]) {
        def defaults = [
                name       : personNameFactory.newEntity(),
                dateOfBirth: new LocalDate().minusYears(RandomUtils.nextInt(18, 100))
        ]
        defaults << args

        new Person(
                name: defaults.name,
                dateOfBirth: defaults.dateOfBirth,
        )
    }
}
