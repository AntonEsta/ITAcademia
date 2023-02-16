package ru.academyit.javacore.lesson9.homework.task02;

/**
 * Диспетчер парковки/аэродрома
 */
public class AerodromeDispatcher {

    private String title;
    private final PlanesParking parking;

    public AerodromeDispatcher(String title, int aerodromeParkingCapacity) {
        this.title = title;
        parking = new PlanesParking(aerodromeParkingCapacity);
    }

    /**
     * Посадить самолет.
     *
     * @param plane самолет
     * @return true - если самолет принят, иначе - false
     */
    public boolean landingPlane(Plane plane) {
        if (plane == null) {
            throw new IllegalArgumentException("Argument cannot be null!");
        }
        return parking.add(plane);
    }


    public String getTitle() {
        return title;
    }

    /**
     * Удалить последний припаркованный самотет.
     *
     * @return Удаленный самолет или null.
     */
    public Plane exitLastPlane() {
        return parking.exitLast();
    }

    /**
     * Удалить все самолеты со стоянки
     */
    public void exitAllPlanes() {
        parking.exitAll();
    }
}
