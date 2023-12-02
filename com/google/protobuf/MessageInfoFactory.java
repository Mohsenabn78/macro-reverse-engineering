package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes6.dex */
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
