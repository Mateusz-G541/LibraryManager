package dataModels;

import helpers.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class User implements Serializable {

    private UUID id;

    private String firstName;

    private String lastName;

    private String pesel;

    private String address;

    private String postalCode;

    private UserType userType;

    private LocalDate birthDate;

    private int alreadyBorrowedBooks;
}
