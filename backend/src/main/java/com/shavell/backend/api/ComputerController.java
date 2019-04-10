package com.shavell.backend.api;

import com.shavell.backend.entity.ComputerEntity;
import com.shavell.backend.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "sendHardwareInfo")
public class ComputerController {

    private ComputerRepository computerRepo;
    private EntityManagerFactory em;

    @Autowired
    public ComputerController(ComputerRepository computerRepo, EntityManagerFactory em) {
        this.computerRepo = computerRepo;
        this.em = em;
    }

    /**
     * @param computer
     */
    @PostMapping
    public void create(@RequestBody ComputerEntity computer) {
        computerRepo.save(computer);
    }

    /**
     * @return
     */
    @GetMapping
    public List<ComputerEntity> list() {
        return computerRepo.findAll();
    }

    /**
     * for pinging usage
     */
    @PatchMapping public void ping(){ }
}
