package com.upiiz.categorias.services;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//Se crea una instancia de esta clase
@Service
public class CategoriasService {
     // Requerimos el REPO (Datos - listado) - categorias
     // Requiero INYECTAR el repositorio
     CategoriasRepository categoriasRepository;

     // Constructor - Cuando crea la instancia le pasa el repositorio
     public CategoriasService(CategoriasRepository categoriasRepository) {
          this.categoriasRepository = categoriasRepository;
     }

     // GET - todas las categorias
     public List<Categoria> getAllCategorias() {
          return categoriasRepository.obtenerTodas();
     }

     // GET - Categotoria por id
     public Categoria getCategoriaById(Long id) {
          return categoriasRepository.obtenerPorId(id);
     }

     // POST - crear la categoria
     public Categoria createCategoria(Categoria categoria) {
          return categoriasRepository.guardar(categoria);
     }

     // PUT - actualizar categoria
     public Categoria updateCategoria(Categoria categoria) {
          return categoriasRepository.actualizar(categoria);
     }

     // DELETE - eliminar categoria
     public void deleteCategoria(Long id) {
          categoriasRepository.eliminar(id);
     }
}
