package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;
import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.managers.MembershipRequestManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class MembershipRequestManagerImpl implements MembershipRequestManager {
    @Override
    public List<MembershipRequest> getAllEntities() {
        List<MembershipRequestModel> allEntities = DatabaseManagerFactory.getInternalDatabaseManager().getMembershipRequestModelManager().getAllEntities();
        ImmutableList.Builder<MembershipRequest> builder = ImmutableList.builder();
        for (MembershipRequestModel entity : allEntities) {
            builder.add(MembershipRequestImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public MembershipRequest getEntity(MembershipRequest.ID id) {
        MembershipRequestModel entity = DatabaseManagerFactory.getInternalDatabaseManager().getMembershipRequestModelManager().getEntity(id.getValue());
        return MembershipRequestImpl.create(entity);
    }

    @Override
    public void updateEntity(MembershipRequest entity) {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getMembershipRequestModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(MembershipRequest entity) {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getMembershipRequestModelManager().deleteEntity(model);
    }

    @Override
    public MembershipRequest.ID addEntity(MembershipRequest entity) {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getInternalDatabaseManager().getMembershipRequestModelManager().addEntity(model);
        return new MembershipRequestImpl.IDImpl(id);
    }

    @Override
    public MembershipRequest createEntity() {
        return MembershipRequestImpl.create(null);
    }
}
