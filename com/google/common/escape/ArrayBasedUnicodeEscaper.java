package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {

    /* renamed from: b  reason: collision with root package name */
    private final char[][] f27613b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27614c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27615d;

    /* renamed from: e  reason: collision with root package name */
    private final int f27616e;

    /* renamed from: f  reason: collision with root package name */
    private final char f27617f;

    /* renamed from: g  reason: collision with root package name */
    private final char f27618g;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.escape.UnicodeEscaper
    @CheckForNull
    public final char[] b(int i4) {
        char[] cArr;
        if (i4 < this.f27614c && (cArr = this.f27613b[i4]) != null) {
            return cArr;
        }
        if (i4 >= this.f27615d && i4 <= this.f27616e) {
            return null;
        }
        return f(i4);
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final int e(CharSequence charSequence, int i4, int i5) {
        while (i4 < i5) {
            char charAt = charSequence.charAt(i4);
            if ((charAt < this.f27614c && this.f27613b[charAt] != null) || charAt > this.f27618g || charAt < this.f27617f) {
                break;
            }
            i4++;
        }
        return i4;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if ((charAt < this.f27614c && this.f27613b[charAt] != null) || charAt > this.f27618g || charAt < this.f27617f) {
                return c(str, i4);
            }
        }
        return str;
    }

    @CheckForNull
    protected abstract char[] f(int i4);
}
