/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jamie
 */
public class M3UFinderTest {

    public M3UFinderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNumberOfPlaylists method, of class M3UFinder.
     */
    @Test
    public void testGetNumberOfPlaylists() {
        System.out.println("getNumberOfPlaylists::");
        Path p;
        int expResult, result;

        String testFolder = "test-data" + File.separator + 
                "testGetNumberOfPlaylists" + File.separator;
        
        p = Paths.get(testFolder + "containsFourPlaylists");
        expResult = 4;
        result = M3UFinder.getNumberOfPlaylists(p);
        assertEquals(expResult, result);

        p = Paths.get(testFolder + "containsTwoPlaylists");
        expResult = 2;
        result = M3UFinder.getNumberOfPlaylists(p);
        assertEquals(expResult, result);

        p = Paths.get(testFolder + "containsZeroPlaylists");
        expResult = 0;
        result = M3UFinder.getNumberOfPlaylists(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlaylistFilenames method, of class M3UFinder.
     */
    @Test
    public void testGetPlaylistFilenames() {
        System.out.println("getPlaylistFilenames::");
        Path p;
        List<String> expResult, result;

        String testFolder = "test-data" + File.separator + "testGetPlaylistFilenames" 
                + File.separator + "containsFourPlaylists";
        p = Paths.get(testFolder);
        expResult = new ArrayList<String>();
        expResult.add(testFolder + File.separator + "child_folder1" + 
                File.separator + "five_tracks.m3u");
        expResult.add(testFolder + File.separator + "child_folder2" + 
                File.separator + "four_tracks.m3u");
        expResult.add(testFolder + File.separator + "four_tracks.m3u");
        expResult.add(testFolder+ File.separator + "three_tracks.m3u");
        result = M3UFinder.getPlaylistFilenames(p);
        Collections.sort(result, null);
        Collections.sort(expResult, null);
        assertEquals(expResult, result);

        testFolder = "test-data" + File.separator + "testGetPlaylistFilenames"
                + File.separator + "containsTwoPlaylists";
        p = Paths.get(testFolder);
        expResult = new ArrayList<String>();
        expResult.add(testFolder + File.separator + "four_tracks.m3u");
        expResult.add(testFolder + File.separator + "three_tracks.m3u");
        result = M3UFinder.getPlaylistFilenames(p);
        Collections.sort(result, null);
        Collections.sort(expResult, null);
        assertEquals(expResult, result);

        testFolder = "test-data" + File.separator + "testGetPlaylistFilenames"
                + File.separator + "containsZeroPlaylists";
        p = Paths.get(testFolder);
        expResult = new ArrayList<>();
        result = M3UFinder.getPlaylistFilenames(p);
        Collections.sort(result, null);
        Collections.sort(expResult, null);
        assertEquals(expResult, result);
    }

}
