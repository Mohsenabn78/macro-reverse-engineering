package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class LogEventDropped {

    /* renamed from: c  reason: collision with root package name */
    private static final LogEventDropped f18754c = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final long f18755a;

    /* renamed from: b  reason: collision with root package name */
    private final Reason f18756b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f18757a = 0;

        /* renamed from: b  reason: collision with root package name */
        private Reason f18758b = Reason.REASON_UNKNOWN;

        Builder() {
        }

        public LogEventDropped build() {
            return new LogEventDropped(this.f18757a, this.f18758b);
        }

        public Builder setEventsDroppedCount(long j4) {
            this.f18757a = j4;
            return this;
        }

        public Builder setReason(Reason reason) {
            this.f18758b = reason;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        
        private final int number_;

        Reason(int i4) {
            this.number_ = i4;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    LogEventDropped(long j4, Reason reason) {
        this.f18755a = j4;
        this.f18756b = reason;
    }

    public static LogEventDropped getDefaultInstance() {
        return f18754c;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long getEventsDroppedCount() {
        return this.f18755a;
    }

    @Protobuf(tag = 3)
    public Reason getReason() {
        return this.f18756b;
    }
}
