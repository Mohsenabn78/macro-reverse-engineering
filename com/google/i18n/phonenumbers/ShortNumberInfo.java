package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class ShortNumberInfo {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f32891c = Logger.getLogger(ShortNumberInfo.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static final ShortNumberInfo f32892d = new ShortNumberInfo(RegexBasedMatcher.create());

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f32893e;

    /* renamed from: a  reason: collision with root package name */
    private final MatcherApi f32894a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, List<String>> f32895b = CountryCodeToRegionCodeMap.a();

    /* renamed from: com.google.i18n.phonenumbers.ShortNumberInfo$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32896a;

        static {
            int[] iArr = new int[ShortNumberCost.values().length];
            f32896a = iArr;
            try {
                iArr[ShortNumberCost.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32896a[ShortNumberCost.UNKNOWN_COST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32896a[ShortNumberCost.STANDARD_RATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32896a[ShortNumberCost.TOLL_FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum ShortNumberCost {
        TOLL_FREE,
        STANDARD_RATE,
        PREMIUM_RATE,
        UNKNOWN_COST
    }

    static {
        HashSet hashSet = new HashSet();
        f32893e = hashSet;
        hashSet.add("BR");
        hashSet.add("CL");
        hashSet.add("NI");
    }

    ShortNumberInfo(MatcherApi matcherApi) {
        this.f32894a = matcherApi;
    }

    private static String a(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phoneNumber.getNationalNumber());
        return sb.toString();
    }

    private String b(Phonenumber.PhoneNumber phoneNumber, List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        String a4 = a(phoneNumber);
        for (String str : list) {
            Phonemetadata.PhoneMetadata e4 = MetadataManager.e(str);
            if (e4 != null && e(a4, e4.getShortCode())) {
                return str;
            }
        }
        return null;
    }

    private List<String> c(int i4) {
        List<String> list = this.f32895b.get(Integer.valueOf(i4));
        if (list == null) {
            list = new ArrayList<>(0);
        }
        return Collections.unmodifiableList(list);
    }

    private boolean d(String str, String str2, boolean z3) {
        Phonemetadata.PhoneMetadata e4;
        String h4 = PhoneNumberUtil.h(str);
        boolean z4 = false;
        if (PhoneNumberUtil.f32856q.matcher(h4).lookingAt() || (e4 = MetadataManager.e(str2)) == null || !e4.hasEmergency()) {
            return false;
        }
        String normalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(h4);
        Phonemetadata.PhoneNumberDesc emergency = e4.getEmergency();
        if (z3 && !f32893e.contains(str2)) {
            z4 = true;
        }
        return this.f32894a.matchesNationalNumber(normalizeDigitsOnly, emergency, z4);
    }

    private boolean e(String str, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        if (phoneNumberDesc.getPossibleLengthCount() > 0 && !phoneNumberDesc.getPossibleLengthList().contains(Integer.valueOf(str.length()))) {
            return false;
        }
        return this.f32894a.matchesNationalNumber(str, phoneNumberDesc, false);
    }

    private boolean f(Phonenumber.PhoneNumber phoneNumber, String str) {
        return c(phoneNumber.getCountryCode()).contains(str);
    }

    public static ShortNumberInfo getInstance() {
        return f32892d;
    }

    public boolean connectsToEmergencyNumber(String str, String str2) {
        return d(str, str2, true);
    }

    public ShortNumberCost getExpectedCost(Phonenumber.PhoneNumber phoneNumber) {
        List<String> c4 = c(phoneNumber.getCountryCode());
        if (c4.size() == 0) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (c4.size() == 1) {
            return getExpectedCostForRegion(phoneNumber, c4.get(0));
        }
        ShortNumberCost shortNumberCost = ShortNumberCost.TOLL_FREE;
        for (String str : c4) {
            ShortNumberCost expectedCostForRegion = getExpectedCostForRegion(phoneNumber, str);
            int i4 = AnonymousClass1.f32896a[expectedCostForRegion.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            Logger logger = f32891c;
                            Level level = Level.SEVERE;
                            logger.log(level, "Unrecognised cost for region: " + expectedCostForRegion);
                        }
                    } else if (shortNumberCost != ShortNumberCost.UNKNOWN_COST) {
                        shortNumberCost = ShortNumberCost.STANDARD_RATE;
                    }
                } else {
                    shortNumberCost = ShortNumberCost.UNKNOWN_COST;
                }
            } else {
                return ShortNumberCost.PREMIUM_RATE;
            }
        }
        return shortNumberCost;
    }

    public ShortNumberCost getExpectedCostForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (!f(phoneNumber, str)) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        Phonemetadata.PhoneMetadata e4 = MetadataManager.e(str);
        if (e4 == null) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        String a4 = a(phoneNumber);
        if (!e4.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(a4.length()))) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (e(a4, e4.getPremiumRate())) {
            return ShortNumberCost.PREMIUM_RATE;
        }
        if (e(a4, e4.getStandardRate())) {
            return ShortNumberCost.STANDARD_RATE;
        }
        if (e(a4, e4.getTollFree())) {
            return ShortNumberCost.TOLL_FREE;
        }
        if (isEmergencyNumber(a4, str)) {
            return ShortNumberCost.TOLL_FREE;
        }
        return ShortNumberCost.UNKNOWN_COST;
    }

    public boolean isCarrierSpecific(Phonenumber.PhoneNumber phoneNumber) {
        String b4 = b(phoneNumber, c(phoneNumber.getCountryCode()));
        String a4 = a(phoneNumber);
        Phonemetadata.PhoneMetadata e4 = MetadataManager.e(b4);
        if (e4 != null && e(a4, e4.getCarrierSpecific())) {
            return true;
        }
        return false;
    }

    public boolean isCarrierSpecificForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (!f(phoneNumber, str)) {
            return false;
        }
        String a4 = a(phoneNumber);
        Phonemetadata.PhoneMetadata e4 = MetadataManager.e(str);
        if (e4 == null || !e(a4, e4.getCarrierSpecific())) {
            return false;
        }
        return true;
    }

    public boolean isEmergencyNumber(String str, String str2) {
        return d(str, str2, false);
    }

    public boolean isPossibleShortNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> c4 = c(phoneNumber.getCountryCode());
        int length = a(phoneNumber).length();
        for (String str : c4) {
            Phonemetadata.PhoneMetadata e4 = MetadataManager.e(str);
            if (e4 != null && e4.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(length))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleShortNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        Phonemetadata.PhoneMetadata e4;
        if (!f(phoneNumber, str) || (e4 = MetadataManager.e(str)) == null) {
            return false;
        }
        return e4.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(a(phoneNumber).length()));
    }

    public boolean isValidShortNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> c4 = c(phoneNumber.getCountryCode());
        String b4 = b(phoneNumber, c4);
        if (c4.size() > 1 && b4 != null) {
            return true;
        }
        return isValidShortNumberForRegion(phoneNumber, b4);
    }

    public boolean isValidShortNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        Phonemetadata.PhoneMetadata e4;
        if (!f(phoneNumber, str) || (e4 = MetadataManager.e(str)) == null) {
            return false;
        }
        String a4 = a(phoneNumber);
        if (!e(a4, e4.getGeneralDesc())) {
            return false;
        }
        return e(a4, e4.getShortCode());
    }
}
