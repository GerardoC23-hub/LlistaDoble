package listdouble;
/**
 *
 * @author gerardo cruz hernández
 */
public class ListaDoble {
    private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola;

    public ListaDoble()
    {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }

    public int getTamanio() {
        return tamanio;
    }

    // Verifica si la lista no contiene nodos
    public boolean estaVacia()
    {
        if(cabeza == null && cola == null)
            return true;
        return false;
    }

    public void insertarInicio(int valor)
    {
        nodoDoble nuevo = new nodoDoble(valor);

        if(estaVacia())
        {
            cola = nuevo; // El nuevo nodo también será el último
        }
        else
        {
            nuevo.setSiguiente(cabeza); // Conecta el nuevo con la cabeza actual
            cabeza.setAnterior(nuevo); // Actualiza el anterior de la cabeza
        }

        cabeza = nuevo; // Actualiza la cabeza
        tamanio++;
    }

    public void insertarFinal(int valor)
    {
        // Si está vacía, reutiliza insertarInicio
        if(estaVacia())
        {
            insertarInicio(valor);
            return;
        }

        nodoDoble nuevo = new nodoDoble(valor);

        cola.setSiguiente(nuevo); // Conecta la última posición con el nuevo nodo
        nuevo.setAnterior(cola); // Conecta el nuevo nodo con la cola actual
        cola = nuevo; // Actualiza la cola

        tamanio++;
    }

    public void insertarEnPosicion(int pos, int valor)
    {
        // Verifica que la posición esté dentro del rango permitido
        if(pos <= 0 || pos > tamanio + 1)
        {
            throw new IllegalStateException(
                "Posicion no valida: " + pos +
                ". Rango valido del 1 al " + (tamanio + 1)
            );
        }

        // Si la posición es 1, inserta al inicio
        if(pos == 1)
        {
            insertarInicio(valor);
            return;
        }

        // Obtiene el nodo que estará antes del nuevo
        nodoDoble anterior = obtenerNodo(pos - 1);
        nodoDoble nuevo = new nodoDoble(valor);

        // Conecta el nuevo nodo con sus dos vecinos
        nuevo.setSiguiente(anterior.getSiguiente());
        nuevo.setAnterior(anterior);

        // Actualiza el anterior del siguiente nodo
        if(anterior.getSiguiente() != null)
        {
            anterior.getSiguiente().setAnterior(nuevo);
        }
        else
        {
            cola = nuevo; // El nuevo nodo será la última posición
        }

        anterior.setSiguiente(nuevo); // Conecta el nodo anterior con el nuevo

        tamanio++;
    }

    public void insertarOrdenado(int valor)
    {
        // Si está vacía, inserta el primer nodo
        if(estaVacia()) {
            insertarInicio(valor);
            return;
        }

        // Si el valor es menor o igual que la cabeza, inserta al inicio
        if(valor <= cabeza.getValor()) {
            insertarInicio(valor);
            return;
        }

        // Si el valor es mayor o igual que la cola, inserta al final
        if(valor >= cola.getValor()) {
            insertarFinal(valor);
            return;
        }

        nodoDoble aux = cabeza; // Comienza el recorrido desde la cabeza

        // Recorre mientras exista un siguiente nodo
        while(aux.getSiguiente() != null) {

            // Comprueba si el valor debe insertarse antes del siguiente nodo
            if(valor <= aux.getSiguiente().getValor()) {
                nodoDoble nuevo = new nodoDoble(valor);

                // Conecta el nuevo nodo con sus vecinos
                nuevo.setSiguiente(aux.getSiguiente());
                nuevo.setAnterior(aux);

                // Actualiza las referencias de los nodos vecinos
                aux.getSiguiente().setAnterior(nuevo);
                aux.setSiguiente(nuevo);

                tamanio++;
                return;
            }

            aux = aux.getSiguiente(); // Avanza al siguiente nodo
        }
    }

    public double eliminarEnPosicion(int pos)
    {
        // Verifica que la posición exista en la lista
        if(pos <= 0 || pos > tamanio)
        {
            throw new IllegalStateException(
                "Posicion no valida: " + pos +
                " Rango valido del 1 al " + tamanio
            );
        }

        // Si es la primera posición, reutiliza eliminarInicio
        if(pos == 1)
        {
            return eliminarInicio();
        }

        // Obtiene el nodo anterior al que se eliminará
        nodoDoble aux = obtenerNodo(pos - 1);
        nodoDoble objetivo = aux.getSiguiente();

        double res = objetivo.getValor(); // Guarda el valor antes de eliminarlo

        aux.setSiguiente(objetivo.getSiguiente()); // Reconecta con el siguiente nodo

        // Actualiza el anterior del siguiente nodo
        if(objetivo.getSiguiente() != null)
        {
            objetivo.getSiguiente().setAnterior(aux);
        }
        else
        {
            cola = aux; // El anterior se convierte en la nueva cola
        }

        // Desconecta el nodo eliminado de la lista
        objetivo.setAnterior(null);
        objetivo.setSiguiente(null);

        tamanio--;

        return res;
    }

    public double eliminarInicio()
    {
        // No permite eliminar cuando la lista está vacía
        if(estaVacia())
        {
            throw new IllegalStateException("La lista esta vacia...");
        }

        double res = cabeza.getValor(); // Guarda el valor de la cabeza

        // Si solo existe un nodo, ambos extremos quedan vacíos
        if(cabeza == cola)
        {
            cabeza = null;
            cola = null;
        }
        else
        {
            cabeza = cabeza.getSiguiente(); // Avanza la cabeza al siguiente nodo
            cabeza.getAnterior().setSiguiente(null); // Desconecta la cabeza anterior
            cabeza.setAnterior(null); // La nueva cabeza ya no tiene anterior
        }

        tamanio--;
        return res;
    }

    public boolean eliminarFinal()
    {
        // No permite eliminar cuando la lista está vacía
        if(estaVacia())
        {
            throw new IllegalStateException("La lista esta vacia...");
        }

        // Si solo existe un nodo, ambos extremos quedan vacíos
        if(cabeza == cola)
        {
            cabeza = null;
            cola = null;
        }
        else
        {
            cola = cola.getAnterior(); // Retrocede la cola al nodo anterior
            cola.getSiguiente().setAnterior(null); // Desconecta la cola anterior
            cola.setSiguiente(null); // La nueva cola ya no tiene siguiente
        }

        tamanio--;
        return true;
    }

    public boolean eliminar(int valor)
    {
        // Si está vacía, no hay elementos que eliminar
        if(estaVacia())
        {
            return false;
        }

        // Si el valor está en la cabeza, reutiliza eliminarInicio
        if(cabeza.getValor() == valor)
        {
            eliminarInicio();
            return true;
        }

        nodoDoble aux = cabeza; // Nodo anterior al que se está revisando
        nodoDoble actual = cabeza.getSiguiente(); // Nodo que se está revisando

        // Recorre hasta encontrar el valor o llegar al final
        while(actual != null)
        {
            if(actual.getValor() == valor)
            {
                // Si está en la cola, reutiliza eliminarFinal
                if(actual == cola)
                {
                    eliminarFinal();
                }
                else
                {
                    // Reconecta los nodos que están antes y después
                    aux.setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(aux);

                    // Desconecta el nodo eliminado
                    actual.setAnterior(null);
                    actual.setSiguiente(null);

                    tamanio--;
                }

                return true;
            }

            aux = actual; // El actual pasa a ser el anterior
            actual = actual.getSiguiente(); // Avanza al siguiente nodo
        }

        return false; // El valor no se encontró
    }

    public boolean buscar(int valor)
    {
        nodoDoble aux = cabeza; // Comienza desde el primer nodo

        while(aux != null)
        {
            if(aux.getValor() == valor)
            {
                return true; // El valor fue encontrado
            }

            aux = aux.getSiguiente(); // Avanza al siguiente nodo
        }

        return false; // Terminó el recorrido sin encontrarlo
    }

    public nodoDoble obtenerNodo(int pos)
    {
        // Verifica que la posición exista
        if(pos <= 0 || pos > tamanio)
        {
            throw new IllegalStateException(
                "posicion no valida: " + pos +
                "Rango validp del 1 al " + tamanio
            );
        }

        nodoDoble aux = cabeza; // Comienza desde la cabeza

        // Avanza hasta llegar a la posición solicitada
        for(int i = 1; i < pos; i++)
        {
            aux = aux.getSiguiente();
        }

        return aux;
    }

    public void actualizar(int pos, int dato)
    {
        // Obtiene el nodo de la posición indicada
        nodoDoble referencia = obtenerNodo(pos);

        referencia.setValor(dato); // Reemplaza su valor
    }

    public String toString()
    {
        String respuesta = "NULL";
        nodoDoble aux = cabeza; // Comienza desde el primer nodo

        // Recorre la lista para construir su representación
        while(aux != null)
        {
            respuesta = respuesta + "<-" + "[" + aux.getValor() + "]->";
            aux = aux.getSiguiente();
        }

        respuesta = respuesta + "NULL";
        return respuesta;
    }
    public String toStringInverso()
    {
        String respuesta = "NULL";
        nodoDoble aux = cola; // Comienza desde el último nodo

        // Recorre la lista utilizando las referencias anteriores
        while(aux != null)
        {
            respuesta = respuesta + "<-[" + aux.getValor() + "]->";
            aux = aux.getAnterior();
        }

        respuesta = respuesta + "NULL";
        return respuesta;
    }
}
