package org.martinmeer;

import java.io.IOException;
import java.util.Map;

public interface DataMap<M> {
    Map getDataMap() throws IOException;
}
