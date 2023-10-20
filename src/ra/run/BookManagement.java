package ra.run;

import ra.Imp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BookManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        while (true){
            System.out.println("""
                    ****************JAVA-HACKATHON-05-BASIC-MENU***************
                    1. Nhập số sách và nhập thông tin sách
                    2. Hiển thị thông tin các sách
                    3. Sắp xếp sách theo lợi nhuận giảm dần
                    4. Xóa sách theo mã sách
                    5. Tìm kiếm sách theo tên sách
                    6. Thay đổi trạng thái của sách theo mã sách
                    7. Thoát
                    """);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    disPlayBook();
                    break;
                case 3:
                    sortBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    statusBook();
                    break;
                case 7:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Lựa chọn không đúng mời nhập lại");
            }
        }
    }

    private static void statusBook() {
        System.out.println("Nhập Id cần sửa");
        int idStatus = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Book book : books) {
            check = false;
            if (book.getBookId() == idStatus) {
                book.displayData();
                System.out.println("Nhập trạng thái mới: ");
                boolean statusEdit = Boolean.parseBoolean(scanner.nextLine());
                book.setBookStatus(statusEdit);
                System.out.println("Thay đổi trạng thái thành công");
                return;
            }
        }
        if (!check){
            System.out.println("không tìm thấy id cần sửa " +idStatus);
        }
    }
    private static void searchBook() {
        System.out.println("Nhập tên sách cần kiếm: ");
        String searchName = scanner.nextLine();
        if (searchName.isEmpty()) {
            System.out.println("Vui lòng nhập tên sách cần tìm kiếm.");
            return;
        }
        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookName().toLowerCase().contains(searchName)) {
                System.out.println("Danh sách cần tìm kiếm là:");
                books.get(i).displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy cuốn sách nào thỏa mãn điều kiện tìm kiếm.");
        }
    }


    private static void deleteBook () {
                for (Book book : books) {
                    book.displayData();
                }
                System.out.println("Nhập Id cần xóa :");
                int idDelete = Integer.parseInt(scanner.nextLine());
                boolean check = false;
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getBookId() == idDelete) {
                        books.remove(i);
                        System.out.println("Xóa thành công");
                        check = true;
                    }
                }
                if (!check) {
                    System.out.println("Không tìm thấy mã sách : " + idDelete);
                }

            }

            private static void sortBook () {
                    Collections.sort(books);
                    System.out.println("Danh sách sau khi đã sắp xếp theo lợi nhuận giảm dần:");
                    for (Book book : books) {
                        book.displayData();
                    }
            }

            private static void disPlayBook () {
                System.out.println("Danh sách tất cả sách đang lưu trữ: ");
                for (Book book : books) {
                    book.displayData();
                }
            }

            private static void addNewBook () {
                System.out.println("Nhập số lượng sách cần thêm :");
                int n = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < n; i++) {
                    Book book = new Book();
                    book.inputData();
                    books.add(book);
                }
                System.out.println("Thêm mới thành công");
            }
        }
