# AprendizajeSpringboot - Proyecto API Tarea

![Spring Boot Logo](https://img.shields.io/badge/Spring%20Boot-3.3.0-green.svg)
![Java Version](https://img.shields.io/badge/Java-24-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)
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

* **Java Development Kit (JDK):** Versión 17 o superior. (Desarrollado con JDK 24.0.1)
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
3.  Navega hasta la carpeta `AprendizajeSpringboot` (o `api_tarea` si la renombraste localmente) y selecciónala.
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
│                       ├── ApiTareaApplication.java      # Clase principal de Spring Boot
│                       └── controller/                   # Aquí residen los controladores REST
│                           └── SaludoController.java     # Controlador de ejemplo
│                           └── IVAController.java        # Controlador para el Ejercicio 1
│                       └── service/                      # (Opcional) Clases de lógica de negocio
│                       └── model/                        # (Opcional) Clases de modelos de datos
│       └── resources/
│           ├── application.properties                  # Configuración de la aplicación (ej. puerto)
│           ├── static/                                 # Aquí se alojan los archivos HTML/CSS/JS para los frontends
│               └── ejercicio1-iva.html                 # Frontend para el Ejercicio 1
│           └── templates/                              # (Opcional) Para motores de plantillas como Thymeleaf
├── .gitignore                                            # Archivos y directorios a ignorar por Git
├── HELP.md                                               # Archivo de ayuda de Spring Boot
├── mvnw                                                  # Script de Maven Wrapper (Linux/macOS)
├── mvnw.cmd                                              # Script de Maven Wrapper (Windows)
└── pom.xml                                               # Archivo de configuración de Maven (dependencias, plugins)



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

Esta sección se actualizará a medida que se implementen más ejercicios:

* **1. Cálculo de IVA (19%)**
    * **Endpoint:** `GET /iva/calcular?precio={valor}`
    * **Frontend:** `http://localhost:8082/ejercicio1-iva.html`
    * **Descripción:** Pide el precio de un artículo y calcula su valor aplicándole un incremento del 19% de IVA.

* **2. [Título del Ejercicio 2]**
    * *(Se añadirá aquí una vez implementado)*

*(...y así sucesivamente para los 16 ejercicios)*

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
        1.  Verifica que las líneas `package` en tus archivos Java (`ApiTareaApplication.java` y `SaludoController.java`) coincidan exactamente con la estructura de carpetas (ej., `package com.projecto1.api_tarea;` para `ApiTareaApplication.java` y `package com.projecto1.api_tarea.controller;` para `SaludoController.java`).
        2.  Abre la terminal en la raíz de tu proyecto y ejecuta `./mvnw clean install` para asegurar que todas las dependencias se descarguen y el proyecto se compile correctamente.

---