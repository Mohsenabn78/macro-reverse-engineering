package com.google.firebase.firestore.index;

import com.google.firebase.firestore.model.FieldIndex;
import com.google.protobuf.ByteString;

/* loaded from: classes5.dex */
public class IndexByteEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final OrderedCodeWriter f30562a = new OrderedCodeWriter();

    /* renamed from: b  reason: collision with root package name */
    private final AscendingIndexByteEncoder f30563b = new AscendingIndexByteEncoder();

    /* renamed from: c  reason: collision with root package name */
    private final DescendingIndexByteEncoder f30564c = new DescendingIndexByteEncoder();

    /* loaded from: classes5.dex */
    class AscendingIndexByteEncoder extends DirectionalIndexByteEncoder {
        AscendingIndexByteEncoder() {
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeBytes(ByteString byteString) {
            IndexByteEncoder.this.f30562a.writeBytesAscending(byteString);
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeDouble(double d4) {
            IndexByteEncoder.this.f30562a.writeDoubleAscending(d4);
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeInfinity() {
            IndexByteEncoder.this.f30562a.writeInfinityAscending();
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeLong(long j4) {
            IndexByteEncoder.this.f30562a.writeSignedLongAscending(j4);
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeString(String str) {
            IndexByteEncoder.this.f30562a.writeUtf8Ascending(str);
        }
    }

    /* loaded from: classes5.dex */
    class DescendingIndexByteEncoder extends DirectionalIndexByteEncoder {
        DescendingIndexByteEncoder() {
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeBytes(ByteString byteString) {
            IndexByteEncoder.this.f30562a.writeBytesDescending(byteString);
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeDouble(double d4) {
            IndexByteEncoder.this.f30562a.writeDoubleDescending(d4);
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeInfinity() {
            IndexByteEncoder.this.f30562a.writeInfinityDescending();
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeLong(long j4) {
            IndexByteEncoder.this.f30562a.writeSignedLongDescending(j4);
        }

        @Override // com.google.firebase.firestore.index.DirectionalIndexByteEncoder
        public void writeString(String str) {
            IndexByteEncoder.this.f30562a.writeUtf8Descending(str);
        }
    }

    public DirectionalIndexByteEncoder forKind(FieldIndex.Segment.Kind kind) {
        if (kind.equals(FieldIndex.Segment.Kind.DESCENDING)) {
            return this.f30564c;
        }
        return this.f30563b;
    }

    public byte[] getEncodedBytes() {
        return this.f30562a.encodedBytes();
    }

    public void reset() {
        this.f30562a.reset();
    }

    public void seed(byte[] bArr) {
        this.f30562a.seed(bArr);
    }
}
