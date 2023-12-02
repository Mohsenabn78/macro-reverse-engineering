package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.type.TimeZone;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class DateTime extends GeneratedMessageLite<DateTime, Builder> implements DateTimeOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    private static final DateTime DEFAULT_INSTANCE;
    public static final int HOURS_FIELD_NUMBER = 4;
    public static final int MINUTES_FIELD_NUMBER = 5;
    public static final int MONTH_FIELD_NUMBER = 2;
    public static final int NANOS_FIELD_NUMBER = 7;
    private static volatile Parser<DateTime> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 6;
    public static final int TIME_ZONE_FIELD_NUMBER = 9;
    public static final int UTC_OFFSET_FIELD_NUMBER = 8;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int day_;
    private int hours_;
    private int minutes_;
    private int month_;
    private int nanos_;
    private int seconds_;
    private int timeOffsetCase_ = 0;
    private Object timeOffset_;
    private int year_;

    /* renamed from: com.google.type.DateTime$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33665a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f33665a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33665a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33665a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33665a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33665a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33665a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33665a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DateTime, Builder> implements DateTimeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDay() {
            f();
            ((DateTime) this.f33398b).B0();
            return this;
        }

        public Builder clearHours() {
            f();
            ((DateTime) this.f33398b).C0();
            return this;
        }

        public Builder clearMinutes() {
            f();
            ((DateTime) this.f33398b).D0();
            return this;
        }

        public Builder clearMonth() {
            f();
            ((DateTime) this.f33398b).E0();
            return this;
        }

        public Builder clearNanos() {
            f();
            ((DateTime) this.f33398b).F0();
            return this;
        }

        public Builder clearSeconds() {
            f();
            ((DateTime) this.f33398b).G0();
            return this;
        }

        public Builder clearTimeOffset() {
            f();
            ((DateTime) this.f33398b).H0();
            return this;
        }

        public Builder clearTimeZone() {
            f();
            ((DateTime) this.f33398b).I0();
            return this;
        }

        public Builder clearUtcOffset() {
            f();
            ((DateTime) this.f33398b).J0();
            return this;
        }

        public Builder clearYear() {
            f();
            ((DateTime) this.f33398b).K0();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getDay() {
            return ((DateTime) this.f33398b).getDay();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getHours() {
            return ((DateTime) this.f33398b).getHours();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getMinutes() {
            return ((DateTime) this.f33398b).getMinutes();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getMonth() {
            return ((DateTime) this.f33398b).getMonth();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getNanos() {
            return ((DateTime) this.f33398b).getNanos();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getSeconds() {
            return ((DateTime) this.f33398b).getSeconds();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public TimeOffsetCase getTimeOffsetCase() {
            return ((DateTime) this.f33398b).getTimeOffsetCase();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public TimeZone getTimeZone() {
            return ((DateTime) this.f33398b).getTimeZone();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public Duration getUtcOffset() {
            return ((DateTime) this.f33398b).getUtcOffset();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getYear() {
            return ((DateTime) this.f33398b).getYear();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public boolean hasTimeZone() {
            return ((DateTime) this.f33398b).hasTimeZone();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public boolean hasUtcOffset() {
            return ((DateTime) this.f33398b).hasUtcOffset();
        }

        public Builder mergeTimeZone(TimeZone timeZone) {
            f();
            ((DateTime) this.f33398b).L0(timeZone);
            return this;
        }

        public Builder mergeUtcOffset(Duration duration) {
            f();
            ((DateTime) this.f33398b).M0(duration);
            return this;
        }

        public Builder setDay(int i4) {
            f();
            ((DateTime) this.f33398b).N0(i4);
            return this;
        }

        public Builder setHours(int i4) {
            f();
            ((DateTime) this.f33398b).O0(i4);
            return this;
        }

        public Builder setMinutes(int i4) {
            f();
            ((DateTime) this.f33398b).P0(i4);
            return this;
        }

        public Builder setMonth(int i4) {
            f();
            ((DateTime) this.f33398b).Q0(i4);
            return this;
        }

        public Builder setNanos(int i4) {
            f();
            ((DateTime) this.f33398b).R0(i4);
            return this;
        }

        public Builder setSeconds(int i4) {
            f();
            ((DateTime) this.f33398b).S0(i4);
            return this;
        }

        public Builder setTimeZone(TimeZone timeZone) {
            f();
            ((DateTime) this.f33398b).T0(timeZone);
            return this;
        }

        public Builder setUtcOffset(Duration duration) {
            f();
            ((DateTime) this.f33398b).U0(duration);
            return this;
        }

        public Builder setYear(int i4) {
            f();
            ((DateTime) this.f33398b).V0(i4);
            return this;
        }

        private Builder() {
            super(DateTime.DEFAULT_INSTANCE);
        }

        public Builder setTimeZone(TimeZone.Builder builder) {
            f();
            ((DateTime) this.f33398b).T0(builder.build());
            return this;
        }

        public Builder setUtcOffset(Duration.Builder builder) {
            f();
            ((DateTime) this.f33398b).U0(builder.build());
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public enum TimeOffsetCase {
        UTC_OFFSET(8),
        TIME_ZONE(9),
        TIMEOFFSET_NOT_SET(0);
        
        private final int value;

        TimeOffsetCase(int i4) {
            this.value = i4;
        }

        public static TimeOffsetCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 8) {
                    if (i4 != 9) {
                        return null;
                    }
                    return TIME_ZONE;
                }
                return UTC_OFFSET;
            }
            return TIMEOFFSET_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TimeOffsetCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        DateTime dateTime = new DateTime();
        DEFAULT_INSTANCE = dateTime;
        GeneratedMessageLite.d0(DateTime.class, dateTime);
    }

    private DateTime() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.day_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        this.hours_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        this.minutes_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.month_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.nanos_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.seconds_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.timeOffsetCase_ = 0;
        this.timeOffset_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        if (this.timeOffsetCase_ == 9) {
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.timeOffsetCase_ == 8) {
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        this.year_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(TimeZone timeZone) {
        timeZone.getClass();
        if (this.timeOffsetCase_ == 9 && this.timeOffset_ != TimeZone.getDefaultInstance()) {
            this.timeOffset_ = TimeZone.newBuilder((TimeZone) this.timeOffset_).mergeFrom((TimeZone.Builder) timeZone).buildPartial();
        } else {
            this.timeOffset_ = timeZone;
        }
        this.timeOffsetCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(Duration duration) {
        duration.getClass();
        if (this.timeOffsetCase_ == 8 && this.timeOffset_ != Duration.getDefaultInstance()) {
            this.timeOffset_ = Duration.newBuilder((Duration) this.timeOffset_).mergeFrom((Duration.Builder) duration).buildPartial();
        } else {
            this.timeOffset_ = duration;
        }
        this.timeOffsetCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(int i4) {
        this.day_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i4) {
        this.hours_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i4) {
        this.minutes_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i4) {
        this.month_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(int i4) {
        this.nanos_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(int i4) {
        this.seconds_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(TimeZone timeZone) {
        timeZone.getClass();
        this.timeOffset_ = timeZone;
        this.timeOffsetCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(Duration duration) {
        duration.getClass();
        this.timeOffset_ = duration;
        this.timeOffsetCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(int i4) {
        this.year_ = i4;
    }

    public static DateTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DateTime) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DateTime> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getDay() {
        return this.day_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getHours() {
        return this.hours_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getMinutes() {
        return this.minutes_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getMonth() {
        return this.month_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getNanos() {
        return this.nanos_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getSeconds() {
        return this.seconds_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public TimeOffsetCase getTimeOffsetCase() {
        return TimeOffsetCase.forNumber(this.timeOffsetCase_);
    }

    @Override // com.google.type.DateTimeOrBuilder
    public TimeZone getTimeZone() {
        if (this.timeOffsetCase_ == 9) {
            return (TimeZone) this.timeOffset_;
        }
        return TimeZone.getDefaultInstance();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public Duration getUtcOffset() {
        if (this.timeOffsetCase_ == 8) {
            return (Duration) this.timeOffset_;
        }
        return Duration.getDefaultInstance();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getYear() {
        return this.year_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public boolean hasTimeZone() {
        if (this.timeOffsetCase_ == 9) {
            return true;
        }
        return false;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public boolean hasUtcOffset() {
        if (this.timeOffsetCase_ == 8) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f33665a[methodToInvoke.ordinal()]) {
            case 1:
                return new DateTime();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004\b<\u0000\t<\u0000", new Object[]{"timeOffset_", "timeOffsetCase_", "year_", "month_", "day_", "hours_", "minutes_", "seconds_", "nanos_", Duration.class, TimeZone.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DateTime> parser = PARSER;
                if (parser == null) {
                    synchronized (DateTime.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static Builder newBuilder(DateTime dateTime) {
        return DEFAULT_INSTANCE.r(dateTime);
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DateTime parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static DateTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DateTime parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static DateTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DateTime) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DateTime parseFrom(InputStream inputStream) throws IOException {
        return (DateTime) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static DateTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DateTime parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DateTime) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DateTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
