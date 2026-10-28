package com.school.designpatterns.framework;

import com.school.designpatterns.framework.filtres.ImplNonStandard;
import com.school.designpatterns.framework.filtres.NonStandardAdapter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] data = {10, 10, 10, 200, 200, 50};
        TraitementImage traitement = new TraitementImage();

        NonStandardAdapter adapter = new NonStandardAdapter(new ImplNonStandard(), "inversionLegacy");
        traitement.setFilterStrategy(adapter);
        print("Filtre (ImplNonStandard via adaptateur)", traitement.filter(data));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom de la classe de filtrage : ");
        String filterClassName = scanner.nextLine();
        FilterStrategy filter = (FilterStrategy) instancier(filterClassName);
        traitement.setFilterStrategy(filter);
        print("Après filtrage", traitement.filter(data));

        System.out.print("Nom de la classe de compression : ");
        String compressorClassName = scanner.nextLine();
        Compressor compressor = (Compressor) instancier(compressorClassName);
        traitement.setCompressor(compressor);
        print("Après compression", traitement.compresser(data));
    }

    private static Object instancier(String className) {
        try {
            return Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Impossible d'instancier " + className, e);
        }
    }

    private static void print(String label, int[] data) {
        System.out.print(label + " : [");
        for (int i = 0; i < data.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println("]");
    }
}
