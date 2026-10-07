S:'process' valideaza , calculeaza si afiseaza , salveaza si trimite notificare. Toate ar trebuii sa fie responsabilitati ale mai multor metode.
O: Daca vrem sa adaugam un nou  tip de procesare, ar trebui sa modificam metoda 'process', ceea ce incalca principiul Open/Closed. Ar fi mai bine sa avem o interfata sau o clasa abstracta pentru procesare, iar fiecare tip de procesare sa fie implementat intr-o clasa separata.
L: Nu avem sublclase sau superclase pentru a decide daca avem Liskov
I:Nu avem o interfata sau un client asa ca nu avem cum sa verificam
D: OrderProcessor , un modul high-level creeaza si depinde de clasele low-level FileDatabase si EmailSender. Ar trebuii abstractizat acest lucru.