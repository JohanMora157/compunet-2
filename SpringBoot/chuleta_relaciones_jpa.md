# Chuleta rápida — Relaciones JPA

> Objetivo: mirar un diagrama y saber rápido dónde poner `@ManyToOne`, `@OneToMany`, `@JoinColumn`, `mappedBy`, etc.

---

## 1. Regla principal

```text
¿Dónde está la FK?
↓
Ahí normalmente va:
@ManyToOne
@JoinColumn(...)
```

Ejemplo:

```text
PLAYER
id
name
country_id FK
```

Entonces:

```java
@ManyToOne
@JoinColumn(name = "country_id")
private Country country;
```

Y del otro lado:

```java
@OneToMany(mappedBy = "country")
private List<Player> players;
```

---

## 2. Truco rápido: MANY TO ONE

Si lees:

```text
Muchos X pertenecen a un Y
```

Entonces en `X`:

```java
@ManyToOne
@JoinColumn(name = "y_id")
private Y y;
```

Ejemplo:

```text
Muchos jugadores pertenecen a un país
```

```java
@ManyToOne
@JoinColumn(name = "country_id")
private Country country;
```

---

## 3. Truco rápido: ONE TO MANY

Si una entidad tiene muchos elementos relacionados:

```text
Un Country tiene muchos Players
```

Entonces en `Country`:

```java
@OneToMany(mappedBy = "country")
private List<Player> players;
```

Regla mental:

```text
@OneToMany
→ normalmente List<...>
```

---

## 4. `@JoinColumn`

`@JoinColumn` indica qué columna física guarda la FK.

```java
@ManyToOne
@JoinColumn(name = "country_id")
private Country country;
```

Significa:

```text
La tabla actual tiene la columna country_id
```

---

## 5. `mappedBy`

`mappedBy` apunta al **atributo Java del otro lado**.

Si tienes:

```java
// Club
@ManyToOne
@JoinColumn(name = "country_id")
private Country country;
```

Entonces:

```java
// Country
@OneToMany(mappedBy = "country")
private List<Club> clubs;
```

Correcto:

```java
mappedBy = "country"
```

Incorrecto:

```java
mappedBy = "country_id"
```

Porque:

```text
country
→ atributo Java

country_id
→ columna de BD
```

---

## 6. Cómo saber quién es el dueño

El dueño normalmente es:

```text
la entidad que tiene la FK
```

Ejemplo:

```text
CLUB
country_id FK
```

Entonces:

```text
Club
→ dueño
→ @ManyToOne
→ @JoinColumn
```

Y:

```text
Country
→ lado inverso
→ @OneToMany(mappedBy = "country")
```

---

## 7. Patrón 1:N

Diagrama:

```text
COUNTRY 1 -------- N PLAYER
```

En `Player`:

```java
@ManyToOne
@JoinColumn(name = "country_id")
private Country country;
```

En `Country`:

```java
@OneToMany(mappedBy = "country")
private List<Player> players;
```

Chuleta:

```text
Lado N
→ @ManyToOne
→ @JoinColumn

Lado 1
→ @OneToMany(mappedBy = "...")
```

---

## 8. Patrón 1:1

Si una entidad tiene una relación exclusiva con otra:

```text
USER 1 -------- 1 PROFILE
```

Y `USER` tiene:

```text
profile_id FK
```

Entonces:

```java
// User
@OneToOne
@JoinColumn(name = "profile_id")
private Profile profile;
```

Y:

```java
// Profile
@OneToOne(mappedBy = "profile")
private User user;
```

---

## 9. Patrón N:M simple

Si tienes:

```text
ROLE N -------- M PERMISSION
```

y una tabla intermedia simple:

```text
ROLE_PERMISSION
role_id
permission_id
```

Puedes usar:

```java
@ManyToMany
@JoinTable(
    name = "role_permission",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id")
)
private List<Permission> permissions;
```

---

## 10. N:M con atributos propios

Si la tabla intermedia tiene datos adicionales:

```text
PLAYER_CLUB
player_id
club_id
start_date
end_date
```

NO pienses primero en `@ManyToMany`.

Piensa:

```text
Player 1:N PlayerClub
Club   1:N PlayerClub
```

En `PlayerClub`:

```java
@ManyToOne
@JoinColumn(name = "player_id")
private Player player;

@ManyToOne
@JoinColumn(name = "club_id")
private Club club;
```

Y en `Player`:

```java
@OneToMany(mappedBy = "player")
private List<PlayerClub> playerClubs;
```

En `Club`:

```java
@OneToMany(mappedBy = "club")
private List<PlayerClub> playerClubs;
```

---

## 11. Dos FK hacia la misma entidad

Ejemplo:

```text
MATCH
home_country_id FK
away_country_id FK
```

Entonces:

```java
@ManyToOne
@JoinColumn(name = "home_country_id")
private Country homeCountry;

@ManyToOne
@JoinColumn(name = "away_country_id")
private Country awayCountry;
```

Y en `Country`:

```java
@OneToMany(mappedBy = "homeCountry")
private List<Match> homeMatches;

@OneToMany(mappedBy = "awayCountry")
private List<Match> awayMatches;
```

Regla:

```text
Dos FK distintas
→ dos relaciones distintas
```

---

## 12. Tipo de atributo según relación

```text
@ManyToOne
@OneToOne
→ objeto singular
```

Ejemplo:

```java
private Country country;
```

```text
@OneToMany
@ManyToMany
→ colección
```

Ejemplo:

```java
private List<Player> players;
```

---

## 13. Chuleta ultra corta

```text
FK en mi tabla
→ @ManyToOne
→ @JoinColumn

FK en la otra tabla
→ @OneToMany(mappedBy = "...")

1 a 1
→ @OneToOne

N a M simple
→ @ManyToMany + @JoinTable

N a M con atributos propios
→ entidad intermedia
→ dos @ManyToOne
```

---

## 14. Regla de 5 segundos para parcial

```text
1. Mira la cardinalidad.
2. Busca dónde está la FK.
3. Ese lado lleva @ManyToOne + @JoinColumn.
4. El otro lado lleva @OneToMany(mappedBy = "...").
5. Si hay tabla intermedia con datos propios, vuélvela entidad.
```

---

## 15. Errores comunes

### Error 1: usar la columna en `mappedBy`

Mal:

```java
@OneToMany(mappedBy = "country_id")
```

Bien:

```java
@OneToMany(mappedBy = "country")
```

### Error 2: poner `@JoinColumn` en ambos lados

Normalmente:

```text
lado dueño
→ @JoinColumn

lado inverso
→ mappedBy
```

### Error 3: usar `List<>` en un `@ManyToOne`

Mal:

```java
@ManyToOne
private List<Country> countries;
```

Bien:

```java
@ManyToOne
private Country country;
```

### Error 4: usar un objeto único en `@OneToMany`

Mal:

```java
@OneToMany
private Player player;
```

Bien:

```java
@OneToMany
private List<Player> players;
```

---

## 16. Forma mental final

```text
@ManyToOne
→ muchos de esta clase apuntan a uno de la otra
→ normalmente tiene FK
→ usa @JoinColumn
→ atributo singular
```

```text
@OneToMany
→ uno de esta clase tiene muchos de la otra
→ normalmente no tiene la FK
→ usa mappedBy
→ atributo List<>
```

```text
@OneToOne
→ uno con uno
```

```text
@ManyToMany
→ muchos con muchos
→ tabla intermedia
```

---

## 17. Frase para memorizar

```text
"La FK manda"
```

Si encuentras la FK, casi siempre sabes dónde empieza la relación:

```text
FK aquí
→ @ManyToOne + @JoinColumn

al otro lado
→ @OneToMany(mappedBy = "atributo")
```
