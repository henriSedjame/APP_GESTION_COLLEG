package com.shj.app.dao;

import java.util.List;

public interface Dao<T, S> {

    public T create( T t );

    public T update( T t );

    public T find( S s );

    public List<T> findAll();

    public boolean delete( T t );

}
