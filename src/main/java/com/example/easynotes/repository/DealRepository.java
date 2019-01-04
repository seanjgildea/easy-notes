package com.example.easynotes.repository;

import com.example.easynotes.model.Deal;

import java.util.List;

public interface DealRepository {

    public List<Deal> findByTitleContaining(String title);
    public List<Deal> findAllByOrderByPriceAsc();
    public List<Deal> findAllByOrderByCreateDateDesc();
    public List<Deal> findAllByOrderByCategoryAsc();
    public List<Deal> findAllByOrderByTitleAsc();
}
