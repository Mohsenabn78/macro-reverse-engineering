package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.BitSet;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public abstract class CharMatcher implements Predicate<Character> {
    public static final CharMatcher ANY;
    public static final CharMatcher DIGIT;
    public static final CharMatcher INVISIBLE;
    public static final CharMatcher JAVA_DIGIT;
    public static final CharMatcher JAVA_ISO_CONTROL;
    public static final CharMatcher JAVA_LETTER;
    public static final CharMatcher JAVA_LETTER_OR_DIGIT;
    public static final CharMatcher JAVA_LOWER_CASE;
    public static final CharMatcher JAVA_UPPER_CASE;
    public static final CharMatcher NONE;
    public static final CharMatcher SINGLE_WIDTH;
    public static final CharMatcher WHITESPACE;

    /* renamed from: b  reason: collision with root package name */
    private static final String f25922b;

    /* renamed from: c  reason: collision with root package name */
    static final int f25923c;

    /* renamed from: a  reason: collision with root package name */
    final String f25924a;
    public static final CharMatcher BREAKING_WHITESPACE = new CharMatcher() { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.1
        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (c4 != ' ' && c4 != 133 && c4 != 5760) {
                if (c4 == 8199) {
                    return false;
                }
                if (c4 != 8287 && c4 != 12288 && c4 != 8232 && c4 != 8233) {
                    switch (c4) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            if (c4 >= 8192 && c4 <= 8202) {
                                return true;
                            }
                            return false;
                    }
                }
            }
            return true;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.BREAKING_WHITESPACE";
        }
    };
    public static final CharMatcher ASCII = b(0, Ascii.MAX, "CharMatcher.ASCII");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class And extends CharMatcher {

        /* renamed from: d  reason: collision with root package name */
        final CharMatcher f25933d;

        /* renamed from: e  reason: collision with root package name */
        final CharMatcher f25934e;

        And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this(charMatcher, charMatcher2, "CharMatcher.and(" + charMatcher + ", " + charMatcher2 + ")");
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        @GwtIncompatible("java.util.BitSet")
        void g(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f25933d.g(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.f25934e.g(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        CharMatcher i(String str) {
            return new And(this.f25933d, this.f25934e, str);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (this.f25933d.matches(c4) && this.f25934e.matches(c4)) {
                return true;
            }
            return false;
        }

        And(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.f25933d = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f25934e = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible("java.util.BitSet")
    /* loaded from: classes5.dex */
    public static class BitSetMatcher extends FastMatcher {

        /* renamed from: d  reason: collision with root package name */
        private final BitSet f25935d;

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        void g(BitSet bitSet) {
            bitSet.or(this.f25935d);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return this.f25935d.get(c4);
        }

        private BitSetMatcher(BitSet bitSet, String str) {
            super(str);
            this.f25935d = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FastMatcher(String str) {
            super(str);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class NegatedFastMatcher extends NegatedMatcher {
        NegatedFastMatcher(CharMatcher charMatcher) {
            super(charMatcher);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher.NegatedMatcher, com.google.api.client.repackaged.com.google.common.base.CharMatcher
        CharMatcher i(String str) {
            return new NegatedFastMatcher(str, this.f25936d);
        }

        NegatedFastMatcher(String str, CharMatcher charMatcher) {
            super(str, charMatcher);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static class RangesMatcher extends CharMatcher {

        /* renamed from: d  reason: collision with root package name */
        private final char[] f25939d;

        /* renamed from: e  reason: collision with root package name */
        private final char[] f25940e;

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            super(str);
            boolean z3;
            boolean z4;
            boolean z5;
            this.f25939d = cArr;
            this.f25940e = cArr2;
            if (cArr.length == cArr2.length) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            int i4 = 0;
            while (i4 < cArr.length) {
                if (cArr[i4] <= cArr2[i4]) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Preconditions.checkArgument(z4);
                int i5 = i4 + 1;
                if (i5 < cArr.length) {
                    if (cArr2[i4] < cArr[i5]) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Preconditions.checkArgument(z5);
                }
                i4 = i5;
            }
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            int binarySearch = Arrays.binarySearch(this.f25939d, c4);
            if (binarySearch >= 0) {
                return true;
            }
            int i4 = (~binarySearch) - 1;
            if (i4 >= 0 && c4 <= this.f25940e[i4]) {
                return true;
            }
            return false;
        }
    }

    static {
        StringBuilder sb = new StringBuilder(31);
        for (int i4 = 0; i4 < 31; i4++) {
            sb.append((char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i4) + '\t'));
        }
        String sb2 = sb.toString();
        f25922b = sb2;
        DIGIT = new RangesMatcher("CharMatcher.DIGIT", "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray(), sb2.toCharArray());
        JAVA_DIGIT = new CharMatcher("CharMatcher.JAVA_DIGIT") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.2
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
            public /* bridge */ /* synthetic */ boolean apply(Character ch) {
                return super.apply(ch);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return Character.isDigit(c4);
            }
        };
        JAVA_LETTER = new CharMatcher("CharMatcher.JAVA_LETTER") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.3
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
            public /* bridge */ /* synthetic */ boolean apply(Character ch) {
                return super.apply(ch);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return Character.isLetter(c4);
            }
        };
        JAVA_LETTER_OR_DIGIT = new CharMatcher("CharMatcher.JAVA_LETTER_OR_DIGIT") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.4
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
            public /* bridge */ /* synthetic */ boolean apply(Character ch) {
                return super.apply(ch);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return Character.isLetterOrDigit(c4);
            }
        };
        JAVA_UPPER_CASE = new CharMatcher("CharMatcher.JAVA_UPPER_CASE") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.5
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
            public /* bridge */ /* synthetic */ boolean apply(Character ch) {
                return super.apply(ch);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return Character.isUpperCase(c4);
            }
        };
        JAVA_LOWER_CASE = new CharMatcher("CharMatcher.JAVA_LOWER_CASE") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.6
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
            public /* bridge */ /* synthetic */ boolean apply(Character ch) {
                return super.apply(ch);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return Character.isLowerCase(c4);
            }
        };
        JAVA_ISO_CONTROL = inRange((char) 0, (char) 31).or(inRange(Ascii.MAX, (char) 159)).i("CharMatcher.JAVA_ISO_CONTROL");
        INVISIBLE = new RangesMatcher("CharMatcher.INVISIBLE", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        SINGLE_WIDTH = new RangesMatcher("CharMatcher.SINGLE_WIDTH", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺\ufdff\ufeffￜ".toCharArray());
        ANY = new FastMatcher("CharMatcher.ANY") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.7
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher and(CharMatcher charMatcher) {
                return (CharMatcher) Preconditions.checkNotNull(charMatcher);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String collapseFrom(CharSequence charSequence, char c4) {
                if (charSequence.length() == 0) {
                    return "";
                }
                return String.valueOf(c4);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int countIn(CharSequence charSequence) {
                return charSequence.length();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int indexIn(CharSequence charSequence) {
                return charSequence.length() == 0 ? -1 : 0;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int lastIndexIn(CharSequence charSequence) {
                return charSequence.length() - 1;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return true;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matchesAllOf(CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return true;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matchesNoneOf(CharSequence charSequence) {
                if (charSequence.length() == 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher.FastMatcher, com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher negate() {
                return CharMatcher.NONE;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher or(CharMatcher charMatcher) {
                Preconditions.checkNotNull(charMatcher);
                return this;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String removeFrom(CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return "";
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String replaceFrom(CharSequence charSequence, char c4) {
                char[] cArr = new char[charSequence.length()];
                Arrays.fill(cArr, c4);
                return new String(cArr);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String trimFrom(CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return "";
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int indexIn(CharSequence charSequence, int i5) {
                int length = charSequence.length();
                Preconditions.checkPositionIndex(i5, length);
                if (i5 == length) {
                    return -1;
                }
                return i5;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
                StringBuilder sb3 = new StringBuilder(charSequence.length() * charSequence2.length());
                for (int i5 = 0; i5 < charSequence.length(); i5++) {
                    sb3.append(charSequence2);
                }
                return sb3.toString();
            }
        };
        NONE = new FastMatcher("CharMatcher.NONE") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.8
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher and(CharMatcher charMatcher) {
                Preconditions.checkNotNull(charMatcher);
                return this;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String collapseFrom(CharSequence charSequence, char c4) {
                return charSequence.toString();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int countIn(CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return 0;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int indexIn(CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return -1;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int lastIndexIn(CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return -1;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return false;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matchesAllOf(CharSequence charSequence) {
                if (charSequence.length() == 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matchesNoneOf(CharSequence charSequence) {
                Preconditions.checkNotNull(charSequence);
                return true;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher.FastMatcher, com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher negate() {
                return CharMatcher.ANY;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher or(CharMatcher charMatcher) {
                return (CharMatcher) Preconditions.checkNotNull(charMatcher);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String removeFrom(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String replaceFrom(CharSequence charSequence, char c4) {
                return charSequence.toString();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String trimFrom(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String trimLeadingFrom(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String trimTrailingFrom(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public int indexIn(CharSequence charSequence, int i5) {
                Preconditions.checkPositionIndex(i5, charSequence.length());
                return -1;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
                Preconditions.checkNotNull(charSequence2);
                return charSequence.toString();
            }
        };
        f25923c = Integer.numberOfLeadingZeros(31);
        WHITESPACE = new FastMatcher("WHITESPACE") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.15
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            @GwtIncompatible("java.util.BitSet")
            void g(BitSet bitSet) {
                for (int i5 = 0; i5 < 32; i5++) {
                    bitSet.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt(i5));
                }
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                if ("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c4) >>> CharMatcher.f25923c) == c4) {
                    return true;
                }
                return false;
            }
        };
    }

    CharMatcher(String str) {
        this.f25924a = str;
    }

    private String a(CharSequence charSequence, int i4, int i5, char c4, StringBuilder sb, boolean z3) {
        while (i4 < i5) {
            char charAt = charSequence.charAt(i4);
            if (matches(charAt)) {
                if (!z3) {
                    sb.append(c4);
                    z3 = true;
                }
            } else {
                sb.append(charAt);
                z3 = false;
            }
            i4++;
        }
        return sb.toString();
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            if (length != 1) {
                if (length != 2) {
                    final char[] charArray = charSequence.toString().toCharArray();
                    Arrays.sort(charArray);
                    StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
                    for (char c4 : charArray) {
                        sb.append(h(c4));
                    }
                    sb.append("\")");
                    return new CharMatcher(sb.toString()) { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.11
                        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
                        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
                            return super.apply(ch);
                        }

                        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
                        @GwtIncompatible("java.util.BitSet")
                        void g(BitSet bitSet) {
                            for (char c5 : charArray) {
                                bitSet.set(c5);
                            }
                        }

                        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
                        public boolean matches(char c5) {
                            if (Arrays.binarySearch(charArray, c5) >= 0) {
                                return true;
                            }
                            return false;
                        }
                    };
                }
                return c(charSequence.charAt(0), charSequence.charAt(1));
            }
            return is(charSequence.charAt(0));
        }
        return NONE;
    }

    static CharMatcher b(final char c4, final char c5, String str) {
        return new FastMatcher(str) { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.13
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            @GwtIncompatible("java.util.BitSet")
            void g(BitSet bitSet) {
                bitSet.set(c4, c5 + 1);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c6) {
                if (c4 <= c6 && c6 <= c5) {
                    return true;
                }
                return false;
            }
        };
    }

    private static CharMatcher c(final char c4, final char c5) {
        return new FastMatcher("CharMatcher.anyOf(\"" + h(c4) + h(c5) + "\")") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.12
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            @GwtIncompatible("java.util.BitSet")
            void g(BitSet bitSet) {
                bitSet.set(c4);
                bitSet.set(c5);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c6) {
                if (c6 != c4 && c6 != c5) {
                    return false;
                }
                return true;
            }
        };
    }

    @GwtIncompatible("SmallCharMatcher")
    private static boolean d(int i4, int i5) {
        if (i4 <= 1023 && i5 > i4 * 4 * 16) {
            return true;
        }
        return false;
    }

    @GwtIncompatible("java.util.BitSet")
    private static CharMatcher f(int i4, BitSet bitSet, String str) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (d(i4, bitSet.length())) {
                        return SmallCharMatcher.l(bitSet, str);
                    }
                    return new BitSetMatcher(bitSet, str);
                }
                char nextSetBit = (char) bitSet.nextSetBit(0);
                return c(nextSetBit, (char) bitSet.nextSetBit(nextSetBit + 1));
            }
            return is((char) bitSet.nextSetBit(0));
        }
        return NONE;
    }

    public static CharMatcher forPredicate(final Predicate<? super Character> predicate) {
        Preconditions.checkNotNull(predicate);
        if (predicate instanceof CharMatcher) {
            return (CharMatcher) predicate;
        }
        return new CharMatcher("CharMatcher.forPredicate(" + predicate + ")") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.14
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c4) {
                return predicate.apply(Character.valueOf(c4));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
            public boolean apply(Character ch) {
                return predicate.apply(Preconditions.checkNotNull(ch));
            }
        };
    }

    private static String h(char c4) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i4 = 0; i4 < 4; i4++) {
            cArr[5 - i4] = "0123456789ABCDEF".charAt(c4 & 15);
            c4 = (char) (c4 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher inRange(char c4, char c5) {
        boolean z3;
        if (c5 >= c4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        return b(c4, c5, "CharMatcher.inRange('" + h(c4) + "', '" + h(c5) + "')");
    }

    public static CharMatcher is(final char c4) {
        return new FastMatcher("CharMatcher.is('" + h(c4) + "')") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.9
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher and(CharMatcher charMatcher) {
                if (charMatcher.matches(c4)) {
                    return this;
                }
                return CharMatcher.NONE;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            @GwtIncompatible("java.util.BitSet")
            void g(BitSet bitSet) {
                bitSet.set(c4);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c5) {
                if (c5 == c4) {
                    return true;
                }
                return false;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher.FastMatcher, com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher negate() {
                return CharMatcher.isNot(c4);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher or(CharMatcher charMatcher) {
                if (!charMatcher.matches(c4)) {
                    return super.or(charMatcher);
                }
                return charMatcher;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public String replaceFrom(CharSequence charSequence, char c5) {
                return charSequence.toString().replace(c4, c5);
            }
        };
    }

    public static CharMatcher isNot(final char c4) {
        return new FastMatcher("CharMatcher.isNot('" + h(c4) + "')") { // from class: com.google.api.client.repackaged.com.google.common.base.CharMatcher.10
            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher and(CharMatcher charMatcher) {
                if (charMatcher.matches(c4)) {
                    return super.and(charMatcher);
                }
                return charMatcher;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            @GwtIncompatible("java.util.BitSet")
            void g(BitSet bitSet) {
                bitSet.set(0, c4);
                bitSet.set(c4 + 1, 65536);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public boolean matches(char c5) {
                if (c5 != c4) {
                    return true;
                }
                return false;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher.FastMatcher, com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher negate() {
                return CharMatcher.is(c4);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
            public CharMatcher or(CharMatcher charMatcher) {
                if (charMatcher.matches(c4)) {
                    return CharMatcher.ANY;
                }
                return this;
            }
        };
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new And(this, (CharMatcher) Preconditions.checkNotNull(charMatcher));
    }

    @CheckReturnValue
    public String collapseFrom(CharSequence charSequence, char c4) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt = charSequence.charAt(i4);
            if (matches(charAt)) {
                if (charAt == c4 && (i4 == length - 1 || !matches(charSequence.charAt(i4 + 1)))) {
                    i4++;
                } else {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence.subSequence(0, i4));
                    sb.append(c4);
                    return a(charSequence, i4 + 1, length, c4, sb, true);
                }
            }
            i4++;
        }
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        int i4 = 0;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (matches(charSequence.charAt(i5))) {
                i4++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible("java.util.BitSet")
    public CharMatcher e() {
        String str;
        String str2;
        BitSet bitSet = new BitSet();
        g(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return f(cardinality, bitSet, this.f25924a);
        }
        bitSet.flip(0, 65536);
        int i4 = 65536 - cardinality;
        if (this.f25924a.endsWith(".negate()")) {
            str = this.f25924a.substring(0, str2.length() - 9);
        } else {
            str = this.f25924a + ".negate()";
        }
        return new NegatedFastMatcher(toString(), f(i4, bitSet, str));
    }

    @GwtIncompatible("java.util.BitSet")
    void g(BitSet bitSet) {
        for (int i4 = 65535; i4 >= 0; i4--) {
            if (matches((char) i4)) {
                bitSet.set(i4);
            }
        }
    }

    CharMatcher i(String str) {
        throw new UnsupportedOperationException();
    }

    public int indexIn(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (matches(charSequence.charAt(i4))) {
                return i4;
            }
        }
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean matches(char c4);

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        if (indexIn(charSequence) == -1) {
            return true;
        }
        return false;
    }

    public CharMatcher negate() {
        return new NegatedMatcher(this);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new Or(this, (CharMatcher) Preconditions.checkNotNull(charMatcher));
    }

    public CharMatcher precomputed() {
        return Platform.b(this);
    }

    @CheckReturnValue
    public String removeFrom(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i4 = 1;
        while (true) {
            indexIn++;
            while (indexIn != charArray.length) {
                if (matches(charArray[indexIn])) {
                    break;
                }
                charArray[indexIn - i4] = charArray[indexIn];
                indexIn++;
            }
            return new String(charArray, 0, indexIn - i4);
            i4++;
        }
    }

    @CheckReturnValue
    public String replaceFrom(CharSequence charSequence, char c4) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[indexIn] = c4;
        while (true) {
            indexIn++;
            if (indexIn < charArray.length) {
                if (matches(charArray[indexIn])) {
                    charArray[indexIn] = c4;
                }
            } else {
                return new String(charArray);
            }
        }
    }

    @CheckReturnValue
    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public String toString() {
        return this.f25924a;
    }

    @CheckReturnValue
    public String trimAndCollapseFrom(CharSequence charSequence, char c4) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && matches(charSequence.charAt(i4))) {
            i4++;
        }
        int i5 = length - 1;
        int i6 = i5;
        while (i6 > i4 && matches(charSequence.charAt(i6))) {
            i6--;
        }
        if (i4 == 0 && i6 == i5) {
            return collapseFrom(charSequence, c4);
        }
        int i7 = i6 + 1;
        return a(charSequence, i4, i7, c4, new StringBuilder(i7 - i4), false);
    }

    @CheckReturnValue
    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && matches(charSequence.charAt(i4))) {
            i4++;
        }
        int i5 = length - 1;
        while (i5 > i4 && matches(charSequence.charAt(i5))) {
            i5--;
        }
        return charSequence.subSequence(i4, i5 + 1).toString();
    }

    @CheckReturnValue
    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (!matches(charSequence.charAt(i4))) {
                return charSequence.subSequence(i4, length).toString();
            }
        }
        return "";
    }

    @CheckReturnValue
    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class NegatedMatcher extends CharMatcher {

        /* renamed from: d  reason: collision with root package name */
        final CharMatcher f25936d;

        NegatedMatcher(String str, CharMatcher charMatcher) {
            super(str);
            this.f25936d = charMatcher;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.f25936d.countIn(charSequence);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        @GwtIncompatible("java.util.BitSet")
        void g(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f25936d.g(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        CharMatcher i(String str) {
            return new NegatedMatcher(str, this.f25936d);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return !this.f25936d.matches(c4);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return this.f25936d.matchesNoneOf(charSequence);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.f25936d.matchesAllOf(charSequence);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return this.f25936d;
        }

        NegatedMatcher(CharMatcher charMatcher) {
            this(charMatcher + ".negate()", charMatcher);
        }
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Predicate
    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Or extends CharMatcher {

        /* renamed from: d  reason: collision with root package name */
        final CharMatcher f25937d;

        /* renamed from: e  reason: collision with root package name */
        final CharMatcher f25938e;

        Or(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.f25937d = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f25938e = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher, com.google.api.client.repackaged.com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        @GwtIncompatible("java.util.BitSet")
        void g(BitSet bitSet) {
            this.f25937d.g(bitSet);
            this.f25938e.g(bitSet);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        CharMatcher i(String str) {
            return new Or(this.f25937d, this.f25938e, str);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (!this.f25937d.matches(c4) && !this.f25938e.matches(c4)) {
                return false;
            }
            return true;
        }

        Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this(charMatcher, charMatcher2, "CharMatcher.or(" + charMatcher + ", " + charMatcher2 + ")");
        }
    }

    protected CharMatcher() {
        this.f25924a = super.toString();
    }

    public int indexIn(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i4, length);
        while (i4 < length) {
            if (matches(charSequence.charAt(i4))) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    @CheckReturnValue
    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i4 = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String charSequence3 = charSequence.toString();
        int indexIn = indexIn(charSequence3);
        if (indexIn == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append((CharSequence) charSequence3, i4, indexIn);
            sb.append(charSequence2);
            i4 = indexIn + 1;
            indexIn = indexIn(charSequence3, i4);
        } while (indexIn != -1);
        sb.append((CharSequence) charSequence3, i4, length2);
        return sb.toString();
    }
}
