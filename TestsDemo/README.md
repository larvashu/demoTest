
# Testy automatyczne aplikacji https://www.saucedemo.com/v1/

Aktualnie obsługiwane przeglądarki:
- Chrome

Uruchamianie lokalnie, wymagania wstępne:
- 1 Instalacja Java JDK21:
https://www.oracle.com/pl/java/technologies/downloads/#java21
- 2  Instalacja maven:
https://maven.apache.org/install.html
- 3 Instalacja scoop + allure:
https://allurereport.org/docs/install-for-windows/

Uruchomienie testów:
- Komendy nalezy wykonywać z poziomu folderu `TestsDemo`
- Pierwszorazowo, lub po modyfikacji zależności w pliku pom: `'mvn clean install -U'`
- W innym przypadku `'mvn clean test'`
- Alternatywnie `'Ctrl+Shift+F10'`


Wyswietlenie raportu:

`allure serve allure-results`


