package ru.dvfedotov.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.dvfedotov.config.ProcessVariableConstants;
import ru.dvfedotov.service.AccessRequestService;

@Component
public class CreateAccessRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    public CreateAccessRequest(AccessRequestService accessRequestService) {
        this.accessRequestService = accessRequestService;
    }


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable(ProcessVariableConstants.USERNAME);
        String comment = (String) delegateExecution.getVariable(ProcessVariableConstants.COMMENT);
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariableConstants.ENTITY_ID);

        Long id = accessRequestService.create(entityId, username, comment);

        delegateExecution.setVariable(ProcessVariableConstants.ID, id);
    }
}
