package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class AsYouTypeFormatter {

    /* renamed from: k  reason: collision with root package name */
    private String f32798k;

    /* renamed from: l  reason: collision with root package name */
    private Phonemetadata.PhoneMetadata f32799l;

    /* renamed from: m  reason: collision with root package name */
    private Phonemetadata.PhoneMetadata f32800m;

    /* renamed from: w  reason: collision with root package name */
    private static final Phonemetadata.PhoneMetadata f32784w = new Phonemetadata.PhoneMetadata().setInternationalPrefix("NA");

    /* renamed from: x  reason: collision with root package name */
    private static final Pattern f32785x = Pattern.compile("\\[([^\\[\\]])*\\]");

    /* renamed from: y  reason: collision with root package name */
    private static final Pattern f32786y = Pattern.compile("\\d(?=[^,}][^,}])");

    /* renamed from: z  reason: collision with root package name */
    private static final Pattern f32787z = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*)+");
    private static final Pattern A = Pattern.compile("[- ]");
    private static final Pattern B = Pattern.compile("\u2008");

    /* renamed from: a  reason: collision with root package name */
    private String f32788a = "";

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f32789b = new StringBuilder();

    /* renamed from: c  reason: collision with root package name */
    private String f32790c = "";

    /* renamed from: d  reason: collision with root package name */
    private StringBuilder f32791d = new StringBuilder();

    /* renamed from: e  reason: collision with root package name */
    private StringBuilder f32792e = new StringBuilder();

    /* renamed from: f  reason: collision with root package name */
    private boolean f32793f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32794g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f32795h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f32796i = false;

    /* renamed from: j  reason: collision with root package name */
    private final PhoneNumberUtil f32797j = PhoneNumberUtil.getInstance();

    /* renamed from: n  reason: collision with root package name */
    private int f32801n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f32802o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f32803p = 0;

    /* renamed from: q  reason: collision with root package name */
    private StringBuilder f32804q = new StringBuilder();

    /* renamed from: r  reason: collision with root package name */
    private boolean f32805r = false;

    /* renamed from: s  reason: collision with root package name */
    private String f32806s = "";

    /* renamed from: t  reason: collision with root package name */
    private StringBuilder f32807t = new StringBuilder();

    /* renamed from: u  reason: collision with root package name */
    private List<Phonemetadata.NumberFormat> f32808u = new ArrayList();

    /* renamed from: v  reason: collision with root package name */
    private RegexCache f32809v = new RegexCache(64);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsYouTypeFormatter(String str) {
        this.f32798k = str;
        Phonemetadata.PhoneMetadata k4 = k(str);
        this.f32800m = k4;
        this.f32799l = k4;
    }

    private boolean a() {
        if (this.f32806s.length() > 0) {
            this.f32807t.insert(0, this.f32806s);
            this.f32804q.setLength(this.f32804q.lastIndexOf(this.f32806s));
        }
        return !this.f32806s.equals(u());
    }

    private String b(String str) {
        int length = this.f32804q.length();
        if (this.f32805r && length > 0 && this.f32804q.charAt(length - 1) != ' ') {
            return new String(this.f32804q) + ' ' + str;
        }
        return ((Object) this.f32804q) + str;
    }

    private String c() {
        if (this.f32807t.length() >= 3) {
            i(this.f32807t.toString());
            String g4 = g();
            if (g4.length() > 0) {
                return g4;
            }
            if (r()) {
                return l();
            }
            return this.f32791d.toString();
        }
        return b(this.f32807t.toString());
    }

    private String d() {
        this.f32793f = true;
        this.f32796i = false;
        this.f32808u.clear();
        this.f32801n = 0;
        this.f32789b.setLength(0);
        this.f32790c = "";
        return c();
    }

    private boolean e() {
        StringBuilder sb;
        int g4;
        if (this.f32807t.length() == 0 || (g4 = this.f32797j.g(this.f32807t, (sb = new StringBuilder()))) == 0) {
            return false;
        }
        this.f32807t.setLength(0);
        this.f32807t.append((CharSequence) sb);
        String regionCodeForCountryCode = this.f32797j.getRegionCodeForCountryCode(g4);
        if (PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(regionCodeForCountryCode)) {
            this.f32800m = this.f32797j.o(g4);
        } else if (!regionCodeForCountryCode.equals(this.f32798k)) {
            this.f32800m = k(regionCodeForCountryCode);
        }
        String num = Integer.toString(g4);
        StringBuilder sb2 = this.f32804q;
        sb2.append(num);
        sb2.append(' ');
        this.f32806s = "";
        return true;
    }

    private boolean f() {
        RegexCache regexCache = this.f32809v;
        Matcher matcher = regexCache.getPatternForRegex("\\+|" + this.f32800m.getInternationalPrefix()).matcher(this.f32792e);
        if (!matcher.lookingAt()) {
            return false;
        }
        this.f32795h = true;
        int end = matcher.end();
        this.f32807t.setLength(0);
        this.f32807t.append(this.f32792e.substring(end));
        this.f32804q.setLength(0);
        this.f32804q.append(this.f32792e.substring(0, end));
        if (this.f32792e.charAt(0) != '+') {
            this.f32804q.append(' ');
        }
        return true;
    }

    private boolean h(Phonemetadata.NumberFormat numberFormat) {
        String pattern = numberFormat.getPattern();
        if (pattern.indexOf(124) != -1) {
            return false;
        }
        String replaceAll = f32786y.matcher(f32785x.matcher(pattern).replaceAll("\\\\d")).replaceAll("\\\\d");
        this.f32789b.setLength(0);
        String j4 = j(replaceAll, numberFormat.getFormat());
        if (j4.length() <= 0) {
            return false;
        }
        this.f32789b.append(j4);
        return true;
    }

    private void i(String str) {
        List<Phonemetadata.NumberFormat> numberFormats;
        if (this.f32795h && this.f32800m.intlNumberFormatSize() > 0) {
            numberFormats = this.f32800m.intlNumberFormats();
        } else {
            numberFormats = this.f32800m.numberFormats();
        }
        boolean hasNationalPrefix = this.f32800m.hasNationalPrefix();
        for (Phonemetadata.NumberFormat numberFormat : numberFormats) {
            if (!hasNationalPrefix || this.f32795h || numberFormat.isNationalPrefixOptionalWhenFormatting() || PhoneNumberUtil.m(numberFormat.getNationalPrefixFormattingRule())) {
                if (p(numberFormat.getFormat())) {
                    this.f32808u.add(numberFormat);
                }
            }
        }
        s(str);
    }

    private String j(String str, String str2) {
        Matcher matcher = this.f32809v.getPatternForRegex(str).matcher("999999999999999");
        matcher.find();
        String group = matcher.group();
        if (group.length() < this.f32807t.length()) {
            return "";
        }
        return group.replaceAll(str, str2).replaceAll("9", "\u2008");
    }

    private Phonemetadata.PhoneMetadata k(String str) {
        Phonemetadata.PhoneMetadata p4 = this.f32797j.p(this.f32797j.getRegionCodeForCountryCode(this.f32797j.getCountryCodeForRegion(str)));
        if (p4 != null) {
            return p4;
        }
        return f32784w;
    }

    private String l() {
        int length = this.f32807t.length();
        if (length > 0) {
            String str = "";
            for (int i4 = 0; i4 < length; i4++) {
                str = m(this.f32807t.charAt(i4));
            }
            if (this.f32793f) {
                return b(str);
            }
            return this.f32791d.toString();
        }
        return this.f32804q.toString();
    }

    private String m(char c4) {
        Matcher matcher = B.matcher(this.f32789b);
        if (matcher.find(this.f32801n)) {
            String replaceFirst = matcher.replaceFirst(Character.toString(c4));
            this.f32789b.replace(0, replaceFirst.length(), replaceFirst);
            int start = matcher.start();
            this.f32801n = start;
            return this.f32789b.substring(0, start + 1);
        }
        if (this.f32808u.size() == 1) {
            this.f32793f = false;
        }
        this.f32790c = "";
        return this.f32791d.toString();
    }

    private String n(char c4, boolean z3) {
        this.f32791d.append(c4);
        if (z3) {
            this.f32802o = this.f32791d.length();
        }
        if (!o(c4)) {
            this.f32793f = false;
            this.f32794g = true;
        } else {
            c4 = t(c4, z3);
        }
        if (!this.f32793f) {
            if (this.f32794g) {
                return this.f32791d.toString();
            }
            if (f()) {
                if (e()) {
                    return d();
                }
            } else if (a()) {
                this.f32804q.append(' ');
                return d();
            }
            return this.f32791d.toString();
        }
        int length = this.f32792e.length();
        if (length != 0 && length != 1 && length != 2) {
            if (length == 3) {
                if (f()) {
                    this.f32796i = true;
                } else {
                    this.f32806s = u();
                    return c();
                }
            }
            if (this.f32796i) {
                if (e()) {
                    this.f32796i = false;
                }
                return ((Object) this.f32804q) + this.f32807t.toString();
            } else if (this.f32808u.size() > 0) {
                String m4 = m(c4);
                String g4 = g();
                if (g4.length() > 0) {
                    return g4;
                }
                s(this.f32807t.toString());
                if (r()) {
                    return l();
                }
                if (this.f32793f) {
                    return b(m4);
                }
                return this.f32791d.toString();
            } else {
                return c();
            }
        }
        return this.f32791d.toString();
    }

    private boolean o(char c4) {
        if (Character.isDigit(c4)) {
            return true;
        }
        if (this.f32791d.length() == 1 && PhoneNumberUtil.f32856q.matcher(Character.toString(c4)).matches()) {
            return true;
        }
        return false;
    }

    private boolean p(String str) {
        return f32787z.matcher(str).matches();
    }

    private boolean q() {
        if (this.f32800m.getCountryCode() != 1 || this.f32807t.charAt(0) != '1' || this.f32807t.charAt(1) == '0' || this.f32807t.charAt(1) == '1') {
            return false;
        }
        return true;
    }

    private boolean r() {
        Iterator<Phonemetadata.NumberFormat> it = this.f32808u.iterator();
        while (it.hasNext()) {
            Phonemetadata.NumberFormat next = it.next();
            String pattern = next.getPattern();
            if (this.f32790c.equals(pattern)) {
                return false;
            }
            if (h(next)) {
                this.f32790c = pattern;
                this.f32805r = A.matcher(next.getNationalPrefixFormattingRule()).find();
                this.f32801n = 0;
                return true;
            }
            it.remove();
        }
        this.f32793f = false;
        return false;
    }

    private void s(String str) {
        int length = str.length() - 3;
        Iterator<Phonemetadata.NumberFormat> it = this.f32808u.iterator();
        while (it.hasNext()) {
            Phonemetadata.NumberFormat next = it.next();
            if (next.leadingDigitsPatternSize() != 0) {
                if (!this.f32809v.getPatternForRegex(next.getLeadingDigitsPattern(Math.min(length, next.leadingDigitsPatternSize() - 1))).matcher(str).lookingAt()) {
                    it.remove();
                }
            }
        }
    }

    private char t(char c4, boolean z3) {
        if (c4 == '+') {
            this.f32792e.append(c4);
        } else {
            c4 = Character.forDigit(Character.digit(c4, 10), 10);
            this.f32792e.append(c4);
            this.f32807t.append(c4);
        }
        if (z3) {
            this.f32803p = this.f32792e.length();
        }
        return c4;
    }

    private String u() {
        int i4 = 1;
        if (q()) {
            StringBuilder sb = this.f32804q;
            sb.append('1');
            sb.append(' ');
            this.f32795h = true;
        } else {
            if (this.f32800m.hasNationalPrefixForParsing()) {
                Matcher matcher = this.f32809v.getPatternForRegex(this.f32800m.getNationalPrefixForParsing()).matcher(this.f32807t);
                if (matcher.lookingAt() && matcher.end() > 0) {
                    this.f32795h = true;
                    i4 = matcher.end();
                    this.f32804q.append(this.f32807t.substring(0, i4));
                }
            }
            i4 = 0;
        }
        String substring = this.f32807t.substring(0, i4);
        this.f32807t.delete(0, i4);
        return substring;
    }

    public void clear() {
        this.f32788a = "";
        this.f32791d.setLength(0);
        this.f32792e.setLength(0);
        this.f32789b.setLength(0);
        this.f32801n = 0;
        this.f32790c = "";
        this.f32804q.setLength(0);
        this.f32806s = "";
        this.f32807t.setLength(0);
        this.f32793f = true;
        this.f32794g = false;
        this.f32803p = 0;
        this.f32802o = 0;
        this.f32795h = false;
        this.f32796i = false;
        this.f32808u.clear();
        this.f32805r = false;
        if (!this.f32800m.equals(this.f32799l)) {
            this.f32800m = k(this.f32798k);
        }
    }

    String g() {
        for (Phonemetadata.NumberFormat numberFormat : this.f32808u) {
            Matcher matcher = this.f32809v.getPatternForRegex(numberFormat.getPattern()).matcher(this.f32807t);
            if (matcher.matches()) {
                this.f32805r = A.matcher(numberFormat.getNationalPrefixFormattingRule()).find();
                return b(matcher.replaceAll(numberFormat.getFormat()));
            }
        }
        return "";
    }

    public int getRememberedPosition() {
        if (!this.f32793f) {
            return this.f32802o;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.f32803p && i5 < this.f32788a.length()) {
            if (this.f32792e.charAt(i4) == this.f32788a.charAt(i5)) {
                i4++;
            }
            i5++;
        }
        return i5;
    }

    public String inputDigit(char c4) {
        String n4 = n(c4, false);
        this.f32788a = n4;
        return n4;
    }

    public String inputDigitAndRememberPosition(char c4) {
        String n4 = n(c4, true);
        this.f32788a = n4;
        return n4;
    }
}
