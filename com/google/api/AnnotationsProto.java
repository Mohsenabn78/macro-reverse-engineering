package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;

/* loaded from: classes5.dex */
public final class AnnotationsProto {
    public static final int HTTP_FIELD_NUMBER = 72295728;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MethodOptions, HttpRule> http = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.MethodOptions.getDefaultInstance(), HttpRule.getDefaultInstance(), HttpRule.getDefaultInstance(), null, HTTP_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, HttpRule.class);

    private AnnotationsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) http);
    }
}
