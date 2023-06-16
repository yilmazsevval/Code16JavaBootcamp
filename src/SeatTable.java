public class SeatTable {
    private Seat[][] seatTable;

    public SeatTable() {
        seatTable = createSeatTable();
    }

    private Seat[][] createSeatTable() {
        Seat[][] seatTable = new Seat[10][3];

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 3; col++) {
                String seatNumber = (char) ('A' + row) + String.valueOf(col + 1);
                boolean isBusinessClass = row < 3; // İlk 3 satır Business Class olarak işaretlendi
                seatTable[row][col] = new Seat(seatNumber, isBusinessClass);
            }
        }

        return seatTable;
    }

    public void printSeatTable() {
        System.out.println("Koltuk Tablosu:");
        System.out.println("===============");

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 3; col++) {
                Seat seat = seatTable[row][col];
                System.out.print(seat.getSeatNumber() + " (" + (seat.isBusinessClass() ? "Business" : "Economy") + ")\t");
            }
            System.out.println();
        }
    }

    public boolean isSeatTaken(String seatNumber) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 3; col++) {
                Seat seat = seatTable[row][col];
                if (seat.getSeatNumber().equals(seatNumber) && seat.isTaken()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean takeSeat(String seatNumber) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 3; col++) {
                Seat seat = seatTable[row][col];
                if (seat.getSeatNumber().equals(seatNumber) && !seat.isTaken()) {
                    seat.setTaken(true);
                    return true;
                }
            }
        }
        return false;
    }

    public Seat[][] getSeatTable() {
        return seatTable;
    }
}