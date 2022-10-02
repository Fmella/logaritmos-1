## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## How to run the project (Español)

Para poder correr el proyecto necesitará la version de Java 18 para que funcione correctamente.

Se recomienda el uso de un IDE como Visual Studio Code o IntelliJ para poder ejecutar el proyecto.

Primero, debera importar la libreria para poder crear los gráficos que puede ser encontrado [aqui](https://sourceforge.net/projects/jfreechart/)
- Si usa VS Code, deberá seguir las instrucciones de la sección de Dependacy Management que se encuentra en el README.
- Si usa IntelliJ, deberá incluir un modulo de librerias en la estructura del proyecto.

Tiene que incluir los archivos de jcommon-xxx.jar, jfreechart-xxx.jar y swtgraphics2d.jar para poder ejecurlo.

Además, debera editar el VM agregando las flags -Xmx5g y -XX:+DisableExplicitGC para poder aumentar el tamaño del heap y para poder
desactivar el Garbage Collector de Java.

La estructura del proyecto es la siguiente:
- Utils: Clases que nos ayudaran a calcular los tiempos de ejecución.
- Plot: Clase para poder gráficar los distintos tiempos de ejecución de los algoritmos.
- AlgoritmoX: Implementacion del algoritmo
- BMain: Experimento para poder determinar el valor de B. (1 hora aproximadamente)
- Main: Experimento principal de la tarea (25 minutos aproximadamente)

Dependiendo del experimento que quiere probar, se deberá ejecutar el método main de la clase Main o BMain.