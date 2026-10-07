# 1. Single Responsability Principle
Este incalcat, deoarece clasa OrderProcessor are prea multe responsabilitati:
 * verifica datele de intrare
 * calculeaza totalul
 * aplica un dicount
 * proceseaza plata
 * salveaza comanda
 * trimite notificarea

# 2. Open/Close Principle
Este incalcat pentru ca daca vrem sa adaugam un nou tip de client sau o noua metoda de plata, trebuie modificata clasa OrderProcessor si trebuie adaugate noi ramuri

# 3. Liskov Substitution Principle
In codul initial nu este incalcat, deoarece nu foloseste o ierarhie de clase

# 4. Interface Segregation Principle

In codul initial nu este incalcat, deoarece nu defineste interfete

# 5. Dependency Inversion Principle

Este incalcat deoarece creeaza direct dependente concrete folosind "new FileDatabase()" si "new EmailSender()"