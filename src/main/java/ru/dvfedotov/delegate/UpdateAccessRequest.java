package ru.dvfedotov.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.dvfedotov.config.ProcessVariableConstants;
import ru.dvfedotov.service.AccessRequestService;

@Component
public class UpdateAccessRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    public UpdateAccessRequest(AccessRequestService accessRequestService) {
        this.accessRequestService = accessRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariableConstants.ENTITY_ID);
        String approver = (String) delegateExecution.getVariable(ProcessVariableConstants.APPROVER);
        Boolean isApproved = (Boolean) delegateExecution.getVariable(ProcessVariableConstants.IS_APPROVED);

        accessRequestService.update(entityId, approver, isApproved);
    }
}
