# Conversor de Monedas

Este proyecto es un desafío práctico para desarrollar un conversor de monedas que consuma una API de tipos de cambio, implementado en Java. El objetivo es poner en práctica conocimientos de Java, consumo de APIs y desarrollo de aplicaciones, siguiendo una metodología ágil.

## Características

- Consumo de la API de [Exchange Rate](https://exchangeratesapi.io/).
- Conversión entre múltiples monedas.
- Interfaz de usuario en consola.
- Manejo de errores para entradas no válidas y problemas con la API.
- Historial de conversiones (opcional).

## Requisitos Previos

Antes de comenzar, asegúrate de tener lo siguiente:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) instalado.
- Un IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/) o [Eclipse](https://www.eclipse.org/).
- Una cuenta en GitHub para el repositorio del proyecto.
- Conexión a Internet para consumir la API.

## Instalación y Configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/conversor-monedas.git
   ```
2. **Configurar el entorno**
   - Asegúrate de que tu IDE esté configurado para usar Java.
   - Configura las dependencias necesarias, como bibliotecas para realizar solicitudes HTTP.

3. **Obtener la clave de API**
   - Regístrate en [Exchange Rate API](https://exchangeratesapi.io/) para obtener una clave de API.
   - Configura la clave de API en el archivo de configuración del proyecto (por ejemplo, `config.properties`).

## Uso

1. Ejecuta la aplicación desde tu IDE o consola:
   ```bash
   java -jar conversor-monedas.jar
   ```
2. Sigue las instrucciones en pantalla para:
   - Seleccionar la moneda de origen.
   - Seleccionar la moneda de destino.
   - Ingresar el monto a convertir.

## Metodología Ágil

Este proyecto se organiza siguiendo los principios ágiles:

- **Trello:** Utilizado para organizar las tareas. Las tarjetas incluyen subtareas como configurar el entorno, implementar la lógica de consumo de la API, crear la interfaz de usuario y manejar errores.

## Estructura del Proyecto

```
conversor-monedas/
|-- src/
|   |-- Main.java
|   |-- ApiService.java
|   |-- Converter.java
|   |-- UI.java
|-- resources/
|   |-- config.properties
|-- README.md
|-- .gitignore
|-- pom.xml (si usas Maven)
```

## Funcionalidades Futuras

- Implementar una interfaz gráfica de usuario (GUI).
- Soporte para más APIs de tipos de cambio.
- Configuración regional para mostrar resultados en diferentes formatos.

## Contribuciones

Si deseas contribuir al proyecto:
1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad: `git checkout -b nueva-funcionalidad`.
3. Realiza los cambios y realiza un commit: `git commit -m "Agrega nueva funcionalidad"`.
4. Envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

¡Gracias por tu interés en este proyecto! Si tienes preguntas o sugerencias, no dudes en abrir un issue en GitHub.
