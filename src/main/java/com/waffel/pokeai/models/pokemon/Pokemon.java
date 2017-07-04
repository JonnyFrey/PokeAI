package com.waffel.pokeai.models.pokemon;

import lombok.Data;

@Data
public class Pokemon implements Classified, Comparable<Pokemon> {

    private int id;
    private String name;
    private int speciesId;
    private int order;

    private int height;
    private int weight;

    private int baseExperience;
    private boolean specialForm;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(final Pokemon o) {
        return Integer.compare(this.getOrder(), o.getOrder());
    }
}
