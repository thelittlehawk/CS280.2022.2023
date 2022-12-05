package ba.ssst.edu;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.IOException;
import java.nio.file.Paths;

public class Airbnb {
    private String text;
    private String id;

    public Airbnb(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String[] getLocations() {
        try {
            // This is a sentence written by Mike in Paris.
            // [ 'This', 'is', 'a', 'sentence', 'written', 'by', 'Mike', 'in', 'Paris', '.' ]
            // String text = "This is a sentence written by Mike in Paris.";
            TokenNameFinderModel model = new TokenNameFinderModel(Paths.get("en-ner-location.bin"));
            NameFinderME nameFinder = new NameFinderME(model);

            // Results
            String[] tokens = text.split("[ .]");
            Span[] elements = nameFinder.find(text.split("[ .]"));
            for (Span element : elements) {
                System.out.println(tokens[element.getStart()] + " - https://www.airbnb.com/rooms/" + this.id);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
