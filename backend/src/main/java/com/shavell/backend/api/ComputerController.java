package com.shavell.backend.api;

import com.shavell.backend.entity.ComputerEntity;
import com.shavell.backend.repository.ComputerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "sendHardwareInfo")
@Log4j2
public class ComputerController {

    private ComputerRepository computerRepo;
    private EntityManagerFactory em;

    @Autowired
    public ComputerController(ComputerRepository computerRepo, EntityManagerFactory em) {
        this.computerRepo = computerRepo;
        this.em = em;
        log.info("ComputerController Created!");
    }

    /**
     * @param computer
     */
    @PostMapping
    public void create(@RequestBody ComputerEntity computer) {
        computerRepo.save(computer);
        log.info(String.format("Computer Saved! %s", computer.getDoorNo()));
    }

    /**
     * @return
     */
    @GetMapping
    public List<ComputerEntity> list() {
        log.info("Get request to all list in repository");
        return computerRepo.findAll();
    }

    /**
     * for pinging usage
     */
    @PatchMapping
    public void ping() {
        log.info("Ping triggered!");
    }
}
