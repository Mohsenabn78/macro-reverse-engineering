package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public final class RawMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final MessageLite f33520a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33521b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f33522c;

    /* renamed from: d  reason: collision with root package name */
    private final int f33523d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.f33520a = messageLite;
        this.f33521b = str;
        this.f33522c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f33523d = charAt;
            return;
        }
        int i4 = charAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char charAt2 = str.charAt(i6);
            if (charAt2 >= 55296) {
                i4 |= (charAt2 & 8191) << i5;
                i5 += 13;
                i6 = i7;
            } else {
                this.f33523d = i4 | (charAt2 << i5);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] a() {
        return this.f33522c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f33521b;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.f33520a;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        if ((this.f33523d & 1) == 1) {
            return ProtoSyntax.PROTO2;
        }
        return ProtoSyntax.PROTO3;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        if ((this.f33523d & 2) == 2) {
            return true;
        }
        return false;
    }
}
