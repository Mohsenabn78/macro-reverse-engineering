package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;

/* loaded from: classes3.dex */
public final class ObjectDescriptor extends Descriptor<Object> {
    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public String getLocalName(Object obj) {
        return getNodeName(obj);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public String getNodeName(Object obj) {
        return obj.getClass().getName();
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public NodeType getNodeType(Object obj) {
        return NodeType.ELEMENT_NODE;
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public String getNodeValue(Object obj) {
        return null;
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void hook(Object obj) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void unhook(Object obj) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getChildren(Object obj, Accumulator<Object> accumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getComputedStyles(Object obj, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getStyleRuleNames(Object obj, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void setAttributesAsText(Object obj, String str) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getStyles(Object obj, String str, StyleAccumulator styleAccumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void setStyle(Object obj, String str, String str2, String str3) {
    }
}
