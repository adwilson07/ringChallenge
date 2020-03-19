package org.test.project.dao;

import org.test.project.model.Virus;

import java.util.List;

public interface VirusDao {

    Virus findByName(String name);

    List<Virus> findAll();

}