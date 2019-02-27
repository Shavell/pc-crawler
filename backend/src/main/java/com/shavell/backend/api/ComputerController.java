package com.shavell.backend.api;

import com.shavell.backend.model.Computer;
import com.shavell.backend.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "sendHardwareInfo")
public class ComputerController {

    @Autowired private ComputerRepository computerRepo;

    /**
     * @param computer
     */
    @PostMapping public void create(@RequestBody Computer computer) {
        computerRepo.save(computer);
    }

    /**
     * @return
     */
    @GetMapping public List<Computer> list(){
        return computerRepo.findAll();
    }

    /**
     * for pinging usage
     */
    @PatchMapping public void ping(){ }
}
