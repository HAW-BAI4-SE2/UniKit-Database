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

    FieldOfStudyModel model;

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
        return model.getName();
    }

    @Override
    public void setName(String s) {
        model.setName(s);
    }

    @Override
    public String getAbbreviation() {
        return model.getAbbreviation();
    }

    @Override
    public void setAbbreviation(String s) {
        model.setAbbreviation(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldOfStudyImpl)) return false;

        FieldOfStudyImpl that = (FieldOfStudyImpl) o;

        return !(model != null ? !model.equals(that.model) : that.model != null);

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
