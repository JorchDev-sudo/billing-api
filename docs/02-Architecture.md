# Arquitectura del Proyecto

Este documento describe la arquitectura del MVP, las decisiones estructurales adoptadas y los principios que guían la organización del código. El objetivo es **claridad, mantenibilidad y evolución controlada**, no complejidad innecesaria.

---

## 🏗️ Enfoque arquitectónico

El proyecto está construido como una **API REST monolítica**, siguiendo una **arquitectura en capas**, adecuada para un MVP que busca validar dominio y diseño antes de escalar.

Este enfoque permite:

* Desarrollo rápido sin sacrificar orden
* Facilidad de testing
* Evolución progresiva hacia arquitecturas más complejas si es necesario

---

## 🧱 Capas del sistema

La aplicación se divide en las siguientes capas principales:

### 🎮 Controllers (Capa de entrada)

Responsables de:

* Exponer endpoints REST
* Validar inputs básicos
* Orquestar llamadas a servicios

No contienen lógica de negocio.

---

### 🧠 Services (Lógica de negocio)

Responsables de:

* Implementar reglas de negocio
* Coordinar operaciones entre entidades
* Definir transacciones

Esta capa concentra la lógica crítica del sistema.

---

### 🗄️ Repositories (Persistencia)

Responsables de:

* Acceso a datos mediante JPA
* Abstracción de la base de datos

No contienen lógica de negocio.

---

### 🔄 DTOs y Mappers

Responsables de:

* Separar modelos internos de contratos externos
* Evitar exposición directa de entidades
* Transformar datos entre capas

Se utiliza **MapStruct** para mantener mappers declarativos y seguros.

---

### 🔐 Security

Responsable de:

* Autenticación stateless con JWT
* Autorización basada en roles
* Protección de endpoints

El sistema es completamente **stateless**.

---

## 🔄 Flujo general de una petición

1. El cliente realiza una petición HTTP
2. El Controller recibe y valida el request
3. El Service ejecuta la lógica de negocio
4. El Repository interactúa con la base de datos
5. El resultado se transforma en DTO
6. El Controller retorna la respuesta

---

## 🧪 Testing y arquitectura

La arquitectura está diseñada para facilitar testing:

* Services testeables de forma aislada
* Repositories mockeables
* Seguridad testeada por separado

Se prioriza testing en capas donde **aporta más valor**.

---

## 🚫 Decisiones arquitectónicas descartadas

Durante el MVP se decidió **no implementar**:

* Microservicios
* Arquitectura orientada a eventos
* CQRS
* Arquitectura hexagonal completa

Estas decisiones se tomaron para evitar complejidad prematura.

---

## 🌱 Evolución futura

La arquitectura permite evolucionar hacia:

* Separación de módulos
* Exposición pública de la API
* Escalado horizontal
* Posible migración a arquitecturas más distribuidas

Sin necesidad de reescribir la base.

---

## 📌 Nota final

La arquitectura del MVP prioriza **entendibilidad y control**. Cualquier evolución futura debe respetar estos principios.
