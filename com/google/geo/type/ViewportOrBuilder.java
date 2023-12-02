package com.google.geo.type;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.type.LatLng;

/* loaded from: classes5.dex */
public interface ViewportOrBuilder extends MessageLiteOrBuilder {
    LatLng getHigh();

    LatLng getLow();

    boolean hasHigh();

    boolean hasLow();
}
