
# Ce am gasit gresit (SOLID)

- S: Clasa veche facea prea multe chestii (calcula, platea, salva). Acum le-am separat.
- O: Daca voiam o reducere noua, trebuia sa modificam codul vechi cu "else if". Acum doar adaugam o clasa noua.
- L: Lipsa de organizare facea grea folosirea claselor derivate.
- I: Nu aveam interfete deloc.
- D: Baza de date era creata direct in cod cu "new". Acum o primim ca paramentru in constructor.