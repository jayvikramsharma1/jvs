package uk.co.news.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import uk.co.news.main.MainApp;

public class TestFileExplorer {
	public static Map<String, List<CheckBox>>getTabletFiles(String location) {
		Map<String, List<CheckBox>> fileLists = new HashMap<String, List<CheckBox>>();
		File tabletFolder = new File(location);
		List<CheckBox> ttIrishTablet = new ArrayList<CheckBox>();
		List<CheckBox> ttNationalTablet = new ArrayList<CheckBox>();
		List<CheckBox> stIrishTablet = new ArrayList<CheckBox>();
		List<CheckBox> stNationalTablet = new ArrayList<CheckBox>();
		for(File tabletFiles : tabletFolder.listFiles()) {
			if(tabletFiles.getName().startsWith("irish")){
				ttIrishTablet.add(new CheckBox(tabletFiles.getName().replaceAll(".xml", "")));
			}
			else if(tabletFiles.getName().startsWith("st_irish")) {
				stIrishTablet.add(new CheckBox(tabletFiles.getName().replaceAll(".xml", "")));
			}
			else if((tabletFiles.getName().startsWith("st")) && (!tabletFiles.getName().contains("irish"))) {
				stNationalTablet.add(new CheckBox(tabletFiles.getName().replaceAll(".xml", "")));
			}
			else if((!tabletFiles.getName().startsWith("st")) && (!tabletFiles.getName().contains("irish"))){
				ttNationalTablet.add(new CheckBox(tabletFiles.getName().replaceAll(".xml", "")));
			}
		}
		
		fileLists.put("ttIrishTablet", ttIrishTablet);
		fileLists.put("ttNationalTablet", ttNationalTablet);
		fileLists.put("stIrishTablet", stIrishTablet);
		fileLists.put("stNationalTablet", stNationalTablet);
		return fileLists;
	}
	/*public static void main(String[] args) {
		TestFileExplorer test = new TestFileExplorer();
		Map<String, List<CheckBox>> fileLists = test.getTabletFiles(Main.configProperties.getProperty("base.autocam.dir")+"/testcases/tablet/");
		System.out.println(fileLists);
	}*/
}
 