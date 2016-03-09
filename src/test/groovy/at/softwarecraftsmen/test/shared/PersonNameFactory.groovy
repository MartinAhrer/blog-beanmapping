package at.softwarecraftsmen.test.shared

import at.softwarecraftsmen.model.PersonName

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

class PersonNameFactory extends AbstractEntityFactory<PersonName> {

    def static name() {
        randomAlphabetic(PersonName.MAX_NAME_LENGTH)
    }

    //@Override
    PersonName newEntity(Map args = [:]) {
        def defaults = [firstName: name(),
                        middleName: name(),
                        lastName: name(),
                        namePrefix: name()]
        defaults << args

        new PersonName(firstName: defaults.firstName,
                middleName: defaults.middleName,
                lastName: defaults.lastName,
                namePrefix: defaults.namePrefix)
    }
}

