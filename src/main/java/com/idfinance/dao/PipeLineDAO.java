package com.idfinance.dao;

import java.util.List;

import com.idfinance.model.Pipeline;

public interface PipeLineDAO {

	void createPipeLine(Pipeline pipeline);

	void deletePipeLine(Pipeline pipeline);

	Pipeline getPipeLineById(int id);

	List<Pipeline> getAllPipeLine();

}
