package com.shj.app.entities;

public enum Civilite {
	
	MR("Monsieur"), MME("Madame"), MLLE("Mademoiselle");
	private String label;

	private Civilite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
