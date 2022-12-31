package com.driver;

import java.util.Comparator;

public class Key {

    int freq; // store frequency of character
    char ch;
    Key(int val, char c)
    {
        freq = val;
        ch = c;
    }
}

class KeyComparator implements Comparator<Key> {

    // Overriding compare()method of Comparator
    public int compare(Key k1, Key k2)
    {
        if (k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        return 0;
    }
}

