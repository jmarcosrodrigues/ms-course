package br.com.jm.hrworker.hrworker.resources;

import br.com.jm.hrworker.hrworker.entities.Worker;
import br.com.jm.hrworker.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    private final Environment environment;
    private final WorkerRepository repository;

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    public WorkerResource(WorkerRepository repository, Environment environment){

        this.repository = repository;
        this.environment = environment;
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        logger.info("Config = " + testConfig);

        return  ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return  ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        logger.info("PORT = " + environment.getProperty("local.serve.port"));

        Worker obj = repository.findById(id).get();
        return  ResponseEntity.ok(obj);


    }
}
