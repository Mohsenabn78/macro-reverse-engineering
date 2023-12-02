package com.google.firebase.firestore.util;

import com.google.firebase.firestore.core.CompositeFilter;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.InFilter;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class LogicUtils {
    protected static Filter a(Filter filter) {
        f(filter);
        if (l(filter)) {
            return filter;
        }
        CompositeFilter compositeFilter = (CompositeFilter) filter;
        List<Filter> filters = compositeFilter.getFilters();
        if (filters.size() == 1) {
            return a(filters.get(0));
        }
        if (compositeFilter.isFlat()) {
            return compositeFilter;
        }
        ArrayList<Filter> arrayList = new ArrayList();
        for (Filter filter2 : filters) {
            arrayList.add(a(filter2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Filter filter3 : arrayList) {
            if (filter3 instanceof FieldFilter) {
                arrayList2.add(filter3);
            } else if (filter3 instanceof CompositeFilter) {
                CompositeFilter compositeFilter2 = (CompositeFilter) filter3;
                if (compositeFilter2.getOperator().equals(compositeFilter.getOperator())) {
                    arrayList2.addAll(compositeFilter2.getFilters());
                } else {
                    arrayList2.add(compositeFilter2);
                }
            }
        }
        if (arrayList2.size() == 1) {
            return (Filter) arrayList2.get(0);
        }
        return new CompositeFilter(arrayList2, compositeFilter.getOperator());
    }

    private static Filter b(CompositeFilter compositeFilter, CompositeFilter compositeFilter2) {
        boolean z3;
        CompositeFilter compositeFilter3;
        if (!compositeFilter.getFilters().isEmpty() && !compositeFilter2.getFilters().isEmpty()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Found an empty composite filter", new Object[0]);
        if (compositeFilter.isConjunction() && compositeFilter2.isConjunction()) {
            return compositeFilter.withAddedFilters(compositeFilter2.getFilters());
        }
        if (compositeFilter.isDisjunction()) {
            compositeFilter3 = compositeFilter;
        } else {
            compositeFilter3 = compositeFilter2;
        }
        if (compositeFilter.isDisjunction()) {
            compositeFilter = compositeFilter2;
        }
        ArrayList arrayList = new ArrayList();
        for (Filter filter : compositeFilter3.getFilters()) {
            arrayList.add(e(filter, compositeFilter));
        }
        return new CompositeFilter(arrayList, CompositeFilter.Operator.OR);
    }

    private static Filter c(FieldFilter fieldFilter, CompositeFilter compositeFilter) {
        if (compositeFilter.isConjunction()) {
            return compositeFilter.withAddedFilters(Collections.singletonList(fieldFilter));
        }
        ArrayList arrayList = new ArrayList();
        for (Filter filter : compositeFilter.getFilters()) {
            arrayList.add(e(fieldFilter, filter));
        }
        return new CompositeFilter(arrayList, CompositeFilter.Operator.OR);
    }

    private static Filter d(FieldFilter fieldFilter, FieldFilter fieldFilter2) {
        return new CompositeFilter(Arrays.asList(fieldFilter, fieldFilter2), CompositeFilter.Operator.AND);
    }

    protected static Filter e(Filter filter, Filter filter2) {
        Filter b4;
        f(filter);
        f(filter2);
        boolean z3 = filter instanceof FieldFilter;
        if (z3 && (filter2 instanceof FieldFilter)) {
            b4 = d((FieldFilter) filter, (FieldFilter) filter2);
        } else if (z3 && (filter2 instanceof CompositeFilter)) {
            b4 = c((FieldFilter) filter, (CompositeFilter) filter2);
        } else if ((filter instanceof CompositeFilter) && (filter2 instanceof FieldFilter)) {
            b4 = c((FieldFilter) filter2, (CompositeFilter) filter);
        } else {
            b4 = b((CompositeFilter) filter, (CompositeFilter) filter2);
        }
        return a(b4);
    }

    private static void f(Filter filter) {
        boolean z3;
        if (!(filter instanceof FieldFilter) && !(filter instanceof CompositeFilter)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assert.hardAssert(z3, "Only field filters and composite filters are accepted.", new Object[0]);
    }

    protected static Filter g(Filter filter) {
        boolean z3;
        f(filter);
        if (filter instanceof FieldFilter) {
            return filter;
        }
        CompositeFilter compositeFilter = (CompositeFilter) filter;
        if (compositeFilter.getFilters().size() == 1) {
            return g(filter.getFilters().get(0));
        }
        ArrayList arrayList = new ArrayList();
        for (Filter filter2 : compositeFilter.getFilters()) {
            arrayList.add(g(filter2));
        }
        Filter a4 = a(new CompositeFilter(arrayList, compositeFilter.getOperator()));
        if (j(a4)) {
            return a4;
        }
        Assert.hardAssert(a4 instanceof CompositeFilter, "field filters are already in DNF form.", new Object[0]);
        CompositeFilter compositeFilter2 = (CompositeFilter) a4;
        Assert.hardAssert(compositeFilter2.isConjunction(), "Disjunction of filters all of which are already in DNF form is itself in DNF form.", new Object[0]);
        if (compositeFilter2.getFilters().size() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Single-filter composite filters are already in DNF form.", new Object[0]);
        Filter filter3 = compositeFilter2.getFilters().get(0);
        for (int i4 = 1; i4 < compositeFilter2.getFilters().size(); i4++) {
            filter3 = e(filter3, compositeFilter2.getFilters().get(i4));
        }
        return filter3;
    }

    public static List<Filter> getDnfTerms(CompositeFilter compositeFilter) {
        if (compositeFilter.getFilters().isEmpty()) {
            return Collections.emptyList();
        }
        Filter g4 = g(h(compositeFilter));
        Assert.hardAssert(j(g4), "computeDistributedNormalForm did not result in disjunctive normal form", new Object[0]);
        if (!l(g4) && !k(g4)) {
            return g4.getFilters();
        }
        return Collections.singletonList(g4);
    }

    protected static Filter h(Filter filter) {
        f(filter);
        ArrayList arrayList = new ArrayList();
        if (filter instanceof FieldFilter) {
            if (filter instanceof InFilter) {
                InFilter inFilter = (InFilter) filter;
                for (Value value : inFilter.getValue().getArrayValue().getValuesList()) {
                    arrayList.add(FieldFilter.create(inFilter.getField(), FieldFilter.Operator.EQUAL, value));
                }
                return new CompositeFilter(arrayList, CompositeFilter.Operator.OR);
            }
            return filter;
        }
        CompositeFilter compositeFilter = (CompositeFilter) filter;
        for (Filter filter2 : compositeFilter.getFilters()) {
            arrayList.add(h(filter2));
        }
        return new CompositeFilter(arrayList, compositeFilter.getOperator());
    }

    private static boolean i(Filter filter) {
        if (filter instanceof CompositeFilter) {
            CompositeFilter compositeFilter = (CompositeFilter) filter;
            if (compositeFilter.isDisjunction()) {
                for (Filter filter2 : compositeFilter.getFilters()) {
                    if (!l(filter2) && !k(filter2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean j(Filter filter) {
        if (!l(filter) && !k(filter) && !i(filter)) {
            return false;
        }
        return true;
    }

    private static boolean k(Filter filter) {
        if ((filter instanceof CompositeFilter) && ((CompositeFilter) filter).isFlatConjunction()) {
            return true;
        }
        return false;
    }

    private static boolean l(Filter filter) {
        return filter instanceof FieldFilter;
    }
}
