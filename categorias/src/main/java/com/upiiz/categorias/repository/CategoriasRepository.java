package com.upiiz.categorias.repository;

import com.upiiz.categorias.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoriasRepository {
    // Almacenar en un listado las categorias: salvar, listar, eliminar, actualizar,
    // etc.
    // Generar de manera única el id para cada categoría
    private List<Categoria> categorias = new ArrayList<Categoria>();
    private AtomicLong id = new AtomicLong();
    // Agregamos la categoia al listado y la regresamos

    // POST
    public Categoria guardar(Categoria categoria) {
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    // GET - Todas las categorias
    public List<Categoria> obtenerTodas() {

        return categorias;
    }

    // GET - Sólo una categoria
    public Categoria obtenerPorId(Long id) {
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }

    // PUT
    public Categoria actualizar(Categoria categoria) {
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }

    // DELETE
    public void eliminar(Long id) {
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }
}
