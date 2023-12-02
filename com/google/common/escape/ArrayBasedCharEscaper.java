package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ArrayBasedCharEscaper extends CharEscaper {

    /* renamed from: b  reason: collision with root package name */
    private final char[][] f27607b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27608c;

    /* renamed from: d  reason: collision with root package name */
    private final char f27609d;

    /* renamed from: e  reason: collision with root package name */
    private final char f27610e;

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayBasedCharEscaper(Map<Character, String> map, char c4, char c5) {
        this(ArrayBasedEscaperMap.create(map), c4, c5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.escape.CharEscaper
    @CheckForNull
    public final char[] a(char c4) {
        char[] cArr;
        if (c4 < this.f27608c && (cArr = this.f27607b[c4]) != null) {
            return cArr;
        }
        if (c4 >= this.f27609d && c4 <= this.f27610e) {
            return null;
        }
        return d(c4);
    }

    @CheckForNull
    protected abstract char[] d(char c4);

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if ((charAt < this.f27608c && this.f27607b[charAt] != null) || charAt > this.f27610e || charAt < this.f27609d) {
                return b(str, i4);
            }
        }
        return str;
    }

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c4, char c5) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] b4 = arrayBasedEscaperMap.b();
        this.f27607b = b4;
        this.f27608c = b4.length;
        if (c5 < c4) {
            c5 = 0;
            c4 = CharCompanionObject.MAX_VALUE;
        }
        this.f27609d = c4;
        this.f27610e = c5;
    }
}
