# Chuleta rápida — Spring Data JPA Query Methods

> Objetivo: ver un requerimiento y convertirlo rápido en un método de repositorio, **sin escribir `@Query`**.

---

## 1. Estructura mental

La forma general es:

```java
find + [Top/First/Distinct] + By + CONDICIONES + [OrderBy + CAMPO + Asc/Desc]
```

Ejemplo genérico:

```java
List<User> findTop5DistinctByRole_NameContainingIgnoreCaseOrderByIdDesc(String roleName);
```

Léelo por partes:

```text
find
Top5
Distinct
By
Role_Name
Containing
IgnoreCase
OrderBy
Id
Desc
```

---

# 2. Igualdad

```java
findByName(String name)
```

Equivale a:

```sql
WHERE name = ?
```

También existe:

```java
findByNameEquals(String name)
findByNameIs(String name)
```

Los tres representan igualdad.

---

# 3. AND

```java
findByNameAndCity(String name, String city)
```

Significa:

```text
name = ?
AND
city = ?
```

Recibe **dos parámetros**.

---

# 4. OR

```java
findByNameOrCity(String name, String city)
```

Significa:

```text
name = ?
OR
city = ?
```

Si las dos condiciones deben comparar contra el mismo valor, el Query Method normalmente sigue necesitando dos parámetros:

```java
repository.findByNameOrCity(valor, valor);
```

---

# 5. Containing

Busca texto en cualquier parte.

```java
findByNameContaining(String text)
```

Equivale aproximadamente a:

```sql
LIKE '%texto%'
```

Ejemplo:

```java
findByNameContaining("san")
```

Puede encontrar:

```text
Santiago
Cassandra
Alexander
```

---

# 6. StartingWith

```java
findByNameStartingWith(String text)
```

Equivale a:

```sql
LIKE 'texto%'
```

---

# 7. EndingWith

```java
findByNameEndingWith(String text)
```

Equivale a:

```sql
LIKE '%texto'
```

---

# 8. IgnoreCase

Ignora mayúsculas y minúsculas.

```java
findByNameIgnoreCase(String name)
```

Puede encontrar:

```text
BOGOTA
Bogota
bogota
```

## Combinaciones muy útiles

```java
findByNameContainingIgnoreCase(String text)
```

```java
findByNameStartingWithIgnoreCase(String text)
```

```java
findByNameEndingWithIgnoreCase(String text)
```

```java
findByNameEqualsIgnoreCase(String text)
```

---

# 9. Not / IsNot

```java
findByNameNot(String name)
```

o:

```java
findByNameIsNot(String name)
```

Equivale a:

```sql
WHERE name <> ?
```

También se puede combinar:

```java
findByNameNotContainingIgnoreCase(String text)
```

---

# 10. GreaterThan

```java
findByScoreGreaterThan(Integer value)
```

```text
score > value
```

---

# 11. GreaterThanEqual

```java
findByScoreGreaterThanEqual(Integer value)
```

```text
score >= value
```

---

# 12. LessThan

```java
findByScoreLessThan(Integer value)
```

```text
score < value
```

---

# 13. LessThanEqual

```java
findByScoreLessThanEqual(Integer value)
```

```text
score <= value
```

---

# 14. Between

Muy útil para fechas, pesos, precios, edades, etc.

```java
findByCreatedAtBetween(Timestamp start, Timestamp end)
```

Significa:

```text
createdAt >= start
AND
createdAt <= end
```

También:

```java
findByWeightBetween(Double min, Double max)
```

---

# 15. In

Cuando tienes una lista de valores permitidos.

```java
findByIdIn(List<Integer> ids)
```

Ejemplo:

```java
findByIdIn(List.of(1, 5, 8));
```

Equivale a:

```sql
WHERE id IN (1, 5, 8)
```

---

# 16. NotIn

```java
findByIdNotIn(List<Integer> ids)
```

Equivale a:

```sql
WHERE id NOT IN (...)
```

---

# 17. IsNull

```java
findByEndDateIsNull()
```

Significa:

```sql
WHERE end_date IS NULL
```

Muy útil para cosas como:

```text
relación actual
contrato activo
club actual
registro aún no cerrado
```

---

# 18. IsNotNull

```java
findByEndDateIsNotNull()
```

Significa:

```sql
WHERE end_date IS NOT NULL
```

---

# 19. True / False

Si tienes:

```java
private Boolean active;
```

Puedes hacer:

```java
findByActiveTrue()
```

```java
findByActiveFalse()
```

No reciben parámetros.

---

# 20. OrderBy

## Ascendente

```java
findByCityOrderByNameAsc(String city)
```

```text
A → Z
menor → mayor
más antiguo → más reciente
```

## Descendente

```java
findByCityOrderByNameDesc(String city)
```

```text
Z → A
mayor → menor
más reciente → más antiguo
```

---

# 21. Ordenar por varios campos

```java
findByCityOrderByScoreDescNameAsc(String city)
```

Primero:

```text
score DESC
```

Si empatan:

```text
name ASC
```

---

# 22. Top

```java
findTopByOrderByScoreDesc()
```

Trae solo el primero.

También:

```java
findTop5ByOrderByScoreDesc()
```

Trae máximo 5.

```java
findTop10ByCityOrderByScoreDesc(String city)
```

Trae máximo 10 que cumplan la condición.

---

# 23. First

Funciona parecido a `Top`.

```java
findFirstByOrderByCreatedAtDesc()
```

Trae el más reciente.

También:

```java
findFirst5ByCityOrderByScoreDesc(String city)
```

---

# 24. Distinct

Evita entidades repetidas cuando atraviesas relaciones.

```java
findDistinctByRole_Name(String roleName)
```

Especialmente útil en caminos como:

```text
Entidad
→ colección
→ otra colección
→ atributo
```

Ejemplo genérico:

```java
findDistinctByOrders_Items_Product_Name(String productName)
```

---

# 25. Relaciones / JOIN automático

No escribes `JOIN`.

Spring navega las relaciones usando los atributos Java.

Si tienes:

```text
User
  ↓
role
  ↓
name
```

Puedes escribir:

```java
findByRole_Name(String roleName)
```

Mentalmente:

```text
User.role.name
```

---

# 26. Relaciones largas

Si tienes:

```text
A
↓
bs
↓
c
↓
name
```

El método puede ser:

```java
findByBs_C_Name(String name)
```

La regla es:

```text
empieza en la entidad del Repository
y camina atributo por atributo
hasta llegar al campo que quieres filtrar
```

Ejemplo mental:

```text
Permission
→ rolePermissions
→ role
→ users
→ id
```

Se convierte en:

```java
findByRolePermissions_Role_Users_Id(Integer userId)
```

---

# 27. Relaciones + IsNull

Muy útil para relaciones históricas.

```java
findByPlayerClubs_EndDateIsNull()
```

Significa:

```text
buscar entidades relacionadas
con PlayerClub
cuya endDate todavía sea null
```

También:

```java
findByPlayerClubs_Club_NameAndPlayerClubs_EndDateIsNull(String clubName)
```

---

# 28. Relaciones + filtros múltiples

```java
findByCountry_NameAndScoreGreaterThanEqual(
    String countryName,
    Integer minimumScore
)
```

Se lee:

```text
country.name = ?
AND
score >= ?
```

---

# 29. Relaciones + Between

```java
findByWarehouse_CityAndCreatedAtBetween(
    String city,
    Timestamp start,
    Timestamp end
)
```

---

# 30. Relaciones + ContainingIgnoreCase

```java
findByCategory_NameContainingIgnoreCase(String category)
```

Puedes seguir navegando:

```java
findByOrders_Items_Product_NameContainingIgnoreCase(String product)
```

---

# 31. Relaciones + OR

```java
findByOrigin_CityOrDestination_City(
    String originCity,
    String destinationCity
)
```

Si quieres buscar la misma ciudad en ambos lados:

```java
repository.findByOrigin_CityOrDestination_City(city, city);
```

---

# 32. Distinct + relación

```java
findDistinctByFlights_Destination_Name(String airport)
```

Úsalo cuando una misma entidad pueda coincidir varias veces por diferentes registros relacionados.

---

# 33. Distinct + OrderBy

```java
findDistinctByRole_NameOrderByIdDesc(String roleName)
```

---

# 34. Top + OrderBy

```java
findTop5ByOrderByScoreDesc()
```

Patrón típico para:

```text
Top 5
Top 10
mayores
menores
más recientes
más antiguos
```

---

# 35. Top + condición + OrderBy

```java
findTop5ByCountry_NameOrderByScoreDesc(String countryName)
```

Se lee:

```text
filtra por country.name
ordena por score DESC
toma máximo 5
```

---

# 36. Distinct + Top + condición + OrderBy

```java
findTop5DistinctByCategory_NameOrderByScoreDesc(String category)
```

Piensa así:

```text
Top5
Distinct
By condición
OrderBy campo Desc
```

---

# 37. ExistsBy

Devuelve `boolean`.

```java
boolean existsByEmail(String email);
```

Uso:

```java
if (repository.existsByEmail(email)) {
    ...
}
```

---

# 38. CountBy

Devuelve cantidad.

```java
long countByRole_Name(String roleName);
```

Ejemplo:

```text
¿Cuántos usuarios tienen rol ADMIN?
```

---

# 39. DeleteBy

```java
void deleteByEmail(String email);
```

También puede retornar cantidad eliminada:

```java
long deleteByActiveFalse();
```

---

# 40. Tipo de retorno

## Muchos resultados

```java
List<User>
```

## Puede existir uno o ninguno

```java
Optional<User>
```

## Exactamente uno

```java
User
```

Pero si no estás seguro de que exista:

```java
Optional<User>
```

es normalmente mejor.

---

# 41. Sort dinámico

También puedes pasar `Sort` como parámetro:

```java
List<User> findByCity(String city, Sort sort);
```

Uso:

```java
repository.findByCity(
    "Cali",
    Sort.by(Sort.Direction.DESC, "score")
);
```

Útil si el orden cambia en tiempo de ejecución.

Si el enunciado ya dice exactamente cómo ordenar, suele ser más directo ponerlo en el nombre:

```java
findByCityOrderByScoreDesc(...)
```

---

# 42. Pageable

Sirve para limitar y paginar resultados.

```java
Page<User> findByCity(String city, Pageable pageable);
```

Ejemplo:

```java
PageRequest.of(0, 5, Sort.by("score").descending())
```

Significa:

```text
página 0
5 elementos
ordenados por score DESC
```

---

# 43. Combinaciones útiles para memorizar

```java
ContainingIgnoreCase
```

```java
StartingWithIgnoreCase
```

```java
EndingWithIgnoreCase
```

```java
GreaterThanEqual
```

```java
LessThanEqual
```

```java
IsNull
```

```java
IsNotNull
```

```java
OrderByScoreDesc
```

```java
OrderByDateDesc
```

```java
Top5By
```

```java
DistinctBy
```

```java
Top5DistinctBy
```

---

# 44. Cómo traducir un enunciado rápidamente

Cuando leas una consulta, identifica esto:

```text
1. ¿QUÉ entidad debo retornar?
2. ¿DESDE qué Repository empiezo?
3. ¿POR QUÉ relaciones debo caminar?
4. ¿QUÉ campo filtra?
5. ¿QUÉ operador usa?
6. ¿Hay AND u OR?
7. ¿Hay NULL?
8. ¿Hay rango?
9. ¿Hay orden?
10. ¿Hay Top?
11. ¿Puede haber repetidos?
```

Después construyes:

```text
find
+ Top/Distinct si hace falta
+ By
+ camino
+ operador
+ And/Or
+ otro camino
+ operador
+ OrderBy
+ campo
+ Asc/Desc
```

---

# 45. Traducción rápida de palabras del enunciado

| Si el enunciado dice... | Piensa en... |
|---|---|
| igual a | `findByCampo` |
| contiene | `Containing` |
| empieza por | `StartingWith` |
| termina por | `EndingWith` |
| ignorando mayúsculas | `IgnoreCase` |
| mayor que | `GreaterThan` |
| mayor o igual | `GreaterThanEqual` |
| menor que | `LessThan` |
| menor o igual | `LessThanEqual` |
| entre X y Y | `Between` |
| dentro de estos valores | `In` |
| no tiene valor | `IsNull` |
| tiene valor | `IsNotNull` |
| activo | `True` |
| inactivo | `False` |
| y | `And` |
| o | `Or` |
| sin repetir | `Distinct` |
| primeros N | `TopN` / `FirstN` |
| mayor a menor | `OrderBy...Desc` |
| menor a mayor | `OrderBy...Asc` |
| más reciente primero | `OrderByFechaDesc` |
| más antiguo primero | `OrderByFechaAsc` |

---

# 46. Cuidado con AND + OR

Esto:

```java
findByAAndBOrC(...)
```

se interpreta siguiendo la precedencia de Spring Data.

Cuando la lógica se vuelve muy complicada, el nombre del método puede ser difícil de leer.

Para parcial, intenta primero separar mentalmente:

```text
(A AND B)
OR C
```

o:

```text
A
AND (B OR C)
```

Los Query Methods no son buenos para expresar cualquier agrupación arbitraria con paréntesis.

---

# 47. Cuidado con agregaciones

Query Methods sirven muy bien para:

```text
filtrar
navegar relaciones
ordenar
Top N
Distinct
rangos
null
comparaciones
```

Pero cosas como:

```text
GROUP BY
SUM
AVG
MAX por cada grupo
MIN por cada grupo
HAVING
```

no siempre se pueden expresar limpiamente con un Query Method.

Si un requerimiento dice algo como:

```text
"por cada X, calcule el máximo..."
```

ojo: ahí probablemente hay una agregación real.

---

# 48. Patrón para relaciones históricas

Cuando existe una entidad intermedia con algo como:

```text
startDate
endDate
```

normalmente:

```text
endDate IS NULL
```

significa:

```text
relación actual / vigente
```

y:

```text
endDate IS NOT NULL
```

significa:

```text
relación histórica / terminada
```

Esto aparece mucho en consultas de:

```text
club actual
empleado activo
asignación actual
contrato vigente
```

---

# 49. Mini plantilla final

Antes de escribir el método, llena esto:

```text
RETORNO:
List<________>

REPOSITORY:
________Repository

CAMINO:
Entidad → relación → relación → campo

CONDICIÓN:
= / Containing / >= / Between / IsNull / ...

CONECTOR:
And / Or

ORDEN:
OrderBy________Asc/Desc

LÍMITE:
Top5 / Top10 / First

REPETIDOS:
Distinct sí/no
```

Después armas el nombre.

---

# 50. Ejemplo abstracto completo

Requerimiento imaginario:

```text
Traer los primeros 5 registros diferentes
relacionados con una categoría cuyo nombre contenga cierto texto,
sin importar mayúsculas,
con score >= X,
ordenados por fecha más reciente.
```

Piensa:

```text
Top5
Distinct
By
Category_Name
ContainingIgnoreCase
And
Score
GreaterThanEqual
OrderBy
CreatedAt
Desc
```

Resultado:

```java
findTop5DistinctByCategory_NameContainingIgnoreCaseAndScoreGreaterThanEqualOrderByCreatedAtDesc(
    String category,
    Integer score
);
```

La clave no es memorizar métodos completos.

La clave es memorizar las **piezas** y pegarlas siguiendo el requerimiento.
