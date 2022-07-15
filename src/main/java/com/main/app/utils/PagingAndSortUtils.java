package com.main.app.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PagingAndSortUtils {

    public static Pageable buildPageable(String sort, Pageable pageable) {
        if (!sort.isBlank() && !sort.isEmpty()) {
            if (sort.contains(",")) {
                String[] s = sort.split(",");
                if (s[1].equalsIgnoreCase("ASC")) {
                    return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(s[0]).ascending());
                }
                if (s[1].equalsIgnoreCase("DESC")) {
                    return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(s[0]).descending());
                }
            } else {
                return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
            }
        }
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
    }
}
