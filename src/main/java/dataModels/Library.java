package dataModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Builder
@AllArgsConstructor
@Getter
public class Library {
    private UUID id;
    private String address;
}
