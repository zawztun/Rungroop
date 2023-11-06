package com.rungroop.web.Mapper;

import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Event;

public class EventMapper {
 public static Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .photoUrl(eventDto.getPhotoUrl())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .build();
    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .photoUrl(event.getPhotoUrl())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .build();
    }

}
