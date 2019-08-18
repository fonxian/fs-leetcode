package com.fonxian.leetcode.leetcode5048;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2019-08-18
 */
public class Solution {

    public int countCharacters(String[] words, String chars) {
        char[] array = chars.toCharArray();
        List<String> charList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            charList.add(String.valueOf(array[i]));
        }
        for (int i = 0; i < words.length; i++) {
            if (isRight(words[i], charList)) {
                result.add(words[i]);
            }
        }
        int res = 0;
        for (String s : result) {
            res += s.length();
        }
        return res;
    }


    private boolean isRight(String str, List<String> charList) {
        List<String> tempList = new ArrayList<>();
        tempList.addAll(charList);
        char[] array = str.toCharArray();
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < tempList.size(); j++) {
                if (tempList.get(j).equals(String.valueOf(array[i]))) {
                    tempList.remove(j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            flag = false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
//
//        String[] words = {
//                "qobxtxjzdngkrzamsxzdvbvkiwijokwdyndqllhqpaoxzwonriclsm",
//                "fahtqqnuzhhhrcblquaosdfdcqoskxcsdnhtwvvvzsxkpjprytieieniafnltxmuzwkdnttofpibi",
//                "xedhntgrqegfs",
//                "wrssfvsbcehbahbvojnzgacbgveitirkjmmyiorwykynqddgydzgfvlvplfnyumgxturxraonpchd",
//                "hpmdzhpgijirecxzkuyhptiytnuscu",
//                "xljgysrjjukphjgzbpn","gmwbirxt","yhvpsvsnhfmbmcpihnqtodspbvexnpgcqrrughbakbufyjispkquvfppkaffypdpnvikjygdaarcigipfhuvzzzbgw","gvvbgpjolobpbxcnhnzuqrsqgrkanwmnnkqynakkooailoafunopsrlijqhaqmszssxikftcfoqsw","naktgxfyuvuoh","muui","ghzqskipqprrzeligdjyowypeerogxonvztsq","onosezgutawtzteoagbftclsqpfsxtwetourxjxurdqevrir","fcskqxwkzsldsjihahalnw","lsstgzxjxabcbspjwelqmhtnurgfmdtpaihxnxad","nwrwtwetgjwooevhxhkzlvsyghtkldioyjhkkniepktqs","utohzbqvkqkq","vdoqnhtidgicevprrrwlbtldtaxpsxdhxhgbwlkbeglkbhrujtafswjkozdmdpvwhsuskofmxxtprtpopacslinwozth","zqlzxpemomnbzxlorvlkxt","kubshvnldnkofitnnjere","czxmqpowzzhdbhgtlqdokrzxowsvwyavfhcycctgdvrsfzmanrlktfaetnuayrqkvhcbxezfahkrxgaaztovrxuhnll","rrcesnfbxglhjawldnnuiiepdsofbrsbjczlemusqwvenicxmtdmpwfrnizymfmqynvtkbrmablcugroshc","thholqebekkysstqzlbbdapktxumygplqganucwnahmrihiraxdnvbiaqhykcti",
//                "fagqnapzeeglbdzsbneosxmptmwopjcxztukhpjkqjmjbkpbzrfaqskctehyboeddmilkwlurcb",
//                "wtjdykncubkduhxiwwusoxvzpnaxpnzdjmwddnonsmmvwmuaxghetgrwpoeqbprxgviwzagyqopfdakrqjgiy","nsftehpgzstetbganbtozdopptseucdqkhzdmujnzjdvufqtikgeepttnrabb","ozihktgnvljzhqwanxemtzxphzqvmoblvi","iwdsrekqllbbyarzzmbqbvldvxctdeswiyahiwfoefhfsfwktdzaulnalewbusazjhcbtxjuck","dylhds","idnaddnzbodhjrpshhahnbbnrskruxszxeeyanumazvahktizectmmvjbhnhbrohsyqhrgq","scyzsykrwzuozmbrbenfiqpxchtpmcxepjiglaeionsmbwrzeidupayusczcooudpcgkgspbuyzcdfymsejucb","otpcfrhckxmnseayhwoyjjfkceaoznmmkikpdsuueyqmbsuelmhqnmdsjs","xoghnhpypfiibqrpgtyux","cxhpbcziptgandiwxtctdjpboiqwv","gyjosuhwgbqpcdsdqadopdqozjxpzwxbqaffnxaddhgrxmunpidvpnijxnbawshcznkmprpgkhvzxmzbaftedgtfgjhaisdnva","jlnxshfthqgzlnvjzztrnjswwsotpybxecyqhnfkbfwvmxpcs","mtddspmqwbnoiajpexsuhxogarduzsoammqqelh","sixkvxgnbalipwmkbcwpugpvolsvvlmaaeeobmoeogspbkbsskwjdqkite","xhsutriuynfrldjbhexhxjgcfwcujvwsqfiaqwvjnkjkswdpaynelhryrzfeqjhajezmolk","zfiredtxenzgtrkiamuoubetexzbnwkdtxbtihhtsfubnmryxq","sot","szgkkhuhkcnr","firxkgvkzqlnallzwjispsizoawobemuhqrhpyvknasjzwctamfuonder","vyei","fidqszoicndwifns","xkickycwzj","gmybflbjunudxrwguzditaxmyadgdjeengut","gvlwwnmrddhzwewugdtobauecealfhasyftgxkiqeluysxxmroukfziifpryvddggttojhcszeyjetbsldmorqnbuqreuxfw","vbhuerxkcjlkamgruturkbrubbscmvzqruwvlrlyylcvuiothkhpznjzsfnyfoaqkziyjqzdreeygmtbdljwnaojexfgmjlup","bxjvop","aswdmctosieicucsjwxych","lxbtlhnrfyaznrqgxrltmxkjmhdqjjgnvstxaygmuxznjfiiukm","npncdabkmbgfhnedcmbfyjiplzwymgvsfrifvvjayobsygwolqbwkblqutakcshnlsqadtfiqmpauslvqd","kuyemuuymacyvmahtagmcewkspverpjtjscccnrczchgkjzppdxcalxxcxrwnepk","jxwouobfvzttz","yucpsdhqvzboeezcqpxsepuuk","iwbdmxdcbypnzqmgkrjhfivkrmnv","lpqklgcwdvgbghfyoyejnpexrelywqfdtczflwetbxvzigtvisi","dlasodatffcreungntdmezgfqklrabyymsnhdberufcrgpxgsziklznhdprbczhbxgtuslufycjronozdqumzlnidkvaydg","oejzlmrrbdysqlezifcvgjnmvodfvmrnjmnfkejdbnnyljzjaxfecrfefdgarqbtwoijuktacywmsubtxtgzkbnstgrsrjpkdfe","mlegvhxielwlfadlnqvnipcuizpdxgtvro","vwgmwkbturocovaykdsjaftbtgmtwknnmhexfgcfchpwwgcgecfobbencotjizxbtdrijwfjxdsxanwfjyjamrxrdaiusgr","xjmkcsekcorldyrjiavrhuhqtndujymc","rmxwcaorznumwxgwnibnxwzvnxjhzwqzgmkgifnnnnzpgtsvprycjtdeirtpqbduursabbidzkfbexgthkoacagkb","tkrsxhztwgvqxamjtexklnooaloydjhejlbasavskttwxiabarogvmfdfjttaxhgqljlbfnrvrwwbxkurhufiknoxfmemcv","cojlyayladyrhofzetaddteqrjbyxtvyszgdorexqmgznqmuvemegbwki","zktqnurtpttlcjgkmnprqeyeepqunfqqvjwuevwbvnaupyofwiqwhpyumyfwpjrruhleromrmpvczlkxqiuq","gyxl","qmhwlymfsjixvvjhkczylqcsnbjxliasetxciggtfl","gizysqkqbyhzeagzsscvdigtcfiupyhqovaaioxfrphugxzrcjvwqwc","hpgkulrmbaixnjiapmjiwhwsgromfqpxqkkiscjwpiicslwcijginxfiwqakeezeohhskxgvgdkezmqys","vibswdyqaxjvqsffwmcismooheyhwzqvyzezluejztlgddshvwcryzcllaisxrygwqyyoiaivfvgtzicycyrkckv","oyclwdejlifmocfjsbgmernsyitkfaahjxfnwnusrdypsziawlpsjgnavytdihpxcmugshnqbkyfts","xwcbiporfbktpvqhznjuaxfcdykifuzwdsdhxirwwxinoffywgxscrtuwhvuwjejzqirsfijgguouapqpmfdnpsfm","qffrjfkj","rpynimubaxdgbrkdawgugnhobaowxdnzkiidworcsnejgqctftyksvbhiwkcnyffmsbxwptqn","oeqdvldvfbklukstxwomapaauaozblhxudkdxihepqagndnlkvbqhluscvczhrsrhodnftoszhjdymuywdtjgzbmkrdf","xviupppkeswkctwlqwyuhokbhqqjshmaeiouhununbhrkabacenkg","habomjnlznqvckmowgelhnglfizogckplbymkdowfpicxydzgoskckraxpdysksvzezcpg","zemawxwjeowraaqsqytsshtavnvoyiyollelxqabmjwhxtrdijiacbbjiiyzwkxboot","jcnpsxnkbqdbh","bftrbaurtzkftodotjguzjmwxrrmswxwclohotuanypmhtemmsaicwckowmcdmpnhcfzptekpgljfvwpqjgilxu","bbaigjqxdmuchkkb","effbptpwafzqbsebbjmvdcxdbmnlfqjklongafzkvaqmkehefedjxgxlbdhltihtgfqjjsdis","lhuxgqpwcgpujfvvnlrxhgbiwxmxzhglyhkdkafafojtlkuxkmjwlxrd","ussuyjqsxwsdhkjeipwycrkcxxjatoqhygzymgikqdnqiyyzlbcdlgtmneyickucbkpkza","ykmsksjorovmdymlbgprvprnyxwppvwgmzfjsqouvgara","wduqkbncayo","qdfkyomjlhfozonwpdxllqdnvpohyijqmyymuclnydzmlqksntdfj","ynzekkkljzrvnwclzcfgtvcmstxgadxpztofckypbgqgbnumnkeaqclaspzxjbygtkjznxeduhbksr","aw","jbremnahqoiqktpbkteefdkbrerrxmhqbbselpnfzapgmxidrhbixetaetjcroufa","wtufuqgljvxzsurhviikdxyuythezjnvwrxqrykmotkhlphlyfljjsfugzwxxfqkc","ytjuaagqnfxqwiopolnejmoxow","oqoskpzkwxsffgeuuhdklidtmjobzayatyaqefgwgqbo","qkhtpuhhkspffkpryvdjasbxhtfrmptpljszvtgvhfvqpxypxfdaphfqdmigzgfg","goddugelwdvemxwureitzwqmbqeqtymrlrzahuxnpgufaagbpexwpoahvdnsyvgxw","dfhxrctagxkuasofoejsalcerkbtsjwnbnoahsumzfyiiskhzzwyykeefszrzrbztbrzhxxgaajb","tjsardsbhmhefysdqtbhzsxukbwdpioqaohloaancxdkkmofniojrvxj","jzjozqfqiwyfadplibubtpcfxxfvjtbizxlmpaccjpihvnrtvfqtfiaztvfbednyemfmahbljdvykddawaujdksenm"
//       };
//        String chars = "fcxpzkzkqeyeijquyfixvlzjpzomujrqzxeoynjiflnmdrpdkrm";
        System.out.println(s.countCharacters(words, chars));

    }

}
