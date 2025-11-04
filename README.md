# Programación Modular en Java: Simulación de Máquina Expendedora

Este proyecto demuestra los conceptos fundamentales de la programación modular utilizando un enfoque estructurado/procedural en Java, sin usar conceptos de Programación Orientada a Objetos (POO).

## Descripción del Proyecto

La simulación de una máquina expendedora es un ejemplo perfecto para ilustrar la programación modular. El proyecto está dividido en tres módulos claramente definidos:

1. **MaquinaExpendedora**: Programa principal que coordina los módulos y maneja la interacción con el usuario.
2. **ModuloInventario**: Gestiona los productos, sus precios y disponibilidad.
3. **ModuloMonedero**: Gestiona todo lo relacionado con el dinero (inserción, pagos y cambio).

## Estructura del Proyecto

```
.
├── MaquinaExpendedora.java  # Programa principal
├── ModuloInventario.java    # Módulo para gestión de productos
├── ModuloMonedero.java      # Módulo para gestión del dinero
└── README.md                # Este archivo
```

## Conceptos de Programación Modular

### ¿Qué es un Módulo?

Un módulo es una unidad independiente de código que agrupa variables y funciones relacionadas con una tarea específica. En nuestro ejemplo:

- `ModuloInventario`: Se encarga exclusivamente de gestionar los productos, sus precios y su disponibilidad.
- `ModuloMonedero`: Se encarga exclusivamente de gestionar el dinero (inserción, pagos y cambio).
- `MaquinaExpendedora`: Programa principal que coordina los módulos y gestiona la interacción con el usuario.

Los módulos son como "librerías" especializadas, cada una con su propio ámbito de responsabilidad claramente definido. En Java, al no tener un concepto nativo de "módulo" como lo tienen otros lenguajes, utilizamos clases como contenedores de funciones y variables estáticas.

### Ocultación de Información (Encapsulación)

La ocultación de información es un principio que establece que los datos internos de un módulo deben estar protegidos del acceso directo desde fuera del módulo. En nuestro ejemplo:

- Las variables `stockProductos`, `preciosProductos` y `nombresProductos` en `ModuloInventario` son `private static`.
- Las variables `dineroInsertado` y `dineroTotal` en `ModuloMonedero` son `private static`.

Esto significa que el programa principal **no puede** hacer:
```java
ModuloInventario.stockProductos[0] = -100; // ERROR: No compila, acceso denegado
ModuloMonedero.dineroTotal = 999999; // ERROR: No compila, acceso denegado
```

En su lugar, debe usar las funciones públicas que validan la operación:
```java
ModuloInventario.dispensarProducto(0); // Correcto: reduce el stock adecuadamente
ModuloMonedero.insertarDinero(100); // Correcto: actualiza el dinero adecuadamente
```

### Bajo Acoplamiento

El bajo acoplamiento significa que los módulos dependen lo menos posible unos de otros. Cada módulo sabe lo mínimo necesario sobre otros módulos para funcionar. En nuestro ejemplo:

- `ModuloInventario` no sabe nada sobre cómo se gestiona el dinero.
- `ModuloMonedero` no sabe nada sobre qué productos existen ni sus precios.
- El programa principal conoce la interfaz pública de ambos módulos pero no sus detalles internos.

Si quisiéramos cambiar `ModuloMonedero` para aceptar pagos con tarjeta, solo necesitaríamos modificar ese módulo. `ModuloInventario` seguiría funcionando sin cambios porque no depende de cómo se realiza el pago, solo necesita saber si el pago fue exitoso.

### Alta Cohesión

La alta cohesión significa que un módulo tiene un propósito único y bien definido, y todas sus funciones están estrechamente relacionadas con ese propósito. En nuestro ejemplo:

- `ModuloInventario` solo se ocupa de la gestión de productos. No contiene código para gestionar pagos.
- `ModuloMonedero` solo se ocupa de la gestión del dinero. No contiene código para gestionar productos.

Cada módulo tiene una responsabilidad clara y todas sus funciones contribuyen a cumplir esa responsabilidad específica.

### Implicaciones de Usar Métodos `static`

En este proyecto, todos los métodos y variables son `static`. Esto tiene implicaciones importantes:

- **Sin instanciación**: No necesitamos crear objetos con `new ModuloInventario()`. Accedemos directamente a través del nombre de la clase: `ModuloInventario.mostrarProductos()`.
- **Datos compartidos**: Las variables `static` existen una única vez en memoria durante toda la ejecución del programa. Todos los accesos comparten el mismo estado.
- **Simulación de módulos**: Los métodos `static` nos permiten simular módulos independientes sin necesidad de POO. Cada clase actúa como un contenedor de funciones relacionadas.
- **Limitación**: No podemos tener múltiples máquinas expendedoras independientes con estados diferentes, porque todas compartirían las mismas variables `static`. Para eso necesitaríamos POO.

## Analogías de la Vida Real

### Analogía para Ocultación de Información

**El cajero automático**: Cuando usas un cajero automático, puedes realizar operaciones como retirar dinero o consultar tu saldo, pero no tienes acceso directo a los mecanismos internos que cuentan el dinero o verifican tu cuenta. El cajero expone una interfaz limitada (botones y pantalla) mientras oculta toda la complejidad interna. De manera similar, nuestros módulos exponen métodos públicos pero ocultan las variables y la lógica interna.

### Analogía para Bajo Acoplamiento

**Departamentos en una empresa**: En una empresa, el departamento de ventas puede comunicarse con el departamento de contabilidad mediante procedimientos formales (como enviar facturas), pero no necesita saber cómo contabilidad registra esas facturas internamente. Si contabilidad cambia su sistema interno, ventas puede seguir enviando facturas de la misma manera. Esto es bajo acoplamiento: los departamentos interactúan a través de interfaces bien definidas sin depender de los detalles internos de otros departamentos.

### Analogía para Alta Cohesión

**Las herramientas especializadas**: Un destornillador está diseñado específicamente para atornillar y desatornillar. No trata de ser también un martillo o una sierra. Esta especialización lo hace muy bueno en su tarea específica. De manera similar, cada módulo en nuestro programa tiene un propósito específico y hace bien esa tarea, en lugar de intentar hacer múltiples tareas no relacionadas.

## Beneficios de la Programación Modular

1. **Mantenibilidad**: Es más fácil mantener código organizado en módulos porque cada módulo tiene una responsabilidad clara.

2. **Reutilización**: Los módulos bien diseñados pueden reutilizarse en diferentes partes del programa o incluso en diferentes programas.

3. **Facilidad de prueba**: Es más fácil probar un módulo aisladamente porque tiene responsabilidades bien definidas.

4. **División del trabajo**: Diferentes programadores pueden trabajar en diferentes módulos sin interferir entre sí.

5. **Gestión de la complejidad**: La programación modular ayuda a manejar sistemas complejos dividiéndolos en partes más pequeñas y manejables.

## Instrucciones para Compilar y Ejecutar

1. Asegúrate de tener instalado Java Development Kit (JDK)
2. Abre una terminal en la carpeta del proyecto
3. Compila los archivos:
   ```
   javac MaquinaExpendedora.java ModuloInventario.java ModuloMonedero.java
   ```
4. Ejecuta el programa:
   ```
   java MaquinaExpendedora
   ```

## Cómo Usar la Máquina Expendedora

Una vez ejecutado el programa, podrás interactuar con la máquina expendedora a través del menú:

1. **Ver productos disponibles**: Muestra todos los productos, sus precios y stock
2. **Insertar dinero**: Te permite agregar dinero a la máquina
3. **Comprar producto**: Selecciona un producto para comprarlo
4. **Solicitar cambio**: Recupera el dinero insertado
5. **Salir**: Finaliza el programa

## Diseño Modular del Proyecto

### ModuloInventario
- **Responsabilidad**: Gestión de productos
- **Variables**: `nombresProductos`, `stockProductos`, `preciosProductos`
- **Métodos principales**: `mostrarProductos()`, `verificarStock()`, `dispensarProducto()`, `consultarPrecio()`

### ModuloMonedero
- **Responsabilidad**: Gestión del dinero
- **Variables**: `dineroInsertado`, `dineroTotal`
- **Métodos principales**: `insertarDinero()`, `procesarPago()`, `darCambio()`, `verificarDineroSuficiente()`

### MaquinaExpendedora (Programa Principal)
- **Responsabilidad**: Coordinar los módulos y gestionar la interfaz de usuario
- **Funcionamiento**: Muestra el menú, recibe las opciones del usuario y llama a los métodos adecuados de cada módulo
