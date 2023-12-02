package com.google.firebase.messaging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes5.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    /* loaded from: classes5.dex */
    private static final class MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final MessagingClientEventEncoder f31604a = new MessagingClientEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f31605b = FieldDescriptor.builder("projectNumber").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f31606c = FieldDescriptor.builder("messageId").withProperty(AtProtobuf.builder().tag(2).build()).build();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f31607d = FieldDescriptor.builder("instanceId").withProperty(AtProtobuf.builder().tag(3).build()).build();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f31608e = FieldDescriptor.builder("messageType").withProperty(AtProtobuf.builder().tag(4).build()).build();

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f31609f = FieldDescriptor.builder("sdkPlatform").withProperty(AtProtobuf.builder().tag(5).build()).build();

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f31610g = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME).withProperty(AtProtobuf.builder().tag(6).build()).build();

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f31611h = FieldDescriptor.builder("collapseKey").withProperty(AtProtobuf.builder().tag(7).build()).build();

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f31612i = FieldDescriptor.builder(LogFactory.PRIORITY_KEY).withProperty(AtProtobuf.builder().tag(8).build()).build();

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f31613j = FieldDescriptor.builder("ttl").withProperty(AtProtobuf.builder().tag(9).build()).build();

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f31614k = FieldDescriptor.builder("topic").withProperty(AtProtobuf.builder().tag(10).build()).build();

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f31615l = FieldDescriptor.builder("bulkId").withProperty(AtProtobuf.builder().tag(11).build()).build();

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f31616m = FieldDescriptor.builder(NotificationCompat.CATEGORY_EVENT).withProperty(AtProtobuf.builder().tag(12).build()).build();

        /* renamed from: n  reason: collision with root package name */
        private static final FieldDescriptor f31617n = FieldDescriptor.builder("analyticsLabel").withProperty(AtProtobuf.builder().tag(13).build()).build();

        /* renamed from: o  reason: collision with root package name */
        private static final FieldDescriptor f31618o = FieldDescriptor.builder("campaignId").withProperty(AtProtobuf.builder().tag(14).build()).build();

        /* renamed from: p  reason: collision with root package name */
        private static final FieldDescriptor f31619p = FieldDescriptor.builder("composerLabel").withProperty(AtProtobuf.builder().tag(15).build()).build();

        private MessagingClientEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(MessagingClientEvent messagingClientEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f31605b, messagingClientEvent.getProjectNumber());
            objectEncoderContext.add(f31606c, messagingClientEvent.getMessageId());
            objectEncoderContext.add(f31607d, messagingClientEvent.getInstanceId());
            objectEncoderContext.add(f31608e, messagingClientEvent.getMessageType());
            objectEncoderContext.add(f31609f, messagingClientEvent.getSdkPlatform());
            objectEncoderContext.add(f31610g, messagingClientEvent.getPackageName());
            objectEncoderContext.add(f31611h, messagingClientEvent.getCollapseKey());
            objectEncoderContext.add(f31612i, messagingClientEvent.getPriority());
            objectEncoderContext.add(f31613j, messagingClientEvent.getTtl());
            objectEncoderContext.add(f31614k, messagingClientEvent.getTopic());
            objectEncoderContext.add(f31615l, messagingClientEvent.getBulkId());
            objectEncoderContext.add(f31616m, messagingClientEvent.getEvent());
            objectEncoderContext.add(f31617n, messagingClientEvent.getAnalyticsLabel());
            objectEncoderContext.add(f31618o, messagingClientEvent.getCampaignId());
            objectEncoderContext.add(f31619p, messagingClientEvent.getComposerLabel());
        }
    }

    /* loaded from: classes5.dex */
    private static final class MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {

        /* renamed from: a  reason: collision with root package name */
        static final MessagingClientEventExtensionEncoder f31620a = new MessagingClientEventExtensionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f31621b = FieldDescriptor.builder("messagingClientEvent").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private MessagingClientEventExtensionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(MessagingClientEventExtension messagingClientEventExtension, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f31621b, messagingClientEventExtension.getMessagingClientEventInternal());
        }
    }

    /* loaded from: classes5.dex */
    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a  reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f31622a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f31623b = FieldDescriptor.of("messagingClientEventExtension");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f31623b, protoEncoderDoNotUse.getMessagingClientEventExtension());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f31622a);
        encoderConfig.registerEncoder(MessagingClientEventExtension.class, MessagingClientEventExtensionEncoder.f31620a);
        encoderConfig.registerEncoder(MessagingClientEvent.class, MessagingClientEventEncoder.f31604a);
    }
}
