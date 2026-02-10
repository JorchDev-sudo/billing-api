# Decisiones Técnicas

Este documento recopila las **principales decisiones técnicas** tomadas durante el desarrollo del MVP, junto con su contexto y justificación. Su objetivo es dejar constancia del razonamiento detrás de cada elección y facilitar la evolución futura del proyecto.

Las decisiones aquí documentadas son **conscientes**, no accidentales.

---

## Decisión 01 — Arquitectura monolítica en capas

### Contexto

El proyecto se encuentra en fase MVP y busca validar dominio, arquitectura y calidad técnica sin introducir complejidad prematura.

### Alternativas consideradas

* Microservicios
* Arquitectura hexagonal completa
* Arquitectura orientada a eventos

### Decisión

Implementar una **arquitectura monolítica en capas**.

### Justificación

* Reduce complejidad inicial
* Facilita testing y debugging
* Acelera el desarrollo sin perder orden
* Permite escalar o modularizar más adelante

### Consecuencias

* El despliegue es único
* El crecimiento debe gestionarse con disciplina

---

## Decisión 02 — API REST stateless

### Contexto

El sistema debe ser fácilmente escalable y desacoplado del estado del servidor.

### Alternativas consideradas

* API stateful con sesiones
* GraphQL

### Decisión

Construir una **API REST completamente stateless**.

### Justificación

* Mejor escalabilidad horizontal
* Simplicidad de integración
* Menor acoplamiento

### Consecuencias

* El cliente debe manejar el estado
* Mayor responsabilidad en la capa de seguridad

---

## Decisión 03 — Autenticación con JWT

### Contexto

Se requiere proteger endpoints sin mantener estado en el servidor.

### Alternativas consideradas

* Sesiones HTTP
* OAuth2 desde el inicio

### Decisión

Implementar **JWT con Spring Security**.

### Justificación

* Compatible con APIs stateless
* Amplio soporte en Spring
* Flexibilidad para futuros clientes

### Consecuencias

* Gestión manual de expiración y revocación
* Mayor cuidado en configuración de seguridad

---

## Decisión 04 — JPA + Hibernate para persistencia

### Contexto

Se necesita una capa de persistencia estable y bien integrada con Spring.

### Alternativas consideradas

* JDBC puro
* MyBatis

### Decisión

Utilizar **JPA con Hibernate**.

### Justificación

* Integración nativa con Spring Boot
* Reducción de boilerplate
* Enfoque orientado a dominio

### Consecuencias

* Requiere cuidado con lazy loading
* Necesidad de diseñar bien las entidades

---

## Decisión 05 — DTOs y MapStruct

### Contexto

Evitar exponer entidades directamente y mantener contratos claros.

### Alternativas consideradas

* Mapear manualmente
* Exponer entidades JPA

### Decisión

Usar **DTOs con MapStruct**.

### Justificación

* Separación clara de capas
* Mappers declarativos y seguros
* Menor error humano

### Consecuencias

* Más clases
* Necesidad de mantener mappers actualizados

---

## Decisión 06 — Testing selectivo y pragmático

### Contexto

El MVP requiere calidad, pero sin frenar el avance.

### Alternativas consideradas

* Cobertura de tests exhaustiva
* Sin tests

### Decisión

Aplicar **testing selectivo**, priorizando lógica crítica.

### Justificación

* Mejor relación costo/beneficio
* Protección de reglas de negocio
* Rapidez de iteración

### Consecuencias

* No todo el código está cubierto
* Se requiere criterio para decidir qué testear

---

## Decisión 07 — Documentación desde el inicio

### Contexto

La mayoría de proyectos MVP carecen de documentación clara.

### Alternativas consideradas

* Documentar al final
* No documentar

### Decisión

Documentar **proceso, decisiones y arquitectura desde el día uno**.

### Justificación

* Claridad futura
* Facilita mantenimiento
* Mejora comunicación técnica

### Consecuencias

* Tiempo adicional de escritura
* Mayor disciplina

---
## Decisión 08 — Integración Continua (CI) desde etapas tempranas
### Contexto

A medida que el proyecto crece, incluso en fase MVP, se vuelve necesario garantizar que cada cambio en el código mantenga un estado mínimo de calidad y estabilidad, sin depender de ejecuciones manuales ni validaciones locales.

### Alternativas consideradas

Ejecutar builds y tests manualmente

Añadir CI/CD solo en fases avanzadas

Incorporar despliegue automático desde el inicio

### Decisión

Implementar una pipeline básica de Integración Continua (CI) desde etapas tempranas del proyecto.

### Justificación

Validación automática de compilación y tests

Detección temprana de errores

Refuerza la disciplina técnica desde el inicio

Sienta las bases para un futuro CD sin complejidad prematura

### Consecuencias

El código debe mantenerse siempre en un estado “buildable”

Los tests dejan de ser opcionales

Cualquier fallo en la pipeline bloquea el avance hasta ser corregido

## 📌 Nota final

Estas decisiones no son definitivas. Están alineadas con el estado actual del proyecto y pueden evolucionar conforme el producto crezca. Cualquier cambio relevante debe quedar reflejado en este documento.
