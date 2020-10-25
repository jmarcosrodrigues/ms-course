package br.com.jm.hrpayroll.service;

import br.com.jm.hrpayroll.entities.Payment;
import br.com.jm.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVeriables = new HashMap<>();
        uriVeriables.put("id", "" + workerId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVeriables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
