package com.rungroop.web.dto;

import com.rungroop.web.models.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

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
    private UserEntity createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<EventDto> events;
}
