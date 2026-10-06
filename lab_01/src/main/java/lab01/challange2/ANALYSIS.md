SRP
Este incalcat deoarece clasa OrderProcessor are prea multe responsabilitati:
valideaza datele, calculeaza pretul, realizeaza plata, salveaza comanda si trimite email-ul

OCP
Este incalcat. Pentru a adauga un nou tip de client sau o noua metoda de plata trebuie sa modificam clasa OrderProcessor si sa adaugam noi conditii if/else

LSP
Nu este incalcat. Codul nu foloseste mostenire sau subclase

ISP
Nu este incalcat. Codul nu contine interfete

DIP 
Este incalcat. OrderProcessor creeaza direct obiecte de tip FileDatabse si EmailSender folosing new, deci depinde direct de clase concrete
