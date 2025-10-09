package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {

        List<Integer> lista = new ArrayList<>();

        while (it.hasNext()) {
            lista.add(it.next());
        }

        Set<Integer> resultado = new HashSet<>();

        for (int i = 0; i < lista.size(); i++) {

            int x = lista.get(i);
            if (x == 0) continue;

            for (int j = 0; j < lista.size(); j++) {

                if (i == j) continue;
                int y = lista.get(j);
                if (y == 0) continue;

                if (x % y == 0) {
                    resultado.add(x);
                    break;
                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {

        Set<Integer> conjuntoAux = new HashSet<>();

        conjuntoAux.addAll(cuadrados);
        conjuntoAux.addAll(noCuadrados);

        Set<Integer> cuadradosFinal = new HashSet<>();
        Set<Integer> noCuadradosFinal = new HashSet<>();

        for (Integer n : conjuntoAux) {

            double raizCuadrada = Math.sqrt(n);
            int raizInt = (int) raizCuadrada;
            boolean cuadradoValido = false;

            if (raizCuadrada == raizInt) {
                if (n == raizInt) {
                    if (cuadrados.contains(raizInt) && noCuadrados.contains(raizInt))
                        cuadradoValido = true;
                } else {
                    if (conjuntoAux.contains(raizInt))
                        cuadradoValido = true;
                }
            }

            if (cuadradoValido)
                cuadradosFinal.add(n);
            else
                noCuadradosFinal.add(n);
        }

        cuadrados.clear();
        noCuadrados.clear();

        cuadrados.addAll(cuadradosFinal);
        noCuadrados.addAll(noCuadradosFinal);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {

        Collection<Set<T>> coleccion = new ArrayList<>();

        while (it.hasNext()) {
            T n = it.next();
            boolean esAñadido = false;

            for (Set<T> conjunto : coleccion) {
                if (!conjunto.contains(n)){
                    conjunto.add(n);
                    esAñadido = true;
                    break;
                }
            }

            if (!esAñadido) {
                Set<T> nuevoConjunto = new HashSet<>();
                nuevoConjunto.add(n);
                coleccion.add(nuevoConjunto);
            }
        }

        return coleccion;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {

        for (int i = 0; i < col.size(); i++) {
            for (int j = i + 1; j < col.size(); j++) {

                Set<T> set1 = col.get(i);
                Set<T> set2 = col.get(j);

                if (set1.equals(u) || set2.equals(u)) {
                    continue;
                }

                Set<T> union = new HashSet<>(set1);
                union.addAll(set2);

                if (union.equals(u)) {
                    Collection<Set<T>> resultado = new LinkedHashSet<>();
                    resultado.add(set1);
                    resultado.add(set2);

                    return resultado;
                }
            }
        }
        return new LinkedHashSet<>();
    }
}
