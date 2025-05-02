# Danerick Mod

A Minecraft mod created for fun and to gain more experience with Java coding :)

Feel free to fork this repository and make the mod your own!

---

## Setup Process

### Step 1: Open your terminal and navigate to the folder where you cloned this repository.

### Step 2: Choose your preferred IDE:

#### If you're using **Eclipse**:
1. Run: `./gradlew genEclipseRuns`
2. Open Eclipse, then go to **File > Import > Existing Gradle Project** and select the project folder.
   Alternatively, you can run `./gradlew eclipse` to generate Eclipse project files.

#### If you're using **IntelliJ IDEA**:
1. Open IntelliJ and select **Open Project**.
2. Choose the `build.gradle` file to import the project.
3. Run: `./gradlew genIntellijRuns`
4. Refresh the Gradle project in IDEA if necessary.

---

### Troubleshooting

If you're missing libraries or something isn't working:
- Run `./gradlew --refresh-dependencies` to refresh your local Gradle cache.
- Run `./gradlew clean` to reset the workspace (your code will not be affected).
- Then restart the setup process.

---

### Development

Once everything is set up:

1. Run `./gradlew runData` to generate data (like block/item models).
2. Run `./gradlew runClient` to launch the Minecraft client in development mode.

---

Happy modding!!