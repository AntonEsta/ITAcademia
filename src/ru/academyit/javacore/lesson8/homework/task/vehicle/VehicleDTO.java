package ru.academyit.javacore.lesson8.homework.task.vehicle;

import ru.academyit.javacore.lesson8.homework.task.Person;

import java.util.Objects;

public class VehicleDTO {
    private final Person person;
    private final VehicleNumber vehicleNumber;

    public VehicleDTO(Person person, VehicleNumber vehicleNumber) {
        this.person = person;
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDTO that = (VehicleDTO) o;
        return person.equals(that.person) && vehicleNumber.equals(that.vehicleNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, vehicleNumber);
    }

    @Override
    public String
    toString() {
        return "Транспортное средство" +
                "\n\tГос. регистрационный номер: " + vehicleNumber +
                "\n\tВладелец: " +
                "\t" + person.getLastName() +
                " " + person.getFirstName() +
                " " + person.getPatronymic();
    }
}
