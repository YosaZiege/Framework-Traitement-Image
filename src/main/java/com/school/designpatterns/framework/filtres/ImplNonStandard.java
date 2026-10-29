package com.school.designpatterns.framework.filtres;

public class ImplNonStandard {
    public int[] appliquerFiltre(String filterName, int[] data) {
        System.out.println("ImplNonStandard.appliquerFiltre : " + filterName);
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[data.length - 1 - i];
        }
        return result;
    }
}
