# 🧠 KariAI – Smart AI Assistant for Nutrition & Health

**KariAI** is a cross-platform smart assistant that helps users track nutrition, health data, and fitness progress — with a touch of AI personalization.  
Built using Kotlin Multiplatform (KMP), the app runs on both **Android** and **iOS** from a shared codebase.

🌐 Website: [https://kariai.app](https://kariai.app)  
👤 Author: [MVikX](https://github.com/MVikX)  
🗓 Development period: since April 6, 2025 – present  
🚫 License: **Proprietary. All rights reserved.**

---

## 📱 Features (Work in Progress)

- 🌐 Google Sign-In via OAuth2
- 📝 User Details screen (name, birth date, gender, weight, height, allergies, intolerances)
- 📊 Main screen layout and components (UI only, logic in progress)
- 💬 Fake messages and placeholders for AI interaction
- 🎨 Animated UI: arcs, progress, assistant panel, bottom navigation
- 🔒 Basic user data handling and storage

---
## 🧰 Tech Stack

### 📦 Languages & Architecture
- **Kotlin Multiplatform (KMP)** – shared business logic
- **Jetpack Compose Multiplatform** – declarative UI for Android and iOS
- **MVVM** – modern architectural pattern with clean state management
- **Koin** – dependency injection
- **Ktor (Client/Server)** – HTTP networking and server-side APIs
- **DataStore / Multiplatform Settings** – persistent key-value storage
- **Moko Resources** – localization and multi-language support
- **Material 3** – modern material design system

### 🤖 AI & Messaging
- Placeholder for AI chat assistant (API integration planned)
- Fake messages for prototyping conversational interface

### 📊 Health Tracking
- **Health Connect (Android)** – step count, distance, calories (in progress)
- **HealthKit (iOS)** – integration planned

---

## 📂 Project Modules

| Module | Description |
|--------|-------------|
| `api` | Networking layer (Ktor client) |
| `auth` | Authentication (Google, Telegram, planned Apple) |
| `storage` | Data persistence, user preferences |
| `shared` | Core logic, models, ViewModels |
| `composeApp` | Multiplatform UI and navigation |
| `AiChatApi` | Planned integration for AI-based interactions |
| `healthdata` | HealthKit/Health Connect bindings |
| `notifications` | Push/local notification handling |

---

## 🚀 Running the App (Android)

> **Requirements:** Android Studio Hedgehog or newer

1. Clone the repository:
   ```bash
   git clone https://github.com/MVikX/KariAI
   ```
2. Open the project in **Android Studio** as a Kotlin Multiplatform project
3. Launch the `composeApp` module on an Android device or emulator

---

## 🧪 Running on iOS *(Planned)*

> **Requirements:** macOS with Xcode installed

- Set up an iOS target using `UIViewControllerRepresentable`
- Build `shared` and `composeApp` modules in **Xcode**
- Connect to native iOS UI via **Swift** or **Compose for iOS** *(automation planned)*

---

## 🔮 Roadmap

- 🔜 Finalize user registration and onboarding flow
- 🔜 Google Fit / Health Connect data sync
- 🔜 HealthKit integration *(iOS)*
- 🔜 AI chat assistant with real-time responses
- 🔜 Calorie & macro tracking with visual charts
- 🔜 Product scanner and smart food recognition
- 🔜 Notification reminders and goal tracking

---

## 💡 Why KariAI?

Most nutrition apps feel either **too generic** or **overly complex**.  
**KariAI** is built to deliver:

- 🔬 *True personalization* based on user profile and health metrics
- 🧠 *Intelligent AI-powered suggestions* for food, habits, and fitness
- 🪄 *Smooth, modern UI/UX* backed by Kotlin Multiplatform

---

## ⚠️ Status

> KariAI is under **active development**.

Features, APIs, and visuals are subject to **rapid changes**.  
The project is not intended for production or public release at this stage. Use at your own risk during development phase.
---

## 🔒 License

This project is **closed-source** and **proprietary**.  
All rights reserved © 2025 **MVikX**.

> Unauthorized use, redistribution, or modification of any part of the codebase, designs, or assets is strictly prohibited.

For licensing or collaboration inquiries, visit [https://kariai.app](https://kariai.app)
Or contact us via email: **support@kariai.app**
---

## 👨‍🎨 Author

Designed, developed, and maintained by **MVikX**

📬 [GitHub Issues](https://github.com/MVikX/KariAI/issues)  
🌐 [kariai.app](https://kariai.app)