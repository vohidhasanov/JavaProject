package JavaConcepts.GenericsErasure;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.Locale;

public class Ex <E,K> {
    E itSize;
    E itWidth;
    K itHeight;

    public Ex(E itSize, E itWidth, K itHeight) {
        this.itSize = itSize;
        this.itWidth = itWidth;
        this.itHeight = itHeight;
    }

    public static <T> int countAll (T[]list, T item) {
        int count =0;
        if (item==null) {
            for (T listItem : list) {
                if (listItem == null)
                    count++;
            }
            }
            else {
                for (T listItem: list)
                    if (item.equals(listItem))
                        count++;
            }

        return count;


    }

    public static void main(String[] args) {

        String[] str = new String[3];
        str[0]="ali";
        str [1]="hello";
        str[2] = "world";

        System.out.println(countAll(str, "int"));

        Integer [] integers = new Integer[3];
        integers[0]=10;
        integers[1]=20;
        integers[2]=30;

        System.out.println(countAll(integers, integers[0]));

        Locale locale = Locale.UK;
        Collator collator = Collator.getInstance(locale );
        int result = collator.compare("A", "B");


        String rules = "<b<a";
        RuleBasedCollator ruleBasedCollator = null;
        try {
            ruleBasedCollator = new RuleBasedCollator(rules);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result1 = ruleBasedCollator.compare("a", "b");
        System.out.println(result1);

        


        try {
            Comparator<? super String> cmp = new RuleBasedCollator(new String("a"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
