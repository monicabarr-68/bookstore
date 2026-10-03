package com.project.bookstore.infraestructure.adapter.in.mappers;

import com.project.bookstore.application.port.in.CreatePublisherCommand;
import com.project.bookstore.domain.model.BookPublisher;
import com.project.bookstore.infraestructure.adapter.in.dtos.PublisherRequestDto;
import com.project.bookstore.infraestructure.adapter.in.dtos.PublisherResponseDto;

import java.util.List;

public class PublisherWebMapper {
    public static CreatePublisherCommand toPublisherCommand(PublisherRequestDto requestDto){
        return new CreatePublisherCommand(requestDto.getName(), requestDto.getWebsite());
    }

    public static PublisherResponseDto toPublisherResponseDto(BookPublisher publisher){
        return new PublisherResponseDto(publisher.getName(), publisher.getWebsite());
    }

    public static List<PublisherResponseDto> toPublisherResponseDtoList(List<BookPublisher> publisherList){
        return publisherList.stream()
                            .map(publisher -> toPublisherResponseDto(publisher))
                            .toList();
    }
}
