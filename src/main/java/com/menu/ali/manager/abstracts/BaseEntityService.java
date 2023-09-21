package com.menu.ali.manager.abstracts;


import com.menu.ali.core.results.DataResult;
import com.menu.ali.core.results.Result;

import java.util.List;

public interface BaseEntityService<T> {
    Result add(T entity);

    Result update(T entity);

    Result delete(int id);

    DataResult<List<T>> getAll();

    DataResult<T> getById(int id);

}
