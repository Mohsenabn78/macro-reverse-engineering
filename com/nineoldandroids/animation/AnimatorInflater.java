package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes6.dex */
public class AnimatorInflater {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f36292a = {16843490};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f36293b = {16843489};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f36294c = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};

    private static Animator a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return b(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    private static Animator b(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i4) throws XmlPullParserException, IOException {
        int i5;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        ObjectAnimator objectAnimator = null;
        while (true) {
            int next = xmlPullParser.next();
            i5 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        objectAnimator = d(context, attributeSet);
                    } else if (name.equals("animator")) {
                        objectAnimator = c(context, attributeSet, null);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f36292a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        if (typedValue.type == 16) {
                            i5 = typedValue.data;
                        }
                        b(context, xmlPullParser, attributeSet, animatorSet2, i5);
                        obtainStyledAttributes.recycle();
                        objectAnimator = animatorSet2;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(objectAnimator);
                    }
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i5] = (Animator) it.next();
                i5++;
            }
            if (i4 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return objectAnimator;
    }

    private static ValueAnimator c(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        ValueAnimator valueAnimator2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f4;
        float f5;
        float f6;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f36294c);
        long j4 = obtainStyledAttributes.getInt(1, 0);
        long j5 = obtainStyledAttributes.getInt(2, 0);
        int i10 = obtainStyledAttributes.getInt(7, 0);
        if (valueAnimator == null) {
            valueAnimator2 = new ValueAnimator();
        } else {
            valueAnimator2 = valueAnimator;
        }
        if (i10 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        if (peekValue != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i4 = peekValue.type;
        } else {
            i4 = 0;
        }
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        if (peekValue2 != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            i5 = peekValue2.type;
        } else {
            i5 = 0;
        }
        if ((z4 && i4 >= 28 && i4 <= 31) || (z5 && i5 >= 28 && i5 <= 31)) {
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            z3 = false;
        }
        if (z3) {
            if (z4) {
                if (i4 == 5) {
                    f5 = obtainStyledAttributes.getDimension(5, 0.0f);
                } else {
                    f5 = obtainStyledAttributes.getFloat(5, 0.0f);
                }
                if (z5) {
                    if (i5 == 5) {
                        f6 = obtainStyledAttributes.getDimension(6, 0.0f);
                    } else {
                        f6 = obtainStyledAttributes.getFloat(6, 0.0f);
                    }
                    i6 = 0;
                    valueAnimator2.setFloatValues(f5, f6);
                } else {
                    i6 = 0;
                    valueAnimator2.setFloatValues(f5);
                }
            } else {
                i6 = 0;
                if (i5 == 5) {
                    f4 = obtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    f4 = obtainStyledAttributes.getFloat(6, 0.0f);
                }
                valueAnimator2.setFloatValues(f4);
            }
        } else {
            i6 = 0;
            if (z4) {
                if (i4 == 5) {
                    i8 = (int) obtainStyledAttributes.getDimension(5, 0.0f);
                } else if (i4 >= 28 && i4 <= 31) {
                    i8 = obtainStyledAttributes.getColor(5, 0);
                } else {
                    i8 = obtainStyledAttributes.getInt(5, 0);
                }
                if (z5) {
                    if (i5 == 5) {
                        i9 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                    } else if (i5 >= 28 && i5 <= 31) {
                        i9 = obtainStyledAttributes.getColor(6, 0);
                    } else {
                        i9 = obtainStyledAttributes.getInt(6, 0);
                    }
                    valueAnimator2.setIntValues(i8, i9);
                } else {
                    valueAnimator2.setIntValues(i8);
                }
            } else if (z5) {
                if (i5 == 5) {
                    i7 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                } else if (i5 >= 28 && i5 <= 31) {
                    i7 = obtainStyledAttributes.getColor(6, 0);
                } else {
                    i7 = obtainStyledAttributes.getInt(6, 0);
                }
                valueAnimator2.setIntValues(i7);
            }
        }
        valueAnimator2.setDuration(j4);
        valueAnimator2.setStartDelay(j5);
        if (obtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(obtainStyledAttributes.getInt(3, i6));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i6, i6);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator2;
    }

    private static ObjectAnimator d(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        c(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f36293b);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }

    public static Animator loadAnimator(Context context, int i4) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = context.getResources().getAnimation(i4);
                return a(context, xmlResourceParser);
            } catch (IOException e4) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i4));
                notFoundException.initCause(e4);
                throw notFoundException;
            } catch (XmlPullParserException e5) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i4));
                notFoundException2.initCause(e5);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
