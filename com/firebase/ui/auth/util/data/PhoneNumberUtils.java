package com.firebase.ui.auth.util.data;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.dx.io.Opcodes;
import com.firebase.ui.auth.data.model.CountryInfo;
import com.firebase.ui.auth.data.model.PhoneNumber;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.logging.type.LogSeverity;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Marker;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class PhoneNumberUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18221a = String.valueOf(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Locale f18222b;

    /* renamed from: c  reason: collision with root package name */
    private static final CountryInfo f18223c;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseArray<List<String>> f18224d;

    /* renamed from: e  reason: collision with root package name */
    private static Map<String, Integer> f18225e;

    static {
        Locale locale = Locale.US;
        f18222b = locale;
        f18223c = new CountryInfo(locale, 1);
        f18224d = a();
    }

    private static SparseArray<List<String>> a() {
        SparseArray<List<String>> sparseArray = new SparseArray<>(Opcodes.XOR_INT_LIT16);
        sparseArray.put(1, Arrays.asList("US", "AG", "AI", "AS", "BB", "BM", "BS", "CA", "DM", "DO", "GD", "GU", "JM", "KN", "KY", "LC", "MP", "MS", "PR", "SX", "TC", "TT", "VC", "VG", "VI"));
        sparseArray.put(7, Arrays.asList("RU", "KZ"));
        sparseArray.put(20, Collections.singletonList("EG"));
        sparseArray.put(27, Collections.singletonList("ZA"));
        sparseArray.put(30, Collections.singletonList("GR"));
        sparseArray.put(31, Collections.singletonList("NL"));
        sparseArray.put(32, Collections.singletonList("BE"));
        sparseArray.put(33, Collections.singletonList("FR"));
        sparseArray.put(34, Collections.singletonList("ES"));
        sparseArray.put(36, Collections.singletonList("HU"));
        sparseArray.put(39, Collections.singletonList("IT"));
        sparseArray.put(40, Collections.singletonList("RO"));
        sparseArray.put(41, Collections.singletonList("CH"));
        sparseArray.put(43, Collections.singletonList("AT"));
        sparseArray.put(44, Arrays.asList("GB", "GG", "IM", "JE"));
        sparseArray.put(45, Collections.singletonList("DK"));
        sparseArray.put(46, Collections.singletonList("SE"));
        sparseArray.put(47, Arrays.asList("NO", "SJ"));
        sparseArray.put(48, Collections.singletonList("PL"));
        sparseArray.put(49, Collections.singletonList("DE"));
        sparseArray.put(51, Collections.singletonList("PE"));
        sparseArray.put(52, Collections.singletonList("MX"));
        sparseArray.put(53, Collections.singletonList("CU"));
        sparseArray.put(54, Collections.singletonList("AR"));
        sparseArray.put(55, Collections.singletonList("BR"));
        sparseArray.put(56, Collections.singletonList("CL"));
        sparseArray.put(57, Collections.singletonList("CO"));
        sparseArray.put(58, Collections.singletonList("VE"));
        sparseArray.put(60, Collections.singletonList("MY"));
        sparseArray.put(61, Arrays.asList("AU", "CC", "CX"));
        sparseArray.put(62, Collections.singletonList("ID"));
        sparseArray.put(63, Collections.singletonList("PH"));
        sparseArray.put(64, Collections.singletonList("NZ"));
        sparseArray.put(65, Collections.singletonList("SG"));
        sparseArray.put(66, Collections.singletonList("TH"));
        sparseArray.put(81, Collections.singletonList("JP"));
        sparseArray.put(82, Collections.singletonList("KR"));
        sparseArray.put(84, Collections.singletonList("VN"));
        sparseArray.put(86, Collections.singletonList("CN"));
        sparseArray.put(90, Collections.singletonList("TR"));
        sparseArray.put(91, Collections.singletonList("IN"));
        sparseArray.put(92, Collections.singletonList("PK"));
        sparseArray.put(93, Collections.singletonList("AF"));
        sparseArray.put(94, Collections.singletonList("LK"));
        sparseArray.put(95, Collections.singletonList("MM"));
        sparseArray.put(98, Collections.singletonList("IR"));
        sparseArray.put(Opcodes.DIV_INT_LIT16, Collections.singletonList("SS"));
        sparseArray.put(Opcodes.REM_INT_LIT16, Arrays.asList(RequestConfiguration.MAX_AD_CONTENT_RATING_MA, "EH"));
        sparseArray.put(213, Collections.singletonList("DZ"));
        sparseArray.put(Opcodes.ADD_INT_LIT8, Collections.singletonList("TN"));
        sparseArray.put(Opcodes.MUL_INT_LIT8, Collections.singletonList("LY"));
        sparseArray.put(Opcodes.REM_INT_LIT8, Collections.singletonList("GM"));
        sparseArray.put(221, Collections.singletonList("SN"));
        sparseArray.put(222, Collections.singletonList("MR"));
        sparseArray.put(Opcodes.XOR_INT_LIT8, Collections.singletonList("ML"));
        sparseArray.put(Opcodes.SHL_INT_LIT8, Collections.singletonList("GN"));
        sparseArray.put(Opcodes.SHR_INT_LIT8, Collections.singletonList("CI"));
        sparseArray.put(Opcodes.USHR_INT_LIT8, Collections.singletonList("BF"));
        sparseArray.put(227, Collections.singletonList("NE"));
        sparseArray.put(228, Collections.singletonList("TG"));
        sparseArray.put(229, Collections.singletonList("BJ"));
        sparseArray.put(230, Collections.singletonList("MU"));
        sparseArray.put(231, Collections.singletonList("LR"));
        sparseArray.put(232, Collections.singletonList("SL"));
        sparseArray.put(233, Collections.singletonList("GH"));
        sparseArray.put(234, Collections.singletonList("NG"));
        sparseArray.put(235, Collections.singletonList("TD"));
        sparseArray.put(236, Collections.singletonList("CF"));
        sparseArray.put(237, Collections.singletonList("CM"));
        sparseArray.put(238, Collections.singletonList("CV"));
        sparseArray.put(239, Collections.singletonList("ST"));
        sparseArray.put(240, Collections.singletonList("GQ"));
        sparseArray.put(241, Collections.singletonList("GA"));
        sparseArray.put(242, Collections.singletonList("CG"));
        sparseArray.put(243, Collections.singletonList("CD"));
        sparseArray.put(244, Collections.singletonList("AO"));
        sparseArray.put(245, Collections.singletonList("GW"));
        sparseArray.put(246, Collections.singletonList("IO"));
        sparseArray.put(247, Collections.singletonList("AC"));
        sparseArray.put(248, Collections.singletonList("SC"));
        sparseArray.put(249, Collections.singletonList("SD"));
        sparseArray.put(250, Collections.singletonList("RW"));
        sparseArray.put(251, Collections.singletonList("ET"));
        sparseArray.put(252, Collections.singletonList("SO"));
        sparseArray.put(253, Collections.singletonList("DJ"));
        sparseArray.put(254, Collections.singletonList("KE"));
        sparseArray.put(255, Collections.singletonList("TZ"));
        sparseArray.put(256, Collections.singletonList("UG"));
        sparseArray.put(257, Collections.singletonList("BI"));
        sparseArray.put(258, Collections.singletonList("MZ"));
        sparseArray.put(260, Collections.singletonList("ZM"));
        sparseArray.put(261, Collections.singletonList("MG"));
        sparseArray.put(262, Arrays.asList("RE", "YT"));
        sparseArray.put(263, Collections.singletonList("ZW"));
        sparseArray.put(264, Collections.singletonList("NA"));
        sparseArray.put(265, Collections.singletonList("MW"));
        sparseArray.put(266, Collections.singletonList("LS"));
        sparseArray.put(267, Collections.singletonList("BW"));
        sparseArray.put(268, Collections.singletonList("SZ"));
        sparseArray.put(269, Collections.singletonList("KM"));
        sparseArray.put(290, Arrays.asList("SH", "TA"));
        sparseArray.put(291, Collections.singletonList("ER"));
        sparseArray.put(297, Collections.singletonList("AW"));
        sparseArray.put(298, Collections.singletonList("FO"));
        sparseArray.put(299, Collections.singletonList("GL"));
        sparseArray.put(350, Collections.singletonList("GI"));
        sparseArray.put(351, Collections.singletonList("PT"));
        sparseArray.put(352, Collections.singletonList("LU"));
        sparseArray.put(353, Collections.singletonList("IE"));
        sparseArray.put(354, Collections.singletonList("IS"));
        sparseArray.put(355, Collections.singletonList("AL"));
        sparseArray.put(356, Collections.singletonList("MT"));
        sparseArray.put(357, Collections.singletonList("CY"));
        sparseArray.put(358, Arrays.asList("FI", "AX"));
        sparseArray.put(359, Collections.singletonList("BG"));
        sparseArray.put(370, Collections.singletonList("LT"));
        sparseArray.put(371, Collections.singletonList("LV"));
        sparseArray.put(372, Collections.singletonList("EE"));
        sparseArray.put(373, Collections.singletonList("MD"));
        sparseArray.put(374, Collections.singletonList("AM"));
        sparseArray.put(375, Collections.singletonList("BY"));
        sparseArray.put(376, Collections.singletonList("AD"));
        sparseArray.put(377, Collections.singletonList("MC"));
        sparseArray.put(378, Collections.singletonList("SM"));
        sparseArray.put(379, Collections.singletonList("VA"));
        sparseArray.put(380, Collections.singletonList("UA"));
        sparseArray.put(381, Collections.singletonList("RS"));
        sparseArray.put(382, Collections.singletonList("ME"));
        sparseArray.put(383, Collections.singletonList("XK"));
        sparseArray.put(385, Collections.singletonList("HR"));
        sparseArray.put(386, Collections.singletonList("SI"));
        sparseArray.put(387, Collections.singletonList("BA"));
        sparseArray.put(389, Collections.singletonList("MK"));
        sparseArray.put(420, Collections.singletonList("CZ"));
        sparseArray.put(421, Collections.singletonList("SK"));
        sparseArray.put(423, Collections.singletonList("LI"));
        sparseArray.put(500, Collections.singletonList("FK"));
        sparseArray.put(501, Collections.singletonList("BZ"));
        sparseArray.put(502, Collections.singletonList("GT"));
        sparseArray.put(503, Collections.singletonList("SV"));
        sparseArray.put(504, Collections.singletonList("HN"));
        sparseArray.put(505, Collections.singletonList("NI"));
        sparseArray.put(TypedValues.PositionType.TYPE_PERCENT_X, Collections.singletonList("CR"));
        sparseArray.put(507, Collections.singletonList("PA"));
        sparseArray.put(TypedValues.PositionType.TYPE_CURVE_FIT, Collections.singletonList("PM"));
        sparseArray.put(509, Collections.singletonList("HT"));
        sparseArray.put(590, Arrays.asList("GP", "BL", "MF"));
        sparseArray.put(591, Collections.singletonList("BO"));
        sparseArray.put(592, Collections.singletonList("GY"));
        sparseArray.put(593, Collections.singletonList(KeyPropertiesCompact.KEY_ALGORITHM_EC));
        sparseArray.put(594, Collections.singletonList("GF"));
        sparseArray.put(595, Collections.singletonList("PY"));
        sparseArray.put(596, Collections.singletonList("MQ"));
        sparseArray.put(597, Collections.singletonList("SR"));
        sparseArray.put(598, Collections.singletonList("UY"));
        sparseArray.put(599, Arrays.asList("CW", "BQ"));
        sparseArray.put(670, Collections.singletonList("TL"));
        sparseArray.put(672, Collections.singletonList("NF"));
        sparseArray.put(673, Collections.singletonList("BN"));
        sparseArray.put(674, Collections.singletonList("NR"));
        sparseArray.put(675, Collections.singletonList(RequestConfiguration.MAX_AD_CONTENT_RATING_PG));
        sparseArray.put(676, Collections.singletonList("TO"));
        sparseArray.put(677, Collections.singletonList("SB"));
        sparseArray.put(678, Collections.singletonList("VU"));
        sparseArray.put(679, Collections.singletonList("FJ"));
        sparseArray.put(680, Collections.singletonList("PW"));
        sparseArray.put(681, Collections.singletonList("WF"));
        sparseArray.put(682, Collections.singletonList("CK"));
        sparseArray.put(683, Collections.singletonList("NU"));
        sparseArray.put(685, Collections.singletonList("WS"));
        sparseArray.put(686, Collections.singletonList("KI"));
        sparseArray.put(687, Collections.singletonList("NC"));
        sparseArray.put(688, Collections.singletonList("TV"));
        sparseArray.put(689, Collections.singletonList("PF"));
        sparseArray.put(690, Collections.singletonList("TK"));
        sparseArray.put(691, Collections.singletonList("FM"));
        sparseArray.put(692, Collections.singletonList("MH"));
        sparseArray.put(LogSeverity.EMERGENCY_VALUE, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(808, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(850, Collections.singletonList("KP"));
        sparseArray.put(852, Collections.singletonList("HK"));
        sparseArray.put(853, Collections.singletonList("MO"));
        sparseArray.put(855, Collections.singletonList("KH"));
        sparseArray.put(856, Collections.singletonList("LA"));
        sparseArray.put(870, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(878, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(880, Collections.singletonList("BD"));
        sparseArray.put(881, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(882, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(883, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(886, Collections.singletonList("TW"));
        sparseArray.put(888, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(960, Collections.singletonList("MV"));
        sparseArray.put(961, Collections.singletonList("LB"));
        sparseArray.put(962, Collections.singletonList("JO"));
        sparseArray.put(963, Collections.singletonList("SY"));
        sparseArray.put(964, Collections.singletonList("IQ"));
        sparseArray.put(965, Collections.singletonList("KW"));
        sparseArray.put(966, Collections.singletonList("SA"));
        sparseArray.put(967, Collections.singletonList("YE"));
        sparseArray.put(968, Collections.singletonList("OM"));
        sparseArray.put(970, Collections.singletonList("PS"));
        sparseArray.put(971, Collections.singletonList("AE"));
        sparseArray.put(972, Collections.singletonList("IL"));
        sparseArray.put(973, Collections.singletonList("BH"));
        sparseArray.put(974, Collections.singletonList("QA"));
        sparseArray.put(975, Collections.singletonList("BT"));
        sparseArray.put(976, Collections.singletonList("MN"));
        sparseArray.put(977, Collections.singletonList("NP"));
        sparseArray.put(979, Collections.singletonList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY));
        sparseArray.put(992, Collections.singletonList("TJ"));
        sparseArray.put(993, Collections.singletonList("TM"));
        sparseArray.put(994, Collections.singletonList("AZ"));
        sparseArray.put(995, Collections.singletonList("GE"));
        sparseArray.put(996, Collections.singletonList("KG"));
        sparseArray.put(998, Collections.singletonList("UZ"));
        return sparseArray;
    }

    @Nullable
    private static String b(String str) {
        String replaceFirst = str.replaceFirst("^\\+", "");
        int length = replaceFirst.length();
        for (int i4 = 1; i4 <= 3 && i4 <= length; i4++) {
            String substring = replaceFirst.substring(0, i4);
            if (f18224d.indexOfKey(Integer.valueOf(substring).intValue()) >= 0) {
                return substring;
            }
        }
        return null;
    }

    @NonNull
    private static String c(String str) {
        String b4 = b(str);
        if (b4 == null) {
            return f18221a;
        }
        return b4;
    }

    private static String d(String str) {
        List<String> list = f18224d.get(Integer.parseInt(str));
        if (list != null) {
            return list.get(0);
        }
        return f18222b.getCountry();
    }

    private static Locale e() {
        return Locale.getDefault();
    }

    private static Locale f(@NonNull Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getSimCountryIso();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Locale("", str);
    }

    public static String format(@NonNull String str, @NonNull CountryInfo countryInfo) {
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            return str;
        }
        return Marker.ANY_NON_NULL_MARKER + String.valueOf(countryInfo.getCountryCode()) + str.replaceAll("[^\\d.]", "");
    }

    @Nullable
    public static String formatUsingCurrentCountry(@NonNull String str, Context context) {
        return format(str, getCurrentCountryInfo(context));
    }

    private static void g() {
        HashMap hashMap = new HashMap(248);
        int i4 = 0;
        while (true) {
            SparseArray<List<String>> sparseArray = f18224d;
            if (i4 < sparseArray.size()) {
                int keyAt = sparseArray.keyAt(i4);
                for (String str : sparseArray.get(keyAt)) {
                    if (!str.equals(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY)) {
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, Integer.valueOf(keyAt));
                        } else {
                            throw new IllegalStateException("Duplicate regions for country code: " + keyAt);
                        }
                    }
                }
                i4++;
            } else {
                hashMap.remove("TA");
                hashMap.put("HM", 672);
                hashMap.put("GS", 500);
                f18225e = Collections.unmodifiableMap(hashMap);
                return;
            }
        }
    }

    @Nullable
    public static Integer getCountryCode(String str) {
        if (f18225e == null) {
            g();
        }
        if (str == null) {
            return null;
        }
        return f18225e.get(str.toUpperCase(Locale.getDefault()));
    }

    @Nullable
    public static List<String> getCountryIsosFromCountryCode(String str) {
        if (!isValid(str)) {
            return null;
        }
        return f18224d.get(Integer.parseInt(str.substring(1)));
    }

    @NonNull
    public static CountryInfo getCurrentCountryInfo(@NonNull Context context) {
        Locale f4 = f(context);
        if (f4 == null) {
            f4 = e();
        }
        if (f4 == null) {
            return f18223c;
        }
        Integer countryCode = getCountryCode(f4.getCountry());
        if (countryCode == null) {
            return f18223c;
        }
        return new CountryInfo(f4, countryCode.intValue());
    }

    public static Map<String, Integer> getImmutableCountryIsoMap() {
        if (f18225e == null) {
            g();
        }
        return f18225e;
    }

    public static PhoneNumber getPhoneNumber(@NonNull String str) {
        String str2 = f18221a;
        String country = f18222b.getCountry();
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str2 = c(str);
            country = d(str2);
            str = h(str, str2);
        }
        return new PhoneNumber(str, country, str2);
    }

    private static String h(String str, String str2) {
        return str.replaceFirst("^\\+?" + str2, "");
    }

    private static String i(String str) {
        return str.replaceFirst("^\\+?", "");
    }

    public static boolean isValid(@NonNull String str) {
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER) && b(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean isValidIso(@Nullable String str) {
        if (getCountryCode(str) != null) {
            return true;
        }
        return false;
    }

    public static PhoneNumber getPhoneNumber(@NonNull String str, @NonNull String str2) {
        int countryCode = getCountryCode(str);
        if (countryCode == null) {
            countryCode = 1;
            str = f18221a;
        }
        return new PhoneNumber(i(str2), str, String.valueOf(countryCode));
    }
}
