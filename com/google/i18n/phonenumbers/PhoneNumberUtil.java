package com.google.i18n.phonenumbers;

import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberMatcher;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.anko.DimensionsKt;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class PhoneNumberUtil {
    private static final Pattern A;
    private static final Pattern B;
    static final Pattern C;
    private static final Pattern D;
    private static final Pattern E;
    private static final Pattern F;
    private static final Pattern G;
    private static final Pattern H;
    private static PhoneNumberUtil I = null;
    public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f32846g = Logger.getLogger(PhoneNumberUtil.class.getName());

    /* renamed from: h  reason: collision with root package name */
    private static final Map<Integer, String> f32847h;

    /* renamed from: i  reason: collision with root package name */
    private static final Set<Integer> f32848i;

    /* renamed from: j  reason: collision with root package name */
    private static final Set<Integer> f32849j;

    /* renamed from: k  reason: collision with root package name */
    private static final Map<Character, Character> f32850k;

    /* renamed from: l  reason: collision with root package name */
    private static final Map<Character, Character> f32851l;

    /* renamed from: m  reason: collision with root package name */
    private static final Map<Character, Character> f32852m;

    /* renamed from: n  reason: collision with root package name */
    private static final Map<Character, Character> f32853n;

    /* renamed from: o  reason: collision with root package name */
    private static final Pattern f32854o;

    /* renamed from: p  reason: collision with root package name */
    private static final String f32855p;

    /* renamed from: q  reason: collision with root package name */
    static final Pattern f32856q;

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f32857r;

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f32858s;

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f32859t;

    /* renamed from: u  reason: collision with root package name */
    static final Pattern f32860u;

    /* renamed from: v  reason: collision with root package name */
    static final Pattern f32861v;

    /* renamed from: w  reason: collision with root package name */
    private static final Pattern f32862w;

    /* renamed from: x  reason: collision with root package name */
    private static final String f32863x;

    /* renamed from: y  reason: collision with root package name */
    private static final String f32864y;

    /* renamed from: z  reason: collision with root package name */
    static final String f32865z;

    /* renamed from: a  reason: collision with root package name */
    private final MetadataSource f32866a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, List<String>> f32867b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f32868c = new HashSet(35);

    /* renamed from: d  reason: collision with root package name */
    private final RegexCache f32869d = new RegexCache(100);

    /* renamed from: e  reason: collision with root package name */
    private final Set<String> f32870e = new HashSet((int) DimensionsKt.XHDPI);

    /* renamed from: f  reason: collision with root package name */
    private final Set<Integer> f32871f = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32877a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f32878b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f32879c;

        static {
            int[] iArr = new int[PhoneNumberType.values().length];
            f32879c = iArr;
            try {
                iArr[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32879c[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32879c[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32879c[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32879c[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32879c[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32879c[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32879c[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32879c[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32879c[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f32879c[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[PhoneNumberFormat.values().length];
            f32878b = iArr2;
            try {
                iArr2[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f32878b[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f32878b[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f32878b[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[Phonenumber.PhoneNumber.CountryCodeSource.values().length];
            f32877a = iArr3;
            try {
                iArr3[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f32877a[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f32877a[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f32877a[Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Leniency {
        POSSIBLE { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.1
            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            boolean a(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                return phoneNumberUtil.isPossibleNumber(phoneNumber);
            }
        },
        VALID { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.2
            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            boolean a(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                if (phoneNumberUtil.isValidNumber(phoneNumber) && PhoneNumberMatcher.e(phoneNumber, str, phoneNumberUtil)) {
                    return PhoneNumberMatcher.l(phoneNumber, phoneNumberUtil);
                }
                return false;
            }
        },
        STRICT_GROUPING { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.3
            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            boolean a(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                if (phoneNumberUtil.isValidNumber(phoneNumber) && PhoneNumberMatcher.e(phoneNumber, str, phoneNumberUtil) && !PhoneNumberMatcher.d(phoneNumber, str) && PhoneNumberMatcher.l(phoneNumber, phoneNumberUtil)) {
                    return PhoneNumberMatcher.c(phoneNumber, str, phoneNumberUtil, new PhoneNumberMatcher.NumberGroupingChecker() { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.3.1
                        @Override // com.google.i18n.phonenumbers.PhoneNumberMatcher.NumberGroupingChecker
                        public boolean a(PhoneNumberUtil phoneNumberUtil2, Phonenumber.PhoneNumber phoneNumber2, StringBuilder sb, String[] strArr) {
                            return PhoneNumberMatcher.b(phoneNumberUtil2, phoneNumber2, sb, strArr);
                        }
                    });
                }
                return false;
            }
        },
        EXACT_GROUPING { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.4
            @Override // com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency
            boolean a(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                if (phoneNumberUtil.isValidNumber(phoneNumber) && PhoneNumberMatcher.e(phoneNumber, str, phoneNumberUtil) && !PhoneNumberMatcher.d(phoneNumber, str) && PhoneNumberMatcher.l(phoneNumber, phoneNumberUtil)) {
                    return PhoneNumberMatcher.c(phoneNumber, str, phoneNumberUtil, new PhoneNumberMatcher.NumberGroupingChecker() { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency.4.1
                        @Override // com.google.i18n.phonenumbers.PhoneNumberMatcher.NumberGroupingChecker
                        public boolean a(PhoneNumberUtil phoneNumberUtil2, Phonenumber.PhoneNumber phoneNumber2, StringBuilder sb, String[] strArr) {
                            return PhoneNumberMatcher.a(phoneNumberUtil2, phoneNumber2, sb, strArr);
                        }
                    });
                }
                return false;
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean a(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil);
    }

    /* loaded from: classes5.dex */
    public enum MatchType {
        NOT_A_NUMBER,
        NO_MATCH,
        SHORT_NSN_MATCH,
        NSN_MATCH,
        EXACT_MATCH
    }

    /* loaded from: classes5.dex */
    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    /* loaded from: classes5.dex */
    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    /* loaded from: classes5.dex */
    public enum ValidationResult {
        IS_POSSIBLE,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(52, "1");
        hashMap.put(54, "9");
        f32847h = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        f32848i = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        f32849j = Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        Map<Character, Character> unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        f32851l = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        f32852m = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        Character valueOf = Character.valueOf(SignatureVisitor.EXTENDS);
        hashMap5.put(valueOf, valueOf);
        Character valueOf2 = Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        hashMap5.put(valueOf2, valueOf2);
        hashMap5.put('#', '#');
        f32850k = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character ch : unmodifiableMap.keySet()) {
            char charValue = ch.charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue)), Character.valueOf(charValue));
            hashMap6.put(Character.valueOf(charValue), Character.valueOf(charValue));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put(Character.valueOf(SignatureVisitor.SUPER), Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put((char) 65293, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put((char) 8208, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put((char) 8209, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put((char) 8210, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(Character.valueOf(Typography.ndash), Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put(Character.valueOf(Typography.mdash), Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put((char) 8213, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put((char) 8722, Character.valueOf(SignatureVisitor.SUPER));
        hashMap6.put('/', '/');
        hashMap6.put((char) 65295, '/');
        hashMap6.put(' ', ' ');
        hashMap6.put((char) 12288, ' ');
        hashMap6.put((char) 8288, ' ');
        hashMap6.put('.', '.');
        hashMap6.put((char) 65294, '.');
        f32853n = Collections.unmodifiableMap(hashMap6);
        f32854o = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = f32851l;
        sb.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String sb2 = sb.toString();
        f32855p = sb2;
        f32856q = Pattern.compile("[+＋]+");
        f32857r = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        f32858s = Pattern.compile("(\\p{Nd})");
        f32859t = Pattern.compile("[+＋\\p{Nd}]");
        f32860u = Pattern.compile("[\\\\/] *x");
        f32861v = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        f32862w = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + sb2 + "\\p{Nd}]*";
        f32863x = str;
        String e4 = e(",;xｘ#＃~～");
        f32864y = e4;
        f32865z = e("xｘ#＃~～");
        A = Pattern.compile("(?:" + e4 + ")$", 66);
        B = Pattern.compile(str + "(?:" + e4 + ")?", 66);
        C = Pattern.compile("(\\D+)");
        D = Pattern.compile("(\\$\\d)");
        E = Pattern.compile("\\$NP");
        F = Pattern.compile("\\$FG");
        G = Pattern.compile("\\$CC");
        H = Pattern.compile("\\(?\\$1\\)?");
        I = null;
    }

    PhoneNumberUtil(MetadataSource metadataSource, Map<Integer, List<String>> map) {
        this.f32866a = metadataSource;
        this.f32867b = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && REGION_CODE_FOR_NON_GEO_ENTITY.equals(value.get(0))) {
                this.f32871f.add(entry.getKey());
            } else {
                this.f32870e.addAll(value);
            }
        }
        if (this.f32870e.remove(REGION_CODE_FOR_NON_GEO_ENTITY)) {
            f32846g.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f32868c.addAll(map.get(1));
    }

    private boolean A(String str) {
        if (str != null && this.f32870e.contains(str)) {
            return true;
        }
        return false;
    }

    static boolean B(String str) {
        if (str.length() < 2) {
            return false;
        }
        return B.matcher(str).matches();
    }

    private void C(Phonenumber.PhoneNumber phoneNumber, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        if (phoneNumber.hasExtension() && phoneNumber.getExtension().length() > 0) {
            if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                sb.append(";ext=");
                sb.append(phoneNumber.getExtension());
            } else if (phoneMetadata.hasPreferredExtnPrefix()) {
                sb.append(phoneMetadata.getPreferredExtnPrefix());
                sb.append(phoneNumber.getExtension());
            } else {
                sb.append(" ext. ");
                sb.append(phoneNumber.getExtension());
            }
        }
    }

    static String H(String str) {
        if (f32862w.matcher(str).matches()) {
            return K(str, f32852m, true);
        }
        return normalizeDigitsOnly(str);
    }

    static void I(StringBuilder sb) {
        sb.replace(0, sb.length(), H(sb.toString()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder J(String str, boolean z3) {
        char[] charArray;
        StringBuilder sb = new StringBuilder(str.length());
        for (char c4 : str.toCharArray()) {
            int digit = Character.digit(c4, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z3) {
                sb.append(c4);
            }
        }
        return sb;
    }

    private static String K(String str, Map<Character, Character> map, boolean z3) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            Character ch = map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z3) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private void L(String str, String str2, boolean z3, boolean z4, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        int D2;
        if (str != null) {
            if (str.length() <= 250) {
                StringBuilder sb = new StringBuilder();
                a(str, sb);
                if (B(sb.toString())) {
                    if (z4 && !c(sb.toString(), str2)) {
                        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
                    }
                    if (z3) {
                        phoneNumber.setRawInput(str);
                    }
                    String E2 = E(sb);
                    if (E2.length() > 0) {
                        phoneNumber.setExtension(E2);
                    }
                    Phonemetadata.PhoneMetadata p4 = p(str2);
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        D2 = D(sb.toString(), p4, sb2, z3, phoneNumber);
                    } catch (NumberParseException e4) {
                        Matcher matcher = f32856q.matcher(sb.toString());
                        NumberParseException.ErrorType errorType = e4.getErrorType();
                        NumberParseException.ErrorType errorType2 = NumberParseException.ErrorType.INVALID_COUNTRY_CODE;
                        if (errorType == errorType2 && matcher.lookingAt()) {
                            D2 = D(sb.substring(matcher.end()), p4, sb2, z3, phoneNumber);
                            if (D2 == 0) {
                                throw new NumberParseException(errorType2, "Could not interpret numbers after plus-sign.");
                            }
                        } else {
                            throw new NumberParseException(e4.getErrorType(), e4.getMessage());
                        }
                    }
                    if (D2 != 0) {
                        String regionCodeForCountryCode = getRegionCodeForCountryCode(D2);
                        if (!regionCodeForCountryCode.equals(str2)) {
                            p4 = q(D2, regionCodeForCountryCode);
                        }
                    } else {
                        I(sb);
                        sb2.append((CharSequence) sb);
                        if (str2 != null) {
                            phoneNumber.setCountryCode(p4.getCountryCode());
                        } else if (z3) {
                            phoneNumber.clearCountryCodeSource();
                        }
                    }
                    if (sb2.length() >= 2) {
                        if (p4 != null) {
                            StringBuilder sb3 = new StringBuilder();
                            StringBuilder sb4 = new StringBuilder(sb2);
                            G(sb4, p4, sb3);
                            if (R(sb4.toString(), p4.getGeneralDesc()) != ValidationResult.TOO_SHORT) {
                                if (z3 && sb3.length() > 0) {
                                    phoneNumber.setPreferredDomesticCarrierCode(sb3.toString());
                                }
                                sb2 = sb4;
                            }
                        }
                        int length = sb2.length();
                        if (length >= 2) {
                            if (length <= 17) {
                                Q(sb2.toString(), phoneNumber);
                                phoneNumber.setNationalNumber(Long.parseLong(sb2.toString()));
                                return;
                            }
                            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                        }
                        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                    }
                    throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            }
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
    }

    private boolean M(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = f32858s.matcher(sb.substring(end));
        if (matcher2.find() && normalizeDigitsOnly(matcher2.group(1)).equals("0")) {
            return false;
        }
        sb.delete(0, end);
        return true;
    }

    private void N(int i4, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        int i5 = AnonymousClass2.f32878b[phoneNumberFormat.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    return;
                }
                sb.insert(0, "-").insert(0, i4).insert(0, SignatureVisitor.EXTENDS).insert(0, "tel:");
                return;
            }
            sb.insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, i4).insert(0, SignatureVisitor.EXTENDS);
            return;
        }
        sb.insert(0, i4).insert(0, SignatureVisitor.EXTENDS);
    }

    private boolean O(String str, String str2, String str3) {
        String normalizeDigitsOnly = normalizeDigitsOnly(str);
        if (normalizeDigitsOnly.startsWith(str2)) {
            try {
                return isValidNumber(parse(normalizeDigitsOnly.substring(str2.length()), str3));
            } catch (NumberParseException unused) {
            }
        }
        return false;
    }

    static synchronized void P(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            I = phoneNumberUtil;
        }
    }

    static void Q(String str, Phonenumber.PhoneNumber phoneNumber) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            phoneNumber.setItalianLeadingZero(true);
            int i4 = 1;
            while (i4 < str.length() - 1 && str.charAt(i4) == '0') {
                i4++;
            }
            if (i4 != 1) {
                phoneNumber.setNumberOfLeadingZeros(i4);
            }
        }
    }

    private ValidationResult R(String str, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        List<Integer> possibleLengthList = phoneNumberDesc.getPossibleLengthList();
        List<Integer> possibleLengthLocalOnlyList = phoneNumberDesc.getPossibleLengthLocalOnlyList();
        int length = str.length();
        if (possibleLengthLocalOnlyList.contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE;
        }
        int intValue = possibleLengthList.get(0).intValue();
        if (intValue == length) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (intValue > length) {
            return ValidationResult.TOO_SHORT;
        }
        if (possibleLengthList.get(possibleLengthList.size() - 1).intValue() < length) {
            return ValidationResult.TOO_LONG;
        }
        if (possibleLengthList.subList(1, possibleLengthList.size()).contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE;
        }
        return ValidationResult.TOO_LONG;
    }

    private void a(String str, StringBuilder sb) {
        int i4;
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf > 0) {
            int i5 = indexOf + 15;
            if (str.charAt(i5) == '+') {
                int indexOf2 = str.indexOf(59, i5);
                if (indexOf2 > 0) {
                    sb.append(str.substring(i5, indexOf2));
                } else {
                    sb.append(str.substring(i5));
                }
            }
            int indexOf3 = str.indexOf("tel:");
            if (indexOf3 >= 0) {
                i4 = indexOf3 + 4;
            } else {
                i4 = 0;
            }
            sb.append(str.substring(i4, indexOf));
        } else {
            sb.append(h(str));
        }
        int indexOf4 = sb.indexOf(";isub=");
        if (indexOf4 > 0) {
            sb.delete(indexOf4, sb.length());
        }
    }

    private boolean c(String str, String str2) {
        if (!A(str2)) {
            if (str == null || str.length() == 0 || !f32856q.matcher(str).lookingAt()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static String convertAlphaCharactersInNumber(String str) {
        return K(str, f32852m, false);
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader != null) {
            return f(new MultiFileMetadataSourceImpl(metadataLoader));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static String e(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[" + str + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    private static PhoneNumberUtil f(MetadataSource metadataSource) {
        if (metadataSource != null) {
            return new PhoneNumberUtil(metadataSource, CountryCodeToRegionCodeMap.a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public static String getCountryMobileToken(int i4) {
        Map<Integer, String> map = f32847h;
        if (map.containsKey(Integer.valueOf(i4))) {
            return map.get(Integer.valueOf(i4));
        }
        return "";
    }

    public static synchronized PhoneNumberUtil getInstance() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            if (I == null) {
                P(createInstance(MetadataManager.f32810a));
            }
            phoneNumberUtil = I;
        }
        return phoneNumberUtil;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(String str) {
        Matcher matcher = f32859t.matcher(str);
        if (matcher.find()) {
            String substring = str.substring(matcher.start());
            Matcher matcher2 = f32861v.matcher(substring);
            if (matcher2.find()) {
                substring = substring.substring(0, matcher2.start());
                Logger logger = f32846g;
                Level level = Level.FINER;
                logger.log(level, "Stripped trailing characters: " + substring);
            }
            Matcher matcher3 = f32860u.matcher(substring);
            if (matcher3.find()) {
                return substring.substring(0, matcher3.start());
            }
            return substring;
        }
        return "";
    }

    private String i(String str, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return j(str, phoneMetadata, phoneNumberFormat, null);
    }

    private String j(String str, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, String str2) {
        List<Phonemetadata.NumberFormat> numberFormats;
        if (phoneMetadata.intlNumberFormats().size() != 0 && phoneNumberFormat != PhoneNumberFormat.NATIONAL) {
            numberFormats = phoneMetadata.intlNumberFormats();
        } else {
            numberFormats = phoneMetadata.numberFormats();
        }
        Phonemetadata.NumberFormat d4 = d(numberFormats, str);
        if (d4 != null) {
            return l(str, d4, phoneNumberFormat, str2);
        }
        return str;
    }

    private String l(String str, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat, String str2) {
        String replaceAll;
        String format = numberFormat.getFormat();
        Matcher matcher = this.f32869d.getPatternForRegex(numberFormat.getPattern()).matcher(str);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.NATIONAL;
        if (phoneNumberFormat == phoneNumberFormat2 && str2 != null && str2.length() > 0 && numberFormat.getDomesticCarrierCodeFormattingRule().length() > 0) {
            replaceAll = matcher.replaceAll(D.matcher(format).replaceFirst(G.matcher(numberFormat.getDomesticCarrierCodeFormattingRule()).replaceFirst(str2)));
        } else {
            String nationalPrefixFormattingRule = numberFormat.getNationalPrefixFormattingRule();
            if (phoneNumberFormat == phoneNumberFormat2 && nationalPrefixFormattingRule != null && nationalPrefixFormattingRule.length() > 0) {
                replaceAll = matcher.replaceAll(D.matcher(format).replaceFirst(nationalPrefixFormattingRule));
            } else {
                replaceAll = matcher.replaceAll(format);
            }
        }
        if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
            Matcher matcher2 = f32857r.matcher(replaceAll);
            if (matcher2.lookingAt()) {
                replaceAll = matcher2.replaceFirst("");
            }
            return matcher2.reset(replaceAll).replaceAll("-");
        }
        return replaceAll;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(String str) {
        if (str.length() != 0 && !H.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    private int n(String str) {
        Phonemetadata.PhoneMetadata p4 = p(str);
        if (p4 != null) {
            return p4.getCountryCode();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    public static String normalizeDiallableCharsOnly(String str) {
        return K(str, f32850k, true);
    }

    public static String normalizeDigitsOnly(String str) {
        return J(str, false).toString();
    }

    private Phonemetadata.PhoneMetadata q(int i4, String str) {
        if (REGION_CODE_FOR_NON_GEO_ENTITY.equals(str)) {
            return o(i4);
        }
        return p(str);
    }

    private PhoneNumberType s(String str, Phonemetadata.PhoneMetadata phoneMetadata) {
        if (!z(str, phoneMetadata.getGeneralDesc())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (z(str, phoneMetadata.getPremiumRate())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (z(str, phoneMetadata.getTollFree())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (z(str, phoneMetadata.getSharedCost())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (z(str, phoneMetadata.getVoip())) {
            return PhoneNumberType.VOIP;
        }
        if (z(str, phoneMetadata.getPersonalNumber())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (z(str, phoneMetadata.getPager())) {
            return PhoneNumberType.PAGER;
        }
        if (z(str, phoneMetadata.getUan())) {
            return PhoneNumberType.UAN;
        }
        if (z(str, phoneMetadata.getVoicemail())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (z(str, phoneMetadata.getFixedLine())) {
            if (phoneMetadata.isSameMobileAndFixedLinePattern()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (z(str, phoneMetadata.getMobile())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        } else if (!phoneMetadata.isSameMobileAndFixedLinePattern() && z(str, phoneMetadata.getMobile())) {
            return PhoneNumberType.MOBILE;
        } else {
            return PhoneNumberType.UNKNOWN;
        }
    }

    private String t(Phonenumber.PhoneNumber phoneNumber, List<String> list) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String str : list) {
            Phonemetadata.PhoneMetadata p4 = p(str);
            if (p4.hasLeadingDigits()) {
                if (this.f32869d.getPatternForRegex(p4.getLeadingDigits()).matcher(nationalSignificantNumber).lookingAt()) {
                    return str;
                }
            } else if (s(nationalSignificantNumber, p4) != PhoneNumberType.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    private boolean u(Phonenumber.PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata q4 = q(countryCode, getRegionCodeForCountryCode(countryCode));
        if (q4 == null) {
            return false;
        }
        if (d(q4.numberFormats(), getNationalSignificantNumber(phoneNumber)) == null) {
            return false;
        }
        return true;
    }

    private boolean v(Phonenumber.PhoneNumber phoneNumber) {
        if (phoneNumber.isItalianLeadingZero() && !x(phoneNumber.getCountryCode())) {
            return true;
        }
        return false;
    }

    private boolean w(int i4) {
        return this.f32867b.containsKey(Integer.valueOf(i4));
    }

    private boolean y(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        String valueOf = String.valueOf(phoneNumber.getNationalNumber());
        String valueOf2 = String.valueOf(phoneNumber2.getNationalNumber());
        if (!valueOf.endsWith(valueOf2) && !valueOf2.endsWith(valueOf)) {
            return false;
        }
        return true;
    }

    int D(String str, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb, boolean z3, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        String str2;
        if (str.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(str);
        if (phoneMetadata != null) {
            str2 = phoneMetadata.getInternationalPrefix();
        } else {
            str2 = "NonMatch";
        }
        Phonenumber.PhoneNumber.CountryCodeSource F2 = F(sb2, str2);
        if (z3) {
            phoneNumber.setCountryCodeSource(F2);
        }
        if (F2 != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (sb2.length() > 2) {
                int g4 = g(sb2, sb);
                if (g4 != 0) {
                    phoneNumber.setCountryCode(g4);
                    return g4;
                }
                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
        if (phoneMetadata != null) {
            int countryCode = phoneMetadata.getCountryCode();
            String valueOf = String.valueOf(countryCode);
            String sb3 = sb2.toString();
            if (sb3.startsWith(valueOf)) {
                StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                Phonemetadata.PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                Pattern patternForRegex = this.f32869d.getPatternForRegex(generalDesc.getNationalNumberPattern());
                G(sb4, phoneMetadata, null);
                if ((!patternForRegex.matcher(sb2).matches() && patternForRegex.matcher(sb4).matches()) || R(sb2.toString(), generalDesc) == ValidationResult.TOO_LONG) {
                    sb.append((CharSequence) sb4);
                    if (z3) {
                        phoneNumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phoneNumber.setCountryCode(countryCode);
                    return countryCode;
                }
            }
        }
        phoneNumber.setCountryCode(0);
        return 0;
    }

    String E(StringBuilder sb) {
        Matcher matcher = A.matcher(sb);
        if (matcher.find() && B(sb.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i4 = 1; i4 <= groupCount; i4++) {
                if (matcher.group(i4) != null) {
                    String group = matcher.group(i4);
                    sb.delete(matcher.start(), sb.length());
                    return group;
                }
            }
            return "";
        }
        return "";
    }

    Phonenumber.PhoneNumber.CountryCodeSource F(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = f32856q.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            I(sb);
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.f32869d.getPatternForRegex(str);
        I(sb);
        if (M(patternForRegex, sb)) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        }
        return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G(StringBuilder sb, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb2) {
        int length = sb.length();
        String nationalPrefixForParsing = phoneMetadata.getNationalPrefixForParsing();
        if (length != 0 && nationalPrefixForParsing.length() != 0) {
            Matcher matcher = this.f32869d.getPatternForRegex(nationalPrefixForParsing).matcher(sb);
            if (matcher.lookingAt()) {
                Pattern patternForRegex = this.f32869d.getPatternForRegex(phoneMetadata.getGeneralDesc().getNationalNumberPattern());
                boolean matches = patternForRegex.matcher(sb).matches();
                int groupCount = matcher.groupCount();
                String nationalPrefixTransformRule = phoneMetadata.getNationalPrefixTransformRule();
                if (nationalPrefixTransformRule != null && nationalPrefixTransformRule.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
                    if (matches && !patternForRegex.matcher(sb3.toString()).matches()) {
                        return false;
                    }
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                } else if (matches && !patternForRegex.matcher(sb.substring(matcher.end())).matches()) {
                    return false;
                } else {
                    if (sb2 != null && groupCount > 0 && matcher.group(groupCount) != null) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                }
            }
        }
        return false;
    }

    boolean b(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata p4 = p(getRegionCodeForNumber(phoneNumber));
        if (p4 == null) {
            return true;
        }
        return !z(getNationalSignificantNumber(phoneNumber), p4.getNoInternationalDialling());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata.NumberFormat d(List<Phonemetadata.NumberFormat> list, String str) {
        for (Phonemetadata.NumberFormat numberFormat : list) {
            int leadingDigitsPatternSize = numberFormat.leadingDigitsPatternSize();
            if (leadingDigitsPatternSize == 0 || this.f32869d.getPatternForRegex(numberFormat.getLeadingDigitsPattern(leadingDigitsPatternSize - 1)).matcher(str).lookingAt()) {
                if (this.f32869d.getPatternForRegex(numberFormat.getPattern()).matcher(str).matches()) {
                    return numberFormat;
                }
            }
        }
        return null;
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence charSequence, String str) {
        return findNumbers(charSequence, str, Leniency.VALID, Long.MAX_VALUE);
    }

    public String format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phoneNumber.getNationalNumber() == 0 && phoneNumber.hasRawInput()) {
            String rawInput = phoneNumber.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        format(phoneNumber, phoneNumberFormat, sb);
        return sb.toString();
    }

    public String formatByPattern(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, List<Phonemetadata.NumberFormat> list) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!w(countryCode)) {
            return nationalSignificantNumber;
        }
        Phonemetadata.PhoneMetadata q4 = q(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb = new StringBuilder(20);
        Phonemetadata.NumberFormat d4 = d(list, nationalSignificantNumber);
        if (d4 == null) {
            sb.append(nationalSignificantNumber);
        } else {
            Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
            newBuilder.mergeFrom(d4);
            String nationalPrefixFormattingRule = d4.getNationalPrefixFormattingRule();
            if (nationalPrefixFormattingRule.length() > 0) {
                String nationalPrefix = q4.getNationalPrefix();
                if (nationalPrefix.length() > 0) {
                    newBuilder.setNationalPrefixFormattingRule(F.matcher(E.matcher(nationalPrefixFormattingRule).replaceFirst(nationalPrefix)).replaceFirst("\\$1"));
                } else {
                    newBuilder.clearNationalPrefixFormattingRule();
                }
            }
            sb.append(k(nationalSignificantNumber, newBuilder, phoneNumberFormat));
        }
        C(phoneNumber, q4, phoneNumberFormat, sb);
        N(countryCode, phoneNumberFormat, sb);
        return sb.toString();
    }

    public String formatInOriginalFormat(Phonenumber.PhoneNumber phoneNumber, String str) {
        String format;
        String nationalPrefixFormattingRule;
        int indexOf;
        if (phoneNumber.hasRawInput() && (v(phoneNumber) || !u(phoneNumber))) {
            return phoneNumber.getRawInput();
        }
        if (!phoneNumber.hasCountryCodeSource()) {
            return format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        int i4 = AnonymousClass2.f32877a[phoneNumber.getCountryCodeSource().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    String regionCodeForCountryCode = getRegionCodeForCountryCode(phoneNumber.getCountryCode());
                    String nddPrefixForRegion = getNddPrefixForRegion(regionCodeForCountryCode, true);
                    PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.NATIONAL;
                    format = format(phoneNumber, phoneNumberFormat);
                    if (nddPrefixForRegion != null && nddPrefixForRegion.length() != 0 && !O(phoneNumber.getRawInput(), nddPrefixForRegion, regionCodeForCountryCode)) {
                        Phonemetadata.NumberFormat d4 = d(p(regionCodeForCountryCode).numberFormats(), getNationalSignificantNumber(phoneNumber));
                        if (d4 != null && (indexOf = (nationalPrefixFormattingRule = d4.getNationalPrefixFormattingRule()).indexOf("$1")) > 0 && normalizeDigitsOnly(nationalPrefixFormattingRule.substring(0, indexOf)).length() != 0) {
                            Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
                            newBuilder.mergeFrom(d4);
                            newBuilder.clearNationalPrefixFormattingRule();
                            List<Phonemetadata.NumberFormat> arrayList = new ArrayList<>(1);
                            arrayList.add(newBuilder);
                            format = formatByPattern(phoneNumber, phoneNumberFormat, arrayList);
                        }
                    }
                } else {
                    format = format(phoneNumber, PhoneNumberFormat.INTERNATIONAL).substring(1);
                }
            } else {
                format = formatOutOfCountryCallingNumber(phoneNumber, str);
            }
        } else {
            format = format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        }
        String rawInput = phoneNumber.getRawInput();
        if (format != null && rawInput.length() > 0 && !normalizeDiallableCharsOnly(format).equals(normalizeDiallableCharsOnly(rawInput))) {
            return rawInput;
        }
        return format;
    }

    public String formatNationalNumberWithCarrierCode(Phonenumber.PhoneNumber phoneNumber, String str) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!w(countryCode)) {
            return nationalSignificantNumber;
        }
        Phonemetadata.PhoneMetadata q4 = q(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb = new StringBuilder(20);
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.NATIONAL;
        sb.append(j(nationalSignificantNumber, q4, phoneNumberFormat, str));
        C(phoneNumber, q4, phoneNumberFormat, sb);
        N(countryCode, phoneNumberFormat, sb);
        return sb.toString();
    }

    public String formatNationalNumberWithPreferredCarrierCode(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (phoneNumber.getPreferredDomesticCarrierCode().length() > 0) {
            str = phoneNumber.getPreferredDomesticCarrierCode();
        }
        return formatNationalNumberWithCarrierCode(phoneNumber, str);
    }

    public String formatNumberForMobileDialing(Phonenumber.PhoneNumber phoneNumber, String str, boolean z3) {
        boolean z4;
        String format;
        int countryCode = phoneNumber.getCountryCode();
        String str2 = "";
        if (!w(countryCode)) {
            if (!phoneNumber.hasRawInput()) {
                return "";
            }
            return phoneNumber.getRawInput();
        }
        Phonenumber.PhoneNumber clearExtension = new Phonenumber.PhoneNumber().mergeFrom(phoneNumber).clearExtension();
        String regionCodeForCountryCode = getRegionCodeForCountryCode(countryCode);
        PhoneNumberType numberType = getNumberType(clearExtension);
        boolean z5 = false;
        if (numberType != PhoneNumberType.UNKNOWN) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (str.equals(regionCodeForCountryCode)) {
            PhoneNumberType phoneNumberType = PhoneNumberType.FIXED_LINE;
            z5 = (numberType == phoneNumberType || numberType == PhoneNumberType.MOBILE || numberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) ? true : true;
            if (regionCodeForCountryCode.equals("CO") && numberType == phoneNumberType) {
                format = formatNationalNumberWithCarrierCode(clearExtension, ExifInterface.GPS_MEASUREMENT_3D);
            } else if (regionCodeForCountryCode.equals("BR") && z5) {
                if (clearExtension.getPreferredDomesticCarrierCode().length() > 0) {
                    str2 = formatNationalNumberWithPreferredCarrierCode(clearExtension, "");
                }
            } else if (z4 && regionCodeForCountryCode.equals("HU")) {
                format = getNddPrefixForRegion(regionCodeForCountryCode, true) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + format(clearExtension, PhoneNumberFormat.NATIONAL);
            } else if (countryCode == 1) {
                Phonemetadata.PhoneMetadata p4 = p(str);
                if (b(clearExtension) && R(getNationalSignificantNumber(clearExtension), p4.getGeneralDesc()) != ValidationResult.TOO_SHORT) {
                    format = format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
                } else {
                    format = format(clearExtension, PhoneNumberFormat.NATIONAL);
                }
            } else if ((regionCodeForCountryCode.equals(REGION_CODE_FOR_NON_GEO_ENTITY) || ((regionCodeForCountryCode.equals("MX") || regionCodeForCountryCode.equals("CL")) && z5)) && b(clearExtension)) {
                format = format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
            } else {
                format = format(clearExtension, PhoneNumberFormat.NATIONAL);
            }
            str2 = format;
        } else if (z4 && b(clearExtension)) {
            if (z3) {
                return format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
            }
            return format(clearExtension, PhoneNumberFormat.E164);
        }
        if (!z3) {
            return normalizeDiallableCharsOnly(str2);
        }
        return str2;
    }

    public String formatOutOfCountryCallingNumber(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (!A(str)) {
            Logger logger = f32846g;
            Level level = Level.WARNING;
            logger.log(level, "Trying to format number from invalid region " + str + ". International formatting applied.");
            return format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        }
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!w(countryCode)) {
            return nationalSignificantNumber;
        }
        if (countryCode == 1) {
            if (isNANPACountry(str)) {
                return countryCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + format(phoneNumber, PhoneNumberFormat.NATIONAL);
            }
        } else if (countryCode == n(str)) {
            return format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        Phonemetadata.PhoneMetadata p4 = p(str);
        String internationalPrefix = p4.getInternationalPrefix();
        if (!f32854o.matcher(internationalPrefix).matches()) {
            if (p4.hasPreferredInternationalPrefix()) {
                internationalPrefix = p4.getPreferredInternationalPrefix();
            } else {
                internationalPrefix = "";
            }
        }
        Phonemetadata.PhoneMetadata q4 = q(countryCode, getRegionCodeForCountryCode(countryCode));
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.INTERNATIONAL;
        StringBuilder sb = new StringBuilder(i(nationalSignificantNumber, q4, phoneNumberFormat));
        C(phoneNumber, q4, phoneNumberFormat, sb);
        if (internationalPrefix.length() > 0) {
            sb.insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, countryCode).insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, internationalPrefix);
        } else {
            N(countryCode, phoneNumberFormat, sb);
        }
        return sb.toString();
    }

    public String formatOutOfCountryKeepingAlphaChars(Phonenumber.PhoneNumber phoneNumber, String str) {
        String str2;
        int indexOf;
        String rawInput = phoneNumber.getRawInput();
        if (rawInput.length() == 0) {
            return formatOutOfCountryCallingNumber(phoneNumber, str);
        }
        int countryCode = phoneNumber.getCountryCode();
        if (!w(countryCode)) {
            return rawInput;
        }
        String K = K(rawInput, f32853n, true);
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (nationalSignificantNumber.length() > 3 && (indexOf = K.indexOf(nationalSignificantNumber.substring(0, 3))) != -1) {
            K = K.substring(indexOf);
        }
        Phonemetadata.PhoneMetadata p4 = p(str);
        if (countryCode == 1) {
            if (isNANPACountry(str)) {
                return countryCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + K;
            }
        } else if (p4 != null && countryCode == n(str)) {
            Phonemetadata.NumberFormat d4 = d(p4.numberFormats(), nationalSignificantNumber);
            if (d4 == null) {
                return K;
            }
            Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
            newBuilder.mergeFrom(d4);
            newBuilder.setPattern("(\\d+)(.*)");
            newBuilder.setFormat("$1$2");
            return k(K, newBuilder, PhoneNumberFormat.NATIONAL);
        }
        if (p4 != null) {
            str2 = p4.getInternationalPrefix();
            if (!f32854o.matcher(str2).matches()) {
                str2 = p4.getPreferredInternationalPrefix();
            }
        } else {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder(K);
        Phonemetadata.PhoneMetadata q4 = q(countryCode, getRegionCodeForCountryCode(countryCode));
        PhoneNumberFormat phoneNumberFormat = PhoneNumberFormat.INTERNATIONAL;
        C(phoneNumber, q4, phoneNumberFormat, sb);
        if (str2.length() > 0) {
            sb.insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, countryCode).insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, str2);
        } else {
            if (!A(str)) {
                Logger logger = f32846g;
                Level level = Level.WARNING;
                logger.log(level, "Trying to format number from invalid region " + str + ". International formatting applied.");
            }
            N(countryCode, phoneNumberFormat, sb);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(StringBuilder sb, StringBuilder sb2) {
        if (sb.length() != 0 && sb.charAt(0) != '0') {
            int length = sb.length();
            for (int i4 = 1; i4 <= 3 && i4 <= length; i4++) {
                int parseInt = Integer.parseInt(sb.substring(0, i4));
                if (this.f32867b.containsKey(Integer.valueOf(parseInt))) {
                    sb2.append(sb.substring(i4));
                    return parseInt;
                }
            }
        }
        return 0;
    }

    public AsYouTypeFormatter getAsYouTypeFormatter(String str) {
        return new AsYouTypeFormatter(str);
    }

    public int getCountryCodeForRegion(String str) {
        if (!A(str)) {
            Logger logger = f32846g;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger.log(level, sb.toString());
            return 0;
        }
        return n(str);
    }

    public Phonenumber.PhoneNumber getExampleNumber(String str) {
        return getExampleNumberForType(str, PhoneNumberType.FIXED_LINE);
    }

    public Phonenumber.PhoneNumber getExampleNumberForNonGeoEntity(int i4) {
        Phonemetadata.PhoneMetadata o4 = o(i4);
        if (o4 != null) {
            for (Phonemetadata.PhoneNumberDesc phoneNumberDesc : Arrays.asList(o4.getMobile(), o4.getTollFree(), o4.getSharedCost(), o4.getVoip(), o4.getVoicemail(), o4.getUan(), o4.getPremiumRate())) {
                if (phoneNumberDesc != null) {
                    try {
                        if (phoneNumberDesc.hasExampleNumber()) {
                            return parse(Marker.ANY_NON_NULL_MARKER + i4 + phoneNumberDesc.getExampleNumber(), "ZZ");
                        }
                        continue;
                    } catch (NumberParseException e4) {
                        f32846g.log(Level.SEVERE, e4.toString());
                    }
                }
            }
            return null;
        }
        Logger logger = f32846g;
        Level level = Level.WARNING;
        logger.log(level, "Invalid or unknown country calling code provided: " + i4);
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(String str, PhoneNumberType phoneNumberType) {
        if (!A(str)) {
            Logger logger = f32846g;
            Level level = Level.WARNING;
            logger.log(level, "Invalid or unknown region code provided: " + str);
            return null;
        }
        Phonemetadata.PhoneNumberDesc r4 = r(p(str), phoneNumberType);
        try {
            if (r4.hasExampleNumber()) {
                return parse(r4.getExampleNumber(), str);
            }
        } catch (NumberParseException e4) {
            f32846g.log(Level.SEVERE, e4.toString());
        }
        return null;
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "to" is null
        	at jadx.core.dex.visitors.blocks.BlockSplitter.connect(BlockSplitter.java:150)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectSplittersAndHandlers(BlockExceptionHandler.java:457)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.wrapBlocksWithTryCatch(BlockExceptionHandler.java:358)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:84)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:59)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:318)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public com.google.i18n.phonenumbers.Phonenumber.PhoneNumber getInvalidExampleNumber(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = r5.A(r6)
            r1 = 0
            if (r0 != 0) goto L20
            java.util.logging.Logger r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.f32846g
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid or unknown region code provided: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r0.log(r2, r6)
            return r1
        L20:
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r0 = r5.p(r6)
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r0 = r5.r(r0, r2)
            boolean r2 = r0.hasExampleNumber()
            if (r2 != 0) goto L31
            return r1
        L31:
            java.lang.String r0 = r0.getExampleNumber()
            int r2 = r0.length()
            int r2 = r2 + (-1)
        L3b:
            r3 = 2
            if (r2 < r3) goto L51
            r3 = 0
            java.lang.String r3 = r0.substring(r3, r2)
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r3 = r5.parse(r3, r6)     // Catch: com.google.i18n.phonenumbers.NumberParseException -> L4e
            boolean r4 = r5.isValidNumber(r3)     // Catch: com.google.i18n.phonenumbers.NumberParseException -> L4e
            if (r4 != 0) goto L4e
            return r3
        L4e:
            int r2 = r2 + (-1)
            goto L3b
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.getInvalidExampleNumber(java.lang.String):com.google.i18n.phonenumbers.Phonenumber$PhoneNumber");
    }

    public int getLengthOfGeographicalAreaCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata p4 = p(getRegionCodeForNumber(phoneNumber));
        if (p4 == null) {
            return 0;
        }
        if (!p4.hasNationalPrefix() && !phoneNumber.isItalianLeadingZero()) {
            return 0;
        }
        PhoneNumberType numberType = getNumberType(phoneNumber);
        int countryCode = phoneNumber.getCountryCode();
        if ((numberType == PhoneNumberType.MOBILE && f32848i.contains(Integer.valueOf(countryCode))) || !isNumberGeographical(numberType, countryCode)) {
            return 0;
        }
        return getLengthOfNationalDestinationCode(phoneNumber);
    }

    public int getLengthOfNationalDestinationCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonenumber.PhoneNumber phoneNumber2;
        if (phoneNumber.hasExtension()) {
            phoneNumber2 = new Phonenumber.PhoneNumber();
            phoneNumber2.mergeFrom(phoneNumber);
            phoneNumber2.clearExtension();
        } else {
            phoneNumber2 = phoneNumber;
        }
        String[] split = C.split(format(phoneNumber2, PhoneNumberFormat.INTERNATIONAL));
        if (split.length <= 3) {
            return 0;
        }
        if (getNumberType(phoneNumber) == PhoneNumberType.MOBILE && !getCountryMobileToken(phoneNumber.getCountryCode()).equals("")) {
            return split[2].length() + split[3].length();
        }
        return split[2].length();
    }

    public String getNationalSignificantNumber(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phoneNumber.getNationalNumber());
        return sb.toString();
    }

    public String getNddPrefixForRegion(String str, boolean z3) {
        Phonemetadata.PhoneMetadata p4 = p(str);
        if (p4 == null) {
            Logger logger = f32846g;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger.log(level, sb.toString());
            return null;
        }
        String nationalPrefix = p4.getNationalPrefix();
        if (nationalPrefix.length() == 0) {
            return null;
        }
        if (z3) {
            return nationalPrefix.replace("~", "");
        }
        return nationalPrefix;
    }

    public PhoneNumberType getNumberType(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata q4 = q(phoneNumber.getCountryCode(), getRegionCodeForNumber(phoneNumber));
        if (q4 == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return s(getNationalSignificantNumber(phoneNumber), q4);
    }

    public String getRegionCodeForCountryCode(int i4) {
        List<String> list = this.f32867b.get(Integer.valueOf(i4));
        if (list == null) {
            return "ZZ";
        }
        return list.get(0);
    }

    public String getRegionCodeForNumber(Phonenumber.PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        List<String> list = this.f32867b.get(Integer.valueOf(countryCode));
        if (list == null) {
            String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
            Logger logger = f32846g;
            Level level = Level.INFO;
            logger.log(level, "Missing/invalid country_code (" + countryCode + ") for number " + nationalSignificantNumber);
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return t(phoneNumber, list);
        }
    }

    public List<String> getRegionCodesForCountryCode(int i4) {
        List<String> list = this.f32867b.get(Integer.valueOf(i4));
        if (list == null) {
            list = new ArrayList<>(0);
        }
        return Collections.unmodifiableList(list);
    }

    public Set<Integer> getSupportedGlobalNetworkCallingCodes() {
        return Collections.unmodifiableSet(this.f32871f);
    }

    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(this.f32870e);
    }

    public boolean isAlphaNumber(String str) {
        if (!B(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        E(sb);
        return f32862w.matcher(sb).matches();
    }

    public boolean isMobileNumberPortableRegion(String str) {
        Phonemetadata.PhoneMetadata p4 = p(str);
        if (p4 == null) {
            Logger logger = f32846g;
            Level level = Level.WARNING;
            logger.log(level, "Invalid or unknown region code provided: " + str);
            return false;
        }
        return p4.isMobileNumberPortableRegion();
    }

    public boolean isNANPACountry(String str) {
        return this.f32868c.contains(str);
    }

    public boolean isNumberGeographical(Phonenumber.PhoneNumber phoneNumber) {
        return isNumberGeographical(getNumberType(phoneNumber), phoneNumber.getCountryCode());
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        Phonenumber.PhoneNumber phoneNumber3 = new Phonenumber.PhoneNumber();
        phoneNumber3.mergeFrom(phoneNumber);
        Phonenumber.PhoneNumber phoneNumber4 = new Phonenumber.PhoneNumber();
        phoneNumber4.mergeFrom(phoneNumber2);
        phoneNumber3.clearRawInput();
        phoneNumber3.clearCountryCodeSource();
        phoneNumber3.clearPreferredDomesticCarrierCode();
        phoneNumber4.clearRawInput();
        phoneNumber4.clearCountryCodeSource();
        phoneNumber4.clearPreferredDomesticCarrierCode();
        if (phoneNumber3.hasExtension() && phoneNumber3.getExtension().length() == 0) {
            phoneNumber3.clearExtension();
        }
        if (phoneNumber4.hasExtension() && phoneNumber4.getExtension().length() == 0) {
            phoneNumber4.clearExtension();
        }
        if (phoneNumber3.hasExtension() && phoneNumber4.hasExtension() && !phoneNumber3.getExtension().equals(phoneNumber4.getExtension())) {
            return MatchType.NO_MATCH;
        }
        int countryCode = phoneNumber3.getCountryCode();
        int countryCode2 = phoneNumber4.getCountryCode();
        if (countryCode != 0 && countryCode2 != 0) {
            if (phoneNumber3.exactlySameAs(phoneNumber4)) {
                return MatchType.EXACT_MATCH;
            }
            if (countryCode == countryCode2 && y(phoneNumber3, phoneNumber4)) {
                return MatchType.SHORT_NSN_MATCH;
            }
            return MatchType.NO_MATCH;
        }
        phoneNumber3.setCountryCode(countryCode2);
        if (phoneNumber3.exactlySameAs(phoneNumber4)) {
            return MatchType.NSN_MATCH;
        }
        if (y(phoneNumber3, phoneNumber4)) {
            return MatchType.SHORT_NSN_MATCH;
        }
        return MatchType.NO_MATCH;
    }

    public boolean isPossibleNumber(Phonenumber.PhoneNumber phoneNumber) {
        return isPossibleNumberWithReason(phoneNumber) == ValidationResult.IS_POSSIBLE;
    }

    public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber phoneNumber) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        int countryCode = phoneNumber.getCountryCode();
        if (!w(countryCode)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return R(nationalSignificantNumber, q(countryCode, getRegionCodeForCountryCode(countryCode)).getGeneralDesc());
    }

    public boolean isValidNumber(Phonenumber.PhoneNumber phoneNumber) {
        return isValidNumberForRegion(phoneNumber, getRegionCodeForNumber(phoneNumber));
    }

    public boolean isValidNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        int countryCode = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata q4 = q(countryCode, str);
        if (q4 == null) {
            return false;
        }
        if ((!REGION_CODE_FOR_NON_GEO_ENTITY.equals(str) && countryCode != n(str)) || s(getNationalSignificantNumber(phoneNumber), q4) == PhoneNumberType.UNKNOWN) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k(String str, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat) {
        return l(str, numberFormat, phoneNumberFormat, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata.PhoneMetadata o(int i4) {
        if (!this.f32867b.containsKey(Integer.valueOf(i4))) {
            return null;
        }
        return this.f32866a.b(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata.PhoneMetadata p(String str) {
        if (!A(str)) {
            return null;
        }
        return this.f32866a.a(str);
    }

    public Phonenumber.PhoneNumber parse(String str, String str2) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parse(str, str2, phoneNumber);
        return phoneNumber;
    }

    public Phonenumber.PhoneNumber parseAndKeepRawInput(String str, String str2) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parseAndKeepRawInput(str, str2, phoneNumber);
        return phoneNumber;
    }

    Phonemetadata.PhoneNumberDesc r(Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        switch (AnonymousClass2.f32879c[phoneNumberType.ordinal()]) {
            case 1:
                return phoneMetadata.getPremiumRate();
            case 2:
                return phoneMetadata.getTollFree();
            case 3:
                return phoneMetadata.getMobile();
            case 4:
            case 5:
                return phoneMetadata.getFixedLine();
            case 6:
                return phoneMetadata.getSharedCost();
            case 7:
                return phoneMetadata.getVoip();
            case 8:
                return phoneMetadata.getPersonalNumber();
            case 9:
                return phoneMetadata.getPager();
            case 10:
                return phoneMetadata.getUan();
            case 11:
                return phoneMetadata.getVoicemail();
            default:
                return phoneMetadata.getGeneralDesc();
        }
    }

    public boolean truncateTooLongNumber(Phonenumber.PhoneNumber phoneNumber) {
        if (isValidNumber(phoneNumber)) {
            return true;
        }
        Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
        phoneNumber2.mergeFrom(phoneNumber);
        long nationalNumber = phoneNumber.getNationalNumber();
        do {
            nationalNumber /= 10;
            phoneNumber2.setNationalNumber(nationalNumber);
            if (isPossibleNumberWithReason(phoneNumber2) == ValidationResult.TOO_SHORT || nationalNumber == 0) {
                return false;
            }
        } while (!isValidNumber(phoneNumber2));
        phoneNumber.setNationalNumber(nationalNumber);
        return true;
    }

    boolean x(int i4) {
        Phonemetadata.PhoneMetadata q4 = q(i4, getRegionCodeForCountryCode(i4));
        if (q4 == null) {
            return false;
        }
        return q4.isLeadingZeroPossible();
    }

    boolean z(String str, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        int length = str.length();
        List<Integer> possibleLengthList = phoneNumberDesc.getPossibleLengthList();
        if (possibleLengthList.size() > 0 && !possibleLengthList.contains(Integer.valueOf(length))) {
            return false;
        }
        return this.f32869d.getPatternForRegex(phoneNumberDesc.getNationalNumberPattern()).matcher(str).matches();
    }

    public Iterable<PhoneNumberMatch> findNumbers(final CharSequence charSequence, final String str, final Leniency leniency, final long j4) {
        return new Iterable<PhoneNumberMatch>() { // from class: com.google.i18n.phonenumbers.PhoneNumberUtil.1
            @Override // java.lang.Iterable
            public Iterator<PhoneNumberMatch> iterator() {
                return new PhoneNumberMatcher(PhoneNumberUtil.this, charSequence, str, leniency, j4);
            }
        };
    }

    public boolean isNumberGeographical(PhoneNumberType phoneNumberType, int i4) {
        return phoneNumberType == PhoneNumberType.FIXED_LINE || phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE || (f32849j.contains(Integer.valueOf(i4)) && phoneNumberType == PhoneNumberType.MOBILE);
    }

    public boolean isPossibleNumber(String str, String str2) {
        try {
            return isPossibleNumber(parse(str, str2));
        } catch (NumberParseException unused) {
            return false;
        }
    }

    public void parse(String str, String str2, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        L(str, str2, false, true, phoneNumber);
    }

    public void parseAndKeepRawInput(String str, String str2, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        L(str, str2, true, true, phoneNumber);
    }

    public void format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        sb.setLength(0);
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.E164;
        if (phoneNumberFormat == phoneNumberFormat2) {
            sb.append(nationalSignificantNumber);
            N(countryCode, phoneNumberFormat2, sb);
        } else if (!w(countryCode)) {
            sb.append(nationalSignificantNumber);
        } else {
            Phonemetadata.PhoneMetadata q4 = q(countryCode, getRegionCodeForCountryCode(countryCode));
            sb.append(i(nationalSignificantNumber, q4, phoneNumberFormat));
            C(phoneNumber, q4, phoneNumberFormat, sb);
            N(countryCode, phoneNumberFormat, sb);
        }
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(PhoneNumberType phoneNumberType) {
        for (String str : getSupportedRegions()) {
            Phonenumber.PhoneNumber exampleNumberForType = getExampleNumberForType(str, phoneNumberType);
            if (exampleNumberForType != null) {
                return exampleNumberForType;
            }
        }
        for (Integer num : getSupportedGlobalNetworkCallingCodes()) {
            int intValue = num.intValue();
            Phonemetadata.PhoneNumberDesc r4 = r(o(intValue), phoneNumberType);
            try {
            } catch (NumberParseException e4) {
                f32846g.log(Level.SEVERE, e4.toString());
            }
            if (r4.hasExampleNumber()) {
                return parse(Marker.ANY_NON_NULL_MARKER + intValue + r4.getExampleNumber(), "ZZ");
            }
            continue;
        }
        return null;
    }

    public MatchType isNumberMatch(String str, String str2) {
        try {
            return isNumberMatch(parse(str, "ZZ"), str2);
        } catch (NumberParseException e4) {
            if (e4.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                try {
                    return isNumberMatch(parse(str2, "ZZ"), str);
                } catch (NumberParseException e5) {
                    if (e5.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                        try {
                            Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
                            Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
                            L(str, null, false, false, phoneNumber);
                            L(str2, null, false, false, phoneNumber2);
                            return isNumberMatch(phoneNumber, phoneNumber2);
                        } catch (NumberParseException unused) {
                            return MatchType.NOT_A_NUMBER;
                        }
                    }
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber phoneNumber, String str) {
        try {
            return isNumberMatch(phoneNumber, parse(str, "ZZ"));
        } catch (NumberParseException e4) {
            if (e4.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                String regionCodeForCountryCode = getRegionCodeForCountryCode(phoneNumber.getCountryCode());
                try {
                    if (!regionCodeForCountryCode.equals("ZZ")) {
                        MatchType isNumberMatch = isNumberMatch(phoneNumber, parse(str, regionCodeForCountryCode));
                        return isNumberMatch == MatchType.EXACT_MATCH ? MatchType.NSN_MATCH : isNumberMatch;
                    }
                    Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
                    L(str, null, false, false, phoneNumber2);
                    return isNumberMatch(phoneNumber, phoneNumber2);
                } catch (NumberParseException unused) {
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }
}
