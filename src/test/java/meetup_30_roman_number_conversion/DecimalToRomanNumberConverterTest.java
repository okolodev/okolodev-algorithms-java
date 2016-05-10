package meetup_30_roman_number_conversion;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DecimalToRomanNumberConverterTest {
    private DecimalToRomanNumberConverter converter =
            new DecimalToRomanNumberConverter();

    @Test
    @Parameters({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "7, VII",
            "8, VIII",
            "9, IX",
            "10, X",
            "11, XI",
            "12, XII",
            "13, XIII",
            "14, XIV",
            "15, XV",
            "16, XVI",
            "17, XVII",
            "18, XVIII",
            "19, XIX",
            "20, XX",
            "21, XXI",
            "22, XXII",
            "23, XXIII",
            "24, XXIV",
            "25, XXV",
            "26, XXVI",
            "27, XXVII",
            "28, XXVIII",
            "29, XXIX",
            "30, XXX",
            "31, XXXI",
            "32, XXXII",
            "33, XXXIII",
            "34, XXXIV",
            "35, XXXV",
            "36, XXXVI",
            "37, XXXVII",
            "38, XXXVIII",
            "39, XXXIX",
            "40, XL",
            "41, XLI",
            "42, XLII",
            "43, XLIII",
            "44, XLIV",
            "45, XLV",
            "46, XLVI",
            "47, XLVII",
            "48, XLVIII",
            "49, XLIX",
            "50, L",
            "51, LI",
            "52, LII",
            "53, LIII",
            "54, LIV",
            "55, LV",
            "56, LVI",
            "57, LVII",
            "58, LVIII",
            "59, LIX",
            "60, LX",
            "61, LXI",
            "62, LXII",
            "63, LXIII",
            "64, LXIV",
            "65, LXV",
            "66, LXVI",
            "67, LXVII",
            "68, LXVIII",
            "69, LXIX",
            "70, LXX",
            "71, LXXI",
            "72, LXXII",
            "73, LXXIII",
            "74, LXXIV",
            "75, LXXV",
            "76, LXXVI",
            "77, LXXVII",
            "78, LXXVIII",
            "79, LXXIX",
            "80, LXXX",
            "81, LXXXI",
            "82, LXXXII",
            "83, LXXXIII",
            "84, LXXXIV",
            "85, LXXXV",
            "86, LXXXVI",
            "87, LXXXVII",
            "88, LXXXVIII",
            "89, LXXXIX",
            "90, XC",
            "91, XCI",
            "92, XCII",
            "93, XCIII",
            "94, XCIV",
            "95, XCV",
            "96, XCVI",
            "97, XCVII",
            "98, XCVIII",
            "99, XCIX",
            "100, C",
            "101, CI",
            "102, CII",
            "103, CIII",
            "104, CIV",
            "105, CV",
            "106, CVI",
            "107, CVII",
            "108, CVIII",
            "109, CIX",
            "110, CX",
            "111, CXI",
            "112, CXII",
            "113, CXIII",
            "114, CXIV",
            "115, CXV",
            "116, CXVI",
            "117, CXVII",
            "118, CXVIII",
            "119, CXIX",
            "120, CXX",
            "121, CXXI",
            "122, CXXII",
            "123, CXXIII",
            "124, CXXIV",
            "125, CXXV",
            "126, CXXVI",
            "127, CXXVII",
            "128, CXXVIII",
            "129, CXXIX",
            "130, CXXX",
            "131, CXXXI",
            "132, CXXXII",
            "133, CXXXIII",
            "134, CXXXIV",
            "135, CXXXV",
            "136, CXXXVI",
            "137, CXXXVII",
            "138, CXXXVIII",
            "139, CXXXIX",
            "140, CXL",
            "141, CXLI",
            "142, CXLII",
            "143, CXLIII",
            "144, CXLIV",
            "145, CXLV",
            "146, CXLVI",
            "147, CXLVII",
            "148, CXLVIII",
            "149, CXLIX",
            "150, CL",
            "151, CLI",
            "152, CLII",
            "153, CLIII",
            "154, CLIV",
            "155, CLV",
            "156, CLVI",
            "157, CLVII",
            "158, CLVIII",
            "159, CLIX",
            "160, CLX",
            "161, CLXI",
            "162, CLXII",
            "163, CLXIII",
            "164, CLXIV",
            "165, CLXV",
            "166, CLXVI",
            "167, CLXVII",
            "168, CLXVIII",
            "169, CLXIX",
            "170, CLXX",
            "171, CLXXI",
            "172, CLXXII",
            "173, CLXXIII",
            "174, CLXXIV",
            "175, CLXXV",
            "176, CLXXVI",
            "177, CLXXVII",
            "178, CLXXVIII",
            "179, CLXXIX",
            "180, CLXXX",
            "181, CLXXXI",
            "182, CLXXXII",
            "183, CLXXXIII",
            "184, CLXXXIV",
            "185, CLXXXV",
            "186, CLXXXVI",
            "187, CLXXXVII",
            "188, CLXXXVIII",
            "189, CLXXXIX",
            "190, CXC",
            "191, CXCI",
            "192, CXCII",
            "193, CXCIII",
            "194, CXCIV",
            "195, CXCV",
            "196, CXCVI",
            "197, CXCVII",
            "198, CXCVIII",
            "199, CXCIX",
            "200, CC",
            "201, CCI",
            "202, CCII",
            "203, CCIII",
            "204, CCIV",
            "205, CCV",
            "206, CCVI",
            "207, CCVII",
            "208, CCVIII",
            "209, CCIX",
            "210, CCX",
            "211, CCXI",
            "212, CCXII",
            "213, CCXIII",
            "214, CCXIV",
            "215, CCXV",
            "216, CCXVI",
            "217, CCXVII",
            "218, CCXVIII",
            "219, CCXIX",
            "220, CCXX",
            "221, CCXXI",
            "222, CCXXII",
            "223, CCXXIII",
            "224, CCXXIV",
            "225, CCXXV",
            "226, CCXXVI",
            "227, CCXXVII",
            "228, CCXXVIII",
            "229, CCXXIX",
            "230, CCXXX",
            "231, CCXXXI",
            "232, CCXXXII",
            "233, CCXXXIII",
            "234, CCXXXIV",
            "235, CCXXXV",
            "236, CCXXXVI",
            "237, CCXXXVII",
            "238, CCXXXVIII",
            "239, CCXXXIX",
            "240, CCXL",
            "241, CCXLI",
            "242, CCXLII",
            "243, CCXLIII",
            "244, CCXLIV",
            "245, CCXLV",
            "246, CCXLVI",
            "247, CCXLVII",
            "248, CCXLVIII",
            "249, CCXLIX",
            "250, CCL",
            "251, CCLI",
            "252, CCLII",
            "253, CCLIII",
            "254, CCLIV",
            "255, CCLV",
            "256, CCLVI",
            "257, CCLVII",
            "258, CCLVIII",
            "259, CCLIX",
            "260, CCLX",
            "261, CCLXI",
            "262, CCLXII",
            "263, CCLXIII",
            "264, CCLXIV",
            "265, CCLXV",
            "266, CCLXVI",
            "267, CCLXVII",
            "268, CCLXVIII",
            "269, CCLXIX",
            "270, CCLXX",
            "271, CCLXXI",
            "272, CCLXXII",
            "273, CCLXXIII",
            "274, CCLXXIV",
            "275, CCLXXV",
            "276, CCLXXVI",
            "277, CCLXXVII",
            "278, CCLXXVIII",
            "279, CCLXXIX",
            "280, CCLXXX",
            "281, CCLXXXI",
            "282, CCLXXXII",
            "283, CCLXXXIII",
            "284, CCLXXXIV",
            "285, CCLXXXV",
            "286, CCLXXXVI",
            "287, CCLXXXVII",
            "288, CCLXXXVIII",
            "289, CCLXXXIX",
            "290, CCXC",
            "291, CCXCI",
            "292, CCXCII",
            "293, CCXCIII",
            "294, CCXCIV",
            "295, CCXCV",
            "296, CCXCVI",
            "297, CCXCVII",
            "298, CCXCVIII",
            "299, CCXCIX",
            "300, CCC",
            "301, CCCI",
            "302, CCCII",
            "303, CCCIII",
            "304, CCCIV",
            "305, CCCV",
            "306, CCCVI",
            "307, CCCVII",
            "308, CCCVIII",
            "309, CCCIX",
            "310, CCCX",
            "311, CCCXI",
            "312, CCCXII",
            "313, CCCXIII",
            "314, CCCXIV",
            "315, CCCXV",
            "316, CCCXVI",
            "317, CCCXVII",
            "318, CCCXVIII",
            "319, CCCXIX",
            "320, CCCXX",
            "321, CCCXXI",
            "322, CCCXXII",
            "323, CCCXXIII",
            "324, CCCXXIV",
            "325, CCCXXV",
            "326, CCCXXVI",
            "327, CCCXXVII",
            "328, CCCXXVIII",
            "329, CCCXXIX",
            "330, CCCXXX",
            "331, CCCXXXI",
            "332, CCCXXXII",
            "333, CCCXXXIII",
            "334, CCCXXXIV",
            "335, CCCXXXV",
            "336, CCCXXXVI",
            "337, CCCXXXVII",
            "338, CCCXXXVIII",
            "339, CCCXXXIX",
            "340, CCCXL",
            "341, CCCXLI",
            "342, CCCXLII",
            "343, CCCXLIII",
            "344, CCCXLIV",
            "345, CCCXLV",
            "346, CCCXLVI",
            "347, CCCXLVII",
            "348, CCCXLVIII",
            "349, CCCXLIX",
            "350, CCCL",
            "351, CCCLI",
            "352, CCCLII",
            "353, CCCLIII",
            "354, CCCLIV",
            "355, CCCLV",
            "356, CCCLVI",
            "357, CCCLVII",
            "358, CCCLVIII",
            "359, CCCLIX",
            "360, CCCLX",
            "361, CCCLXI",
            "362, CCCLXII",
            "363, CCCLXIII",
            "364, CCCLXIV",
            "365, CCCLXV",
            "366, CCCLXVI",
            "367, CCCLXVII",
            "368, CCCLXVIII",
            "369, CCCLXIX",
            "370, CCCLXX",
            "371, CCCLXXI",
            "372, CCCLXXII",
            "373, CCCLXXIII",
            "374, CCCLXXIV",
            "375, CCCLXXV",
            "376, CCCLXXVI",
            "377, CCCLXXVII",
            "378, CCCLXXVIII",
            "379, CCCLXXIX",
            "380, CCCLXXX",
            "381, CCCLXXXI",
            "382, CCCLXXXII",
            "383, CCCLXXXIII",
            "384, CCCLXXXIV",
            "385, CCCLXXXV",
            "386, CCCLXXXVI",
            "387, CCCLXXXVII",
            "388, CCCLXXXVIII",
            "389, CCCLXXXIX",
            "390, CCCXC",
            "391, CCCXCI",
            "392, CCCXCII",
            "393, CCCXCIII",
            "394, CCCXCIV",
            "395, CCCXCV",
            "396, CCCXCVI",
            "397, CCCXCVII",
            "398, CCCXCVIII",
            "399, CCCXCIX",
            "400, CD",
            "401, CDI",
            "402, CDII",
            "403, CDIII",
            "404, CDIV",
            "405, CDV",
            "406, CDVI",
            "407, CDVII",
            "408, CDVIII",
            "409, CDIX",
            "410, CDX",
            "411, CDXI",
            "412, CDXII",
            "413, CDXIII",
            "414, CDXIV",
            "415, CDXV",
            "416, CDXVI",
            "417, CDXVII",
            "418, CDXVIII",
            "419, CDXIX",
            "420, CDXX",
            "421, CDXXI",
            "422, CDXXII",
            "423, CDXXIII",
            "424, CDXXIV",
            "425, CDXXV",
            "426, CDXXVI",
            "427, CDXXVII",
            "428, CDXXVIII",
            "429, CDXXIX",
            "430, CDXXX",
            "431, CDXXXI",
            "432, CDXXXII",
            "433, CDXXXIII",
            "434, CDXXXIV",
            "435, CDXXXV",
            "436, CDXXXVI",
            "437, CDXXXVII",
            "438, CDXXXVIII",
            "439, CDXXXIX",
            "440, CDXL",
            "441, CDXLI",
            "442, CDXLII",
            "443, CDXLIII",
            "444, CDXLIV",
            "445, CDXLV",
            "446, CDXLVI",
            "447, CDXLVII",
            "448, CDXLVIII",
            "449, CDXLIX",
            "450, CDL",
            "451, CDLI",
            "452, CDLII",
            "453, CDLIII",
            "454, CDLIV",
            "455, CDLV",
            "456, CDLVI",
            "457, CDLVII",
            "458, CDLVIII",
            "459, CDLIX",
            "460, CDLX",
            "461, CDLXI",
            "462, CDLXII",
            "463, CDLXIII",
            "464, CDLXIV",
            "465, CDLXV",
            "466, CDLXVI",
            "467, CDLXVII",
            "468, CDLXVIII",
            "469, CDLXIX",
            "470, CDLXX",
            "471, CDLXXI",
            "472, CDLXXII",
            "473, CDLXXIII",
            "474, CDLXXIV",
            "475, CDLXXV",
            "476, CDLXXVI",
            "477, CDLXXVII",
            "478, CDLXXVIII",
            "479, CDLXXIX",
            "480, CDLXXX",
            "481, CDLXXXI",
            "482, CDLXXXII",
            "483, CDLXXXIII",
            "484, CDLXXXIV",
            "485, CDLXXXV",
            "486, CDLXXXVI",
            "487, CDLXXXVII",
            "488, CDLXXXVIII",
            "489, CDLXXXIX",
            "490, CDXC",
            "491, CDXCI",
            "492, CDXCII",
            "493, CDXCIII",
            "494, CDXCIV",
            "495, CDXCV",
            "496, CDXCVI",
            "497, CDXCVII",
            "498, CDXCVIII",
            "499, CDXCIX",
            "500, D",
            "501, DI",
            "502, DII",
            "503, DIII",
            "504, DIV",
            "505, DV",
            "506, DVI",
            "507, DVII",
            "508, DVIII",
            "509, DIX",
            "510, DX",
            "511, DXI",
            "512, DXII",
            "513, DXIII",
            "514, DXIV",
            "515, DXV",
            "516, DXVI",
            "517, DXVII",
            "518, DXVIII",
            "519, DXIX",
            "520, DXX",
            "521, DXXI",
            "522, DXXII",
            "523, DXXIII",
            "524, DXXIV",
            "525, DXXV",
            "526, DXXVI",
            "527, DXXVII",
            "528, DXXVIII",
            "529, DXXIX",
            "530, DXXX",
            "531, DXXXI",
            "532, DXXXII",
            "533, DXXXIII",
            "534, DXXXIV",
            "535, DXXXV",
            "536, DXXXVI",
            "537, DXXXVII",
            "538, DXXXVIII",
            "539, DXXXIX",
            "540, DXL",
            "541, DXLI",
            "542, DXLII",
            "543, DXLIII",
            "544, DXLIV",
            "545, DXLV",
            "546, DXLVI",
            "547, DXLVII",
            "548, DXLVIII",
            "549, DXLIX",
            "550, DL",
            "551, DLI",
            "552, DLII",
            "553, DLIII",
            "554, DLIV",
            "555, DLV",
            "556, DLVI",
            "557, DLVII",
            "558, DLVIII",
            "559, DLIX",
            "560, DLX",
            "561, DLXI",
            "562, DLXII",
            "563, DLXIII",
            "564, DLXIV",
            "565, DLXV",
            "566, DLXVI",
            "567, DLXVII",
            "568, DLXVIII",
            "569, DLXIX",
            "570, DLXX",
            "571, DLXXI",
            "572, DLXXII",
            "573, DLXXIII",
            "574, DLXXIV",
            "575, DLXXV",
            "576, DLXXVI",
            "577, DLXXVII",
            "578, DLXXVIII",
            "579, DLXXIX",
            "580, DLXXX",
            "581, DLXXXI",
            "582, DLXXXII",
            "583, DLXXXIII",
            "584, DLXXXIV",
            "585, DLXXXV",
            "586, DLXXXVI",
            "587, DLXXXVII",
            "588, DLXXXVIII",
            "589, DLXXXIX",
            "590, DXC",
            "591, DXCI",
            "592, DXCII",
            "593, DXCIII",
            "594, DXCIV",
            "595, DXCV",
            "596, DXCVI",
            "597, DXCVII",
            "598, DXCVIII",
            "599, DXCIX",
            "600, DC",
            "601, DCI",
            "602, DCII",
            "603, DCIII",
            "604, DCIV",
            "605, DCV",
            "606, DCVI",
            "607, DCVII",
            "608, DCVIII",
            "609, DCIX",
            "610, DCX",
            "611, DCXI",
            "612, DCXII",
            "613, DCXIII",
            "614, DCXIV",
            "615, DCXV",
            "616, DCXVI",
            "617, DCXVII",
            "618, DCXVIII",
            "619, DCXIX",
            "620, DCXX",
            "621, DCXXI",
            "622, DCXXII",
            "623, DCXXIII",
            "624, DCXXIV",
            "625, DCXXV",
            "626, DCXXVI",
            "627, DCXXVII",
            "628, DCXXVIII",
            "629, DCXXIX",
            "630, DCXXX",
            "631, DCXXXI",
            "632, DCXXXII",
            "633, DCXXXIII",
            "634, DCXXXIV",
            "635, DCXXXV",
            "636, DCXXXVI",
            "637, DCXXXVII",
            "638, DCXXXVIII",
            "639, DCXXXIX",
            "640, DCXL",
            "641, DCXLI",
            "642, DCXLII",
            "643, DCXLIII",
            "644, DCXLIV",
            "645, DCXLV",
            "646, DCXLVI",
            "647, DCXLVII",
            "648, DCXLVIII",
            "649, DCXLIX",
            "650, DCL",
            "651, DCLI",
            "652, DCLII",
            "653, DCLIII",
            "654, DCLIV",
            "655, DCLV",
            "656, DCLVI",
            "657, DCLVII",
            "658, DCLVIII",
            "659, DCLIX",
            "660, DCLX",
            "661, DCLXI",
            "662, DCLXII",
            "663, DCLXIII",
            "664, DCLXIV",
            "665, DCLXV",
            "666, DCLXVI",
            "667, DCLXVII",
            "668, DCLXVIII",
            "669, DCLXIX",
            "670, DCLXX",
            "671, DCLXXI",
            "672, DCLXXII",
            "673, DCLXXIII",
            "674, DCLXXIV",
            "675, DCLXXV",
            "676, DCLXXVI",
            "677, DCLXXVII",
            "678, DCLXXVIII",
            "679, DCLXXIX",
            "680, DCLXXX",
            "681, DCLXXXI",
            "682, DCLXXXII",
            "683, DCLXXXIII",
            "684, DCLXXXIV",
            "685, DCLXXXV",
            "686, DCLXXXVI",
            "687, DCLXXXVII",
            "688, DCLXXXVIII",
            "689, DCLXXXIX",
            "690, DCXC",
            "691, DCXCI",
            "692, DCXCII",
            "693, DCXCIII",
            "694, DCXCIV",
            "695, DCXCV",
            "696, DCXCVI",
            "697, DCXCVII",
            "698, DCXCVIII",
            "699, DCXCIX",
            "700, DCC",
            "701, DCCI",
            "702, DCCII",
            "703, DCCIII",
            "704, DCCIV",
            "705, DCCV",
            "706, DCCVI",
            "707, DCCVII",
            "708, DCCVIII",
            "709, DCCIX",
            "710, DCCX",
            "711, DCCXI",
            "712, DCCXII",
            "713, DCCXIII",
            "714, DCCXIV",
            "715, DCCXV",
            "716, DCCXVI",
            "717, DCCXVII",
            "718, DCCXVIII",
            "719, DCCXIX",
            "720, DCCXX",
            "721, DCCXXI",
            "722, DCCXXII",
            "723, DCCXXIII",
            "724, DCCXXIV",
            "725, DCCXXV",
            "726, DCCXXVI",
            "727, DCCXXVII",
            "728, DCCXXVIII",
            "729, DCCXXIX",
            "730, DCCXXX",
            "731, DCCXXXI",
            "732, DCCXXXII",
            "733, DCCXXXIII",
            "734, DCCXXXIV",
            "735, DCCXXXV",
            "736, DCCXXXVI",
            "737, DCCXXXVII",
            "738, DCCXXXVIII",
            "739, DCCXXXIX",
            "740, DCCXL",
            "741, DCCXLI",
            "742, DCCXLII",
            "743, DCCXLIII",
            "744, DCCXLIV",
            "745, DCCXLV",
            "746, DCCXLVI",
            "747, DCCXLVII",
            "748, DCCXLVIII",
            "749, DCCXLIX",
            "750, DCCL",
            "751, DCCLI",
            "752, DCCLII",
            "753, DCCLIII",
            "754, DCCLIV",
            "755, DCCLV",
            "756, DCCLVI",
            "757, DCCLVII",
            "758, DCCLVIII",
            "759, DCCLIX",
            "760, DCCLX",
            "761, DCCLXI",
            "762, DCCLXII",
            "763, DCCLXIII",
            "764, DCCLXIV",
            "765, DCCLXV",
            "766, DCCLXVI",
            "767, DCCLXVII",
            "768, DCCLXVIII",
            "769, DCCLXIX",
            "770, DCCLXX",
            "771, DCCLXXI",
            "772, DCCLXXII",
            "773, DCCLXXIII",
            "774, DCCLXXIV",
            "775, DCCLXXV",
            "776, DCCLXXVI",
            "777, DCCLXXVII",
            "778, DCCLXXVIII",
            "779, DCCLXXIX",
            "780, DCCLXXX",
            "781, DCCLXXXI",
            "782, DCCLXXXII",
            "783, DCCLXXXIII",
            "784, DCCLXXXIV",
            "785, DCCLXXXV",
            "786, DCCLXXXVI",
            "787, DCCLXXXVII",
            "788, DCCLXXXVIII",
            "789, DCCLXXXIX",
            "790, DCCXC",
            "791, DCCXCI",
            "792, DCCXCII",
            "793, DCCXCIII",
            "794, DCCXCIV",
            "795, DCCXCV",
            "796, DCCXCVI",
            "797, DCCXCVII",
            "798, DCCXCVIII",
            "799, DCCXCIX",
            "800, DCCC",
            "801, DCCCI",
            "802, DCCCII",
            "803, DCCCIII",
            "804, DCCCIV",
            "805, DCCCV",
            "806, DCCCVI",
            "807, DCCCVII",
            "808, DCCCVIII",
            "809, DCCCIX",
            "810, DCCCX",
            "811, DCCCXI",
            "812, DCCCXII",
            "813, DCCCXIII",
            "814, DCCCXIV",
            "815, DCCCXV",
            "816, DCCCXVI",
            "817, DCCCXVII",
            "818, DCCCXVIII",
            "819, DCCCXIX",
            "820, DCCCXX",
            "821, DCCCXXI",
            "822, DCCCXXII",
            "823, DCCCXXIII",
            "824, DCCCXXIV",
            "825, DCCCXXV",
            "826, DCCCXXVI",
            "827, DCCCXXVII",
            "828, DCCCXXVIII",
            "829, DCCCXXIX",
            "830, DCCCXXX",
            "831, DCCCXXXI",
            "832, DCCCXXXII",
            "833, DCCCXXXIII",
            "834, DCCCXXXIV",
            "835, DCCCXXXV",
            "836, DCCCXXXVI",
            "837, DCCCXXXVII",
            "838, DCCCXXXVIII",
            "839, DCCCXXXIX",
            "840, DCCCXL",
            "841, DCCCXLI",
            "842, DCCCXLII",
            "843, DCCCXLIII",
            "844, DCCCXLIV",
            "845, DCCCXLV",
            "846, DCCCXLVI",
            "847, DCCCXLVII",
            "848, DCCCXLVIII",
            "849, DCCCXLIX",
            "850, DCCCL",
            "851, DCCCLI",
            "852, DCCCLII",
            "853, DCCCLIII",
            "854, DCCCLIV",
            "855, DCCCLV",
            "856, DCCCLVI",
            "857, DCCCLVII",
            "858, DCCCLVIII",
            "859, DCCCLIX",
            "860, DCCCLX",
            "861, DCCCLXI",
            "862, DCCCLXII",
            "863, DCCCLXIII",
            "864, DCCCLXIV",
            "865, DCCCLXV",
            "866, DCCCLXVI",
            "867, DCCCLXVII",
            "868, DCCCLXVIII",
            "869, DCCCLXIX",
            "870, DCCCLXX",
            "871, DCCCLXXI",
            "872, DCCCLXXII",
            "873, DCCCLXXIII",
            "874, DCCCLXXIV",
            "875, DCCCLXXV",
            "876, DCCCLXXVI",
            "877, DCCCLXXVII",
            "878, DCCCLXXVIII",
            "879, DCCCLXXIX",
            "880, DCCCLXXX",
            "881, DCCCLXXXI",
            "882, DCCCLXXXII",
            "883, DCCCLXXXIII",
            "884, DCCCLXXXIV",
            "885, DCCCLXXXV",
            "886, DCCCLXXXVI",
            "887, DCCCLXXXVII",
            "888, DCCCLXXXVIII",
            "889, DCCCLXXXIX",
            "890, DCCCXC",
            "891, DCCCXCI",
            "892, DCCCXCII",
            "893, DCCCXCIII",
            "894, DCCCXCIV",
            "895, DCCCXCV",
            "896, DCCCXCVI",
            "897, DCCCXCVII",
            "898, DCCCXCVIII",
            "899, DCCCXCIX",
            "900, CM",
            "901, CMI",
            "902, CMII",
            "903, CMIII",
            "904, CMIV",
            "905, CMV",
            "906, CMVI",
            "907, CMVII",
            "908, CMVIII",
            "909, CMIX",
            "910, CMX",
            "911, CMXI",
            "912, CMXII",
            "913, CMXIII",
            "914, CMXIV",
            "915, CMXV",
            "916, CMXVI",
            "917, CMXVII",
            "918, CMXVIII",
            "919, CMXIX",
            "920, CMXX",
            "921, CMXXI",
            "922, CMXXII",
            "923, CMXXIII",
            "924, CMXXIV",
            "925, CMXXV",
            "926, CMXXVI",
            "927, CMXXVII",
            "928, CMXXVIII",
            "929, CMXXIX",
            "930, CMXXX",
            "931, CMXXXI",
            "932, CMXXXII",
            "933, CMXXXIII",
            "934, CMXXXIV",
            "935, CMXXXV",
            "936, CMXXXVI",
            "937, CMXXXVII",
            "938, CMXXXVIII",
            "939, CMXXXIX",
            "940, CMXL",
            "941, CMXLI",
            "942, CMXLII",
            "943, CMXLIII",
            "944, CMXLIV",
            "945, CMXLV",
            "946, CMXLVI",
            "947, CMXLVII",
            "948, CMXLVIII",
            "949, CMXLIX",
            "950, CML",
            "951, CMLI",
            "952, CMLII",
            "953, CMLIII",
            "954, CMLIV",
            "955, CMLV",
            "956, CMLVI",
            "957, CMLVII",
            "958, CMLVIII",
            "959, CMLIX",
            "960, CMLX",
            "961, CMLXI",
            "962, CMLXII",
            "963, CMLXIII",
            "964, CMLXIV",
            "965, CMLXV",
            "966, CMLXVI",
            "967, CMLXVII",
            "968, CMLXVIII",
            "969, CMLXIX",
            "970, CMLXX",
            "971, CMLXXI",
            "972, CMLXXII",
            "973, CMLXXIII",
            "974, CMLXXIV",
            "975, CMLXXV",
            "976, CMLXXVI",
            "977, CMLXXVII",
            "978, CMLXXVIII",
            "979, CMLXXIX",
            "980, CMLXXX",
            "981, CMLXXXI",
            "982, CMLXXXII",
            "983, CMLXXXIII",
            "984, CMLXXXIV",
            "985, CMLXXXV",
            "986, CMLXXXVI",
            "987, CMLXXXVII",
            "988, CMLXXXVIII",
            "989, CMLXXXIX",
            "990, CMXC",
            "991, CMXCI",
            "992, CMXCII",
            "993, CMXCIII",
            "994, CMXCIV",
            "995, CMXCV",
            "996, CMXCVI",
            "997, CMXCVII",
            "998, CMXCVIII",
            "999, CMXCIX",
            "1000, M",
            "1001, MI",
            "1998, MCMXCVIII",
            "2016, MMXVI"
    })
    public void itShouldConvertDecimalToRoman(int decimal, String roman) {
        assertThat(converter.convertDecimalToRoman(decimal), is(roman));
    }

}
