package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
final class ParseRequest {

    /* renamed from: a  reason: collision with root package name */
    final String f28173a;

    /* renamed from: b  reason: collision with root package name */
    final int f28174b;

    private ParseRequest(String str, int i4) {
        this.f28173a = str;
        this.f28174b = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParseRequest a(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i4 = 16;
            if (!str.startsWith("0x") && !str.startsWith("0X")) {
                if (charAt == '#') {
                    str = str.substring(1);
                } else if (charAt == '0' && str.length() > 1) {
                    str = str.substring(1);
                    i4 = 8;
                } else {
                    i4 = 10;
                }
            } else {
                str = str.substring(2);
            }
            return new ParseRequest(str, i4);
        }
        throw new NumberFormatException("empty string");
    }
}
