package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;

@GwtCompatible
/* loaded from: classes6.dex */
final class TrieParser {

    /* renamed from: a  reason: collision with root package name */
    private static final Joiner f33659a = Joiner.on("");

    TrieParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.util.Deque<java.lang.CharSequence> r8, java.lang.CharSequence r9, int r10, com.google.common.collect.ImmutableMap.Builder<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r11) {
        /*
            int r0 = r9.length()
            r1 = 0
            r2 = r10
        L6:
            r3 = 58
            r4 = 33
            r5 = 44
            r6 = 63
            if (r2 >= r0) goto L24
            char r1 = r9.charAt(r2)
            r7 = 38
            if (r1 == r7) goto L24
            if (r1 == r6) goto L24
            if (r1 == r4) goto L24
            if (r1 == r3) goto L24
            if (r1 != r5) goto L21
            goto L24
        L21:
            int r2 = r2 + 1
            goto L6
        L24:
            java.lang.CharSequence r7 = r9.subSequence(r10, r2)
            java.lang.CharSequence r7 = d(r7)
            r8.push(r7)
            if (r1 == r4) goto L37
            if (r1 == r6) goto L37
            if (r1 == r3) goto L37
            if (r1 != r5) goto L4a
        L37:
            com.google.common.base.Joiner r3 = com.google.thirdparty.publicsuffix.TrieParser.f33659a
            java.lang.String r3 = r3.join(r8)
            int r4 = r3.length()
            if (r4 <= 0) goto L4a
            com.google.thirdparty.publicsuffix.PublicSuffixType r4 = com.google.thirdparty.publicsuffix.PublicSuffixType.b(r1)
            r11.put(r3, r4)
        L4a:
            int r2 = r2 + 1
            if (r1 == r6) goto L65
            if (r1 == r5) goto L65
        L50:
            if (r2 >= r0) goto L65
            int r1 = a(r8, r9, r2, r11)
            int r2 = r2 + r1
            char r1 = r9.charAt(r2)
            if (r1 == r6) goto L63
            char r1 = r9.charAt(r2)
            if (r1 != r5) goto L50
        L63:
            int r2 = r2 + 1
        L65:
            r8.pop()
            int r2 = r2 - r10
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.thirdparty.publicsuffix.TrieParser.a(java.util.Deque, java.lang.CharSequence, int, com.google.common.collect.ImmutableMap$Builder):int");
    }

    @VisibleForTesting
    static ImmutableMap<String, PublicSuffixType> b(String str) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            i4 += a(Queues.newArrayDeque(), str, i4, builder);
        }
        return builder.buildOrThrow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableMap<String, PublicSuffixType> c(CharSequence... charSequenceArr) {
        return b(f33659a.join(charSequenceArr));
    }

    private static CharSequence d(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
