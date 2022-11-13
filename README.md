# EntregaMinim1 Examen

**Parte I:**
Se ha creado una interfaz GestorJuego.java donde se definen los métodos principales y algunas funciones extras necesarias para el funcionamiento.

En GestorJuegoImpl.java se implementan todas estas funciones.

Se han creado dos clases modelos principales, User y Partida con las que trabajar. También se han creado tres package en la carpeta modelos que se usarán en la parte 2 como objetos de transferencia. Funcionan todos los métodos y sus tests correspondientes.

Se ha asumido que una partida y un juego son lo mismo (más adelante se intentará modificar esta confusión de concepto)


**Parte II:**
Se ha implementado un servicio REST, UserService.java en el que se implementan todos los métodos CRUD necesarios.

También se han definido objetos de transferencia para evitar ciclos. Tenemos tres package (Reg & Data & EO):

- Reg: 'UserReg' que nos ayudará a generar nuevos usuarios; 'PartidaReg' para generar nuevas partidas.

- Data: 'Actividad' que define un idUser y un idJuego que se usará para el método actividad; 'DatosActivity' que ayudará a poder mostrar los datos de la actividad correctamente; 'DatosPasarNivel' para poder coger los datos de pasar nivel.

- EO: (Extra objects): 'Level' para poder mostrar en swagger el nivel actual del jugador; 'Point' para poder mostrar en swagger los puntos actuales del jugador;

Todos los métodos del servicio REST funcionan correctamente.




