package com.android.dx.dex.cf;

import com.android.dx.cf.attrib.AttAnnotationDefault;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttExceptions;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttRuntimeInvisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.InnerClassList;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.dex.file.AnnotationUtils;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Warning;
import java.io.PrintStream;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class AttributeTranslator {
    private AttributeTranslator() {
    }

    public static Annotations getAnnotations(AttributeList attributeList) {
        Annotations annotations0 = getAnnotations0(attributeList);
        Annotation signature = getSignature(attributeList);
        if (signature != null) {
            return Annotations.combine(annotations0, signature);
        }
        return annotations0;
    }

    private static Annotations getAnnotations0(AttributeList attributeList) {
        AttRuntimeVisibleAnnotations attRuntimeVisibleAnnotations = (AttRuntimeVisibleAnnotations) attributeList.findFirst(AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME);
        AttRuntimeInvisibleAnnotations attRuntimeInvisibleAnnotations = (AttRuntimeInvisibleAnnotations) attributeList.findFirst(AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME);
        if (attRuntimeVisibleAnnotations == null) {
            if (attRuntimeInvisibleAnnotations == null) {
                return Annotations.EMPTY;
            }
            return attRuntimeInvisibleAnnotations.getAnnotations();
        } else if (attRuntimeInvisibleAnnotations == null) {
            return attRuntimeVisibleAnnotations.getAnnotations();
        } else {
            return Annotations.combine(attRuntimeVisibleAnnotations.getAnnotations(), attRuntimeInvisibleAnnotations.getAnnotations());
        }
    }

    public static Annotations getClassAnnotations(DirectClassFile directClassFile, CfOptions cfOptions) {
        boolean z3;
        Annotation translateAnnotationDefaults;
        CstType thisClass = directClassFile.getThisClass();
        AttributeList attributes = directClassFile.getAttributes();
        Annotations annotations = getAnnotations(attributes);
        Annotation translateEnclosingMethod = translateEnclosingMethod(attributes);
        if (translateEnclosingMethod == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        try {
            Annotations translateInnerClasses = translateInnerClasses(thisClass, attributes, z3);
            if (translateInnerClasses != null) {
                annotations = Annotations.combine(annotations, translateInnerClasses);
            }
        } catch (Warning e4) {
            PrintStream printStream = cfOptions.warn;
            printStream.println("warning: " + e4.getMessage());
        }
        if (translateEnclosingMethod != null) {
            annotations = Annotations.combine(annotations, translateEnclosingMethod);
        }
        if (AccessFlags.isAnnotation(directClassFile.getAccessFlags()) && (translateAnnotationDefaults = translateAnnotationDefaults(directClassFile)) != null) {
            return Annotations.combine(annotations, translateAnnotationDefaults);
        }
        return annotations;
    }

    public static TypeList getExceptions(Method method) {
        AttExceptions attExceptions = (AttExceptions) method.getAttributes().findFirst(AttExceptions.ATTRIBUTE_NAME);
        if (attExceptions == null) {
            return StdTypeList.EMPTY;
        }
        return attExceptions.getExceptions();
    }

    public static Annotations getMethodAnnotations(Method method) {
        Annotations annotations = getAnnotations(method.getAttributes());
        TypeList exceptions = getExceptions(method);
        if (exceptions.size() != 0) {
            return Annotations.combine(annotations, AnnotationUtils.makeThrows(exceptions));
        }
        return annotations;
    }

    public static AnnotationsList getParameterAnnotations(Method method) {
        AttributeList attributes = method.getAttributes();
        AttRuntimeVisibleParameterAnnotations attRuntimeVisibleParameterAnnotations = (AttRuntimeVisibleParameterAnnotations) attributes.findFirst(AttRuntimeVisibleParameterAnnotations.ATTRIBUTE_NAME);
        AttRuntimeInvisibleParameterAnnotations attRuntimeInvisibleParameterAnnotations = (AttRuntimeInvisibleParameterAnnotations) attributes.findFirst(AttRuntimeInvisibleParameterAnnotations.ATTRIBUTE_NAME);
        if (attRuntimeVisibleParameterAnnotations == null) {
            if (attRuntimeInvisibleParameterAnnotations == null) {
                return AnnotationsList.EMPTY;
            }
            return attRuntimeInvisibleParameterAnnotations.getParameterAnnotations();
        } else if (attRuntimeInvisibleParameterAnnotations == null) {
            return attRuntimeVisibleParameterAnnotations.getParameterAnnotations();
        } else {
            return AnnotationsList.combine(attRuntimeVisibleParameterAnnotations.getParameterAnnotations(), attRuntimeInvisibleParameterAnnotations.getParameterAnnotations());
        }
    }

    private static Annotation getSignature(AttributeList attributeList) {
        AttSignature attSignature = (AttSignature) attributeList.findFirst(AttSignature.ATTRIBUTE_NAME);
        if (attSignature == null) {
            return null;
        }
        return AnnotationUtils.makeSignature(attSignature.getSignature());
    }

    private static Annotation translateAnnotationDefaults(DirectClassFile directClassFile) {
        CstType thisClass = directClassFile.getThisClass();
        MethodList methods = directClassFile.getMethods();
        int size = methods.size();
        Annotation annotation = new Annotation(thisClass, AnnotationVisibility.EMBEDDED);
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            Method method = methods.get(i4);
            AttAnnotationDefault attAnnotationDefault = (AttAnnotationDefault) method.getAttributes().findFirst(AttAnnotationDefault.ATTRIBUTE_NAME);
            if (attAnnotationDefault != null) {
                annotation.add(new NameValuePair(method.getNat().getName(), attAnnotationDefault.getValue()));
                z3 = true;
            }
        }
        if (!z3) {
            return null;
        }
        annotation.setImmutable();
        return AnnotationUtils.makeAnnotationDefault(annotation);
    }

    private static Annotation translateEnclosingMethod(AttributeList attributeList) {
        AttEnclosingMethod attEnclosingMethod = (AttEnclosingMethod) attributeList.findFirst(AttEnclosingMethod.ATTRIBUTE_NAME);
        if (attEnclosingMethod == null) {
            return null;
        }
        CstType enclosingClass = attEnclosingMethod.getEnclosingClass();
        CstNat method = attEnclosingMethod.getMethod();
        if (method == null) {
            return AnnotationUtils.makeEnclosingClass(enclosingClass);
        }
        return AnnotationUtils.makeEnclosingMethod(new CstMethodRef(enclosingClass, method));
    }

    private static Annotations translateInnerClasses(CstType cstType, AttributeList attributeList, boolean z3) {
        AttInnerClasses attInnerClasses = (AttInnerClasses) attributeList.findFirst(AttInnerClasses.ATTRIBUTE_NAME);
        if (attInnerClasses == null) {
            return null;
        }
        InnerClassList innerClasses = attInnerClasses.getInnerClasses();
        int size = innerClasses.size();
        ArrayList arrayList = new ArrayList();
        InnerClassList.Item item = null;
        for (int i4 = 0; i4 < size; i4++) {
            InnerClassList.Item item2 = innerClasses.get(i4);
            CstType innerClass = item2.getInnerClass();
            if (innerClass.equals(cstType)) {
                item = item2;
            } else if (cstType.equals(item2.getOuterClass())) {
                arrayList.add(innerClass.getClassType());
            }
        }
        int size2 = arrayList.size();
        if (item == null && size2 == 0) {
            return null;
        }
        Annotations annotations = new Annotations();
        if (item != null) {
            annotations.add(AnnotationUtils.makeInnerClass(item.getInnerName(), item.getAccessFlags()));
            if (z3) {
                if (item.getOuterClass() != null) {
                    annotations.add(AnnotationUtils.makeEnclosingClass(item.getOuterClass()));
                } else {
                    throw new Warning("Ignoring InnerClasses attribute for an anonymous inner class\n(" + cstType.toHuman() + ") that doesn't come with an\nassociated EnclosingMethod attribute. This class was probably produced by a\ncompiler that did not target the modern .class file format. The recommended\nsolution is to recompile the class from source, using an up-to-date compiler\nand without specifying any \"-target\" type options. The consequence of ignoring\nthis warning is that reflective operations on this class will incorrectly\nindicate that it is *not* an inner class.");
                }
            }
        }
        if (size2 != 0) {
            StdTypeList stdTypeList = new StdTypeList(size2);
            for (int i5 = 0; i5 < size2; i5++) {
                stdTypeList.set(i5, (Type) arrayList.get(i5));
            }
            stdTypeList.setImmutable();
            annotations.add(AnnotationUtils.makeMemberClasses(stdTypeList));
        }
        annotations.setImmutable();
        return annotations;
    }
}
