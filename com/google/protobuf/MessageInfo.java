package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes6.dex */
interface MessageInfo {
    MessageLite getDefaultInstance();

    ProtoSyntax getSyntax();

    boolean isMessageSetWireFormat();
}
