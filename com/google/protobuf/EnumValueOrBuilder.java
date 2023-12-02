package com.google.protobuf;

import java.util.List;

/* loaded from: classes6.dex */
public interface EnumValueOrBuilder extends MessageLiteOrBuilder {
    String getName();

    ByteString getNameBytes();

    int getNumber();

    Option getOptions(int i4);

    int getOptionsCount();

    List<Option> getOptionsList();
}
