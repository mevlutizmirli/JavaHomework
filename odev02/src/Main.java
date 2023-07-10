import model.Category;
import model.Film;
import model.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        boolean exit = true;
        int control;
        int adminControl;

        List <Film> FilmList = new ArrayList<>();

        ArrayList<String> categoryList = new ArrayList<>();
        ArrayList<String> platformList = new ArrayList<>();

        do {

            System.out.println("Oturum açınız: ");
            System.out.println("1-Admin Giriş\n2-Kullanıcı Giriş\n0-Çıkış");
            control=input.nextInt();

            switch (control){
                case 1:
                    System.out.println("Admin olarak giriş yaptınız...");
                    System.out.println("Lütfen yapılacak işlemi seçin :");
                    System.out.println("1-Kategori Ekle\n2-Platform Ekle\n3-Film Ekle");
                    adminControl=input.nextInt();


                    switch (adminControl){

                        case 1:
                            input.nextLine();
                            System.out.println("Yeni kategori adı giriniz :");
                            String newCategoryName = input.nextLine();
                            categoryList.add(newCategoryName);

                            break;

                        case 2:
                            input.nextLine();
                            System.out.println("Yeni platform adı giriniz : ");
                            String newPlatformName=input.nextLine();
                            platformList.add(newPlatformName);

                            break;

                        case 3:
                            System.out.println("Kategori seçin: ");
                            for (int i=0;i<categoryList.size();i++){
                                System.out.println((i+1)+"-"+categoryList.get(i));
                            }
                            int catNumb=input.nextInt();

                            System.out.println("Platformu seçin :");
                            for (int i=0;i<platformList.size();i++){
                                System.out.println((i+1)+"-"+platformList.get(i));
                            }
                            int platNum=input.nextInt();
                            input.nextLine();
                            System.out.println("Kaydetmek istediğiniz filmin adını giriniz :");
                            String movieName=input.nextLine();
                            System.out.println("Kaydetmek istediğiniz filmin yılını giriniz :");
                            int movieYear=input.nextInt();
                            input.nextLine();
                            System.out.println("Filmin başrol oyuncusunu giriniz :");
                            String movieStar=input.nextLine();
                            System.out.println("Filmin imdb puanının giriniz :");
                            double movieScoreImdb=input.nextDouble();

                            Film newFilm = new Film(movieName,movieYear,movieStar,movieScoreImdb);

                            Category newCategory = new Category();
                            newCategory.setCategoryName(categoryList.get(catNumb-1));
                            ArrayList<Category> tempCatList = new ArrayList<>();
                            tempCatList.add(newCategory);
                            newFilm.setCatList(tempCatList);

                            Platform newPlatform = new Platform();
                            newPlatform.setPlatformName(platformList.get(platNum-1));
                            ArrayList<Platform> tempPlatList = new ArrayList<>();
                            tempPlatList.add(newPlatform);
                            newFilm.setPlatList(tempPlatList);

                            FilmList.add(newFilm);

                            System.out.println("Film oluşturuldu...");



                            break;

                    }

                    break;

                case 2:
                    System.out.println("Filmleri listelemek için kategori seçiniz : ");
                    for (int i=0;i<categoryList.size();i++){
                        System.out.println((i+1)+"-"+categoryList.get(i));
                    }
                    int categorySelect=input.nextInt();
                    System.out.println(categoryList.get(categorySelect-1) + " kategorisinde listelenen filmler : ");

                    int count = 0;

                    for (Film fd: FilmList){
                        for (Category cat : fd.getCatList()){
                            if (cat.getCategoryName().equals(categoryList.get(categorySelect-1))){
                                System.out.println(fd);
                                count++;

                            }
                        }
                    }

                    System.out.println(categoryList.get(categorySelect-1)+"kategorisinde" + count +" film var..");

                    break;



                case 0:
                    System.out.println("Çıkış Yapılıyor....");
                    exit=false;
                    input.close();
                    break;


            }

        }while (exit==true);




    }
}