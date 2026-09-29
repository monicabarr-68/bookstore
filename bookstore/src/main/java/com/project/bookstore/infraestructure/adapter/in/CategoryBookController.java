package com.project.bookstore.infraestructure.adapter.in;

import com.project.bookstore.application.port.in.CategoryBookInputPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryBookController {

    private final CategoryBookInputPort categoryInputPort;

    public CategoryBookController(CategoryBookInputPort categoryInputPort){
        this.categoryInputPort = categoryInputPort;
    }


}
