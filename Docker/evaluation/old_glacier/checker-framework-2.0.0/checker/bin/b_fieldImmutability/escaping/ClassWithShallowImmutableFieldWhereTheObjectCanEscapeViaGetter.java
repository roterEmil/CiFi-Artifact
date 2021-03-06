/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.escaping;

import org.opalj.br.fpcf.analyses.L0ClassImmutabilityAnalysis;
import org.opalj.br.fpcf.analyses.L0TypeImmutabilityAnalysis;
import org.opalj.fpcf.properties.immutability.classes.ShallowImmutableClass;
import org.opalj.fpcf.properties.immutability.fields.ShallowImmutableField;
import org.opalj.fpcf.properties.immutability.references.ImmutableFieldReference;
import org.opalj.fpcf.properties.immutability.types.MutableType;
import org.opalj.tac.fpcf.analyses.immutability.L1ClassImmutabilityAnalysis;
import org.opalj.tac.fpcf.analyses.immutability.L1TypeImmutabilityAnalysis;
import org.opalj.tac.fpcf.analyses.immutability.fieldreference.L0FieldReferenceImmutabilityAnalysis;

@MutableType(value = "class is extensible")
@ShallowImmutableClass(value = "class has only the shallow immutable field tmc")
public class ClassWithShallowImmutableFieldWhereTheObjectCanEscapeViaGetter {

    @ShallowImmutableField("Because of Immutable Reference and Mutable Field Type")
    @ImmutableFieldReference(value = "effective immutable field", analyses = L0FieldReferenceImmutabilityAnalysis.class)
    private ClassWithPublicFields tmc = new ClassWithPublicFields();

    public ClassWithPublicFields getTmc() {
        return tmc;
    }
}
