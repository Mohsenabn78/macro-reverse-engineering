package com.facebook.stetho.inspector.elements.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.stetho.common.android.AccessibilityUtil;

/* loaded from: classes3.dex */
public final class AccessibilityNodeInfoWrapper {
    public static AccessibilityNodeInfoCompat createNodeInfoFromView(View view) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        ViewCompat.onInitializeAccessibilityNodeInfo(view, obtain);
        return obtain;
    }

    @Nullable
    public static String getActions(View view) {
        String str;
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            StringBuilder sb = new StringBuilder();
            for (AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat : createNodeInfoFromView.getActionList()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                int id = accessibilityActionCompat.getId();
                if (id != 1) {
                    if (id != 2) {
                        switch (id) {
                            case 4:
                                sb.append("select");
                                continue;
                            case 8:
                                sb.append("clear-selection");
                                continue;
                            case 16:
                                sb.append("click");
                                continue;
                            case 32:
                                sb.append("long-click");
                                continue;
                            case 64:
                                sb.append("accessibility-focus");
                                continue;
                            case 128:
                                sb.append("clear-accessibility-focus");
                                continue;
                            case 256:
                                sb.append("next-at-movement-granularity");
                                continue;
                            case 512:
                                sb.append("previous-at-movement-granularity");
                                continue;
                            case 1024:
                                sb.append("next-html-element");
                                continue;
                            case 2048:
                                sb.append("previous-html-element");
                                continue;
                            case 4096:
                                sb.append("scroll-forward");
                                continue;
                            case 8192:
                                sb.append("scroll-backward");
                                continue;
                            case 16384:
                                sb.append("copy");
                                continue;
                            case 32768:
                                sb.append("paste");
                                continue;
                            case 65536:
                                sb.append("cut");
                                continue;
                            case 131072:
                                sb.append("set-selection");
                                continue;
                            default:
                                CharSequence label = accessibilityActionCompat.getLabel();
                                if (label != null) {
                                    sb.append(label);
                                    break;
                                } else {
                                    sb.append(EnvironmentCompat.MEDIA_UNKNOWN);
                                    continue;
                                }
                        }
                    } else {
                        sb.append("clear-focus");
                    }
                } else {
                    sb.append("focus");
                }
            }
            if (sb.length() > 0) {
                str = sb.toString();
            } else {
                str = null;
            }
            return str;
        } finally {
            createNodeInfoFromView.recycle();
        }
    }

    @Nullable
    public static CharSequence getDescription(View view) {
        boolean z3;
        CharSequence charSequence;
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            CharSequence contentDescription = createNodeInfoFromView.getContentDescription();
            CharSequence text = createNodeInfoFromView.getText();
            if (!TextUtils.isEmpty(text)) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z4 = view instanceof EditText;
            if (!TextUtils.isEmpty(contentDescription) && (!z4 || !z3)) {
                return contentDescription;
            }
            if (z3) {
                return text;
            }
            String str = null;
            if (!(view instanceof ViewGroup)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
                ViewCompat.onInitializeAccessibilityNodeInfo(childAt, obtain);
                if (AccessibilityUtil.isSpeakingNode(obtain, childAt) && !AccessibilityUtil.isAccessibilityFocusable(obtain, childAt)) {
                    charSequence = getDescription(childAt);
                } else {
                    charSequence = null;
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(charSequence);
                }
                obtain.recycle();
            }
            if (sb.length() > 0) {
                str = sb.toString();
            }
            return str;
        } finally {
            createNodeInfoFromView.recycle();
        }
    }

    @Nullable
    public static String getFocusableReasons(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            boolean hasText = AccessibilityUtil.hasText(createNodeInfoFromView);
            boolean isCheckable = createNodeInfoFromView.isCheckable();
            boolean hasNonActionableSpeakingDescendants = AccessibilityUtil.hasNonActionableSpeakingDescendants(createNodeInfoFromView, view);
            if (AccessibilityUtil.isActionableForAccessibility(createNodeInfoFromView)) {
                if (createNodeInfoFromView.getChildCount() <= 0) {
                    return "View is actionable and has no children.";
                }
                if (hasText) {
                    return "View is actionable and has a description.";
                }
                if (isCheckable) {
                    return "View is actionable and checkable.";
                }
                if (hasNonActionableSpeakingDescendants) {
                    return "View is actionable and has non-actionable descendants with descriptions.";
                }
            }
            if (AccessibilityUtil.isTopLevelScrollItem(createNodeInfoFromView, view)) {
                if (hasText) {
                    return "View is a direct child of a scrollable container and has a description.";
                }
                if (isCheckable) {
                    return "View is a direct child of a scrollable container and is checkable.";
                }
                if (hasNonActionableSpeakingDescendants) {
                    return "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
                }
            }
            if (hasText) {
                return "View has a description and is not actionable, but has no actionable ancestor.";
            }
            createNodeInfoFromView.recycle();
            return null;
        } finally {
            createNodeInfoFromView.recycle();
        }
    }

    public static boolean getIgnored(View view) {
        int importantForAccessibility = ViewCompat.getImportantForAccessibility(view);
        if (importantForAccessibility == 2 || importantForAccessibility == 4) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (ViewCompat.getImportantForAccessibility((View) parent) == 4) {
                return true;
            }
        }
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.isVisibleToUser()) {
                return true;
            }
            if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                if (createNodeInfoFromView.getChildCount() <= 0) {
                    return false;
                }
                if (!AccessibilityUtil.isSpeakingNode(createNodeInfoFromView, view)) {
                    return true;
                }
                return false;
            } else if (AccessibilityUtil.hasFocusableAncestor(createNodeInfoFromView, view) || !AccessibilityUtil.hasText(createNodeInfoFromView)) {
                return true;
            } else {
                return false;
            }
        } finally {
            createNodeInfoFromView.recycle();
        }
    }

    public static String getIgnoredReasons(View view) {
        int importantForAccessibility = ViewCompat.getImportantForAccessibility(view);
        if (importantForAccessibility == 2) {
            return "View has importantForAccessibility set to 'NO'.";
        }
        if (importantForAccessibility == 4) {
            return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (ViewCompat.getImportantForAccessibility((View) parent) == 4) {
                return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
            }
        }
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.isVisibleToUser()) {
                return "View is not visible.";
            }
            if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                return "View is actionable, but has no description.";
            }
            if (AccessibilityUtil.hasText(createNodeInfoFromView)) {
                return "View is not actionable, and an ancestor View has co-opted its description.";
            }
            return "View is not actionable and has no description.";
        } finally {
            createNodeInfoFromView.recycle();
        }
    }

    public static boolean getIsAccessibilityFocused(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        boolean isAccessibilityFocused = createNodeInfoFromView.isAccessibilityFocused();
        createNodeInfoFromView.recycle();
        return isAccessibilityFocused;
    }
}
