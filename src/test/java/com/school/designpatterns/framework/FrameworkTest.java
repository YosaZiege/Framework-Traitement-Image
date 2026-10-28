package com.school.designpatterns.framework;

import com.school.designpatterns.framework.compression.CompressionRle;
import com.school.designpatterns.framework.compression.CompressionSimple;
import com.school.designpatterns.framework.filtres.FiltreInversion;
import com.school.designpatterns.framework.filtres.FiltreSeuil;
import com.school.designpatterns.framework.filtres.ImplNonStandard;
import com.school.designpatterns.framework.filtres.NonStandardAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FrameworkTest {

    @Test
    void filtreInversionInverseLesValeurs() {
        FilterStrategy f = new FiltreInversion();
        assertArrayEquals(new int[]{255, 0, 245}, f.filter(new int[]{0, 255, 10}));
    }

    @Test
    void filtreSeuilBinarise() {
        FilterStrategy f = new FiltreSeuil();
        assertArrayEquals(new int[]{0, 255}, f.filter(new int[]{50, 200}));
    }

    @Test
    void adaptateurDelegueAImplNonStandard() {
        NonStandardAdapter adapter = new NonStandardAdapter(new ImplNonStandard(), "test");
        assertArrayEquals(new int[]{3, 2, 1}, adapter.filter(new int[]{1, 2, 3}));
    }

    @Test
    void compressionRleCompresse() {
        Compressor c = new CompressionRle();
        assertArrayEquals(new int[]{3, 1, 2, 2}, c.compresser(new int[]{1, 1, 1, 2, 2}));
    }

    @Test
    void compressionSimpleCopie() {
        Compressor c = new CompressionSimple();
        assertArrayEquals(new int[]{1, 2, 3}, c.compresser(new int[]{1, 2, 3}));
    }

    @Test
    void traitementImageDelegueFiltreEtCompression() {
        TraitementImage t = new TraitementImage();
        t.setFilterStrategy(data -> new int[]{0});
        t.setCompressor(new CompressionSimple());
        assertArrayEquals(new int[]{0}, t.filter(new int[]{1}));
        assertArrayEquals(new int[]{5}, t.compresser(new int[]{5}));
    }

    @Test
    void traitementImageRejetteSansStrategie() {
        TraitementImage t = new TraitementImage();
        assertThrows(IllegalStateException.class, () -> t.filter(new int[]{1}));
        assertThrows(IllegalStateException.class, () -> t.compresser(new int[]{1}));
    }
}
