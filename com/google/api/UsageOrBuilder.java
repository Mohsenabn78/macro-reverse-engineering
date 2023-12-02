package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public interface UsageOrBuilder extends MessageLiteOrBuilder {
    String getProducerNotificationChannel();

    ByteString getProducerNotificationChannelBytes();

    String getRequirements(int i4);

    ByteString getRequirementsBytes(int i4);

    int getRequirementsCount();

    List<String> getRequirementsList();

    UsageRule getRules(int i4);

    int getRulesCount();

    List<UsageRule> getRulesList();
}
