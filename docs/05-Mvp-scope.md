# Alcance del MVP (MVP Scope)

Este documento define explícitamente el **alcance funcional y técnico del MVP**. Su objetivo principal es evitar ambigüedades, controlar el scope creep y servir como referencia constante durante el desarrollo.

El MVP busca **validar la base técnica y el modelo de dominio**, no resolver el problema completo de facturación electrónica.

---

## 🎯 Objetivo del MVP

Construir una **API de facturación electrónica mínima pero bien diseñada**, que permita validar:

* Arquitectura base
* Modelo de dominio inicial
* Flujo técnico de una API REST segura
* Buenas prácticas de desarrollo (testing, versionado, documentación)

El éxito del MVP se mide por **calidad y claridad**, no por cantidad de funcionalidades.

---

## ✅ Qué SÍ incluye el MVP

### 🔐 Seguridad y usuarios

* Autenticación stateless con JWT
* Registro y gestión básica de usuarios
* Protección de endpoints

### 🧾 Dominio base

* Entidad Cliente
* Entidad Comprobante (modelo simplificado)
* Relación Cliente–Comprobante
* Estados básicos del comprobante

### ⚙️ Funcionalidad técnica

* API REST
* Persistencia con JPA
* Manejo básico de errores
* Validaciones mínimas de entrada
* Versionado inicial de la API

### 🧪 Calidad

* Tests unitarios en servicios críticos
* Tests de mappers
* Tests básicos de seguridad

---

## ❌ Qué NO incluye el MVP

### 🏛️ Integraciones fiscales

* Comunicación con Hacienda
* Firma digital
* Recepción de estados fiscales
* Manejo de rechazos oficiales

### 💼 Funcionalidad avanzada

* Facturación recurrente
* Notas de crédito / débito
* Automatización contable
* Reportes fiscales

### 🖥️ Experiencia de usuario

* Frontend
* Panel administrativo
* Gestión visual de comprobantes

### 🧠 Complejidad innecesaria

* Microservicios
* Event-driven architecture
* Multi-tenant avanzado
* Optimización prematura

---

## 🚧 Criterios para aceptar nuevas funcionalidades

Una funcionalidad solo puede entrar al MVP si:

1. Refuerza la arquitectura base
2. Aporta al modelo de dominio inicial
3. No introduce complejidad innecesaria
4. Puede implementarse y probarse correctamente

Si no cumple estos criterios, se pospone.

---

## 📌 Decisiones conscientes

Muchas exclusiones del MVP son **decisiones intencionales**, no limitaciones técnicas. El objetivo es:

* Reducir riesgos
* Mantener foco
* Facilitar evolución futura

Este documento tiene prioridad sobre nuevas ideas durante la fase MVP.

---

## 🧭 Relación con otros documentos

* La **visión** define el porqué del proyecto
* El **roadmap** define el cuándo
* Este documento define el **hasta dónde**

Cualquier cambio de alcance debe reflejarse aquí.
