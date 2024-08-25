package com.raggie.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParams {
    // Default page number
    public static final long DEFAULT_PAGE_CURRENT = 1L;
    // Default page size
    public static final long DEFAULT_PAGE_SIZE = 10L;

    // Current page number
    private Long pageNo = DEFAULT_PAGE_CURRENT;

    // Current page size
    private Long pageSize = DEFAULT_PAGE_SIZE;
}
