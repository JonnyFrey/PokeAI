package com.waffel.pokeai.database.query;

import com.waffel.pokeai.exceptions.PokeAiRuntimeException;
import com.waffel.pokeai.models.pokemon.Pokemon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jonny on 7/3/2017.
 */
public class PokemonQuery implements Query<Pokemon> {

    @Override
    public String getQuery() {
        return "SELECT * FROM pokemon";
    }

    @Override
    public void setParameters(PreparedStatement statement) throws SQLException {
        //no parameters required
    }

    @Override
    public Pokemon buildFromResultSet(ResultSet resultSet) {
        try {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(resultSet.getInt("id"));
            pokemon.setName(resultSet.getString("identifier"));
            pokemon.setSpeciesId(resultSet.getInt("species_id"));
            pokemon.setHeight(resultSet.getInt("height"));
            pokemon.setWeight(resultSet.getInt("weight"));
            pokemon.setBaseExperience(resultSet.getInt("base_experience"));
            pokemon.setOrder(resultSet.getInt("order"));
            pokemon.setSpecialForm(!resultSet.getBoolean("is_default"));
            return pokemon;
        } catch (final Exception e) {
            throw new PokeAiRuntimeException("Failed to build Pokemon from result set", e);
        }
    }
}
