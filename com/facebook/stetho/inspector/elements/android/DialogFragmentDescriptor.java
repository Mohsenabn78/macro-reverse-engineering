package com.facebook.stetho.inspector.elements.android;

import android.app.Dialog;
import android.graphics.Rect;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.DialogFragmentAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
final class DialogFragmentDescriptor extends Descriptor<Object> implements ChainedDescriptor<Object>, HighlightableDescriptor<Object> {
    private final DialogFragmentAccessor mAccessor;
    private Descriptor<? super Object> mSuper;

    private DialogFragmentDescriptor(FragmentCompat fragmentCompat) {
        this.mAccessor = fragmentCompat.forDialogFragment();
    }

    private static void maybeRegister(DescriptorMap descriptorMap, @Nullable FragmentCompat fragmentCompat) {
        if (fragmentCompat != null) {
            Class<?> dialogFragmentClass = fragmentCompat.getDialogFragmentClass();
            LogUtil.d("Adding support for %s", dialogFragmentClass);
            descriptorMap.registerDescriptor(dialogFragmentClass, (Descriptor) new DialogFragmentDescriptor(fragmentCompat));
        }
    }

    public static DescriptorMap register(DescriptorMap descriptorMap) {
        maybeRegister(descriptorMap, FragmentCompat.getSupportLibInstance());
        maybeRegister(descriptorMap, FragmentCompat.getFrameworkInstance());
        return descriptorMap;
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(obj, attributeAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getChildren(Object obj, Accumulator<Object> accumulator) {
        accumulator.store(this.mAccessor.getDialog(obj));
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public Object getElementToHighlightAtPosition(Object obj, int i4, int i5, Rect rect) {
        Dialog dialog;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            dialog = this.mAccessor.getDialog(obj);
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(dialog);
        } else {
            dialog = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getElementToHighlightAtPosition(dialog, i4, i5, rect);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public String getLocalName(Object obj) {
        return this.mSuper.getLocalName(obj);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public String getNodeName(Object obj) {
        return this.mSuper.getNodeName(obj);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public NodeType getNodeType(Object obj) {
        return this.mSuper.getNodeType(obj);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    @Nullable
    public String getNodeValue(Object obj) {
        return this.mSuper.getNodeValue(obj);
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewAndBoundsForHighlighting(Object obj, Rect rect) {
        Dialog dialog;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            dialog = this.mAccessor.getDialog(obj);
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(dialog);
        } else {
            dialog = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getViewAndBoundsForHighlighting(dialog, rect);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void hook(Object obj) {
        this.mSuper.hook(obj);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void setAttributesAsText(Object obj, String str) {
        this.mSuper.setAttributesAsText(obj, str);
    }

    @Override // com.facebook.stetho.inspector.elements.ChainedDescriptor
    public void setSuper(Descriptor<? super Object> descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor<? super Object> descriptor2 = this.mSuper;
        if (descriptor != descriptor2) {
            if (descriptor2 == null) {
                this.mSuper = descriptor;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void unhook(Object obj) {
        this.mSuper.unhook(obj);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getComputedStyles(Object obj, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getStyleRuleNames(Object obj, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getStyles(Object obj, String str, StyleAccumulator styleAccumulator) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void setStyle(Object obj, String str, String str2, String str3) {
    }
}
