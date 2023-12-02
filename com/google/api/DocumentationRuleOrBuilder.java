package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface DocumentationRuleOrBuilder extends MessageLiteOrBuilder {
    String getDeprecationDescription();

    ByteString getDeprecationDescriptionBytes();

    String getDescription();

    ByteString getDescriptionBytes();

    String getSelector();

    ByteString getSelectorBytes();
}
