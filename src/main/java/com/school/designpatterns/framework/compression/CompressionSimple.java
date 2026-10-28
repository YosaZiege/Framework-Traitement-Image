package com.school.designpatterns.framework.compression;

import com.school.designpatterns.framework.Compressor;

public class CompressionSimple extends Compressor {
    @Override
    protected int[] compresserDetail(int[] data) {
        return data.clone();
    }
}
