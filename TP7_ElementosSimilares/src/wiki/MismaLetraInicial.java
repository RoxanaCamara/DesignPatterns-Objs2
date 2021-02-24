package wiki;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MismaLetraInicial implements WikipediaPage{
	
	private String title;
	private List<WikipediaPage> links = new ArrayList<WikipediaPage>();

	@Override
	public String getTitle() {	
		return title;
	}

	@Override
	public List<WikipediaPage> getLinks() {
		return links;
	}

	@Override
	public Map<String, WikipediaPage> getInfobox() {
		return null;
	}

}
