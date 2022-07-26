package com.toyproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static java.lang.Math.max;
import static java.util.Objects.requireNonNullElse;

@Getter @Setter
public class BoardSearchCond {

    private int page;
    private int size = 10;
    private Sort sort;

    @Builder
    public BoardSearchCond(Integer page) {
        this.page = requireNonNullElse(page, 1);
        this.sort = Sort.by(Sort.Direction.DESC, "id");
    }

    public int getOffset() {
        return ((max(1, page) - 1) * size);
    }

}
