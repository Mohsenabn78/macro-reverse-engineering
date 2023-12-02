package com.airbnb.lottie.parser.moshi;

import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

/* compiled from: JsonScope.java */
/* loaded from: classes2.dex */
final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i4, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            if (i6 != 1 && i6 != 2) {
                if (i6 == 3 || i6 == 4 || i6 == 5) {
                    sb.append('.');
                    String str = strArr[i5];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                sb.append(iArr2[i5]);
                sb.append(']');
            }
        }
        return sb.toString();
    }
}
