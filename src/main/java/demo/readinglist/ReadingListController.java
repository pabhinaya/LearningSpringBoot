package demo.readinglist;

import java.util.List;
import java.util.Optional;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReadingListController {

    private final BookRepository bookRepository;

    public ReadingListController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model,@RequestParam Optional<String> error) {
        model.addAttribute("error",error);
        return "login";
    }
    @GetMapping("/myList")
    public String readersBooks(Model model) {
         String reader = SecurityContextHolder.getContext().getAuthentication().getName();
         List<Book> bookList =  bookRepository.findByReader(reader);
         model.addAttribute("books",bookList);
         model.addAttribute("reader",reader);
         return "readersBooks";
    }

    @GetMapping("/addBook")
    public String addBookForm() {
        return "addBook";
    }

    @PostMapping("/addToBookList")
    public String addBookToList(Book book) {
        String reader = SecurityContextHolder.getContext().getAuthentication().getName();
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:myList";
    }

}
