package com.google.firebase.messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.IOException;
import java.io.OutputStream;

@Encodable
/* loaded from: classes5.dex */
public abstract class ProtoEncoderDoNotUse {

    /* renamed from: a  reason: collision with root package name */
    private static final ProtobufEncoder f31680a = ProtobufEncoder.builder().configureWith(AutoProtoEncoderDoNotUseEncoder.CONFIG).build();

    private ProtoEncoderDoNotUse() {
    }

    public static byte[] encode(Object obj) {
        return f31680a.encode(obj);
    }

    public abstract MessagingClientEventExtension getMessagingClientEventExtension();

    public static void encode(Object obj, OutputStream outputStream) throws IOException {
        f31680a.encode(obj, outputStream);
    }
}
