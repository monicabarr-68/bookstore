package com.project.bookstore.application.port.in;

import com.project.bookstore.domain.model.Author;

public interface CreateAuthorPort {
    Author create(CreateAuthorCommand authorCommand);
}
