package maxscore;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.junit.Assert;
import org.junit.Test;


/**
 * Below class finds the subsequence with maxscore according to given formula
 * 
 * Math.pow(length, 2) * Math.pow((frequency - 1), 0.33)
 * length: subsequence length
 * frequency: number of times the subsequence is repeated in the full file
 *
 * Time Complexity - (n/k)O(k^2)
 * Space Complexity - O(k^2)
 * where k is the fixed size here it is 3000 characters
 */
public class Solution {
    /**
     * Reads the given file from the path 3000 characters and finds the longest subsequence
     *
     * @param path
     * @throws Exception
     */
    public String findMaxScore(String path) {
        try(RandomAccessFile file = new RandomAccessFile(path, "r")) {
            long length = file.length();
            long offset = 0;
            long size = 3 * 1024; // read by 3Kb or 3000 since its given limit

            FileChannel channel = file.getChannel();
            long maxLen = Long.MIN_VALUE;
            String maxString = "";
            int[][] maxdp = new int[3000][3000];
            while (offset < length) {
                file.seek(offset);
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, offset, Math.min(size, length - offset));
                buffer.load();
                StringBuilder str = new StringBuilder("");
                for (int i = 0; i < buffer.limit(); i++) {
                    str.append((char) buffer.get());
                }
                String X = str.toString();
                int[][] T = new int[X.length() + 1][X.length() + 1];
                LRSLength(X, T);
                int currLen = T[X.length()][X.length()];
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxString = X;
                    maxdp = T;
                }
                buffer.clear();
                offset += size;
            }
            channel.close();
            file.close();
            return LRS(maxString, maxdp);
        }catch (Exception e){
            throw new RuntimeException("Exception occurred while opening the file", e);
        }
    }

    private String LRS(String str, int[][] lookup) {

        int n = str.length();
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                lookup[i][j] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];
                else
                    lookup[i][j] = Math.max(lookup[i][j - 1], lookup[i - 1][j]);
        String res = "";
        int i = n, j = n;
        while (i > 0 && j > 0) {

            if (lookup[i][j] == lookup[i - 1][j - 1] + 1) {
                res = res + str.charAt(i - 1);
                i--;
                j--;
            } else if (lookup[i][j] == lookup[i - 1][j])
                i--;
            else
                j--;
        }
        String reverse = "";
        for (int k = res.length() - 1; k >= 0; k--) {
            reverse = reverse + res.charAt(k);
        }
        return reverse;
    }

    private void LRSLength(String str, int[][] lookup) {
        int n = str.length();
        // Create and initialize DP table
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                lookup[i][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];

                else
                    lookup[i][j] = Math.max(lookup[i][j - 1], lookup[i - 1][j]);
            }
        }
    }
    
    @Test
    public void testMaxScore(){
        Assert.assertEquals("ABD",findMaxScore("F:/1-PHASE2/voicezen/src/main/resources/data1.txt"));
        Assert.assertEquals("iqzqcwltcjwbkegmkfymcgbtomweswmdontqlejnphqbmxnyelmhtnchcynuxbxloqezwpmlxolcbjgoxnkkqtmqhhnkgzavupjtuxgwermsbzivlaesqqbrpwvsheoeuzfmdwavazxidygpgnehkklmsenepauwnylbpmaaqmmdcipamtmncdfuhcudhkhlqrcsflajcooireabjlfqpbrqwjggkqwiszptgmuzcrcqqpqnbzqpljbxhvqsjybeerqfllauzquzfevpyzugrrokhetzktqmntunehbttceedeqobzcldlbeeroococbaoeovcbvanxubdimnqmnwixaclvgalgecqlppxnhploncrecnnbniqhsdgannnegrdbbdsfwhtdkrqbddewxfxqguzsxuxnbvbykujsqbqgbniushjdnkfkbmnnhsfmgkmqesftjgrjrnedygdmofyuxqllgmzxruzghorktokmhhyzgxpmztjnahijvatpezpjlcclzpilcnzfpspghlipsujauskbehwntqexwgsctxumxfofuktfhtcxwdwtoptmoofnzzcutxibncvrkeeuujbgbzhjkjsjxmxyhthtmdyhcudlatudnsnqnsmgqcxbxgyqatktpxburrqtrumxrkxjjseqqsbqwbllcxrxuwyyotnjirabsqfhgthikfjaqyzjaqutktnnzpttwttifivvrgajgemxmapwppjvrvvdmbmpttbpbmxrqsmaaamdxdooabhqlloobvhxrbbvbledhltbrkqqwqwkqpsslxjoccnklsacbsxeussccrpvpsnoucyfekikfyicrbybaqguwpuexlyqvqnhtbmtmjfccvbjsdqjnhjmwnavgyucgnunggnenkgntfuadkoajxfklahsxfummtowsqutebiniagqnaiveexjgbhbohbllrhqniwjnebbjqebjdvjnodtjhubdttnmjhrsb"
                ,findMaxScore("F:/1-PHASE2/voicezen/src/main/resources/data2.txt"));
    }
}
