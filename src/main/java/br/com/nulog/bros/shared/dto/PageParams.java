package br.com.nulog.bros.shared.dto;

public record PageParams(
        String search,
        int page,
        int size,
        String orderBy,
        String direction
) {
}
