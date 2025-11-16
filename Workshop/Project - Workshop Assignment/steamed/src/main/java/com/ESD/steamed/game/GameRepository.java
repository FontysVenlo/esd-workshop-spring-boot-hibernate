package com.ESD.steamed.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/*
* Because this Repository implements JpaRepository we get access to the most common functionality we want when dealing with databases.
* Examples:
    findById(Long id) -> returns an entity with the specified Id 
    Just type gameRepository within your interface and then hit "." it will give you autocompletion of all the common methods with explainations.
* */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    /*
     * TODO: Write a JPA derived query method which returns a list of games with a lower price than the parameter 'price'.
     *
     * How to write JPA derived queries:
     * 1. The Method name determines what the method actually does. And they all start with 'findBy'.
     * 2. You can access fields of entities if you specify the exact name : (price)
     * 3. Add a keyword describing the condition (here: 'LessThan')
     * 
     * Some Examples: 
     * 1. Find all games with a title containing some text (case-insensitive):
     *    - findBy + Title + Containing + IgnoreCase
     *    Example:
     *    List<Game> findByTitleContainingIgnoreCase(String text);
     *
     * 2. Find all games released after a certain date and developed by a specific studio:
     *    - findBy + ReleaseDate + After + And + Developer
     *    Example:
     *    List<Game> findByReleaseDateAfterAndDeveloper(LocalDate date, String developer);
     */
}
