public class Seat {
    private String seatNumber;
    private boolean isBusinessClass;
    private boolean isTaken;

    public Seat(String seatNumber, boolean isBusinessClass) {
        this.seatNumber = seatNumber;
        this.isBusinessClass = isBusinessClass;
        this.isTaken = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}