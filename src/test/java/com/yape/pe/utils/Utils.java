package com.yape.pe.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Utils {

  public Utils() {
  }

  public static <K, V> Map removeNulls(Map<K, V> map) {
    Map<K, V> mapFiltered = new HashMap<>();
    Iterator<Entry<K, V>> itr = map.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry<K, V> currentItem = itr.next();
      if (currentItem.getValue() != null) {
        mapFiltered.put(currentItem.getKey(), currentItem.getValue());
      }
    }
    return mapFiltered;
  }
}
