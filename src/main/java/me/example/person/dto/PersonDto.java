package me.example.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthDate;

    private AddressDto registrationAddress;

    private List<AddressDto> residentialAddresses;
}
