package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class TimeWindow {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeWindow f18770c = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final long f18771a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18772b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f18773a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f18774b = 0;

        Builder() {
        }

        public TimeWindow build() {
            return new TimeWindow(this.f18773a, this.f18774b);
        }

        public Builder setEndMs(long j4) {
            this.f18774b = j4;
            return this;
        }

        public Builder setStartMs(long j4) {
            this.f18773a = j4;
            return this;
        }
    }

    TimeWindow(long j4, long j5) {
        this.f18771a = j4;
        this.f18772b = j5;
    }

    public static TimeWindow getDefaultInstance() {
        return f18770c;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public long getEndMs() {
        return this.f18772b;
    }

    @Protobuf(tag = 1)
    public long getStartMs() {
        return this.f18771a;
    }
}
