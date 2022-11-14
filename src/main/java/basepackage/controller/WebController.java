package basepackage.controller;

import basepackage.dao.StudentRepo;
import basepackage.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private StudentRepo repo;

//    @RequestMapping("/students")
//    public String  getAllStudents(ModelMap  model){
//        model.addAttribute( "studentlist", (List<Student>) repo.findAll());
//        return "students";
//    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student){
        repo.save(student);
        return "redirect:/viewstudent";//will redirect to viewstudent request mapping
    }


    @RequestMapping("/viewstudent")
    public String viewStudents(Model m){
        List<Student> list= (List<Student>) repo.findAll();
        m.addAttribute("studentlist",list);
        return "viewstudentpage";
    }

    @RequestMapping("/addstudent")
    public String addStudent(Model m){
        m.addAttribute("command", new Student());
        return "addstudentpage";
    }

    @RequestMapping("/editstudent/{id}")
    public String edit(@PathVariable int id, Model m){
        Optional<Student> student=repo.findById(id);
        m.addAttribute("command",student);
        return "editstudentpage";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("student") Student student){
        repo.save(student);
        return "redirect:/viewstudent";
    }

    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){

        repo.deleteById(id);
        return "redirect:/viewstudent";
    }

    @RequestMapping("/")
    public String displayHomeForDefault(ModelMap  model) {
        model.addAttribute("message", "Welcome Home");
        return "home";
    }

    @RequestMapping("/home")
    public String displayHome(ModelMap  model) {
        model.addAttribute("message", "Welcome Home");
        return "home";
    }

//    @RequestMapping("/dummy")
//    public String displayDummy(ModelMap model) {
//        model.addAttribute("message", "This page is to provide some information about our company");
//        return "dummy";
//    }
//
//    @RequestMapping("/about")
//    public String displayAbout(ModelMap model) {
//        model.addAttribute("message", "This page is to provide some information about our company");
//        return "about";
//    }
//
//    @RequestMapping("/help")
//    public String displayHelp(ModelMap model) {
//        model.addAttribute("message", "This page is to provide help document");
//        return "help";
//    }
}
