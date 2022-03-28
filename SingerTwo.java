import java.util.Scanner;


public class SingerTwo {
    static Scanner sc;

    public static Artist[] fillArr(int num) {
        Artist[] artists = new Artist[num];
        sc.nextLine();
        System.out.println("Введите информацию об исполнителях: ");
        for (int i = 0; i < num; i++) {
            artists[i] = new Artist();

            System.out.println("Введите фамилию исполнителя " + (i + 1) + ": ");
            artists[i].FamName = sc.nextLine();

            System.out.println("Введите имя исполнителя " + (i + 1) + ": ");
            artists[i].Name = sc.nextLine();

            System.out.println("Введите рейтинг исполнителя " + (i + 1) + ": ");
            artists[i].Rating = sc.nextDouble();

            System.out.println("Введите количество альбомов исполнителя " + (i + 1) + ": ");
            artists[i].AlbumNum = sc.nextInt();
            sc.nextLine();
        }
        return artists;
    }

    public static void printArr(Artist[] artists) {
        for (int i = 0; i <artists.length; i++) {
            System.out.println(artists[i].FamName + "\t" + artists[i].Name + "\t" + artists[i].Rating + "\t" + artists[i].AlbumNum);
        }
    }

    public static Artist mostPop(Artist[] artists){
        int NumFame = 0;
        double max = artists[NumFame].Rating;
        for (int i = 0; i < artists.length; i++){
            if (artists[i].Rating>max){
                max = artists[i].Rating;
                NumFame = i;
            }
        }
        return artists[NumFame];
    }

    public static void oneArtist (Artist artists){
        System.out.println(artists.FamName + "\t" + artists.Name  + "\t Рейтинг - " + artists.Rating + "\t Кол-во альбомов - " + artists.AlbumNum);
    }

    public static void srAlbum (Artist[] artists){
        double sum = 0;
        for (int i = 0; i < artists.length; i++)
            sum = sum + artists[i].AlbumNum;
        double srSum = sum/artists.length;
        System.out.println("\nСреднее кол-во альбомов = "+srSum);
        System.out.println("\nИсполнители, выпустившие альбомов больше среднего:");
        for (int i = 0; i < artists.length; i++) {
            if (artists[i].AlbumNum > srSum)
                System.out.println(artists[i].FamName + "\t" + artists[i].Name + "\t" + artists[i].AlbumNum);
        }
    }

    public static Artist[] famSort (Artist[] artists){
        for (int i = 0; i < artists.length-1; i++){
            for (int j = 0; j < artists.length-i-1; j++)
                if (artists[j].FamName.compareTo(artists[j+1].FamName)<0){
                    Artist temp = artists[j];
                    artists[j] = artists[j+1];
                    artists[j+1] = temp;
                }
        }
        return artists;
    }

    public static void searchArt (Artist[] artists){
        System.out.println("\nВведите фамилию искомого исполнителя: ");
        String Fam = sc.nextLine();
        int nom = -1;

        for (int i = 0; i < artists.length; i++)
            if (Fam.equalsIgnoreCase(artists[i].FamName))
                nom = i;
        if (nom!=-1){
            System.out.println("" + artists[nom].FamName + "\t" + artists[nom].Name);
            System.out.println("\nВы хотите изменить информацию об этом исполнителе? 1 - да, 0 -нет");
            int otv = sc.nextInt();
            if (otv == 1){
                System.out.println("\nИзменить фамилию - 1, имя - 2, рейтинг - 3, кол-во альбомов - 4");
                otv = sc.nextInt();
                switch (otv){
                    case 1:
                        sc.nextLine();
                        System.out.println("\nВведите новую фамилию: ");
                        artists[nom].FamName = sc.nextLine();
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("\nВведите новое имя: ");
                        artists[nom].Name = sc.nextLine();
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("\nВведите новый рейтинг: ");
                        artists[nom].Rating = sc.nextDouble();
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("\nВведите новое кол-во альбомов: ");
                        artists[nom].AlbumNum = sc.nextInt();
                        break;
                    default:
                        System.out.println("\nНеправильно. ");
                }
                oneArtist(artists[nom]);
            }
        }else System.out.println("\nИсполнителя с такой фамилией нет в списке.");
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Введите количество исполнителей:");
        int num = sc.nextInt();
        Artist[] artists = fillArr(num);
        printArr(artists);
        System.out.println("\nСамый популярный исполнитель:");
        oneArtist(mostPop(artists));
        srAlbum(artists);
        System.out.println("\nСортировка исполнителей по фамилиям:\n");
        printArr(famSort(artists));
        searchArt(artists);
    }
}
