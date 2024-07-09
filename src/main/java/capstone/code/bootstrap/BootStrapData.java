package capstone.code.bootstrap;

import capstone.code.domain.OutsourcedPart;
import capstone.code.domain.Part;
import capstone.code.domain.Product;
import capstone.code.repositories.OutsourcedPartRepository;
import capstone.code.repositories.PartRepository;
import capstone.code.repositories.ProductRepository;
import capstone.code.service.OutsourcedPartService;
import capstone.code.service.OutsourcedPartServiceImpl;
import capstone.code.service.ProductService;
import capstone.code.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private Part part;
    private Product product;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
    if(0 == partRepository.count()) {
        /*Part 1*/
        OutsourcedPart t = new OutsourcedPart();
        t.setCompanyName("Indy Motor Shop");
        t.setName("Headlights");
        t.setInv(50);
        t.setPrice(30.0);
        t.setId(45869);
        t.setMinInv(4);
        t.setMaxInv(200);
        outsourcedPartRepository.save(t);
        OutsourcedPart partOne = null;

        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            if (part.getName().equals("Headlights")) partOne = part;
        }
        System.out.println(partOne.getCompanyName());

        /*Part 2*/
        OutsourcedPart f = new OutsourcedPart();
        f.setCompanyName("Indy Motor Shop");
        f.setName("Frame");
        f.setInv(20);
        f.setPrice(20.0);
        f.setId(17685);
        f.setMinInv(2);
        f.setMaxInv(200);
        outsourcedPartRepository.save(f);
        OutsourcedPart partTwo = null;

        outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            if (part.getName().equals("Frame")) partTwo = part;
        }
        System.out.println(partTwo.getCompanyName());

        /*Part 3*/
        OutsourcedPart s = new OutsourcedPart();
        s.setCompanyName("Indy Motor Shop");
        s.setName("Seats");
        s.setInv(50);
        s.setPrice(5.0);
        s.setId(36587);
        s.setMinInv(2);
        s.setMaxInv(200);
        outsourcedPartRepository.save(s);
        OutsourcedPart partThree = null;

        outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            if (part.getName().equals("Seats")) partThree = part;
        }
        System.out.println(partThree.getCompanyName());

        /*Part 4*/
        OutsourcedPart d = new OutsourcedPart();
        d.setCompanyName("Indy Motor Shop");
        d.setName("Doors");
        d.setInv(40);
        d.setPrice(8.0);
        d.setId(16849);
        d.setMinInv(2);
        d.setMaxInv(200);
        outsourcedPartRepository.save(d);
        OutsourcedPart partFour = null;

        outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            if (part.getName().equals("Doors")) partFour = part;
        }
        System.out.println(partFour.getCompanyName());

        /*Part 5*/
        OutsourcedPart w = new OutsourcedPart();
        w.setCompanyName("Indy Motor Shop");
        w.setName("Windows");
        w.setInv(45);
        w.setPrice(15.0);
        w.setId(48659);
        w.setMinInv(5);
        w.setMaxInv(200);
        outsourcedPartRepository.save(w);
        OutsourcedPart partFive = null;

        outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            if (part.getName().equals("Windows")) partFive = part;
        }
        assert partFive != null;
        System.out.println(partFive.getCompanyName());

    }
    else {
        System.out.println("Repository not empty.");
    }
    if(productRepository.count() == 0)
        {
            Product IndyCar = new Product("Indy Car", 150.0, 20);
            productRepository.save(IndyCar);
            Product Ferrari = new Product("Ferrari", 175.0, 30);
            productRepository.save(Ferrari);
            Product Porsche = new Product("Porsche Cayenne", 190.0, 10);
            productRepository.save(Porsche);
            Product ModelT = new Product("Ford Model T", 210.0, 6);
            productRepository.save(ModelT);
            Product Tesla = new Product("Telsa Model 3", 215.0, 40);
            productRepository.save(Tesla);
        }
    else {
        System.out.println("Repository not empty.");
    }

        /*List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }*/
        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
