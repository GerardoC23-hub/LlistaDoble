# Implementación de Lista Doblemente Enlazada en Java

## Descripción del proyecto

Este proyecto consiste en la implementación de una **lista doblemente enlazada** utilizando el lenguaje de programación Java.

Una lista doblemente enlazada es una estructura de datos en la que cada nodo contiene un valor y dos referencias: una hacia el siguiente nodo y otra hacia el nodo anterior. Esto permite recorrer la lista en ambos sentidos, desde la cabeza hasta la cola y viceversa.

El objetivo de la actividad es implementar y comprobar diferentes operaciones de inserción y eliminación, manteniendo correctamente las referencias entre los nodos.

## Estructura del proyecto

El proyecto está organizado de la siguiente manera:

```text
listdouble/
├── nodoDoble.java
├── ListaDoble.java
└── Main.java
```

- **nodoDoble.java:** Define la estructura de cada nodo, incluyendo el valor y las referencias `siguiente` y `anterior`.
- **ListaDoble.java:** Contiene la implementación de la lista y sus operaciones.
- **Main.java:** Contiene las pruebas para demostrar el funcionamiento de los métodos solicitados.

## Atributos principales

La clase `ListaDoble` utiliza los siguientes atributos:

- `cabeza`: referencia al primer nodo de la lista.
- `cola`: referencia al último nodo de la lista.
- `tamanio`: contador que almacena la cantidad de elementos.

## Métodos implementados

Se desarrollaron los siguientes métodos:

| Método | Descripción |
|---|---|
| `insertarEnPosicion(int pos, int dato)` | Inserta un elemento en una posición específica. |
| `eliminar(int valor)` | Elimina el primer nodo que contiene el valor indicado. |
| `eliminarEnPosicion(int pos)` | Elimina el nodo ubicado en la posición indicada y devuelve su valor. |
| `eliminarFinal()` | Elimina el último nodo de la lista. |
| `insertarOrdenado(int valor)` | Inserta un elemento conservando el orden ascendente de los valores. |

También se implementaron métodos auxiliares para insertar al inicio y al final, buscar elementos, actualizar valores, obtener nodos, comprobar si la lista está vacía y mostrar su contenido.

## Consideraciones técnicas

Durante la implementación se tuvieron en cuenta los siguientes aspectos:

- Mantener correctamente las referencias `siguiente` y `anterior` de cada nodo.
- Actualizar las referencias `cabeza` y `cola` cuando se insertan o eliminan elementos.
- Actualizar el contador `tamanio` después de cada operación.
- Controlar los casos especiales, como listas vacías y listas con un solo elemento.
- Validar las posiciones para evitar acceder a nodos inexistentes.
- Permitir el recorrido de la lista en ambos sentidos.

## Pruebas realizadas

En la clase `Main` se desarrolló una batería de pruebas para comprobar los cinco métodos principales solicitados.

1. **Insertar en posición:** Se insertan elementos en diferentes posiciones de la lista.
2. **Eliminar por valor:** Se comprueba la eliminación de un elemento mediante su valor.
3. **Eliminar en posición:** Se elimina un nodo utilizando su posición.
4. **Eliminar último:** Se comprueba la eliminación del último elemento.
5. **Insertar ordenado:** Se insertan diferentes valores y se verifica que la lista conserve el orden ascendente.

En cada prueba se muestra el contenido de la lista y su tamaño para comprobar los resultados.

## Ejemplo de funcionamiento

Una lista después de insertar los valores ordenadamente puede representarse de la siguiente manera:

```text
NULL <- [5] <-> [15] <-> [35] <-> [60] -> NULL
```

El recorrido inverso permite visualizar los mismos elementos desde la cola hasta la cabeza.

## Tecnologías utilizadas

- Lenguaje: Java.
- Entorno de desarrollo: Apache NetBeans.
- Estructura de datos: Lista doblemente enlazada.


