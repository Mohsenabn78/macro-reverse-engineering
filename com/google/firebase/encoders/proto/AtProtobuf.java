package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public final class AtProtobuf {

    /* renamed from: a  reason: collision with root package name */
    private int f30094a;

    /* renamed from: b  reason: collision with root package name */
    private Protobuf.IntEncoding f30095b = Protobuf.IntEncoding.DEFAULT;

    /* loaded from: classes5.dex */
    private static final class ProtobufImpl implements Protobuf {

        /* renamed from: a  reason: collision with root package name */
        private final int f30096a;

        /* renamed from: b  reason: collision with root package name */
        private final Protobuf.IntEncoding f30097b;

        ProtobufImpl(int i4, Protobuf.IntEncoding intEncoding) {
            this.f30096a = i4;
            this.f30097b = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            if (this.f30096a == protobuf.tag() && this.f30097b.equals(protobuf.intEncoding())) {
                return true;
            }
            return false;
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f30096a) + (this.f30097b.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.f30097b;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.f30096a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f30096a + "intEncoding=" + this.f30097b + ')';
        }
    }

    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    public Protobuf build() {
        return new ProtobufImpl(this.f30094a, this.f30095b);
    }

    public AtProtobuf intEncoding(Protobuf.IntEncoding intEncoding) {
        this.f30095b = intEncoding;
        return this;
    }

    public AtProtobuf tag(int i4) {
        this.f30094a = i4;
        return this;
    }
}
