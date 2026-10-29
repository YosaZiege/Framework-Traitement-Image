package com.school.designpatterns.framework;

public abstract class Compressor {
    public final int[] compresser(int[] data) {
        verifier(data);
        int[] compressed = compresserDetail(data);
        System.out.println("Compression : " + data.length + " -> " + compressed.length + " éléments");
        return compressed;
    }

    private void verifier(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Données invalides");
        }
    }

    protected abstract int[] compresserDetail(int[] data);
}
