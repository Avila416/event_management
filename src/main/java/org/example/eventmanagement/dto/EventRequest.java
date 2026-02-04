package org.example.eventmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Event date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;

    @NotBlank(message = "Location is required")
    private String location;
}
