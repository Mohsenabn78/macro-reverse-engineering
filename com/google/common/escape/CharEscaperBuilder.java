package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class CharEscaperBuilder {

    /* renamed from: b  reason: collision with root package name */
    private int f27620b = -1;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Character, String> f27619a = new HashMap();

    /* loaded from: classes5.dex */
    private static class CharArrayDecorator extends CharEscaper {

        /* renamed from: b  reason: collision with root package name */
        private final char[][] f27621b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27622c;

        CharArrayDecorator(char[][] cArr) {
            this.f27621b = cArr;
            this.f27622c = cArr.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        public char[] a(char c4) {
            if (c4 < this.f27622c) {
                return this.f27621b[c4];
            }
            return null;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            int length = str.length();
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                char[][] cArr = this.f27621b;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return b(str, i4);
                }
            }
            return str;
        }
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscape(char c4, String str) {
        this.f27619a.put(Character.valueOf(c4), (String) Preconditions.checkNotNull(str));
        if (c4 > this.f27620b) {
            this.f27620b = c4;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char c4 : cArr) {
            addEscape(c4, str);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[this.f27620b + 1];
        for (Map.Entry<Character, String> entry : this.f27619a.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
