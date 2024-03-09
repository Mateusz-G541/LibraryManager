package mg.librarymanager.dataModels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Magazine extends Item {

    private final String magazineYear;
    private final String magazineNumber;
    private final String magazineName;

    public Magazine(UUID id, String title, UUID location, LocalDate releaseDate, BigDecimal rating, boolean isAvailable, int amount, String magazineYear, String magazineNumber, String magazineName) {
        super(id, title, location, releaseDate, rating, isAvailable, amount);
        this.magazineYear = magazineYear;
        this.magazineNumber = magazineNumber;
        this.magazineName = magazineName;
    }
}
