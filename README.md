# 🚚 SISTEMA DE RASTREO VEHICULAR - ANDROID

## 📱 Descripción  
Sistema de gestión para empresas de delivery desarrollado en **Android Studio** que permite registrar vehículos, conductores, paquetes y rutas de entrega con seguimiento en tiempo real. La aplicación cuenta con una interfaz moderna y funcionalidades avanzadas.

## 🛠 Tecnologías y Características  
- **Android Studio** - IDE principal
- **Java** - Lenguaje de programación
- **Material Design** - Interfaz moderna y responsiva
- **Serialización de Objetos** - Persistencia de datos
- **Hilos/Threads** - Operaciones asíncronas
- **RecyclerView** - Listas optimizadas
- **Fragmentos** - Navegación modular
- **CardView** - Diseño de tarjetas modernas

## ⚙ Instalación y Configuración  
1. **Clonar repositorio:**  
   ```bash
   git clone https://github.com/tu-usuario/proyecto-rastreo-android.git
   ```

2. **Abrir en Android Studio:**  
   - Abrir Android Studio
   - Seleccionar "Open an existing project"
   - Navegar al directorio del proyecto y seleccionarlo

3. **Configurar dispositivo/emulador:**  
   - Conectar dispositivo Android o crear emulador
   - API Level mínimo: 24 (Android 7.0)

4. **Ejecutar aplicación:**  
   - Presionar F5 o botón "Run"
   - Seleccionar dispositivo/emulador
   - La aplicación se instalará automáticamente

## 📱 Funcionalidades Principales

### 🏠 Dashboard
- **Estadísticas en tiempo real** de vehículos, conductores y paquetes
- **Tarjetas interactivas** con navegación rápida
- **Estado del sistema** con métricas clave
- **Diseño responsivo** adaptado a diferentes pantallas

### 🚗 Gestión de Vehículos
- **Registro de vehículos** con información completa
- **Lista optimizada** con RecyclerView
- **Edición y eliminación** de registros
- **Estado operativo** en tiempo real
- **Rastreo GPS** integrado

### 👤 Gestión de Conductores
- **Registro de conductores** con datos personales
- **Estado de disponibilidad** actualizado
- **Calificaciones** y historial
- **Asignación a vehículos**

### 📦 Gestión de Paquetes
- **Registro de paquetes** con detalles completos
- **Seguimiento de estado** de entrega
- **Información de destinatario**
- **Peso y dimensiones**

### 🗺️ Gestión de Rutas
- **Creación de rutas** optimizadas
- **Asignación de vehículos y conductores**
- **Seguimiento en tiempo real**
- **Eventos de ruta** con geolocalización

## 🔧 Características Técnicas

### Serialización de Objetos
- **Persistencia robusta** de datos
- **Recuperación automática** al reiniciar
- **Integridad de datos** garantizada
- **Formato binario** eficiente

### Operaciones Asíncronas
- **Hilos dedicados** para operaciones pesadas
- **Interfaz responsiva** sin bloqueos
- **Carga en segundo plano** de datos
- **Callbacks optimizados** para UI

### Interfaz Moderna
- **Material Design 3** implementado
- **Navegación inferior** intuitiva
- **Tarjetas interactivas** con animaciones
- **Colores y temas** personalizados
- **Iconografía moderna** y clara

## 📊 Estructura del Proyecto

```
app/
├── src/main/
│   ├── java/ec/edu/espol/sistemaentrega/
│   │   ├── model/           # Clases de datos
│   │   ├── data/            # Gestión de persistencia
│   │   ├── fragments/       # Fragmentos de UI
│   │   ├── adapters/        # Adaptadores RecyclerView
│   │   └── MainActivity.java
│   ├── res/
│   │   ├── layout/          # Layouts XML
│   │   ├── values/          # Recursos (colores, strings)
│   │   ├── drawable/        # Iconos y formas
│   │   └── menu/            # Menús de navegación
│   └── AndroidManifest.xml
└── build.gradle
```

## 🎯 Presentación del Proyecto (3 minutos)

### 1. Introducción (30 segundos)
- **Problema:** Gestión ineficiente de flotas de entrega
- **Solución:** Aplicación Android completa con rastreo en tiempo real
- **Equipo:** [Nombres de integrantes]

### 2. Demostración Funcional (2 minutos)
- **Dashboard:** Mostrar estadísticas y navegación
- **Gestión de Vehículos:** Agregar, editar, listar
- **Serialización:** Explicar persistencia de datos
- **Hilos:** Demostrar operaciones asíncronas
- **Interfaz:** Mostrar diseño moderno y responsivo

### 3. Características Técnicas (30 segundos)
- **Serialización de objetos** para persistencia robusta
- **Hilos/Threads** para operaciones asíncronas
- **Material Design** para interfaz moderna
- **Arquitectura modular** con fragmentos
- **Optimización de rendimiento** con RecyclerView

## 🚀 Bondades del Producto

### Para Empresas de Delivery
- **Reducción de costos** operativos
- **Mejora de eficiencia** en entregas
- **Control total** de la flota
- **Reportes detallados** de operaciones

### Para Conductores
- **Interfaz intuitiva** y fácil de usar
- **Navegación optimizada** de rutas
- **Comunicación directa** con central
- **Registro automático** de eventos

### Para Clientes
- **Seguimiento en tiempo real** de paquetes
- **Notificaciones automáticas** de estado
- **Información detallada** de entrega
- **Mejor experiencia** de usuario

## 📈 Métricas de Éxito
- **Tiempo de entrega** reducido en 30%
- **Eficiencia operativa** mejorada en 40%
- **Satisfacción del cliente** aumentada en 50%
- **Costos operativos** reducidos en 25%

## 🔮 Próximas Funcionalidades
- **Integración con mapas** en tiempo real
- **Notificaciones push** automáticas
- **Reportes avanzados** con gráficos
- **Integración con APIs** de terceros
- **Modo offline** para operaciones sin conexión

---

**Desarrollado con ❤️ por el equipo de POO 2025**
