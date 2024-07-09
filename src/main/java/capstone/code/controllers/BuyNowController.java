package capstone.code.controllers;

import capstone.code.domain.Product;
import capstone.code.repositories.ProductRepository;
import capstone.code.service.ProductService;
import capstone.code.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.ApplicationContext;
import capstone.code.domain.Part;

import java.util.List;
import java.util.Optional;

@Controller
public class BuyNowController
{

    @Autowired private ProductRepository productRepository;
    private ProductServiceImpl productServiceImpl;
    private Model model;
    private Product product;
    private ApplicationContext context;
    private Part part;
    private ProductService productService;

    public BuyNowController(ProductService productService){this.productService = productService;}

    @GetMapping("/buyNow")
    public String buyNow(@RequestParam("productID") int productID, Model model)
    {
        Optional<Product> productOptional = Optional.ofNullable(productService.findById(productID));
        if(productOptional.isPresent()) {
            product = productOptional.get();
            if (product.getInv() > 0)
            {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                return "confirmationbuyproduct";
            } else {
                return "errorbuynow";
            }
        }else {
            return "errorbuynow";
        }
    }
}