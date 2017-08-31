/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3utools;

import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class M3UPlaylistTest {
    
    public M3UPlaylistTest() {
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
     * Test of save method, of class M3UPlaylist.
     */
    

    /**
     * Test of getTracks method, of class M3UPlaylist.
     */
    @Test
    public void testGetTracks() {
        System.out.println("getTracks");
        M3UPlaylist instance = new M3UPlaylist();
        List<M3UTrack> expResult = null;
        List<M3UTrack> result = instance.getTracks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTracks method, of class M3UPlaylist.
     */
    @Test
    public void testSetTracks() {
        System.out.println("setTracks");
        List<M3UTrack> tracks = null;
        M3UPlaylist instance = new M3UPlaylist();
        instance.setTracks(tracks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTrack method, of class M3UPlaylist.
     */
    @Test
    public void testAddTrack() {
        System.out.println("addTrack");
        M3UTrack thisTrack = null;
        M3UPlaylist instance = new M3UPlaylist();
        instance.addTrack(thisTrack);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class M3UPlaylist.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        M3UPlaylist instance = new M3UPlaylist();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class M3UPlaylist.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        M3UPlaylist instance = new M3UPlaylist();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSave() throws Exception {
        File plFilename = new File("test-data/testGetPlaylist/three_tracks.m3u");
        M3UPlaylist playList = M3UReader.getPlaylist(plFilename);
        assert(playList != null);
        boolean save_result = playList.save("newfile.m3u");
        assert(save_result);
    } 

    /**
     * Test of add method, of class M3UPlaylist.
     */
    @Test
    public void testAdd() {
        String filename = "test-data/testCopy/inputPlaylist.m3u";
        System.out.println("add tracks from file test 1");
        M3UPlaylist mypl = new M3UPlaylist();
        assertEquals(5, mypl.add(filename));
    }

    /**
     * Test of getNextTrack method, of class M3UPlaylist.
     */
    @Test
    public void testGetNextTrack() throws Exception {
        System.out.println("getNextTrack");
        M3UPlaylist instance = new M3UPlaylist();
        M3UTrack expResult = null;
        M3UTrack result = instance.getNextTrack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
