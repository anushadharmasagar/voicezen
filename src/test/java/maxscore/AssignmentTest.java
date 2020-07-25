package maxscore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * source: gfg/LeetCode/InterviewBit
 * 7/26/2020
 * 2:27 AM
 **/
public class AssignmentTest {

    private Assignment assignment;

    @Before
    public void before(){
        assignment = new Assignment();
    }

    @Test
    public void testMaxScore(){
        Assert.assertEquals("ABD", assignment.findMaxScore("F:/1-PHASE2/voicezen/src/main/resources/data1.txt"));
        Assert.assertEquals("iqzqcwltcjwbkegmkfymcgbtomweswmdontqlejnphqbmxnyelmhtnchcynuxbxloqezwpmlxolcbjgoxnkkqtmqhhnkgzavupjtuxgwermsbzivlaesqqbrpwvsheoeuzfmdwavazxidygpgnehkklmsenepauwnylbpmaaqmmdcipamtmncdfuhcudhkhlqrcsflajcooireabjlfqpbrqwjggkqwiszptgmuzcrcqqpqnbzqpljbxhvqsjybeerqfllauzquzfevpyzugrrokhetzktqmntunehbttceedeqobzcldlbeeroococbaoeovcbvanxubdimnqmnwixaclvgalgecqlppxnhploncrecnnbniqhsdgannnegrdbbdsfwhtdkrqbddewxfxqguzsxuxnbvbykujsqbqgbniushjdnkfkbmnnhsfmgkmqesftjgrjrnedygdmofyuxqllgmzxruzghorktokmhhyzgxpmztjnahijvatpezpjlcclzpilcnzfpspghlipsujauskbehwntqexwgsctxumxfofuktfhtcxwdwtoptmoofnzzcutxibncvrkeeuujbgbzhjkjsjxmxyhthtmdyhcudlatudnsnqnsmgqcxbxgyqatktpxburrqtrumxrkxjjseqqsbqwbllcxrxuwyyotnjirabsqfhgthikfjaqyzjaqutktnnzpttwttifivvrgajgemxmapwppjvrvvdmbmpttbpbmxrqsmaaamdxdooabhqlloobvhxrbbvbledhltbrkqqwqwkqpsslxjoccnklsacbsxeussccrpvpsnoucyfekikfyicrbybaqguwpuexlyqvqnhtbmtmjfccvbjsdqjnhjmwnavgyucgnunggnenkgntfuadkoajxfklahsxfummtowsqutebiniagqnaiveexjgbhbohbllrhqniwjnebbjqebjdvjnodtjhubdttnmjhrsb"
                , assignment.findMaxScore("F:/1-PHASE2/voicezen/src/main/resources/data2.txt"));
    }
}
