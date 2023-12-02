package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.util.List;

/* loaded from: classes5.dex */
public final class FieldBehaviorProto {
    public static final int FIELD_BEHAVIOR_FIELD_NUMBER = 1052;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, List<FieldBehavior>> fieldBehavior = GeneratedMessageLite.newRepeatedGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), null, FieldBehavior.internalGetValueMap(), FIELD_BEHAVIOR_FIELD_NUMBER, WireFormat.FieldType.ENUM, true, FieldBehavior.class);

    private FieldBehaviorProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) fieldBehavior);
    }
}
