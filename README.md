CashOnlineTest

Consideraciones:
Tener alguna version compatible de Java 11
Libre el puerto 8080 para la base de datos

Importar el proyecto como gradle
Setear CashOnlineApplication como main class del proyecto
Levantarlo con start (shift + F10 en IntelliJ)

Una vez levantado, se puede consultar la base de datos en la siguiente URL:
http://localhost:8080/h2-ui
La Base de datos no tiene password
Al levantar, carga un usuario con 50 registros (loans)
Los endpoints de consulta son los siguientes:

GET http://localhost:8080/users/{id} obtiene el usuario con sus prestamos por id
DELETE http://localhost:8080/users/{id} borra el usuario con sus prestamos por id
POST: http://localhost:8080/users crea un usuario sin prestamos, el body del json tiene
el siguiente formato:

{
    "firstName": "asadad",
    "lastName": "asdadasa"
     
}

GET http://localhost:8080/loans?page=0&size=20 obtiene los prestamos por pagina y tamaño de la pagina
GET http://localhost:8080/loans?page=0&size=20&userId=1 obtiene los prestamos por pagina y tamaño de la pagina y usuario

Dentro del proyecto, se encuentra la carpeta logs donde se guardan los logs de error.
Las excepciones se manejan en la clase ExceptionHandlerController
Podria haber usado try catch, pero me parecio mas util manejarlo de forma centralizada para este ejemplo.

Por ultimo, los test son de servicio (valido que pasen donde deberian pasar)
y me quedo pendiente los del store (por alguna razon no puedo darle contexto para usar
con el TestEntityManager)
Puede que me haya quedado corto en este punto, pero tampoco habia mucho mas para testear.

Faltantes:
Quedo por redondear el tema de los test de persistencia
Armar un jar para ejecutarlo desde una terminal sin IDE

