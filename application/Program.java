package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso?: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            System.out.printf("Dados da %d° aula\n",i);
            System.out.print("Conteúdo ou tarefa (c/t)?: ");
            char ch = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String titulo = sc.nextLine().toLowerCase();
            if (ch == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int segundos = sc.nextInt();
                list.add(new Video(titulo,url,segundos));
            }
            else {
                System.out.print("Descrição: ");
                String descricao = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questoes = sc.nextInt();
                list.add(new Task(titulo,descricao,questoes));
            }
        }

        int duracaoCursoSegundos = 0;

        for (Lesson lesson : list) {
            duracaoCursoSegundos += lesson.duration();
        }
        System.out.printf("\nDURAÇÃO TOTAL DO CURSO = %d SEGUNDOS\n",duracaoCursoSegundos);


    }
}
