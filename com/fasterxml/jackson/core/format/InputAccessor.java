package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public interface InputAccessor {
    boolean hasMoreBytes() throws IOException;

    byte nextByte() throws IOException;

    void reset();

    /* loaded from: classes3.dex */
    public static class Std implements InputAccessor {

        /* renamed from: a  reason: collision with root package name */
        protected final InputStream f17709a;

        /* renamed from: b  reason: collision with root package name */
        protected final byte[] f17710b;

        /* renamed from: c  reason: collision with root package name */
        protected final int f17711c;

        /* renamed from: d  reason: collision with root package name */
        protected int f17712d;

        /* renamed from: e  reason: collision with root package name */
        protected int f17713e;

        public Std(InputStream inputStream, byte[] bArr) {
            this.f17709a = inputStream;
            this.f17710b = bArr;
            this.f17711c = 0;
            this.f17713e = 0;
            this.f17712d = 0;
        }

        public DataFormatMatcher createMatcher(JsonFactory jsonFactory, MatchStrength matchStrength) {
            InputStream inputStream = this.f17709a;
            byte[] bArr = this.f17710b;
            int i4 = this.f17711c;
            return new DataFormatMatcher(inputStream, bArr, i4, this.f17712d - i4, jsonFactory, matchStrength);
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public boolean hasMoreBytes() throws IOException {
            int read;
            int i4 = this.f17713e;
            if (i4 < this.f17712d) {
                return true;
            }
            InputStream inputStream = this.f17709a;
            if (inputStream == null) {
                return false;
            }
            byte[] bArr = this.f17710b;
            int length = bArr.length - i4;
            if (length < 1 || (read = inputStream.read(bArr, i4, length)) <= 0) {
                return false;
            }
            this.f17712d += read;
            return true;
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public byte nextByte() throws IOException {
            if (this.f17713e >= this.f17712d && !hasMoreBytes()) {
                throw new EOFException("Failed auto-detect: could not read more than " + this.f17713e + " bytes (max buffer size: " + this.f17710b.length + ")");
            }
            byte[] bArr = this.f17710b;
            int i4 = this.f17713e;
            this.f17713e = i4 + 1;
            return bArr[i4];
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public void reset() {
            this.f17713e = this.f17711c;
        }

        public Std(byte[] bArr) {
            this.f17709a = null;
            this.f17710b = bArr;
            this.f17711c = 0;
            this.f17712d = bArr.length;
        }

        public Std(byte[] bArr, int i4, int i5) {
            this.f17709a = null;
            this.f17710b = bArr;
            this.f17713e = i4;
            this.f17711c = i4;
            this.f17712d = i4 + i5;
        }
    }
}
