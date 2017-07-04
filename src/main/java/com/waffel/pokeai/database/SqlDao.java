package com.waffel.pokeai.database;

import com.waffel.pokeai.database.query.Query;

import java.util.List;

/**
 * Created by Jonny on 7/3/2017.
 */
@FunctionalInterface
public interface SqlDao {

    <T> List<T> getObjectsBySearch(final Query<T> query);

}
