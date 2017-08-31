/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import m3utools.M3UPlaylist;
import m3utools.M3UTrack;
import m3utools.M3UReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ku14009
 */
public class M3UReaderTest {

    public M3UReaderTest() {
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
     * Test of isValidHeader method, of class M3UReader.
     */
    @Test
    public void testIsValidHeader() {
        System.out.println("isValidHeader:: current working directing is " + System.getProperty("user.dir"));
        String filename;
        boolean expResult, result;

        filename = "test-data" + File.separator + "testIsValidHeader" + File.separator + "validButEmpty.m3u";
        expResult = true;
        result = M3UReader.isValidHeader(filename);
        assertEquals(expResult, result);

        filename = "test-data" + File.separator + "testIsValidHeader" + File.separator + "invalid.m3u";
        expResult = false;
        result = M3UReader.isValidHeader(filename);
        assertEquals(expResult, result);

        filename = "test-data" + File.separator + "testIsValidHeader" + File.separator + "noSuchFile.m3u";
        expResult = false;
        result = M3UReader.isValidHeader(filename);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNumberOfTracks method, of class M3UReader.
     */
    @Test
    public void testGetNumberOfTracks() {
        System.out.println("getNumberOfTracks::");
        String filename;
        int expResult, result;

        filename = "test-data" + File.separator + "testGetNumberOfTracks" + File.separator + "noSuchFile.m3u";
        expResult = 0;
        result = M3UReader.getNumberOfTracks(filename);
        assertEquals(expResult, result);

        filename = "test-data" + File.separator + "testGetNumberOfTracks" + File.separator + "zero_tracks.m3u";
        expResult = 0;
        result = M3UReader.getNumberOfTracks(filename);
        assertEquals(expResult, result);

        filename = "test-data" + File.separator + "testGetNumberOfTracks" + File.separator + "three_tracks.m3u";
        expResult = 3;
        result = M3UReader.getNumberOfTracks(filename);
        assertEquals(expResult, result);

        filename = "test-data" + File.separator + "testGetNumberOfTracks" + File.separator + "four_tracks.m3u";
        expResult = 4;
        result = M3UReader.getNumberOfTracks(filename);
        assertEquals(expResult, result);

        filename = "test-data" + File.separator + "testGetNumberOfTracks" + File.separator + "five_tracks.m3u";
        expResult = 5;
        result = M3UReader.getNumberOfTracks(filename);
        assertEquals(expResult, result);

    }

    /**
     * Test of getTotalSeconds method, of class M3UReader.
     */
    @Test
    public void testGetTotalSeconds() {
        System.out.println("getTotalSeconds::");
        String playList;
        int expResult, result;

        playList = "test-data" + File.separator + "testGetNumberOfSeconds" + File.separator + "noSuchFile.m3u";
        expResult = 0;
        result = M3UReader.getTotalSeconds(playList);
        assertEquals(expResult, result);

        playList = "test-data" + File.separator + "testGetNumberOfSeconds" + File.separator + "455_seconds.m3u";
        expResult = 455;
        result = M3UReader.getTotalSeconds(playList);
        assertEquals(expResult, result);

        playList = "test-data" + File.separator + "testGetNumberOfSeconds" + File.separator + "1244_seconds.m3u";
        expResult = 1244;
        result = M3UReader.getTotalSeconds(playList);
        assertEquals(expResult, result);

        playList = "test-data" + File.separator + "testGetNumberOfSeconds" + File.separator + "1619_seconds.m3u";
        expResult = 1619;
        result = M3UReader.getTotalSeconds(playList);
        assertEquals(expResult, result);
    }

    /**
     * Test of copy method, of class M3UReader.
     */
    @Test
    public void testCopy() {
        System.out.println("copy::");
        String inputPlayList, outputPlayList;
        int numberOfSeconds, secondsInOutputFile;
        boolean expResult, result;

        inputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "inputPlaylist.m3u";
        outputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "outputPlaylist.m3u";
        numberOfSeconds = 290;
        expResult = true;
        result = M3UReader.copy(inputPlayList, outputPlayList, numberOfSeconds);
        secondsInOutputFile = 290;
        assertEquals(secondsInOutputFile, M3UReader.getTotalSeconds(outputPlayList));
        assertEquals(expResult, result);

        inputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "inputPlaylist.m3u";
        outputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "outputPlaylist.m3u";
        numberOfSeconds = 800;
        expResult = true;
        result = M3UReader.copy(inputPlayList, outputPlayList, numberOfSeconds);
        secondsInOutputFile = 745;
        assertEquals(secondsInOutputFile, M3UReader.getTotalSeconds(outputPlayList));
        assertEquals(expResult, result);

        inputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "inputPlaylist.m3u";
        outputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "outputPlaylist.m3u";
        numberOfSeconds = 2500;
        expResult = true;
        result = M3UReader.copy(inputPlayList, outputPlayList, numberOfSeconds);
        secondsInOutputFile = 2370;
        assertEquals(secondsInOutputFile, M3UReader.getTotalSeconds(outputPlayList));
        assertEquals(expResult, result);

        inputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "noSuchFile.m3u";
        outputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "outputPlaylist.m3u";
        numberOfSeconds = 0;
        expResult = false;
        result = M3UReader.copy(inputPlayList, outputPlayList, numberOfSeconds);
        assertEquals(expResult, result);

        inputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "invalidHeader.m3u";
        outputPlayList = "test-data" + File.separator + "testCopy" + File.separator + "outputPlaylist.m3u";
        numberOfSeconds = 0;
        expResult = false;
        result = M3UReader.copy(inputPlayList, outputPlayList, numberOfSeconds);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getTrack method, of class M3UReader.
//     */
//    //@Test
//    public void testGetTrack() {
//        System.out.println("getTrack::");
//        String trackFilename, trackMetaData;
//        M3UTrack expResult, result;
//
//        trackFilename = "F:\\SortedMusic\\Electronic\\Underworld\\Dubnobasswithmyheadman\\01 Dark & Long.mp3";
//        trackMetaData = "#EXTINF:455,Underworld - Dark & Long";
//        expResult = new M3UTrack().setTrackFilename(trackFilename).setTrackMetaData("Underworld - Dark & Long").setTrackDuration(455);
//        result = M3UReader.getTrack(trackFilename, trackMetaData);
//        assertEquals(expResult, result);
//
//        trackFilename = "F:\\SortedMusic\\Electronic\\Underworld\\Dubnobasswithmyheadman\\02 Mmm Skyscraper I Love You.mp3";
//        trackMetaData = "";
//        expResult = new M3UTrack().setTrackFilename(trackFilename).setTrackMetaData("Not Set").setTrackDuration(0);
//        result = M3UReader.getTrack(trackFilename, trackMetaData);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getPlaylist method, of class M3UReader.
//     */
//    @Test
//    public void testGetPlaylist() {
//        System.out.println("getPlaylist::");
//        File plFilename;
//        M3UPlaylist expResult, result;
//
//        plFilename = new File("test-data" + File.separator + "testGetPlaylist" + File.separator + "noSuchFile.m3u");
//        expResult = null;
//        result = M3UReader.getPlaylist(plFilename);
//        assertEquals(expResult, result);
//
//        plFilename = new File("test-data" + File.separator + "testGetPlaylist" + File.separator + "zero_tracks.m3u");
//        expResult = null;
//        result = M3UReader.getPlaylist(plFilename);
//        assertEquals(expResult, result);
//
//        plFilename = new File("test-data" + File.separator + "testGetPlaylist" + File.separator + "one_track.m3u");
//        expResult = new M3UPlaylist();
//        expResult.addTrack(new M3UTrack().setTrackFilename("F:\\SortedMusic\\Electronic\\Underworld\\Dubnobasswithmyheadman\\01 Dark & Long.mp3").setTrackMetaData("Underworld - Dark & Long").setTrackDuration(455));
//        result = M3UReader.getPlaylist(plFilename);
//        assertEquals(expResult, result);
//
//        plFilename = new File("test-data" + File.separator + "testGetPlaylist" + File.separator + "three_tracks.m3u");
//        expResult = new M3UPlaylist();
//        expResult.addTrack(new M3UTrack().setTrackFilename("F:\\SortedMusic\\Electronic\\Underworld\\Dubnobasswithmyheadman\\01 Dark & Long.mp3").setTrackMetaData("Not Set").setTrackDuration(0));
//        expResult.addTrack(new M3UTrack().setTrackFilename("F:\\SortedMusic\\Electronic\\Underworld\\Dubnobasswithmyheadman\\02 Mmm Skyscraper I Love You.mp3").setTrackMetaData("Not Set").setTrackDuration(0));
//        expResult.addTrack(new M3UTrack().setTrackFilename("F:\\SortedMusic\\Electronic\\Underworld\\Dubnobasswithmyheadman\\03 Surfboy.mp3").setTrackMetaData("Not Set").setTrackDuration(0));
//        result = M3UReader.getPlaylist(plFilename);
//        assertEquals(expResult, result);
//    }
    /**
     * Test of hasType method, of class M3UReader.
     */
    @Test
    public void testHasType() {

        System.out.println("test 1");
        assertEquals(true, M3UReader.hasType("test-data/testCopy/inputPlaylist.m3u", "mp3"));
        System.out.println("test 2");
        assertEquals(true, M3UReader.hasType("test-data/testCopy/inputPlaylist.m3u", "mp3"));
        System.out.println("test 3");
        assertEquals(true, M3UReader.hasType("test-data/testCopy/inputPlaylist.m3u", "mp3"));
        System.out.println("test 4");
        assertEquals(false, M3UReader.hasType("blah/nonamefile.nothing", "mp3"));

    }

    /**
     * Test of hasExtraComments method, of class M3UReader.
     */
    @Test
    public void testHasExtraComments() {
        System.out.println("Test 1");
        System.out.println("");
        assertEquals(true, M3UReader.hasExtraComments("test-data/testCopy/inputPlaylist.m3u"));
        System.out.println("");
        System.out.println("Test 2");
        System.out.println("");
        assertEquals(false, M3UReader.hasExtraComments("test-data/testCopy/invalidHeader.m3u"));
        System.out.println("");
        System.out.println("Test 3");
        System.out.println("");
        assertEquals(false, M3UReader.hasExtraComments("test-data/testCopy/blahblah.m3u"));
    }

    /**
     * Test of getExtraComments method, of class M3UReader.
     */
    @Test
    public void testGetExtraComments() {
        System.out.println("Test 1");
        List<String> result = M3UReader.getExtraComments("test-data/testCopy/inputPlaylist.m3u");
        assertEquals(5, result.size());
    }

    @Test
    public void testGetExtraComments2() {
        System.out.println("Test 2");
        List<String> result2 = M3UReader.getExtraComments("test-data/testCopy/blahfile.m3u");
        assertEquals(null, result2);
    }

    @Test
    public void testGetExtraComments3() {
        System.out.println("Test 3");
        List<String> result3 = M3UReader.getExtraComments("test-data/testCopy/cantOpen.m3u");
        assertEquals(null, result3);
    }

    /**
     * Test of getPlaylist method, of class M3UReader.
     */
    @Test
    public void testGetPlaylist() {
        System.out.println("getPlaylist");
        File plFilename = null;
        M3UPlaylist expResult = null;
        M3UPlaylist result = M3UReader.getPlaylist(plFilename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrack method, of class M3UReader.
     */
    @Test
    public void testGetTrack() {
        System.out.println("getTrack");
        String trackFilename = "";
        String trackMetaData = "";
        M3UTrack expResult = null;
        M3UTrack result = M3UReader.getTrack(trackFilename, trackMetaData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasEmptyLines method, of class M3UReader.
     */
    @Test
    public void testHasEmptyLines() {
        System.out.println("Test 1");
        assertEquals(true, M3UReader.hasEmptyLines("test-data/testCopy/emptylines.m3u"));
        System.out.println("Test 2");
        assertEquals(false, M3UReader.hasEmptyLines("test-data/testCopy/inputPlaylist.m3u"));
    }

}
