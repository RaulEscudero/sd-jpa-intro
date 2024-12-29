package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Desgin", "123", "RandomHouse");
        System.out.println("Id: "+bookDDD.getId());
        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println("Id: "+savedDDD.getId());

        Book bookSIA = new Book("Spring in Action", "234","Oriley");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book ID: "+book.getId());
            System.out.println("Book Title: "+book.getTitle());
            System.out.println("Book ISBN: "+book.getIsbn());
        });
    }
}
