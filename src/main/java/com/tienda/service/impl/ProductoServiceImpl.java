package com.tienda.service.impl;

import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tienda.dao.ProductoDao;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    //Consulta JPA para traer informacion sobre el precio inferio y superior
    @Override
    @Transactional(readOnly = true)
    public List< Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {

        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    //Consulta JPQL para traer informacion sobre el precio inferio y superior
    @Override
    @Transactional(readOnly = true)
    public List< Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
      @Override
    @Transactional(readOnly = true)
    public List< Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }
}
