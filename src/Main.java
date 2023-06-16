import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TurkishAirlines turkishAirlines = new TurkishAirlines();
        PegasusAirlines pegasusAirlines = new PegasusAirlines();

        System.out.println("Havayolu Şirketi Seçin:" +
                "\n1. Turkish Airlines" +
                "\n2. Pegasus Airlines");
        int airlineChoice = scanner.nextInt();

        Airline selectedAirline;
        if (airlineChoice == 1) {
            selectedAirline = turkishAirlines;
        } else if (airlineChoice == 2) {
            selectedAirline = pegasusAirlines;
        } else {
            System.out.println("Geçersiz seçim. Tekrar deneyiniz.");
            return;
        }

        System.out.print("İsim Soyisim Girin: ");
        String name = scanner.next();

        SeatTable seatTable = new SeatTable();
        seatTable.printSeatTable();

        String seatNumber = null;
        boolean validSeatNumber = false;
        while (!validSeatNumber) {
            System.out.print("Koltuk Numarası Girin: ");
            seatNumber = scanner.next();

            if (seatTable.isSeatTaken(seatNumber)) {
                System.out.println("Seçilen koltuk zaten alınmış.");
            } else {
                if (seatTable.takeSeat(seatNumber)) {
                    validSeatNumber = true;
                } else {
                    System.out.println("Geçersiz koltuk numarası.");
                }
            }
        }

        boolean isBusinessClass = false;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                Seat seat = seatTable.getSeatTable()[row][col];
                if (seat.getSeatNumber().equals(seatNumber)) {
                    isBusinessClass = seat.isBusinessClass();
                    break;
                }
            }
        }

        boolean isInternationalFlight = true; // Örnek olarak uluslararası uçuş olarak işaretledik
        boolean hasMeal = selectedAirline.getName().equals("Turkish Airlines");

        double ticketPrice = selectedAirline.calculateTicketPrice(isInternationalFlight, hasMeal);

        System.out.println("Bilet Bilgileri:" +
                "\n===============" +
                "\nHavayolu Şirketi: " + selectedAirline.getName() +
                "\nİsim Soyisim: " + name +
                "\nKoltuk Numarası: " + seatNumber +
                "\nSınıf: " + (isBusinessClass ? "Business" : "Economy") +
                "\nYemek Hizmeti: " + (hasMeal ? "Var" : "Yok") +
                "\nUçuş Türü: " + (isInternationalFlight ? "Uluslararası" : "Yurtiçi") +
                "\nBilet Fiyatı: " + ticketPrice + " TL");
    }
}
