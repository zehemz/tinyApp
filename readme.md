
_**Explicación general TinyApp**_

- Arquitectura general basada en clean Arquitecture
http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/

- RxAndroid para request async.

- Persistencia de datos de usuario con SharedPreferences.

- Request con Retrofit.

- ViewBinding con Butterknife.

- Inyección de dependencias con Dagger2.

_**Pendientes y posibles mejoras a implementar Sobre Tinyapp**_

		Hacer unit test.
		Implementación gráfica de loading.
		Implementación gráfica de Error Message (auth y get tweets).
		Mejora estética general de la aplicación.
		Modelos de dominio.
		Mappers de data a dominio.
		Mappers de dominio a UI models.
		Implementación de scroll infinito.
		Implementación de caché de search.
		A gusto - eliminar del git el .idea y gradle-wrapper dependiendo de como se trabaje en el proyecto.



-----------

_**Propuesta de mejoras en OLX app**_

- Icono de share parece estar al reves.

- Aparece scroll lateral muy pegado al contenido, podía ocultarse ya que es intuitivo.

- Loading modal está poco recomendado por los syleguidelines de android y material design.

- Scroll se traba en la home, probablemente por carga excesiva de vistas.

- Usando monitor de render se observan muchas superposiciones de vista que probocan mucho procesamiento.

- RTL no está soportado.

- Mucha demora en inicio de aplicación.

- Se pueden implementar menus contextuales sobre vistas para agregar acciones rápidas.

- No hay loading cuando se llega al fondo del scroll, esto puede confundir.

- Mensaje de sin conexión mueve todo para abajo, sería mejor que sea un snackbar o similar, manteniendo la linea material design de la app.

[Ver imagenes](ImagenesOlx/)