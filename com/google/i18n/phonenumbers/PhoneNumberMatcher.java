package com.google.i18n.phonenumbers;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import java.lang.Character;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f32826i;

    /* renamed from: n  reason: collision with root package name */
    private static final Pattern f32831n;

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f32833p;

    /* renamed from: a  reason: collision with root package name */
    private final PhoneNumberUtil f32834a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f32835b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32836c;

    /* renamed from: d  reason: collision with root package name */
    private final PhoneNumberUtil.Leniency f32837d;

    /* renamed from: e  reason: collision with root package name */
    private long f32838e;

    /* renamed from: f  reason: collision with root package name */
    private State f32839f = State.NOT_READY;

    /* renamed from: g  reason: collision with root package name */
    private PhoneNumberMatch f32840g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f32841h = 0;

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f32827j = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f32828k = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f32829l = Pattern.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f32830m = Pattern.compile(":[0-5]\\d");

    /* renamed from: o  reason: collision with root package name */
    private static final Pattern[] f32832o = {Pattern.compile("/+(.*)"), Pattern.compile("(\\([^(]*)"), Pattern.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile("[‒-―－]\\p{Z}*(.+)"), Pattern.compile("\\.+\\p{Z}*([^.]+)"), Pattern.compile("\\p{Z}+(\\P{Z}+)")};

    /* loaded from: classes5.dex */
    interface NumberGroupingChecker {
        boolean a(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb, String[] strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum State {
        NOT_READY,
        READY,
        DONE
    }

    static {
        String str = "[^(\\[（［)\\]）］]";
        f32831n = Pattern.compile("(?:[(\\[（［])?(?:" + str + "+[)\\]）］])?" + str + "+(?:[(\\[（［]" + str + "+[)\\]）］])" + m(0, 3) + str + "*");
        String m4 = m(0, 2);
        String m5 = m(0, 4);
        String m6 = m(0, 20);
        String str2 = "[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]" + m5;
        String str3 = "\\p{Nd}" + m(1, 20);
        String str4 = "[" + ("(\\[（［+＋") + "]";
        f32833p = Pattern.compile(str4);
        f32826i = Pattern.compile("(?:" + str4 + str2 + ")" + m4 + str3 + "(?:" + str2 + str3 + ")" + m6 + "(?:" + PhoneNumberUtil.f32865z + ")?", 66);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneNumberMatcher(PhoneNumberUtil phoneNumberUtil, String str, String str2, PhoneNumberUtil.Leniency leniency, long j4) {
        if (phoneNumberUtil != null && leniency != null) {
            if (j4 >= 0) {
                this.f32834a = phoneNumberUtil;
                this.f32835b = str == null ? "" : str;
                this.f32836c = str2;
                this.f32837d = leniency;
                this.f32838e = j4;
                return;
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb, String[] strArr) {
        int length;
        String[] split = PhoneNumberUtil.C.split(sb.toString());
        if (phoneNumber.hasExtension()) {
            length = split.length - 2;
        } else {
            length = split.length - 1;
        }
        if (split.length == 1 || split[length].contains(phoneNumberUtil.getNationalSignificantNumber(phoneNumber))) {
            return true;
        }
        int length2 = strArr.length - 1;
        while (length2 > 0 && length >= 0) {
            if (!split[length].equals(strArr[length2])) {
                return false;
            }
            length2--;
            length--;
        }
        if (length >= 0 && split[length].endsWith(strArr[0])) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder sb, String[] strArr) {
        int i4;
        if (phoneNumber.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            String num = Integer.toString(phoneNumber.getCountryCode());
            i4 = sb.indexOf(num) + num.length();
        } else {
            i4 = 0;
        }
        for (int i5 = 0; i5 < strArr.length; i5++) {
            int indexOf = sb.indexOf(strArr[i5], i4);
            if (indexOf < 0) {
                return false;
            }
            i4 = indexOf + strArr[i5].length();
            if (i5 == 0 && i4 < sb.length() && phoneNumberUtil.getNddPrefixForRegion(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()), true) != null && Character.isDigit(sb.charAt(i4))) {
                return sb.substring(i4 - strArr[i5].length()).startsWith(phoneNumberUtil.getNationalSignificantNumber(phoneNumber));
            }
        }
        return sb.substring(i4).contains(phoneNumber.getExtension());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil, NumberGroupingChecker numberGroupingChecker) {
        StringBuilder J = PhoneNumberUtil.J(str, true);
        if (numberGroupingChecker.a(phoneNumberUtil, phoneNumber, J, i(phoneNumberUtil, phoneNumber, null))) {
            return true;
        }
        Phonemetadata.PhoneMetadata b4 = MetadataManager.b(phoneNumber.getCountryCode());
        if (b4 != null) {
            for (Phonemetadata.NumberFormat numberFormat : b4.numberFormats()) {
                if (numberGroupingChecker.a(phoneNumberUtil, phoneNumber, J, i(phoneNumberUtil, phoneNumber, numberFormat))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Phonenumber.PhoneNumber phoneNumber, String str) {
        int indexOf;
        boolean z3;
        int indexOf2 = str.indexOf(47);
        if (indexOf2 < 0 || (indexOf = str.indexOf(47, indexOf2 + 1)) < 0) {
            return false;
        }
        if (phoneNumber.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN && phoneNumber.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3 || !PhoneNumberUtil.normalizeDigitsOnly(str.substring(0, indexOf2)).equals(Integer.toString(phoneNumber.getCountryCode()))) {
            return true;
        }
        return str.substring(indexOf + 1).contains(RemoteSettings.FORWARD_SLASH_STRING);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Phonenumber.PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
        int i4 = 0;
        while (i4 < str.length() - 1) {
            char charAt = str.charAt(i4);
            if (charAt == 'x' || charAt == 'X') {
                int i5 = i4 + 1;
                char charAt2 = str.charAt(i5);
                if (charAt2 != 'x' && charAt2 != 'X') {
                    if (!PhoneNumberUtil.normalizeDigitsOnly(str.substring(i4)).equals(phoneNumber.getExtension())) {
                        return false;
                    }
                } else if (phoneNumberUtil.isNumberMatch(phoneNumber, str.substring(i5)) != PhoneNumberUtil.MatchType.NSN_MATCH) {
                    return false;
                } else {
                    i4 = i5;
                }
            }
            i4++;
        }
        return true;
    }

    private PhoneNumberMatch f(String str, int i4) {
        for (Pattern pattern : f32832o) {
            Matcher matcher = pattern.matcher(str);
            boolean z3 = true;
            while (matcher.find() && this.f32838e > 0) {
                if (z3) {
                    PhoneNumberMatch o4 = o(p(PhoneNumberUtil.f32861v, str.substring(0, matcher.start())).toString(), i4);
                    if (o4 != null) {
                        return o4;
                    }
                    this.f32838e--;
                    z3 = false;
                }
                PhoneNumberMatch o5 = o(p(PhoneNumberUtil.f32861v, matcher.group(1)).toString(), matcher.start(1) + i4);
                if (o5 != null) {
                    return o5;
                }
                this.f32838e--;
            }
        }
        return null;
    }

    private PhoneNumberMatch g(CharSequence charSequence, int i4) {
        if (f32828k.matcher(charSequence).find()) {
            return null;
        }
        if (f32829l.matcher(charSequence).find()) {
            if (f32830m.matcher(this.f32835b.toString().substring(charSequence.length() + i4)).lookingAt()) {
                return null;
            }
        }
        String charSequence2 = charSequence.toString();
        PhoneNumberMatch o4 = o(charSequence2, i4);
        if (o4 != null) {
            return o4;
        }
        return f(charSequence2, i4);
    }

    private PhoneNumberMatch h(int i4) {
        Matcher matcher = f32826i.matcher(this.f32835b);
        while (this.f32838e > 0 && matcher.find(i4)) {
            int start = matcher.start();
            CharSequence p4 = p(PhoneNumberUtil.f32860u, this.f32835b.subSequence(start, matcher.end()));
            PhoneNumberMatch g4 = g(p4, start);
            if (g4 != null) {
                return g4;
            }
            i4 = start + p4.length();
            this.f32838e--;
        }
        return null;
    }

    private static String[] i(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, Phonemetadata.NumberFormat numberFormat) {
        if (numberFormat == null) {
            String format = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.RFC3966);
            int indexOf = format.indexOf(59);
            if (indexOf < 0) {
                indexOf = format.length();
            }
            return format.substring(format.indexOf(45) + 1, indexOf).split("-");
        }
        return phoneNumberUtil.k(phoneNumberUtil.getNationalSignificantNumber(phoneNumber), numberFormat, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split("-");
    }

    private static boolean j(char c4) {
        if (c4 != '%' && Character.getType(c4) != 26) {
            return false;
        }
        return true;
    }

    static boolean k(char c4) {
        if (!Character.isLetter(c4) && Character.getType(c4) != 6) {
            return false;
        }
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c4);
        if (!of.equals(Character.UnicodeBlock.BASIC_LATIN) && !of.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) && !of.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) && !of.equals(Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) && !of.equals(Character.UnicodeBlock.LATIN_EXTENDED_B) && !of.equals(Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(Phonenumber.PhoneNumber phoneNumber, PhoneNumberUtil phoneNumberUtil) {
        Phonemetadata.PhoneMetadata p4;
        if (phoneNumber.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY || (p4 = phoneNumberUtil.p(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()))) == null) {
            return true;
        }
        Phonemetadata.NumberFormat d4 = phoneNumberUtil.d(p4.numberFormats(), phoneNumberUtil.getNationalSignificantNumber(phoneNumber));
        if (d4 == null || d4.getNationalPrefixFormattingRule().length() <= 0 || d4.isNationalPrefixOptionalWhenFormatting() || PhoneNumberUtil.m(d4.getNationalPrefixFormattingRule())) {
            return true;
        }
        return phoneNumberUtil.G(new StringBuilder(PhoneNumberUtil.normalizeDigitsOnly(phoneNumber.getRawInput())), p4, null);
    }

    private static String m(int i4, int i5) {
        if (i4 >= 0 && i5 > 0 && i5 >= i4) {
            return "{" + i4 + "," + i5 + "}";
        }
        throw new IllegalArgumentException();
    }

    private PhoneNumberMatch o(String str, int i4) {
        try {
            if (f32831n.matcher(str).matches() && !f32827j.matcher(str).find()) {
                if (this.f32837d.compareTo(PhoneNumberUtil.Leniency.VALID) >= 0) {
                    if (i4 > 0 && !f32833p.matcher(str).lookingAt()) {
                        char charAt = this.f32835b.charAt(i4 - 1);
                        if (j(charAt) || k(charAt)) {
                            return null;
                        }
                    }
                    int length = str.length() + i4;
                    if (length < this.f32835b.length()) {
                        char charAt2 = this.f32835b.charAt(length);
                        if (j(charAt2) || k(charAt2)) {
                            return null;
                        }
                    }
                }
                Phonenumber.PhoneNumber parseAndKeepRawInput = this.f32834a.parseAndKeepRawInput(str, this.f32836c);
                if ((!this.f32834a.getRegionCodeForCountryCode(parseAndKeepRawInput.getCountryCode()).equals("IL") || this.f32834a.getNationalSignificantNumber(parseAndKeepRawInput).length() != 4 || (i4 != 0 && (i4 <= 0 || this.f32835b.charAt(i4 - 1) == '*'))) && this.f32837d.a(parseAndKeepRawInput, str, this.f32834a)) {
                    parseAndKeepRawInput.clearCountryCodeSource();
                    parseAndKeepRawInput.clearRawInput();
                    parseAndKeepRawInput.clearPreferredDomesticCarrierCode();
                    return new PhoneNumberMatch(i4, str, parseAndKeepRawInput);
                }
            }
        } catch (NumberParseException unused) {
        }
        return null;
    }

    private static CharSequence p(Pattern pattern, CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        if (matcher.find()) {
            return charSequence.subSequence(0, matcher.start());
        }
        return charSequence;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f32839f == State.NOT_READY) {
            PhoneNumberMatch h4 = h(this.f32841h);
            this.f32840g = h4;
            if (h4 == null) {
                this.f32839f = State.DONE;
            } else {
                this.f32841h = h4.end();
                this.f32839f = State.READY;
            }
        }
        if (this.f32839f == State.READY) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    /* renamed from: n */
    public PhoneNumberMatch next() {
        if (hasNext()) {
            PhoneNumberMatch phoneNumberMatch = this.f32840g;
            this.f32840g = null;
            this.f32839f = State.NOT_READY;
            return phoneNumberMatch;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
