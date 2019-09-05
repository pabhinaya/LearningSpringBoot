package demo.readinglist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoadDatabase implements CommandLineRunner {

    private BookRepository bookRepository;
    private ReaderRepository readerRepository;

    LoadDatabase(BookRepository bookRepository,ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    @Override
    public void run(String...args) throws Exception {

        log.info("Application started!!");
        log.info("Creating Book 1 Reader 1" + bookRepository.save(new Book("ISBN1","Book1","Author1","Description1","Reader1")));
        log.info("Creating Book 1 Reader 2" + bookRepository.save(new Book("ISBN1","Book1","Author1","Description1","Reader2")));
        log.info("Creating Book 2 Reader 1" + bookRepository.save(new Book("ISBN1","Book2","Author2","Description2","Reader1")));
        log.info("Creating Reader 1" + readerRepository.save(new Reader("Reader1", "Reader1 Lastname1","password1")));
        log.info("Creating Reader 2" + readerRepository.save(new Reader("Reader2", "Reader2 Lastname2","password2")));
    }
}
