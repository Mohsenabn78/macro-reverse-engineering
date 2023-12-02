package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;

/* loaded from: classes6.dex */
public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return true;
    }

    public abstract Type getDefaultValue();

    public abstract WireFormat.FieldType getLiteType();

    public abstract MessageLite getMessageDefaultInstance();

    public abstract int getNumber();

    public abstract boolean isRepeated();
}
