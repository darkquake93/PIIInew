/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jamie
 */
public class M3UFinder {

    public static int getNumberOfPlaylists(Path p) {
        int numberOfPlaylists = 0;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(p)) {
            for (Path file : stream) {
                if (Files.isDirectory(file, LinkOption.NOFOLLOW_LINKS)) {
                    numberOfPlaylists += getNumberOfPlaylists(file);
                } else if (M3UReader.isValidHeader(file.toString())) {
                    numberOfPlaylists++;
                }
            }
        } catch (Exception e) {
            System.err.println("getNumberOFPlaylists:: error with path "
                    + p + ": " + e.getMessage());
            numberOfPlaylists = 0;
        }

        return numberOfPlaylists;
    }

    public static List<String> getPlaylistFilenames(Path p) {
        List<String> listOfPlaylists = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(p)) {
            for (Path file : stream) {                
                if (Files.isDirectory(file, LinkOption.NOFOLLOW_LINKS)) {                  
                    listOfPlaylists.addAll(getPlaylistFilenames(file));
                } else if (M3UReader.isValidHeader(file.toString())) {
                    listOfPlaylists.add(file.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("getPlaylistFilenames:: error with path "
                    + p + ": " + e.getMessage());
        }

        return listOfPlaylists;
    }

}
