package com.rungroop.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Club title should not be Empty")
    private String title;
    @NotEmpty(message = "Photo link should not be Empty")
    private String photoUrl;
    @NotEmpty(message = "Content should not be Empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
