package uk.co.news.methode.automation.container;

import java.util.ArrayList;

public class ManifestModel {
	
	private ArrayList<ManifestEntry> data = new ArrayList<ManifestEntry>();

	public ArrayList<ManifestEntry> getData() {
		return data;
	}

	public void setData(ArrayList<ManifestEntry> data) {
		this.data = data;
	}
	
	public void addEntry(ManifestEntry entry) {
		System.out.println(data.size());
		if(data.size() == 20) {
			data.remove(data.size() - 1);
			data.add(0,entry);
		} else {
			data.add(0, entry);
		}
	}
}
