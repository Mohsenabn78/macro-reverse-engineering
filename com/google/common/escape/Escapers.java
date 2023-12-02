package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Escapers {

    /* renamed from: a  reason: collision with root package name */
    private static final Escaper f27624a = new CharEscaper() { // from class: com.google.common.escape.Escapers.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        public char[] a(char c4) {
            return null;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }
    };

    /* renamed from: com.google.common.escape.Escapers$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass2 extends UnicodeEscaper {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CharEscaper f27625b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.escape.UnicodeEscaper
        @CheckForNull
        public char[] b(int i4) {
            int i5;
            int i6;
            if (i4 < 65536) {
                return this.f27625b.a((char) i4);
            }
            char[] cArr = new char[2];
            Character.toChars(i4, cArr, 0);
            char[] a4 = this.f27625b.a(cArr[0]);
            char[] a5 = this.f27625b.a(cArr[1]);
            if (a4 == null && a5 == null) {
                return null;
            }
            if (a4 != null) {
                i5 = a4.length;
            } else {
                i5 = 1;
            }
            if (a5 != null) {
                i6 = a5.length;
            } else {
                i6 = 1;
            }
            char[] cArr2 = new char[i6 + i5];
            if (a4 != null) {
                for (int i7 = 0; i7 < a4.length; i7++) {
                    cArr2[i7] = a4[i7];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (a5 != null) {
                for (int i8 = 0; i8 < a5.length; i8++) {
                    cArr2[i5 + i8] = a5[i8];
                }
            } else {
                cArr2[i5] = cArr[1];
            }
            return cArr2;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Character, String> f27626a;

        /* renamed from: b  reason: collision with root package name */
        private char f27627b;

        /* renamed from: c  reason: collision with root package name */
        private char f27628c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        private String f27629d;

        @CanIgnoreReturnValue
        public Builder addEscape(char c4, String str) {
            Preconditions.checkNotNull(str);
            this.f27626a.put(Character.valueOf(c4), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.f27626a, this.f27627b, this.f27628c) { // from class: com.google.common.escape.Escapers.Builder.1
                @CheckForNull

                /* renamed from: f  reason: collision with root package name */
                private final char[] f27630f;

                {
                    char[] cArr;
                    if (Builder.this.f27629d != null) {
                        cArr = Builder.this.f27629d.toCharArray();
                    } else {
                        cArr = null;
                    }
                    this.f27630f = cArr;
                }

                @Override // com.google.common.escape.ArrayBasedCharEscaper
                @CheckForNull
                protected char[] d(char c4) {
                    return this.f27630f;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c4, char c5) {
            this.f27627b = c4;
            this.f27628c = c5;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(String str) {
            this.f27629d = str;
            return this;
        }

        private Builder() {
            this.f27626a = new HashMap();
            this.f27627b = (char) 0;
            this.f27628c = CharCompanionObject.MAX_VALUE;
            this.f27629d = null;
        }
    }

    private Escapers() {
    }

    @CheckForNull
    private static String a(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public static Builder builder() {
        return new Builder();
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper charEscaper, char c4) {
        return a(charEscaper.a(c4));
    }

    public static Escaper nullEscaper() {
        return f27624a;
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i4) {
        return a(unicodeEscaper.b(i4));
    }
}
