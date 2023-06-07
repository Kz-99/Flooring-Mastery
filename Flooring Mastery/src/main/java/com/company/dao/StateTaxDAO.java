package com.company.dao;

import com.company.entity.StateTax;

import java.util.List;

public interface StateTaxDAO {

    List<StateTax> readTaxes() throws Exception;
}
