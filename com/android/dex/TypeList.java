package com.android.dex;

/* loaded from: classes2.dex */
public final class TypeList implements Comparable<TypeList> {
    public static final TypeList EMPTY = new TypeList(null, Dex.EMPTY_SHORT_ARRAY);
    private final Dex dex;
    private final short[] types;

    public TypeList(Dex dex, short[] sArr) {
        this.dex = dex;
        this.types = sArr;
    }

    public short[] getTypes() {
        return this.types;
    }

    public String toString() {
        String valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int length = this.types.length;
        for (int i4 = 0; i4 < length; i4++) {
            Dex dex = this.dex;
            if (dex != null) {
                valueOf = dex.typeNames().get(this.types[i4]);
            } else {
                valueOf = Short.valueOf(this.types[i4]);
            }
            sb.append(valueOf);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        return com.android.dex.util.Unsigned.compare(r1.length, r5.types.length);
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.android.dex.TypeList r5) {
        /*
            r4 = this;
            r0 = 0
        L1:
            short[] r1 = r4.types
            int r2 = r1.length
            if (r0 >= r2) goto L19
            short[] r2 = r5.types
            int r3 = r2.length
            if (r0 >= r3) goto L19
            short r1 = r1[r0]
            short r2 = r2[r0]
            if (r1 == r2) goto L16
            int r5 = com.android.dex.util.Unsigned.compare(r1, r2)
            return r5
        L16:
            int r0 = r0 + 1
            goto L1
        L19:
            int r0 = r1.length
            short[] r5 = r5.types
            int r5 = r5.length
            int r5 = com.android.dex.util.Unsigned.compare(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dex.TypeList.compareTo(com.android.dex.TypeList):int");
    }
}
