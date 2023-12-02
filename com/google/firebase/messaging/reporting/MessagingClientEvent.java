package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes5.dex */
public final class MessagingClientEvent {

    /* renamed from: p  reason: collision with root package name */
    private static final MessagingClientEvent f31817p = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final long f31818a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31819b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31820c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageType f31821d;

    /* renamed from: e  reason: collision with root package name */
    private final SDKPlatform f31822e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31823f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31824g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31825h;

    /* renamed from: i  reason: collision with root package name */
    private final int f31826i;

    /* renamed from: j  reason: collision with root package name */
    private final String f31827j;

    /* renamed from: k  reason: collision with root package name */
    private final long f31828k;

    /* renamed from: l  reason: collision with root package name */
    private final Event f31829l;

    /* renamed from: m  reason: collision with root package name */
    private final String f31830m;

    /* renamed from: n  reason: collision with root package name */
    private final long f31831n;

    /* renamed from: o  reason: collision with root package name */
    private final String f31832o;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f31833a = 0;

        /* renamed from: b  reason: collision with root package name */
        private String f31834b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f31835c = "";

        /* renamed from: d  reason: collision with root package name */
        private MessageType f31836d = MessageType.UNKNOWN;

        /* renamed from: e  reason: collision with root package name */
        private SDKPlatform f31837e = SDKPlatform.UNKNOWN_OS;

        /* renamed from: f  reason: collision with root package name */
        private String f31838f = "";

        /* renamed from: g  reason: collision with root package name */
        private String f31839g = "";

        /* renamed from: h  reason: collision with root package name */
        private int f31840h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f31841i = 0;

        /* renamed from: j  reason: collision with root package name */
        private String f31842j = "";

        /* renamed from: k  reason: collision with root package name */
        private long f31843k = 0;

        /* renamed from: l  reason: collision with root package name */
        private Event f31844l = Event.UNKNOWN_EVENT;

        /* renamed from: m  reason: collision with root package name */
        private String f31845m = "";

        /* renamed from: n  reason: collision with root package name */
        private long f31846n = 0;

        /* renamed from: o  reason: collision with root package name */
        private String f31847o = "";

        Builder() {
        }

        public MessagingClientEvent build() {
            return new MessagingClientEvent(this.f31833a, this.f31834b, this.f31835c, this.f31836d, this.f31837e, this.f31838f, this.f31839g, this.f31840h, this.f31841i, this.f31842j, this.f31843k, this.f31844l, this.f31845m, this.f31846n, this.f31847o);
        }

        public Builder setAnalyticsLabel(String str) {
            this.f31845m = str;
            return this;
        }

        public Builder setBulkId(long j4) {
            this.f31843k = j4;
            return this;
        }

        public Builder setCampaignId(long j4) {
            this.f31846n = j4;
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f31839g = str;
            return this;
        }

        public Builder setComposerLabel(String str) {
            this.f31847o = str;
            return this;
        }

        public Builder setEvent(Event event) {
            this.f31844l = event;
            return this;
        }

        public Builder setInstanceId(String str) {
            this.f31835c = str;
            return this;
        }

        public Builder setMessageId(String str) {
            this.f31834b = str;
            return this;
        }

        public Builder setMessageType(MessageType messageType) {
            this.f31836d = messageType;
            return this;
        }

        public Builder setPackageName(String str) {
            this.f31838f = str;
            return this;
        }

        public Builder setPriority(int i4) {
            this.f31840h = i4;
            return this;
        }

        public Builder setProjectNumber(long j4) {
            this.f31833a = j4;
            return this;
        }

        public Builder setSdkPlatform(SDKPlatform sDKPlatform) {
            this.f31837e = sDKPlatform;
            return this;
        }

        public Builder setTopic(String str) {
            this.f31842j = str;
            return this;
        }

        public Builder setTtl(int i4) {
            this.f31841i = i4;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum Event implements ProtoEnum {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);
        
        private final int number_;

        Event(int i4) {
            this.number_ = i4;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes5.dex */
    public enum MessageType implements ProtoEnum {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);
        
        private final int number_;

        MessageType(int i4) {
            this.number_ = i4;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes5.dex */
    public enum SDKPlatform implements ProtoEnum {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);
        
        private final int number_;

        SDKPlatform(int i4) {
            this.number_ = i4;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    MessagingClientEvent(long j4, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i4, int i5, String str5, long j5, Event event, String str6, long j6, String str7) {
        this.f31818a = j4;
        this.f31819b = str;
        this.f31820c = str2;
        this.f31821d = messageType;
        this.f31822e = sDKPlatform;
        this.f31823f = str3;
        this.f31824g = str4;
        this.f31825h = i4;
        this.f31826i = i5;
        this.f31827j = str5;
        this.f31828k = j5;
        this.f31829l = event;
        this.f31830m = str6;
        this.f31831n = j6;
        this.f31832o = str7;
    }

    public static MessagingClientEvent getDefaultInstance() {
        return f31817p;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 13)
    public String getAnalyticsLabel() {
        return this.f31830m;
    }

    @Protobuf(tag = 11)
    public long getBulkId() {
        return this.f31828k;
    }

    @Protobuf(tag = 14)
    public long getCampaignId() {
        return this.f31831n;
    }

    @Protobuf(tag = 7)
    public String getCollapseKey() {
        return this.f31824g;
    }

    @Protobuf(tag = 15)
    public String getComposerLabel() {
        return this.f31832o;
    }

    @Protobuf(tag = 12)
    public Event getEvent() {
        return this.f31829l;
    }

    @Protobuf(tag = 3)
    public String getInstanceId() {
        return this.f31820c;
    }

    @Protobuf(tag = 2)
    public String getMessageId() {
        return this.f31819b;
    }

    @Protobuf(tag = 4)
    public MessageType getMessageType() {
        return this.f31821d;
    }

    @Protobuf(tag = 6)
    public String getPackageName() {
        return this.f31823f;
    }

    @Protobuf(tag = 8)
    public int getPriority() {
        return this.f31825h;
    }

    @Protobuf(tag = 1)
    public long getProjectNumber() {
        return this.f31818a;
    }

    @Protobuf(tag = 5)
    public SDKPlatform getSdkPlatform() {
        return this.f31822e;
    }

    @Protobuf(tag = 10)
    public String getTopic() {
        return this.f31827j;
    }

    @Protobuf(tag = 9)
    public int getTtl() {
        return this.f31826i;
    }
}
