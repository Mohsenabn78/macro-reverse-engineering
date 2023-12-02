package com.android.multidex;

import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.HasAttribute;
import com.android.dx.cf.iface.MethodList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public class MainDexListBuilder {
    private static final String CLASS_EXTENSION = ".class";
    private static final String DISABLE_ANNOTATION_RESOLUTION_WORKAROUND = "--disable-annotation-resolution-workaround";
    private static final String EOL;
    private static final int STATUS_ERROR = 1;
    private static String USAGE_MESSAGE;
    private Set<String> filesToKeep = new HashSet();

    static {
        String property = System.getProperty("line.separator");
        EOL = property;
        USAGE_MESSAGE = "Usage:" + property + property + "Short version: Don't use this." + property + property + "Slightly longer version: This tool is used by mainDexClasses script to build" + property + "the main dex list." + property;
    }

    public MainDexListBuilder(boolean z3, String str, String str2) throws IOException {
        Path path;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    path = new Path(str2);
                } catch (Throwable th) {
                    th = th;
                    path = null;
                }
            } catch (Throwable th2) {
                th = th2;
                path = null;
            }
            try {
                ClassReferenceListBuilder classReferenceListBuilder = new ClassReferenceListBuilder(path);
                classReferenceListBuilder.addRoots(zipFile);
                Iterator<String> it = classReferenceListBuilder.getClassNames().iterator();
                while (it.hasNext()) {
                    this.filesToKeep.add(it.next() + ".class");
                }
                if (z3) {
                    keepAnnotated(path);
                }
                try {
                    zipFile.close();
                } catch (IOException unused) {
                }
                for (ClassPathElement classPathElement : path.elements) {
                    try {
                        classPathElement.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile2 = zipFile;
                try {
                    zipFile2.close();
                } catch (IOException unused3) {
                }
                if (path != null) {
                    for (ClassPathElement classPathElement2 : path.elements) {
                        try {
                            classPathElement2.close();
                        } catch (IOException unused4) {
                        }
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            throw new IOException("\"" + str + "\" can not be read as a zip archive. (" + e4.getMessage() + ")", e4);
        }
    }

    private boolean hasRuntimeVisibleAnnotation(HasAttribute hasAttribute) {
        Attribute findFirst = hasAttribute.getAttributes().findFirst(AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME);
        if (findFirst != null && ((AttRuntimeVisibleAnnotations) findFirst).getAnnotations().size() > 0) {
            return true;
        }
        return false;
    }

    private void keepAnnotated(Path path) throws FileNotFoundException {
        for (ClassPathElement classPathElement : path.getElements()) {
            for (String str : classPathElement.list()) {
                if (str.endsWith(".class")) {
                    DirectClassFile directClassFile = path.getClass(str);
                    if (hasRuntimeVisibleAnnotation(directClassFile)) {
                        this.filesToKeep.add(str);
                    } else {
                        MethodList methods = directClassFile.getMethods();
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            if (i5 < methods.size()) {
                                if (hasRuntimeVisibleAnnotation(methods.get(i5))) {
                                    this.filesToKeep.add(str);
                                    break;
                                }
                                i5++;
                            } else {
                                FieldList fields = directClassFile.getFields();
                                while (true) {
                                    if (i4 >= fields.size()) {
                                        break;
                                    } else if (hasRuntimeVisibleAnnotation(fields.get(i4))) {
                                        this.filesToKeep.add(str);
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] strArr) {
        int i4 = 0;
        boolean z3 = true;
        while (i4 < strArr.length - 2) {
            if (strArr[i4].equals(DISABLE_ANNOTATION_RESOLUTION_WORKAROUND)) {
                z3 = false;
            } else {
                PrintStream printStream = System.err;
                printStream.println("Invalid option " + strArr[i4]);
                printUsage();
                System.exit(1);
            }
            i4++;
        }
        if (strArr.length - i4 != 2) {
            printUsage();
            System.exit(1);
        }
        try {
            printList(new MainDexListBuilder(z3, strArr[i4], strArr[i4 + 1]).getMainDexList());
        } catch (IOException e4) {
            PrintStream printStream2 = System.err;
            printStream2.println("A fatal error occured: " + e4.getMessage());
            System.exit(1);
        }
    }

    private static void printList(Set<String> set) {
        for (String str : set) {
            System.out.println(str);
        }
    }

    private static void printUsage() {
        System.err.print(USAGE_MESSAGE);
    }

    public Set<String> getMainDexList() {
        return this.filesToKeep;
    }
}
