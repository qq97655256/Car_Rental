package first.controller;

import first.utils.Emil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EmilController {
    @Autowired
    private Emil e;
    @RequestMapping("/emil/{emil1}")
    public Object emil(@PathVariable("emil1")String emil1, HttpServletRequest request){
        e.testEmil(emil1,request);
        Object random = request.getSession().getAttribute("random");
        return  random;
    }
}
