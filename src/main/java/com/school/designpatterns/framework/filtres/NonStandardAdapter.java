package com.school.designpatterns.framework.filtres;

import com.school.designpatterns.framework.FilterStrategy;

public class NonStandardAdapter implements FilterStrategy {
    private final ImplNonStandard implNonStandard;
    private final String filterName;

    public NonStandardAdapter(ImplNonStandard implNonStandard, String filterName) {
        this.implNonStandard = implNonStandard;
        this.filterName = filterName;
    }

    @Override
    public int[] filter(int[] data) {
        return implNonStandard.appliquerFiltre(filterName, data);
    }
}
