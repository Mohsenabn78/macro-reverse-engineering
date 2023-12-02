package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* loaded from: classes5.dex */
class ProtobufValueEncoderContext implements ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f30117a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30118b = false;

    /* renamed from: c  reason: collision with root package name */
    private FieldDescriptor f30119c;

    /* renamed from: d  reason: collision with root package name */
    private final ProtobufDataEncoderContext f30120d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.f30120d = protobufDataEncoderContext;
    }

    private void a() {
        if (!this.f30117a) {
            this.f30117a = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(@Nullable String str) throws IOException {
        a();
        this.f30120d.d(this.f30119c, str, this.f30118b);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(FieldDescriptor fieldDescriptor, boolean z3) {
        this.f30117a = false;
        this.f30119c = fieldDescriptor;
        this.f30118b = z3;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(float f4) throws IOException {
        a();
        this.f30120d.c(this.f30119c, f4, this.f30118b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(double d4) throws IOException {
        a();
        this.f30120d.b(this.f30119c, d4, this.f30118b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(int i4) throws IOException {
        a();
        this.f30120d.f(this.f30119c, i4, this.f30118b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(long j4) throws IOException {
        a();
        this.f30120d.h(this.f30119c, j4, this.f30118b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(boolean z3) throws IOException {
        a();
        this.f30120d.j(this.f30119c, z3, this.f30118b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        a();
        this.f30120d.d(this.f30119c, bArr, this.f30118b);
        return this;
    }
}
