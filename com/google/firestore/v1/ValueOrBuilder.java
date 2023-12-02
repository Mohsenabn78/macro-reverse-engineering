package com.google.firestore.v1;

import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;

/* loaded from: classes5.dex */
public interface ValueOrBuilder extends MessageLiteOrBuilder {
    ArrayValue getArrayValue();

    boolean getBooleanValue();

    ByteString getBytesValue();

    double getDoubleValue();

    LatLng getGeoPointValue();

    long getIntegerValue();

    MapValue getMapValue();

    NullValue getNullValue();

    int getNullValueValue();

    String getReferenceValue();

    ByteString getReferenceValueBytes();

    String getStringValue();

    ByteString getStringValueBytes();

    Timestamp getTimestampValue();

    Value.ValueTypeCase getValueTypeCase();

    boolean hasArrayValue();

    boolean hasBooleanValue();

    boolean hasBytesValue();

    boolean hasDoubleValue();

    boolean hasGeoPointValue();

    boolean hasIntegerValue();

    boolean hasMapValue();

    boolean hasNullValue();

    boolean hasReferenceValue();

    boolean hasStringValue();

    boolean hasTimestampValue();
}
