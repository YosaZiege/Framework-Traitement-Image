package com.school.designpatterns.framework.filtres;

import com.school.designpatterns.framework.FilterStrategy;

public class FiltreSeuil implements FilterStrategy {
    private final int seuil;

    public FiltreSeuil() {
        this(127);
    }

    public FiltreSeuil(int seuil) {
        this.seuil = seuil;
    }

    @Override
    public int[] filter(int[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] > seuil ? 255 : 0;
        }
        return result;
    }
}
