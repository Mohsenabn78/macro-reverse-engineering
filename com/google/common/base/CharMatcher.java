package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class CharMatcher implements Predicate<Character> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class And extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        final CharMatcher f26272a;

        /* renamed from: b  reason: collision with root package name */
        final CharMatcher f26273b;

        And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f26272a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f26273b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f26272a.g(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.f26273b.g(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (this.f26272a.matches(c4) && this.f26273b.matches(c4)) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.and(" + this.f26272a + ", " + this.f26273b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Any extends NamedFastMatcher {

        /* renamed from: b  reason: collision with root package name */
        static final Any f26274b = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c4) {
            if (charSequence.length() == 0) {
                return "";
            }
            return String.valueOf(c4);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            if (charSequence.length() == 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c4) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c4);
            return new String(cArr);
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i4) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i4, length);
            if (i4 == length) {
                return -1;
            }
            return i4;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i4 = 0; i4 < charSequence.length(); i4++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AnyOf extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final char[] f26275a;

        public AnyOf(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f26275a = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            for (char c4 : this.f26275a) {
                bitSet.set(c4);
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (Arrays.binarySearch(this.f26275a, c4) >= 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c4 : this.f26275a) {
                sb.append(CharMatcher.h(c4));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* loaded from: classes5.dex */
    private static final class Ascii extends NamedFastMatcher {

        /* renamed from: b  reason: collision with root package name */
        static final Ascii f26276b = new Ascii();

        Ascii() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (c4 <= 127) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @J2ktIncompatible
    @GwtIncompatible
    /* loaded from: classes5.dex */
    public static final class BitSetMatcher extends NamedFastMatcher {

        /* renamed from: b  reason: collision with root package name */
        private final BitSet f26277b;

        @Override // com.google.common.base.CharMatcher
        void g(BitSet bitSet) {
            bitSet.or(this.f26277b);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return this.f26277b.get(c4);
        }

        private BitSetMatcher(BitSet bitSet, String str) {
            super(str);
            this.f26277b = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }
    }

    /* loaded from: classes5.dex */
    private static final class BreakingWhitespace extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        static final CharMatcher f26278a = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
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

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* loaded from: classes5.dex */
    private static final class Digit extends RangesMatcher {

        /* renamed from: d  reason: collision with root package name */
        static final Digit f26279d = new Digit();

        private Digit() {
            super("CharMatcher.digit()", j(), i());
        }

        private static char[] i() {
            char[] cArr = new char[37];
            for (int i4 = 0; i4 < 37; i4++) {
                cArr[i4] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i4) + '\t');
            }
            return cArr;
        }

        private static char[] j() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }
    }

    /* loaded from: classes5.dex */
    private static final class ForPredicate extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final Predicate<? super Character> f26280a;

        ForPredicate(Predicate<? super Character> predicate) {
            this.f26280a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return this.f26280a.apply(Character.valueOf(c4));
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.forPredicate(" + this.f26280a + ")";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public boolean apply(Character ch) {
            return this.f26280a.apply(Preconditions.checkNotNull(ch));
        }
    }

    /* loaded from: classes5.dex */
    private static final class InRange extends FastMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final char f26281a;

        /* renamed from: b  reason: collision with root package name */
        private final char f26282b;

        InRange(char c4, char c5) {
            boolean z3;
            if (c5 >= c4) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f26281a = c4;
            this.f26282b = c5;
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            bitSet.set(this.f26281a, this.f26282b + 1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (this.f26281a <= c4 && c4 <= this.f26282b) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.h(this.f26281a) + "', '" + CharMatcher.h(this.f26282b) + "')";
        }
    }

    /* loaded from: classes5.dex */
    private static final class Invisible extends RangesMatcher {

        /* renamed from: d  reason: collision with root package name */
        static final Invisible f26283d = new Invisible();

        private Invisible() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u0890\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9".toCharArray(), "  \u00ad\u0605\u061c\u06dd\u070f\u0891\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb".toCharArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Is extends FastMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final char f26284a;

        Is(char c4) {
            this.f26284a = c4;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            if (charMatcher.matches(this.f26284a)) {
                return this;
            }
            return CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            bitSet.set(this.f26284a);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (c4 == this.f26284a) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.isNot(this.f26284a);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            if (!charMatcher.matches(this.f26284a)) {
                return super.or(charMatcher);
            }
            return charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c4) {
            return charSequence.toString().replace(this.f26284a, c4);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.h(this.f26284a) + "')";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class IsEither extends FastMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final char f26285a;

        /* renamed from: b  reason: collision with root package name */
        private final char f26286b;

        IsEither(char c4, char c5) {
            this.f26285a = c4;
            this.f26286b = c5;
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            bitSet.set(this.f26285a);
            bitSet.set(this.f26286b);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (c4 != this.f26285a && c4 != this.f26286b) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.h(this.f26285a) + CharMatcher.h(this.f26286b) + "\")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class IsNot extends FastMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final char f26287a;

        IsNot(char c4) {
            this.f26287a = c4;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            if (charMatcher.matches(this.f26287a)) {
                return super.and(charMatcher);
            }
            return charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            bitSet.set(0, this.f26287a);
            bitSet.set(this.f26287a + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (c4 != this.f26287a) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.is(this.f26287a);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            if (charMatcher.matches(this.f26287a)) {
                return CharMatcher.any();
            }
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.h(this.f26287a) + "')";
        }
    }

    /* loaded from: classes5.dex */
    private static final class JavaDigit extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        static final JavaDigit f26288a = new JavaDigit();

        private JavaDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return Character.isDigit(c4);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* loaded from: classes5.dex */
    private static final class JavaIsoControl extends NamedFastMatcher {

        /* renamed from: b  reason: collision with root package name */
        static final JavaIsoControl f26289b = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (c4 > 31 && (c4 < 127 || c4 > 159)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    private static final class JavaLetter extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        static final JavaLetter f26290a = new JavaLetter();

        private JavaLetter() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return Character.isLetter(c4);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* loaded from: classes5.dex */
    private static final class JavaLetterOrDigit extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        static final JavaLetterOrDigit f26291a = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return Character.isLetterOrDigit(c4);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* loaded from: classes5.dex */
    private static final class JavaLowerCase extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        static final JavaLowerCase f26292a = new JavaLowerCase();

        private JavaLowerCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return Character.isLowerCase(c4);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* loaded from: classes5.dex */
    private static final class JavaUpperCase extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        static final JavaUpperCase f26293a = new JavaUpperCase();

        private JavaUpperCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return Character.isUpperCase(c4);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class NamedFastMatcher extends FastMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final String f26294a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public NamedFastMatcher(String str) {
            this.f26294a = (String) Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.f26294a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Negated extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        final CharMatcher f26295a;

        Negated(CharMatcher charMatcher) {
            this.f26295a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.f26295a.countIn(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f26295a.g(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return !this.f26295a.matches(c4);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return this.f26295a.matchesNoneOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.f26295a.matchesAllOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return this.f26295a;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.f26295a + ".negate()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class None extends NamedFastMatcher {

        /* renamed from: b  reason: collision with root package name */
        static final None f26296b = new None();

        private None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c4) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            if (charSequence.length() == 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.any();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c4) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i4) {
            Preconditions.checkPositionIndex(i4, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Or extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        final CharMatcher f26297a;

        /* renamed from: b  reason: collision with root package name */
        final CharMatcher f26298b;

        Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f26297a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f26298b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            this.f26297a.g(bitSet);
            this.f26298b.g(bitSet);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if (!this.f26297a.matches(c4) && !this.f26298b.matches(c4)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.or(" + this.f26297a + ", " + this.f26298b + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static class RangesMatcher extends CharMatcher {

        /* renamed from: a  reason: collision with root package name */
        private final String f26299a;

        /* renamed from: b  reason: collision with root package name */
        private final char[] f26300b;

        /* renamed from: c  reason: collision with root package name */
        private final char[] f26301c;

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            boolean z3;
            boolean z4;
            boolean z5;
            this.f26299a = str;
            this.f26300b = cArr;
            this.f26301c = cArr2;
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

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            int binarySearch = Arrays.binarySearch(this.f26300b, c4);
            if (binarySearch >= 0) {
                return true;
            }
            int i4 = (~binarySearch) - 1;
            if (i4 >= 0 && c4 <= this.f26301c[i4]) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.f26299a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class SingleWidth extends RangesMatcher {

        /* renamed from: d  reason: collision with root package name */
        static final SingleWidth f26302d = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺\ufdff\ufeffￜ".toCharArray());
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static final class Whitespace extends NamedFastMatcher {

        /* renamed from: b  reason: collision with root package name */
        static final int f26303b = Integer.numberOfLeadingZeros(31);

        /* renamed from: c  reason: collision with root package name */
        static final Whitespace f26304c = new Whitespace();

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        @J2ktIncompatible
        @GwtIncompatible
        void g(BitSet bitSet) {
            for (int i4 = 0; i4 < 32; i4++) {
                bitSet.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt(i4));
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c4) {
            if ("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c4) >>> f26303b) == c4) {
                return true;
            }
            return false;
        }
    }

    protected CharMatcher() {
    }

    public static CharMatcher any() {
        return Any.f26274b;
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            if (length != 1) {
                if (length != 2) {
                    return new AnyOf(charSequence);
                }
                return c(charSequence.charAt(0), charSequence.charAt(1));
            }
            return is(charSequence.charAt(0));
        }
        return none();
    }

    public static CharMatcher ascii() {
        return Ascii.f26276b;
    }

    private String b(CharSequence charSequence, int i4, int i5, char c4, StringBuilder sb, boolean z3) {
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

    public static CharMatcher breakingWhitespace() {
        return BreakingWhitespace.f26278a;
    }

    private static IsEither c(char c4, char c5) {
        return new IsEither(c4, c5);
    }

    @J2ktIncompatible
    @GwtIncompatible
    private static boolean d(int i4, int i5) {
        if (i4 <= 1023 && i5 > i4 * 4 * 16) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static CharMatcher digit() {
        return Digit.f26279d;
    }

    @J2ktIncompatible
    @GwtIncompatible
    private static CharMatcher f(int i4, BitSet bitSet, String str) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (d(i4, bitSet.length())) {
                        return SmallCharMatcher.k(bitSet, str);
                    }
                    return new BitSetMatcher(bitSet, str);
                }
                char nextSetBit = (char) bitSet.nextSetBit(0);
                return c(nextSetBit, (char) bitSet.nextSetBit(nextSetBit + 1));
            }
            return is((char) bitSet.nextSetBit(0));
        }
        return none();
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        if (predicate instanceof CharMatcher) {
            return (CharMatcher) predicate;
        }
        return new ForPredicate(predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(char c4) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i4 = 0; i4 < 4; i4++) {
            cArr[5 - i4] = "0123456789ABCDEF".charAt(c4 & 15);
            c4 = (char) (c4 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher inRange(char c4, char c5) {
        return new InRange(c4, c5);
    }

    @Deprecated
    public static CharMatcher invisible() {
        return Invisible.f26283d;
    }

    public static CharMatcher is(char c4) {
        return new Is(c4);
    }

    public static CharMatcher isNot(char c4) {
        return new IsNot(c4);
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return JavaDigit.f26288a;
    }

    public static CharMatcher javaIsoControl() {
        return JavaIsoControl.f26289b;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return JavaLetter.f26290a;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return JavaLetterOrDigit.f26291a;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return JavaLowerCase.f26292a;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return JavaUpperCase.f26293a;
    }

    public static CharMatcher none() {
        return None.f26296b;
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return SingleWidth.f26302d;
    }

    public static CharMatcher whitespace() {
        return Whitespace.f26304c;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new And(this, charMatcher);
    }

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
                    sb.append(charSequence, 0, i4);
                    sb.append(c4);
                    return b(charSequence, i4 + 1, length, c4, sb, true);
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
    @J2ktIncompatible
    @GwtIncompatible
    public CharMatcher e() {
        String str;
        BitSet bitSet = new BitSet();
        g(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return f(cardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i4 = 65536 - cardinality;
        final String charMatcher = toString();
        if (charMatcher.endsWith(".negate()")) {
            str = charMatcher.substring(0, charMatcher.length() - 9);
        } else {
            str = charMatcher + ".negate()";
        }
        return new NegatedFastMatcher(this, f(i4, bitSet, str)) { // from class: com.google.common.base.CharMatcher.1
            @Override // com.google.common.base.CharMatcher.Negated, com.google.common.base.CharMatcher
            public String toString() {
                return charMatcher;
            }
        };
    }

    @J2ktIncompatible
    @GwtIncompatible
    void g(BitSet bitSet) {
        for (int i4 = 65535; i4 >= 0; i4--) {
            if (matches((char) i4)) {
                bitSet.set(i4);
            }
        }
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
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
        return new Negated(this);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new Or(this, charMatcher);
    }

    public CharMatcher precomputed() {
        return Platform.g(this);
    }

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

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c4) {
        int length = charSequence.length();
        int i4 = length - 1;
        int i5 = 0;
        while (i5 < length && matches(charSequence.charAt(i5))) {
            i5++;
        }
        int i6 = i4;
        while (i6 > i5 && matches(charSequence.charAt(i6))) {
            i6--;
        }
        if (i5 == 0 && i6 == i4) {
            return collapseFrom(charSequence, c4);
        }
        int i7 = i6 + 1;
        return b(charSequence, i5, i7, c4, new StringBuilder(i7 - i5), false);
    }

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

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (!matches(charSequence.charAt(i4))) {
                return charSequence.subSequence(i4, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
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

    /* loaded from: classes5.dex */
    static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    /* loaded from: classes5.dex */
    static class NegatedFastMatcher extends Negated {
        NegatedFastMatcher(CharMatcher charMatcher) {
            super(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }
}
