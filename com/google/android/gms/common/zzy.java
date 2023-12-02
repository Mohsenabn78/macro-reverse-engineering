package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zzy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i4) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i5 = 0; i5 < 6; i5++) {
            int i6 = iArr[i5];
            int i7 = i6 - 1;
            if (i6 != 0) {
                if (i7 == i4) {
                    return i6;
                }
            } else {
                throw null;
            }
        }
        return 1;
    }
}
