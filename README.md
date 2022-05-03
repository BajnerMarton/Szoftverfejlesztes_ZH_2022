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
- Derby adatbázis mappa
- Gson.jar fájl

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
