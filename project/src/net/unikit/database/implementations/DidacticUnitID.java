package net.unikit.database.implementations;

/**
 * An id for a didactic unit.
 * @author Andreas Berks
 * @since 1.2.1
 */
public abstract class DidacticUnitID extends AbstractID<Integer> {
    protected DidacticUnitID(Integer value) {
        super(value);
    }
}
