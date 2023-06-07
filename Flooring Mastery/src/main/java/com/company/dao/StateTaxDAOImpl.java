package com.company.dao;

import com.company.entity.StateTax;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StateTaxDAOImpl implements StateTaxDAO {
    private final String TAXES_FILE = "src/main/resources/data/Taxes.txt";

    @Override
    public List<StateTax> readTaxes() throws Exception {
        List<StateTax> taxes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TAXES_FILE))) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                StateTax tax = new StateTax();
                tax.setStateCode(fields[0]);
                tax.setStateName(fields[1]);
                tax.setStateRate(Double.parseDouble(fields[2]));
                taxes.add(tax);
            }
        }

        return taxes;
    }


}
