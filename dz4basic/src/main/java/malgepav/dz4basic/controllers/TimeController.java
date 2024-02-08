package malgepav.dz4basic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

@Controller
public class TimeController {
    @GetMapping("/time")
    public String timePage(Model model){

        model.addAttribute("time", new SimpleDateFormat("HH:mm:ss")
                .format(Calendar.getInstance().getTime()));
        return "TimePage";
    }
    @PostMapping("/leap")
    public String leapController(Model model, int year){
        model.addAttribute("time", new SimpleDateFormat("HH:mm:ss")
                .format(Calendar.getInstance().getTime()));
        String reply = Year.isLeap(year) ? "Year "+year+ " IS leap" : "Year "+year+ " IS NOT leap";
        model.addAttribute("reply",reply);
        return "TimePage";
    }
}
