package com.school.designpatterns.framework.compression;

import com.school.designpatterns.framework.Compressor;

import java.util.ArrayList;
import java.util.List;

public class CompressionRle extends Compressor {
    @Override
    protected int[] compresserDetail(int[] data) {
        List<Integer> result = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < data.length; i++) {
            if (data[i] == data[i - 1]) {
                count++;
            } else {
                result.add(count);
                result.add(data[i - 1]);
                count = 1;
            }
        }
        result.add(count);
        result.add(data[data.length - 1]);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
