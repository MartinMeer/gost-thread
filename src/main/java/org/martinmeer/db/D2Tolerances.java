package org.martinmeer.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.martinmeer.utils.PitchRanges;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class D2Tolerances {

    private Map<PitchRanges, Map<Double, List<Double>>> d2TolerancesMap;
}
