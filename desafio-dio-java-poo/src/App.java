import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class App {
    public static void main(String[] args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Java básico");
        curso1.setCargaHoraria(8);


        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Js");
        curso2.setDescricao("Js básico");
        curso2.setCargaHoraria(4);
        
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Mentoria de java para iniciantes");
        mentoria.setData(LocalDate.now());
        
        //System.out.println(curso1);
        //System.out.println(curso2);
        //System.out.println(mentoria1);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java");
        bootcamp.setDescricao("Bootcamp para devs Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devGustavo = new Dev();
        devGustavo.setNome("Gustavo");
        devGustavo.inscreverBootcamp(bootcamp);
        System.out.println("Contudos Inscritos: " + devGustavo.getConteudoInscritos());
        devGustavo.progedir();
        System.out.println("-");
        System.out.println("Contudos Inscritos: " + devGustavo.getConteudoInscritos());
        System.out.println("Contudos Concluidos: " + devGustavo.getConteudoConcluidos());
        System.out.println("XP: " + devGustavo.calcularTotalXP());



        System.out.println("-------------------------------");

        Dev devFelipe = new Dev();
        devFelipe.setNome("Felipe");
        devFelipe.inscreverBootcamp(bootcamp);
        devFelipe.progedir();
        devFelipe.progedir();
        devFelipe.progedir();
        System.out.println("-");
        System.out.println("Contudos Inscritos: " + devFelipe.getConteudoInscritos());
        System.out.println("Contudos Concluidos: " + devFelipe.getConteudoConcluidos());
        System.out.println("XP: " + devFelipe.calcularTotalXP());


    }
}
