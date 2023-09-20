# BANCO UNION
JEFFERSON ALEXANDER MORENO BARRERA
*****************************************************************************************************************************************************************
###  Solucion de la prueba 

Para el desarrollo de la prueba se usaron las siguientes tecnologías:

1.  Maven: Gestor de dependencias para el manejo del empaquetado e implementación de librerías externas
2.  Spring Boot: Modulo de spring para el desarrollo de la API REST 
3.  Java 11: leguaje de codificación del aplicativo
4.  Eclipse: IDE de desarrollo
5.  GIT: software de manejo de versiones de la API
6.  Postman: Plataforma para el diseño y pruebas de API
7.  JWT: Api para el manejo de tockens
8.  Flyway:para realizar la migracion de datos
9.  h2:Base de datos envevida en spring
10. gson: Biblioteca para el manejo de los JSON
11. swagger2: Documentacion de las APIS
12. GitHub: Plataforma para alojar el código fuente de la API     

### URL API REST
### JSON DE ENTRADA
##### Servicio authenticate metodo POST 
http://localhost:8080/authenticate
```json
{
    "username":"bancounion",
    "password":"password"
}
```
##### Servicio get metodo GET
http://localhost:8080/V1/API/get

```json
NO APLICA
```

##### Servicio put metodo PUT
http://localhost:8080/V1/API/get

```json
{
    "id":9,
    "name":"Jefferson Moreno Barrera"
}
```

##### Servicio post metodo POST
http://localhost:8080/V1/API/post

```json
{
    "id":9,
    "name":"Jefferson Moreno Casas"
}
```

##### Servicio delete metodo DELETE
http://localhost:8080/V1/API/delete

```json
{
    "id":9
}
```

##### Poner en todos los servicios las siguientes cabeceras
Header

Key = Content-Type 

Value = application/json

Authorization= Token generado en servicio authenticate

