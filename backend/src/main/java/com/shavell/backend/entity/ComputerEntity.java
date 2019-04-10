package com.shavell.backend.entity;

import com.shavell.pojo.model.Computer;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@AttributeOverrides(value = {
        @AttributeOverride(name = "doorNo", column = @Column(nullable = false)),
        @AttributeOverride(name = "gpus", column = @Column(length = 3000)),
        @AttributeOverride(name = "displays", column = @Column(length = 3000)),
        @AttributeOverride(name = "soundCards", column = @Column(length = 3000)),
        @AttributeOverride(name = "usbDevices", column = @Column(length = 3000)),
        @AttributeOverride(name = "networks", column = @Column(length = 3000)),
        @AttributeOverride(name = "disks", column = @Column(length = 3000)),
})
public class ComputerEntity extends Computer implements Serializable {
    private static final long serialVersionUID = 8890435079654208095L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreationTimestamp
    private Timestamp created;
}