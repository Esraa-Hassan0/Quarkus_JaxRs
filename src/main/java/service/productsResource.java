package service;

import DAO.productDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.product;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class productsResource {

    productDAO repo = new productDAO();

    @GET
    public Response getAllProducts() {
//        product product = new product(1, "we", 12);
//        repo.add(product);
        List<product> products = repo.listAll();
        return Response.ok(products).build();
    }

    @POST
    public product createProduct(product product) {
        repo.add(product);
        return product;
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") int id, product product) {

        repo.update(id, product.getName(), product.getPrice());
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public product deleteProduct(@PathParam("id") int id) {
        product del = repo.delete(id);
        return del;
    }
}
