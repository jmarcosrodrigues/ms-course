package br.com.jm.hrpayroll.service;

import br.com.jm.hrpayroll.entities.Payment;
import br.com.jm.hrpayroll.entities.Worker;
import br.com.jm.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private WorkerFeignClient workerFeignClient;


    @Autowired
    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
