package com.zurimokato.ms_product.infrastructure.adapter.in.controller.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse implements Serializable  {
    private int size;
    private int totalPages;
    private int totalElements;
    private int number;
    private int numberOfElements;
    private boolean first;
    private boolean last;
    private boolean empty;

}
