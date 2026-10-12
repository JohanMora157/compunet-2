package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Page<User> findAll(Pageable pageable);
    Optional<User> findById(Integer id);
    void deleteById(Integer id);

    // Búsquedas directas por nombre (adaptado de username al modelo de este proyecto)
    Optional<User> findByNameEquals(String name);
    List<User> findByName(String name);
    List<User> findByNameContaining(String name);
    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameIgnoreCase(String name);
    List<User> findByNameIsNot(String name);
    List<User> findByNameLike(String name);

    // Búsqueda por email
    Optional<User> findByEmail(String email);

    // Búsquedas por fechas de creación
    List<User> findByCreatedAtGreaterThan(Timestamp createdAt);
    List<User> findByCreatedAtLessThan(Timestamp createdAt);
    List<User> findByCreatedAtLessThanEqual(Timestamp createdAt);

    // Búsqueda con lista de IDs
    List<User> findByIdIn(List<Integer> ids);

    // =========================================================================
    // QUERY METHODS CON JOIN (Navegación de propiedades y relaciones)
    // =========================================================================

    // JOIN implícito: User -> Role filtrando por nombre del rol
    List<User> findByRole_Name(String roleName);

    // JOIN implícito: User -> Role filtrando por ID del rol
    List<User> findByRole_Id(Integer roleId);

    // JOIN implícito: User -> Routines filtrando por el nombre de la rutina
    List<User> findByRoutines_Name(String routineName);

    // JOIN implícito: User -> Routines filtrando por coincidencia en la descripción de la rutina
    List<User> findByRoutines_DescriptionContaining(String keyword);

    // =========================================================================
    // CONSULTAS PERSONALIZADAS (@Query JPQL y Nativas)
    // =========================================================================

    @Query("SELECT count(u), year(u.createdAt) FROM User u GROUP BY year(u.createdAt)")
    List<Object[]> countByYearCreated();

    @Query(value = "SELECT * FROM users WHERE name = ?1", nativeQuery = true)
    List<User> findByNameNative(String name);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByNameParam(@Param("name") String name);
}
