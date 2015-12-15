package net.unikit.database.test_utils;

/**
 * Created by Andreas on 15.12.2015.
 */
public interface Range<AttributeType extends Comparable<AttributeType>> {
    AttributeType getFrom();
    AttributeType getTo();

    boolean includes(AttributeType value);
}
