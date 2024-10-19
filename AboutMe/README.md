# AboutMe Android Application

## Assignment Overview
This project is an Android app built using **Android Java** and follows the **Basic Views Activity** template. The app is designed to present personal information about the user. The directory for this project is named **AboutMe**, as required, and includes all the necessary files such as the APK, screenshots, Word document, and the source code.

### Project Structure
- **Project Name:** AboutMe
- **App Name on Device:** Fouzan
- **Minimum SDK:** 24
- **Target SDK:** Latest Android version

### App Features
1. **Main Screen (Bio Screen):**
   - The app opens with a screen that displays a short biography about the user.
   - The screen contains two buttons: 
     - **Hobbies** – navigates to a screen displaying the user's hobbies.
     - **Contact** – navigates to a screen with the user's contact information.
   
2. **Fragment 2 (Hobbies Screen):**
   - Displays a list or description of the user's hobbies.

3. **Fragment 3 (Contact Screen):**
   - Displays contact information for the user.
   - A toast message appears when navigating to this screen: **“Going to Contact…”**.
   - This fragment is implemented in `FragmentThird.java` and `fragment_third.xml`.

4. **Navigation:**
   - The app's navigation is handled through `nav_graph.xml`, linking the fragments for seamless transitions between screens.

5. **Floating Action Button (FAB):**
   - Clicking the FAB displays a custom message as specified in the assignment.

6. **Menu:**
   - Includes two options: **Settings** and **About**.

### Special Requirements
- **Icon:** The app's icon has been changed to a custom image, replacing the default icon.
- **String Resources:** All text content (buttons, headings, etc.) is managed through `strings.xml`. No hardcoded strings are used in the Java or XML code, in compliance with the assignment guidelines.

### How to Run
1. Clone the repository and open it in **Android Studio**.
2. Build and run the app on an Android emulator or physical device.
3. Alternatively, install the APK (`aboutmefouzan.apk` or replace with your first name) from the root directory onto a device.

### File Details
- **App Directory:** `AboutMe/`
- **APK File:** `aboutmefouzan.apk`
- **Fragments:**
  - `FragmentSecond.java`, `fragment_second.xml` (Hobbies Screen)
  - `FragmentThird.java`, `fragment_third.xml` (Contact Screen)
- **Resource Files:** 
  - `res/values/strings.xml` (contains all text used in the app)
  - `res/navigation/nav_graph.xml` (handles navigation between screens)

### Submission Requirements
- **Word Document:** A Word document containing screenshots of the app, demonstrating the key features, has been added to the root directory.
- **Screenshots:** Screenshots of the app, as outlined in the assignment, are also included at the root.

### Additional Resources
- Android Developer Documentation: [Android Docs](https://developer.android.com/docs)
- Java Documentation: [Java Docs](https://docs.oracle.com/en/java/)

### Student Information
- **Author:** Fouzan Ahmed Mir
