# AprendizajeSpringboot - Proyecto API Tarea

![Spring Boot Logo](https://img.shields.io/badge/Spring%20Boot-3.3.0-green.svg)
![Java Version](https://img.shields.io/badge/Java-17%2B-blue.svg) ![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)
![GitHub Repo stars](https://img.shields.io/github/stars/MiguelEstradaLopez/AprendizajeSpringboot?style=social)

Este repositorio contiene el código de la aplicación "API Tarea", desarrollada con Spring Boot. La aplicación implementa diversas funcionalidades matemáticas y lógicas a través de endpoints REST, y se complementa con pequeños "frontends" en HTML y JavaScript para una interacción sencilla y visual.

---

## 📋 Tabla de Contenidos

1.  [Acerca del Proyecto](#1-acerca-del-proyecto)
2.  [Requisitos del Sistema](#2-requisitos-del-sistema)
3.  [Configuración Inicial del Proyecto](#3-configuración-inicial-del-proyecto)
    * [Clonar el Repositorio de GitHub](#31-clonar-el-repositorio-de-github)
    * [Abrir el Proyecto en VS Code](#32-abrir-el-proyecto-en-vs-code)
    * [Configuración de Git (si es la primera vez)](#33-configuración-de-git-si-es-la-primera-vez)
4.  [Estructura del Proyecto](#4-estructura-del-proyecto)
5.  [Ejecución de la Aplicación](#5-ejecución-de-la-aplicación)
    * [Desde VS Code (Recomendado)](#51-desde-vs-code-recomendado)
    * [Desde la Terminal (Maven Wrapper)](#52-desde-la-terminal-maven-wrapper)
6.  [Uso de la Aplicación (Endpoints y Frontends)](#6-uso-de-la-aplicación-endpoints-y-frontends)
    * [Acceso a los Endpoints de la API (Backend Puro)](#61-acceso-a-los-endpoints-de-la-api-backend-puro)
    * [Acceso a los Pequeños Frontends (HTML)](#62-acceso-a-los-pequeños-frontends-html)
    * [Ejercicios Implementados](#63-ejercicios-implementados)
7.  [Parar la Aplicación](#7-parar-la-aplicación)
8.  [Resolución de Problemas Comunes](#8-resolución-de-problemas-comunes)

---

## 1. Acerca del Proyecto

El objetivo de este proyecto es implementar una serie de ejercicios de lógica de programación y cálculo utilizando la arquitectura de una API REST con Spring Boot. Cada ejercicio se aborda con un controlador específico que expone uno o más endpoints, y algunos ejercicios incluyen una interfaz de usuario simple (HTML/JavaScript) para facilitar la interacción.

---

## 2. Requisitos del Sistema

Para poder ejecutar y trabajar con este proyecto, necesitarás tener instalado lo siguiente en tu equipo:

* **Java Development Kit (JDK):** Versión 17 o superior. (Desarrollado con JDK 24.0.1, pero compatible con 17+).
    * Verificar versión: `java -version`
* **Apache Maven:** Versión 3.6.0 o superior (el proyecto incluye Maven Wrapper, `mvnw`, por lo que una instalación global no es estrictamente necesaria, pero es recomendable).
    * Verificar versión: `mvn -v`
* **Git:** Para clonar el repositorio y gestionar el control de versiones.
    * Verificar versión: `git --version`
* **Visual Studio Code (VS Code):** Editor de código IDE recomendado, con las siguientes extensiones instaladas para facilitar el desarrollo Java/Spring Boot:
    * [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=redhat.java) (Red Hat)
    * [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack) (Pivotal)
* **Un navegador web:** Para acceder a la aplicación (ej., Chrome, Firefox, Edge).

---

## 3. Configuración Inicial del Proyecto

Sigue estos pasos para obtener el código fuente y preparar el proyecto en tu entorno local.

### 3.1. Clonar el Repositorio de GitHub

1.  Abre una terminal en tu sistema.
2.  Navega a la carpeta donde deseas almacenar el proyecto (ej., `cd ~/Documentos/java/`).
3.  Clona el repositorio:
    ```bash
    git clone [https://github.com/MiguelEstradaLopez/AprendizajeSpringboot.git](https://github.com/MiguelEstradaLopez/AprendizajeSpringboot.git)
    ```
    Esto creará una carpeta llamada `AprendizajeSpringboot` que contendrá el proyecto.

### 3.2. Abrir el Proyecto en VS Code

1.  Abre Visual Studio Code.
2.  Ve a `File` (Archivo) > `Open Folder...` (Abrir Carpeta...).
3.  Navega hasta la carpeta `AprendizajeSpringboot` y selecciónala.
4.  VS Code detectará que es un proyecto Spring Boot/Maven y comenzará a importar las dependencias. Espera a que este proceso finalice.

### 3.3. Configuración de Git (si es la primera vez)

Si es la primera vez que usas Git en esta máquina o con tu cuenta de GitHub, es fundamental configurar tu nombre de usuario y correo electrónico:

1.  Abre la terminal integrada de VS Code (`Ctrl + Ñ` o `Cmd + J`).
2.  Ejecuta los siguientes comandos, reemplazando con tu información real:
    ```bash
    git config --global user.name "Tu Nombre Completo"
    git config --global user.email "tu.email@ejemplo.com"
    ```

---

## 4. Estructura del Proyecto

El proyecto sigue una estructura Maven estándar para aplicaciones Spring Boot:

AprendizajeSpringboot/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── projecto1/
│                   └── api_tarea/
│                       ├── ApiTareaApplication.java             # Clase principal de Spring Boot
│                       ├── controller/                          # Aquí residen los controladores REST
│                       │   ├── SaludoController.java
│                       │   ├── IVAController.java
│                       │   ├── RectanguloController.java
│                       │   ├── OperacionesBasicasController.java
│                       │   ├── TemperaturaController.java
│                       │   ├── FinanzasController.java
│                       │   ├── InmueblesController.java
│                       │   ├── RestauranteController.java
│                       │   ├── EmpresaController.java
│                       │   ├── NumerosController.java
│                       │   ├── NotasController.java
│                       │   ├── VectorOperationsController.java    # Para 1.2.1, 1.2.2, 1.2.3, 1.3.1, 1.3.2, 1.3.3
│                       │   ├── HaciendaController.java            # Para 3.1.2
│                       │   ├── MatrixOperationsController.java    # Para 3.2.1
│                       │   ├── MatrixRowSumController.java        # Para 3.2.2
│                       │   └── MatrixOperationsAdvancedController.java # Para 3.2.3
│                       └── utils/                               # Clases de utilidad
│                           └── MatrixUtils.java                 # Utilidades para manipulación de matrices
│       └── resources/
│           ├── application.properties                 # Configuración de la aplicación (ej. puerto)
│           ├── static/                                # Aquí se alojan los archivos HTML/CSS/JS para los frontends
│           │   ├── index.html                           # Página principal con enlaces a todos los ejercicios
│           │   ├── styles.css                           # Estilos CSS compartidos
│           │   ├── ejercicio1-iva.html
│           │   ├── ejercicio2-rectangulo.html
│           │   ├── ejercicio3-operaciones.html
│           │   ├── ejercicio10-fahrenheit-celsius.html
│           │   ├── ejercicio11-interes.html
│           │   ├── ejercicio12-casa.html
│           │   ├── ejercicio13-restaurante.html
│           │   ├── ejercicio14-inversion.html
│           │   ├── ejercicio15-invertir-numero.html
│           │   ├── ejercicio16-nota-definitiva.html
│           │   ├── problema1-2-1-examen.html
│           │   ├── problema1-2-2-normalizacion.html
│           │   ├── problema1-2-3-suma-binaria.html
│           │   ├── ejercicio1-3-1-mezcla-arreglos.html
│           │   ├── ejercicio1-3-2-buscar-indices.html
│           │   ├── ejercicio1-3-3-arreglo-partidario.html
│           │   ├── problema3-1-1-restaurante.html
│           │   ├── problema3-1-2-hacienda.html
│           │   ├── ejercicio3-2-1-matrices.html
│           │   ├── ejercicio3-2-2-suma-filas.html
│           │   └── ejercicio3-2-3-operaciones-matrices.html
│           └── templates/                           # (Opcional) Para motores de plantillas como Thymeleaf
├── .gitignore                                       # Archivos y directorios a ignorar por Git
├── HELP.md                                          # Archivo de ayuda de Spring Boot
├── mvnw                                             # Script de Maven Wrapper (Linux/macOS)
├── mvnw.cmd                                         # Script de Maven Wrapper (Windows)
└── pom.xml                                          # Archivo de configuración de Maven (dependencias, plugins)


---

## 5. Ejecución de la Aplicación

La aplicación Spring Boot se ejecutará en el puerto **`8082`**.

### 5.1. Desde VS Code (Recomendado)

1.  Abre la vista **"Spring Boot Dashboard"** en VS Code (icono de resorte en la barra lateral o busca en la Paleta de Comandos).
2.  En la sección de `API_TAREA`, haz clic en el botón de **"Play" (Run)** para iniciar la aplicación.
3.  La terminal de VS Code mostrará los logs de inicio. Confirma que la aplicación ha iniciado correctamente buscando la línea:
    ```
    Tomcat started on port 8082 (http) with context path '/'
    ```

### 5.2. Desde la Terminal (Maven Wrapper)

1.  Abre la terminal integrada de VS Code.
2.  Navega al directorio raíz de tu proyecto `AprendizajeSpringboot` (donde está `pom.xml`).
3.  Ejecuta el siguiente comando:
    * **En Linux/macOS:**
        ```bash
        ./mvnw spring-boot:run
        ```
    * **En Windows:**
        ```bash
        mvnw.cmd spring-boot:run
        ```
4.  La aplicación se iniciará y los logs se mostrarán en la terminal.

---

## 6. Uso de la Aplicación (Endpoints y Frontends)

Una vez que la aplicación esté corriendo, puedes interactuar con los ejercicios implementados a través de tu navegador.

### 6.1. Acceso a los Endpoints de la API (Backend Puro)

Puedes probar los endpoints directamente en tu navegador o utilizando herramientas como Postman o Insomnia.

* **Ejemplo: Calcular IVA (Ejercicio 1)**
    * **URL:** `http://localhost:8082/iva/calcular?precio=X`
    * **Reemplaza `X`** con el valor del precio que deseas calcular (ej., `http://localhost:8082/iva/calcular?precio=250.75`).
    * **Respuesta esperada:** Un mensaje de texto con el precio final incluyendo el IVA.

### 6.2. Acceso a los Pequeños Frontends (HTML)

Para cada ejercicio que incluye un archivo HTML en la carpeta `src/main/resources/static/`, puedes acceder a ellos directamente en tu navegador.

* **Ejemplo: Calculadora de IVA (Ejercicio 1)**
    * **URL:** `http://localhost:8082/ejercicio1-iva.html`
    * Al acceder, se cargará la página HTML con un formulario. Ingresa un valor y haz clic en "Calcular con IVA". El JavaScript en la página hará la llamada a tu API y mostrará el resultado.

### 6.3. Ejercicios Implementados

Esta sección lista los ejercicios que han sido implementados en esta API, junto con sus respectivos endpoints y frontends interactivos.

* **1. Cálculo de IVA (19%)**
    * **Endpoint:** `GET http://localhost:8082/iva/calcular?precio={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio1-iva.html`
    * **Descripción:** Calcula el precio final de un artículo aplicando un 19% de IVA.

* **2. Área de un Rectángulo**
    * **Endpoint:** `GET http://localhost:8082/rectangulo/area?largo={valor}&ancho={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio2-rectangulo.html`
    * **Descripción:** Calcula y muestra el área de un rectángulo dadas su longitud y anchura.

* **3. Operaciones Básicas con Dos Números**
    * **Endpoint:** `GET http://localhost:8082/operaciones/basicas?num1={valor}&num2={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio3-operaciones.html`
    * **Descripción:** Lee dos números e imprime su suma, producto, diferencia y cociente.

* **4. Determinante de una Matriz 2x2**
    * *(Pendiente de implementación)*
    * **Descripción:** Calcule el determinante de una matriz de dos filas y dos columnas.

* **5. Intercambio de Caracteres**
    * *(Pendiente de implementación)*
    * **Descripción:** Intercambie los datos de dos variables que almacenan caracteres.

* **6. Nota Definitiva Lógica de Programación I (Complejo)**
    * *(Pendiente de implementación)*
    * **Descripción:** Calcula la nota definitiva de un estudiante teniendo en cuenta examen parcial (20%), examen final (20%) y seguimiento (60% - promedio entre dos quices, un taller y un proyecto).

* **7. Volumen de un Cono**
    * *(Pendiente de implementación)*
    * **Descripción:** Calcule el volumen de un cono, la fórmula a emplear es: Volumen= (π * radio² * altura)/3.

* **8. Porcentaje de Estudiantes (Hombres/Mujeres)**
    * *(Pendiente de implementación)*
    * **Descripción:** Calcule el porcentaje de estudiantes mujeres y el porcentaje de estudiantes hombres de un salón de clases.

* **9. Perímetro de un Rectángulo**
    * *(Pendiente de implementación)*
    * **Descripción:** Calcule el perímetro de un rectángulo, conociendo la longitud de dos lados no paralelos. Perímetro= L1+ L2.

* **10. Conversión Fahrenheit a Celsius**
    * **Endpoint:** `GET http://localhost:8082/temperatura/fahrenheit-to-celsius?fahrenheit={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio10-fahrenheit-celsius.html`
    * **Descripción:** Convierte una temperatura dada en grados Fahrenheit a grados Celsius.

* **11. Cálculo de Interés**
    * **Endpoint:** `GET http://localhost:8082/finanzas/calcular-interes?monto={valor}&interes={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio11-interes.html`
    * **Descripción:** Calcula el valor ganado por concepto de interés, dada una inversión y un porcentaje de interés.

* **12. Valor de Cuota Inicial de Casa**
    * **Endpoint:** `GET http://localhost:8082/inmuebles/calcular-casa?valor={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio12-casa.html`
    * **Descripción:** Calcula el valor de la cuota inicial (20%), el valor restante a prestar al banco y la cuota mensual de la cuota inicial (en 24 cuotas).

* **13. Venta Total de Restaurante (Combos)**
    * **Endpoint:** `GET http://localhost:8082/restaurante/ventas?combo1={cant}&combo2={cant}&combo3={cant}`
    * **Frontend:** `http://localhost:8082/ejercicio13-restaurante.html`
    * **Descripción:** Determina el valor total vendido por un restaurante en un día a partir de la cantidad de combos vendidos de cada tipo.

* **14. Porcentaje de Inversión en Empresa**
    * **Endpoint:** `GET http://localhost:8082/empresa/porcentaje-inversion?inv1={monto}&inv2={monto}&inv3={monto}`
    * **Frontend:** `http://localhost:8082/ejercicio14-inversion.html`
    * **Descripción:** Calcula el porcentaje que cada una de tres personas invierte con respecto a la cantidad total invertida en una empresa.

* **15. Número Invertido (Dos Cifras)**
    * **Endpoint:** `GET http://localhost:8082/numeros/invertir-dos-cifras?numero={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio15-invertir-numero.html`
    * **Descripción:** Dado un número de dos cifras, obtiene y muestra el número invertido (ej. 15 -> 51).

* **16. Nota Definitiva de Asignatura (Simple)**
    * **Endpoint:** `GET http://localhost:8082/notas/definitiva?parcial={nota}&final={nota}&seguimiento={nota}`
    * **Frontend:** `http://localhost:8082/ejercicio16-nota-definitiva.html`
    * **Descripción:** Calcula la nota definitiva de un estudiante a partir de las notas del examen parcial (20%), examen final (20%) y seguimiento (60%).

### Ejercicios de Vectores y Matrices

* **Problema 1.2.1: Calificación de Examen de Selección Múltiple**
    * **Frontend:** `http://localhost:8082/problema1-2-1-examen.html`
    * **Descripción:** Califica un examen de selección múltiple comparando las respuestas del estudiante con las correctas.

* **Problema 1.2.2: Normalización de una Colección de Números Reales**
    * **Frontend:** `http://localhost:8082/problema1-2-2-normalizacion.html`
    * **Descripción:** Normaliza un vector de números reales.

* **Problema 1.2.3: Suma en Binario**
    * **Frontend:** `http://localhost:8082/problema1-2-3-suma-binaria.html`
    * **Descripción:** Realiza la suma de dos números binarios ingresados como cadenas.

* **Ejercicio 1.3.1: Mezcla de Arreglos Ordenados**
    * **Frontend:** `http://localhost:8082/ejercicio1-3-1-mezcla-arreglos.html`
    * **Descripción:** Mezcla dos arreglos de números reales ordenados en un único arreglo ordenado.

* **Ejercicio 1.3.2: Búsqueda de Índices de un Número en Arreglo**
    * **Frontend:** `http://localhost:8082/ejercicio1-3-2-buscar-indices.html`
    * **Descripción:** Busca todas las ocurrencias de un número dado en un arreglo y devuelve sus índices.

* **Ejercicio 1.3.3: Arreglo Partidario**
    * **Frontend:** `http://localhost:8082/ejercicio1-3-3-arreglo-partidario.html`
    * **Descripción:** Separa los números positivos y negativos de un arreglo en dos arreglos distintos.

* **Problema 3.1.1: Calificación de Aspectos de Restaurante (Clientes)**
    * **Frontend:** `http://localhost:8082/problema3-1-1-restaurante.html`
    * **Descripción:** Calcula promedios de calificación para diferentes aspectos de un restaurante basados en encuestas de clientes.

* **Problema 3.1.2: Producción de Leche en Hacienda (Matriz 7xN)**
    * **Frontend:** `http://localhost:8082/problema3-1-2-hacienda.html`
    * **Descripción:** Procesar la producción de leche de N vacas durante 7 días, almacenada en una matriz.

* **Ejercicio 3.2.1: Operaciones con Diagonales y Bordes de Matriz NxN**
    * **Frontend:** `http://localhost:8082/ejercicio3-2-1-matrices.html`
    * **Descripción:** Algoritmos para poner ceros en diagonales, en bordes, llenar con `i+j`, y secuencias en filas/diagonal principal de una matriz NxN.

* **Ejercicio 3.2.2: Suma de Filas de Matriz en un Arreglo**
    * **Frontend:** `http://localhost:8082/ejercicio3-2-2-suma-filas.html`
    * **Descripción:** Lee una matriz de números reales y calcula la suma de los elementos de cada una de sus filas, guardándolos en un arreglo.

* **Ejercicio 3.2.3: Operaciones con Matrices (Suma, Traspuesta, Traza, Multiplicación)**
    * **Frontend:** `http://localhost:8082/ejercicio3-2-3-operaciones-matrices.html`
    * **Descripción:** Implementa la suma, traspuesta, traza y multiplicación de matrices, incluyendo validaciones de dimensiones.

---

## 7. Parar la Aplicación

* **Desde VS Code (Spring Boot Dashboard):**
    * En el Spring Boot Dashboard, selecciona tu proyecto `API_TAREA`.
    * Haz clic en el botón de **"Stop" (cuadrado rojo)**.
* **Desde la Terminal:**
    * Si iniciaste la aplicación desde la terminal, presiona `Ctrl + C` en la terminal donde se está ejecutando la aplicación.

---

## 8. Resolución de Problemas Comunes

* **"Whitelabel Error Page" al acceder a `http://localhost:8082/`:**
    * **Causa:** Es el comportamiento normal de Spring Boot cuando no hay un endpoint definido para la ruta raíz (`/`). La aplicación está funcionando.
    * **Solución:** Accede a las URLs específicas de los endpoints o los archivos HTML de frontend (ej., `http://localhost:8082/ejercicio1-iva.html`).
* **`error: failed to push some refs to 'https://github.com/MiguelEstradaLopez/AprendizajeSpringboot.git'` (non-fast-forward):**
    * **Causa:** Tu rama local está "detrás" de la rama remota en GitHub (hay cambios en GitHub que no tienes localmente).
    * **Solución:** Primero, trae y fusiona los cambios remotos. Desde la raíz de tu proyecto en la terminal, ejecuta:
        ```bash
        git pull origin main --allow-unrelated-histories --no-rebase
        ```
        Si hay conflictos (ej., en `README.md` o `.gitignore`), resuélvelos en VS Code, haz `git add .` y luego `git commit -m "Merge changes from remote"`. Después, intenta el `git push -u origin main` de nuevo.
* **`remote: Repository not found.` al hacer `git push`:**
    * **Causa:** La URL del repositorio remoto está mal configurada.
    * **Solución:** Elimina y vuelve a añadir el remoto con la URL correcta (asegurándote de usar tu nombre de usuario de GitHub real, como `MiguelEstradaLopez`):
        ```bash
        git remote remove origin
        git remote add origin [https://github.com/MiguelEstradaLopez/AprendizajeSpringboot.git](https://github.com/MiguelEstradaLopez/AprendizajeSpringboot.git)
        ```
* **Error de "user name" o "email" de Git:**
    * **Causa:** Git necesita tu identidad para registrar los commits.
    * **Solución:** Configura tu información globalmente:
        ```bash
        git config --global user.name "Tu Nombre Completo"
        git config --global user.email "tu.email@ejemplo.com"
        ```
* **Errores de compilación en VS Code (`Missing mandatory Classpath entries` o problemas de `package`):**
    * **Causa:** Generalmente se debe a una declaración de paquete incorrecta o a que Maven no ha resuelto las dependencias.
    * **Solución:**
        1.  Verifica que las líneas `package` en tus archivos Java (`ApiTareaApplication.java` y `SaludoController.java`, etc.) coincidan exactamente con la estructura de carpetas (ej., `package com.projecto1.api_tarea;` para `ApiTareaApplication.java` y `package com.projecto1.api_tarea.controller;` para los controladores).
        2.  Abre la terminal en la raíz de tu proyecto y ejecuta `./mvnw clean install` para asegurar que todas las dependencias se descarguen y el proyecto se compile correctamente.
