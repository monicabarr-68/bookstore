package com.project.bookstore.infraestructure.adapter.in.controller;

import com.project.bookstore.application.port.in.CreatePublisherPort;
import com.project.bookstore.application.port.in.DeletePublisherPort;
import com.project.bookstore.application.port.in.GetPublisherPort;
import com.project.bookstore.infraestructure.adapter.in.dtos.AuthorRequestDto;
import com.project.bookstore.infraestructure.adapter.in.dtos.AuthorResponseDto;
import com.project.bookstore.infraestructure.adapter.in.dtos.PublisherRequestDto;
import com.project.bookstore.infraestructure.adapter.in.dtos.PublisherResponseDto;
import com.project.bookstore.infraestructure.adapter.in.mappers.AuthorWebMapper;
import com.project.bookstore.infraestructure.adapter.in.mappers.PublisherWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private final CreatePublisherPort createPublisherPort;
    private final GetPublisherPort getPublisherPort;
    private final DeletePublisherPort deletePublisherPort;


    public PublisherController(CreatePublisherPort createPublisherPort,
                               GetPublisherPort getPublisherPort,
                               DeletePublisherPort deletePublisherPort) {
        this.createPublisherPort = createPublisherPort;
        this.getPublisherPort = getPublisherPort;
        this.deletePublisherPort = deletePublisherPort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherResponseDto create(@Valid @RequestBody PublisherRequestDto publisherRequest){
        return PublisherWebMapper.toPublisherResponseDto(
                createPublisherPort.create(PublisherWebMapper.toPublisherCommand(publisherRequest))
        );
    }

    @GetMapping
    public List<PublisherResponseDto> findAllPublishers(){
        return PublisherWebMapper.toPublisherResponseDtoList(getPublisherPort.findAllPublishers());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherResponseDto findById(@PathVariable Long id){
        return PublisherWebMapper.toPublisherResponseDto(getPublisherPort.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable Long id){
        deletePublisherPort.delete(id);
    }

}
