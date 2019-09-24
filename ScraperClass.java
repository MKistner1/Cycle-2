package WebScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperClass {
	//function to retrieve all names from the table on the URL
	static String[] getNames() {
		final String url =
                "https://www.cryptocurrencychart.com/top/100";
		String[] names = new String[27];
        int i = 0;
        try {
            final Document document = Jsoup.connect(url).get();
            Elements tableHTML = document.select("table.market-cap-list tr");
            for (Element row : tableHTML) {
            	if(row.select("td.name").text()== "") {
            		continue;
            	}
            	else {
                  final String name = row.select("td.name").text() ;
                  names[i]=name;
                  i++;
            	}
        }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return names;
	}
	//function to retrieve all prices from the table on the URL
	static String[] getPrices() {
		final String url =
                "https://www.cryptocurrencychart.com/top/100";
		String[] prices = new String[27];
        int i = 0;
        try {
            final Document document = Jsoup.connect(url).get();
            Elements tableHTML = document.select("table.market-cap-list tr");
            for (Element row : tableHTML) {
            	if(row.select("td.name").text()== "") {
            		continue;
            	}
            	else {
                  final String price = row.select("td.price").text();
                  String temp = price.replace(",", "");
                  temp = temp.replace("$", "");
                  prices[i]=temp;
                  i++;
            	}
        }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		return prices;
	}
	//function that takes in the total amount of a cryptocurrency and the price of the selected cryptocurrency to calculate the total value of
	//the amount inputed
	static Double calculateValue(Double amount, Double price) {

			return amount*price;

		}
	//function that loops through the list of names to find the one you are looking for and returns the name of the crypto you seleceted
	static String pickName(String[] names, String[] prices, String crypto) {
		String temp= "";
		String n = "";
		for (int i=0;i<names.length;i++) {
			temp = names[i].toString();
		if(temp.contains(crypto)) {
			n = names[i];
		}

	}
		return n;

	}
	//function that takes the selected name and finds the price value associated with that name and returns the price
	static String pickPrice(String[] names, String[] prices, String crypto) {
		String temp= "";
		String n = "";
		for (int i=0;i<names.length;i++) {
			temp = names[i].toString();
		if(temp.contains(crypto)) {
			n = prices[i].toString();
		}

	}
		return n;

	}
}
