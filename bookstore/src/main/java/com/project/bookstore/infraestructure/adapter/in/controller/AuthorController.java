package com.project.bookstore.infraestructure.adapter.in;

import com.project.bookstore.application.port.in.CreateAuthorPort;
import com.project.bookstore.application.port.in.DeleteAuthorPort;
import com.project.bookstore.application.port.in.GetAuthorPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final CreateAuthorPort createAuthorPort;
    private final GetAuthorPort getAuthorPort;
    private final DeleteAuthorPort deleteAuthorPort;

    public AuthorController(CreateAuthorPort createAuthorPort,
                            GetAuthorPort getAuthorPort,
                            DeleteAuthorPort deleteAuthorPort){
        this.createAuthorPort = createAuthorPort;
        this.getAuthorPort = getAuthorPort;
        this.deleteAuthorPort = deleteAuthorPort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDto create(@Valid @RequestBody AuthorRequestDto authorRequest){
        return AuthorWebMapper.toAuthorResponseDto(createAuthorPort.create(AuthorWebMapper.toAuthorCommand(authorRequest)));
    }

    @GetMapping
    public List<AuthorResponseDto> findAllAuthors(){
        return AuthorWebMapper.toAuthorListResponseDto(getAuthorPort.findAllAuthors());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponseDto findById(@PathVariable Long id){
        return AuthorWebMapper.toAuthorResponseDto(getAuthorPort.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        deleteAuthorPort.delete(id);
    }


}
