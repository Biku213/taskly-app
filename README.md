# Taskly - Simple Todo App

Taskly is a modern, intuitive Android todo application built with Kotlin. This project was developed as part of my Kotlin learning journey, implementing best practices and modern Android development patterns.

## Learning Project Context

This application was created while learning:
- Kotlin programming language fundamentals
- Android app architecture (MVVM)
- Modern Android development practices
- Room database implementation
- Android Navigation Components
- ViewBinding and LiveData

## Features

- Create and manage notes/tasks with titles and descriptions
- Search functionality to quickly find specific notes
- Grid layout for better visualization of multiple tasks
- Edit and update existing notes
- Delete notes with confirmation dialog
- Clean and intuitive Material Design UI
- Responsive layout that works on all Android devices

## Project Structure

```
📦src
 ┣ 📂main
 ┃ ┣ 📂java/com/example/taskly
 ┃ ┃ ┣ 📂adapters          # RecyclerView adapters
 ┃ ┃ ┣ 📂database          # Room database and DAO
 ┃ ┃ ┣ 📂fragments         # UI fragments
 ┃ ┃ ┣ 📂models            # Data models
 ┃ ┃ ┣ 📂repo              # Repository layer
 ┃ ┃ ┣ 📂viewmodel         # ViewModels and Factory
 ┃ ┃ ┗ 📜MainActivity.kt   # Main activity
 ┃ ┣ 📂res
 ┃ ┃ ┣ 📂drawable          # Image resources
 ┃ ┃ ┣ 📂font              # Custom fonts
 ┃ ┃ ┣ 📂layout            # XML layouts
 ┃ ┃ ┣ 📂menu              # Menu resources
 ┃ ┃ ┣ 📂navigation        # Navigation graph
 ┃ ┃ ┗ 📂values            # Resource values
 ┃ ┗ 📜AndroidManifest.xml
```

## Tech Stack

- Kotlin
- MVVM Architecture
- Android Architecture Components
  - Room Database
  - LiveData
  - ViewModel
- Navigation Component
- ViewBinding
- Coroutines
- RecyclerView with DiffUtil
- Material Design Components

## Demo

https://github.com/user-attachments/assets/4db18a39-bced-4957-9502-82a8a8d6b98c


## Requirements

- Android Studio Arctic Fox or newer
- Minimum SDK: API 21 (Android 5.0)
- Target SDK: API 33 (Android 13)
- Kotlin version: 1.8.0 or newer

## Installation

1. Clone the repository
```bash
git clone https://github.com/Biku213/taskly-app.git
```

2. Open the project in Android Studio

3. Build the project:
   - Click on `Build > Make Project`
   - Or use the shortcut `Ctrl + F9` (Windows) or `Cmd + F9` (Mac)

4. Run the app:
   - Connect an Android device or use an emulator
   - Click on `Run > Run 'app'`
   - Or use the shortcut `Shift + F10` (Windows) or `Ctrl + R` (Mac)

## Building from Source

1. Make sure you have the latest version of Android Studio installed

2. Configure your Android SDK:
   - Open Android Studio Settings/Preferences
   - Navigate to Appearance & Behavior → System Settings → Android SDK
   - Install any missing platform SDKs and build tools

3. Sync project with Gradle files:
   - Click "Sync Project with Gradle Files" in the toolbar
   - Or use File → Sync Project with Gradle Files

4. Build the project using the "Build" menu or the provided Gradle tasks


## Acknowledgments

- Thanks to the Kotlin and Android development communities for their excellent documentation and resources
- This project was created as part of learning Android development with Kotlin

