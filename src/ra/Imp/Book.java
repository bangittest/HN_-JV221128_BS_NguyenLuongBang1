package ra.Imp;

import ra.bussiness.IBook;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    private static int nextId = 1;
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Book() {
        this.bookId = nextId++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        this.bookName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sách: ");
        this.title = scanner.nextLine();
        System.out.println("Nhập số trang sách: ");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá nhập sách: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá bán sách: ");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái của sách (true/false): ");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
        this.interest = this.exportPrice - this.importPrice;
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tiêu đề sách: " + title);
        System.out.println("Số trang sách: " + numberOfPages);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedImportPrice = currencyFormat.format(importPrice);
        String formattedExportPrice = currencyFormat.format(exportPrice);
        String formattedExportInterest = currencyFormat.format(interest);


        System.out.println("Giá nhập sách: " + formattedImportPrice);
        System.out.println("Giá bán sách: " + formattedExportPrice);

        System.out.println("Lợi nhuận: " + formattedExportInterest);
        System.out.println("Trạng thái: " + bookStatus);
    }

    @Override
    public int compareTo(Book o) {
        return (int) -(this .getInterest()-(o.getInterest()));
    }
}
