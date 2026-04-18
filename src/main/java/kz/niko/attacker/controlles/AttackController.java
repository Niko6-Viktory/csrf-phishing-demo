package kz.niko.attacker.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttackController {
    @GetMapping("/win-prize")
    public String showAttackPage() {
        return "attack"; // Ищет файл attack.html
    }
}