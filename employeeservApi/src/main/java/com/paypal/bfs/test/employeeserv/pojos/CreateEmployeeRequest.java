package com.paypal.bfs.test.employeeserv.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    @NotBlank(message = "first_name can not be blank")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "last_name can not be blank")
    @JsonProperty("last_name")
    private String lastName;

    @NotNull(message = "date_of_birth is mandatory")
    @JsonProperty("date_of_birth")
    private Date dob;

    @NotNull(message = "address is mandatory")
    private @Valid AddressRequest address;
}
