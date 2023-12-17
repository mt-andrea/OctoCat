# Octocat szótár alkalmazás

## 1. Ügyfél igény
Az Eszterházy Károly Katolikus Egyetem Bölcsészettudományi és Művészeti Kara felkért minket arra, hogy egy a hallgatók szókincs fejlesztését támogató alkalmazást készítsünk.
### 1.1. Kérések
- 1.1.1. Az alkalmazás használata ne igényeljen internetkapcsolatot.
- 1.1.2. A lehető legegyszerűbb legyen a használata. A használathoz ne legyen szükség betanításra.
## 2. Képernyő tervek
![image](https://github.com/mt-andrea/OctoCat/assets/74617712/2d42b5cb-5757-4958-9d4d-e21daecfd8ca)
![image](https://github.com/mt-andrea/OctoCat/assets/74617712/a3b3f950-1a35-44c5-ac07-26d79fe947ae)
### 2.1 Módosítási javaslat az ügyfél részéről
- 2.1.1. Tartalmazzon több tájékoztató szöveget a felület.
- 2.1.2. Legyen még egy oszlop "Idegen nyelv" névvel, tekintettel azokra a hallgatókra, akik több idegen nyelvet tanulnak párhuzamosan.
- 2.1.3. Az "Angol" nevű oszlopot át kell nevezni. "Idegen nyelvű" legyen a neve, tekintettel azokra a hallgatókra, akik nem angolt tanulnak.
- 2.1.4. Az initialize metódusban megadtam, hogy a TableView oszlopaiba a Szo osztály melyik mezőit kell megjeleníteni!
## 3. A fejlesztés menete
### 3.1 Az ablak létrehozása
- 3.1.1 Az ablakban két fül létrehozása (Szótár és Tanulás fülek)
- 3.1.2 Szűréshez feliratok és szövegdobozok létrehozása 
- 3.1.3 Táblázat létrehozása négy oszloppal
- 3.1.4 Új rekordok létrehozásához feliratok és szövegdobozok létrehozása
- 3.1.5 A Tanulás Tabon elhelyeztem a megfelelő Boxokat a megfelelő feliratokkal.
- 3.1.6 A Tanulás Tabon további Labeleket helyeztem el a megfelelő formázumban
  ### 3.2 Funkcionalitás
- 3.2.1 Adatbázis létrehozása a szavak tárolására
- 3.2.2 A controller osztályban létrehoztam egy példányt a DB osztályból.
- 3.2.3 Megírtam a beolvas metódust.
- 3.2.4 Osztály létrehozása a szavak tárolására a program futása közben 
- 3.2.5 Controll objektumok átmásolása a Controll osztályba
- 3.2.6 Az adatbázisba való beszúrás hozzáadása
- 3.2.7 Rekordok módosításának megoldása
## 4. Tesztelés
- 4.1 Szavak hozzáadásának tesztelése.
- - 4.1.1 Elvárt viselkedés: az alsó szövegmezőkbe beírt adatoknak az eltárolása az adatbázisban a 'Hozzáad' gomb megnyomására.
- - 4.1.2 Tesztadatok: Lecke: 01, Idegen nyelv: angol, Idegen szó: mother, Magyar: anya
- - 4.1.3 Tapasztalt viselkedés: a szövegmezőkbe beírt adatok megjelentek a táblázatban. Ebből lehet következtetni, hogy az adatbázisba is bekerültek.
- 4.2 A táblázatban történő kiválasztás tesztelése.
- - 4.2.1 Elvárt viselkedés: amikor a táblázatban rákattintunk egy sorra, akkor annak az adatai bekerülnek az alsó szövegdobozokba.
- - 4.2.2 Lecke: 01, Idegen nyelv: angol, Idegen szó: mother, Magyar: anya.
- - 4.2.3 A tapasztalt viselkedés: az elvártaknak megfelelő.
- 4.3 Az 'Új' gomb viselkedésének tesztelése.
- - 4.3.1 Tesztadatok: Lecke: 01, Idegen nyelv: német, Idegen szó: die Mutter, Magyar: anya.
- - 4.3.2 Az elvárt viselkedés: az alsó szövegdobozokból a beírt adatok eltűnnek.
- - 4.3.3 A tapasztalt viselkedés az elvártaknak megfelelő.
- 4.4 A 'Módosít' gomb viselkedésének tesztelése
- - 4.4.1 Elvárt viselkedés: a táblázatban kijelölt sor adataiban történt változtatás elmentése az adatbázisban.
- - 4.4.2 Tesztadatok: Lecke: 02, Idegen nyelv: angol, Idegen szó: mom, Magyar: anyuci->anyu.
- - 4.4.3 Tapasztalt viselkedés: a módosítás megjelent a táblázatban, ebből következtethető, hogy az adatbázisban is megtörtént a változtatás.
