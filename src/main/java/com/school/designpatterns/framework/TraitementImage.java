package com.school.designpatterns.framework;

public class TraitementImage {
    private FilterStrategy filterStrategy;
    private Compressor compressor;

    public void setFilterStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public int[] filter(int[] data) {
        if (filterStrategy == null) {
            throw new IllegalStateException("Aucune stratégie de filtrage définie");
        }
        return filterStrategy.filter(data);
    }

    public int[] compresser(int[] data) {
        if (compressor == null) {
            throw new IllegalStateException("Aucun compresseur défini");
        }
        return compressor.compresser(data);
    }
}
