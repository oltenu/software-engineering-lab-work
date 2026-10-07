SOLID principles:

1. Single Responsibility Principle: Clasa OrderProcessor face de toate: valideaza date, calculeaza reduceri, proceseaza comenzi si trimite notificari.
2. Open/Closed Principle: Avem if-uri pentru a verifica tipul de client si tipul de plata, ceea ce inseamna ca trebuie sa modificam codul existent.
3. Liskov Substitution Principle: Nu este incalcat pentru ca nu avem mostenire.
4. Interface Segregation Principle: Nu avem interfete, deci nu putem spune ca este incalcat.
5. Dependency Inversion Principle: Clasa OrderProcessor isi creeaza propriile dependente, de ex new FileDatabase(), in loc sa depinda de interfete primite din exterior.
