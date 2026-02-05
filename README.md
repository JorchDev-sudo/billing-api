# SaaS de Facturación Electrónica – MVP

> MVP de una API de facturación electrónica orientada al contexto fiscal de Costa Rica, diseñada con foco en buenas prácticas de ingeniería de software, escalabilidad y claridad arquitectónica.

---

## 🧩 ¿Qué es este proyecto?

Este proyecto es el **MVP de un SaaS de facturación electrónica**, cuyo objetivo es permitir a pequeñas y medianas empresas emitir y gestionar comprobantes electrónicos de forma simple y confiable.

El enfoque principal del MVP **no es cubrir todo el dominio fiscal**, sino validar:

* La arquitectura base
* El modelo de dominio
* El flujo técnico de una API de facturación moderna

---

## 🎯 Problema que busca resolver

En Costa Rica, la facturación electrónica es obligatoria, pero muchas soluciones existentes:

* Son costosas para pequeños negocios
* Tienen curvas de aprendizaje altas
* No están pensadas para integrarse fácilmente con otros sistemas

Este proyecto nace como una **alternativa técnica bien diseñada**, extensible y pensada desde API-first.

---

## 🚧 Estado actual del proyecto

🟡 **En desarrollo activo (MVP)**

Actualmente el proyecto incluye:

* Autenticación stateless con JWT
* Gestión básica de usuarios
* Endpoints iniciales para clientes
* Arquitectura en capas claramente definida
* Tests unitarios y de seguridad (en progreso)

> ⚠️ Este proyecto **no está listo para producción**.

---

## 🧠 Alcance del MVP

### Incluye

* API REST con Spring Boot
* Seguridad JWT
* Persistencia con JPA
* Control básico de errores
* Documentación técnica del proceso

### No incluye (por ahora)

* Integración directa con Hacienda
* UI / Frontend
* Facturación avanzada
* Automatización contable

> El alcance está intencionalmente limitado para priorizar calidad técnica.

---

## 🏗️ Arquitectura

El proyecto sigue una **arquitectura en capas**, separando claramente responsabilidades:

* **Controllers**: capa de entrada (API)
* **Services**: lógica de negocio
* **Repositories**: acceso a datos
* **DTOs & Mappers**: transferencia y transformación
* **Security**: autenticación y autorización

Principios aplicados:

* Separation of Concerns
* Stateless API
* Orientación a dominio

Más detalles en `/docs/02-arquitectura.md`.

---

## 🛠️ Stack tecnológico

* **Java 21**
* **Spring Boot 3**
* **Spring Security (JWT, stateless)**
* **JPA / Hibernate**
* **MapStruct**
* **Flyway**
* **H2 (dev)** / **PostgreSQL (prod)**
* **Maven**
* **JUnit & Mockito**

---

## 🧪 Testing

* Tests unitarios para servicios
* Tests de mappers
* Tests de seguridad (JWT, filtros)

El enfoque de testing se basa en **TDD cuando aporta valor**, especialmente en lógica crítica.

---

## ▶️ Ejecutar el proyecto en local

Requisitos:

* Java 21+
* Maven

```bash
mvn clean install
mvn spring-boot:run
```

La API quedará disponible en:

```
http://localhost:8080
```

---

## 📄 Documentación adicional

Toda la documentación técnica y de proceso se encuentra en la carpeta `/docs`:

* Visión del proyecto
* Roadmap
* Decisiones técnicas
* Alcance del MVP

---

## 📌 Nota personal

Este proyecto forma parte de mi proceso de crecimiento como **backend developer**, con foco en:

* Buen diseño
* Claridad arquitectónica
* Construcción de productos reales

También estoy documentando el proceso públicamente en LinkedIn.

---

## 🤝 Contribuciones

Este proyecto está en fase temprana. Feedback técnico y sugerencias son bienvenidas.

---

## 📜 Licencia

Por definir.
