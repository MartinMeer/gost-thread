package org.martinmeer.AuxClasses;

import java.io.IOException;
import java.util.Map;

public interface DataMap<K, V> {
    Map<K, V> getDataMap() throws IOException;
}
