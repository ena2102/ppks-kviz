# KvizApp

## Upute za korištenje:

### 1. Namjestiti postavke za povezivanje s bazom u application.properties:

U datoteci **application.properties**, postavite sljedeće:
properties

**spring.datasource.url=jdbc:vaš_url_baze**

**spring.datasource.username=korisnik**

**spring.datasource.password=lozinka** 

### 2. Pokrenuti PpksKvizBackendApplication u PpksKvizBackendApplication.java:
Ili iz terminala s mvn spring-boot:run **mvn spring-boot:run**

### 3. Pokrenuti frontend aplikaciju:

Otvorite terminal i pozicionirajte se u direktorij **ppks-kviz-frontend**.

Izvršite naredbu **npm install** kako biste instalirali sve potrebne pakete.

Nakon završetka instalacije, pokrenite aplikaciju naredbom **npm start**.

### 7. Aplikacija je spremna za korištenje:

Nakon što se frontend aplikacija uspješno pokrene, otvorite web preglednik i posjetite http://localhost:3000 kako biste pristupili aplikaciji.
