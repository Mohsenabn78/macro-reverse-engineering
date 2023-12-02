package com.fasterxml.jackson.core;

import net.bytebuddy.description.type.TypeDescription;
import org.slf4j.Logger;

/* loaded from: classes3.dex */
public abstract class JsonStreamContext {

    /* renamed from: a  reason: collision with root package name */
    protected int f17662a;

    /* renamed from: b  reason: collision with root package name */
    protected int f17663b;

    public final int getCurrentIndex() {
        int i4 = this.f17663b;
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    public abstract String getCurrentName();

    public final int getEntryCount() {
        return this.f17663b + 1;
    }

    public abstract JsonStreamContext getParent();

    public final String getTypeDesc() {
        int i4 = this.f17662a;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return TypeDescription.Generic.OfWildcardType.SYMBOL;
                }
                return "OBJECT";
            }
            return "ARRAY";
        }
        return Logger.ROOT_LOGGER_NAME;
    }

    public final boolean inArray() {
        if (this.f17662a == 1) {
            return true;
        }
        return false;
    }

    public final boolean inObject() {
        if (this.f17662a == 2) {
            return true;
        }
        return false;
    }

    public final boolean inRoot() {
        if (this.f17662a == 0) {
            return true;
        }
        return false;
    }
}
