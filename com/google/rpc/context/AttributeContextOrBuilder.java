package com.google.rpc.context;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.rpc.context.AttributeContext;

/* loaded from: classes6.dex */
public interface AttributeContextOrBuilder extends MessageLiteOrBuilder {
    AttributeContext.Api getApi();

    AttributeContext.Peer getDestination();

    AttributeContext.Peer getOrigin();

    AttributeContext.Request getRequest();

    AttributeContext.Resource getResource();

    AttributeContext.Response getResponse();

    AttributeContext.Peer getSource();

    boolean hasApi();

    boolean hasDestination();

    boolean hasOrigin();

    boolean hasRequest();

    boolean hasResource();

    boolean hasResponse();

    boolean hasSource();
}
