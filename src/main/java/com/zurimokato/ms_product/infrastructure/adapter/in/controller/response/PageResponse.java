package com.zurimokato.ms_product.infrastructure.adapter.in.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageResponse {
    private int page;
    private int size;
    private int totalPages;
    private int totalElements;
    private int number;
    private int numberOfElements;
    private boolean first;
    private boolean last;
    private boolean empty;

}
