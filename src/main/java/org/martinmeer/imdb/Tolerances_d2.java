package org.martinmeer.imdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.martinmeer.utils.PitchRanges;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Tolerances_d2 {

    private Map<PitchRanges, Map<Number, List<Number>>> d2_TolerancesMap;
}
