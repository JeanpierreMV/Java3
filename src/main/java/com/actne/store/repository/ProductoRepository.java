package com.actne.store.repository;

import com.actne.store.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    @Query(value = "SELECT o FROM Producto o WHERE o.status='A'")
    List<Producto> getAllActiveProducto();

    @Query(value = "SELECT o FROM Producto o WHERE o.descripcion LIKE %:searchName% And o.status='A'")
    List<Producto> getAllActiveProductoBySearch(@Param("searchName")String searchName);
}
