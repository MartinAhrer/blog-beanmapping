package at.softwarecraftsmen.resource;

import org.joda.time.LocalDate;

public class PersonResource {

    private PersonNameResource name;

    private LocalDate dateOfBirth;

    public PersonNameResource getName() {
        return name;
    }

    public void setName(PersonNameResource name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
