package mg.librarymanager.controllers;

import mg.librarymanager.dataModels.Item;
import mg.librarymanager.dataModels.Library;
import mg.librarymanager.dataModels.User;
import mg.librarymanager.interfaces.Borrowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowItemController {

    private final Borrowable borrowItemService;

    @Autowired
    public BorrowItemController(Borrowable borrowItemService) {
        this.borrowItemService = borrowItemService;
    }

    @PostMapping("/borrow")
    public boolean borrowItem(@RequestBody BorrowRequest request) {
        User borrower = request.getBorrower();
        User librarian = request.getLibrarian();
        Item item = request.getItem();
        Library library = request.getLibrary();

        return borrowItemService.borrowItem(borrower, librarian, item, library);
    }

    static class BorrowRequest {
        private User borrower;
        private User librarian;
        private Item item;
        private Library library;

        public User getBorrower() {
            return borrower;
        }

        public void setBorrower(User borrower) {
            this.borrower = borrower;
        }

        public User getLibrarian() {
            return librarian;
        }

        public void setLibrarian(User librarian) {
            this.librarian = librarian;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public Library getLibrary() {
            return library;
        }

        public void setLibrary(Library library) {
            this.library = library;
        }
    }
}
