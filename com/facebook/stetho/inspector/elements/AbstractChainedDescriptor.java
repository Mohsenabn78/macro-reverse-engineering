package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
    private Descriptor<? super E> mSuper;

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getAttributes(E e4, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(e4, attributeAccumulator);
        onGetAttributes(e4, attributeAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getChildren(E e4, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(e4, accumulator);
        onGetChildren(e4, accumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getComputedStyles(E e4, ComputedStyleAccumulator computedStyleAccumulator) {
        this.mSuper.getComputedStyles(e4, computedStyleAccumulator);
        onGetComputedStyles(e4, computedStyleAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getLocalName(E e4) {
        return onGetLocalName(e4);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeName(E e4) {
        return onGetNodeName(e4);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final NodeType getNodeType(E e4) {
        return onGetNodeType(e4);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeValue(E e4) {
        return onGetNodeValue(e4);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyleRuleNames(E e4, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        this.mSuper.getStyleRuleNames(e4, styleRuleNameAccumulator);
        onGetStyleRuleNames(e4, styleRuleNameAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyles(E e4, String str, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(e4, str, styleAccumulator);
        onGetStyles(e4, str, styleAccumulator);
    }

    final Descriptor<? super E> getSuper() {
        return this.mSuper;
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void hook(E e4) {
        verifyThreadAccess();
        this.mSuper.hook(e4);
        onHook(e4);
    }

    protected String onGetLocalName(E e4) {
        return this.mSuper.getLocalName(e4);
    }

    protected String onGetNodeName(E e4) {
        return this.mSuper.getNodeName(e4);
    }

    protected NodeType onGetNodeType(E e4) {
        return this.mSuper.getNodeType(e4);
    }

    @Nullable
    public String onGetNodeValue(E e4) {
        return this.mSuper.getNodeValue(e4);
    }

    protected void onSetAttributesAsText(E e4, String str) {
        this.mSuper.setAttributesAsText(e4, str);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setAttributesAsText(E e4, String str) {
        onSetAttributesAsText(e4, str);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setStyle(E e4, String str, String str2, String str3) {
        this.mSuper.setStyle(e4, str, str2, str3);
        onSetStyle(e4, str, str2, str3);
    }

    @Override // com.facebook.stetho.inspector.elements.ChainedDescriptor
    public void setSuper(Descriptor<? super E> descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor<? super E> descriptor2 = this.mSuper;
        if (descriptor != descriptor2) {
            if (descriptor2 == null) {
                this.mSuper = descriptor;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void unhook(E e4) {
        verifyThreadAccess();
        onUnhook(e4);
        this.mSuper.unhook(e4);
    }

    protected void onHook(E e4) {
    }

    protected void onUnhook(E e4) {
    }

    protected void onGetAttributes(E e4, AttributeAccumulator attributeAccumulator) {
    }

    protected void onGetChildren(E e4, Accumulator<Object> accumulator) {
    }

    protected void onGetComputedStyles(E e4, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    protected void onGetStyleRuleNames(E e4, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    protected void onGetStyles(E e4, String str, StyleAccumulator styleAccumulator) {
    }

    protected void onSetStyle(E e4, String str, String str2, String str3) {
    }
}
