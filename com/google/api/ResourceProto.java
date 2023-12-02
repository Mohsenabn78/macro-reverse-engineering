package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.util.List;

/* loaded from: classes5.dex */
public final class ResourceProto {
    public static final int RESOURCE_DEFINITION_FIELD_NUMBER = 1053;
    public static final int RESOURCE_FIELD_NUMBER = 1053;
    public static final int RESOURCE_REFERENCE_FIELD_NUMBER = 1055;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, ResourceDescriptor> resource;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FileOptions, List<ResourceDescriptor>> resourceDefinition;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, ResourceReference> resourceReference;

    static {
        DescriptorProtos.FieldOptions defaultInstance = DescriptorProtos.FieldOptions.getDefaultInstance();
        ResourceReference defaultInstance2 = ResourceReference.getDefaultInstance();
        ResourceReference defaultInstance3 = ResourceReference.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        resourceReference = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, RESOURCE_REFERENCE_FIELD_NUMBER, fieldType, ResourceReference.class);
        resourceDefinition = GeneratedMessageLite.newRepeatedGeneratedExtension(DescriptorProtos.FileOptions.getDefaultInstance(), ResourceDescriptor.getDefaultInstance(), null, 1053, fieldType, false, ResourceDescriptor.class);
        resource = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.MessageOptions.getDefaultInstance(), ResourceDescriptor.getDefaultInstance(), ResourceDescriptor.getDefaultInstance(), null, 1053, fieldType, ResourceDescriptor.class);
    }

    private ResourceProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) resourceReference);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) resourceDefinition);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) resource);
    }
}
