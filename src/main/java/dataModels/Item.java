package dataModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public abstract class Item  {

    private UUID id;
    private String title;
    private UUID location;
    private LocalDate releaseDate;
    private BigDecimal rating;
    private boolean isAvailable;
    private int amount;

}
