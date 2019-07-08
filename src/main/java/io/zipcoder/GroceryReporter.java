package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;

import javax.management.ListenerNotFoundException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class GroceryReporter {

    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }


public String bread() {
        return null;
}

    @Override
    public String toString() {
        String groceryList = "";
        ItemParser parser = new ItemParser();
        List<Item> items = parser.parseItemList(originalFileText);
        Map<String, List<Double>> freq = mapFrequencies(items);
        for(Map.Entry<String, List<Double>> entry : freq.entrySet()) {
            groceryList += formatItem(entry.getKey(), entry.getValue());

        }
        return null;
    }


    public String capString(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String formatItem(String itemName, List<Double> freq) {
        String format = "";
        format += String.format("name:%8s \t\t seen:%2d %s", capString(itemName),
        freq.size(), times(freq.size())) + '\n' + "============ \t\t =============\n";
        return format;
    }

    public String formatPrice(List<Double> price) {
        return String.format("Price:%7.2f \t\t seen:%2d %s", price.get(0), price.size(),times(price.size()))
                + '\n' + "------------- \t\t -------------\n";
    }

//    public String formatMorePrices(List<Double> price) {
//        String format = "";
//        int counter =0;
//        Map<Double, Integer> priceAppearance = mapPricefreq(price);
//        for(Map.Entry<Double, Integer> entry: priceAppearance.entrySet()) {
//
//            counter++;
//            format += String.format("Price:%7.2f \t\t seen:2d %s\n", entry.getKey(), entry.getValue(), times(entry.getValue()));
//            if(counter != priceAppearance.entrySet().size()) {
//                format += "------------- \t\t -------------\n";
//            }
//        }
//        return format;
//    }

//    public Map<Double, Integer> mapPricefreq(List<Double> prices) {
//        Map<Double, Integer> priceAppearance = new LinkedHashMap<>();
//        for(Double price : prices) {
//            if(priceAppearance.containsKey(price)) {
//                Integer freq = priceAppearance.get(price);
//                priceAppearance.put(price, freq + 1);
//            }
//            else {
//                priceAppearance.put(price, 1);
//            }
//        }
//        return priceAppearance;
//    }

    public String times(int j) {
        if(j == 1) {
            return "time";
        }
        else{
            return "time";
        }
    }

    public Map<String, List<Double>> mapFrequencies(List<Item> items) {
        Map<String, List<Double>> freq = new LinkedHashMap<>();

        for(Item item: items) {
            String itemName = item.getName();
            if(freq.containsKey(itemName)) {
                List<Double> prices = freq.get(itemName);
                prices.add(item.getPrice());
                freq.put(itemName, prices);
            }
        }
        return freq;
    }
}
