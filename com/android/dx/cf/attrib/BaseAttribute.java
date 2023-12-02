package com.android.dx.cf.attrib;

import com.android.dx.cf.iface.Attribute;

/* loaded from: classes2.dex */
public abstract class BaseAttribute implements Attribute {
    private final String name;

    public BaseAttribute(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException("name == null");
    }

    @Override // com.android.dx.cf.iface.Attribute
    public String getName() {
        return this.name;
    }
}
