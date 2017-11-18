package lab.phb.mhswebapp.controller;

import lab.phb.mhswebapp.repo.PenulisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import lab.phb.mhswebapp.entity.Penulis;
import org.springframework.validation.BindingResult;


@Controller
public class WebController {
    @Autowired
    private PenulisRepo mhsRepo;
	
    @RequestMapping("/daftar-penulis")
    public void daftarPenulis(Model model) {
        model.addAttribute("daftarPenulis", 
                mhsRepo.findAll());
    }
    @RequestMapping("/tambah-data")
    public void tambahData(
        @ModelAttribute("mhs") Penulis mhs,
        BindingResult result){}

    @RequestMapping(value = "/tambah-data",
    	method = RequestMethod.POST)
    public String simpanDataBaru(
        @ModelAttribute("mhs") Penulis mhs,
        BindingResult result){
        System.out.println(mhs.getId());
        mhsRepo.save(mhs);

        return "redirect:/daftar-penulis";
    }

    @RequestMapping("/edit")
    public void getEditForm(
        @RequestParam("id") String id,
        Model model){
        System.out.println("ID yang dikirim: " + id);
        Penulis result = mhsRepo.findOne(id);
        model.addAttribute("mhs", result);
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
        public String SimpanEditData(
            @ModelAttribute("mhs") Penulis mhs,
            BindingResult result){
            System.out.println("id : " + mhs.getId());

            return "redirect:/daftar-penulis";
        }

        @RequestMapping("/hapus")
        public String hapusData(@RequestParam("id") String id){
            mhsRepo.delete(id);
            return "redirect:/daftar-penulis";
        }

    
}
