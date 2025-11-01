# 📜 Rules

A simple and flexible **Minecraft Spigot/Paper plugin** that allows server administrators to **manage and display custom server rules** using a `rules.yml` file.  
Perfect for servers that want to provide easily editable in-game or chat-displayed rule messages.

---

## ⚙️ Features

- 🧾 Loads and manages rules from an external `rules.yml` file  
- ✏️ Easily update or replace your server rules  
- 💾 Automatically creates a default `rules.yml` on first launch  
- ⚡ Lightweight and efficient — only loads when needed  

---

## 📁 Installation

1. Download the plugin `.jar` file  
2. Place it inside your server’s `plugins/` folder  
3. Start or reload your server  
4. A file named `rules.yml` will be generated in the plugin folder  

You can open and edit this file at any time to change your server’s rules.

---

## 🧩 Developer Information

**Main utility class:**  
`de.scholle.rules.RulesManager`

**Key methods:**
- `getRulesText()` → Returns the rules text stored in the YAML file  
- `setRulesText(String text)` → Updates the rules text and saves it  
- `loadRules()` → Initializes or reloads the rules file  

**Default file created:**  
`plugins/Rules/rules.yml`

---

## 🧰 Compatibility

- ✅ Works on **Spigot**, **Paper**, and **Purpur**  
- 🧱 Compatible with **Minecraft 1.18+**  
- ⚙️ Requires **Java 17+**

---

## 🧑‍💻 Author

**Developed by:** Scholle  
**Package:** `de.scholle.rules`

---

## 📜 License

This project is licensed under the **Apache License 2.0**.  
You may use, modify, and distribute it in compliance with the terms of that license.  
For more information, see: [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)
