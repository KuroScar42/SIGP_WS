/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.BodegaDto;
import cr.grupojf.sigp.sigp_ws.model.Bodegas;
import cr.grupojf.sigp.sigp_ws.model.BodegasProductos;
import cr.grupojf.sigp.sigp_ws.model.BodegasProductosDto;
import cr.grupojf.sigp.sigp_ws.model.MoveProductDto;
import cr.grupojf.sigp.sigp_ws.model.ProductosDto;
import cr.grupojf.sigp.sigp_ws.model.Productos;
import cr.grupojf.sigp.sigp_ws.model.Proveedores;
import cr.grupojf.sigp.sigp_ws.model.SaveProducto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sigp
 */
@Stateless
@LocalBean
public class ProductosService {

    private static final Logger LOG = Logger.getLogger(MetodoPagoService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;

    public Respuesta guardarProducto(SaveProducto saveProducto) {
        try {
            Productos producto;
            if (saveProducto.getProducto().getId() != null && saveProducto.getProducto().getId() > 0) {
                producto = em.find(Productos.class, saveProducto.getProducto().getId());
                if (producto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el producto especificado", "guardarProducto NoResultException");
                }
                producto.actualizar(saveProducto.getProducto());
                producto = em.merge(producto);
            } else {
                producto = new Productos(saveProducto.getProducto());
                em.persist(producto);
            }
            em.flush();
            for (BodegasProductosDto bd : saveProducto.getBodegasProductos()) {
                BodegasProductosDto bodegaProducto = bd;
                bodegaProducto.setProducto(new ProductosDto(producto));
                Respuesta res = this.guardarProductoBodega(bodegaProducto);
                if (!res.getEstado()) {
                    em.getTransaction().rollback();
                    removeProductById(producto.getIdProducto());
                    return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, res.getMensaje(), res.getMensajeInterno());
                }
            }
//            if (productoDto.getBodega() != null && productoDto.getDetalles() != null) {
//                bodegaProducto = new BodegasProductosDto(new BodegasProductos(productoDto.getDetalles()));
//                bodegaProducto.setBodega(productoDto.getBodega());
//                bodegaProducto.setProducto(productoDto);
//                
//            }
            em.flush();
            em.refresh(producto); // si no funciona para refrescar el guardado de ProductoBodega -> quitar y descomentar la linea de arriba
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "producto", new ProductosDto(producto));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el producto.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el producto.", "guardarCerdo " + e.getMessage());
        }
    }

    private void removeProductById(Integer id) {
        if (id != null && id > 0) {
            try {
                Productos p = em.getReference(Productos.class, id);
                em.remove(p);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Ocurrio un error al eliminar el producto.", e);
            }
        }
    }

    private Respuesta guardarProductoBodega(BodegasProductosDto bodegaProductoDto) {
        try {
            BodegasProductos bodegaProducto;
            if (bodegaProductoDto.getId() != null && bodegaProductoDto.getId() > 0) {
                bodegaProducto = em.find(BodegasProductos.class, bodegaProductoDto.getId());
                if (bodegaProducto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el ProductoBodega especificado", "guardarProductoBodega NoResultException");
                }
                bodegaProducto.actualizar(bodegaProductoDto);
                bodegaProducto = em.merge(bodegaProducto);
            } else {
                bodegaProducto = new BodegasProductos(bodegaProductoDto);
                em.persist(bodegaProducto);
            }
//            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "producto", new BodegasProductosDto(bodegaProducto));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el cerdo.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el producto en la bodega.", "guardarProductoBodega " + e.getMessage());
        }
    }

    public Respuesta moveProduct(MoveProductDto m) {
        try {
            Bodegas origen = null;
            Bodegas destino = null;
            Productos producto = null;
            if (m.getOrigen() != null) {
                if (m.getOrigen().getId() != null && m.getOrigen().getId() > 0) {
                    origen = em.find(Bodegas.class, m.getOrigen().getId());
                }
            }
            if (m.getDestino() != null) {
                if (m.getDestino().getId() != null && m.getDestino().getId() > 0) {
                    destino = em.find(Bodegas.class, m.getDestino().getId());
                }
            }
            if (m.getProducto() != null) {
                producto = em.find(Productos.class, m.getProducto().getId());
            }
            if (origen != null && destino != null && producto != null) {
                try {
                    // obtiene el bodegaProducto del origen
                    Query query = em.createNamedQuery("BodegasProductos.findByBodProd", BodegasProductos.class);
                    query.setParameter("bodega", origen);
                    query.setParameter("producto", producto);
                    BodegasProductos o = (BodegasProductos) query.getSingleResult();
                    if (o.getCantidadProducto() - m.getCantidad() >= 0) {
                        try {
                            query = em.createNamedQuery("BodegasProductos.findByBodProd", BodegasProductos.class);
                            query.setParameter("bodega", destino);
                            query.setParameter("producto", producto);
                            BodegasProductos d = (BodegasProductos) query.getSingleResult();
                            o.setCantidadProducto(o.getCantidadProducto() - m.getCantidad());
                            d.setCantidadProducto(d.getCantidadProducto() + m.getCantidad());
                            // Se actualiza ambas entidades
                            em.merge(o);
                            em.merge(d);

                            em.flush();
                        } catch (NoResultException e) {
                            // en caso de que no se encuentre se crea nuevo y se guarda
                            BodegasProductos d = new BodegasProductos();
                            d.setIdBodega(destino);
                            d.setIdProducto(producto);
                            d.setUnidadMedida(o.getUnidadMedida());
                            d.setPrecioProducto(o.getPrecioProducto());
                            d.setCantidadProducto(m.getCantidad());

                            o.setCantidadProducto(o.getCantidadProducto() - m.getCantidad());
                            em.merge(o);
                            em.persist(d);
                            em.flush();
                        } catch (Exception e) {
                            em.getTransaction().rollback();
                            throw new Exception(e);
                        }
                    }

                } catch (NonUniqueResultException | NoResultException e) {
                    // nunca deberia de estar aqui pero no se sabe
                } catch (Exception e) {
                    LOG.log(Level.SEVERE, "Ocurrio un error al mover producto de bodega.", e);
                    return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al mover el producto.", "moveProduct " + e.getMessage());
                }
            } else {
                throw new Exception("Bodega de origen o destino no existe");
            }
//            if (productoDto.getId() != null && productoDto.getId() > 0) {
//                producto = em.find(Productos.class, productoDto.getId());
//                if (producto == null) {
//                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el cerdo especificado", "Cerdos NoResultException");
//                }
//                producto.actualizar(productoDto);
//                producto = em.merge(producto);
//            } else {
//                producto = new Productos(productoDto);
//                em.persist(producto);
//            }
//            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al mover producto de bodega.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al mover el producto.", "moveProduct " + e.getMessage());
        }
    }

    public Respuesta getProductosByBodega(Integer bodegaId) {
        try {
            Query query = em.createNamedQuery("Productos.findProductosByBodega", Bodegas.class);
            query.setParameter("idBodega", bodegaId);
            List<Productos> productos = query.getResultList();
            List<ProductosDto> productosDtoList = new ArrayList<>();

            for (Productos producto : productos) {
                productosDtoList.add(new ProductosDto(producto));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productos", productosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del inventario.", "getProductosByBodega " + ex.getMessage());
        }
    }

    public Respuesta getProductosByBodegaCompl(Integer bodegaId) {
        try {
            Query query = em.createNamedQuery("Productos.findProductosByBodegaComplete", Bodegas.class);
            query.setParameter("idBodega", bodegaId);

            List<Object[]> productos = query.getResultList();
            List<ProductosDto> productosDtoList = new ArrayList<>();

//            Query q = em.createNamedQuery("Proveedores.AllProvOfProductInBodega",Proveedores.class);
//            q.setParameter("idBodega", bodegaId);
//            q.setParameter("idProducto", bodegaId);
            for (Object[] producto : productos) {
                productosDtoList.add(new ProductosDto((Productos) producto[0], (BodegasProductos) producto[1], ((Productos) producto[0]).getProveedoresList()));
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productos", productosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del inventario.", "getProductosByBodega " + ex.getMessage());
        }
    }

    public Respuesta getProductosByBodegaComplSR(Integer bodegaId) {
        try {
            Query query = em.createNamedQuery("Productos.findProductosByBodegaCompleteSR", Bodegas.class);
            query.setParameter("idBodega", bodegaId);

            List<Object[]> productos = query.getResultList();
            List<ProductosDto> productosDtoList = new ArrayList<>();

            for (Object[] producto : productos) {
                productosDtoList.add(new ProductosDto((Productos) producto[0], (BodegasProductos) producto[1], ((Productos) producto[0]).getProveedoresList()));
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productos", productosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del inventario.", "getProductosByBodega " + ex.getMessage());
        }
    }

    public Respuesta getProductoByBodega(Integer bodegaId, String codigoProd) {
        try {
            Query query = em.createNamedQuery("Productos.findProductoByBodega", Productos.class);
            query.setParameter("idBodega", bodegaId);
            query.setParameter("codigo", codigoProd);
            Object[] resultado = (Object[]) query.getSingleResult();
            ProductosDto productoDto = new ProductosDto((Productos) resultado[0], (BodegasProductos) resultado[1], ((Productos) resultado[0]).getProveedoresList());

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "producto", productoDto);
//return null;
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe el producto con el codigo '" + codigoProd + "' en la bodega consultada.", "getProducByIds " + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del inventario.", "getProducByIds " + ex.getMessage());
        }
    }

    public Respuesta getBodegas() {
        try {
            Query query = em.createNamedQuery("Bodegas.findAllActives", Bodegas.class);
            List<Bodegas> bodegas = query.getResultList();
            List<BodegaDto> bodegasDto = new ArrayList<>();

            for (Bodegas bodega : bodegas) {
                bodegasDto.add(new BodegaDto(bodega));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "bodegas", bodegasDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los inventarios.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los inventarios.", "getBodegas " + ex.getMessage());
        }
    }

}
