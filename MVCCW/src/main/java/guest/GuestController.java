package guest;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {

    @Autowired
    private GuestDao guestDao;

    @RequestMapping(value = "/guest")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        String roomno = request.getParameter("roomno");
        if (name.equals(null) || roomno.equals(null)) {
            System.out.println("Testing");
        }
        if (name != null || roomno != null) {
            guestDao.persist(new Guest(name, roomno));
        }

        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "guestDao", guestDao);
    }
}
