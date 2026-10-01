package com.project.bookstore.infraestructure.adapter.in;

import com.project.bookstore.application.port.in.CreateAuthorCommand;
import com.project.bookstore.domain.model.Author;

import java.util.List;

public class AuthorWebMapper {

    public static CreateAuthorCommand toAuthorCommand(AuthorRequestDto requestDto){
        return new CreateAuthorCommand(requestDto.getFullName(), requestDto.getBiography());
    }

    public static AuthorResponseDto toAuthorResponseDto (Author author){
        return new AuthorResponseDto(author.getFullName(), author.getBiography());
    }

    public static List<AuthorResponseDto> toAuthorListResponseDto(List<Author> authorList){
        return authorList.stream()
                         .map(author -> toAuthorResponseDto(author))
                         .toList();
    }
}
