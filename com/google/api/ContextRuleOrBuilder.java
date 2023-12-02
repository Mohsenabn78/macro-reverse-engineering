package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public interface ContextRuleOrBuilder extends MessageLiteOrBuilder {
    String getAllowedRequestExtensions(int i4);

    ByteString getAllowedRequestExtensionsBytes(int i4);

    int getAllowedRequestExtensionsCount();

    List<String> getAllowedRequestExtensionsList();

    String getAllowedResponseExtensions(int i4);

    ByteString getAllowedResponseExtensionsBytes(int i4);

    int getAllowedResponseExtensionsCount();

    List<String> getAllowedResponseExtensionsList();

    String getProvided(int i4);

    ByteString getProvidedBytes(int i4);

    int getProvidedCount();

    List<String> getProvidedList();

    String getRequested(int i4);

    ByteString getRequestedBytes(int i4);

    int getRequestedCount();

    List<String> getRequestedList();

    String getSelector();

    ByteString getSelectorBytes();
}
