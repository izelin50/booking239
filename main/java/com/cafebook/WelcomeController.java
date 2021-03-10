package com.cafebook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WelcomeController {

    Map<String, String> keys = new HashMap<>();
    Map<Integer, Stolik> tables = new HashMap();
    Map<String, String> passwords = new HashMap<>();
    Map<String,String> times = new HashMap<>();
    private static final int TABLE_NUMBER = 12;
    int tableNumber = -1;
    int startTime;
    int finishTime;
    String start;
    String finish;

    public WelcomeController(){
        for (int i = 1; i <= TABLE_NUMBER; i++) {
            Stolik morning = new Stolik();
            tables.put(i, morning);
            passwords.put("admin", "1");
            for (int j = 1; j <= 6; j++) morning.duration.put(j, "noID");
            keys.put("#vip", "#vip");
        }

    }

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "start";
    }

    @PostMapping("/clear")
    public String clear(Map<String, String> model, String clear) {

        for (int i = 1; i <= TABLE_NUMBER; i++) {
            Stolik morning = new Stolik();
            tables.put(i, morning);

            for (int j = 1; j <= 6; j++) morning.duration.put(j, "noID");
        }
        times.clear();
        model.put("clear", "Oчищено!");
        return "admin";
    }


    @PostMapping("/admin")
    public String admin(Map<String, Object> model, @RequestParam String key, @RequestParam String
            id, @RequestParam String table, HttpServletRequest req) {
        String login = (String) req.getSession().getAttribute("login");
        if (login != null) {

            keys.put(key, key);
            String realPass = passwords.get(id);
            Stolik checkStol = tables.get(table);
            model.put("password", ("Пароль: " + realPass));
            model.put("stol", ("Стол: " + checkStol));
            if (key != null) {
                model.put("writen", ("Результат: " + "регистрационный ключ записан"));
                return "admin";
            }
            return "admin";
        }
        return "start";
    }

    @PostMapping("/register")
    public String register(Map<String, Object> model) {
        return "register";
    }

    @PostMapping("/start")
    public String start(@RequestParam String login, @RequestParam String pass, @RequestParam String key) {
        if (login.contains("#") | passwords.containsKey(login)| login == null | login==""|pass==null|pass=="") {
            return "expect";
        } else {
            if (keys.containsKey(key) && !keys.containsKey(login)) {
                keys.remove(key);
                keys.put(login, key);
                passwords.put(login, pass);
                return "start";
            } else {
                return "expect";
            }
        }
    }

    @PostMapping("/start1")
    public String start1() {

        return "start";
    }


    @PostMapping("/login")
    public String processLoginInformation( @RequestParam String login, @RequestParam String pass, Map<String, Object> model, HttpServletRequest req) {
        model.put("message", login);
        String realPass = passwords.get(login);
        int tableNumber1 = 0;
        String start1="0";
        String finish1="0";
        int starttime1=0;
        int finishtime1=0;
        if (times.containsKey(login)){
            for (int i=1;i<=TABLE_NUMBER;i++){
                Stolik check=tables.get(i);
                for (int j=1;j<=6;j++){
                    if (check.duration.get(j).equals(login)){
                        tableNumber1 = i;
                        if (starttime1==0){
                            starttime1=j;
                        }
                        finishtime1=j;
                    }
                }
            }
            switch (finishtime1) {
                case 1:
                    finish1 = "13:00";
                    break;
                case 2:
                    finish1 = "13:05";
                    break;
                case 3:
                    finish1 = "13:10";
                    break;
                case 4:
                    finish1 = "13:15";
                    break;
                case 5:
                    finish1 = "13:20";
                    break;
                case 6:
                    finish1 = "13:25";
                    break;
            }
            switch (starttime1) {
                case 1:
                    start1 = "12:55";
                    break;
                case 2:
                    start1 = "13:00";
                    break;
                case 3:
                    start1 = "13:05";
                    break;
                case 4:
                    start1 = "13:10";
                    break;
                case 5:
                    start1 = "13:15";
                    break;
                case 6:
                    start1 = "13:20";
                    break;
            }
            model.put("stolPoluchen","Поздравляем! Вы получили стол № " + tableNumber1 + "! " + "Вы можете занять его с " + start1 + " по " + finish1 + ".");
            return"end";
        }
        if (!login.equals("admin") && realPass != null && realPass.equals(pass)) {
            HttpSession s = req.getSession();
            s.setAttribute("login", login);

            return "second";
        }

        if (login.equals("admin") && pass.equals("1")) {
            HttpSession s = req.getSession();
            s.setAttribute("login", login);
            return "admin";
        }
        return "expect";

    }

    @PostMapping("/forget1")
    public String forget1() {
        return "forget";
    }

    @PostMapping("/forget")
    public String forget(Map<String, Object> model, @RequestParam String login) {
        model.put("forget", "Если учётная запись существовала, то ваш регистрационный ключ активирован вновь, а учётная запись удалена.");
        if (passwords.containsKey(login)) {
            passwords.remove(login);
            String key = keys.get(login);
            keys.put(key, null);
            keys.remove(login);
        }
        return "register";
    }


    @PostMapping("/second")
    public String id(@RequestParam String id, Map<String, Object> model, HttpServletRequest req) {
        String login = (String) req.getSession().getAttribute("login");
        int counter = 0;
        int time = 0;
        int userTable = 0;
        if (login != null) {

            if (id!=null|id!=""){
            String containedUser;
            for (int i = 1; i <= TABLE_NUMBER; i++) {
                if (userTable != 0 && time != 0 && counter != 0) break;
                userTable = 0;
                counter = 0;
                time = 0;
                Stolik stol = tables.get(i);
                if (stol.duration.containsValue(id)) {
                    for (int j = 1; j <= 6; j++) {
                        String check = stol.duration.get(j);
                        if (check.equals(id)) {
                            userTable = i;
                            counter++;
                            if (time == 0) {
                                time = j;
                            }
                        }
                    }
                }
            if (time==0){ model.put("netStola", "Увы, с другом Вас посадить не получается."); return "third";}
            }
            for (int q = 1; q <= TABLE_NUMBER; q++) {
                int dounter = 0; //счётчик типа 0 1 -1 2 -2
                int bounter = 0;
                int lime = 0;
                if ((userTable - q) >= 1) {
                    if (q % 2 == 0) dounter -= q;
                    else dounter += q;
                } else dounter = 1;
                Stolik next = tables.get(userTable + dounter);

                for (int j = time; j <= 6; j++) {
                    if (bounter == counter) {
                        lime = j;
                        break;}
                    if (next.duration.get(j) == "noID") {
                        bounter++;
                    } else {
                        bounter = 0;
                        continue;
                    }
                }
                if (bounter == counter) {
                    for (int s = lime; s >= lime - counter; s--){times.put(login,"#got"); next.duration.put(s, login);}
                    tableNumber = userTable + dounter;
                    startTime = time;
                    finishTime = time + counter;
                    int num = userTable + dounter;
                    tables.put(num, next);
                    finishTime-=1;
                    switch (finishTime) {
                        case 1:
                            finish = "13:00";
                            break;
                        case 2:
                            finish = "13:05";
                            break;
                        case 3:
                            finish = "13:10";
                            break;
                        case 4:
                            finish = "13:15";
                            break;
                        case 5:
                            finish = "13:20";
                            break;
                        case 6:
                            finish = "13:25";
                            break;
                    }
                    switch (startTime) {
                        case 1:
                            start = "12:55";
                            break;
                        case 2:
                            start = "13:00";
                            break;
                        case 3:
                            start = "13:05";
                            break;
                        case 4:
                            start = "13:10";
                            break;
                        case 5:
                            start = "13:15";
                            break;
                        case 6:
                            start = "13:20";
                            break;
                    }

                    model.put("stolPoluchen", "Поздравляем! Вы получили стол №" + tableNumber + ". Вы можете занять его с " + start + " по " + finish + ".");
                    return "end";

                }
            }

            model.put("netStola", "Увы, с другом Вас посадить не получается.");
            return "third";
        }
            model.put("netStola", "Увы, с другом Вас посадить не получается.");
            return "third";
        }

        return "start";
    }


    @PostMapping("/place")
    public String place(Map<String, Object> model, HttpServletRequest req) {
        String login = (String) req.getSession().getAttribute("login");
        if (login != null) {
            return "third";
        }
        return "start";
    }


    @PostMapping("/duration")
    public String duration(Map<String, Object> model, HttpServletRequest req) {
        String login = (String) req.getSession().getAttribute("login");
        if (login != null) {
            return "end";
        }
        return "start";
    }


    @PostMapping("/end")
    public String end(Map<String, Object> model, HttpServletRequest req, @RequestParam Integer duration) {
        int counter = 0;
        int time = 0;
        int i;
        String login = (String) req.getSession().getAttribute("login");
        if (login != null) {
IVAN_DESIGN:
            for (i = 1; i <= TABLE_NUMBER; i++) {
                Stolik stol = tables.get(i);
                for (int j = 1; j <= 6; j++) {
                    if("noID".equals(stol.duration.get(j))){
                        counter++;
                        if (counter == duration ){
                            time = j;//ok
                            break IVAN_DESIGN;
                        }
                    } else {
                        counter = 0;
                    }
                }
            }
            if (counter == duration) {
                Stolik stol = tables.get(i);
                for (int q = time; q > time - duration; q--) {
                    stol.duration.put(q, login);
                }
                tableNumber = i;
                startTime = time - duration+1;
                finishTime = time;
                switch (finishTime) {
                    case 1:
                        finish = "13:00";
                        break;
                    case 2:
                        finish = "13:05";
                        break;
                    case 3:
                        finish = "13:10";
                        break;
                    case 4:
                        finish = "13:15";
                        break;
                    case 5:
                        finish = "13:20";
                        break;
                    case 6:
                        finish = "13:25";
                        break;
                }
                switch (startTime) {
                    case 1:
                        start = "12:55";
                        break;
                    case 2:
                        start = "13:00";
                        break;
                    case 3:
                        start = "13:05";
                        break;
                    case 4:
                        start = "13:10";
                        break;
                    case 5:
                        start = "13:15";
                        break;
                    case 6:
                        start = "13:20";
                        break;
                }
                times.put(login,"#got");
                model.put("stolPoluchen", "Поздравляем! Вы получили стол №" + tableNumber + "вы можете занять его с " + start + " по " + finish + ".");
                return "end";
            }
            model.put("netStola", "Увы, нет ни одного стола на указанную продолжительность! Попробуйте выбрать другую.");
            return "third";
        }
        return "start";
    }


    @PostMapping("/cancel")
    public String end1(Map<String, Object> model, HttpServletRequest req) {
        String login = (String) req.getSession().getAttribute("login");
        if (login != null) {
            for (int i=1 ; i<=TABLE_NUMBER;i++){
                Stolik canceled = tables.get(i);
                times.remove(login);
                for (int j=1; j<=6;j++)
                    if (canceled.duration.get(j).equals(login)){
                        canceled.duration.remove(j);
                        canceled.duration.put(j,"noID");
                    }

            }
            model.put("conclusion", "эх, жалость-то! А ведь так надеялись увидеть вас в столовой...");
            return "end";
        }
        return "start";
    }


}