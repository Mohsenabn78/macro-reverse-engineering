package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.messaging.ProtoEncoderDoNotUse;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class MessagingClientEventExtension {

    /* renamed from: b  reason: collision with root package name */
    private static final MessagingClientEventExtension f31851b = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final MessagingClientEvent f31852a;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private MessagingClientEvent f31853a = null;

        Builder() {
        }

        public MessagingClientEventExtension build() {
            return new MessagingClientEventExtension(this.f31853a);
        }

        public Builder setMessagingClientEvent(MessagingClientEvent messagingClientEvent) {
            this.f31853a = messagingClientEvent;
            return this;
        }
    }

    MessagingClientEventExtension(MessagingClientEvent messagingClientEvent) {
        this.f31852a = messagingClientEvent;
    }

    public static MessagingClientEventExtension getDefaultInstance() {
        return f31851b;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public MessagingClientEvent getMessagingClientEvent() {
        MessagingClientEvent messagingClientEvent = this.f31852a;
        if (messagingClientEvent == null) {
            return MessagingClientEvent.getDefaultInstance();
        }
        return messagingClientEvent;
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "messagingClientEvent")
    public MessagingClientEvent getMessagingClientEventInternal() {
        return this.f31852a;
    }

    public byte[] toByteArray() {
        return ProtoEncoderDoNotUse.encode(this);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.encode(this, outputStream);
    }
}
