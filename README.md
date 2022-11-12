# EntregaMinim1 Examen

**Parte I:**
Se ha creado una interfície GestorJuego.java donde se definen los métodos principales y algunas funciones extras necesarias para el funcionamiento.

En GestorJuegoImpl.java se implementan todas estas funciones.

Se han creado dos clases modelos principales User y Partida con las que trabajar

Se han implementado todas las funciones menos la de la actividad, que falta aclarar algunos conceptos.



**Parte II:**
Se ha implementado un servicio REST, UserService.java en el que se implementan todos los métodos CRUD necesarios.

También se han definido objetos de transferencia para evitar ciclos. 

En este caso se han declarado; 'UserReg' que nos ayudará a generar nuevos usuarios; 'PartidaReg' para generar nuevas partidas; 'Actividad' que define un idUser y un idJuego, que se usará tanto para el método actividad como para iniciar partida.

Por otro lado, se ha definido 'DatosPasarNivel' para utilizar en el método PasarNivel.



