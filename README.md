# Szoftverfejlesztes_ZH_2022
PE Szoftverfejlesztés ZH 2022 Kedd12 
Név: Keresztúri Gergő
Neptun: X7PT4C

Megoldott feladatok:
- 1
- 2
- 3
- 5

Dokumentáció:
1. Futtatáshoz szükséges állományok:
A program futtatásához szükséges az adott ágon megtalálható összes fájl.
Kiemelten fontos:
- Derby adatbázis mappa (Jelen esetben minden Github ágon .zip fájlként elérhető, kérem csomagolja ki futtatás előtt)
- Gson.jar fájl
- Az elkészített adatbázis mappája (Release verziótól)

Optimális fordítás,futás esetén ajánlott az IntelliJ Idea IDE használata.

2.Specifikáció:
Ezen program egy megadott .csv állomány adataiból beolvasva végzi el az alábbi műveleteket:
- Adatbázisba feltöltés
- Adatbázis lekérdezése
- Adatokat tároló lista keresés alapú szűrése

A program jelenleg ösztöndíj adatokat tárol el az alábbi megadott formában:
- ID
- Cím
- Képzések
- Ösztöndíj
- Dátum
- Helyszín

A jelen Github ágakon megadott forrás .csv állomány tartalmazza a szükséges formátumot

3.Adatbázis architektúra:
SchoolarshipsDB adatbázis
- Egyetlen táblával rendelkezik: Schoolarships
- Az adattábla architektúráját megtalálja a Feladat5 névü Github ágon .pdf formátumban.

Schoolarships tábla architektúrája:
- ID INT PRIMARY KEY
- TITLE VARCHAR(500)
- DEGREES VARCHAR(500)
- FUNDS VARCHAR(50)
- DATE VARCHAR(50)
- LOCATION VARCHAR(50)

4. Telepítés

A program telepítéséhez szükség van az alábbi lépések teljesítésére:
  - Minden állomány letöltése ezen Github-ról, valamely ágról.
  - db-derby-10.14.2.0-bin.zip állomány kicsomagolása
  - Program megjelenítése valamely integrált fejlesztőkörnyezetben
  - Depenencies beállítások: gson.jar és db-derby-10.14.2.0-bin/lib/összes jar állomány
  - Main.java futtatása

5. Use Case Diagram
![use case](https://user-images.githubusercontent.com/96192995/166455551-d15c7a89-cf85-4e42-84d7-0e6a7b777a8b.png)
