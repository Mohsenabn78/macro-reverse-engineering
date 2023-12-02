package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.json.annotation.JsonValue;

/* loaded from: classes3.dex */
public enum NodeType {
    ELEMENT_NODE(1),
    TEXT_NODE(3),
    PROCESSING_INSTRUCTION_NODE(7),
    COMMENT_NODE(8),
    DOCUMENT_NODE(9),
    DOCUMENT_TYPE_NODE(10),
    DOCUMENT_FRAGMENT_NODE(11);
    
    private final int mValue;

    NodeType(int i4) {
        this.mValue = i4;
    }

    @JsonValue
    public int getProtocolValue() {
        return this.mValue;
    }
}
