package capstone.code.controllers;

import capstone.code.domain.InhousePart;
import capstone.code.service.InhousePartService;
import capstone.code.service.InhousePartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("inhousepart",part);
        if(!part.isInvValid()) {
            theBindingResult.rejectValue("inv", "invalid.inv", "Error!!: Inventory must be between " + part.getMinInv() + " to " + part.getMaxInv());
        }
        if(part.isInvBelowMin()) {
            theBindingResult.rejectValue("inv", "invalid.inv", "Error!!: Inventory must be above " + part.getMinInv());
        }
        if(part.isInvAboveMax()) {
            theBindingResult.rejectValue("inv", "invalid.inv", "Error!!: Inventory must be below " + part.getMaxInv());
        }
        if (theBindingResult.hasErrors()) {
            return "InhousePartForm";
        }
        else
        {
        InhousePartService repo=context.getBean(InhousePartServiceImpl.class);
        InhousePart ip=repo.findById((int)part.getId());
        if(ip!=null)part.setProducts(ip.getProducts());
            repo.save(part);

        return "confirmationaddpart";}
    }




}
