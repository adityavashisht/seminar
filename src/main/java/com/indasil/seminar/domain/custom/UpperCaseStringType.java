package com.indasil.seminar.domain.custom;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

/**
 * Created by vashishta on 10/1/15.
 */
public class UpperCaseStringType extends AbstractSingleColumnStandardBasicType<String>
        implements DiscriminatorType<String>

{
    public static final UpperCaseStringType INSTANCE = new UpperCaseStringType();

    public UpperCaseStringType() {
        super( VarcharTypeDescriptor.INSTANCE, StringTypeDescriptor.INSTANCE );
    }

    public String getName() {
        return "upper_case_string";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    public String objectToSQLString(String value, Dialect dialect) throws Exception {
        return '\'' + value.toUpperCase() + '\'';
    }

    public String stringToObject(String xml) throws Exception {
        return xml;
    }

    public String toString(String value) {
        return value.toUpperCase();
    }
}
