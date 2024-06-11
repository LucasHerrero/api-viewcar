# Concesionario

Este es un proyecto de Spring Boot que proporciona una API REST para un concesionario de coches. Permite a los usuarios interactuar con datos relacionados con los coches, como los paquetes de coches, colores exteriores, etc.

## Cómo iniciar el proyecto

1. Asegúrate de tener instalado Java 17 y Maven en tu máquina.

2. Clona el repositorio a tu máquina local.

3. Navega hasta el directorio del proyecto.

4. Ejecuta el siguiente comando para construir el proyecto:

```sh
./mvnw clean install
```

5. Para iniciar la aplicación, ejecuta el siguiente comando:

```sh
./mvnw spring-boot:run
```

Alternativamente, si estás utilizando Visual Studio Code, puedes iniciar la aplicación utilizando la configuración de lanzamiento proporcionada en [``.vscode/launch.json``](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fc%3A%2FUsers%2F6002676%2FDocuments%2FProyecto-concesionario%2Fapi-viewcar%2F.vscode%2Flaunch.json%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "c:\Users\6002676\Documents\Proyecto-concesionario\api-viewcar\.vscode\launch.json"). Asegúrate de tener instalada la extensión "Spring Boot Tools".

## Resumen del proyecto

El proyecto Concesionario es una aplicación de back-end que proporciona una API REST para gestionar un concesionario de coches. Permite a los usuarios realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en varios recursos, incluyendo:

- Paquetes de coches: Los usuarios pueden crear, leer, actualizar y eliminar paquetes de coches. Un paquete de coche incluye detalles como el nombre, la carrocería, los asientos, el precio y una lista de rutas de imágenes.

El proyecto utiliza Spring Security para la autenticación y autorización, y también incluye pruebas unitarias y de integración.

Además, el proyecto está configurado para ser ejecutado en un contenedor Docker, como se indica en el archivo Dockerfile proporcionado