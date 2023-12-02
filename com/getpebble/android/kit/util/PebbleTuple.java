package com.getpebble.android.kit.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class PebbleTuple {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f18341a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Map<String, a> f18342b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    static final Map<Integer, b> f18343c;
    public final int key;
    public final int length;
    public final a type;
    public final Object value;
    public final b width;

    /* loaded from: classes3.dex */
    public static class ValueOverflowException extends RuntimeException {
        public ValueOverflowException() {
            super("Value exceeds tuple capacity");
        }
    }

    /* loaded from: classes3.dex */
    enum a {
        BYTES(0),
        STRING(1),
        UINT(2),
        INT(3);
        
        public final byte ord;

        a(int i4) {
            this.ord = (byte) i4;
        }

        public String getName() {
            return name().toLowerCase(Locale.US);
        }
    }

    /* loaded from: classes3.dex */
    enum b {
        NONE(0),
        BYTE(1),
        SHORT(2),
        WORD(4);
        
        public final int value;

        b(int i4) {
            this.value = i4;
        }
    }

    static {
        a[] values;
        b[] values2;
        for (a aVar : a.values()) {
            f18342b.put(aVar.getName(), aVar);
        }
        f18343c = new HashMap();
        for (b bVar : b.values()) {
            f18343c.put(Integer.valueOf(bVar.value), bVar);
        }
    }

    private PebbleTuple(int i4, a aVar, b bVar, int i5, Object obj) {
        this.key = i4;
        this.type = aVar;
        this.width = bVar;
        this.length = i5;
        this.value = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PebbleTuple a(int i4, a aVar, b bVar, int i5) {
        return new PebbleTuple(i4, aVar, bVar, bVar.value, Long.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.getpebble.android.kit.util.PebbleTuple b(int r7, com.getpebble.android.kit.util.PebbleTuple.a r8, com.getpebble.android.kit.util.PebbleTuple.b r9, java.lang.Object r10) {
        /*
            com.getpebble.android.kit.util.PebbleTuple$b r0 = com.getpebble.android.kit.util.PebbleTuple.b.NONE
            if (r9 == r0) goto L8
            int r0 = r9.value
        L6:
            r5 = r0
            goto L26
        L8:
            com.getpebble.android.kit.util.PebbleTuple$a r0 = com.getpebble.android.kit.util.PebbleTuple.a.BYTES
            if (r8 != r0) goto L11
            r0 = r10
            byte[] r0 = (byte[]) r0
            int r0 = r0.length
            goto L6
        L11:
            com.getpebble.android.kit.util.PebbleTuple$a r0 = com.getpebble.android.kit.util.PebbleTuple.a.STRING
            if (r8 != r0) goto L20
            r0 = r10
            java.lang.String r0 = (java.lang.String) r0
            java.nio.charset.Charset r1 = com.getpebble.android.kit.util.PebbleTuple.f18341a
            byte[] r0 = r0.getBytes(r1)
            int r0 = r0.length
            goto L6
        L20:
            r0 = 2147483647(0x7fffffff, float:NaN)
            r5 = 2147483647(0x7fffffff, float:NaN)
        L26:
            r0 = 65535(0xffff, float:9.1834E-41)
            if (r5 > r0) goto L36
            com.getpebble.android.kit.util.PebbleTuple r0 = new com.getpebble.android.kit.util.PebbleTuple
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r0
        L36:
            com.getpebble.android.kit.util.PebbleTuple$ValueOverflowException r7 = new com.getpebble.android.kit.util.PebbleTuple$ValueOverflowException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.kit.util.PebbleTuple.b(int, com.getpebble.android.kit.util.PebbleTuple$a, com.getpebble.android.kit.util.PebbleTuple$b, java.lang.Object):com.getpebble.android.kit.util.PebbleTuple");
    }
}
