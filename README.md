### **📌 New Project in IntelliJ IDEA**

![IntelliJ IDEA](https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/120px-IntelliJ_IDEA_Icon.svg.png)

#### **🛠 Project Overview**
This is a Java project built using **Maven** in **IntelliJ IDEA**. It includes essential configurations, dependencies, and a build process to ensure smooth development.

---

## **📂 Project Structure**
```
📛 NewProject  
 └─ src  
   └─ main  
      └─ java  
         └─ Main.java  
   └─ test  
      └─ java  
         └─ MainTest.java  
 └─ pom.xml  
 └─ README.md  
 └─ .gitignore  
```

---

## **🚀 Getting Started**

### **1️⃣ Prerequisites**
Ensure you have the following installed:  
✅ Java (JDK 8 or higher)  
✅ IntelliJ IDEA (Latest version recommended)  
✅ Apache Maven (3.x.x)

---

### **2️⃣ Cloning the Repository**
```sh
git clone https://github.com/KishorDeshmane/NewProject.git  
cd NewProject
```

---

### **3️⃣ Importing the Project into IntelliJ IDEA**
1. Open **IntelliJ IDEA**.
2. Click **"Open"**, then select the project folder.
3. IntelliJ will detect the Maven project automatically.
4. If prompted, select **"Import Maven Projects"**.

---

### **4️⃣ Building the Project**
Run the following Maven command:
```sh
mvn clean install
```

---

### **5️⃣ Running the Application**
To run the application inside IntelliJ IDEA:
- Open `Main.java`.
- Click **Run** ▶ or use the shortcut `Shift + F10`.

To run via the terminal:
```sh
mvn exec:java -Dexec.mainClass="com.example.Main"
```

---

## **🐞 Troubleshooting**
### **❌ Error: 'maven-compiler-plugin version missing'**
✅ **Solution:** Add the following to `pom.xml` inside `<build>` → `<plugins>`
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>
```
After that, reload the Maven project in IntelliJ.

---


---

## **📞 Contact**
For any issues, feel free to open an issue on GitHub or reach out:  
📧 Email: kishor.deshmane@iffort.com  
🔗 GitHub: [KishorDeshmane](https://github.com/KishorDeshmane)

---

