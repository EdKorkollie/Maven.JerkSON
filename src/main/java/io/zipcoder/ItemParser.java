package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private int exceptionCount;
    public ItemParser() {

        this.exceptionCount=0;
    }

    public List<Item> parseItemList(String valueToParse) {
        String[] array = valueToParse.split("##");
        List<Item> items = new ArrayList<>();

        for(int i=0; i<array.length; i++) {
            try{
                items.add(parseSingleItem(array[i]));
            }catch (Exception e) {
                exceptionCount++;
                System.out.println("Item list was not added to list (not valid).");
            }
        }

        return items;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String pattern ="(\\w+) [*:,@^%!](\\w+)[*:,@^%!](\\w+)[*:,@^%!](\\d.{3,4})[*:,@^%!](\\w+)[*:,@^%!](\\w+)" +
                "[*:,@^%!](\\w+)[*:,@^%!](\\d{1,2}/\\d{1,2}/\\d{4}).*";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(singleItem);

        try{
            matcher.matches();
            String name = matcher.group(2).toLowerCase();
            if(name.contains("0")) {
                name = name.replace('0', 'o');
            }
            Double price = Double.valueOf(matcher.group(4));
            String string = matcher.group(6).toLowerCase();
            String expireDate = matcher.group(8);
            return new Item(name, price, string,expireDate);

        }catch (Exception e) {
            throw new ItemParseException();
        }

    }
    public String converzeroTOO(String str) {
        return str.replace('0', 'o');
    }
}
