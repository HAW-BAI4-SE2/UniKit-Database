package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.entities.FieldOfStudyModel;
import net.unikit.database.interfaces.entities.FieldOfStudy;

/**
 * Created by Andreas on 26.11.2015.
 */
final class FieldOfStudyImpl implements FieldOfStudy {
    static class IDImpl implements FieldOfStudy.ID {
        private Integer value;

        IDImpl(Integer value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    private FieldOfStudyModel model;

    private FieldOfStudyImpl(FieldOfStudyModel model) {
        this.model = model;
    }

    public static FieldOfStudy create(FieldOfStudyModel model) {
        return new FieldOfStudyImpl(model);
    }

    @Override
    public ID getId() {
        return new IDImpl(model.getId());
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getAbbreviation() {
        return null;
    }

    @Override
    public void setAbbreviation(String abbreviation) {

    }
}
