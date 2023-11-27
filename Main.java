/**
 * @requires lst != null && lst.size() > 0
 * 
 * @modifies lst
 * 
 * @effects removes all duplicates from lst
 * 
 * @throws NullPointerException if lst == null
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public static void removeDuplicates(List lst) {
        if (lst == null || lst.size() == 0) return;
        
        List copy = new ArrayList(lst);
        Iterator elements = copy.iterator();
        Object pre = elements.next();

        while(elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex)) lst.remove(nex);
            else pre = nex;
        }
    }
}