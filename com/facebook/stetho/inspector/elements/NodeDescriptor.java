package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public interface NodeDescriptor<E> extends ThreadBound {
    void getAttributes(E e4, AttributeAccumulator attributeAccumulator);

    void getChildren(E e4, Accumulator<Object> accumulator);

    void getComputedStyles(E e4, ComputedStyleAccumulator computedStyleAccumulator);

    String getLocalName(E e4);

    String getNodeName(E e4);

    NodeType getNodeType(E e4);

    @Nullable
    String getNodeValue(E e4);

    void getStyleRuleNames(E e4, StyleRuleNameAccumulator styleRuleNameAccumulator);

    void getStyles(E e4, String str, StyleAccumulator styleAccumulator);

    void hook(E e4);

    void setAttributesAsText(E e4, String str);

    void setStyle(E e4, String str, String str2, String str3);

    void unhook(E e4);
}
