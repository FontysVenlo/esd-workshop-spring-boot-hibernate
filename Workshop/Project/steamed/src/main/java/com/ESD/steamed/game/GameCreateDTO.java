    package com.ESD.steamed.game;

    import lombok.Data;

    import java.math.BigDecimal;
    import java.time.LocalDate;

    @Data
    public class GameCreateDTO {

        private Long id;
        private String title;
        private String description;
        private BigDecimal price;
        private LocalDate releaseDate;
        private String developer;

        @Override
        public String toString() {
            return "GameCreateDTO{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", price=" + price +
                    ", releaseDate=" + releaseDate +
                    ", developer='" + developer + '\'' +
                    '}';
        }
    }
