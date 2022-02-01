package com.example.project7.controllers;

import com.example.IP.models.*;
import com.example.IP.reposit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class IpController {

    @Autowired
    private RabochieRepository rabochieRepository;
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private ReadersRepository readersRepository;
    @Autowired
    private BuhgaltRepository buhgaltRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private PisateliRepository pisateliRepository;
    @Autowired
    private DirectorsRepository directorsRepository;
    @Autowired
    private SkidkiRepository skidkiRepository;
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private NakladnayaRepository nakladnayaRepository;
    @Autowired
    private ZdanieRepository zdanieRepository;
    @Autowired
    private ZalRepository zalRepository;
    @Autowired
    private MagazinBiblioRepository magazinBiblioRepository;
    @Autowired
    private ElectroSsilkiRepository electroSsilkiRepository;






    @GetMapping("/book")
    public String BookView(Model model) {
        Iterable<Books> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "Book-view";
    }

    @GetMapping("/book/add")
    public String BookAdd(Books books) {

        return "Book-add";
    }

    @PostMapping("/book/add")
    public String BookAdd(@Valid Books books, BindingResult bindingResult, @RequestParam String author,
                          @RequestParam String toms, @RequestParam String name,
                             Model model) {
        if (bindingResult.hasErrors())
            return "Book-add";
        List<Books> res = booksRepository.findByName(name);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такие данные книги уже есть!");
            bindingResult.addError(error);
            return "Book-add";
        }

        else {
            booksRepository.save(books);
            return "redirect:/book";
        }
    }


    @GetMapping("/rabochies")
    public String rabochieView(Model model) {
        Iterable<Rabochie> rabochies = rabochieRepository.findAll();
        model.addAttribute("rabochie", rabochies);
        return "Rabochie-view";
    }

    @GetMapping("/rabochies/add")
    public String rabochieAdd(Rabochie rabochie) {

        return "Rabochie-add";
    }

    @PostMapping("/rabochies/add")
    public String rabochieAdd(@Valid Rabochie rabochie, BindingResult bindingResult, @RequestParam String zp, @RequestParam String name,
                              @RequestParam String role, Model model) {
        if (bindingResult.hasErrors())
            return "Rabochie-add";
        List<Rabochie> res = rabochieRepository.findByRole(role);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("role","Такая должность уже есть!");
            bindingResult.addError(error);
            return "Rabochie-add";
        }

        else {
            rabochieRepository.save(rabochie);
            return "redirect:/rabochies";
        }
    }

    @GetMapping("/rabochie/{id}/detail")
    public String rabochieDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Rabochie> rabochie = rabochieRepository.findById(id);
        ArrayList<Rabochie> result = new ArrayList<>();
        rabochie.ifPresent(result::add);
        model.addAttribute("rabochies", result);
        return "rabochie-detail";
    }
    @PostMapping("/rabochie/result")
    public String rabochieSearch(@RequestParam String role, Model model) {
        List<Rabochie> result2 = rabochieRepository.findByRole(role);
        model.addAttribute("rabochies", result2);
        return "Rabochie-view";
    }

    @GetMapping("/rabochie/{id}/edit")
    public String rabochieEdit(@PathVariable(value = "id") Long id,Rabochie rabochie, Model model){
        if(!rabochieRepository.existsById(id))
        {
            return "redirect:/rabochie";
        }

        Optional<Rabochie> rabochie1 = rabochieRepository.findById(id);
        ArrayList<Rabochie> res = new ArrayList<>();
        rabochie1.ifPresent(res::add);
        model.addAttribute("rabochieEdit", res);
        return "rabochie-edit";
    }

    @PostMapping("/rabochie/{id}/edit")
    public String rabochiePostUpdate(@Valid Rabochie rabochie,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String zp,
                                     @RequestParam String name, @RequestParam String role,
                                     Model model){
        List<Rabochie> res = rabochieRepository.findByName(name);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(rabochie);
            model.addAttribute("rabochieEdit",res);
            return "rabochie-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такой Сотрудник уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(rabochie);
            model.addAttribute("rabochieEdit",res);
            return "rabochie-edit";
        }
        else {
            rabochieRepository.save(rabochie);
            return "redirect:/rabochies";
        }
    }

    @GetMapping("/rabochie/{id}/remove")
    public String rabochiePostDelete(@PathVariable(value = "id") Long id, Model model){
        Rabochie rabochie = rabochieRepository.findById(id).orElseThrow();
        rabochieRepository.delete(rabochie);
        return "redirect:/rabochies";
    }


    @GetMapping("/book/{id}/detail")
    public String bookDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Books> books = booksRepository.findById(id);
        ArrayList<Books> result = new ArrayList<>();
        books.ifPresent(result::add);
        model.addAttribute("books", result);
        return "book-detail";
    }
    @PostMapping("/book/result")
    public String bookSearch(@RequestParam String Name, Model model) {
        List<Books> result2 = booksRepository.findByNameContaining(Name);
        model.addAttribute("books", result2);
        return "Book-view";
    }

    @GetMapping("/book/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") Long id,Books books, Model model){
        if(!booksRepository.existsById(id))
        {
            return "redirect:/book";
        }

        Optional<Books> books1 = booksRepository.findById(id);
        ArrayList<Books> res = new ArrayList<>();
        books1.ifPresent(res::add);
        model.addAttribute("bookEdit", res);
        return "book-edit";
    }

    @PostMapping("/book/{id}/edit")
    public String bookPostUpdate(@Valid Books books,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String author,
                                    @RequestParam String toms, @RequestParam String name,
                                    Model model){
        List<Books> res = booksRepository.findByName(name);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(books);
            model.addAttribute("bookEdit",res);
            return "book-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такая книга уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(books);
            model.addAttribute("bookEdit",res);
            return "book-edit";
        }
        else {
            booksRepository.save(books);
            return "redirect:/book";
        }
    }

    @GetMapping("/book/{id}/remove")
    public String bookPostDelete(@PathVariable(value = "id") Long id, Model model){
        Books books = booksRepository.findById(id).orElseThrow();
        booksRepository.delete(books);
        return "redirect:/book";
    }


    @GetMapping("/readers")
    public String readersView(Model model) {
        Iterable<Readers> readers = readersRepository.findAll();
        model.addAttribute("readers", readers);
        return "Reader-view";
    }

    @GetMapping("/readers/add")
    public String readerAdd(Readers readers) {

        return "Reader-add";
    }

    @PostMapping("/readers/add")
    public String readerAdd(@Valid Readers readers, BindingResult bindingResult, @RequestParam String FIO, @RequestParam String age,
                             Model model) {
        if (bindingResult.hasErrors())
            return "Reader-add";
        List<Readers> res = readersRepository.findByFIO(FIO);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("FIO","Такие данные ФИО уже есть!");
            bindingResult.addError(error);
            return "Reader-add";
        }

        else {
            readersRepository.save(readers);
            return "redirect:/readers";
        }
    }


    @GetMapping("/readers/{id}/detail")
    public String readerDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Readers> readers = readersRepository.findById(id);
        ArrayList<Readers> result = new ArrayList<>();
        readers.ifPresent(result::add);
        model.addAttribute("readers", result);
        return "readers-detail";
    }
    @PostMapping("/readers/result")
    public String readerSearch(@RequestParam String age, Model model) {
        List<Readers> result2 = readersRepository.findByAge(age);
        model.addAttribute("readers", result2);
        return "Reader-view";
    }


    @GetMapping("/readers/{id}/edit")
    public String readerEdit(@PathVariable(value = "id") Long id,Readers readers, Model model){
        if(!readersRepository.existsById(id))
        {
            return "redirect:/readers";
        }

        Optional<Readers> readers1 = readersRepository.findById(id);
        ArrayList<Readers> res = new ArrayList<>();
        readers1.ifPresent(res::add);
        model.addAttribute("readerEdit", res);
        return "reader-edit";
    }

    @PostMapping("/readers/{id}/edit")
    public String readerPostUpdate(@Valid Readers readers,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String age,
                                    @RequestParam String FIO,
                                    Model model){
        List<Readers> res = readersRepository.findByFIO(FIO);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(readers);
            model.addAttribute("readerEdit",res);
            return "reader-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("FIO","Такой Читатель уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(readers);
            model.addAttribute("readerEdit",res);
            return "reader-edit";
        }
        else {
            readersRepository.save(readers);
            return "redirect:/readers";
        }
    }

    @GetMapping("/readers/{id}/remove")
    public String readerPostDelete(@PathVariable(value = "id") Long id, Model model){
        Readers readers = readersRepository.findById(id).orElseThrow();
        readersRepository.delete(readers);
        return "redirect:/readers";
    }






    @GetMapping("/buhgalt")
    public String buhgaltView(Model model) {
        Iterable<Buhgalt> buhgalts = buhgaltRepository.findAll();
        model.addAttribute("buhgalt", buhgalts);
        return "Buhgalt-view";
    }

    @GetMapping("/buhgalt/add")
    public String buhgaltAdd(Buhgalt buhgalt) {

        return "Buhgalt-add";
    }

    @PostMapping("/buhgalt/add")
    public String buhgaltAdd(@Valid Buhgalt buhgalt, BindingResult bindingResult, @RequestParam String viruchka,@RequestParam String colBooks,
                            @RequestParam String month,
                            Model model) {
        if (bindingResult.hasErrors())
            return "Buhgalt-add";
        List<Buhgalt> res = buhgaltRepository.findByMonth(month);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("month","Такие данные месяца уже есть!");
            bindingResult.addError(error);
            return "Buhgalt-add";
        }

        else {
            buhgaltRepository.save(buhgalt);
            return "redirect:/buhgalt";
        }
    }


    @GetMapping("/buhgalt/{id}/detail")
    public String buhgaltDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Buhgalt> buhgalt = buhgaltRepository.findById(id);
        ArrayList<Buhgalt> result = new ArrayList<>();
        buhgalt.ifPresent(result::add);
        model.addAttribute("buhgalt", result);
        return "buhgalt-detail";
    }
    @PostMapping("/buhgalt/result")
    public String buhgaltSearch(@RequestParam String month, Model model) {
        List<Buhgalt> result2 = buhgaltRepository.findByMonth(month);
        model.addAttribute("buhgalt", result2);
        return "Buhgalt-view";
    }


    @GetMapping("/buhgalt/{id}/edit")
    public String buhgaltEdit(@PathVariable(value = "id") Long id,Buhgalt buhgalt, Model model){
        if(!buhgaltRepository.existsById(id))
        {
            return "redirect:/buhgalt";
        }

        Optional<Buhgalt> buhgalt1 = buhgaltRepository.findById(id);
        ArrayList<Buhgalt> res = new ArrayList<>();
        buhgalt1.ifPresent(res::add);
        model.addAttribute("buhgaltEdit", res);
        return "buhgalt-edit";
    }

    @PostMapping("/buhgalt/{id}/edit")
    public String buhgaltPostUpdate(@Valid Buhgalt buhgalt,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String viruchka,
                                   @RequestParam String colBooks, @RequestParam String month,
                                   Model model){
        List<Buhgalt> res = buhgaltRepository.findByMonth(month);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(buhgalt);
            model.addAttribute("buhgaltEdit",res);
            return "buhgalt-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("month","Такой месяц уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(buhgalt);
            model.addAttribute("buhgaltEdit",res);
            return "buhgalt-edit";
        }
        else {
            buhgaltRepository.save(buhgalt);
            return "redirect:/buhgalt";
        }
    }

    @GetMapping("/buhgalt/{id}/remove")
    public String buhgaltPostDelete(@PathVariable(value = "id") Long id, Model model){
        Buhgalt buhgalt = buhgaltRepository.findById(id).orElseThrow();
        buhgaltRepository.delete(buhgalt);
        return "redirect:/buhgalt";
    }




    @GetMapping("/adress")
    public String adressView(Model model) {
        Iterable<Adress> adresses = adressRepository.findAll();
        model.addAttribute("adress", adresses);
        return "Adress-view";
    }

    @GetMapping("/adress/add")
    public String adresAdd(Adress adress) {

        return "Adress-add";
    }

    @PostMapping("/adress/add")
    public String adressAdd(@Valid Adress adress, BindingResult bindingResult, @RequestParam String ulica,@RequestParam String town,
                             Model model) {
        if (bindingResult.hasErrors())
            return "Adress-add";
        List<Adress> res = adressRepository.findByTown(town);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("town","Такие данные города уже есть!");
            bindingResult.addError(error);
            return "Adress-add";
        }

        else {
            adressRepository.save(adress);
            return "redirect:/adress";
        }
    }


    @GetMapping("/adress/{id}/detail")
    public String adressDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Adress> adress = adressRepository.findById(id);
        ArrayList<Adress> result = new ArrayList<>();
        adress.ifPresent(result::add);
        model.addAttribute("adress", result);
        return "adress-detail";
    }

    @PostMapping("/adress/result")
    public String adressSearch(@RequestParam String town, Model model) {
        List<Adress> result2 = adressRepository.findByTown(town);
        model.addAttribute("adress", result2);
        return "Adress-view";
    }


    @GetMapping("/adress/{id}/edit")
    public String adressEdit(@PathVariable(value = "id") Long id,Adress adress, Model model){
        if(!adressRepository.existsById(id))
        {
            return "redirect:/adress";
        }

        Optional<Adress> adress1 = adressRepository.findById(id);
        ArrayList<Adress> res = new ArrayList<>();
        adress1.ifPresent(res::add);
        model.addAttribute("adressEdit", res);
        return "adress-edit";
    }

    @PostMapping("/adress/{id}/edit")
    public String adressPostUpdate(@Valid Adress adress,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String ulica,
                                    @RequestParam String town,
                                    Model model){
        List<Adress> res = adressRepository.findByTown(town);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(adress);
            model.addAttribute("adressEdit",res);
            return "adress-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("town","Такой город уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(adress);
            model.addAttribute("adressEdit",res);
            return "adress-edit";
        }
        else {
            adressRepository.save(adress);
            return "redirect:/adress";
        }
    }

    @GetMapping("/adress/{id}/remove")
    public String adressPostDelete(@PathVariable(value = "id") Long id, Model model){
        Adress adress = adressRepository.findById(id).orElseThrow();
        adressRepository.delete(adress);
        return "redirect:/adress";
    }





    @GetMapping("/pisateli")
    public String pisatelView(Model model) {
        Iterable<Pisateli> pisatelis = pisateliRepository.findAll();
        model.addAttribute("pisateli", pisatelis);
        return "Pisateli-view";
    }

    @GetMapping("/pisateli/add")
    public String pisatelAdd(Pisateli pisateli) {

        return "Pisateli-add";
    }

    @PostMapping("/pisateli/add")
    public String pisatelAdd(@Valid Pisateli pisateli, BindingResult bindingResult, @RequestParam String staz,@RequestParam String FIO,
                             @RequestParam String book,
                            Model model) {
        if (bindingResult.hasErrors())
            return "Pisateli-add";
        List<Pisateli> res = pisateliRepository.findByFIO(FIO);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("FIO","Такие данные ФИО уже есть!");
            bindingResult.addError(error);
            return "Pisateli-add";
        }

        else {
            pisateliRepository.save(pisateli);
            return "redirect:/pisateli";
        }
    }


    @GetMapping("/pisateli/{id}/detail")
    public String pisateliDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Pisateli> pisateli = pisateliRepository.findById(id);
        ArrayList<Pisateli> result = new ArrayList<>();
        pisateli.ifPresent(result::add);
        model.addAttribute("pisateli", result);
        return "pisateli-detail";
    }

    @PostMapping("/pisateli/result")
    public String pisateliSearch(@RequestParam String staz, Model model) {
        List<Pisateli> result2 = pisateliRepository.findByStaz(staz);
        model.addAttribute("pisateli", result2);
        return "Pisateli-view";
    }


    @GetMapping("/pisateli/{id}/edit")
    public String pisateliEdit(@PathVariable(value = "id") Long id,Pisateli pisateli, Model model){
        if(!pisateliRepository.existsById(id))
        {
            return "redirect:/pisateli";
        }

        Optional<Pisateli> pisateli1 = pisateliRepository.findById(id);
        ArrayList<Pisateli> res = new ArrayList<>();
        pisateli1.ifPresent(res::add);
        model.addAttribute("pisateliEdit", res);
        return "pisateli-edit";
    }

    @PostMapping("/pisateli/{id}/edit")
    public String pisateliPostUpdate(@Valid Pisateli pisateli,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String staz,
                                   @RequestParam String FIO, @RequestParam String book,
                                   Model model){
        List<Pisateli> res = pisateliRepository.findByFIO(FIO);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(pisateli);
            model.addAttribute("pisateliEdit",res);
            return "pisateli-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("FIO","Такие данные ФИО уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(pisateli);
            model.addAttribute("pisateliEdit",res);
            return "pisateli-edit";
        }
        else {
            pisateliRepository.save(pisateli);
            return "redirect:/pisateli";
        }
    }

    @GetMapping("/pisateli/{id}/remove")
    public String pisateliPostDelete(@PathVariable(value = "id") Long id, Model model){
        Pisateli pisateli = pisateliRepository.findById(id).orElseThrow();
        pisateliRepository.delete(pisateli);
        return "redirect:/pisateli";
    }






    @GetMapping("/director")
    public String directorView(Model model) {
        Iterable<Directors> directors = directorsRepository.findAll();
        model.addAttribute("directors", directors);
        return "Director-view";
    }

    @GetMapping("/director/add")
    public String directorAdd(Directors directors) {

        return "Director-add";
    }

    @PostMapping("/director/add")
    public String directorAdd(@Valid Directors directors, BindingResult bindingResult, @RequestParam String otdel,@RequestParam String FIO,
                             @RequestParam String rab,
                             Model model) {
        if (bindingResult.hasErrors())
            return "Director-add";
        List<Directors> res = directorsRepository.findByOtdel(otdel);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("otdel","Такие данные отдела уже есть!");
            bindingResult.addError(error);
            return "Director-add";
        }

        else {
            directorsRepository.save(directors);
            return "redirect:/director";
        }
    }


    @GetMapping("/director/{id}/detail")
    public String directorDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Directors> directors = directorsRepository.findById(id);
        ArrayList<Directors> result = new ArrayList<>();
        directors.ifPresent(result::add);
        model.addAttribute("directors", result);
        return "director-detail";
    }

    @PostMapping("/director/result")
    public String directorSearch(@RequestParam String rab, Model model) {
        List<Directors> result2 = directorsRepository.findByRab(rab);
        model.addAttribute("directors", result2);
        return "Director-view";
    }


    @GetMapping("/director/{id}/edit")
    public String directorEdit(@PathVariable(value = "id") Long id,Directors directors, Model model){
        if(!directorsRepository.existsById(id))
        {
            return "redirect:/director";
        }

        Optional<Directors> directors1 = directorsRepository.findById(id);
        ArrayList<Directors> res = new ArrayList<>();
        directors1.ifPresent(res::add);
        model.addAttribute("directorEdit", res);
        return "director-edit";
    }

    @PostMapping("/director/{id}/edit")
    public String directorPostUpdate(@Valid Directors directors,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String otdel,
                                     @RequestParam String FIO, @RequestParam String rab,
                                     Model model){
        List<Directors> res = directorsRepository.findByOtdel(otdel);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(directors);
            model.addAttribute("directorEdit",res);
            return "director-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("otdel","Такие данные отдела уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(directors);
            model.addAttribute("directorEdit",res);
            return "director-edit";
        }
        else {
            directorsRepository.save(directors);
            return "redirect:/director";
        }
    }

    @GetMapping("/director/{id}/remove")
    public String directorPostDelete(@PathVariable(value = "id") Long id, Model model){
        Directors directors = directorsRepository.findById(id).orElseThrow();
        directorsRepository.delete(directors);
        return "redirect:/director";
    }







    @GetMapping("/skidka")
    public String skidkaView(Model model) {
        Iterable<Skidki> skidkis = skidkiRepository.findAll();
        model.addAttribute("skidki", skidkis);
        return "Skidka-view";
    }

    @GetMapping("/skidka/add")
    public String skidkaAdd(Skidki skidki) {

        return "Skidka-add";
    }

    @PostMapping("/skidka/add")
    public String skidkaAdd(@Valid Skidki skidki, BindingResult bindingResult, @RequestParam String razmer,@RequestParam String books,
                              Model model) {
        if (bindingResult.hasErrors())
            return "Skidka-add";
        List<Skidki> res = skidkiRepository.findByRazmer(razmer);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("razmer","Такие данные скидки уже есть!");
            bindingResult.addError(error);
            return "Skidka-add";
        }

        else {
            skidkiRepository.save(skidki);
            return "redirect:/skidka";
        }
    }


    @GetMapping("/skidka/{id}/detail")
    public String skidkaDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Skidki> skidki = skidkiRepository.findById(id);
        ArrayList<Skidki> result = new ArrayList<>();
        skidki.ifPresent(result::add);
        model.addAttribute("skidki", result);
        return "skidka-detail";
    }

    @PostMapping("/skidka/result")
    public String skidkaSearch(@RequestParam String razmer, Model model) {
        List<Skidki> result2 = skidkiRepository.findByRazmer(razmer);
        model.addAttribute("skidki", result2);
        return "Skidka-view";
    }


    @GetMapping("/skidka/{id}/edit")
    public String skidkaEdit(@PathVariable(value = "id") Long id,Skidki skidki, Model model){
        if(!skidkiRepository.existsById(id))
        {
            return "redirect:/skidka";
        }

        Optional<Skidki> skidki1 = skidkiRepository.findById(id);
        ArrayList<Skidki> res = new ArrayList<>();
        skidki1.ifPresent(res::add);
        model.addAttribute("skidkaEdit", res);
        return "skidka-edit";
    }

    @PostMapping("/skidka/{id}/edit")
    public String skidkaPostUpdate(@Valid Skidki skidki,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String razmer,
                                     @RequestParam String books,
                                     Model model){
        List<Skidki> res = skidkiRepository.findByRazmer(razmer);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(skidki);
            model.addAttribute("skidkaEdit",res);
            return "skidka-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("razmer","Такие данные скидки уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(skidki);
            model.addAttribute("skidkaEdit",res);
            return "skidka-edit";
        }
        else {
            skidkiRepository.save(skidki);
            return "redirect:/skidka";
        }
    }

    @GetMapping("/skidka/{id}/remove")
    public String skidkaPostDelete(@PathVariable(value = "id") Long id, Model model){
        Skidki skidki = skidkiRepository.findById(id).orElseThrow();
        skidkiRepository.delete(skidki);
        return "redirect:/skidka";
    }




    @GetMapping("/information")
    public String informationView(Model model) {
        Iterable<Information> information = informationRepository.findAll();
        model.addAttribute("information", information);
        return "Information-view";
    }

    @GetMapping("/information/add")
    public String informationAdd(Information information) {

        return "Information-add";
    }

    @PostMapping("/information/add")
    public String informationAdd(@Valid Information information, BindingResult bindingResult, @RequestParam String statistic,@RequestParam String contact,
                                 @RequestParam String hoursOfWork,
                            Model model) {
        if (bindingResult.hasErrors())
            return "Information-add";
        List<Information> res = informationRepository.findByStatistic(statistic);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("statistic","Такие данные статистики уже есть!");
            bindingResult.addError(error);
            return "Information-add";
        }

        else {
            informationRepository.save(information);
            return "redirect:/information";
        }
    }


    @GetMapping("/information/{id}/detail")
    public String informationDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Information> information = informationRepository.findById(id);
        ArrayList<Information> result = new ArrayList<>();
        information.ifPresent(result::add);
        model.addAttribute("information", result);
        return "information-detail";
    }

    @PostMapping("/information/result")
    public String informationSearch(@RequestParam String statistic, Model model) {
        List<Information> result2 = informationRepository.findByStatistic(statistic);
        model.addAttribute("information", result2);
        return "Information-view";
    }


    @GetMapping("/information/{id}/edit")
    public String informationEdit(@PathVariable(value = "id") Long id,Information information, Model model){
        if(!informationRepository.existsById(id))
        {
            return "redirect:/information";
        }

        Optional<Information> information1 = informationRepository.findById(id);
        ArrayList<Information> res = new ArrayList<>();
        information1.ifPresent(res::add);
        model.addAttribute("informationEdit", res);
        return "information-edit";
    }

    @PostMapping("/information/{id}/edit")
    public String informationPostUpdate(@Valid Information information,BindingResult bindingResult, @PathVariable(value = "id") Long id,
                                        @RequestParam String statistic,
                                   @RequestParam String contact,
                                        @RequestParam String hoursOfWork,
                                   Model model){
        List<Information> res = informationRepository.findByStatistic(statistic);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(information);
            model.addAttribute("informationEdit",res);
            return "information-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("statistic","Такие данные статистики уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(information);
            model.addAttribute("informationEdit",res);
            return "information-edit";
        }
        else {
            informationRepository.save(information);
            return "redirect:/information";
        }
    }

    @GetMapping("/information/{id}/remove")
    public String informationPostDelete(@PathVariable(value = "id") Long id, Model model){
        Information information = informationRepository.findById(id).orElseThrow();
        informationRepository.delete(information);
        return "redirect:/information";
    }









    @GetMapping("/nakladnaya")
    public String nakladnayaView(Model model) {
        Iterable<Nakladnaya> nakladnaya = nakladnayaRepository.findAll();
        model.addAttribute("nakladnaya", nakladnaya);
        return "Nakladnaya-view";
    }

    @GetMapping("/nakladnaya/add")
    public String informationAdd(Nakladnaya nakladnaya) {

        return "Nakladnaya-add";
    }

    @PostMapping("/nakladnaya/add")
    public String informationAdd(@Valid Nakladnaya nakladnaya, BindingResult bindingResult, @RequestParam String dati,@RequestParam String stoimost,
                                 @RequestParam String postavchik,
                                 Model model) {
        if (bindingResult.hasErrors())
            return "Nakladnaya-add";
        List<Nakladnaya> res = nakladnayaRepository.findByDati(dati);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("dati","Такие данные даты уже есть!");
            bindingResult.addError(error);
            return "Nakladnaya-add";
        }

        else {
            nakladnayaRepository.save(nakladnaya);
            return "redirect:/nakladnaya";
        }
    }


    @GetMapping("/nakladnaya/{id}/detail")
    public String nakladnayaDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Nakladnaya> nakladnaya = nakladnayaRepository.findById(id);
        ArrayList<Nakladnaya> result = new ArrayList<>();
        nakladnaya.ifPresent(result::add);
        model.addAttribute("nakladnaya", result);
        return "nakladnaya-detail";
    }

    @PostMapping("/nakladnaya/result")
    public String nakladnayaSearch(@RequestParam String dati, Model model) {
        List<Nakladnaya> result2 = nakladnayaRepository.findByDatiContaining(dati);
        model.addAttribute("nakladnaya", result2);
        return "Nakladnaya-view";
    }


    @GetMapping("/nakladnaya/{id}/edit")
    public String nakladnayaEdit(@PathVariable(value = "id") Long id,Nakladnaya nakladnaya, Model model){
        if(!informationRepository.existsById(id))
        {
            return "redirect:/nakladnaya";
        }

        Optional<Nakladnaya> nakladnaya1 = nakladnayaRepository.findById(id);
        ArrayList<Nakladnaya> res = new ArrayList<>();
        nakladnaya1.ifPresent(res::add);
        model.addAttribute("nakladnayaEdit", res);
        return "nakladnaya-edit";
    }

    @PostMapping("/nakladnaya/{id}/edit")
    public String nakladnayaPostUpdate(@Valid Nakladnaya nakladnaya,BindingResult bindingResult, @PathVariable(value = "id") Long id,
                                        @RequestParam String dati,
                                        @RequestParam String stoimost,
                                        @RequestParam String postavchik,
                                        Model model){
        List<Nakladnaya> res = nakladnayaRepository.findByDatiContaining(dati);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(nakladnaya);
            model.addAttribute("nakladnayaEdit",res);
            return "nakladnaya-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("dati","Такие данные числа уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(nakladnaya);
            model.addAttribute("nakladnayaEdit",res);
            return "nakladnaya-edit";
        }
        else {
            nakladnayaRepository.save(nakladnaya);
            return "redirect:/nakladnaya";
        }
    }

    @GetMapping("/nakladnaya/{id}/remove")
    public String nakladnayaPostDelete(@PathVariable(value = "id") Long id, Model model){
        Nakladnaya nakladnaya = nakladnayaRepository.findById(id).orElseThrow();
        nakladnayaRepository.delete(nakladnaya);
        return "redirect:/information";
    }




    @GetMapping("/onetoone")
    public String onetooneView(Model model) {
        Iterable<Zdanie> zdanies = zdanieRepository.findAll();
        Iterable<Zal> zals = zalRepository.findAll();
        model.addAttribute("zdanie", zdanies);
        model.addAttribute("zal", zals);
        return "onetoone-view";
    }

    @GetMapping("/zdanie/add")
    public String zdanieAdd(Zdanie zdanie, Model model)
    {
        Iterable<Zal> zals = zalRepository.findAll();
        model.addAttribute("zal",zals);
        return "/Zdanie-add";
    }


    @PostMapping("/zdanie/add")
    public String zdanieAdd(@RequestParam String itazi,@RequestParam String number, Zdanie zdanie,
                          Model model) {


        List<Zdanie> res = zdanieRepository.findByItazi(itazi);
        Zal zal = zalRepository.findZalByNumber(number);


            Zdanie zdanie1 = new Zdanie(itazi, zal);
            zdanieRepository.save(zdanie1);
        return "redirect:/onetoone";

    }

    @GetMapping("/zal/add")
    public String zalAdd(Model model) {

        return "Zal-add";
    }

    @PostMapping("/zal/add")
    public String zalAdd(@RequestParam String number,
                          Model model) {
        Zal zal = new Zal(number);
        zalRepository.save(zal);
        return "redirect:/onetoone";
    }

    @GetMapping("/manytomany")
    public String manytomanyView(Model model) {
        Iterable<ElectroSsilki> electroSsilkis = electroSsilkiRepository.findAll();
        Iterable<MagazinBiblio> magazinBiblios = magazinBiblioRepository.findAll();
        model.addAttribute("electro", electroSsilkis);
        model.addAttribute("magazin", magazinBiblios);
        return "manytomany-view";
    }

    @GetMapping("/electro/add")
    public String electroAdd(Model model) {

        return "Electro-add";
    }

    @PostMapping("/electro/add")
    public String electroAdd(@RequestParam String ssilka,
                          Model model) {
        ElectroSsilki electroSsilki = new ElectroSsilki(ssilka);
        electroSsilkiRepository.save(electroSsilki);
        return "redirect:/manytomany";
    }

    @GetMapping("/magazin/add")
    public String magazinAdd(Model model) {

        return "Magazin-add";
    }

    @PostMapping("/magazin/add")
    public String magazinAdd(@RequestParam String name,
                          Model model) {
        MagazinBiblio magazinBiblio = new MagazinBiblio(name);
        magazinBiblioRepository.save(magazinBiblio);
        return "redirect:/manytomany";
    }




    @PostMapping("/manytomany")
    public String mamytomanyAdd(@RequestParam String ssilka,
                                @RequestParam String name,
                                Model model){
        ElectroSsilki electroSsilki = electroSsilkiRepository.findElectroSsilkisBySsilka(ssilka);
        MagazinBiblio magazinBiblio = magazinBiblioRepository.findMagazinBiblioByName(name);
        electroSsilki.getMagazinBiblios().add(magazinBiblio);
        electroSsilkiRepository.save(electroSsilki);
        return "redirect:/manytomany";
    }

}
