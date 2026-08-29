Aquí tienes la guía definitiva en formato Markdown para migrar de **XML a Java Config Puro**, manteniendo tus clases de negocio y repositorios 100% limpias de anotaciones de Spring.

---

# 📖 Guía Paso a Paso: Migración a Spring Java Config Puro (Sin Anotaciones en Clases)

> [!NOTE]
> Con este enfoque, tus clases de Repositorio y Servicio siguen siendo **POJOs Java puros** (sin `@Repository`, `@Service`, ni `@PostConstruct`). Toda la configuración queda encapsulada en una sola clase Java.

---

## 📌 Paso 1: Configurar `web.xml` (El puente con Tomcat)

Modifica tu archivo `web.xml` para indicarle a Spring que reemplace la lectura de archivos XML por la clase de configuración Java `AnnotationConfigWebApplicationContext`:

```xml
<web-app>
  <display-name>Demo Web Application</display-name>

  <!-- 1. Indicar a Spring que usará un contexto Java en lugar de XML -->
  <context-param>
    <param-name>contextClass</param-name>
    <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
  </context-param>

  <!-- 2. Indicar la ruta de la clase Java de configuración (Ruta completa con paquete) -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>com.parcial.config.AppConfig</param-value>
  </context-param>

  <!-- 3. Listener estándar de Spring (se mantiene igual) -->
  <listener>
    <listener-class>
        org.springframework.web.context.ContextLoaderListener
    </listener-class>
  </listener>

</web-app>
```

---

## 📌 Paso 2: Crear la Clase de Configuración `AppConfig.java`

Crea la clase `AppConfig.java` en tu paquete de configuración (ej: `com.parcial.config`). Esta clase sustituye al 100% las etiquetas `<bean>` del archivo XML.

```java
package com.parcial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parcial.repository.IAuthorRepository;
import com.parcial.repository.IPostRepository;
import com.parcial.repository.impl.AuthorRepositoryImpl;
import com.parcial.repository.impl.PostRepositoryImpl;
import com.parcial.service.IAuthorService;
import com.parcial.service.IPostService;
import com.parcial.service.impl.AuthorServiceImpl;
import com.parcial.service.impl.PostServiceImpl;

@Configuration
public class AppConfig {

    // Repositorio de Autores (con método de inicialización init)
    @Bean(initMethod = "init")
    public IAuthorRepository authorRepository() {
        return new AuthorRepositoryImpl();
    }

    // Repositorio de Posts (inyecta authorRepository por parámetro)
    @Bean(initMethod = "init")
    public IPostRepository postRepository(IAuthorRepository authorRepository) {
        return new PostRepositoryImpl(authorRepository);
    }

    // Servicio de Autores
    @Bean
    public IAuthorService authorService(IAuthorRepository authorRepository) {
        return new AuthorServiceImpl(authorRepository);
    }

    // Servicio de Posts
    @Bean
    public IPostService postService(IPostRepository postRepository, IAuthorRepository authorRepository) {
        return new PostServiceImpl(postRepository, authorRepository);
    }
}
```

> [!TIP]
> **Regla de nombres:** El nombre que le des al método `@Bean` (ej: `public IAuthorService authorService()`) se convierte en el **ID del bean** en Spring. Por eso coincide exactamente con lo que buscan los Servlets en `context.getBean("authorService")`.

---

## 📌 Paso 3: Dejar las Clases de Negocio y Repositorios Intactas

No agregues ninguna anotación de Spring (`@Service`, `@Repository`, `@PostConstruct`, etc.) a tus clases de implementación:

* `AuthorRepositoryImpl` ➡️ Clase Java normal
* `PostRepositoryImpl` ➡️ Clase Java normal
* `AuthorServiceImpl` ➡️ Clase Java normal
* `PostServiceImpl` ➡️ Clase Java normal

---

## 📌 Paso 4: Eliminar `applicationContext.xml`

Elimina o borra el archivo `src/main/resources/applicationContext.xml`, ya que fue reemplazado en su totalidad por `AppConfig.java`.

---

## 📊 Tabla de Equivalencias (XML vs Java Config)

| Configuración XML (`applicationContext.xml`) | Java Config (`AppConfig.java`) |
| :--- | :--- |
| `<beans>` | `@Configuration` sobre la clase |
| `<bean id="authorService" class="...">` | Método anotado con `@Bean`: `public IAuthorService authorService() { ... }` |
| `<constructor-arg ref="authorRepository"/>` | Pasar el bean como parámetro del método: `public IAuthorService authorService(IAuthorRepository repo)` |
| `init-method="init"` | Parámetro `initMethod`: `@Bean(initMethod = "init")` |