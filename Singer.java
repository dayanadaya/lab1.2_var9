import java.util.Scanner;

class Artist{
    String FamName, Name;
    double Rating;
    int AlbumNum;
}

public class Singer {
    public static void main(String[]  args){
        Scanner sc=new Scanner(System.in);
        //Ввод информации
        System.out.println("Введите количество исполнителей:");
        int num = sc.nextInt();
        sc.nextLine();
        Artist []Artist=new Artist[num];
        System.out.println("Введите информацию об исполнителях: ");
        for (int i = 0; i<num; i++){
            Artist[i]=new Artist();
            System.out.println("Введите фамилию исполнителя " +(i+1)+": ");
            Artist[i].FamName = sc.nextLine();

            System.out.println("Введите имя исполнителя " +(i+1)+": ");
            Artist[i].Name = sc.nextLine();

            System.out.println("Введите рейтинг исполнителя " +(i+1)+": ");
            Artist[i].Rating = sc.nextDouble();

            System.out.println("Введите количество альбомов исполнителя " +(i+1)+": ");
            Artist[i].AlbumNum = sc.nextInt();
            sc.nextLine();
        }

        //Вывод информации
        System.out.println("\nИсполнители \nФамилия \tИмя \tРейтинг \tКол-во альбомов");
        for (int i = 0; i < Artist.length; i++){
            System.out.println(Artist[i].FamName + "\t" + Artist[i].Name  + "\t" + Artist[i].Rating + "\t" + Artist[i].AlbumNum);
            System.out.println("");
        }

        //Самый популяр
        int NumFame = 0;
        double max = Artist[NumFame].Rating;
        for (int i = 0; i < Artist.length; i++){
            if (Artist[i].Rating>max){
                max = Artist[i].Rating;
                NumFame = i;
            }
        }
        System.out.println("\nСамый популярный исполнитель - ");
        System.out.println(""+Artist[NumFame].FamName + " "+Artist[NumFame].Name);

        //Среднее кол-во альбомов
        double sum = 0;
        for (int i = 0; i < Artist.length; i++)
            sum = sum + Artist[i].AlbumNum;
        double srSum = sum/Artist.length;
        System.out.println("\nСреднее кол-во альбомов = "+srSum);
        System.out.println("\nИсполнители, выпустившие альбомов больше среднего:");
        for (int i = 0; i < Artist.length; i++){
            if (Artist[i].AlbumNum > srSum)
                System.out.println(Artist[i].FamName + "\t" + Artist[i].Name+ "\t" + Artist[i].AlbumNum);
        }

        //Сортировка по фамилиям, алфавит наоборот
        for (int i = 0; i < Artist.length-1; i++){
            for (int j = 0; j < Artist.length-i-1; j++)
                if (Artist[j].FamName.compareTo(Artist[j+1].FamName)<0){
                    Artist temp = Artist[j];
                    Artist[j] = Artist[j+1];
                    Artist[j+1] = temp;
                }
        }
        System.out.println("\nИсполнители по алфавиту наоборот:");
        for (int i = 0; i < Artist.length; i++){
            System.out.println("" + Artist[i].FamName + "\t" + Artist[i].Name);
        }

        //Поиск по названию
        //sc.nextLine();
        System.out.println("\nВведите фамилию искомого исполнителя: ");
        String Fam = sc.nextLine();
        int nom = -1;

        for (int i = 0; i < Artist.length; i++)
            if (Fam.equalsIgnoreCase(Artist[i].FamName))
                nom = i;
        if (nom!=-1){
            System.out.println("" + Artist[nom].FamName + "\t" + Artist[nom].Name);
            System.out.println("\nВы хотите изменить информацию об этом исполнителе? 1 - да, 0 -нет");
            int otv = sc.nextInt();
            if (otv == 1){
                System.out.println("\nИзменить фамилию - 1, имя - 2, рейтинг - 3, кол-во альбомов - 4");
                otv = sc.nextInt();
                switch (otv){
                    case 1:
                        sc.nextLine();
                        System.out.println("\nВведите новую фамилию: ");
                        Artist[nom].FamName = sc.nextLine();
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("\nВведите новое имя: ");
                        Artist[nom].Name = sc.nextLine();
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("\nВведите новый рейтинг: ");
                        Artist[nom].Rating = sc.nextDouble();
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("\nВведите новое кол-во альбомов: ");
                        Artist[nom].AlbumNum = sc.nextInt();
                        break;
                    default:
                        System.out.println("\nНеправильно. ");
                }
                System.out.println(Artist[nom].FamName + "\t" + Artist[nom].Name  + "\t Рейтинг - " + Artist[nom].Rating + "\t Кол-во альбомов - " + Artist[nom].AlbumNum);
            }
        }else System.out.println("\nИсполнителя с такой фамилией нет в списке.");

        //Редактирование информации

    }
}