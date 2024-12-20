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

## Installation and Setup Guide

## Prerequisites

Before starting, ensure you have the following installed:
1. Java Development Kit (JDK) 11 or newer
2. Android Studio (Latest stable version recommended)
3. Git (for cloning the repository)

## Detailed Installation Steps

### 1. Install Android Studio
1. Download Android Studio from [developer.android.com/studio](https://developer.android.com/studio)
2. Run the installer:
   - Windows: Run the `.exe` file
   - Mac: Drag to Applications folder
   - Linux: Extract the archive and run `studio.sh`
3. Follow the setup wizard to:
   - Install the Android SDK
   - Install the Android Virtual Device (AVD)
   - Set up the development environment

### 2. Configure Android SDK
1. Open Android Studio
2. Go to `Tools > SDK Manager` or `Settings/Preferences > Appearance & Behavior > System Settings > Android SDK`
3. Install the following components:
   - Android 13.0 (API 33) SDK Platform
   - Android SDK Build-Tools 33.0.0
   - Android SDK Command-line Tools
   - Android SDK Platform-Tools
   - Android Emulator
   - Intel x86 Emulator Accelerator (HAXM installer) - for Intel processors
4. Click "Apply" to install selected components

### 3. Clone and Setup the Project
1. Open Terminal/Command Prompt
2. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/taskly.git
   cd taskly
   ```
3. Open Android Studio
4. Select `File > Open`
5. Navigate to the cloned project directory and click "OK"
6. Wait for the project to sync and index

### 4. Configure the Project
1. Open `local.properties` (create if not exists)
2. Ensure SDK path is correct:
   ```properties
   sdk.dir=YOUR_ANDROID_SDK_PATH
   ```
   Replace `YOUR_ANDROID_SDK_PATH` with your actual SDK path:
   - Windows: `C:\\Users\\YourUsername\\AppData\\Local\\Android\\Sdk`
   - Mac: `/Users/YourUsername/Library/Android/sdk`
   - Linux: `/home/YourUsername/Android/Sdk`

### 5. Run the Project
#### Using a Physical Device
1. Enable Developer Options on your Android device:
   - Go to `Settings > About Phone`
   - Tap "Build Number" 7 times
   - Return to Settings, find "Developer Options"
2. Enable USB Debugging in Developer Options
3. Connect your device via USB
4. Select your device from the toolbar device dropdown
5. Click the "Run" button (green play icon) or press `Shift + F10`

#### Using an Emulator
1. Go to `Tools > Device Manager`
2. Click "Create Device"
3. Select a device definition (e.g., Pixel 4)
4. Select a system image (API 33 recommended)
5. Name your virtual device and click "Finish"
6. Select the created emulator from the toolbar
7. Click the "Run" button or press `Shift + F10`

## Troubleshooting

### Common Issues and Solutions

1. Gradle Build Failed
   ```
   Solution:
   - File > Invalidate Caches / Restart
   - Clean Project (Build > Clean Project)
   - Rebuild Project (Build > Rebuild Project)
   ```

2. SDK Location Not Found
   ```
   Solution:
   - Ensure local.properties has correct sdk.dir path
   - Sync Project with Gradle Files
   ```

3. Missing Dependencies
   ```
   Solution:
   - Check build.gradle files for correct dependencies
   - Sync Project with Gradle Files
   - Check internet connection
   ```

4. Device Not Recognized
   ```
   Solution:
   - Enable USB Debugging
   - Try different USB ports/cables
   - Install device manufacturer's USB drivers
   ```

## Running Tests

1. Unit Tests:
   ```bash
   ./gradlew test
   ```

2. Instrumented Tests:
   ```bash
   ./gradlew connectedAndroidTest
   ```

## Project Verification

After installation, verify the project by:
1. Creating a new note
2. Editing an existing note
3. Deleting a note
4. Searching through notes
5. Checking if the grid layout works properly

## Additional Configuration

### Custom Fonts
The project uses Poppins font family. Ensure it's properly synced:
1. Open `res/font/poppins.xml`
2. Sync Project with Gradle Files
3. Rebuild if necessary

### Database Setup
Room database will be automatically created on first run. No additional setup required.

## Development Environment

## Acknowledgments

- Thanks to the Kotlin and Android development communities for their excellent documentation and resources
- This project was created as part of learning Android development with Kotlin

