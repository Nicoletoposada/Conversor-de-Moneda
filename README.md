# Conversor de Moneda

Este proyecto es una aplicación en Java que permite convertir valores en USD (dólares estadounidenses) a varias monedas, como ARS, BOB, BRL, CLP y COP, utilizando tasas de cambio obtenidas a través de la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

## Características

- Obtención de tasas de cambio actualizadas mediante solicitudes HTTP.
- Conversión de USD a otras monedas soportadas.
- Interfaz de menú interactiva para que el usuario seleccione la conversión deseada.
- Validación de las tasas de cambio obtenidas para garantizar la precisión de los resultados.

## Tecnologías y Bibliotecas

- **Java**: Lenguaje principal para el desarrollo del proyecto.
- **HttpClient**: Para realizar solicitudes HTTP.
- **Gson**: Para manejar y deserializar las respuestas JSON de la API.
- **Maven**: Para la gestión de dependencias y construcción del proyecto.

## Requisitos

- Java 8 o superior.
- Maven instalado.
- Conexión a internet para acceder a la API de tasas de cambio.

## Instalación y Ejecución

1. **Clona este repositorio**:
   ```bash
   git clone <URL-del-repositorio>
   cd conversor-de-moneda
   ```

2. **Configura tu API Key**:
   - Abre el archivo `ConversorDeMoneda.java`.
   - Reemplaza `6f7ea3ba3e2518c15787e93c` con tu propia API Key obtenida de [ExchangeRate-API](https://www.exchangerate-api.com/).

3. **Compila el proyecto**:
   ```bash
   mvn compile
   ```

4. **Ejecúta la aplicación**:
   ```bash
   mvn exec:java -Dexec.mainClass="ConversorDeMoneda"
   ```

## Estructura del Proyecto

- **`ConversorDeMoneda.java`**: Clase principal que maneja las solicitudes HTTP, deserializa las respuestas y proporciona la interfaz de menú.
- **`ApiResponse.java`**: Clase para modelar la respuesta de la API.
- **`Rates.java`**: Clase para modelar las tasas de cambio dentro de la respuesta de la API.
- **`pom.xml`**: Archivo de configuración de Maven.

## Uso

1. Ejecuta la aplicación.
2. Selecciona una opción del menú para realizar una conversión de moneda:
   - 1: USD a ARS
   - 2: USD a BOB
   - 3: USD a BRL
   - 4: USD a CLP
   - 5: USD a COP
   - 6: Salir
3. Ingresa la cantidad en USD que deseas convertir.
4. Visualiza el resultado de la conversión.

## Ejemplo de Ejecución
```plaintext
Código de estado: 200
JSON de respuesta: {"base_code":"USD", "conversion_rates":{"ARS":350.25, "BOB":6.91, ...}}
Base: USD
ARS Rate: 350.25
Ingrese la cantidad en USD: 100
100 USD es equivalente a 35025.0 ARS
```

## Dependencias

El archivo `pom.xml` incluye las siguientes dependencias:

- **Gson**: Manejo de JSON.
- **HttpClient**: Realizar solicitudes HTTP.

## Contribuciones

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu función (`git checkout -b nueva-funcion`).
3. Realiza tus cambios y haz commit (`git commit -m 'Agregada nueva función'`).
4. Haz push a la rama (`git push origin nueva-funcion`).
5. Abre un Pull Request.

## Autor

Desarrollado por Nicolás Posada García para Alura Latam.

