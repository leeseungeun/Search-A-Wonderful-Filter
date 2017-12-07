package com.SWF.search.dto;

import java.util.List;

public class ResultDTO {
	
	private double modelAccuracy;
	private List<SearchDTO> labeledResult;
	
	public double getModelAccuracy() {
		return modelAccuracy;
	}
	public void setModelAccuracy(double modelAccuracy) {
		this.modelAccuracy = modelAccuracy;
	}
	public List<SearchDTO> getLabeledResult() {
		return labeledResult;
	}
	public void setLabeledResult(List<SearchDTO> labeledResult) {
		this.labeledResult = labeledResult;
	}
	
	@Override
	public String toString() {
		return "ResultDTO [modelAccuracy=" + modelAccuracy + ", labeledResult=" + labeledResult + "]";
	}
	
}
