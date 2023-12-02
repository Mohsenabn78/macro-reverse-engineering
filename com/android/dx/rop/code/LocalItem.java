package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;

/* loaded from: classes2.dex */
public class LocalItem implements Comparable<LocalItem> {
    private final CstString name;
    private final CstString signature;

    private LocalItem(CstString cstString, CstString cstString2) {
        this.name = cstString;
        this.signature = cstString2;
    }

    private static int compareHandlesNulls(CstString cstString, CstString cstString2) {
        if (cstString == cstString2) {
            return 0;
        }
        if (cstString == null) {
            return -1;
        }
        if (cstString2 == null) {
            return 1;
        }
        return cstString.compareTo((Constant) cstString2);
    }

    public static LocalItem make(CstString cstString, CstString cstString2) {
        if (cstString == null && cstString2 == null) {
            return null;
        }
        return new LocalItem(cstString, cstString2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocalItem) || compareTo((LocalItem) obj) != 0) {
            return false;
        }
        return true;
    }

    public CstString getName() {
        return this.name;
    }

    public CstString getSignature() {
        return this.signature;
    }

    public int hashCode() {
        int hashCode;
        CstString cstString = this.name;
        int i4 = 0;
        if (cstString == null) {
            hashCode = 0;
        } else {
            hashCode = cstString.hashCode();
        }
        int i5 = hashCode * 31;
        CstString cstString2 = this.signature;
        if (cstString2 != null) {
            i4 = cstString2.hashCode();
        }
        return i5 + i4;
    }

    public String toString() {
        String quoted;
        CstString cstString = this.name;
        if (cstString != null && this.signature == null) {
            return cstString.toQuoted();
        }
        String str = "";
        if (cstString == null && this.signature == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        CstString cstString2 = this.name;
        if (cstString2 == null) {
            quoted = "";
        } else {
            quoted = cstString2.toQuoted();
        }
        sb.append(quoted);
        sb.append("|");
        CstString cstString3 = this.signature;
        if (cstString3 != null) {
            str = cstString3.toQuoted();
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalItem localItem) {
        int compareHandlesNulls = compareHandlesNulls(this.name, localItem.name);
        return compareHandlesNulls != 0 ? compareHandlesNulls : compareHandlesNulls(this.signature, localItem.signature);
    }
}
