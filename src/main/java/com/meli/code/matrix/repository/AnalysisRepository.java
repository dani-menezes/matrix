package com.meli.code.matrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.meli.code.matrix.model.Analysis;


@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, String>, JpaSpecificationExecutor<Analysis> {

}
