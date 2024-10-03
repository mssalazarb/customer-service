package com.msa.service.customer.infrastructure.aop;

import com.msa.service.customer.domain.models.Customer;
import com.msa.service.customer.domain.models.CustomerAudit;
import com.msa.service.customer.domain.ports.in.CustomerAuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Log4j2
public class CustomerAuditAspect {
    private final CustomerAuditService customerAuditService;

    @Pointcut("execution(* com.msa.service.customer.domain.ports.out.CustomerRepository.save(..))")
    public void saveCustomer(){}

    @Before("saveCustomer() && args(customer,action)")
    public  void logBeforeSaveCustomer(Customer customer,String action){
        customerAuditService.saveCustomerAudit(customer, action);
    }

    @AfterReturning(pointcut = "execution(* com.msa.service.customer.domain.ports.out.CustomerRepository.save(..))", returning = "customerAudit")
    public  void logAfterSaveCustomer(CustomerAudit customerAudit){
        log.info("usuario {} realizo {}", customerAudit.getUserName(), customerAudit.getAction());
    }
}
