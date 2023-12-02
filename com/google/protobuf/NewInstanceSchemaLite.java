package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes6.dex */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).M();
    }
}
