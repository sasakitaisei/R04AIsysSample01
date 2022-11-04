package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Sentiments message = getSentiment("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println("positive：" + message.documents[0].confidenceScores.positive);
			System.out.println("neutral：" + message.documents[0].confidenceScores.neutral);
			System.out.println("negative：" + message.documents[0].confidenceScores.negative);
			
		}
	}

	static Sentiments getSentiment(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3a12-text.cognitiveservices.azure.com/"+"text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "c1aaf39fc0624ce3ac4ef1171392ec35");

		Docs2 doc = new Docs2();
		doc.id = "1";
		doc.text = s;
		doc.language="ja";

		Source2 src = new Source2();
		src.documents = new Docs2[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		//InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		//JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		JsonReader reader = WebApiConnector.postJsonReader(url, map, jsonData);
		Sentiments message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Sentiments.class);
			reader.close();
		}
		return message;
	}

}

class Sentiments {
	Documents2[] documents;
	String[] errors;
	String modelVersion;
}

class Documents2 {
	ConfidenceScores confidenceScores;
	
	String id;
	String[] warnings;
	
}

class ConfidenceScores {
	double positive;
	double neutral;
	double negative;
}

class Source2 {
	Docs2[] documents;
}

class Docs2 {
	String language;
	String id;
	String text;
}
