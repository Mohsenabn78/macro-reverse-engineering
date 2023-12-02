package com.android.dx.rop.annotation;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;

/* loaded from: classes2.dex */
public final class NameValuePair implements Comparable<NameValuePair> {
    private final CstString name;
    private final Constant value;

    public NameValuePair(CstString cstString, Constant constant) {
        if (cstString != null) {
            if (constant != null) {
                this.name = cstString;
                this.value = constant;
                return;
            }
            throw new NullPointerException("value == null");
        }
        throw new NullPointerException("name == null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        NameValuePair nameValuePair = (NameValuePair) obj;
        if (!this.name.equals(nameValuePair.name) || !this.value.equals(nameValuePair.value)) {
            return false;
        }
        return true;
    }

    public CstString getName() {
        return this.name;
    }

    public Constant getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.name.toHuman() + ":" + this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(NameValuePair nameValuePair) {
        int compareTo = this.name.compareTo((Constant) nameValuePair.name);
        return compareTo != 0 ? compareTo : this.value.compareTo(nameValuePair.value);
    }
}
