package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CheckReturnValue
/* loaded from: classes6.dex */
final class StructuralMessageInfo implements MessageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ProtoSyntax f33567a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33568b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f33569c;

    /* renamed from: d  reason: collision with root package name */
    private final FieldInfo[] f33570d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f33571e;

    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z3, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.f33567a = protoSyntax;
        this.f33568b = z3;
        this.f33569c = iArr;
        this.f33570d = fieldInfoArr;
        this.f33571e = (MessageLite) Internal.b(obj, "defaultInstance");
    }

    public int[] a() {
        return this.f33569c;
    }

    public FieldInfo[] b() {
        return this.f33570d;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.f33571e;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return this.f33567a;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return this.f33568b;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<FieldInfo> f33572a;

        /* renamed from: b  reason: collision with root package name */
        private ProtoSyntax f33573b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f33574c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f33575d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f33576e;

        /* renamed from: f  reason: collision with root package name */
        private Object f33577f;

        public Builder() {
            this.f33576e = null;
            this.f33572a = new ArrayList();
        }

        public StructuralMessageInfo build() {
            if (!this.f33574c) {
                if (this.f33573b != null) {
                    this.f33574c = true;
                    Collections.sort(this.f33572a);
                    return new StructuralMessageInfo(this.f33573b, this.f33575d, this.f33576e, (FieldInfo[]) this.f33572a.toArray(new FieldInfo[0]), this.f33577f);
                }
                throw new IllegalStateException("Must specify a proto syntax");
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void withCheckInitialized(int[] iArr) {
            this.f33576e = iArr;
        }

        public void withDefaultInstance(Object obj) {
            this.f33577f = obj;
        }

        public void withField(FieldInfo fieldInfo) {
            if (!this.f33574c) {
                this.f33572a.add(fieldInfo);
                return;
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void withMessageSetWireFormat(boolean z3) {
            this.f33575d = z3;
        }

        public void withSyntax(ProtoSyntax protoSyntax) {
            this.f33573b = (ProtoSyntax) Internal.b(protoSyntax, "syntax");
        }

        public Builder(int i4) {
            this.f33576e = null;
            this.f33572a = new ArrayList(i4);
        }
    }
}
