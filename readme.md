# Proyecto #1: Fase 1
###### Base de Datos II (SD-ISC-349-T-001)
- Dante Faña Badia - 2015-6079
- Lorna Flerida Espinosa Cuello - 2014-5845
- Emmanuel Cruz - 2015-5973
- Marcos González - 2015-6275

## Vista estática de la arquitectura del software (Diagrama de Componentes)   

![](/diagrams/recommender.component.png)

  1. __recommender.entities__: capa de acceso a datos; a travésde este se obtiene las información de las películas y usuario a través de este capa.  
  2. __recommender.core__: esta capa consume la entidades y aplica las lógica de negocios en ellas.
  3. __recommender.rest__: esta es un mecanismo de delivery el cual envía los datos a la capa de presentación del cliente. Esta también se encarga de enviar las notificaciones a la capa de presentación para indicar que se procesaron recomendaciones.  
  4. __recommender.app__: es la capa de presentación con el que el cliente interactúa.  
  5. __recommender.services__: esta capa calcula las recomendaciones en base a las información en la capa de acceso a datos.  

## Modelado de Datos (Diagrama ER)   

Entidades necesarias para el funcionamiento de la aplicación.  

![](/diagrams/recommender.er.png)

## Modelado de Procesos (Diagrama de Secuencia y Diagrama de Flujo)

Aquí diagramamos el proceso más complejo de la aplicación; las recomendaciones.  

### Diagrama de Secuencia

En este diagrama de secuencia observamos que el usuario realiza una llamada al "RecommenderMaker" enviándole el tipo de recomendación que desea, este luego llamando al algoritmo de recomendación necesario para procesar los datos.    

![](/diagrams/recommender.sequence.png)

### Diagrama de Flujo   

Aquí vemos el diagrama de flujo de la aplicación en la cual se muestra el proceso desde que el usuario hace su calificación, el sistema procesa la información y la capa de presentación lo muestra.  

![](/diagrams/recommender.flowchart.png)

## Modelado de Objetos (Diagrama de Clases)

Esta muestra las clases necesarias para que el sistema funcione en la capa de datos y en la estructura base necesaria de clases para el cálculo de algoritmos de recomendaciones.  

![](/diagrams/recommender.class.png)

## Descripción de Tecnologías

Este proyecto utiliza varias herramientas:

  - __Hadoop 2.7.5__: para procesamiento de datos.
  - __Mahout__: para el manejo de los datos dentro de hadoop e implementación de algoritmo de recomendaciones.
  - __ionic 3 / Angular 4__: para creación de capa de presentación web y móvil.
  - __Java EE__: para creación de la lógica de negocios y acceso a datos.
  - __Sqoop 1.4.7__: para el transporte de datos de una plataforma a otra.
  - __MySQL__: para almacenar datos.

## Repositorio Git con estructura inicial del proyecto

Enlace a repositorio git con estructura inicial:

- https://github.com/LibrePlan/libreplan.git

Explicación de estructura inicial:

```text
/__
   |__ readme.md: descripción del proyecto.
   |__ /recommender-frontend: capa de presentación de la aplicación
   |__ /recommender-backend:  DAC y lógica de recomendación
```

## Licencia


Copyright (c) 2018 Dante Faña Badia

Se concede permiso, de forma gratuita, a cualquier persona que obtenga una copia de este software y de los archivos de documentación asociados (el "Software"), para utilizar el Software sin restricción, incluyendo sin limitación los derechos a usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar, y/o vender copias del Software, y a permitir a las personas a las que se les proporcione el Software a hacer lo mismo, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales del Software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A GARANTÍAS DE COMERCIALIZACIÓN, IDONEIDAD PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS AUTORES O TITULARES DEL COPYRIGHT SERÁN RESPONSABLES DE NINGUNA RECLAMACIÓN, DAÑOS U OTRAS RESPONSABILIDADES, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O CUALQUIER OTRO MOTIVO, QUE SURJA DE O EN CONEXIÓN CON EL SOFTWARE O EL USO U OTRO TIPO DE ACCIONES EN EL SOFTWARE.
