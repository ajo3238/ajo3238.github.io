package capstone.code.controllers;

import capstone.code.domain.OutsourcedPart;
import capstone.code.domain.Part;
import capstone.code.service.OutsourcedPartService;
import capstone.code.service.OutsourcedPartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("outsourcedpart",part);
        if(!part.isInvValid()) {
            bindingResult.rejectValue("inv", "invalid.inv", "Error!!: Inventory must be between " + part.getMinInv() + " to " + part.getMaxInv());
        }
        if(part.isInvBelowMin()) {
            bindingResult.rejectValue("inv", "invalid.inv", "Error!!: Inventory must be above " + part.getMinInv());
        }
        if(part.isInvAboveMax()) {
            bindingResult.rejectValue("inv", "invalid.inv", "Error!!: Inventory must be below " + part.getMaxInv());
        }
        if(bindingResult.hasErrors()){
            return "OutsourcedPartForm";
        }
        else{
        OutsourcedPartService repo=context.getBean(OutsourcedPartServiceImpl.class);
        OutsourcedPart op=repo.findById((int)part.getId());
        if(op!=null)part.setProducts(op.getProducts());
            repo.save(part);
        return "confirmationaddpart";}
    }





}
