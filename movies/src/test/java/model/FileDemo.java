package model;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileDemo {

    @Test
    void demoFileVsPath() throws IOException {
        var file = new File("pom.xml");
        System.out.println(file + " exists: " + file.exists());
        System.out.println("\t- is a regular file: " + file.isFile());
        System.out.println("\t- is a directory: " + file.isDirectory());

        var file2 = new File("pom_copy.xml");
        System.out.println(file2 + " exists: " + file2.exists());
        System.out.println("\t- is a regular file: " + file2.isFile());
        System.out.println("\t- is a directory: " + file2.isDirectory());

        // if executed twice with no option:
        //      java.nio.file.FileAlreadyExistsException: pom_copy.xml
        Files.copy(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        // see also: move, delete, makeDirectory

        var file3 = new File("src");
        System.out.println(file3 + " exists: " + file3.exists());
        System.out.println("\t- is a regular file: " + file3.isFile());
        System.out.println("\t- is a directory: " + file3.isDirectory());

       var pathSrc = file3.toPath();
       var pathSrcJavaMain = pathSrc.resolve("main").resolve("java");
       //        var pathSrcJavaMain = Path.of("src", "main", "java");
        System.out.println(pathSrcJavaMain + " exists: " + Files.exists(pathSrcJavaMain));

        Files.walk(pathSrcJavaMain)
                //.forEach(System.out::println);
                .forEach(path -> System.out.println(
                        path
                        + " ; regular file: " + Files.isRegularFile(path)
                        + " ; directory: " + Files.isDirectory(path)
                 ));
        // see Files.find with a predicate
    }

    @Test
    void demoWriteFile() { //throws IOException {
        List<MovieL> movies = List.of(
                new MovieL("Top Gun", 1984, (short) 109, PgType.PG)
                , new MovieL("Top Gun: Maverick", 2022, (short) 130, PgType.PG_13)
                , new MovieL("John Wick: Chapter 4", 2023, (short) 169, PgType.R)
                , new MovieL("The Man Who Knew Too Much",1934,(short) 75, PgType.R)                , new MovieL("The Man Who Knew Too Much", 1956, (short) 120, PgType.R)
                , new MovieL("The Terminator", 1984, (short) 107, PgType.R)
                , new MovieL("Tightrope", 1984, (short) 114, PgType.R)
                , new MovieL("Unforgiven", 1992, (short) 130, PgType.R)
                , new MovieL("Thelma & Louise", 1991, (short) 130, PgType.R)
                , new MovieL("Thunderball", 1965, (short) 130, PgType.R)
        );

        var pathOutput = Path.of("movies.txt");
                // Path.of("target"); // provoke an error
        try (
           var outputStream = Files.newBufferedWriter(pathOutput);
           var printer = new PrintWriter(outputStream)
        ) {
            for (var movie : movies) {
                printer.println(movie.toString());
            }
            // close printer + outputStream
        } catch (IOException ex) {
            System.err.println("Error while saving movies");
            System.err.println(ex.getClass() + ":" + ex.getMessage());
        }
    }

    // lecture: bufferedReader
}
